package org.comroid.math.dim2;

import org.comroid.math.model.Vector;
import org.comroid.mutatio.model.Ref;
import org.comroid.mutatio.ref.Reference;

public class Vector2i implements Vector {
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

    public Vector2i(float x, float y) {
        this((int) x, (int) y);
    }

    public Vector2i(int x, int y) {
        this.x.set(x);
        this.y.set(y);
    }

    @Override
    public Vector2i plus(Vector plus) {
        return new Vector2i(getX() + plus.getX(), getY() + plus.getY());
    }

    @Override
    public Vector2i minus(Vector minus) {
        return new Vector2i(getX() - minus.getX(), getY() - minus.getY());
    }

    @Override
    public Vector2i multiply(Vector multiply) {
        return new Vector2i(getX() * multiply.getX(), getY() * multiply.getY());
    }

    @Override
    public Vector2i divide(Vector dividend) {
        return new Vector2i(getX() / dividend.getX(), getY() / dividend.getY());
    }
}
