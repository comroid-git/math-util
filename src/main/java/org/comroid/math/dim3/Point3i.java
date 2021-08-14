package org.comroid.math.dim3;

import org.comroid.math.Dimension;
import org.comroid.math.dim2.Point2i;
import org.comroid.math.model.Point;
import org.comroid.math.model.Vector;
import org.comroid.mutatio.model.Ref;
import org.comroid.mutatio.ref.Reference;

public class Point3i extends Point2i implements Point {
    public final Ref<Integer> z = Reference.create();

    @Override
    public float getZ() {
        return z.assertion();
    }

    @Override
    public Dimension getDimension() {
        return Dimension.Dim3;
    }

    public Point3i(float x, float y, float z) {
        this((int) x, (int) y, (int) z);
    }

    public Point3i(int x, int y, int z) {
        super(x, y);
        this.z.set(z);
    }

    @Override
    public Point3i plus(Vector vector) {
        return new Point3i(getX() + vector.getX(), getY() + vector.getY(), getZ() + vector.getZ());
    }

    @Override
    public Point3i minus(Vector vector) {
        return new Point3i(getX() - vector.getX(), getY() - vector.getY(), getZ() - vector.getZ());
    }

    @Override
    public Point3i multiply(Vector vector) {
        return new Point3i(getX() * vector.getX(), getY() - vector.getY(), getZ() * vector.getZ());
    }

    @Override
    public Point3i divide(Vector vector) {
        return new Point3i(getX() / vector.getX(), getY() / vector.getY(), getZ() / vector.getZ());
    }
}
