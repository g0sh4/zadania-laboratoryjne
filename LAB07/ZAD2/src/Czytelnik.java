import java.util.Timer;

public class Czytelnik implements Runnable{
    public int A;
    public int B;
    public int C;
    public int D;
    public Czytelnia czyt;
    public int numer;
    public int numerKsiążki;
    public int numerSiedzenia;

    public Czytelnik(int A, int B, int C, int D, Czytelnia czytelnia, int numer){
        this.A=A;
        this.B=B;
        this.C=C;
        this.D=D;
        this.czyt = czytelnia;
        this.numer = numer;
        if(A > 0){
            numerKsiążki = czyt.losowanieWartości(0, A-1);
        }
    }

    public int getNumerKsiążki() {
        return numerKsiążki;
    }

    public void run(){
        Timer timer = new Timer();
        timer.schedule(new Oddawanie(czyt, this), D);
    }
}
