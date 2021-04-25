import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * summing up the number of lines from each file (with given extension)
 */
public class Analyzer {

    private String pathName;
    private List<String> fileExtensionNamesList = new ArrayList<>();
    private List<String> nameOfFilesWithSpecifiedExtension = new ArrayList<>();
    private int linesNumer;
    private int filesCounter;



    public Analyzer(String path, List extensions){
        pathName=path;
        fileExtensionNamesList=extensions;
    }

    public String getPathName() {
        return pathName;
    }

    public int getLinesNumer() {
        return linesNumer;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public int getFilesCounter() {
        return filesCounter;
    }

    public List<String> getFileExtensionNamesList() {
        return fileExtensionNamesList;
    }

    public void setFileExtensionNamesList(List<String> fileExtensionNamesList) {
        this.fileExtensionNamesList = fileExtensionNamesList;
    }

    public List<String> getNameOfFilesWithSpecifiedExtension() {
        return nameOfFilesWithSpecifiedExtension;
    }



    public int analyzerWithSubcatalogs(String pathName){
        try{
            File file = new File(pathName);
            String newPath;

            for(File files: file.listFiles()){

                if(files.isDirectory()){
                    analyzerWithSubcatalogs(String.valueOf(files));
                }else{
                    for(int i=0; i<fileExtensionNamesList.size();i++){
                        if(files.getAbsolutePath().endsWith(fileExtensionNamesList.get(i))){
                            nameOfFilesWithSpecifiedExtension.add(files.getAbsolutePath());
                            filesCounter++;
                        }
                    }
                }
            }


        }catch (Exception e){
            System.out.println("SOMETHING WENT WRONG. (Probably wrong path was given)");
        }
        return filesCounter;
    }

    public int sumLines() throws FileNotFoundException {

        try{

            for(int i=0; i<nameOfFilesWithSpecifiedExtension.size();i++){

                File file = new File(nameOfFilesWithSpecifiedExtension.get(i));
                Scanner scanner = new Scanner(file);
                while(scanner.hasNextLine()){
                    scanner.nextLine();
                    linesNumer++;
                }
            }

        }catch (FileNotFoundException exception){
            exception.getStackTrace();
        }
    return linesNumer;
    }
}
