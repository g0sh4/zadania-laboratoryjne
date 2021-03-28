import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Zadanie1 {

    public static void input(Scanner input, Map inputmap){
        String username = "";
        String password = "";

        boolean running = true;

        while(running){
            System.out.println("Enter username: ");
            username = input.nextLine();

            if (username.equals("q")) {
                break;
            }

            System.out.println("Enter password: ");
            password = input.nextLine();

            inputmap.put(username, password);
        }
    }

    public static void getPassword(Scanner input, Map inputmap){
        System.out.println("\n\nEnter the name of the user whose password you want to get: ");
        String enteredName = input.nextLine();
        if(inputmap.get(enteredName)==null){
            System.out.println("There is no such a user.");
        }
        else{
            System.out.println(enteredName +"'s password: "+ inputmap.get(enteredName));
        }
    }

    public static void getUsers(Map map){
        System.out.println("\nUSERS: ");
        map.forEach((k,v) -> System.out.print(k+" / "));
    }

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        Map<String, String> data = new HashMap<>();

        input(input,data);
        getUsers(data);
        getPassword(input,data);


    }



}
