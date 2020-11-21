package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Lenkino Domino");
        primaryStage.setScene(new Scene(root, 900, 870));
        primaryStage.setResizable(false);
        primaryStage.show();


//        @Override
//        public void handle(ActionEvent event) {
//            StackPane secondaryLayout = new StackPane();
//
//            Scene secondScene = new Scene(secondaryLayout, 230, 100);
//
//            Stage newWindow = new Stage();
//            newWindow.setTitle("Second Stage");
//            newWindow.setScene(secondScene);
//
//
//            newWindow.setX(primaryStage.getX() + 200);
//            newWindow.setY(primaryStage.getY() + 100);
//
//            newWindow.show();
//        }
//    });
}


    public static void main(String[] args) {
        launch(args);
    }
}
