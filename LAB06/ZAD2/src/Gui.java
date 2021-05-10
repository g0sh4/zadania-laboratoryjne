import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Gui extends JPanel{
    private  JTextField textField;
    private  JTextField textField1;
    private JTable backupTable;
    private JTable table;
    private  JLabel messages;
    private TableRowSorter<TableModel> sortValues;
    private JScrollPane sp;

    public Gui(){
        JPanel panel = new JPanel( );
        panel.setLayout(new GridLayout(1,3));
        JButton filtrujButton = new JButton("Filtruj");
        filtrujButton.addActionListener(this::actionPerformed);
        textField = new JTextField(7);
        textField.addActionListener(this::actionPerformed);
        textField1 = new JTextField(7);
        messages = new JLabel();
        JFrame frame = new JFrame("PRM2T - Swing MVC");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        File file = new File();
        file.readCSV("publication_list.csv");
        String[] columnNames2 = file.getColumnNames().toArray(new String[0]);

        //w tym miejscu napotkałam problem, więc musiałam posłużyć się znalezionym na StackOverflow rozwiązaniem
        String[][] data2 = file.getAllRecords().stream().map((l)->l.toArray(new String[l.size()])).collect(Collectors.toList()).toArray(new String[file.getAllRecords().size()][]);

        table = new JTable(data2, columnNames2);
        DefaultTableModel tableModel = new DefaultTableModel(data2, columnNames2);
        backupTable = new JTable();
        backupTable = table;
        JScrollPane sp = new JScrollPane(table);

        MouseListener tableMouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                int kolumna = table.columnAtPoint(mouseEvent.getPoint());
                int wiersz = table.rowAtPoint(mouseEvent.getPoint());

                textField1.setText((String) table.getValueAt(wiersz,kolumna));
            }
        };
        table.addMouseListener(tableMouseListener);

        //textField.addActionListener(this::actionPerformed);
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    if (textField.getText().equals("")) {

                        //table = backupTable;
                        messages.setText("Nie podano żadnej wartości filtrującej.");
                        String filtrujacaWartosc = " ";
                        sortValues = new TableRowSorter<>(table.getModel());
                        sortValues.setRowFilter(RowFilter.regexFilter(filtrujacaWartosc));
                        table.setRowSorter(sortValues);

                    } else {
                        messages.setText("");
                        String filtrujacaWartosc = textField.getText();
                        sortValues = new TableRowSorter<>(table.getModel());
                        sortValues.setRowFilter(RowFilter.regexFilter(filtrujacaWartosc));
                        table.setRowSorter(sortValues);
                    }
                }
            }
        });


        sp.getViewport().add(table);
        panel.add(filtrujButton);
        panel.add(textField);
        panel.add(textField1);
        frame.add(panel,BorderLayout.NORTH);
        frame.add(sp, BorderLayout.CENTER);
        frame.add(messages,BorderLayout.SOUTH);
        frame.pack();
        frame.setSize(1000, 700);
        frame.getContentPane();
        frame.setVisible(true);

    }
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Filtruj")) {
            if (textField.getText().hashCode() == 0) {
                table = backupTable;
                messages.setText("Nie podano żadnej wartości filtrującej.");
                String filtrujacaWartosc = " ";
                sortValues = new TableRowSorter<>(table.getModel());
                sortValues.setRowFilter(RowFilter.regexFilter(filtrujacaWartosc));
                table.setRowSorter(sortValues);


            } else {
                messages.setText("");
                String filtrujacaWartosc = textField.getText();
                sortValues = new TableRowSorter<>(table.getModel());
                sortValues.setRowFilter(RowFilter.regexFilter(filtrujacaWartosc));
                table.setRowSorter(sortValues);
            }
        }

    }
    public static void main (String[] args) {
       new Gui();
    }

}