import java.util.Scanner;

/**
 the class allows to add palindromes to a file;
 if q is given, program ends adding to a file
 */
public class AddPalindrome {

    public static void main(String[] args) throws Exception {
        Scanner myObj = new Scanner(System.in);
        String palindrome;

        System.out.println("Type q to break.");
        while(true) {
            System.out.println("Enter palindrome: ");
            palindrome = myObj.nextLine();

            if (palindrome.equals("q")) break;

            Palindrome p = new Palindrome(palindrome);
            WritePalindrome writePalindrome = new WritePalindrome(p);
            writePalindrome.saveToFile("palindrome.plr");
            writePalindrome.saveToFile("palindrome.txt");

        }
        //Palindrome p1 = new Palindrome("kobyłamamałybok");
        //Palindrome p2 = new Palindrome("kobyła ma mały bok!");
        //Palindrome p3 = new Palindrome("elf układał kufle");

        //new WritePalindrome(p1,"palindrome.txt");
        //new WritePalindrome(p2,"palindrome.txt");
        //new WritePalindrome(p3,"palindrome.txt");
        //new WritePalindrome(p1).saveToFile("palindrome.plr");;
        //WritePalindrome palindrome = new WritePalindrome(p1);
        //WritePalindrome palindrome2 = new WritePalindrome(p2);
        //WritePalindrome palindrome3 = new WritePalindrome(p3);
        //palindrome.saveToFile("palindrome.plr");
        //palindrome2.saveToFile("palindrome.plr");
        //palindrome3.saveToFile("palindrome.plr");


    }
}
