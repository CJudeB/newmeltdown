package Movement;

public class Items {


    private boolean cartKeyUsed = false;
    private boolean fuelUsed = false;

    public boolean isCartKeyUsed() {
        return cartKeyUsed;
    }

    public boolean isFuelUsed() {
        return fuelUsed;
    }

    public void setCartKeyUsed(boolean cartKeyUsed) {
        this.cartKeyUsed = cartKeyUsed;
    }

    public void setFuelUsed(boolean fuelUsed) {
        this.fuelUsed = fuelUsed;
    }


    /**
     * Use wrench boolean. The interaction method for using the wrench.
     * Includes blocks for the player not having the wrench and trying to use the pipeline
     *
     * @param item         the item that the user input to interact with
     * @param tIntractable the tiles intractable item
     * @param player       the player instance from game
     * @return the boolean
     */
    public static boolean useWrench (String item, String tIntractable, Player player) {
        Validation v = new Validation();
        //If not holding wrench
        if (!v.validateInput(item, player.getInventory()).equalsIgnoreCase("wrench")) {
            //If player on 2C
            if(tIntractable.equalsIgnoreCase("pipeline")){
                System.out.println("If you had a tool you might be able to fix the pipe");
            }else
                System.out.println("I'm not holding an item like that");
            return false;
        }
        //If wrench is in inventory and on 2C
        else if(v.validateInput(item, player.getInventory()).equalsIgnoreCase("wrench") && tIntractable.equalsIgnoreCase("pipeline")) {
            System.out.println("You use the wrench to fix the pipe");
            return true;
        }
        //If wrench is in inventory and not on 2C
        else if (v.validateInput(item, player.getInventory()).equalsIgnoreCase("wrench") && !tIntractable.equalsIgnoreCase("pipeline")){
            System.out.println("I'm not sure what I would use that for here");
            return false;
        } else
            return false;
    }


    public static boolean useHazmat (String item, Player player) {
        Validation v = new Validation();
        String[] pInven = player.getInventory();
        if (v.validateInput(item, player.getInventory()).equalsIgnoreCase("hazmat")) {
            System.out.println("You change into the Hazmat suit\nYou notice it has a inbuilt geiger counter");
            return true;
            } else
        System.out.println("You don't have any protective clothing");
        return false;
    }

    public static void useReactorMap(String item, Tile tile){
    }
    public static void useCabinets (String item, Tile tile){
        if(item.equalsIgnoreCase("cabinet")){
            System.out.println("You turn the cabinet over, as you do so a Hazmat suit and ");
        }


    }
}







