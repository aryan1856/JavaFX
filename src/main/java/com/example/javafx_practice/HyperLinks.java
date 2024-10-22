package com.example.javafx_practice;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.awt.Desktop;
import java.net.URI;

public class HyperLinks extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        HBox hbox = new HBox();
        Hyperlink hl = new Hyperlink("Click here");
        hl.setOnAction(e->{
            runUrl("https://www.instagram.com/");
        });
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().add(hl);
        stage.setScene(new Scene(hbox, 300, 300));
        stage.show();
    }

    private void runUrl(String url){
        try {
            Desktop.getDesktop().browse(new URI(url));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
