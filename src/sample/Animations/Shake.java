package sample.Animations;

import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.scene.Node;

public class Shake {
    private TranslateTransition rr;

    public Shake(Node node){
        rr= new TranslateTransition(Duration.millis(70), node);
        rr.setFromX(0f);
        rr.setByX(10f);
        rr.setCycleCount(3);
        rr.setAutoReverse(true);

    }

    public void playAnim(){
        rr.playFromStart();
    }
}
