package sample;

import java.util.*;

public class Bone {
    final private int a, b;

    public Bone(int first, int second) {

        assert 0 <= first && first <= 6 && 0 <= second && second <= 6;

        if (allBone == null){
            allBone = new HashMap<>();
        }

        this.a = first;
        this.b = second;

        if (!hasBone()){
            countBone++;
            this.id = countBone;
            allBone.put(id, this);
        }
    }

    private int id;

    public int first() {
        return a;
    }

    public int second() {
        return b;
    }
    private static Map<Integer, Bone> allBone = new HashMap<>();

    private static int countBone = 0;

    private boolean hasBone(){
        for (Bone bone : allBone.values()){
            if (bone.equals(this) && bone.hashCode() == this.hashCode()){
                return true;
            }
        }
        return false;
    }

    public static List<Bone> getAllBone() {
        return new ArrayList<>(allBone.values());
    }

    public static int getHowManyBone(){
        return allBone.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Bone) {
            return this.a == ((Bone) o).a && this.b == ((Bone) o).b || this.a == ((Bone) o).b && this.b == ((Bone) o).a;
        } else
            return false;
    }

    @Override
    public int hashCode() {

        return Objects.hash(first(), second());
    }
}