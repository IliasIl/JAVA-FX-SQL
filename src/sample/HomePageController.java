package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class HomePageController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField TextField;

    @FXML
    void initialize() {
        TextField.setText("ДОБРО ПОЖАЛОВАТЬ!");

    }


}
