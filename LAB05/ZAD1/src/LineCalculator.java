import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LineCalculator {

    public static void main(String[] args) {


        if(args.length>1){
            String pathName = args[0];

            List<String> fileExtensionNamesList = new ArrayList<>();
            for(int i=1;i< args.length;i++){
                fileExtensionNamesList.add(args[i]);
            }
            try{
                Analyzer analyzer = new Analyzer(pathName, fileExtensionNamesList);
                System.out.println("Number of files analyzed: "+ analyzer.analyzerWithSubcatalogs(pathName));
                System.out.println("Summed up number of lines in analyzed files:  "+analyzer.sumLines());
            } catch (IOException ioException){
                ioException.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }

        }
        else{
            System.out.println("Too few arguments were given.");
        }
    }
}
