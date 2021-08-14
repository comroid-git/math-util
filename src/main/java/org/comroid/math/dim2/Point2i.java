package org.comroid.math.dim2;

import org.comroid.math.Dimension;
import org.comroid.math.model.Point;
import org.comroid.math.model.Vector;
import org.comroid.mutatio.model.Ref;
import org.comroid.mutatio.ref.Reference;

public class Point2i implements Point {
    public final Ref<Integer> x = Reference.create();
    public final Ref<Integer> y = Reference.create();

    @Override
    public float getX() {
        return x.assertion();
    }

    @Override
    public float getY() {
        return y.assertion();
    }

    @Override
    public Dimension getDimension() {
        return Dimension.Dim2;
    }

    public Point2i(float x, float y) {
        this((int) x, (int) y);
    }

    public Point2i(int x, int y) {
        this.x.set(x);
        this.y.set(y);
    }

    @Override
    public Point2i plus(Vector vector) {
        return new Point2i(getX() + vector.getX(), getY() + vector.getY());
    }

    @Override
    public Point2i minus(Vector vector) {
        return new Point2i(getX() - vector.getX(), getY() - vector.getY());
    }

    @Override
    public Point2i multiply(Vector vector) {
        return new Point2i(getX() * vector.getX(), getY() - vector.getY());
    }

    @Override
    public Point2i divide(Vector vector) {
        return new Point2i(getX() / vector.getX(), getY() / vector.getY());
    }
}
