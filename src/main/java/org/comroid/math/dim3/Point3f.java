package org.comroid.math.dim3;

import org.comroid.math.dim2.Point2f;
import org.comroid.math.Dimension;
import org.comroid.math.model.Point;
import org.comroid.math.model.Vector;
import org.comroid.mutatio.model.Ref;
import org.comroid.mutatio.ref.Reference;

public class Point3f extends Point2f implements Point {
    public final Ref<Float> z = Reference.create();

    @Override
    public float getZ() {
        return z.assertion();
    }

    @Override
    public Dimension getDimension() {
        return Dimension.Dim3;
    }

    public Point3f(float x, float y, float z) {
        super(x, y);
        this.z.set(z);
    }

    @Override
    public Point3f plus(Vector vector) {
        return new Point3f(getX() + vector.getX(), getY() + vector.getY(), getZ() + vector.getZ());
    }

    @Override
    public Point3f minus(Vector vector) {
        return new Point3f(getX() - vector.getX(), getY() - vector.getY(), getZ() - vector.getZ());
    }

    @Override
    public Point3f multiply(Vector vector) {
        return new Point3f(getX() * vector.getX(), getY() - vector.getY(), getZ() * vector.getZ());
    }

    @Override
    public Point3f divide(Vector vector) {
        return new Point3f(getX() / vector.getX(), getY() / vector.getY(), getZ() / vector.getZ());
    }
}
