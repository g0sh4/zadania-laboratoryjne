public class Averager {
    public static void main(String[] args){
        double[] vals = new double[]{1.5, 3.0, 5.2};


        double suma = 0;
        for(int i=0; i<vals.length; i++){
            suma = suma + vals[i];

        }
        System.out.println("suma = " +suma);
        System.out.println("średnia= "+suma/vals.length);


    }




}
