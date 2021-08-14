package org.comroid.math.model;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public interface XYZ extends DimensionalAnchor {
    float getX();

    float getY();

    float getZ();

    default float distance(XYZ to) {
        switch (getDimension()) {
            case Dim2:
                return (float) sqrt(pow(to.getX() - getX(), 2) + pow(to.getY() - getY(), 2));
            case Dim3:
                return (float) sqrt(pow(to.getX() - getX(), 2) + pow(to.getY() - getY(), 2) + pow(to.getZ() - getZ(), 2));
        }
        throw new IllegalStateException("Unknown dimension: " + getDimension());
    }
}
