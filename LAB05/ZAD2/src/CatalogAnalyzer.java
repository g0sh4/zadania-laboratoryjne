public class CatalogAnalyzer {
    public static void main(String[] args){

        if(args.length==2){
            try{
                Comparator comparator = new Comparator(args[0], args[1]);

                comparator.listFiles();
                comparator.compareFiles();
                if(comparator.getFilesList1().size()==0){
                    System.out.println("No files in catalog 1.");
                }else if(comparator.getFilesList2().size()==0){
                    System.out.println("No files in catalog 2");
                }
                for(int i = 0; i<comparator.getCounter(); i++){
                    System.out.println(comparator.getMatchingComment1(i));
                    System.out.println(comparator.getMatchingComment2(i)+"\n");
                }

                System.out.println("Number of not matching files (including catalog files) from catalog 1: " + comparator.notMatchingFiles(0) );
                System.out.println("Number of not matching files (including catalog files) from catalog 2: " + comparator.notMatchingFiles(1) );
            }catch (Exception err){
                err.getMessage();
            }

        }else {
            System.out.println("Too few arguments were given.");
        }
    }
}
