package com.example.javafx_practice;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


// shortcuts are known as mnemonic keys

public class Accelorator_KeyCombination extends Application {
    private static int times=0;
    public static void main(String[] args) {
        launch(args);
    }

    /*
        using KeyCombination class, it's an abstract class so use
        KeyCodeCombination or KeyCharacterCombination to create object */
        @Override
        public void start(Stage primaryStage) throws Exception {
            VBox vb = new VBox();
            vb.setAlignment(Pos.CENTER);
            Label label = new Label();
            label.relocate(20, 60);
            Button btn = new Button("Click");
            btn.setOnAction(e->{
                label.setText("Pressed "+(++times)+" times");
           });
            vb.getChildren().addAll(btn, label);
            KeyCombination kc = new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN);
            // or
            KeyCombination kc1 = new KeyCharacterCombination("C", KeyCombination.CONTROL_DOWN);
            // here kc and kc1 are same
            btn.setOnKeyPressed(event -> {
                if (kc.match(event)) {
                    label.setText("Pressed "+(++times)+" times");
                }
            });
            Mnemonic mnemonic =  new Mnemonic(btn, kc);
            Scene scene = new Scene(vb, 400, 400);
            scene.addMnemonic(mnemonic);
            primaryStage.setScene(scene);
            primaryStage.show();
        }

    /*
        using '_' before or in between text but not in the last
       */
        @Override
        public void start(Stage primaryStage) throws Exception {
            HBox hb = new HBox();
            hb.setAlignment(Pos.CENTER);
            Label label = new Label();
            Button btn = new Button("_Click");
            btn.setOnAction(e->{
                label.setText("Pressed "+(++times)+" times");
            });
            hb.getChildren().addAll(btn, label);
            primaryStage.setScene(new Scene(hb, 400, 400));
            primaryStage.show();
        }
}
