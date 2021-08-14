package org.comroid.math.model;

import org.comroid.api.Named;

public interface Point extends XYZ, MathOP<Vector, Point>, Named {
    @Override
    default float getZ() {
        return 0;
    }

    @Override
    default String getAlternateName() {
        return String.format("%s<%f;%f;%f>", getClass().getSimpleName(), getX(), getY(), getZ());
    }
}
