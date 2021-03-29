import java.util.*;

/**
 * klasa Klient służy do przechowywania i operacji na danych charakteryzujacych klienta
 * umożliwia stworzenie listy klientow, ustawia ich losowo w kolejke
 */
public class Klient {
    /**
     * Pola poniższe przechowują kolejno:
     * - nazwiskoKlienta - nazwisko klienta
     * - imieKlienta - imie klienta
     * - koszykKlienta - dane o koszyku klienta z klasy Koszyk
     */
    private String nazwiskoKienta;
    private String imieKlienta;
    private Koszyk koszykKienta;

    Deque<ProduktyWKoszyku> koszyk = new LinkedList<ProduktyWKoszyku>();

    public Klient(String nazwisko, String imie, Deque<ProduktyWKoszyku> koszyk) {
        nazwiskoKienta = nazwisko;
        imieKlienta = imie;
        this.koszyk = koszyk;

    }

    /**
     *
     * @return zwraca czytelny napis o danych personalnych klienta i jego koszyku
     */
    @Override
    public String toString() {
        return "Klient:" + nazwiskoKienta +" "+ imieKlienta + " / " + "koszyk = " + koszyk+"\n";
    }

    public Deque<ProduktyWKoszyku> getKoszyk() {
        return koszyk;
    }

    /**
     *
     * @return - imie klienta
     */
    public String getImieKlienta() {
        return imieKlienta;
    }

    /**
     *
     * @return - nazwisko klienta
     */
    public String getNazwiskoKienta() {
        return nazwiskoKienta;
    }

    /**
     *
     * @param koszykKienta - tworzy koszyk klienta
     */
    public void setKoszykKienta(Koszyk koszykKienta) {
        this.koszykKienta = koszykKienta;
    }

    public Koszyk getKoszykKienta() {
        return koszykKienta;
    }
    /**
     * setListeKlientow - umożliwia utworzenie listy klientow sklepu
     */
    public static List<Klient> setListeKlientow() {
        List<Klient> listaKlientowSklepu = new ArrayList<>();
        listaKlientowSklepu.add(new Klient("Koral", "Maria",Koszyk.tworzenieKoszyka()));
        listaKlientowSklepu.add(new Klient("Rama", "Marek",Koszyk.tworzenieKoszyka()));
        listaKlientowSklepu.add(new Klient("Kabala", "Janina",Koszyk.tworzenieKoszyka()));
        listaKlientowSklepu.add(new Klient("Jakubiec", "Krystyna",Koszyk.tworzenieKoszyka()));
        listaKlientowSklepu.add(new Klient("Dominos", "Robert",Koszyk.tworzenieKoszyka()));


        return listaKlientowSklepu;
    }

    /**
     * getListaKlientow - umożliwia na wypisanie na konsoli listy klientów (tej przed ustawieniem się losowo do kolejki)
     */
    public static void getListaKlientow() {
        List<Klient> listaKlientow = new ArrayList<>();
        listaKlientow = setListeKlientow();
        for (Klient klient : listaKlientow) {
        System.out.print(klient.getImieKlienta() + " " + klient.getNazwiskoKienta() + " // ");
        }
    }

    /**
     *
     * @param lista - setKolejka jako parametr przyjmuje listę osob znajdujacych sie w sklepie
     * @return - zwraca losowo ułożoną listę osob znajdujących się w skliepie (klientów)
     */
    public static Queue<Klient> setKolejka(List lista) {
        Queue<Klient> kolejka = new LinkedList<>();
        List<Klient> listaZ = new ArrayList<>();
        listaZ = lista;
        Random rand = new Random();
        int x = 0;
        int rozmar = lista.size();
        System.out.println("\n");
        for (int i = 0; i < rozmar; i++) {
            x = rand.nextInt(listaZ.size());
            kolejka.add(listaZ.get(x));
            listaZ.remove(x);

        }
        System.out.println("KOLEJKA: ");
        for(Klient klient: kolejka){
            System.out.println(klient.getImieKlienta()+" "+klient.getNazwiskoKienta()+" ");
        }
        System.out.println("\n");
        return kolejka;
    }


}

