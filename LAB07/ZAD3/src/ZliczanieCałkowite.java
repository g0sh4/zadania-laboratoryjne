public class ZliczanieCałkowite implements Runnable{
    public int liczba;
    public int wartoscInkrementacji;



    ZliczanieCałkowite(int liczba, int wartoscInkrementacji){
        this.liczba=liczba;
        this.wartoscInkrementacji = wartoscInkrementacji;

    }


    @Override
    public void run() {
        while (Gui.running) {
            try {
                //mnożnik milisekund na sekundy
                if(Integer.parseInt(String.valueOf(Gui.inkrementacja.getSelectedItem()))==40){
                    Gui.mnoznik =1500;
                }
                if(Integer.parseInt(String.valueOf(Gui.inkrementacja.getSelectedItem()))==60 ){
                    Gui.mnoznik =1000;
                }
                if(Integer.parseInt(String.valueOf(Gui.inkrementacja.getSelectedItem()))==50 ){
                    Gui.mnoznik =1200;
                }
                if(Integer.parseInt(String.valueOf(Gui.inkrementacja.getSelectedItem()))==80 ){
                    Gui.mnoznik =750;
                }
                if(Integer.parseInt(String.valueOf(Gui.inkrementacja.getSelectedItem()))==120 ){
                    Gui.mnoznik =500;
                }
                if(Integer.parseInt(String.valueOf(Gui.inkrementacja.getSelectedItem()))==100 ){
                    Gui.mnoznik =600;
                }
                if(Integer.parseInt(String.valueOf(Gui.inkrementacja.getSelectedItem()))==150 ){
                    Gui.mnoznik =400;
                }
                if(Integer.parseInt(String.valueOf(Gui.inkrementacja.getSelectedItem()))==200 ){
                    Gui.mnoznik =300;
                }
                if(Integer.parseInt(String.valueOf(Gui.inkrementacja.getSelectedItem()))==160 ){
                    Gui.mnoznik =375;
                }
                if(Integer.parseInt(String.valueOf(Gui.inkrementacja.getSelectedItem()))==250 ){
                    Gui.mnoznik =240;
                }
                if(Integer.parseInt(String.valueOf(Gui.inkrementacja.getSelectedItem()))==240 ){
                    Gui.mnoznik =250;
                }
                if(Integer.parseInt(String.valueOf(Gui.inkrementacja.getSelectedItem()))==300 ){
                    Gui.mnoznik =200;
                }
                Thread.sleep(Gui.mnoznik);
                liczba = Integer.parseInt(String.valueOf(Gui.wartoscPoczatkowa));
                //System.out.println(Gui.wartosc );
                Gui.wartosc = Integer.parseInt(String.valueOf(Gui.inkrementacja.getSelectedItem())) ;
                wartoscInkrementacji = Gui.wartosc;
                Gui.textField.setText(String.valueOf(liczba));
                Gui.wartoscPoczatkowa++;
            } catch (InterruptedException e) {
                e.printStackTrace( );
            }
        }
    }


}
