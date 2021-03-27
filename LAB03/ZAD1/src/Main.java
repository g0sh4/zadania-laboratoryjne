
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;



public class Main {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        Map<String, String> data = new HashMap<String, String>();

        String username = "";
        String password = "";

        boolean running = true;

        while(running){
            System.out.print("Enter username: ");
            username = input.nextLine();

            if (username.equals("q")) {
                break;
            }

            System.out.print("Enter password: ");
            password = input.nextLine();


            data.put(username, password);
        }


        System.out.println("\nUSERS: ");

        for(Map.Entry<String, String> entry : data.entrySet()){
            String key = entry.getKey();
            System.out.print(key+" / ");
        }



        System.out.println("\n\nEnter the name of the user whose password you want to get: ");
        String enteredName = input.nextLine();



        if(data.get(enteredName)==null){
            System.out.println("There is no such a user.");
        }
        else{
            System.out.println(enteredName +"'s password: "+ data.get(enteredName));
        }
    }




}