package net.gazeplay.games.creampie;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import net.gazeplay.commons.utils.games.Utils;
import net.gazeplay.games.creampie.event.TouchEvent;

/**
 * Created by schwab on 17/08/2016.
 */
public class Hand extends Parent {

    private static final int size = 40;
    private static final int maxSize = 100;

    private static final String IMAGES_BASE_PATH = "data/creampie/images";

    private static final String PIE_IMAGE_PATH = IMAGES_BASE_PATH + "/gateau.png";

    private static final String HAND_IMAGE_PATH = IMAGES_BASE_PATH + "/hand.png";

    private final ImageView hand;

    private final ImageView pie;

    private double handTranslateX = 0;
    private double handTranslateY = 0;
    private double pieTranslateX = 0;
    private double pieTranslateY = 0;

    public Hand() {
        recomputePosition();

        hand = new ImageView(new Image(HAND_IMAGE_PATH));
        hand.setFitWidth(maxSize);
        hand.setFitHeight(maxSize);
        hand.setPreserveRatio(true);

        pie = new ImageView(new Image(PIE_IMAGE_PATH));
        pie.setFitWidth(size);
        pie.setFitHeight(size);
        pie.setPreserveRatio(true);

        this.getChildren().add(pie);
        this.getChildren().add(hand);

        this.addEventHandler(TouchEvent.TOUCH, (TouchEvent te) -> touch(te));
    }

    public void recomputePosition() {
        Pane parent = (Pane) this.getParent();
        if (parent != null) {
            handTranslateX = (parent.getWidth() - maxSize) / 2;
            handTranslateY = parent.getHeight() - maxSize;
            pieTranslateX = (parent.getWidth() - size) / 2;
            pieTranslateY = parent.getHeight() - maxSize;

            hand.setTranslateX(handTranslateX);
            hand.setTranslateY(handTranslateY);

            pie.setTranslateX(pieTranslateX);
            pie.setTranslateY(pieTranslateY);
        }
    }

    private void touch(TouchEvent te) {
        recomputePosition();

        Timeline timeline = new Timeline();
        Timeline timeline2 = new Timeline();

        timeline.getKeyFrames().add(new KeyFrame(new Duration(200), new KeyValue(hand.fitHeightProperty(), size)));
        timeline.getKeyFrames().add(new KeyFrame(new Duration(200), new KeyValue(hand.fitWidthProperty(), size)));
        timeline.getKeyFrames()
                .add(new KeyFrame(new Duration(2000), new KeyValue(pie.translateXProperty(), te.x - maxSize)));
        timeline.getKeyFrames()
                .add(new KeyFrame(new Duration(2000), new KeyValue(pie.translateYProperty(), te.y - maxSize)));
        timeline.getKeyFrames()
                .add(new KeyFrame(new Duration(2000), new KeyValue(pie.fitHeightProperty(), maxSize * 2)));
        timeline.getKeyFrames()
                .add(new KeyFrame(new Duration(2000), new KeyValue(pie.fitWidthProperty(), maxSize * 2)));
        timeline.getKeyFrames()
                .add(new KeyFrame(new Duration(2000), new KeyValue(pie.rotateProperty(), pie.getRotate() + 360)));

        timeline2.getKeyFrames().add(new KeyFrame(new Duration(1), new KeyValue(hand.fitHeightProperty(), maxSize)));
        timeline2.getKeyFrames().add(new KeyFrame(new Duration(1), new KeyValue(hand.fitWidthProperty(), maxSize)));
        timeline2.getKeyFrames().add(new KeyFrame(new Duration(1), new KeyValue(pie.fitHeightProperty(), size)));
        timeline2.getKeyFrames().add(new KeyFrame(new Duration(1), new KeyValue(pie.fitWidthProperty(), size)));
        timeline2.getKeyFrames()
                .add(new KeyFrame(new Duration(1), new KeyValue(hand.translateXProperty(), handTranslateX)));
        timeline2.getKeyFrames()
                .add(new KeyFrame(new Duration(1), new KeyValue(hand.translateYProperty(), handTranslateY)));
        timeline2.getKeyFrames()
                .add(new KeyFrame(new Duration(1), new KeyValue(pie.translateXProperty(), pieTranslateX)));
        timeline2.getKeyFrames()
                .add(new KeyFrame(new Duration(1), new KeyValue(pie.translateYProperty(), pieTranslateY)));

        SequentialTransition sequence = new SequentialTransition(timeline, timeline2);

        sequence.play();

        Utils.playSound("data/creampie/sounds/missile.mp3");
    }
}
