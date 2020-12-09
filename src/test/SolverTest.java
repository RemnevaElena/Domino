package test;

import org.junit.Assert;
import org.junit.Test;
import sample.Bone;
import sample.Solver;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SolverTest {

    @Test
    public void makeChain() {
        Bone bone = new Bone(1, 2);
        Bone bone1 = new Bone(1, 3);
        Bone bone2 = new Bone(1, 5);
        Bone bone3 = new Bone(2, 4);
        Bone bone4 = new Bone(2, 5);
        Bone bone5 = new Bone(2, 6);
        Bone bone6 = new Bone(3, 3);
        Bone bone7 = new Bone(4, 5);
        Bone bone8 = new Bone(4, 6);
        Bone bone9 = new Bone(5, 5);

        ArrayList<Bone> bones = new ArrayList<Bone>();
        ArrayList<Bone> bestChain;

        bones.add(bone);
        bones.add(bone1);
        bones.add(bone2);
        bones.add(bone3);
        bones.add(bone4);
        bones.add(bone5);
        bones.add(bone6);
        bones.add(bone7);
        bones.add(bone8);
        bones.add(bone9);

        Solver solver = new Solver(bones);
        solver.makeChain();
        ArrayList<Bone> expected = solver.getBestChain();

        ArrayList<Bone> actual = new ArrayList<Bone>();
        actual.add(bone);
        actual.add(bone3);
        actual.add(bone8);
        actual.add(bone5);
        actual.add(bone4);
        actual.add(bone9);
        actual.add(bone2);
        actual.add(bone1);
        actual.add(bone6);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getBestChain() {
        Bone bone = new Bone(0, 0);
        Bone bone1 = new Bone(0, 1);
        Bone bone2 = new Bone(4, 5);
        Bone bone3 = new Bone(1, 3);

        ArrayList<Bone> bones = new ArrayList<Bone>();
        ArrayList<Bone> bestChain;

        bones.add(bone);
        bones.add(bone1);
        bones.add(bone2);
        bones.add(bone3);

        Solver solver = new Solver(bones);
        solver.makeChain();
        ArrayList<Bone> expected = solver.getBestChain();

        ArrayList<Bone> actual = new ArrayList<Bone>();
        actual.add(bone);
        actual.add(bone1);
        actual.add(bone3);

        Assert.assertEquals(expected, actual);
    }
}