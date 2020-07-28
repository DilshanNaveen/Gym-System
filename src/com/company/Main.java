package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

    Stage addMember;

    public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage primaryStage) throws Exception {
        addMember = primaryStage;
        addMember.setTitle("Add Member");
        AnchorPane addMemberPane = new AnchorPane();
        Scene addMemberScene = new Scene(addMemberPane, 1280, 720);

        AnchorPane inputSection = new AnchorPane();
        AnchorPane.setTopAnchor(inputSection, 120.0);
        AnchorPane.setLeftAnchor(inputSection, 25.0);
        inputSection.getStyleClass().add("main-container-style");
        inputSection.setPrefWidth(1240);
        inputSection.setPrefHeight(580);

        AnchorPane buttonSection = new AnchorPane();
        AnchorPane.setTopAnchor(buttonSection, 20.0);
        AnchorPane.setLeftAnchor(buttonSection, 20.0);
        buttonSection.setPrefWidth(300);
        buttonSection.setPrefHeight(100);

        Label newMemberTitle = new Label("Add Member");
        newMemberTitle.getStyleClass().add("add-member-title-style");
        AnchorPane.setTopAnchor(newMemberTitle, 10.0);
        AnchorPane.setLeftAnchor(newMemberTitle, 700.0);


        // Sign Out Button.
        Button signOutButton = new Button("Sign Out");
        // iRButton.setOnMouseClicked(e -> InterestRate.displayInterestRateCalculator(simpleSavingsCalculator, mainScene, simpleSavingsScene));
        AnchorPane.setTopAnchor(signOutButton, 20.0);
        AnchorPane.setLeftAnchor(signOutButton, 10.0);
        signOutButton.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
        signOutButton.setPrefWidth(120);
        signOutButton.setPrefHeight(40);

        // Back Button.
        Button backButton = new Button("Back");
        // iRButton.setOnMouseClicked(e -> InterestRate.displayInterestRateCalculator(simpleSavingsCalculator, mainScene, simpleSavingsScene));
        AnchorPane.setTopAnchor(backButton, 20.0);
        AnchorPane.setLeftAnchor(backButton, 140.0);
        backButton.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
        backButton.setPrefWidth(120);
        backButton.setPrefHeight(40);

        buttonSection.getChildren().addAll(signOutButton, backButton);



        addMemberPane.getChildren().addAll(buttonSection, inputSection, newMemberTitle);
        addMemberScene.getStylesheets().add("style.css");
        addMember.setResizable(false);
        addMember.setScene(addMemberScene);
        addMember.show();
    }
}
