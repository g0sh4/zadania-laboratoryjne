import java.util.Timer;
import java.util.TimerTask;

public class NowyCzytelnik extends TimerTask {

    public KolejkaWCzytelni kolejkaWCzytelni;
    public int czasPojawieniaSieNowegoCzytelnika;
    public int numerCzytelnika;
    public NowyCzytelnik(KolejkaWCzytelni kol, int czas, int numer){
        this.kolejkaWCzytelni = kol;
        this.czasPojawieniaSieNowegoCzytelnika = czas;
        numerCzytelnika = numer;
    }

    @Override
    public void run() {
        numerCzytelnika++;
        var czytelnik = new Czytelnik(kolejkaWCzytelni.czytelnia.A, kolejkaWCzytelni.czytelnia.B, kolejkaWCzytelni.czytelnia.C, kolejkaWCzytelni.czytelnia.D, kolejkaWCzytelni.czytelnia, numerCzytelnika);
        Komunikaty.giveMessage("Nowy czytelnik: "+numerCzytelnika+" chce wypożyczyć książkę: "+czytelnik.getNumerKsiążki()+" Długość kolejki: "+(kolejkaWCzytelni.getKolejka().size()+1));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace( );
        }
        kolejkaWCzytelni.getKolejka().addFirst(czytelnik);
        Timer czekanieWKolejce = new Timer();
        czekanieWKolejce.schedule(new NowyCzytelnik(kolejkaWCzytelni, czasPojawieniaSieNowegoCzytelnika, numerCzytelnika), czasPojawieniaSieNowegoCzytelnika);
    }
}
