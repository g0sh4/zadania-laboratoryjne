import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Comparator {
    private String pathName1;
    private String pathName2;
    List<String> filesList1 = new ArrayList<>();
    List<String> filesList2 = new ArrayList<>();
    List<Integer> fileCounter = new ArrayList<>();
    private int couter;
    List<String> pathList1 = new ArrayList<>();
    List<String> pathList2 = new ArrayList<>();
    Map<String, String> dictionary1 = new HashMap<>();
    Map<String, String> dictionary2 = new HashMap<>();
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");


    List<String> matchingComment1 = new ArrayList<>();
    List<String> matchingComment2 = new ArrayList<>();

    public Comparator(String path1, String path2){
        pathName1=path1;
        pathName2=path2;
    }

    public void listFiles(){
        try{
            File file1 = new File(pathName1);

            for(String file: file1.list()){
                filesList1.add(file);
            }
            for(File file:file1.listFiles()){
                pathList1.add(String.valueOf(file));
            }
            for(int i =0;i<filesList1.size();i++){
                dictionary1.put(filesList1.get(i), pathList1.get(i));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            File file2 = new File(pathName2);

            for(String file: file2.list()){
                filesList2.add(file);
            }
            for(File file:file2.listFiles()){
                pathList2.add(String.valueOf(file));
            }
            for(int i =0;i<filesList2.size();i++){
                dictionary2.put(filesList2.get(i), pathList2.get(i));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public List<String> getFilesList1() {
        return filesList1;
    }

    public List<String> getFilesList2() {
        return filesList2;
    }

    public void compareFiles(){
        String tempName="";
        for(int i=0;i<filesList1.size();i++){
            if(filesList2.contains(filesList1.get(i))){
                tempName = filesList1.get(i);
                matchingComment1.add("File from the first catalog: " + tempName +" [modification date: " +sdf.format(new File(dictionary1.get(tempName)).lastModified()) +"]"+ " [size in bytes: "+new File(dictionary1.get(tempName)).length()+" ]"  );
                matchingComment2.add("File from the second catalog: " + tempName +" [modification date: " +sdf.format(new File(dictionary2.get(tempName)).lastModified()) +"]"+ " [size in bytes: "+new File(dictionary2.get(tempName)).length()+" ]"  );

                couter++;
            }
        }
    }

    public int getCouter() {
        return couter;
    }

    public String getMatchingComment1(int i) {
        return matchingComment1.get(i);
    }

    public String getMatchingComment2(int i) {
        return matchingComment2.get(i);
    }

    public Integer notMatchingFiles(int i){
        fileCounter.add(getFilesList1().size() - couter);
        fileCounter.add(getFilesList2().size() - couter);
        return fileCounter.get(i);
    }



}
