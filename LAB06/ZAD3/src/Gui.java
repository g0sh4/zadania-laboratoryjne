import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Gui extends JPanel {

    private JList listaRzowijana;
    private JTextField inputTextfield;
    private JTextField outputTextfield;
    private JLabel inputLabel;
    private JLabel outputLabel;
    private JOptionPane optionPane;
    private JComboBox comboBox;
    private JLabel komunikaty;

    public Gui(){
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1,3  ));
        JButton konwertujButton = new JButton( "Konwertuj dane 1->2" );
        konwertujButton.addActionListener(this::actionPerformed);
        JButton zmienKierunekButton = new JButton( "Konwertuj dane 2->1" );
        zmienKierunekButton.addActionListener(this::actionPerformed);
        //JButton listaRozwijana = new JButton( "TUBEDZIELIST" );
        comboBox = new JComboBox(  );
        comboBox.setEditable(true);
        comboBox.addItem(" ");
        comboBox.addItem("metry – cale");
        comboBox.addItem("skala Celsjusza – skala Fahrenheit");
        comboBox.addItem("kilogram – funt");
        comboBox.addActionListener(this::actionPerformed);
        panel1.add(konwertujButton);
        panel1.add(zmienKierunekButton);
        panel1.add(comboBox);
        inputTextfield = new JTextField( "" );
        inputTextfield.addActionListener(this::actionPerformed);
        outputTextfield = new JTextField( "" );
        outputTextfield.addActionListener(this::actionPerformed);
        inputLabel = new JLabel( "" );
        outputLabel = new JLabel( "" );
        JPanel panel2 = new JPanel(  );

        panel2.setLayout(new GridLayout( 2,2 ));
        panel2.add(inputTextfield);
        panel2.add(inputLabel);
        panel2.add(outputTextfield);
        panel2.add(outputLabel);
        komunikaty = new JLabel( "" );
        JPanel panel3 = new JPanel(  );
        panel3.add(komunikaty);
        JFrame frame = new JFrame("PRM2T - Konwerter ");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.CENTER);
        frame.add(panel3, BorderLayout.SOUTH);
        frame.pack();
        frame.setSize(500, 200);
        frame.getContentPane();
        frame.setVisible(true);

    }

    private void actionPerformed(ActionEvent actionEvent) {
        String event = actionEvent.getActionCommand();
        KonwerterDanych konwerterDanych = new KonwerterDanych();
        if(event.equals("Konwertuj dane 1->2")){
            if(comboBox.getSelectedItem()==" "){
                komunikaty.setText("Nie wybrałeś typu konwersji z listy.");
            }
            if(inputTextfield.getText().length()==0 && outputTextfield.getText().length()==0){
                komunikaty.setText("Nie podałeś żadnych danych.");
            }
            if(inputTextfield.getText().length()==0 && outputTextfield.getText().length()!=0){
                komunikaty.setText("Spróbuj skorzystać z konwersji 2->1");
            }
            if(comboBox.getSelectedItem()!=" "&& inputTextfield.getText().length()!=0 ){
                if(comboBox.getSelectedItem()=="metry – cale"){
                    inputLabel.setText("[m]");
                    outputLabel.setText("[cal]");
                    komunikaty.setText("");
                    //double metry = Double.parseDouble(inputTextfield.getText())+2;
                    String metry = inputTextfield.getText();
                    String cale = konwerterDanych.konwersjaNaCale(metry);

                    outputTextfield.setText(cale);
                }
                if(comboBox.getSelectedItem()=="skala Celsjusza – skala Fahrenheit"){
                    inputLabel.setText("[°C]");
                    outputLabel.setText("[°F]");
                    komunikaty.setText("");
                    String celcjusz = inputTextfield.getText();
                    String farenheit = konwerterDanych.konwersjaNaFarenheit(celcjusz);
                    outputTextfield.setText(farenheit);
                }
                if(comboBox.getSelectedItem()=="kilogram – funt"){
                    inputLabel.setText("[kg]");
                    outputLabel.setText("[lb]");
                    komunikaty.setText("");
                    String kilogram = inputTextfield.getText();
                    String funt = konwerterDanych.konwersjaNaFunty(kilogram);
                    outputTextfield.setText(funt);
                }
            }

        }
        if(event.equals("Konwertuj dane 2->1")){
            if(comboBox.getSelectedItem()==" "){
                komunikaty.setText("Nie wybrałeś typu konwersji z listy");
            }
            if(inputTextfield.getText().length()!=0 && outputTextfield.getText().length()==0){
                komunikaty.setText("Spróbuj innej konwersji.");
            }
            if(inputTextfield.getText().length()==0 && outputTextfield.getText().length()==0){
                komunikaty.setText("Nie podałeś żadnych danych.");
            }if(comboBox.getSelectedItem()=="metry – cale" && outputTextfield.getText().length()!=0){
                inputLabel.setText("[m]");
                outputLabel.setText("[cal]");
                komunikaty.setText("");
                //double metry = Double.parseDouble(inputTextfield.getText())+2;
                String cale = outputTextfield.getText();
                String metry = konwerterDanych.konwersjaNaMetry(cale);

                inputTextfield.setText(metry);
            }
            if(comboBox.getSelectedItem()=="skala Celsjusza – skala Fahrenheit"&&outputTextfield.getText().length()!=0){
                inputLabel.setText("[°C]");
                outputLabel.setText("[°F]");
                komunikaty.setText("");
                String fahrenheit = outputTextfield.getText();
                String celcjusz = konwerterDanych.konwersjaNaCelcjusza(fahrenheit);
                inputTextfield.setText(celcjusz);
            }
            if(comboBox.getSelectedItem()=="kilogram – funt"){
                inputLabel.setText("[kg]");
                outputLabel.setText("[lb]");
                komunikaty.setText("");
                String funt = outputTextfield.getText();
                String kilogram = konwerterDanych.konwersjaNaKilogramy(funt);
                inputTextfield.setText(kilogram);
            }
        }
        if(comboBox.getSelectedItem()=="metry – cale" ){
            inputLabel.setText("[m]");
            outputLabel.setText("[cal]");
            komunikaty.setText("");

        }
        if(comboBox.getSelectedItem()=="skala Celsjusza – skala Fahrenheit"){
            inputLabel.setText("[°C]");
            outputLabel.setText("[°F]");
            komunikaty.setText("");

        }
        if(comboBox.getSelectedItem()=="kilogram – funt"){
            inputLabel.setText("[kg]");
            outputLabel.setText("[lb]");
            komunikaty.setText("");

        }
    }

    public static void main (String[] args) {
        new Gui();
    }
}
