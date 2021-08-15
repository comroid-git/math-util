package org.comroid.math.model;

public interface Point extends XYZ, MathOP<Vector, Point> {
    @Override
    default float getZ() {
        return 0;
    }
}
