package org.comroid.math.model;

import org.comroid.api.Named;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

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

    default float distance(Point to) {
        switch (getDimension()) {
            case Dim2:
                return (float) sqrt(pow(to.getX() - getX(), 2) + pow(to.getY() - getY(), 2));
            case Dim3:
                return (float) sqrt(pow(to.getX() - getX(), 2) + pow(to.getY() - getY(), 2) + pow(to.getZ() - getZ(), 2));
        }
        throw new IllegalStateException("Unknown dimension: " + getDimension());
    }
}
