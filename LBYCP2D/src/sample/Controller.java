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
import java.util.Arrays;

public class Controller {

    String directory = new String("");

    TakeFilesFromProject getfiles = new TakeFilesFromProject("");

    private ArrayList<File> prelim = new ArrayList<File>();
    private ArrayList<ArrayList<File>> foldername = new ArrayList<ArrayList<File>>();
    private ArrayList<File> folderfiles = new ArrayList<File>();
    int count = 0;

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
        ArrayList<File> FolderNames = getfiles.getFolders();

        listFiles(file);

        AlgorithmClass test = new AlgorithmClass();

        for (int i =0; i < FolderNames.size(); i++){
            matrixdisplay.add(new Label(FolderNames.get(i).getName()),0,i+1);
            matrixdisplay.add(new Label(FolderNames.get(i).getName()),i+1,0);
        }

        for (int i = 0; i < FolderNames.size(); i++){
            for (int j = 0; j < FolderNames.size(); j++){
                DecimalFormat df = new DecimalFormat("0.00");
                matrixdisplay.add(new Label(String.valueOf(df.format((test.takeStrings(FolderNames,i,j))))),i+1,j+1);
            }
        }
    }

    private void listFiles(File folder) {
        //this is will add file in the prelimFiles


        for ( File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFiles(fileEntry);
                folderfiles.add(fileEntry);
                //System.out.println(fileEntry.getName());
            } else {
                prelim.add(fileEntry);
            }
        }
    }
}

