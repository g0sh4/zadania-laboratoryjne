import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileAnalyzer {
    public String pathName;
    private List<String> fileNamesList = new ArrayList<>();
    private int subfoldersNumber;
    private int filenumber;

    public FileAnalyzer(String path){
        pathName = path;
    }
    public int analyzerWithSubfolders(String pathName){
        try{
            File file = new File(pathName);
            for(File files: file.listFiles()){
                if(files.isDirectory()){
                    analyzerWithSubfolders(String.valueOf(files));
                    subfoldersNumber++;
                }else{
                    filenumber++;
                }
            }
        }catch (Exception e){
            e.getMessage();
        }

        return 0;
    }

    public int getSubfoldersNumber() {
        return subfoldersNumber;
    }
    public int getFilenumber(){
        return filenumber;
    }
}



