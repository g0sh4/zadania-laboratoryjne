import java.util.TimerTask;

public class Oddawanie extends TimerTask {
    public Czytelnia czytelnia;
    public Czytelnik czytelnik;

    public Oddawanie(Czytelnia czytelnia, Czytelnik czyt){
        this.czytelnia = czytelnia;
        czytelnik = czyt;
    }
    @Override
    public void run(){
        Komunikaty.giveMessage("Czytelnik nr: "+czytelnik.numer+" oddaje książkę nr: "+czytelnik.getNumerKsiążki());
        czytelnia.siedzenia[czytelnik.numerSiedzenia] =null;
        czytelnia.siedzenia[czytelnik.getNumerKsiążki()]=null;
    }
}
