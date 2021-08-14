package org.comroid.math.dim2;

import org.comroid.math.Dimension;
import org.comroid.math.model.Vector;
import org.comroid.mutatio.model.Ref;
import org.comroid.mutatio.ref.Reference;

public class Vector2f implements Vector {
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

    @Override
    public Dimension getDimension() {
        return Dimension.Dim2;
    }

    public Vector2f(float x, float y) {
        this.x.set(x);
        this.y.set(y);
    }

    @Override
    public Vector2f plus(Vector plus) {
        return new Vector2f(getX() + plus.getX(), getY() + plus.getY());
    }

    @Override
    public Vector2f minus(Vector minus) {
        return new Vector2f(getX() - minus.getX(), getY() - minus.getY());
    }

    @Override
    public Vector2f multiply(Vector multiply) {
        return new Vector2f(getX() * multiply.getX(), getY() * multiply.getY());
    }

    @Override
    public Vector2f divide(Vector dividend) {
        return new Vector2f(getX() / dividend.getX(), getY() / dividend.getY());
    }
}
