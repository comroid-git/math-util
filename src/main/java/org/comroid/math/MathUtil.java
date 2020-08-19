package org.comroid.math;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public final class MathUtil {
    private MathUtil() {
        throw new UnsupportedOperationException();
    }

    public static double distance3d(
            double x1, double y1, double z1,
            double x2, double y2, double z2
    ) {
        return sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2) + pow(z2 - z1, 2));
    }
}
