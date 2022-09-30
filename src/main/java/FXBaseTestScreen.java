import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class FXBaseTestScreen extends Application {

    public void start(Stage stage) throws IOException {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");

        Label l = new Label("Här står saker:, JavaFX version:" + javafxVersion + ", Java på version" + javaVersion + ".");


        Parent root = FXMLLoader.load(getClass().getResource("BaseScreen.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Caves and Carnivores");
        SceneController sceneController = new SceneController();
        sceneController.openStartScreen(); //this line does not work yet??


        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        primaryStage.setMaximized(true);


    }


    public static void main(String[] args) {
        launch();
    }


}
