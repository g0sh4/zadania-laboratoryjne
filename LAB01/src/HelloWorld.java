public class HelloWorld {
    static int add(int a, int b){
        return a+b;
    }

    public static void main(String[] args){
        System.out.println("Witaj swiecie");

        int sum1 = add(5, 4);
        int sum2 = add(7, -3);

        System.out.println("suma1 = "+sum1+"\nsuma2 = "+sum2);
        System.out.println("\n Argumenty: ");
        for (String arg : args) {
            System.out.println("   " + arg);
        }
    }
}
