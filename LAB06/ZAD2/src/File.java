import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class File {

    List<List<String>> allRecords;


    private String[] analyseLine(String tableRow){
        List<String> line = new ArrayList<String>();

        char[] chars = tableRow.toCharArray();
        boolean cite = false;

        StringBuilder nCell = new StringBuilder();

        for(char charInChars : chars){
            switch (charInChars){
                case (char)59:
                case (char)44:

                    if(!cite){
                        String cell = nCell.toString();
                        nCell = new StringBuilder();
                        line.add(cell);
                    }else{
                        nCell.append(charInChars);
                    }
                    break;
                case (char) 39:
                case (char) 34:
                    cite= !cite;
                    break;
                default:
                    nCell.append(charInChars);
                    break;
            }
        }
        return line.toArray(new String[0]);
    }
    public void readCSV(String fileName) {
        try{
            allRecords = new ArrayList<>();
            BufferedReader csvFileReader = new BufferedReader(new FileReader(fileName));

            String readLine;

            while((readLine = csvFileReader.readLine())!=null){
               String [] data = analyseLine(readLine);
               allRecords.add(Arrays.asList(data));

            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }
    public List<String> getColumnNames(){
        return allRecords.get(0);
    }
    public List<List<String>> getAllRecords() {
        List<List<String>> records =  new ArrayList<>();
        for(int i=0;i<(allRecords.size()-1);i++){
            records.add(allRecords.get(i+1));
        }
        return records;
    }

}
