package com.example.javafx_practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;x
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Optional;


public class DialogBox extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();
        Button btn = new Button("Click");
        Label label = new Label();
        label.relocate(30, 50);
        root.getChildren().addAll(btn, label);

        btn.setOnAction(e->{
            Dialog dialog = new Dialog();
            dialog.setTitle("Confirmation");
            dialog.setHeaderText("Select an option :");
            dialog.setContentText("Are you a boy?");
            dialog.getDialogPane().getButtonTypes().add(ButtonType.YES);
            dialog.getDialogPane().getButtonTypes().add(ButtonType.NO);
            Optional<ButtonType> selected = dialog.showAndWait();
            String gender = "Not selected by you";
            if(selected.get()==ButtonType.YES)
                gender = "Male";
            else if(selected.get()==ButtonType.NO)
                gender = "Female";
            label.setText("Your gender is : "+gender);
        });

        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }
}
