import java.util.*;

public class Zbiory {

    Set<Integer> zbiory = new TreeSet<>();;

    public Zbiory(String dane){

        dane = dane.replace("[", "");
        dane = dane.replace("]", "");
        dane = dane.replace(" ","");
        String[] noweDane;
        noweDane = dane.split(",");
        for(String dana: noweDane){
            zbiory.add(Integer.valueOf((dana)));
        }
    }

    @Override
    public String toString() {
        return "Zbior{" + zbiory + '}';
    }
    public Zbiory() {
        zbiory = new TreeSet<>();
    }

    public Zbiory sumaZbiorow(Zbiory dane){
        Zbiory wynikSumyZbiorow = new Zbiory();
        wynikSumyZbiorow = this;
        for (Integer liczba1: dane.zbiory){
            int liczba = liczba1;
            if(!this.zbiory.contains(liczba)){
                wynikSumyZbiorow.zbiory.add(liczba);
                //System.out.println(liczba);
                //System.out.println(wynikSumyZbiorow);

            }

        }
    return wynikSumyZbiorow;
    }
    //ten element niestety mi nie niedziala poprawnie
    public Zbiory roznicaZbiorow(Zbiory dane){
        Zbiory wynikRoznicyZbiorow = new Zbiory();
        wynikRoznicyZbiorow = this;
        for(int liczba: dane.zbiory){
            if(this.zbiory.contains(liczba)){
                wynikRoznicyZbiorow.zbiory.remove(liczba);
            }
        }
        return wynikRoznicyZbiorow;
    }
    public Zbiory czescWspolna(Zbiory dane){
        Zbiory wynikCzesciWspolne = new Zbiory();
        wynikCzesciWspolne = this;
        for(int liczba: dane.zbiory){
            if(this.zbiory.contains(liczba)){
                wynikCzesciWspolne.zbiory.add(liczba);
            }
        }
        return wynikCzesciWspolne;
    }



}
