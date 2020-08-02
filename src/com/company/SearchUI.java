package com.company;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchUI extends Application {

    Stage addMember;
    TableView<Member> table;

    private final static MyGymManager manager = new MyGymManager();

    public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage primaryStage) throws Exception {
        addMember = primaryStage;
        addMember.setTitle("Search Member");
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

        Label newMemberTitle = new Label("Search Gym Members");
        newMemberTitle.getStyleClass().add("add-member-title-style");
        AnchorPane.setTopAnchor(newMemberTitle, 10.0);
        AnchorPane.setLeftAnchor(newMemberTitle, 260.0);

        // Search By Label.
        Label searchByLabel = new Label("Search By Member Membership No");
        searchByLabel.getStyleClass().add("labelStyle");
        AnchorPane.setTopAnchor(searchByLabel, 20.0);
        AnchorPane.setLeftAnchor(searchByLabel, 20.0);
        searchByLabel.setPrefWidth(350);
        searchByLabel.setPrefHeight(40);

        // Search Label.
        Label searchLabel = new Label("Search");
        searchLabel.getStyleClass().add("labelStyle");
        AnchorPane.setTopAnchor(searchLabel, 20.0);
        AnchorPane.setLeftAnchor(searchLabel, 470.0);
        searchLabel.setPrefWidth(300);
        searchLabel.setPrefHeight(40);

        // Search Text Field.
        TextField searchTextField = new TextField();
        AnchorPane.setTopAnchor(searchTextField, 20.0);
        AnchorPane.setLeftAnchor(searchTextField, 550.0);
        searchTextField.setPrefWidth(300);
        searchTextField.setPrefHeight(20);

        // Search Button.
        Button searchButton = new Button("Search");
        searchButton.setOnMouseClicked(e -> table.setItems(manager.searchTableById(Integer.parseInt(searchTextField.getText()))));
        AnchorPane.setTopAnchor(searchButton, 20.0);
        AnchorPane.setLeftAnchor(searchButton, 870.0);
        searchButton.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        searchButton.setPrefWidth(150);
        searchButton.setPrefHeight(50);

        // Reset Button.
        Button closeButton = new Button("Reset");
        closeButton.setOnMouseClicked(e -> {
            table.setItems(manager.loadTable());
            searchTextField.setText(null);
        });
        AnchorPane.setTopAnchor(closeButton, 20.0);
        AnchorPane.setLeftAnchor(closeButton, 1055.0);
        closeButton.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        closeButton.setPrefWidth(150);
        closeButton.setPrefHeight(50);

        //Table Section
        AnchorPane tableSection = new AnchorPane();
        AnchorPane.setTopAnchor(tableSection, 200.0);
        AnchorPane.setLeftAnchor(tableSection, 50.0);
        tableSection.setPrefWidth(1000);
        tableSection.setPrefHeight(100);

        /*
         * Table Columns
         */

        // Membership no column
        TableColumn<Member, String> memberShipNo = new TableColumn<>("Membership No");
        memberShipNo.setCellValueFactory(new PropertyValueFactory<Member, String>("memberShipNo"));
        memberShipNo.setPrefWidth(132);

        // Name column
        TableColumn<Member, String> name = new TableColumn<>("Name");
        name.setCellValueFactory(new PropertyValueFactory<Member, String>("name"));
        name.setPrefWidth(132);

        // Gender column
        TableColumn<Member, String> gender = new TableColumn<>("Gender");
        gender.setCellValueFactory(new PropertyValueFactory<Member, String>("gender"));
        gender.setPrefWidth(100);

        // National ID column
        TableColumn<Member, String> nationalID = new TableColumn<>("National ID");
        nationalID.setCellValueFactory(new PropertyValueFactory<Member, String>("nationalID"));
        nationalID.setPrefWidth(132);

        // Contact Number column
        TableColumn<Member, Integer> contactNumber = new TableColumn<>("Contact Number");
        contactNumber.setCellValueFactory(new PropertyValueFactory<Member, Integer>("contactNumber"));
        contactNumber.setPrefWidth(132);

        // Start Membership Date column
        TableColumn<Member, String> startMembershipDate = new TableColumn<>("Start Membership Date");
        startMembershipDate.setCellValueFactory(new PropertyValueFactory<Member, String>("startMembershipDate"));
        startMembershipDate.setPrefWidth(132);

        // Health Information column
        TableColumn<Member, String> healthInfo = new TableColumn<>("Health Information");
        healthInfo.setCellValueFactory(new PropertyValueFactory<Member, String>("healthInfo"));
        healthInfo.setPrefWidth(132);

        // Age column
        TableColumn<Member, Integer> age = new TableColumn<>("Age");
        age.setCellValueFactory(new PropertyValueFactory<Member, Integer>("age"));
        age.setPrefWidth(52);

        // School Name column
        TableColumn<Member, String> schoolName = new TableColumn<>("School Name");
        schoolName.setCellValueFactory(new PropertyValueFactory<Member, String>("schoolName"));
        schoolName.setPrefWidth(112);

        // Grade Column
        TableColumn<Member, String> grade = new TableColumn<>("Grade");
        grade.setCellValueFactory(new PropertyValueFactory<Member, String>("grade"));
        grade.setPrefWidth(132);

        table = new TableView<>();
        table.setPrefWidth(1190);
        table.setPrefHeight(450);

        table.setItems(manager.loadTable());
        table.getColumns().addAll(memberShipNo, name, gender, nationalID, contactNumber, startMembershipDate, healthInfo, age, schoolName, grade);

        tableSection.getChildren().addAll(table);
        inputSection.getChildren().addAll(searchByLabel, searchLabel, searchTextField, searchButton, closeButton);
        addMemberPane.getChildren().addAll(newMemberTitle,inputSection, tableSection);
        addMemberScene.getStylesheets().add("com/company/style/style.css");
        addMember.setResizable(false);
        addMember.setScene(addMemberScene);
        addMember.show();
    }

}
