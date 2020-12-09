package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sample.Bone;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BoneTest {
    private Bone bone = new Bone(0, 0);
    private Bone bone1 = new Bone(5, 4);
    private Bone bone2 = new Bone(3, 3);
    private Bone bone3 = new Bone(1, 2);
    private Bone bone4 = new Bone(3, 4);
    private Bone bone5 = new Bone(0, 5);
    private Bone bone6 = new Bone(4, 6);
    private Bone bone7 = new Bone(2, 1);

    @Before
    public void setUp() throws Exception {
        Bone bone = new Bone(0, 0);
        Bone bone1 = new Bone(5, 4);
        Bone bone2 = new Bone(3, 3);
        Bone bone3 = new Bone(1, 2);
        Bone bone4 = new Bone(3, 4);
        Bone bone5 = new Bone(0, 5);
        Bone bone6 = new Bone(4, 6);
        Bone bone7 = new Bone(2, 1);
    }

    @Test
    public void getAllBone() {

        List<Bone> expected = Bone.getAllBone();

        List<Bone> actual = new ArrayList<>();

        actual.add(bone);
        actual.add(bone1);
        actual.add(bone2);
        actual.add(bone3);
        actual.add(bone4);
        actual.add(bone5);
        actual.add(bone6);
        actual.add(bone7);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllUsers_NO_NULL() {

        List<Bone> expected = Bone.getAllBone();
        Assert.assertNotNull(expected);
    }

    @Test
    public void getHowManyBone() {

        int expected = Bone.getHowManyBone();

        int actual = 8;

        Assert.assertEquals(expected, actual);
    }


}