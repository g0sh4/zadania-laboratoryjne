import java.util.Objects;


public class Mixer {

    private String brand = "Esperanza";
    private boolean wire = false;
    private int power = 0;
    private double weight = 0.0;
    private String size = "compact";
    private double price = 0;

    /**
     *
     * @return brand name
     */
    public String getBrand() {
        return brand;
    }

    /**
     *
     * @return boolean value (if wire is needed or not)
     */
    public boolean isWire() {
        return wire;
    }

    /**
     *
     * @return power value [W]
     */
    public double getPower() {
        return power;
    }

    /**
     *
     * @return object's weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     *
     * @return size of the object
     */
    public String getSize() {
        return size;
    }

    /**
     *
     * @return price of the object
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @param brand setting brad name
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     *
     * @param power setting a value for the power in [W]
     */
    public void setPower(int power) {
        this.power = power;
    }

    /**
     *
     * @param price setting a value for the price [PLN]
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * @param size setting a descriptive value for the size
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     *
     * @param weight setting a value of the object's weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     *
     * @param wire setting whether a wire is needed
     */
    public void setWire(boolean wire) {
        this.wire = wire;
    }

    /**
     *
     * @return String with all infomration about the object
     */
    public String toString(){
        return "[" +getClass().getName()+" " + getBrand() +"]"+ "\n" +" wire: "+isWire()+ "\n" +" power: "+getPower()+"\n" +" weight: "+getWeight()+"\n" +" size: "+getSize()+"\n" +" price: "+getPrice();
    }
    //public void working(String brand){
        //System.out.println(getClass().getName()+ " "+ getBrand()+ " is working a power of  "+ getPower()+"W.");
    //}

    /**
     * Print the valueof power of the working object.
     */
    public void run(){
        System.out.println(getClass().getName()+" " +getBrand() + " is running with the power "+ getPower()+" W. ");
    }

    public void expensive(){
        if(getPrice()<=100.0){
            System.out.println(getClass().getName()+" " +getBrand() +" is in a very good price.");
        }
        else{
            System.out.println(getClass().getName()+" " +getBrand()+ "is expensive. Ask for a discount");
        }

    }


    public void wires(){
        if(isWire()==true){
            System.out.println(getClass().getName()+" " +getBrand() + " requires wire connection to the power source. ");
        }
        else{
            System.out.println(getClass().getName()+" " +getBrand()+ " can be used remotely");
        }
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mixer mixer = (Mixer) o;
        return brand == mixer.brand &&
                weight == mixer.weight &&
                price == mixer.price &&
                Objects.equals(size, mixer.size);
    }
    @Override
    public int hashCode() {
        return Objects.hash(getPrice(), isWire(), getBrand(), getWeight(), getSize(), getPower());
    }



    public static void main(String[] args){
        Mixer mixer1 = new Mixer();
        mixer1.setBrand("Esperanza");
        mixer1.setWire(true);
        mixer1.setPower(200);
        mixer1.setWeight(1.55);
        mixer1.setSize("compact");
        mixer1.setPrice(90.99);


        Mixer mixer2 = new Mixer();
        mixer2.setBrand("Samsung");
        mixer2.setPower(150);
        mixer2.setWire(true);
        mixer2.setSize("compact");
        mixer2.setWeight(1.00);
        mixer2.setPrice(169.99);

        Mixer mixer3 = new Mixer();
        mixer3.setBrand("Bosh");
        mixer3.setPower(170);
        mixer3.setWire(false);
        mixer3.setWeight(2.25);
        mixer3.setSize("very small");
        mixer3.setPrice(98.99);

        Mixer mixer4 = new Mixer();
        mixer4.setBrand("Bosh");
        mixer4.setPower(170);
        mixer4.setWire(false);
        mixer4.setWeight(2.25);
        mixer4.setSize("very small");
        mixer4.setPrice(98.99);

        System.out.println(mixer1.toString()+ "\n"  );
        System.out.println(mixer2.toString()+ "\n" );
        System.out.println(mixer3.toString()+ "\n" );
        mixer1.run();
        mixer2.wires();

        System.out.println(mixer1.equals(mixer2));
        System.out.println(mixer3.equals(mixer4));
        System.out.printf("\n mixer1 = [%s], mixer.hashCode() = %d%n", mixer1, mixer1.hashCode(), "\n");

        mixer3.expensive();
    }
}



