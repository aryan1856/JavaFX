package com.example.javafx_practice;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Switching_in_stages extends Application {
    private Stage primary, secondary;
    @Override
    public void start(Stage stage) throws Exception {
        primary = createPrimaryStage();
        secondary = createSecondaryStage();

        primary.show();
    }

    private Stage createSecondaryStage() {
        Stage stage = new Stage();
        HBox hb = new HBox(30);

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(primary);

        Button btn = new Button("Kill this window");
        btn.setOnAction(e->{
            secondary.close();
        });

        hb.getChildren().add(btn);
        hb.setAlignment(Pos.CENTER);
        stage.setScene(new Scene(hb, 400, 400));
        stage.setTitle("Child Window");
        return stage;
    }

    private Stage createPrimaryStage() {
        Stage stage = new Stage();
        HBox hb = new HBox(30);

        Button btn = new Button("Launch child window");
        btn.setOnAction(e->{
            secondary.show();
        });

        hb.getChildren().add(btn);
        hb.setAlignment(Pos.CENTER);
        stage.setScene(new Scene(hb, 400, 400));
        stage.setTitle("Primary Window");
        return stage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
