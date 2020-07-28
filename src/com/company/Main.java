package com.company;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
        signOutButton.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        signOutButton.setPrefWidth(120);
        signOutButton.setPrefHeight(40);

        // Back Button.
        Button backButton = new Button("Back");
        // iRButton.setOnMouseClicked(e -> InterestRate.displayInterestRateCalculator(simpleSavingsCalculator, mainScene, simpleSavingsScene));
        AnchorPane.setTopAnchor(backButton, 20.0);
        AnchorPane.setLeftAnchor(backButton, 140.0);
        backButton.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        backButton.setPrefWidth(120);
        backButton.setPrefHeight(40);

        buttonSection.getChildren().addAll(signOutButton, backButton);

        // Creating Anchor pane for left column
        AnchorPane leftColumn  = new AnchorPane();
        AnchorPane.setTopAnchor(leftColumn, 20.0);
        AnchorPane.setLeftAnchor(leftColumn, 20.0);
        leftColumn.setPrefWidth(300);
        leftColumn.setPrefHeight(100);

        inputSection.getChildren().addAll(leftColumn);

        // First Name Label.
        Label firstNameLabel = new Label("First Name");
        // iRButton.setOnMouseClicked(e -> InterestRate.displayInterestRateCalculator(simpleSavingsCalculator, mainScene, simpleSavingsScene));
        AnchorPane.setLeftAnchor(firstNameLabel, 20.0);
        firstNameLabel.setPrefWidth(300);
        firstNameLabel.setPrefHeight(40);

        // First Name Text Field.
        TextField firstNameTextField = new TextField();
        // iRButton.setOnMouseClicked(e -> InterestRate.displayInterestRateCalculator(simpleSavingsCalculator, mainScene, simpleSavingsScene));
        AnchorPane.setTopAnchor(firstNameTextField, 40.0);
        AnchorPane.setLeftAnchor(firstNameTextField, 60.0);
        firstNameTextField.setPrefWidth(300);
        firstNameTextField.setPrefHeight(20);

        // Last Name Label.
        Label lastLabel = new Label("Last Name");
        // iRButton.setOnMouseClicked(e -> InterestRate.displayInterestRateCalculator(simpleSavingsCalculator, mainScene, simpleSavingsScene));
        AnchorPane.setTopAnchor(lastLabel, 90.0);
        AnchorPane.setLeftAnchor(lastLabel, 20.0);
        lastLabel.setPrefWidth(300);
        lastLabel.setPrefHeight(40);

        // Last Name Text Field.
        TextField lastTextField = new TextField();
        // iRButton.setOnMouseClicked(e -> InterestRate.displayInterestRateCalculator(simpleSavingsCalculator, mainScene, simpleSavingsScene));
        AnchorPane.setTopAnchor(lastTextField, 130.0);
        AnchorPane.setLeftAnchor(lastTextField, 60.0);
        lastTextField.setPrefWidth(300);
        lastTextField.setPrefHeight(20);

        // National ID Label.
        Label nationalIdLabel = new Label("National ID Number");
        // iRButton.setOnMouseClicked(e -> InterestRate.displayInterestRateCalculator(simpleSavingsCalculator, mainScene, simpleSavingsScene));
        AnchorPane.setTopAnchor(nationalIdLabel, 180.0);
        AnchorPane.setLeftAnchor(nationalIdLabel, 20.0);
        nationalIdLabel.setPrefWidth(300);
        nationalIdLabel.setPrefHeight(40);

        // Last Name Text Field.
        TextField nationalIdTextField = new TextField();
        // iRButton.setOnMouseClicked(e -> InterestRate.displayInterestRateCalculator(simpleSavingsCalculator, mainScene, simpleSavingsScene));
        AnchorPane.setTopAnchor(nationalIdTextField, 220.0);
        AnchorPane.setLeftAnchor(nationalIdTextField, 60.0);
        nationalIdTextField.setPrefWidth(300);
        nationalIdTextField.setPrefHeight(20);

        // Contact Number Label.
        Label contactNumberLabel = new Label("Contact Number");
        // iRButton.setOnMouseClicked(e -> InterestRate.displayInterestRateCalculator(simpleSavingsCalculator, mainScene, simpleSavingsScene));
        AnchorPane.setTopAnchor(contactNumberLabel, 270.0);
        AnchorPane.setLeftAnchor(contactNumberLabel, 20.0);
        contactNumberLabel.setPrefWidth(300);
        contactNumberLabel.setPrefHeight(40);

        //  Contact Number Text Field.
        TextField contactNumberTextField = new TextField();
        // iRButton.setOnMouseClicked(e -> InterestRate.displayInterestRateCalculator(simpleSavingsCalculator, mainScene, simpleSavingsScene));
        AnchorPane.setTopAnchor(contactNumberTextField, 310.0);
        AnchorPane.setLeftAnchor(contactNumberTextField, 60.0);
        contactNumberTextField.setPrefWidth(300);
        contactNumberTextField.setPrefHeight(20);

        // Address Label.
        Label addressLabel = new Label("Address");
        // iRButton.setOnMouseClicked(e -> InterestRate.displayInterestRateCalculator(simpleSavingsCalculator, mainScene, simpleSavingsScene));
        AnchorPane.setTopAnchor(addressLabel, 360.0);
        AnchorPane.setLeftAnchor(addressLabel, 20.0);
        addressLabel.setPrefWidth(300);
        addressLabel.setPrefHeight(40);

        //  Address Text Field.
        TextField addressTextField = new TextField();
        // iRButton.setOnMouseClicked(e -> InterestRate.displayInterestRateCalculator(simpleSavingsCalculator, mainScene, simpleSavingsScene));
        AnchorPane.setTopAnchor(addressTextField, 400.0);
        AnchorPane.setLeftAnchor(addressTextField, 60.0);
        addressTextField.setPrefWidth(300);
        addressTextField.setPrefHeight(20);


        // Creating Anchor pane for right column
        AnchorPane rightColumn  = new AnchorPane();
        AnchorPane.setTopAnchor(rightColumn, 25.0);
        AnchorPane.setLeftAnchor(rightColumn, 500.0);
        rightColumn.setPrefWidth(300);
        rightColumn.setPrefHeight(100);

        inputSection.getChildren().addAll(rightColumn);

        // Gender Label.
        Label GenderLabel = new Label("Gender");
        // iRButton.setOnMouseClicked(e -> InterestRate.displayInterestRateCalculator(simpleSavingsCalculator, mainScene, simpleSavingsScene));
        AnchorPane.setLeftAnchor(GenderLabel, 20.0);
        GenderLabel.setPrefWidth(300);
        GenderLabel.setPrefHeight(40);

        ObservableList<String> options =
                FXCollections.observableArrayList("Male", "Female", "Other");
        final ComboBox genderComboBox = new ComboBox(options);
        genderComboBox.setValue("Male");
        AnchorPane.setLeftAnchor(genderComboBox, 60.0);
        AnchorPane.setTopAnchor(genderComboBox, 40.0);
        genderComboBox.setPrefWidth(300);
        genderComboBox.setPrefHeight(20);

        // Birthday Label.
        Label birthdayLabel = new Label("Birthday");
        // iRButton.setOnMouseClicked(e -> InterestRate.displayInterestRateCalculator(simpleSavingsCalculator, mainScene, simpleSavingsScene));
        AnchorPane.setTopAnchor(birthdayLabel, 90.0);
        AnchorPane.setLeftAnchor(birthdayLabel, 20.0);
        birthdayLabel.setPrefWidth(300);
        birthdayLabel.setPrefHeight(40);

        DatePicker birthDatePicker = new DatePicker();
        AnchorPane.setTopAnchor(birthDatePicker, 130.0);
        AnchorPane.setLeftAnchor(birthDatePicker, 60.0);
        birthDatePicker.setPrefWidth(300);
        birthDatePicker.setPrefHeight(40);

        // Other Information Label.
        Label otherInformationLabel = new Label("Other Information");
        AnchorPane.setTopAnchor(otherInformationLabel, 180.0);
        AnchorPane.setLeftAnchor(otherInformationLabel, 20.0);
        otherInformationLabel.setPrefWidth(300);
        otherInformationLabel.setPrefHeight(40);

        // Other Information Text Area.
        TextArea otherInformationTextArea = new TextArea();
        AnchorPane.setTopAnchor(otherInformationTextArea, 220.0);
        AnchorPane.setLeftAnchor(otherInformationTextArea, 60.0);
        otherInformationTextArea.setPrefWidth(300);
        otherInformationTextArea.setPrefHeight(230);


        leftColumn.getChildren().addAll(firstNameLabel, firstNameTextField, lastLabel, lastTextField, nationalIdLabel, nationalIdTextField, contactNumberLabel, contactNumberTextField, addressLabel, addressTextField);
        rightColumn.getChildren().addAll(GenderLabel, genderComboBox, birthdayLabel, birthDatePicker, otherInformationLabel, otherInformationTextArea);

        addMemberPane.getChildren().addAll(buttonSection, inputSection, newMemberTitle);
        addMemberScene.getStylesheets().add("style.css");
        addMember.setResizable(false);
        addMember.setScene(addMemberScene);
        addMember.show();
    }
}
