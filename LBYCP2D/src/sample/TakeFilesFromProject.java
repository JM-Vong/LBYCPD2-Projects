package sample;

import java.io.File;
import java.util.ArrayList;

public class TakeFilesFromProject {

    private String filepath;
    private File dir;
    private ArrayList<File> prelim;
    private ArrayList<File> accepted;

    public TakeFilesFromProject(String projectFilepath){
        this.filepath = projectFilepath;
        dir = new File(projectFilepath);
        prelim = new ArrayList<>();
        accepted = new ArrayList<>();
    }

    private void listFiles(File folder) {
        //this is will add file in the prelimFiles


        for ( File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFiles(fileEntry);
            } else {
                prelim.add(fileEntry);
            }
        }
    }

    public ArrayList<File> getFiles(){

        listFiles(dir);


        for (File f: prelim) {

            if(fileExtensionAccept(f.getName())){
                accepted.add(f);
            }
        }

        return accepted;
    }

    private boolean fileExtensionAccept(String filename){

        return (filename.endsWith(".cc") || filename.endsWith(".cpp") || filename.endsWith(".java") ||
                filename.endsWith("Test.java") || filename.endsWith(".c")) && (!filename.endsWith(".h"));

    }


}


