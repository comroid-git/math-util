package org.comroid.math.dim3;

import org.comroid.math.dim2.Vector2i;
import org.comroid.math.model.Dimension;
import org.comroid.math.model.Vector;
import org.comroid.mutatio.model.Ref;
import org.comroid.mutatio.ref.Reference;

public class Vector3i extends Vector2i implements Vector {
    public final Ref<Integer> z = Reference.create();

    @Override
    public float getZ() {
        return z.assertion();
    }

    @Override
    public Dimension getDimension() {
        return Dimension.Dim3;
    }

    public Vector3i(float x, float y, float z) {
        this((int) x, (int) y, (int) z);
    }

    public Vector3i(int x, int y, int z) {
        super(x, y);
        this.z.set(z);
    }

    @Override
    public Vector3i plus(Vector plus) {
        return new Vector3i(getX() + plus.getX(), getY() + plus.getY(), getZ() + plus.getZ());
    }

    @Override
    public Vector3i minus(Vector minus) {
        return new Vector3i(getX() - minus.getX(), getY() - minus.getY(), getZ() - minus.getZ());
    }

    @Override
    public Vector3i multiply(Vector multiply) {
        return new Vector3i(getX() * multiply.getX(), getY() * multiply.getY(), getZ() * multiply.getZ());
    }

    @Override
    public Vector3i divide(Vector dividend) {
        return new Vector3i(getX() / dividend.getX(), getY() / dividend.getY(), getZ() / dividend.getZ());
    }
}
