package Controllers;

import Model.Character;
import Model.CharacterHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CharacterScreenController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCharacterArea();
    }
    @FXML
    private void setCharacterArea(){
        // Load all existing characters to the flowpane in Controllers.CharacterScreen.fxml
    }
    @FXML
    private void deleteCharacter(){
        // Delete a preexisting character
    }

    @FXML
    private void sendData(MouseEvent event) {
        // Step 1
        Character character = CharacterHandler.loadCharacter("Gregg");
        // Step 2
        Node node = (Node) event.getSource();
        // Step 3
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        try {
            // Step 4
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/SceneA.fxml"));
            // Step 5
            stage.setUserData(character);
            // Step 6
            Scene scene = new Scene(root);
            stage.setScene(scene);
            // Step 7
            stage.show();
        } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
        }
    }

}
