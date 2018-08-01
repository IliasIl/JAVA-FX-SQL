package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class HomePageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField TextField;

    @FXML
    void initialize() {
        assert TextField != null : "fx:id=\"TextField\" was not injected: check your FXML file 'HomePage.fxml'.";

    }
}
