package sample;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

public class AlgorithmClass  {

    double equalcounter;
    double notequalcounter;
    double similarity;

    AlgorithmClass(){
        equalcounter = 0;
        notequalcounter = 0;
        similarity = 0;
    }

    double comparison(ArrayList<File> FileNames, int i, int j){

        equalcounter=0;
        notequalcounter=0;
        similarity=0;
        String[] Filecontent = new String[1000];
        String[] Filecontent1 = new String[1000];
        int count1 = 0;

        try {
            List<String> allLines = Files.readAllLines(Paths.get(FileNames.get(i).getAbsolutePath()));
            for (String line : allLines) {
                Filecontent[count1] = line;
                count1++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int count2 = 0;


        try {
            List<String> allLines = Files.readAllLines(Paths.get(FileNames.get(j).getAbsolutePath()));
            for (String line : allLines) {
                Filecontent1[count2] = line;
                count2++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

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
            if (Filecontent[counter] == " "){
                continue;
            }
            else if (Filecontent[counter] == null){
                continue;
            }
            for (int counter2 = 0; counter2 < length; counter2++){
                if (Filecontent[counter].equalsIgnoreCase(Filecontent1[counter2])){
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
