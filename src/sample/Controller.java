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
import java.sql.*;

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
        authButton.setOnAction(event -> {
            String login= user_field.getText().trim();
            String pass= pass_field.getText().trim();
            if (!login.equals("") && !pass.equals("")){
                loginUser(login,pass);
            } else System.out.println("Login and password is empty!");
        });


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

    private void loginUser(String login, String pass) {
    DatabaseHandler dbHandler= new DatabaseHandler();
    User user= new User(login,pass);
    ResultSet result = dbHandler.getUser(user);
    int count= 0;
try {
    while (result.next()) {
        count++;
    }
} catch (Exception ex){ex.printStackTrace();}
if (count>=1){
    System.out.println("Success");
}
    }


}
