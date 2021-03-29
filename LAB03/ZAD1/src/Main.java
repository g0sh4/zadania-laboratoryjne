import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    /**
     *
     * @param input - Scanner input - enables to collect the information given  by the user (password, username)
     * @param inputmap - saves information given by the user
     */
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

    /**
     *
     * @param input - Scanner input - enables to collect the information given  by the user (username)
     * @param inputmap - collection of data given in input()
     */
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

    /**
     *
     * @param map - collection of data given by the user in input()
     * gives us a complete list of users
     */
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
