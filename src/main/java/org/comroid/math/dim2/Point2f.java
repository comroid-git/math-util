package org.comroid.math.dim2;

import org.comroid.math.model.Point;
import org.comroid.math.model.Vector;
import org.comroid.mutatio.model.Ref;
import org.comroid.mutatio.ref.Reference;

public class Point2f implements Point {
    public final Ref<Float> x = Reference.create();
    public final Ref<Float> y = Reference.create();

    @Override
    public float getX() {
        return x.assertion();
    }

    @Override
    public float getY() {
        return y.assertion();
    }

    public Point2f(float x, float y) {
        this.x.set(x);
        this.y.set(y);
    }

    @Override
    public Point2f plus(Vector vector) {
        return new Point2f(getX() + vector.getX(), getY() + vector.getY());
    }

    @Override
    public Point2f minus(Vector vector) {
        return new Point2f(getX() - vector.getX(), getY() - vector.getY());
    }

    @Override
    public Point2f multiply(Vector vector) {
        return new Point2f(getX() * vector.getX(), getY() - vector.getY());
    }

    @Override
    public Point2f divide(Vector vector) {
        return new Point2f(getX() / vector.getX(), getY() / vector.getY());
    }
}
