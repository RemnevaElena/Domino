package sample;

import java.util.ArrayList;

public class Solver {
    final private ArrayList<Bone> bones;
    private ArrayList<Bone> bestChain;

    public Solver(ArrayList<Bone> bones) {
        this.bones = bones;
    }

    public boolean exist(int k) {
        int i = 0;
        while (i < 7 && !bones.contains(new Bone(k, i))) {
            i++;
        }
        return i < 7;
    }


    public void makeChain() {
        ArrayList<Integer> intChain = new ArrayList<>(bones.size());
        for (int i = 0; i <= 6; i++) makeCep(i, intChain, new ArrayList<>(bones.size()));

        bestChain = new ArrayList<>(intChain.size() / 2);
        for (int i = 0; i < intChain.size(); i += 2)
            bestChain.add(new Bone(intChain.get(i), intChain.get(i + 1)));
    }

    public void makeCep(int f, ArrayList<Integer> chain, ArrayList<Integer> trying) {
        int s;
        for (s = 0; s <= 6; s++) {
            Bone current = new Bone(f, s);
            if (bones.contains(current)) {
                bones.remove(current);
                trying.add(trying.size(), f);
                trying.add(trying.size(), s);

                if (exist(s)) {
                    makeCep(s, chain, trying);
                } else if (trying.size() > chain.size()) {
                    bones.add(current);
                    chain.clear();
                    chain.addAll(trying);
                }
                if (!bones.contains(current))
                    bones.add(current);

                trying.remove(trying.size() - 1);
                trying.remove(trying.size() - 1);
            }
        }
    }

    public ArrayList<Bone> getBestChain() {
        return bestChain;
    }
}
