package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField user_field;

    @FXML
    private Button authButton;

    @FXML
    private PasswordField pass_field;

    @FXML
    private Button SignUpButton;

    @FXML
    void initialize() {
    SignUpButton.setOnAction(event -> {
    SignUpButton.getScene().getWindow().hide();
    FXMLLoader loader= new FXMLLoader();
    loader.setLocation(getClass().getResource("/sample/signUp.fxml"));
    try{
        loader.load();
    } catch(Exception ex){ex.printStackTrace();}
    Parent root= loader.getRoot();
    Scene scene= new Scene(root);
    Stage stage= new Stage();
    stage.setScene(scene);
    stage.showAndWait();

});

    }
}
