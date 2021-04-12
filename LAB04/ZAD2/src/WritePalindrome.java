import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple class to write a palindrome into the file.
 */
public class WritePalindrome {
    /**
     * Writes the given palindrome into the given file.
     */
    private Palindrome palindrome;
    public WritePalindrome(Palindrome pal) {
        setPalindrome(pal);

    }
    public void setPalindrome(Palindrome pal){
        palindrome = pal;
    }
    public Palindrome getPalindrome(){
        return palindrome;
    }

    public void saveToFile(String fileName) throws Exception {
        if(getPalindrome()!=null){
            File file = new File(fileName);
            List<Palindrome> palindromeList = new ArrayList<>();

            if(file.exists()){
                FileInputStream fileInputStream = new FileInputStream(file);
                try{
                    ObjectInputStream stream = new ObjectInputStream(fileInputStream);
                    Object palindromeObject = new Object();

                    while((palindromeObject = stream.readObject()) != null){

                        if(palindromeObject instanceof Palindrome){
                            palindromeList.add((Palindrome) palindromeObject);
                        } else{
                            System.out.println("Nieprawidłowy obiekt w pliku.");
                        }
                        //System.out.println("Zapisano do pliku.");
                    }
                    fileInputStream.close();
                }catch (EOFException err){
                    fileInputStream.close();
                }


            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            for(Palindrome palindrome: palindromeList){
                objectOutputStream.writeObject(palindrome);
            }
            objectOutputStream.writeObject(getPalindrome());
            objectOutputStream.close();
        }else{
            throw new Exception("Nie wczytano żadnego palindromu.");
        }
    }

    /**
     * Tests the class.
     * @param args not used.
     */
    public static void main(String[] args) throws Exception {

		/*
		sekcja testowa
		 */

        Palindrome p1 = new Palindrome("kobyłamamałybok");
        Palindrome p2 = new Palindrome("kobyła ma mały bok!");
        Palindrome p3 = new Palindrome("elf układał kufle");

        //new WritePalindrome(p1,"palindrome.txt");
        //new WritePalindrome(p2,"palindrome.txt");
        //new WritePalindrome(p3,"palindrome.txt");
        //new WritePalindrome(p1).saveToFile("palindrome.plr");;
        WritePalindrome palindrome = new WritePalindrome(p1);
        WritePalindrome palindrome2 = new WritePalindrome(p2);
        WritePalindrome palindrome3 = new WritePalindrome(p3);
        palindrome.saveToFile("palindrome.plr");
        palindrome2.saveToFile("palindrome.plr");
        palindrome3.saveToFile("palindrome.plr");
        palindrome.saveToFile("palindrome.txt");
        palindrome2.saveToFile("palindrome.txt");
        palindrome3.saveToFile("palindrome.txt");


    }
}
