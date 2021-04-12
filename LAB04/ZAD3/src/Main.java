/*
Napisz program, który prosi użytkownika o podanie trzech danych:
(1) nazwy parametru (klucza),
(2) typu (do wyboru z: String, int, double, boolean),
(3) jego wartości.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        Properties properties = new Properties();

        System.out.println("To stop entering type: q as a key.");
        boolean running = true;

        /**
         * list to store available data types
         */
        List list = new ArrayList();
        list.add("String");
        list.add("int");
        list.add("double");
        list.add("boolean");

        System.out.println("Values available: String/double/int/boolean.\n");
        /**
         * main loop to set properties together and to save them to file
         */
        while(running){
            System.out.println("Type key: ");
            String keyValue = scanner.nextLine();
            if(keyValue.equals("q")){
                break;
            }

            System.out.println("Type the type of your value : ");
            String typeValue = scanner.nextLine();
            if(!list.contains(typeValue)){
                System.out.println("Wrong value name. ");
                continue;
            }

            System.out.println("Type value (to your key): ");
            String valueValue = scanner.nextLine();

            try{
                if(typeValue.equals("double")){
                    double newValue = Double.parseDouble(valueValue);
                    //System.out.println("to double");
                    properties.setProperty(keyValue, valueValue);

                }
                if(typeValue.equals("int")){
                    int newValue = Integer.parseInt(valueValue);
                    //System.out.println("to int");
                    properties.setProperty(keyValue, valueValue);

                }
                if(typeValue.equals("boolean")){

                    //System.out.println("to boolean");
                    if(valueValue.equals("true")){
                        properties.setProperty(keyValue, valueValue);
                    }
                    else if(valueValue.equals("false")){
                        properties.setProperty(keyValue, valueValue);
                    }
                    else {
                        System.out.println("Wrong value given.");
                        continue;
                    }
                    boolean newValue = Boolean.parseBoolean(valueValue);
                }
                if(typeValue.equals("String")){
                    properties.setProperty(keyValue, valueValue);

                }
                properties.store(new FileWriter("prop.properties"),"Properties stored");
            }catch(Exception e){
                System.out.println("Parsing failed.");
            }

            //properties.store(new FileWriter("prop.properties"),"Properties stored");



        }
    }


}
