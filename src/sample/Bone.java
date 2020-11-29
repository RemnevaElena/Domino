package sample;

public class Bone {
    final private int a, b;

    public Bone(int first, int second) {
        assert 0 <= first && first <= 6 && 0 <= second && second <= 6;

        this.a = first;
        this.b = second;
    }

    public int first() {
        return a;
    }

    public int second() {
        return b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Bone) {
            return this.a == ((Bone) o).a && this.b == ((Bone) o).b || this.a == ((Bone) o).b && this.b == ((Bone) o).a;
        } else
            return false;
    }
}