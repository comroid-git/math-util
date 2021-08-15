package org.comroid.math.trie;

import org.jetbrains.annotations.ApiStatus.Experimental;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Experimental
public final class TrieMap<K, V> implements Map<K, V>, Function<Object, String> {
    private final TrieNode baseNode = new TrieNode((char) 0);
    private final Function<K, String> stringFunction;

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public TrieMap(Function<K, String> stringFunction) {
        this.stringFunction = stringFunction;
    }

    public static <V> TrieMap<String, V> ofString() {
        return new TrieMap<>(Function.identity());
    }

    @Override
    public String apply(Object key) {
        //noinspection unchecked
        return stringFunction.apply((K) key);
    }

    @Override
    public int size() {
        return (int) baseNode.downstream()
                .filter(it -> it.value != null)
                .count();
    }

    @Override
    public boolean containsKey(Object key) {
        return baseNode.get(apply(key), 0) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        return baseNode.downstream()
                .map(it -> it.value)
                .anyMatch(value::equals);
    }

    @Override
    public V get(Object key) {
        return baseNode.get(apply(key), 0);
    }

    @Nullable
    @Override
    public V put(K key, V value) {
        return baseNode.put(apply(key), 0, value);
    }

    @Override
    public V remove(Object key) {
        return baseNode.put(apply(key), 0, null);
    }

    @Override
    public void putAll(@NotNull Map<? extends K, ? extends V> m) {
        m.forEach(this::put);
    }

    @Override
    public void clear() {
        baseNode.clear();
    }

    @NotNull
    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException(); // todo
    }

    @NotNull
    @Override
    public Collection<V> values() {
        return baseNode.downstream()
                .map(it -> it.value)
                .collect(Collectors.toList());
    }

    @NotNull
    @Override
    public Set<Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException(); // todo
    }

    private final class TrieNode extends ConcurrentHashMap<Character, TrieNode> {
        private final char c;
        private @Nullable V value;

        private boolean isBase() {
            return c == 0;
        }

        private TrieNode(char c) {
            this.c = c;
        }

        private @Nullable V get(String str, int index) {
            if (index >= str.length())
                return this.value;
            else node(str.charAt(index));
            return put(str, index + 1, value);
        }

        private @Nullable V put(String str, int index, V value) {
            if (index >= str.length()) {
                V prev = this.value;
                this.value = value;
                return prev;
            } else node(str.charAt(index));
            return put(str, index + 1, value);
        }

        private TrieNode node(char c) {
            return computeIfAbsent(c, TrieNode::new);
        }

        private Stream<TrieNode> downstream() {
            return Stream.concat(Stream.of(this), values().stream());
        }

        @Override
        public void clear() {
            values().forEach(TrieNode::clear);
            super.clear();
        }
    }
}
