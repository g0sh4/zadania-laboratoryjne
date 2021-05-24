import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.Timer;

public class KolejkaWCzytelni implements Runnable {

    public Czytelnia czytelnia;
    public Deque<Czytelnik> kolejkaWCzytelni = new ArrayDeque<>();
    public int czasPojawieniaSieNowegoCzytelnika;

    public KolejkaWCzytelni(Czytelnia czyt, int czas){
        this.czytelnia = czyt;
        this.czasPojawieniaSieNowegoCzytelnika = czas;

    }

    public Deque<Czytelnik> getKolejka() {
        return kolejkaWCzytelni;
    }

    @Override
    public void run() {
        Timer nowyCzytelnik = new Timer();
        NowyCzytelnik kolejkaNowychCzytelnikow = new NowyCzytelnik(this, czasPojawieniaSieNowegoCzytelnika,0);
        nowyCzytelnik.schedule(kolejkaNowychCzytelnikow, czasPojawieniaSieNowegoCzytelnika);

        while(true){
            for(int numerSiedzenia=0; numerSiedzenia<czytelnia.siedzenia.length; numerSiedzenia++){
                if(czytelnia.siedzenia[numerSiedzenia]==null){
                    if(kolejkaWCzytelni.size()>0){
                        try{
                            Czytelnik kandydat = kolejkaWCzytelni.getLast();
                            if(czytelnia.ksiegozbior[kandydat.getNumerKsiążki()]==null){
                                czytelnia.ksiegozbior[kandydat.getNumerKsiążki()]=kandydat;
                                czytelnia.siedzenia[numerSiedzenia] = kandydat;

                                kandydat.numerSiedzenia = numerSiedzenia;

                                kolejkaWCzytelni.removeLast();
                                try {
                                    Thread.sleep(50);
                                } catch (InterruptedException e) {
                                    e.printStackTrace( );
                                }
                                Komunikaty.giveMessage("Wypożyczono książkę nr: "+kandydat.getNumerKsiążki()+" przez czytelnika nr: "+kandydat.numer);
                                Komunikaty.giveMessage("Zajęto siedzenie nr: "+numerSiedzenia+" przez czytelnika nr: "+kandydat.numer);
                                kandydat.run();
                            }
                        }catch (NoSuchElementException err){
                            err.printStackTrace();
                        }
                    }
                    numerSiedzenia = czytelnia.siedzenia.length+1;
                }
            }
        }
    }
}
