import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * the class allows to list all palindromes (if one repeats, it only prints it once)
 */
public class Reading {

    private static Set<Palindrome> palindromeSet = new HashSet<>();

    public Reading( String fileName) throws IOException, ClassNotFoundException {

        ArrayList<Object> objectsList = new ArrayList<>();
        ObjectInputStream objectInputStream= new ObjectInputStream (new FileInputStream(fileName));
        while(true){
            try{
                Palindrome palindrome = (Palindrome) objectInputStream.readObject();
                objectsList.add(palindrome);
                palindromeSet.add(palindrome);
            }catch(EOFException eofException){
                break;
            }
        }
        for(int i=0; i<objectsList.size(); i++){
            //System.out.println(objectsList.get(i));
        }
        for(Palindrome x: palindromeSet){
            System.out.printf(x +"\n");
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
        Reading readPalindrome = new Reading("palindrome.plr");
    }
}
