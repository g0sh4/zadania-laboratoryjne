import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Wczytywacz {

    static void czytanie1() throws IOException{
        int val = 0;
        while(val!= 'q'){
            System.out.println("Wpisz znak: ");
            val = System.in.read();
            System.out.println("Wpisałeś: [" +(char)val + "] (" + val + "), dostepnych znaków: " + System.in.available());
        }
    }

    static void czytanie2() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        do{
            System.out.println("Wpisz słowo: ");
            line = br.readLine();
            System.out.println("Wpisałeś: ["+line+"] ");
        }while (!line.isEmpty());


    }
    public static void main(String[] args) throws IOException{
        //czytanie1();
        czytanie2();
    }


}
