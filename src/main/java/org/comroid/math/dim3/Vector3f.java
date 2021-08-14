package org.comroid.math.dim3;

import org.comroid.math.Dimension;
import org.comroid.math.dim2.Vector2f;
import org.comroid.math.model.Vector;
import org.comroid.mutatio.model.Ref;
import org.comroid.mutatio.ref.Reference;

public class Vector3f extends Vector2f implements Vector {
    public final Ref<Float> z = Reference.create();

    @Override
    public float getZ() {
        return z.assertion();
    }

    @Override
    public Dimension getDimension() {
        return Dimension.Dim3;
    }

    public Vector3f(float x, float y, float z) {
        super(x, y);
        this.z.set(z);
    }

    @Override
    public Vector3f plus(Vector plus) {
        return new Vector3f(getX() + plus.getX(), getY() + plus.getY(), getZ() + plus.getZ());
    }

    @Override
    public Vector3f minus(Vector minus) {
        return new Vector3f(getX() - minus.getX(), getY() - minus.getY(), getZ() - minus.getZ());
    }

    @Override
    public Vector3f multiply(Vector multiply) {
        return new Vector3f(getX() * multiply.getX(), getY() * multiply.getY(), getZ() * multiply.getZ());
    }

    @Override
    public Vector3f divide(Vector dividend) {
        return new Vector3f(getX() / dividend.getX(), getY() / dividend.getY(), getZ() / dividend.getZ());
    }
}
