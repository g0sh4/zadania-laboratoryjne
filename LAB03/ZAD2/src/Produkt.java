import java.util.*;

/**
 * klasa Produkt przechowuje i wykonuje operacje związane w produktem ( np. tworzy i zwraca informacje o jego cenie, nazwie, wadze)
 * tworzy też listę dostępnych produktow w sklepie i umożliwia na wypisanie tych wartości w konsoli
 */
public class Produkt {
    /**
     * nazwaProduktu - przechowuje nazwe
     * cenaProduktu - przechowuje cene
     * wagaProduktu - przechowuje wage
     */
    private String nazwaProduktu;
    private double cenaProduktu;
    private double wagaProduktu;

    /**
     *
     * @return nazwaProduktu - zwraca nazwe produktu
     */
    public String getNazwaProduktu() {
        return nazwaProduktu;
    }

    /**
     *
     * @return cenaProduktu - zwraca cene produktu
     */
    public double getCenaProduktu() {
        return cenaProduktu;
    }

    /**
     *
     * @return wagaProduktu - zwraca wage produktu
     */
    public double getWagaProduktu() {
        return wagaProduktu;
    }

    /**
     *
     * @param nazwa - nazwa produktu
     * @param cena - cena produktu
     * @param waga - waga produktu
     */
    public Produkt(String nazwa, double cena, double waga){
        nazwaProduktu = nazwa;
        cenaProduktu = cena;
        wagaProduktu = waga;
    }

    /**
     * setListeProduktow - tworzy liste produktów dostępnych w sklepie
     * @return - zwraca listę dostępnych produktów razem z ich waga, ceną i nazwą
     */
    public static List<Produkt> setListeProduktow(){
        List <Produkt> listaProduktowDostepnych = new ArrayList<>();
        listaProduktowDostepnych.add(new Produkt("banan", 2.50, 0.12));
        listaProduktowDostepnych.add(new Produkt("jabłko", 4.60, 0.3));
        listaProduktowDostepnych.add(new Produkt("kakao", 3.30, 0.35));
        listaProduktowDostepnych.add(new Produkt("mąka", 1.30, 1.0));
        listaProduktowDostepnych.add(new Produkt("woda", 2.20, 1.0));
        listaProduktowDostepnych.add(new Produkt("barszcz", 1.30, 0.5));
        listaProduktowDostepnych.add(new Produkt("mleko", 3.80, 1.0));
        listaProduktowDostepnych.add(new Produkt("śmietana", 2.80, 0.25));
        listaProduktowDostepnych.add(new Produkt("kuskus", 1.65, 1.16));
        listaProduktowDostepnych.add(new Produkt("marchewka", 1.30, 1.34));
        listaProduktowDostepnych.add(new Produkt("kiełbasa", 9.00, 1.12));
        listaProduktowDostepnych.add(new Produkt("kapusta", 4.40, 1.5));
        return listaProduktowDostepnych;
    }

    /**
     * getListaProduktow - pozwala nam na wyświetlenie w konsoli listy produktów dostępnych w sklepie
     */
    public static void getListaProduktow(){
        List <Produkt> listaProduktowDostepnych = new ArrayList<>();
        listaProduktowDostepnych = setListeProduktow();
        System.out.println("PRODUKTY DOSTĘPNE W SKLEPIE: ");
        for (Produkt prodyktyDostepne: listaProduktowDostepnych){
            System.out.println("["+prodyktyDostepne.getNazwaProduktu()+": "+prodyktyDostepne.getCenaProduktu()+" zl ]");
        }
        return;
    }
}