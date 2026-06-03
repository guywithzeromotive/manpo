package com.zero.manpo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(setupPage(), 700, 500);
        stage.setTitle("ManPo");
        stage.setScene(scene);
        stage.show();
    }

    private Parent setupPage(){
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(30));
        GridPane gridPane = new GridPane();

        gridPane.setPadding( new Insets(10) );
        gridPane.setHgap( 4 );
        gridPane.setVgap( 8 );

        VBox.setVgrow(gridPane, Priority.ALWAYS );

        Label formLabel = new Label("ManPo");

        Label projNameLabel = new Label("Name");
        TextField projNameInput = new TextField();

        Label projStatusLabel = new Label("Status");
        ObservableList<String> projStatuses = FXCollections.observableArrayList("Completed", "Ongoing", "Planned");
        ComboBox<String> projStatusComboBox = new ComboBox<>(projStatuses);

        Label projTypeLabel = new Label("Type");
        ToggleGroup projTypeToggleGroup = new ToggleGroup();
        RadioButton publicType = new RadioButton("Public");
        RadioButton privateType = new RadioButton("Proprietary");

        publicType.setToggleGroup(projTypeToggleGroup);
        privateType.setToggleGroup(projTypeToggleGroup);

        publicType.setSelected(true);

        HBox projTypeContainer = new HBox();
        projTypeContainer.setSpacing(3d);

        projTypeContainer.getChildren().add(publicType);
        projTypeContainer.getChildren().add(privateType);

        Label projRepoLabel = new Label("Repo Link");
        TextField projRepoInput = new TextField();

        Label projDescriptionLabel = new Label("Description");
        TextArea projDescriptionInput = new TextArea();

        Label projDeepDiveLabel = new Label("Deep Dive");
        TextArea projDeepDiveInput = new TextArea();

        Label projImageLabel = new Label("Image");

        HBox projImageUploadContainer = new HBox();
        Label browseImageLabel = new Label("Browse Images ....");
        Button uploadImageBtn = new Button("Upload Image");

        projImageUploadContainer.getChildren().add(browseImageLabel);
        projImageUploadContainer.getChildren().add(uploadImageBtn);


        gridPane.add(formLabel, 1, 1);
        gridPane.add(projNameLabel, 0, 2); gridPane.add(projNameInput, 1, 2);
        gridPane.add(projStatusLabel, 0, 3); gridPane.add(projStatusComboBox, 1, 3);
        gridPane.add(projTypeLabel, 0, 4); gridPane.add(projTypeContainer, 1, 4);
        gridPane.add(projRepoLabel, 0, 5); gridPane.add(projRepoInput, 1, 5);
        gridPane.add(projDescriptionLabel, 0, 6); gridPane.add(projDescriptionInput, 1, 6);
        gridPane.add(projDeepDiveLabel, 0, 7); gridPane.add(projDeepDiveInput, 1, 7);
        gridPane.add(projImageLabel, 0, 8); gridPane.add(projImageUploadContainer, 1, 8);


        Separator sp = new Separator();

        ButtonBar btnBar = new ButtonBar();

        Button submitProjBtn = new Button("Submit");
        Button clearFormBtn = new Button("Clear Form");

        btnBar.getButtons().addAll(submitProjBtn, clearFormBtn);

        vbox.getChildren().addAll(gridPane, sp, btnBar);

        return vbox;
    }
}
