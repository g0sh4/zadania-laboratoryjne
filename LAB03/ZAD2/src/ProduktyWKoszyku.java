/**
 * Klasa ProduktWKoszyku dziedziczy po klasie Pordukt, określa dokładniej cechy konkretnego typu produktu w koszyku (współna wga, ilość)
 */

public class ProduktyWKoszyku extends Produkt  {

    /**
     * liczbaSztukProduktu - przechowuje dane i ilosci sztuk produktu w koszyku
     * rachunekDoZapłaty - przechuwje dane o rachynku do zapłaty
     * wagaPoduktow - mowi o wadzie prodktów danego typu
     * nazwaProduktuWKoszyku - wartosc dziedziczona po klasie Produkt, mówiąca o nazwie produktu
     */
    private int liczbaSztukProduktu;
    private double rachunekDoZaplaty;
    private double wagaPoduktow;
    private String nazwaProduktuWKoszyku;


    public ProduktyWKoszyku(String nazwa, double cena, double waga, int liczba) {
        super(nazwa, cena, waga);
        nazwaProduktuWKoszyku = nazwa;
        liczbaSztukProduktu = liczba;
        rachunekDoZaplaty = liczbaSztukProduktu * cena;
        wagaPoduktow = liczbaSztukProduktu * waga;
    }

    /**
     *
     * @return - waga łacza produktów danego typu
     */
    public double getWagaPoduktow() {
        return wagaPoduktow;
    }

    /**
     *
     * @return - rachunek łaczny za produkty danego typu
     */
    public double getRachunekDoZaplaty() {
        return rachunekDoZaplaty;
    }

    /**
     *
     * @return - umożliwia wypisanie na konsoli nazwy produktu wraz z jego iloscia w koszyku
     */
    @Override
    public String toString() {
        return nazwaProduktuWKoszyku+" x "+liczbaSztukProduktu+" szt.";
    }

}
