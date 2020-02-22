package sample;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

public class AlgorithmClass {



    AlgorithmClass() {

    }

    File[] FileOrFolder(File file, int AllFilesCounter, File[] AllFiles){
        File[] File = file.listFiles();
        for (int q = 0; q < File.length; q++){
            if (File[q].isDirectory()){
                FileOrFolder(File[q], AllFilesCounter, AllFiles);
            }
            else {
                if (File[q].getName().endsWith(".cc") || File[q].getName().endsWith(".cpp") || File[q].getName().endsWith(".h") || File[q].getName().endsWith(".java") || File[q].getName().endsWith(".h")){
                    AllFiles[AllFilesCounter] = File[q];
                    AllFilesCounter++;
                }
            }
        }
        return AllFiles;
    }

    File[] FileOrFolder2(File file, int AllFilesCounter2, File[] AllFiles2){
        File[] File2 = file.listFiles();
        for (int q = 0; q < File2.length; q++){
            if (File2[q].isDirectory()){
                FileOrFolder2(File2[q], AllFilesCounter2, AllFiles2);
            }
            else {
                if (File2[q].getName().endsWith(".cc") || File2[q].getName().endsWith(".cpp") || File2[q].getName().endsWith(".h") || File2[q].getName().endsWith(".java") || File2[q].getName().endsWith(".h")){
                    AllFiles2[AllFilesCounter2] = File2[q];
                    AllFilesCounter2++;
                }
            }
        }
        return AllFiles2;
    }

    double takeStrings(ArrayList<File> FileNames, int i, int j) {

        int AllFilesCounter = 0;
        int AllFilesCounter2 = 0;
        File[] AllFiles = new File[1000];
        File[] AllFiles2 = new File[1000];
        String[] Filecontent = new String[1000000];
        String[] Filecontent1 = new String[1000000];

        int count1 = 0;

        if(FileNames.get(i).isDirectory()){
            File[] FileCheck1 = FileOrFolder(FileNames.get(i), AllFilesCounter, AllFiles);
            for (int q = 0; q < FileCheck1.length; q++){
                if (FileCheck1[q] == null){
                    continue;
                }
                try {
                    List<String> allLines = Files.readAllLines(Paths.get(FileCheck1[q].getAbsolutePath()));
                    for (String line : allLines) {
                        Filecontent[count1] = line;
                        count1++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        int count2 = 0;

        if(FileNames.get(j).isDirectory()){
            File[] FileCheck2 = FileOrFolder2(FileNames.get(j),AllFilesCounter2, AllFiles2);
            for (int q = 0; q < FileCheck2.length; q++){
                if (FileCheck2[q] == null){
                    continue;
                }
                try {
                    List<String> allLines = Files.readAllLines(Paths.get(FileCheck2[q].getAbsolutePath()));
                    for (String line : allLines) {
                        Filecontent1[count2] = line;
                        count2++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return comparison(Filecontent, Filecontent1, count1, count2);
    }

    double comparison(String[] String1, String[] String2, int count1, int count2){

        double equalcounter=0;
        double notequalcounter=0;
        double similarity=0;

        int length=0;
        if (count1 > count2) {
            length = count1;
        }
        else if (count2 > count1) {
            length = count2;
        }
        else if (count1 == count2){
            length = count1;
        }

        for (int counter = 0; counter < length; counter++){
            double g = equalcounter;

            if (String1[counter] == null){
                continue;
            }

            for (int counter2 = 0; counter2 < length; counter2++){
                if (String1[counter].equalsIgnoreCase(String2[counter2])){
                    equalcounter++;
                    break;
                }
            }
            if (g == equalcounter){
                notequalcounter++;
            }
        }

        double total = equalcounter + notequalcounter;

        similarity = equalcounter / total * 100;

        return similarity;
    }


}
