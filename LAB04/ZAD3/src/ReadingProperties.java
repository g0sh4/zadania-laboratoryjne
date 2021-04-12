
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class ReadingProperties {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("prop.properties");
        Properties properties = new Properties();
        properties.load(reader);

        /**
         * print all available keys
         */
        System.out.print("Keys: ");
        for(Object key: properties.keySet()){
            System.out.print(key+" ");
        }
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("\nEnter key: ");
            String key = scanner.nextLine();
            if(key.equals("q")){
                break;
            }
            if(properties.getProperty(key)==null){
                System.out.println("Given key doesn't have a value/doesn't exist.");
            }
            else {
                System.out.println("The value for: "+key+ " is: "+properties.getProperty(key));
            }

        }

    }

}
