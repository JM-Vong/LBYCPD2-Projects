package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Controller {

    String directory = new String("");

    TakeFilesFromProject getfiles = new TakeFilesFromProject("");

    @FXML
    private TextField textbox;

    @FXML
    private AnchorPane anchorid;

    @FXML
    private GridPane matrixdisplay;

    @FXML
    void browsePressed(ActionEvent event) {

        final DirectoryChooser dirchooser = new DirectoryChooser();

        Stage stage = (Stage) anchorid.getScene().getWindow();

        File file1 = dirchooser.showDialog(stage);

        if (file1 != null) {

            System.out.println("Path: " + file1.getAbsolutePath());
            textbox.setText(file1.getAbsolutePath());
            directory = file1.getAbsolutePath();
            getfiles = new TakeFilesFromProject(file1.getAbsolutePath());

        }

    }

    @FXML
    void showmatrix(ActionEvent event) {

        File file = new File(directory);
        ArrayList<File> FileNames = getfiles.getFiles();
        AlgorithmClass test = new AlgorithmClass();

        for (int i =0; i < FileNames.size(); i++){
            System.out.format("%15s ",FileNames.get(i).getName());
            matrixdisplay.add(new Label(FileNames.get(i).getName()),0,i+1);
            matrixdisplay.add(new Label(FileNames.get(i).getName()),i+1,0);
        }

        System.out.print("\n");

        for (int i = 0; i < FileNames.size(); i++){
            System.out.format("%16s", FileNames.get(i).getName());
            for (int j = 0; j < FileNames.size(); j++){
                System.out.format("%16.2f" ,test.comparison(FileNames,i,j));
                DecimalFormat df = new DecimalFormat("0.00");
                matrixdisplay.add(new Label(String.valueOf(df.format((test.comparison(FileNames, i, j))))),i+1,j+1);
            }
            System.out.print("\n");
        }
    }
}

