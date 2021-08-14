package org.comroid.math.model;

import org.comroid.api.Named;

import java.util.function.UnaryOperator;

public interface Vector extends MathOP.Unary<Vector>, UnaryOperator<Point>, Named, DimensionalAnchor {
    float getX();

    float getY();

    default float getZ() {
        return 0;
    }

    @Override
    default String getAlternateName() {
        return String.format("%s<%f;%f;%f>", getClass().getSimpleName(), getX(), getY(), getZ());
    }

    @Override
    default Point apply(Point point) {
        return point.plus(this);
    }
}
