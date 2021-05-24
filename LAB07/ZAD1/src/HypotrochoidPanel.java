

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 * Panel, w którym wyświetlana jest hipotrochoida o zadanych parametrach.
 */
public class HypotrochoidPanel extends JPanel {

    private final static int PANEL_SIZE_IN_PX = 420;

    /**
     * Parametry dotyczące rysowania.
     */
    private final static Color COLOR = Color.BLACK;
    private final static Color BACKGROUND_COLOR = Color.WHITE;
    private final static int STROKE_WIDTH = 1;

    /**
     * Zakres wyświetlanych wartości.
     * W panelu będą widoczne współrzędne x, y z zakresu [-axesLimit, axesLimit].
     */
    private final double axesLimit;
    private double t=0;
    private double step;

    /**
     * Parametry rysowanej hipotrochoidy.
     */
    private final int R, r, d;

    public HypotrochoidPanel(int R, int r, int d) {
        this.R = R;
        this.r = r;
        this.d = d;
        setBackground(BACKGROUND_COLOR);
        axesLimit = d + Math.abs(R - r) * 1.05d;
        step = 0.01;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PANEL_SIZE_IN_PX, PANEL_SIZE_IN_PX);
    }

    public void paintComponent(Graphics g) {
        //super.paintComponent(g);
        //nie do konca udało mi się zrealizować to zadanie- pod odkomentowaniu powyższej linijki JPanel "ładnie" dodaje się do JFrame,
        //jednak obrazek się nie rysuje, jedynie pokazywany jest ślad po nim
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(COLOR);
        g2.setStroke(new BasicStroke(STROKE_WIDTH));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        double tMax = computeTMax();


        ArrayList<Shape> odcinkiRysowane = new ArrayList<>();
        //while(t<tMax) {

        double xStart = x(t);
        double yStart = y(t);

        double xEnd = x(t + step);
        double yEnd = y(t + step);

        odcinkiRysowane.add(new Line2D.Double(coordinateToPixel(xStart), coordinateToPixel(yStart), coordinateToPixel(xEnd), coordinateToPixel(yEnd)));
        for (Shape odcinki : odcinkiRysowane) {
            g2.draw(odcinki);
        }

        t += step;
        g2.setPaintMode( );


        try {
            Thread.sleep(3);
            if (t < tMax) {
                this.revalidate();
                super.repaint( );
            }

        } catch (InterruptedException e) {
            e.printStackTrace( );
        }


        //}

    }

    private double x(double t) {
        return (R - r) * Math.cos(t) + d * Math.cos(t * (R - r) / r);
    }

    private double y(double t) {
        return (R - r) * Math.sin(t) - d * Math.sin(t * (R - r) / r);
    }

    /**
     * Wyznaczenie położenia piksela na obrazku dla danej wartości współrzędnej x lub y.
     * @param c wartość współrzędnej x lub y
     * @return indeks piksela na obrazku
     */
    private double coordinateToPixel(double c) {
        return PANEL_SIZE_IN_PX / 2d + (PANEL_SIZE_IN_PX / 2d / axesLimit) * c;
    }

    /**
     * Wyznaczenie maksymalnej wartość parametru t dla danych wartości parametrów hipotrochoidy.
     * @return maksymalna wartość parametru t
     */
    private double computeTMax() {
        return 2 * Math.PI * HypotrochoidUtils.leastCommonMultiple(R, r) / R;
    }

    /**
     * Sprawdzenie działania klasy.
     * @param args nieużywane.
     */
    public static void main(String... args) {
        int R = 99, r = 3, d = 56;
        JFrame frame = new JFrame("Hipotrochoid: R = " + R + ", r = " + r + ", d = " + d);
        frame.add(new HypotrochoidPanel(R, r, d));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}