package com.example.javafx_practice;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

// we can use ParallelTransition class to run more than one transitions simultaneously

public class AnimationsLearning extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        File file = new File("src/bg.jpeg");
        Image img = new Image(new FileInputStream(file));
        ImageView background = new ImageView(img);
        background.setFitWidth(800);
        background.setFitHeight(600);
//        background.setPreserveRatio(true);

        Text message = new Text("Welcome \n It's a pleasant morning");
        message.setVisible(false);
        message.setStyle(
                "-fx-text-fill:white;" +
                        "-fx-font-size : 34px;" +
                        "-fx-font-weight : bold;"
        );

        Button clickToReveal = new Button("Click here to reveal");
        clickToReveal.setCursor(Cursor.HAND);
        clickToReveal.setStyle(
                "-fx-background-color: linear-gradient(#ff7f50, #ff4500); " +           // Gradient color
                        "-fx-text-fill: white; " +                                     // White text
                        "-fx-font-size: 16px; " +                                      // Larger font size
                        "-fx-font-weight: bold; " +                                    // Bold text
                        "-fx-padding: 10 20; " +                                       // Padding inside button
                        "-fx-background-radius: 15; " +                                // Rounded corners
                        "-fx-border-radius: 15; " +                                    // Rounded corners on border
                        "-fx-border-color: #ff6347; " +                                // Border color
                        "-fx-border-width: 2; "                                        // Border width
        );

        // Add hover effect
        clickToReveal.setOnMouseEntered(e -> {
            clickToReveal.setStyle(
                    "-fx-background-color: linear-gradient(#ff6347, #ff4500); " +
                            "-fx-text-fill: white; " +
                            "-fx-font-size: 16px; " +
                            "-fx-font-weight: bold; " +
                            "-fx-padding: 10 20; " +
                            "-fx-background-radius: 15; " +
                            "-fx-border-radius: 15; " +
                            "-fx-border-color: #ff4500; " +
                            "-fx-border-width: 2;"
            );
        });
        // revert back after hover
        clickToReveal.setOnMouseExited(e -> {
            clickToReveal.setStyle(
                    "-fx-background-color: linear-gradient(#ff7f50, #ff4500); " +
                            "-fx-text-fill: white; " +
                            "-fx-font-size: 16px; " +
                            "-fx-font-weight: bold; " +
                            "-fx-padding: 10 20; " +
                            "-fx-background-radius: 15; " +
                            "-fx-border-radius: 15; " +
                            "-fx-border-color: #ff6347; " +
                            "-fx-border-width: 2;"
            );
        });
        clickToReveal.setOnAction(e->{
            relocateButton(clickToReveal);
            message.setVisible(true);
        });

        StackPane pane = new StackPane();
        pane.getChildren().addAll(background, clickToReveal, message);

        primaryStage.setScene(new Scene(pane, 800, 600));
        primaryStage.show();
    }

    private void relocateButton(Button button) {
        // Create a TranslateTransition to animate button relocation
        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.4), button);
        transition.setToX(500); // X position
        transition.setToY(400); // Y position
        transition.play();
    }

    /*
    *   Using TranslateTransition
    *   @Override
            public void start(Stage primaryStage) throws Exception {
                // class to add animations
                TranslateTransition tt = new TranslateTransition(Duration.seconds(2));
                HBox hb = new HBox();
                Label label = new Label("Animating...");
                hb.getChildren().add(label);
                hb.setAlignment(Pos.CENTER);
                // set Node value to which transition should be applied
                tt.setNode(label);
                // set position in X direction to which node should go
                tt.setToX(200);
                // set position in Y direction
                tt.setToY(30);
                // if you want your element to go back to original position
                tt.setAutoReverse(true);
                // no of cycles, how many times you want to perform the animation
                tt.setCycleCount(10);
                // to play the animation
                tt.play();

                tt.setOnFinished(e->{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Important!");
                    alert.setContentText("transition completed");
                    alert.show();
                });
                primaryStage.setScene(new Scene(hb, 600, 500));
                primaryStage.show();
            }
    * */

    /*
    *   Using ScaleTransition
    * @Override
            public void start(Stage stage) throws Exception{
                // Create the heart shape using Path
                Path heart = new Path();
                heart.setFill(Color.RED);
                heart.setStroke(Color.RED);

                // Move to starting point (bottom of the heart)
                heart.getElements().add(new MoveTo(300, 400));

                // Draw the left curve of the heart
                heart.getElements().add(new CubicCurveTo(100, 200, 100, 50, 300, 150));

                // Draw the right curve of the heart
                heart.getElements().add(new CubicCurveTo(500, 50, 500, 200, 300, 400));

                // Close the shape
                heart.getElements().add(new ClosePath());

                // Add the heart to an HBox
                HBox hb = new HBox();
                hb.setAlignment(Pos.CENTER);
                hb.getChildren().add(heart);

                heartbeatAnimation(heart);



                // Set up the scene and stage
                stage.setScene(new Scene(hb, 800, 800));
                stage.show();
            }

            private void heartbeatAnimation(Node node){
                ScaleTransition st = new ScaleTransition(Duration.seconds(1.5));
                st.setNode(node);
                st.setCycleCount(ScaleTransition.INDEFINITE);
                st.setFromX(1);
                st.setFromY(1);
                st.setToX(1.5);
                st.setToY(1.5);
                st.setAutoReverse(true);
                st.play();
            }
    * */
}
