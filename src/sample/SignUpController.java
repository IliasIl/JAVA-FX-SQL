package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField firstName;

    @FXML
    private Button authButton;

    @FXML
    private PasswordField password;

    @FXML
    private TextField userName;

    @FXML
    private TextField Local;

    @FXML
    private TextField lastName;

    @FXML
    private CheckBox checkMale;

    @FXML
    private CheckBox CheckFemale;

    @FXML
    void initialize() {
authButton.setOnAction(event -> {
    signUpNewUser();
});

    }

    private void signUpNewUser() {
        DatabaseHandler dbHandler= new DatabaseHandler();
        String firstname= firstName.getText();
        String lastname= lastName.getText();
        String username= userName.getText();
        String passw= password.getText();
        String location=Local.getText();
        String gender="";
        if (checkMale.isSelected()){
             gender="Мужчина"; } else gender="Женщина";
        User user= new User(firstname, lastname, username, passw, location, gender);
        dbHandler.signUpUser(user);

        }
    }


