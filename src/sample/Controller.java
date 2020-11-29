package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    @FXML
    private ToggleButton k00, k01, k02, k03, k04, k05, k06,
            k11, k12, k13, k14, k15, k16,
            k22, k23, k24, k25, k26,
            k33, k34, k35, k36,
            k44, k45, k46,
            k55, k56,
            k66;

    private ArrayList<Bone> bones;

    @FXML
    GridPane grid;

    @FXML
    void initialize() {
        bones = new ArrayList<>();
        grid.setStyle("-fx-background-color: #262626;");

        // Реализация метода, определенного в интерефейсе HandleFunction, являющегося функциональным
        BoneClickHandler.HandleFunction handler = (first, second) -> {
            Bone bone = new Bone(first, second);
            ToggleButton tg = getButton(first, second);
            if (tg.isSelected()) {
                tg.setOpacity(1.0);
                bones.add(bone);
            } else {
                tg.setOpacity(0.5);
                bones.remove(bone);
            }
        };

        for (Node x : grid.getChildren()) {
            if (x instanceof ToggleButton) {
                x.setOpacity(0.5);
                GridPane.setMargin(x, new Insets(15));

                x.setOnMouseClicked(new BoneClickHandler(handler, x.getId().charAt(1) - '0', x.getId().charAt(2) - '0'));
            }
        }
    }


    ToggleButton getButton(int i, int j) {
        if (i == 0 && j == 0) {
            return k00;
        }
        if (i == 0 && j == 1) {
            return k01;
        }
        if (i == 0 && j == 2) {
            return k02;
        }
        if (i == 0 && j == 3) {
            return k03;
        }
        if (i == 0 && j == 4) {
            return k04;
        }
        if (i == 0 && j == 5) {
            return k05;
        }
        if (i == 0 && j == 6) {
            return k06;
        }
        if (i == 1 && j == 1) {
            return k11;
        }
        if (i == 1 && j == 2) {
            return k12;
        }
        if (i == 1 && j == 3) {
            return k13;
        }
        if (i == 1 && j == 4) {
            return k14;
        }
        if (i == 1 && j == 5) {
            return k15;
        }
        if (i == 1 && j == 6) {
            return k16;
        }
        if (i == 2 && j == 2) {
            return k22;
        }
        if (i == 2 && j == 3) {
            return k23;
        }
        if (i == 2 && j == 4) {
            return k24;
        }
        if (i == 2 && j == 5) {
            return k25;
        }
        if (i == 2 && j == 6) {
            return k26;
        }
        if (i == 3 && j == 3) {
            return k33;
        }
        if (i == 3 && j == 4) {
            return k34;
        }
        if (i == 3 && j == 5) {
            return k35;
        }
        if (i == 3 && j == 6) {
            return k36;
        }
        if (i == 4 && j == 4) {
            return k44;
        }
        if (i == 4 && j == 5) {
            return k45;
        }
        if (i == 4 && j == 6) {
            return k46;
        }
        if (i == 5 && j == 5) {
            return k55;
        }
        if (i == 5 && j == 6) {
            return k56;
        }
        else return k66;
    }

    public void openNewStage() throws IOException{
        Stage newStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("res.fxml"));

        newStage.setTitle("Lenkino Domino");
        newStage.setScene(new Scene(loader.load(), 1000, 500));
        newStage.setResizable(false);

        ResController resController = loader.getController();
        resController.initialize(bones);

        newStage.show();
    }

    public void onResultClick(ActionEvent actionEvent) throws IOException {
        openNewStage();

    }
}
