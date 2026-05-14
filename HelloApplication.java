package com.example.demo;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.geometry.Insets;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Locale;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        GridPane layout  = new GridPane();
        VBox vbox = new VBox();

        //LABELS
        Label login = new Label("Log In");
        Label forgotPassword = new Label("Forgot Password");

        //Forgot Password customization
        forgotPassword.setFont(Font.font("New Times Roman", FontWeight.MEDIUM, 20));
        forgotPassword.setTextFill(Color.DARKRED);
        

        //TEXTFIELDS
        TextField username = new TextField();
        TextField password = new TextField();
        username.setPromptText("Username");
        password.setPromptText("Password");

        //SHAPES OF TEXTFIELDS
        username.setShape(new Rectangle(200,4));
        password.setShape(new Rectangle(200,4));


        vbox.getChildren().addAll(login,username,password,forgotPassword);
        layout.getChildren().add(vbox);

        //login label customization
        login.setMaxWidth(Double.MAX_VALUE);
        login.setAlignment(Pos.TOP_LEFT);
        login.setFont(Font.font("Arial", FontWeight.BOLD,50));
        login.setTextFill(Color.WHITESMOKE);


        //layout customization
        layout.setStyle("-fx-background-color:#0d0d1a ;");

        //Allignment

        layout.setAlignment(Pos.CENTER);
        GridPane.setColumnIndex(vbox,0);
        GridPane.setRowIndex(vbox,0);
        GridPane.setHalignment(vbox, HPos.CENTER);
        GridPane.setValignment(vbox, VPos.CENTER);

        vbox.setSpacing(20);
        username.setPrefWidth(250);
        username.setPrefHeight(30);
        password.setPrefWidth(250);
        password.setPrefHeight(30);
        login.setPrefWidth(250);
        login.setPrefHeight(40);


        Scene  scene  = new Scene(layout, 500, 500);
        stage.setTitle("Chat Simulator");
        stage.setScene(scene);
        stage.show();







    }
}


