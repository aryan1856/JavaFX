package com.example.javafx_practice;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Stage;

public class Listner_Example extends Application {
    private StringProperty s = new SimpleStringProperty();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        s.addListener((obj, oldVal, newVal)->{
            System.out.println("Value changed from "+oldVal+" to "+newVal);
        });
        s.set("Ram");
//        listenStringProperty();
        s.set("Kishan");
//        listenStringProperty();
    }
}
