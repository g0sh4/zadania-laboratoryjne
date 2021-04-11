import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class KonwerterWierszKolumna {

    /**
     * wierszeDanych - przechowuje odczytane dane
     */
    List<String> wierszeDanych = new ArrayList<>();

    /**
     *
     * @param nazwaPliku - nazwa pliku z danymi wejściowymi
     *  odczytDanych pozwala na odczytanie danych z pliku
     */
    public void odczytDanych(String nazwaPliku){

        try{
            File plik = new File(nazwaPliku);
            Scanner scan = new Scanner(plik);

            while(scan.hasNextLine()){
                String wiersz = scan.nextLine();
                String[] noweDane;

                noweDane = wiersz.split(" ");

                for(String linijka: noweDane){
                    if("" != linijka){
                        wierszeDanych.add(linijka);
                    }
                }
            }

        }
        catch(FileNotFoundException o){
            System.out.println("Nie odnaleziono pliku o takiej nazwie.");
        }
    }

    /**
     * zapisDanych - umożliwia zapis w postaci kolumny odczytanego wcześniej wiersza
     * @param nazwaPliku - nazwa pliku w którym zostaną zapisane dane wyjściowe
     */
    public void zapisDanych(String nazwaPliku){
        try{
            File plik = new File(nazwaPliku);
            if(plik.createNewFile()){
                System.out.println("Plik o nazwie "+nazwaPliku+" nie istniał.\nUtworzono nowy plik o tej nazwie.");
            }
            FileWriter zapis = new FileWriter(nazwaPliku);


            for(int i=0; i< wierszeDanych.size(); i++){
                String znak = wierszeDanych.get(i);
                if(!znak.equals("")){
                    zapis.write(wierszeDanych.get(i)+"\n");
                }
            }
            zapis.close();

        }
        catch(IOException e){
            System.out.println("Błąd zapisu.");
        }
    }

    @Override
    public String toString() {
        return "wiersz danych odczytany z pliku = " + wierszeDanych ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KonwerterWierszKolumna)) return false;
        KonwerterWierszKolumna konwerter = (KonwerterWierszKolumna) o;
        return wierszeDanych.equals(konwerter.wierszeDanych);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wierszeDanych);
    }
    public String getValue(int index){
        return "wartosc na pozycji "+ (index+1)+": "+ wierszeDanych.get(index);
    }


    public static void main(String[] args){
        //w konsoli Konwerter3 plikDoOdczytu.txt plikDoZapisu.txt numerPozycjiDoOdczytu

        if(args.length==3){
            KonwerterWierszKolumna plik = new KonwerterWierszKolumna();
            plik.odczytDanych(args[0]);
            plik.zapisDanych(args[1]);
            System.out.println(plik.toString());
            try {
                int indeks = Integer.parseInt(args[2]);
                System.out.println(plik.getValue(indeks - 1));
            }catch (NumberFormatException numberFormatException){
                System.err.println("Podana dana nie jest formatu int.");
            }

        }
        else{
            System.out.println("Podano nieprawidłową ilość argumentow wywołania programu.");
        }
    }
}