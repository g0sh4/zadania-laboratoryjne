
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class MainGui extends JFrame {

    JButton wybierzButton;
    JButton obliczButton;
    JButton koniecButton;
    JLabel informacjaLabel;
    JTextField sciezkaField;
    String path;
    int files;
    int folders;

    JPanel panel = null;

    GridBagConstraints position = new GridBagConstraints();

    private void wstawSciezkadoGui(){

        position.gridx = 0;
        position.gridy =0;
        position.gridwidth=5;
        position.ipady = 5;
        position.fill = GridBagConstraints.HORIZONTAL;

        position.insets = new Insets(5,10,5,10);
        sciezkaField = new JTextField("");
        panel.add(sciezkaField,position);

    }

    private void wstawWybierzdoGui(){
        position.gridx = 1;
        position.gridy = 1;
        position.gridwidth=1;
        position.fill = GridBagConstraints.CENTER;
        position.insets = new Insets(0,0,20,0);
        position.ipady = 10;
        wybierzButton = new JButton("Wybierz");
        panel.add(wybierzButton,position);
        wybierzButton.addActionListener(this::actionPerformed);

    }


    private void wstawKoniec(){
        position.gridx = 3;
        position.fill = GridBagConstraints.CENTER;
        koniecButton = new JButton("Zakończ");
        koniecButton.addActionListener(this::actionPerformed);
        panel.add(koniecButton,position);
    }
    private void actionPerformed(ActionEvent e) {
        if(e.getSource()== koniecButton){
            System.exit(0);
        }else if(e.getSource() == obliczButton){
            FileAnalyzer fileAnalyzer = new FileAnalyzer(path);
            fileAnalyzer.analyzerWithSubfolders(path);
            files = fileAnalyzer.getFilenumber();
            folders = fileAnalyzer.getSubfoldersNumber();
            informacjaLabel.setText("<html>Katalog "+ path+" zawiera "+fileAnalyzer.getFilenumber() +
                    " podfolderów i "+ fileAnalyzer.getSubfoldersNumber()+" plików.</html>");

        }else if(e.getSource() == wybierzButton){
            JFileChooser choose = new JFileChooser();
            choose.setCurrentDirectory(new File("."));
            choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            choose.setAcceptAllFileFilterUsed(false);

            if (choose.showOpenDialog(panel) == JFileChooser.APPROVE_OPTION) {
                sciezkaField.setText(choose.getSelectedFile().toString());
                path = choose.getSelectedFile().toString();
            }
        }
    }

    private void startPosition(){
        position.weightx = 1;
        position.weighty = 1;
        position.gridx = 0;
        position.gridy = 1;
        position.gridheight=1;
        position.gridwidth=1;
    }
    private void wstawInformacja(){
        position.gridx =0;
        position.gridy=2;
        position.gridwidth = 5;

        position.fill = GridBagConstraints.HORIZONTAL;
        FileAnalyzer fileAnalyzer = new FileAnalyzer(path);
        fileAnalyzer.analyzerWithSubfolders(path);
        informacjaLabel = new JLabel("Wybierz katalog do analizy ... ");
        panel.add(informacjaLabel,position);

    }

    private void wstawObliczdoGui(){
        position.gridx = 2;
        position.fill = GridBagConstraints.CENTER;
        obliczButton = new JButton("Oblicz");
        panel.add(obliczButton,position);
        obliczButton.addActionListener(this::actionPerformed);

    }

    public MainGui(){
        //tytuł okna w instrukcji: "Tytuł okna" zmieniłam na "Zliczanie plików i podfolderów"
        super("Zliczanie plików i podfolderów");
        panel = new JPanel(new GridBagLayout());
        startPosition();
        wstawSciezkadoGui();
        wstawWybierzdoGui();
        wstawKoniec();
        wstawObliczdoGui();
        wstawInformacja();

        this.add(panel);
        this.setResizable(true);

        setBounds(200, 200, 400, 300);
        EventQueue.invokeLater(() -> setVisible(true));
    }
    public static void main(String[] args){
        MainGui GUI = new MainGui();



    }
}