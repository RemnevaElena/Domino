package sample;

import javafx.fxml.FXML;

import java.util.ArrayList;

public class ResController {

    private ArrayList<Bone> bones;

    public void initialize(ArrayList<Bone> bones) {
        this.bones = bones;

        Solver solver = new Solver(bones);
        solver.makeChain();
    }

    @FXML
    void initialize() {
//        System.out.println("bones: " + bones);
//        Solver solver = new Solver(bones);
//        solver.makeChain();
    }
}
