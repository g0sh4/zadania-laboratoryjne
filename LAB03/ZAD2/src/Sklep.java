import java.text.DecimalFormat;
import java.util.*;
public class Sklep {



    public static void main(String[] args){
        /*
        tworzymy liste produktow dostepnych w sklepie i ją wypisujemy
         */
        List<Produkt> listaProduktow = new ArrayList<>();
        listaProduktow = Produkt.setListeProduktow();
        Produkt.getListaProduktow();

        /*
        tworzymy listę klientów będących w sklepie
         */
        List<Klient>listaKlientow = new ArrayList<>();
        listaKlientow = Klient.setListeKlientow();
        //Klient.getListaKlientow();

        /*
        klienci ustwiają się losowo w kolejkę
         */
        Queue<Klient> kolejkaKlientow = new LinkedList<>();
        kolejkaKlientow = Klient.setKolejka(listaKlientow);

        /**
         * rachunekDoZaplaty - przechowywac bedzie sume wartosci poszczegolnych typow produktow - finalny rachunek
         * wagaKoszyka - lączna waga produktów w koszyku
         */
        double rachunekDoZaplaty = 0;
        double wagaKoszyka = 0;

        DecimalFormat df = new DecimalFormat("####0.00");

        /*
        w tym miejscu program dokonuje symulacji obslugi przy kasie - obsługuje kolejkę klientów, sumuje wartość produktów w koszyku i wagę łączną koszyka
         */
        for(Klient k: kolejkaKlientow){
            System.out.println("Lista zakupów dla: "+ k.getImieKlienta()+" "+k.getNazwiskoKienta()+" "+k.getKoszyk());
            if(k.getKoszyk().isEmpty()==false){
                for(ProduktyWKoszyku produkt: k.getKoszyk()){
                    rachunekDoZaplaty = rachunekDoZaplaty + produkt.getRachunekDoZaplaty();
                    wagaKoszyka = wagaKoszyka + produkt.getWagaPoduktow();
                }


                System.out.println("Rachunek: " + df.format(rachunekDoZaplaty)+" zl.");
                System.out.println("Waga koszyka: "+ df.format(wagaKoszyka)+" kg. ");
            }
            else{
                System.out.println("Koszyk klienta jest pusty.");
            }
            rachunekDoZaplaty=0;
            wagaKoszyka = 0;
        }


    }

}

