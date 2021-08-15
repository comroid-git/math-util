package org.comroid.math.trie;

import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public final class TrieMap<K, V> implements Map<K, V>, Function<K, String> {
    private final TrieNode baseNode = new TrieNode((char) 0);
    private final Function<K, String> stringFunction;

    public TrieMap(Function<K, String> stringFunction) {
        this.stringFunction = stringFunction;
    }

    public static <V> TrieMap<String, V> ofString() {
        return new TrieMap<>(Function.identity());
    }

    @Override
    public String apply(K key) {
        return stringFunction.apply(key);
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
    }
}
