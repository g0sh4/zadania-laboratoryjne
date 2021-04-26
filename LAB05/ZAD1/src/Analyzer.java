import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static java.util.Objects.*;

/**
 * summing up the number of lines from each file (with given extension)
 */
public class Analyzer {
        /**
         * pathName -  stores the directory path
         * fileExtensionNameList - stores extensions names
         * nameOfFilesWithSpecifiedExtension - stores specific values
         * lineNumber - number of lines
         * filesCounter - number of files handled
         */
        private String pathName;
        private List<String> fileExtensionNamesList = new ArrayList<>();
        private List<String> nameOfFilesWithSpecifiedExtension = new ArrayList<>();
        private int linesNumber;
        private int filesCounter;

        public Analyzer(String path, List<String> extensions){
            pathName=path;
            fileExtensionNamesList=extensions;
        }

        public String getPathName() {
            return pathName;
        }

        public int getLinesNumber() {
            return linesNumber;
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


    /**
     * analyzerWithSubcatalogs - to get informetion about files in catalog and its subcatalogs
     * @param pathName - stores the directory path
     * @return - filesCounter - handled files
     */
        public int analyzerWithSubcatalogs(String pathName){
            try{
                File file = new File(pathName);

                for(File files: requireNonNull(file.listFiles())){

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

    /**
     * sumLines() - sums the lines of the files found
     * @return - the number of lines in all files
     * @throws FileNotFoundException
     */
    public int sumLines() throws FileNotFoundException {

            try{

                for(int i=0; i<nameOfFilesWithSpecifiedExtension.size();i++){

                    File file = new File(nameOfFilesWithSpecifiedExtension.get(i));
                    Scanner scanner = new Scanner(file);
                    while(scanner.hasNextLine()){
                        scanner.nextLine();
                        linesNumber++;
                    }
                }

            }catch (FileNotFoundException exception){
                exception.getStackTrace();
            }
        return linesNumber;
        }
}
