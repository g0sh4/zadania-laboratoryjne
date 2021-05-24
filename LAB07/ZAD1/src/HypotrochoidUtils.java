

/**
 * Funkcje pomocnicze wykorzystywane przy rysowaniu hipotrochoid.
 * źródło: https://stackoverflow.com/a/4202114
 */
public class HypotrochoidUtils {

    /**
     * Największy wspólny dzielnik liczb a i b.
     */
    public static int greatestCommonDivisor(int a, int b) {
        while (b > 0) {
            int c = b;
            b = a % b;
            a = c;
        }
        return a;
    }

    /**
     * Najmniejsza wspólna wielokrotność liczb a i b.
     */
    public static int leastCommonMultiple(int a, int b) {
        return a * (b / greatestCommonDivisor(a, b));
    }
}
