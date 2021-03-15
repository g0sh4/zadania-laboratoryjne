import java.util.ArrayList;

/**
 * Kitchen Mixer needs a power supply to work (connect to electricity, if possible), can be cleaned (under certain conditions),
 * If we can classify the mixer as a smart device, it can storage the recipes, delete them or show number of them stored.
 */
public class KitchenMixer extends Mixer{



    private boolean working = false;
    private boolean clean = true;
    private boolean connected = false;

    private boolean isConnected(){
        return connected;
    }
    private boolean isWorking(){
        return working;
    }
    private boolean isClean(){
        return clean;
    }
    public void connect(){
        connected = true;
    }
    public void disconnect(){
        connected=false;
    }

    /**
     * this method enables us to run our device,
     before checking if it is connected (if required)
     */
    public void startWorking(){
        if(isWire() && !isConnected()){
            throw new RuntimeException("Cannot start working. " + getClass().getSimpleName() +
                    "require connection to the power source. ");

        }
        if (isWire() && isConnected()){
            System.out.println(getClass().getSimpleName()+ " started working.");
            working = true;
            clean = false;
        }
        if (!isWire()){
            working = true;
            clean = false;
        }


    }

    /**
     *allows us to terminate the operation of the device
     */
    public void stopWorking(){
        if(isWire() && isConnected()){
            connected = false;
            working = false;

        }
        if (isWire() && !isConnected()){
            System.out.println("Cannot stop working not working device. ");

        }
        if (!isWire()){
            working = false;
        }

    }

    /**
     * allows us to clean the device, checking beforehand whether the device requires it and whether it is disconnected
     */
    public void clean(){
        if (isConnected() && isWorking()){
            System.out.println("It is required to turn off and disconnect the device first");
        }

        if(isConnected() && !isWorking()){
            System.out.println("It is required to disconnect the device first");
        }
        if(!isConnected() && !isWorking()){
            if(isClean()){
                System.out.println("There is no nead to clean that device.");
            }
            if(!isClean()){
                clean =true;
                System.out.println("Now device is clean.");
            }
        }
    }
    private ArrayList<String> recipeNames = new ArrayList<>();

    /**
     *
     * @param recipeName
     * we can add new recipe to our device's memory
     */
    public void addRecipe(String recipeName) {
        if (isSmart() && isWorking()) {
            recipeNames.add(recipeName);
            setRecipeNumber(getRecipeNumber() + 1);
        }
    }

    /**
     * allows us to get list od the recipes names
     */
    public void getRecipe(){
        System.out.println(recipeNames);
    }

    /**
     *
     * @param recipeName
     * @return
     * allows us to remove recipe from our device's memory
     */
    public boolean removeRecipe(String recipeName){
        if (isSmart() && isWorking()) {
            recipeNames.remove(recipeName);
            setRecipeNumber(getRecipeNumber() - 1);
            return true;
        } else {
            return false;
        }

    }


    public static void main(String... args) {


        Mixer m = new Mixer();
        Mixer km = new KitchenMixer();
        KitchenMixer kitchenMixer = new KitchenMixer();
        kitchenMixer.setBrand("Bosh");
        kitchenMixer.setWire(true);
        kitchenMixer.setPower(200);
        kitchenMixer.setWeight(3.90);
        kitchenMixer.setSize("large");
        kitchenMixer.setPrice(299.99);
        kitchenMixer.setSmart(true);
        kitchenMixer.setRecipeNumber(0);

        //System.out.println(m);
        //System.out.println(km);
        System.out.println(kitchenMixer);
        kitchenMixer.connect();
        kitchenMixer.startWorking();
        kitchenMixer.addRecipe("Applepie");
        kitchenMixer.addRecipe("Basic cake");
        kitchenMixer.getRecipe();
        kitchenMixer.clean();
        kitchenMixer.disconnect();
        kitchenMixer.clean();

    }

}

