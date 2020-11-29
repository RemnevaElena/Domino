package sample;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class ResController {

    @FXML
    private HBox box;

    public void initialize(ArrayList<Bone> bones) {
        box.setSpacing(90);

        Solver solver = new Solver(bones);
        solver.makeChain();
        ArrayList<Bone> chain = solver.getBestChain();

        for (Bone bone: chain) {
            ImageView boneImg = new ImageView(new Image("res/" + Math.min(bone.first(), bone.second()) + Math.max(bone.first(), bone.second()) + ".png"));
            if (bone.first() < bone.second())
                boneImg.setRotate(-90);
            else
                boneImg.setRotate(90);

            box.getChildren().add(boneImg);
        }

    }

    @FXML
    void initialize() {
    }
}
