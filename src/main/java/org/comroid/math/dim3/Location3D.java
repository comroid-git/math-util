package org.comroid.math.dim3;

import org.comroid.math.MathUtil;
import org.comroid.math.model.LocationScope;

public interface Location3D {
    double getX();

    double getY();

    double getZ();

    LocationScope getLocationScope();

    default double distanceTo(Location3D other) {
        if (!getLocationScope().equals(other.getLocationScope()))
            throw new IllegalArgumentException(String.format("Cannot convert scope %s to %s", other.getLocationScope(), getLocationScope()));
        return MathUtil.distance3d(getX(), getY(), getZ(), other.getX(), other.getY(), other.getZ());
    }
}
