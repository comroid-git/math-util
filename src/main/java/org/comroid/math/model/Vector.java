package org.comroid.math.model;

import org.comroid.api.Named;

import java.util.function.UnaryOperator;

public interface Vector extends XYZ, MathOP.Unary<Vector>, Named, UnaryOperator<Point> {
    default float getZ() {
        return 0;
    }

    @Override
    default Point apply(Point point) {
        return point.plus(this);
    }
}
