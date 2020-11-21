package sample;

import javafx.util.Pair;

import java.util.ArrayList;

public class Solver {
    private int p;
    private int maxlen;
    private int[] bestCep = new int[56];
    //    private int[] cep = new int[56];
    private int first;
    private int second;

    private ArrayList<Bone> bones;
    private ArrayList<Bone> chain;
    private ArrayList<Integer> bestChain;
    private ArrayList<Integer> trying;


    public Solver(ArrayList<Bone> bones) {
        this.bones = bones;
    }

    //    public sCep () {
//        if (p - 1 > maxlen) {
//
//        }
//    }
    public boolean exist(int k) {
        int i = 0;
        while (i < 7 && !bones.contains(new Bone(k, i))) {
            i++;
        }
        return i < 7;
    }

    private void combinations(ArrayList<Bone> current, ArrayList<Bone> unused) {
        ArrayList<Bone> variants = new ArrayList<>();

        for (Bone bone : unused) {
            int last = current.get(current.size() - 1).second();
            if (bone.has(last)) {
                if (bone.second() == last)
                    bone.reverse();
                current.add(bone);
                unused.remove(bone);
//                combinations(current, );
            }
        }
    }

    public void makeChain() {
        chain = new ArrayList<>(bones.size());
        trying = new ArrayList<>(bones.size());
        bestChain = new ArrayList<>(bones.size());
        for (int i = 0; i <= 6; i++) makeCep(i);

        System.out.println("chain: " + bestChain.toString());
//        for (int i = 0; i < bones.size(); i++) {
//            chain.add(bones.get(i));
//            combinations();
//        }
    }

    public void makeCep(int f) {
        int s;
        for (s = 0; s <= 6; s++) {
            Bone current = new Bone(f, s);
            if (bones.contains(current)) {
                bones.remove(current);
                    trying.add(trying.size(), f);
                    trying.add(trying.size(), s);

                if (exist(s)) {
                    makeCep(s);
                } else if (trying.size() > bestChain.size()) {
                    bones.add(current);
                    bestChain = new ArrayList<>(trying);
                }
                if (!bones.contains(current))
                    bones.add(current);

                trying.remove(trying.size() - 1);
                trying.remove(trying.size() - 1);
            }
        }

    }
}
