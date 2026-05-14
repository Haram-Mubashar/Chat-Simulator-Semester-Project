package com.example.chatsimulator;


import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.scene.Scene;uu
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.geometry.Insets;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {

    GridPane layout = new GridPane();
    Scene scene1 = new Scene(layout, 500, 500);

    GridPane chatLayout = new GridPane();
    Scene chatScene = new Scene(chatLayout, 500, 500);

    ChatManager chatManager = new ChatManager();

    ArrayList<User> savedUsers = new ArrayList<>();

    VBox userPanel = new VBox(10);
    Scene scene = new Scene(userPanel, 100, 500);

    String currentUser="You";



    public void start(Stage stage) throws IOException {

        VBox vbox = new VBox();
        HBox hbox = new HBox(10);
        VBox main = new VBox(10);

        // LABELS
        Label login = new Label("Log In");
        Label loginButton = new Label("Log In");
        Label forgotPassword = new Label("Forgot Password");
        Label prompt = new Label("Don't have an account?");
        Label signUp = new Label("Sign Up");

        forgotPassword.setFont(Font.font("New Times Roman", FontWeight.MEDIUM, 15));
        forgotPassword.setTextFill(Color.DARKRED);

        signUp.setFont(Font.font("New Times Roman", FontWeight.MEDIUM, 15));
        signUp.setTextFill(Color.BLUE);
        prompt.setFont(Font.font("New Times Roman", FontWeight.MEDIUM, 15));

        TextField email = new TextField();
        TextField password = new TextField();
        email.setPromptText("Enter email address");
        password.setPromptText("Password");

        vbox.getChildren().addAll(login, email, password, loginButton, forgotPassword);
        hbox.getChildren().addAll(prompt, signUp);
        main.getChildren().addAll(vbox, hbox);
        layout.getChildren().add(main);

        login.setAlignment(Pos.TOP_LEFT);
        login.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        login.setTextFill(Color.WHITESMOKE);
        loginButton.setFont(Font.font("Arial", FontWeight.MEDIUM, 15));
        loginButton.setTextFill(Color.BLUE);

        hbox.setAlignment(Pos.BOTTOM_LEFT);
        layout.setStyle("-fx-background-color:#0d0d1a ;");
        layout.setAlignment(Pos.CENTER);
        layout.resize(200, 400);


        vbox.setSpacing(20);
        email.setPrefWidth(250);
        email.setPrefHeight(30);
        password.setPrefWidth(250);
        password.setPrefHeight(30);

        // Sign Up fields
        TextField nameText = new TextField();
        TextField birthText = new TextField();
        TextField emailText = new TextField();
        TextField passText = new TextField();
        TextField confirmText = new TextField();

        // SIGN UP
        signUp.setOnMouseClicked(event -> {

            GridPane layout2 = new GridPane();
            VBox vbox2 = new VBox(15);
            VBox vbox3 = new VBox(10);
            HBox mainHbox = new HBox(10);

            layout2.getChildren().addAll(mainHbox);
            layout2.setAlignment(Pos.CENTER);
            layout2.setStyle("-fx-background-color:#0d0d1a ;");

            Label message = new Label("Fill the following information to sign up:");
            Label name = new Label("Full Name:");
            Label birth = new Label("Date of Birth:");
            Label emailLabel = new Label("Email Address:");
            Label pass = new Label("Password:");
            Label confirm = new Label("Confirm Password:");
            Label signUpComplete = new Label("Sign Up");

            name.setFont(Font.font("Arial", FontWeight.MEDIUM, 15));
            birth.setFont(Font.font("Arial", FontWeight.MEDIUM, 15));
            emailLabel.setFont(Font.font("Arial", FontWeight.MEDIUM, 15));
            pass.setFont(Font.font("Arial", FontWeight.MEDIUM, 15));
            confirm.setFont(Font.font("Arial", FontWeight.MEDIUM, 15));
            signUpComplete.setFont(Font.font("Arial", FontWeight.MEDIUM, 15));
            name.setTextFill(Color.WHITESMOKE);
            birth.setTextFill(Color.WHITESMOKE);
            emailLabel.setTextFill(Color.WHITESMOKE);
            pass.setTextFill(Color.WHITESMOKE);
            confirm.setTextFill(Color.WHITESMOKE);
            signUpComplete.setTextFill(Color.BLUE);


            vbox2.getChildren().addAll(name, birth, emailLabel, pass, confirm);
            vbox2.setAlignment(Pos.CENTER_LEFT);

            vbox3.getChildren().addAll(nameText, birthText, emailText, passText, confirmText, signUpComplete);
            vbox3.setAlignment(Pos.CENTER_RIGHT);
            mainHbox.setAlignment(Pos.CENTER);
            mainHbox.getChildren().addAll(vbox2, vbox3);
            mainHbox.setPadding(new Insets(20, 20, 20, 20));

            signUpComplete.setOnMouseClicked(e -> {


                if (nameText.getText().isEmpty() || emailText.getText().isEmpty() || passText.getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Sign Up Failed");
                    alert.setHeaderText(null);
                    alert.setContentText("Please fill all fields!");
                    alert.showAndWait();
                    return;
                }

                if (!passText.getText().equals(confirmText.getText())) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Sign Up Failed");
                    alert.setHeaderText(null);
                    alert.setContentText("Passwords do not match!");
                    alert.showAndWait();
                    return;
                }


                User newUser = new User(emailText.getText(), passText.getText());
                savedUsers.add(newUser);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Account created! You can now log in.");
                alert.showAndWait();

                stage.setScene(scene1);
            });

            Scene scene2 = new Scene(layout2, 500, 500);
            stage.setScene(scene2);
            stage.show();
            stage.setTitle("Sign Up");
        });

        // LOGIN CODE
        loginButton.setOnMouseClicked(event -> {

            String enteredEmail = email.getText();
            String enteredPassword = password.getText();

            String correctEmail = "admin@gmail.com";
            String correctPassword = "1234";

            if (enteredEmail.isEmpty() || enteredPassword.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login Failed");
                alert.setHeaderText(null);
                alert.setContentText("Please enter email and password!");
                alert.showAndWait();
                return;
            }


            if (enteredEmail.equals(correctEmail) && enteredPassword.equals(correctPassword)) {
                stage.setScene(chatScene);
                stage.setTitle("Chats");
                return;
            }
            else if(enteredEmail.equals(emailText.getText()) &&  enteredPassword.equals(passText.getText())) {

                stage.setScene(chatScene);
                stage.setTitle("Chats");
                return;

            }


            boolean found = false;

            for (User u : savedUsers) {
                if (u.getUsername().equals(enteredEmail) && u.getPassword().equals(enteredPassword)) {
                    found = true;
                    break;
                }
            }

            if (found) {
                stage.setScene(chatScene);
                stage.setTitle("Chats");

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login Failed");
                alert.setHeaderText(null);
                alert.setContentText("Incorrect Username or Password!");
                alert.showAndWait();
            }
        });


        forgotPassword.setOnMouseClicked(event -> {

            GridPane layout3 = new GridPane();
            VBox vbox1 = new VBox(20);
            VBox vbox2 = new VBox(15);
            VBox mainVbox = new VBox(10);
            VBox resetBox = new VBox(10);

            TextField resetPass = new TextField();
            TextField resetConfirm = new TextField();
            resetPass.setPromptText("New Password");
            resetConfirm.setPromptText("Confirm Password");

            Label ResetPassword = new Label("Reset Password:");
            Label pass = new Label("Password:");
            Label confirm = new Label("Confirm Password:");
            Label reset = new Label("Reset");

            vbox1.getChildren().addAll(pass, resetPass);
            vbox2.getChildren().addAll(confirm, resetConfirm, reset);
            resetBox.getChildren().add(ResetPassword);

            resetBox.setAlignment(Pos.TOP_CENTER);
            ResetPassword.setFont(Font.font("Arial", FontWeight.MEDIUM, 20));
            reset.setFont(Font.font("Arial", FontWeight.MEDIUM, 15));
            reset.setTextFill(Color.BLUE);
            layout3.setStyle("-fx-background-color:#0d0d1a ;");
            pass.setTextFill(Color.WHITESMOKE);
            confirm.setTextFill(Color.WHITESMOKE);
            ResetPassword.setTextFill(Color.WHITESMOKE);

            reset.setOnMouseClicked(event3 -> {

                if(!resetPass.getText().isEmpty() && !resetConfirm.getText().isEmpty()) {
                    stage.setScene(scene1);
                }
                else if(!resetPass.getText().equals(resetConfirm.getText().isEmpty())){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Username cannot be empty!");
                    alert.showAndWait();
                }
                else if(!resetConfirm.getText().isEmpty() || (resetPass.getText().isEmpty())) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Username cannot be empty!");
                    alert.showAndWait();
                }

            });

            mainVbox.getChildren().addAll(resetBox, vbox1, vbox2);
            mainVbox.setAlignment(Pos.CENTER);
            layout3.getChildren().addAll(mainVbox);
            layout3.setAlignment(Pos.CENTER);

            Scene scene3 = new Scene(layout3, 500, 500);
            stage.setScene(scene3);
            stage.setTitle("Forgot Password");
            stage.show();
        });

        VBox userPanel = new VBox(10);

        VBox chatsVbox = new VBox(20);
        HBox toolbar = new HBox(10);

        Label Chats = new Label("Chats");
        Chats.setTextFill(Color.WHITESMOKE);
        Chats.setFont(Font.font("Arial", FontWeight.BOLD, 25));

        Button addUser = new Button("Add User");
        addUser.setFont(Font.font("Arial", FontWeight.MEDIUM, 15));
        addUser.setTextFill(Color.WHITESMOKE);
        addUser.setStyle("-fx-background-color:#0d0d1a ;");


        Label logOut = new Label("Log Out");
        logOut.setFont(Font.font("Arial", FontWeight.MEDIUM, 15));
        logOut.setTextFill(Color.WHITESMOKE);

        toolbar.getChildren().addAll(addUser, logOut);
        toolbar.setAlignment(Pos.TOP_LEFT);
        chatsVbox.getChildren().addAll(Chats, toolbar);
        chatsVbox.getChildren().add(userPanel);
        chatLayout.getChildren().addAll(chatsVbox);
        chatLayout.setStyle("-fx-background-color:#0d0d1a ;");

        chatsVbox.setAlignment(Pos.TOP_LEFT);
        chatsVbox.setPadding(new Insets(10, 20, 10, 20));



        // add user screen
        addUser.setOnMouseClicked(event2 -> {

            GridPane addUserScreen = new GridPane();
            VBox addUserVbox = new VBox(10);

            Label newUserLabel = new Label("New User:");
            newUserLabel.setTextFill(Color.WHITESMOKE);

            Button add = new Button("Add");
            TextField newUserText = new TextField();
            newUserText.setPromptText("Enter username");

            addUserVbox.getChildren().addAll(newUserLabel, newUserText, add);
            addUserScreen.getChildren().addAll(addUserVbox);
            addUserScreen.setStyle("-fx-background-color:#0d0d1a ;");
            addUserScreen.setAlignment(Pos.CENTER);
            add.setTextFill(Color.BLACK);

            add.setOnAction(eventB -> {

                String name=newUserText.getText();

                if (name.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Username cannot be empty!");
                    alert.showAndWait();
                    return;
                }

                User u = new User(name);
                chatManager.addUser(u);

                Chat chat = new Chat("You", name);
                chatManager.addChat(chat);

                Label user = new Label(name);
                user.setTextFill(Color.WHITESMOKE);
                user.setFont(Font.font("Arial", FontWeight.MEDIUM, 15));
                user.setStyle("-fx-cursor: hand;");
                user.setPadding(new Insets(5, 0, 5, 0));

                userPanel.getChildren().add(user);

                user.setOnMouseClicked(event3 -> {
                    openChat(stage, chatScene, name, chat);
                });

                stage.setScene(chatScene);
            });



            Scene scene4 = new Scene(addUserScreen, 300, 300);
            stage.setScene(scene4);
            stage.setTitle("Add User");
        });

        logOut.setOnMouseClicked(event3 -> {
            stage.setScene(scene1);
        });

        stage.setTitle("Chat Simulator");
        stage.setScene(scene1);
        stage.show();
    }

    private void openChat(Stage stage, Scene chatScene, String userName, Chat chat) {

        GridPane msgLayout = new GridPane();
        VBox msgVbox = new VBox(20);
        msgVbox.setPadding(new Insets(10, 10, 10, 10));

        Label chatTitle = new Label("Chat with " + userName);
        chatTitle.setTextFill(Color.WHITESMOKE);
        chatTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));


        VBox messagesBox = new VBox(8);
        messagesBox.setPadding(new Insets(10, 10, 10, 10));


        // In order to show existing messages
        for (Message m : chat.messages) {
            Label msgLabel = new Label(m.toString());
            msgLabel.setTextFill(Color.LIGHTGRAY);
            msgLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 13));
            msgLabel.setWrapText(true);
            messagesBox.getChildren().add(msgLabel);
        }


        HBox inputBox = new HBox(10);
        TextField msgInput = new TextField();
        msgInput.setPromptText("Type a message...");
        msgInput.setPrefWidth(350);

        Button sendBtn = new Button("Send");
        sendBtn.setStyle("-fx-background-color: #1a1a4e; -fx-text-fill: white;");
        sendBtn.setFont(Font.font("Arial", FontWeight.MEDIUM, 13));

        inputBox.getChildren().addAll(msgInput, sendBtn);
        inputBox.setAlignment(Pos.CENTER);


        Label backBtn = new Label(" Back");
        backBtn.setTextFill(Color.WHITESMOKE);
        backBtn.setFont(Font.font("Arial", FontWeight.NORMAL, 13));
        backBtn.setStyle("-fx-background-color: #1a1a4e;");

        Button switchButton = new Button("Switch");
        switchButton.setTextFill(Color.WHITESMOKE);
        switchButton.setFont(Font.font("Arial", FontWeight.NORMAL, 13));
        switchButton.setStyle("-fx-background-color: #1a1a4e;");
        Label currentUserLabel = new Label("Current User: " + currentUser);
        currentUserLabel.setTextFill(Color.WHITESMOKE);


        msgVbox.getChildren().addAll(backBtn, switchButton, chatTitle, messagesBox, inputBox, currentUserLabel);
        msgLayout.getChildren().add(msgVbox);
        msgLayout.setStyle("-fx-background-color:#0d0d1a;");
        msgLayout.setAlignment(Pos.TOP_LEFT);


        switchButton.setOnMouseClicked(event3 -> {

            if (currentUser.equals("You")) {
                currentUser = userName;
            } else {
                currentUser = "You";
            }
            currentUserLabel.setText("Current User: " + currentUser);

        });


        sendBtn.setOnAction(e -> {

            String text = msgInput.getText();
            Message m = new Message(text);

            if (!text.isEmpty()) {


                m.setSender(currentUser);
                chat.messages.add(m);

                Label msgLabel = new Label(m.getSender() +" : " +text);

                msgLabel.setTextFill(Color.LIGHTGREEN);
                msgLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 13));
                msgLabel.setWrapText(true);
                messagesBox.getChildren().add(msgLabel);

                msgInput.clear();

            }


            Button switchBtn = new Button("Switch User");









        });

        backBtn.setOnMouseClicked(e3 -> {

            stage.setScene(chatScene);
            stage.setTitle("Chats");
        });



        Scene msgScene = new Scene(msgLayout, 500, 500);
        stage.setScene(msgScene);
        stage.setTitle("Chat - " + userName);
    }
}