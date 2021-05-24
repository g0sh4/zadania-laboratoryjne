public class Czytelnia {
    public int A; // ilość książek
    public int B; // ilość miejsc do siedzenia (dostępnych)
    public int C; // czas pojawienia się nowego czytelnika
    public int D; // czas czytania przez użytkownika
    public int czasCzytania;
    public int czasPojawieniaSieCzytelnika;
    public Czytelnik[] siedzenia;
    public Czytelnik[] ksiegozbior;
    public KolejkaWCzytelni kolejkaWCzytelni;

    public int losowanieWartości(int min, int max){
        return (int) ((Math.random()*(max-min+1))+min);
    }
    public void losowanie(int min, int max){
        A = losowanieWartości(min, max);
        B = losowanieWartości(min, max);
        C = losowanieWartości(min, max);
        D = losowanieWartości(min, max);
    }
    public Czytelnia(int wartoscMin, int wartoscMax){
        losowanieWartości(wartoscMin,wartoscMax);
        losowanie(wartoscMin, wartoscMax);
        siedzenia = new Czytelnik[B];
        ksiegozbior = new Czytelnik[A];
        czasCzytania = D;
        czasPojawieniaSieCzytelnika = C;
        Komunikaty.giveMessage("Rozpoczęto działanie czytelni. \n               " +
                "W czytelni jest dostępne: "+B+" miejsc.\n"+"               Czas pojawiamia się nowych czytelników: "+czasPojawieniaSieCzytelnika+" sekund.");
        kolejkaWCzytelni = new KolejkaWCzytelni(this, czasPojawieniaSieCzytelnika);
        (new Thread( kolejkaWCzytelni )).start();


    }

    public static void main(String[] args){
        //rozwiazanie nie dziala w pełni poprawnie niestety, ale zadanie przerosło moje możliwości
        if(args.length==2){
            int maxWartość = Integer.parseInt(args[0]);
            int minWartość = Integer.parseInt(args[1]);
            Czytelnia czytelnia = new Czytelnia(minWartość, maxWartość);
        }else{
            System.out.println("Podano za małą ilość argumentów aby uruchomić program." );
        }
    }
}
