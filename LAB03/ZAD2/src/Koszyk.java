

import java.util.*;

/**
 * klasa Koszyk odpowiada za losowe tworzenie zawartości poszczególnego koszyka ( nazwa produktu x ilosc produktu)
 * można też ręcznie dodawać i odejmować produkty w koszyka (dodajProdukt, wyjmijProdukt)
 */
public class Koszyk {



    public Koszyk(){
    }

    /**
     * dodajPordukt - umożliwia dodanie produktu do listy przechowywuające wszystkie produkty z koszyka
     */
    LinkedList <ProduktyWKoszyku> lista=new LinkedList<ProduktyWKoszyku>();
    public void dodajProdukt(ProduktyWKoszyku produkt) {
        lista.addLast(produkt);
    }

    /**
     * wyjmijPordukt - umożliwia usunięcie produktu do listy przechowywuające wszystkie produkty z koszyka
     */
    public void wyjmijProdukt(){
        lista.removeLast();
    }

    /**
     *
     * @return koszyk - tworzenieKoszyka tworzy i zwraca losowy koszyk (losowo przydziela przedmioty i ich ilosc w koszyku)
     */
    public static Deque<ProduktyWKoszyku> tworzenieKoszyka(){
        Deque<ProduktyWKoszyku> koszyk = new LinkedList<ProduktyWKoszyku>();
        List<Produkt> listaProduktow = new ArrayList<>();
        listaProduktow=Produkt.setListeProduktow();
        Random rand = new Random();
        int n = rand.nextInt(listaProduktow.size());
        for(int i=0;i < n;i++){
            int losowyProdukt = rand.nextInt(listaProduktow.size());
            int iloscProduktu = rand.nextInt(10);
            if(iloscProduktu==0){
                iloscProduktu=1;
            }
            koszyk.addFirst(new ProduktyWKoszyku(listaProduktow.get(losowyProdukt).getNazwaProduktu(),listaProduktow.get(losowyProdukt).getCenaProduktu(),listaProduktow.get(losowyProdukt).getWagaProduktu(), iloscProduktu));
            listaProduktow.remove(losowyProdukt);
        }

        return koszyk;
    }






}