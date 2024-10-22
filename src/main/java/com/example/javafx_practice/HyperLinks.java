package com.example.javafx_practice;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.Desktop;
import java.io.FileInputStream;
import java.net.URI;

public class HyperLinks extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Image img = new Image(new FileInputStream("C:\\Users\\ARYAN DIWAKAR\\IdeaProjects\\JavaFx_practice\\src\\instagram.png"));
        ImageView iView = new ImageView(img);
        iView.setFitHeight(35);
        iView.setFitWidth(35);
        HBox hbox = new HBox();
        Hyperlink hl = new Hyperlink();
        hl.setGraphic(iView);
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
