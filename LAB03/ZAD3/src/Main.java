import java.util.Scanner;

public class Main {
    public static void dzialanie(String znak, Zbiory zbior1, Zbiory zbior2){
        if(znak == "*"){
            Zbiory wynik = new Zbiory();
            wynik = zbior1.czescWspolna(zbior2);
            System.out.println(wynik.toString());

        }
        if(znak== "+"){
            Zbiory wynik = zbior1.sumaZbiorow(zbior2);
            System.out.println(wynik.toString());

        }
        if(znak== "-"){
            Zbiory wynik = zbior1.roznicaZbiorow(zbior2);
            System.out.println(wynik.toString());

        }
    }
    public static String znak(String input){
        String znak ="";
        znak = "";
        if(input.contains("*")){
             znak = "*";
        }
        if(input.contains("-")){
             znak = "-";
        }
        if(input.contains("+")){
             znak = "+";
        }

        return znak;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        input = scanner.nextLine();
        String znakDzialania = znak(input);



        String[] czesci = input.split("\\" + znakDzialania);

        String czesc1 = czesci[0];
        String czesc2 = czesci[1];


        Zbiory prawyZbior = new Zbiory(czesc1);
        Zbiory lewyZbior = new Zbiory(czesc2);

        dzialanie(znakDzialania, lewyZbior, prawyZbior);



    }
}
