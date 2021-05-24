


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Gui {
    public JFrame frame;
    public JPanel wpisywaniePanel;
    public JPanel buttonPanel;
    public JPanel panel1;
    public JLabel RLabel;
    public JLabel rLabel;
    public JLabel dLabel;
    public JTextField RField;
    public JTextField rField;
    public JTextField dField;
    public JButton startButton;
    public JButton animacjaButton;
    public int frameWidth = 400;
    public int frameHeight = 400;
    public JPanel panel;

    public Gui() throws InterruptedException {
        frame = new JFrame( "HYPOTORCHOID" );
        wpisywaniePanel = new JPanel();
        wpisywaniePanel.setLayout(new GridLayout( 3, 2 ,2,2));
        RLabel = new JLabel("R:");
        rLabel = new JLabel( "r:" );
        dLabel = new JLabel( "d:" );

        RField = new JTextField();
        RField.setText("1");
        RField.addActionListener(this::actionPerformed);
        rField = new JTextField();
        rField.setText("1");
        rField.addActionListener(this::actionPerformed);
        dField = new JTextField();
        dField.setText("1");
        dField.addActionListener(this::actionPerformed);

        wpisywaniePanel.add(RLabel);
        wpisywaniePanel.add(RField);
        wpisywaniePanel.add(rLabel);
        wpisywaniePanel.add(rField);
        wpisywaniePanel.add(dLabel);
        wpisywaniePanel.add(dField);
        wpisywaniePanel.setBorder(BorderFactory.createEmptyBorder(60,60,60,60));

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout( 1,1 ));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        startButton = new JButton( "START" );
        buttonPanel.add(startButton);
        startButton.addActionListener(this::actionPerformed);

        panel1 = new JPanel();
        panel1.setLayout(new GridLayout( 2,1 ));
        panel1.add(wpisywaniePanel);
        panel1.add(buttonPanel);
        animacjaButton = new JButton( "BUTTON ANIMATION" );

        panel = new JPanel( );
        panel.setSize(1000,1000);
        panel.setBorder(BorderFactory.createEmptyBorder(100,400,100,100));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        frame.setSize(frameWidth+1000, frameHeight+200);
        frame.setLocation((int) (width-frameWidth)/2, (int) (height-frameHeight)/2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel1, BorderLayout.WEST);
        frame.add(panel, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)  {
        String s = e.getActionCommand();

        if(RField.getText().length()!=0){
            try{
                Integer.parseInt(RField.getText());
                if(Integer.parseInt(RField.getText())<0 || Integer.parseInt(RField.getText())>100){
                    JOptionPane.showMessageDialog(null, "Wartość R musi należeć do przedziału [1,100]", "Błędne dane", JOptionPane.ERROR_MESSAGE);
                    RField.setText("");
                }
            }catch (Exception exception){
                JOptionPane.showMessageDialog(null, "Wartość R musi należeć do przedziału [1,100]", "Błędne dane", JOptionPane.ERROR_MESSAGE);
                RField.setText("");
            }

        }
        if(rField.getText().length()!=0){
            try{
                Integer.parseInt(rField.getText());
                if(Integer.parseInt(rField.getText())<0 || Integer.parseInt(rField.getText())>100){
                    JOptionPane.showMessageDialog(null, "Wartość r musi należeć do przedziału [1,100]", "Błędne dane", JOptionPane.ERROR_MESSAGE);
                    rField.setText("");
                }
            }catch (Exception exception){
                JOptionPane.showMessageDialog(null, "Wartość r musi należeć do przedziału [1,100]", "Błędne dane", JOptionPane.ERROR_MESSAGE);
                rField.setText("");
            }

        }
        if(dField.getText().length()!=0){
            try{
                Integer.parseInt(dField.getText());
                if(Integer.parseInt(dField.getText())<0 || Integer.parseInt(dField.getText())>100){
                    JOptionPane.showMessageDialog(null, "Wartość d musi należeć do przedziału [1,100]", "Błędne dane", JOptionPane.ERROR_MESSAGE);

                }
            }catch (Exception exception){
                JOptionPane.showMessageDialog(null, "Wartość d musi należeć do przedziału [1,100]", "Błędne dane", JOptionPane.ERROR_MESSAGE);
                dField.setText("");
            }
        }
        if(dField.getText().length()==0 || RField.getText().length()==0 || rField.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Musisz podać wszystkie wartości, aby rozpocząć animacje.", "Błędne dane", JOptionPane.ERROR_MESSAGE);
        }

        if(s.equals("START")&&dField.getText().length()!=0 &&RField.getText().length()!=0 &&rField.getText().length()!=0 ){
            //panel.repaint(  );
            panel.getGraphics().clearRect(0, 0, panel.getWidth(), panel.getHeight());

            HypotrochoidPanel panel4 =new HypotrochoidPanel(Integer.parseInt(RField.getText()),Integer.parseInt(rField.getText()),Integer.parseInt(dField.getText()));
            //frame.add(new HypotrochoidPanel(Integer.parseInt(RField.getText()),Integer.parseInt(rField.getText()),Integer.parseInt(dField.getText())), BorderLayout.CENTER);
            frame.add(panel4);
            frame.setSize(1000,1000);frame.pack();
            //frame.remove(panel4);
            //System.out.println(RField.getText()+rField.getText()+dField.getText() );

        }


    }

    public int getRField() {
        return Integer.parseInt(RField.getText());
    }

    public int getdField() {
        return Integer.parseInt(dField.getText());
    }
    public int getrField(){
        return Integer.parseInt(rField.getText());
    }
    public static void main (String[] args) throws InterruptedException {

        new Gui();

    }

}