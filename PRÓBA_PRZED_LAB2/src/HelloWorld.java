public class HelloWorld {

    //takie metody statyczne nie wymagają obiektów
    //int/double/void/float - ale jakieś musi być

    //int a i int b to parametry
    static int add(int a, int b){
        //ciało funkcji
        return a+b;
    }

    //args - sys argv - parametry wywołania programu
    //[]tablica obiektów typu sting
    public static void main(String[] argv){
        System.out.println("Hello World!");

        int sum1 = add(4,5);
        int sum2 = add(7, -3);
        System.out.println("suma = " + sum1);
        System.out.println("suma2 = "+sum2);



        System.out.println("argumenty: ");
        for (int i =0; i< argv.length; i++){
            System.out.println("  "+argv[i]);
        }

        System.out.println("Inna forma");
        for (String a: argv){
            System.out.println("   "+ a);
        }


    }
}
