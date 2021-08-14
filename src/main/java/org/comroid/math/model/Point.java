package org.comroid.math.model;

import org.comroid.api.Named;

public interface Point extends MathOP<Vector, Point>, Named, DimensionalAnchor {
    float getX();

    float getY();

    default float getZ() {
        return 0;
    }

    @Override
    default String getAlternateName() {
        return String.format("%s<%f;%f;%f>", getClass().getSimpleName(), getX(), getY(), getZ());
    }
}
