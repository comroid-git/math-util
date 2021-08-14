package org.comroid.math.model;

public interface MathOP<I, O> {
    O plus(I plus);

    O minus(I minus);

    O multiply(I multiply);

    O divide(I dividend);

    interface Unary<T> extends MathOP<T, T> {
    }
}
