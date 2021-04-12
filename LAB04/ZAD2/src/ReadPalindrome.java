import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * the class lists all palindromes, even if they repeat themselves
 */
public class ReadPalindrome {



    public ReadPalindrome( String fileName) throws IOException, ClassNotFoundException {

        ArrayList<Object> objectsList = new ArrayList<>();
        ObjectInputStream objectInputStream= new ObjectInputStream (new FileInputStream(fileName));
        while(true){
            try{
                Palindrome palindrome = (Palindrome) objectInputStream.readObject();
                objectsList.add(palindrome);
                objectsList.add(palindrome);
            }catch(EOFException eofException){
                break;
            }
        }
        for(int i=0; i<objectsList.size(); i++){
            System.out.println(objectsList.get(i));
        }


    }
    //public void czytaniePalindrowu(String nazwaPliku) throws IOException, ClassNotFoundException {
    // ArrayList<Object> objectsList = new ArrayList<>();
    //while(true){
    //ObjectInputStream objectInputStream= new ObjectInputStream (new FileInputStream(nazwaPliku));
    //try{
    //  Palindrome palindrome = (Palindrome) objectInputStream.readObject();
    //if(palindrome!=null){
    //  objectsList.add(palindrome);
    //}
    //for(int i=0; i<objectsList.size(); i++){
    //    System.out.println(objectsList.get(i));
    //}
    //}catch(EOFException eofException){
    //  break;
    //}
    //}
    //}

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ReadPalindrome readPalindrome = new ReadPalindrome("palindrome.plr");
    }
}
