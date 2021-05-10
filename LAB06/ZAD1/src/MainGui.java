import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class MainGui extends JPanel {
    private JButton wpiszButton;
    private JTextField tekstField;
    public JFrame frame;

    public MainGui() {

        wpiszButton= new JButton ("Wpisz: ");
        wpiszButton.addActionListener(this::actionPerformed);

        tekstField = new JTextField (5);

        setPreferredSize (new Dimension (543, 138));
        setLayout (null);
        add(wpiszButton);
        add(tekstField);

        wpiszButton.setBounds (35, 50, 110, 36);
        tekstField.setBounds (170, 50, 315, 36);
        tekstField.setEditable(false);

    }

    public void mainGuiSetter(){
        frame = new JFrame ("Testowanie danych wejściowych.");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new MainGui());
        frame.pack();
        frame.setVisible (true);
    }


    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("Wpisz: ")) {
            while(true){

                String wpisanaWartosc = JOptionPane.showInputDialog(null, "Podaj wartość: ", "Input Dialog", JOptionPane.QUESTION_MESSAGE);
                if(wpisanaWartosc==null){
                    break;
                }

                try{
                    double parseDouble = Double.parseDouble(wpisanaWartosc);
                    tekstField.setText(wpisanaWartosc);
                    break;
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null, "Wpisana wartość może byc tylko liczbą, spróbuj ponownie. ","Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        }
    }

    public static void main(String[] args){
        MainGui mainGui = new MainGui();
        mainGui.mainGuiSetter();

    }
}
