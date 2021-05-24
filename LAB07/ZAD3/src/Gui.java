import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class Gui {
    public static JComboBox<String> inkrementacja;
    public JLabel opisListy;
    public JButton przyciskPierwszy;
    public JButton przyciskDrugi;
    public JButton przyciskTrzeci;
    public static JTextField textField;
    public static boolean running=true;
    public static int wartoscPoczatkowa=0;
    public static int wartosc;
    public static int mnoznik;
    public Thread thread;
    public Gui(){
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1,2  ));
        opisListy = new JLabel( "      Wybór liczby inkrementacji na minutę: " );
        inkrementacja = new JComboBox<>();
        inkrementacja.setEditable(true);
        inkrementacja.addItem("40");
        inkrementacja.addItem("50");
        inkrementacja.addItem("60");
        inkrementacja.addItem("80");
        inkrementacja.addItem("100");
        inkrementacja.addItem("120");
        inkrementacja.addItem("150");
        inkrementacja.addItem("160");
        inkrementacja.addItem("200");
        inkrementacja.addItem("240");
        inkrementacja.addItem("250");
        inkrementacja.addItem("300");
        inkrementacja.addActionListener(this::actionPerformed);
        panel1.add(opisListy);
        panel1.add(inkrementacja);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3,1 ,15,15));
        przyciskPierwszy = new JButton( "START" );
        przyciskPierwszy.addActionListener(this::actionPerformed);
        przyciskDrugi = new JButton(  "RESET" );
        przyciskDrugi.addActionListener(this::actionPerformed);
        przyciskTrzeci = new JButton( "ZWIĘKSZ o 10" );
        przyciskTrzeci.addActionListener(this::actionPerformed);
        panel2.add(przyciskPierwszy);
        panel2.add(przyciskDrugi);
        panel2.add(przyciskTrzeci);
        panel2.setBorder(BorderFactory.createEmptyBorder(100,10,100,10));

        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout( 1,1 ));
        textField = new JTextField( "LICZNIK" );

        textField.setEditable(false);
        panel3.add(textField);
        panel3.setBorder(BorderFactory.createEmptyBorder(100,10,100,10));
        JFrame frame = new JFrame( "PRM2T - LICZNIK/TIMER" );
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.WEST);
        frame.add(panel3, BorderLayout.CENTER);
        frame.pack();
        frame.setSize(500,400);
        frame.getContentPane();
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent actionEvent){
    String event = actionEvent.getActionCommand();
    if(event.equals("START")){

        przyciskPierwszy.setText("STOP");
        running = true;
        wartosc = Integer.parseInt(String.valueOf(inkrementacja.getSelectedItem()));
        //System.out.println(inkrementacja.getSelectedItem());
        ZliczanieCałkowite zliczanieCałkowite = new ZliczanieCałkowite(wartoscPoczatkowa, wartosc );
        thread = new Thread( zliczanieCałkowite );
        thread.start();
    }
    if(event.equals("STOP")){
        przyciskPierwszy.setText("START");
        running = false;

        }
    if(event.equals("ZWIĘKSZ o 10")){
        wartoscPoczatkowa = Integer.parseInt(textField.getText())+10;
        textField.setText(String.valueOf(wartoscPoczatkowa));
    }
    if(event.equals("RESET")){
        wartoscPoczatkowa=0;
        textField.setText("0");
    }
    }

    public static void main (String[] args) {
        new Gui();
    }
}
