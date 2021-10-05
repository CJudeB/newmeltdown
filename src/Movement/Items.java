package Movement;

import java.util.Locale;

public class Items {
    private boolean cartKeyUsed = false;
    private boolean fuelUsed = false;

    public boolean isCartKeyUsed() {
        return cartKeyUsed;
    }

    public boolean isFuelUsed() {
        return fuelUsed;
    }

    public void useItem(String invenItem, String tInteractable) {
        String interactable = tInteractable.toLowerCase();
        String item = invenItem.toLowerCase();

        //Super messy but wanted to add interaction with cart to include re-fuel first then key.
        // I do think re-fueling and using key should happen in one turn.
        // TBH not sure where useItem should be called to get let the player to also use the key.

        if (item.equals("fuel") && interactable.equals("cart")) {
            this.fuelUsed = true;
            System.out.println("You've re-fueled the cart. What next?");
            useItem(invenItem, tInteractable);

            if (item.equals("cart key") && interactable.equals("cart")) {
                this.cartKeyUsed = true;
                System.out.println("You use the key to start the cart");
            } else {
                System.out.println("This item can't be used here");
            }
        } else {
            System.out.println("This item can't be used here");
        }
    }

    public static boolean useCart(String item, String tInteractable, Player player) {
        Validation v = new Validation();
        if (item.equalsIgnoreCase(tInteractable)){
            if (v.validateInput("fuel", player.getInventory()).equalsIgnoreCase("fuel") && v.validateInput("cart-key", player.getInventory()).equalsIgnoreCase("cart-key")) {

                System.out.println("You re-fuel the cart and start it with the key");
                return true;
            } else if (v.validateInput("fuel", player.getInventory()).equalsIgnoreCase("fuel") && !v.validateInput("cart-key", player.getInventory()).equalsIgnoreCase("cart-key")) {
                System.out.println("It seems you're missing the key");
                return false;
            } else if (!v.validateInput("fuel", player.getInventory()).equalsIgnoreCase("fuel") && !v.validateInput("cart-key", player.getInventory()).equalsIgnoreCase("cart-key")) {
                System.out.println("It seems to be out of fuel");
                return false;
            }
        }
        System.out.println("The cart seems to need fuel and a key to work");
        return false;
    }

    public static boolean useWrench (String item, String tInteractable, Player player){
        Validation v = new Validation();
        if(item.equalsIgnoreCase(tInteractable)){
            if(v.validateInput("wrench", player.getInventory()).equalsIgnoreCase("wrench")){
                System.out.println("You use the wrench to fix the pipe");
                return true;
            }
        }
        System.out.println("If you had a tool you could fix the pipeline");
        return false;
    }

    public static boolean useHazmat (String item, Player player){
        Validation v = new Validation();
        if(v.validateInput(item, player.getInventory()).equalsIgnoreCase("hazmat")){

            System.out.println("You change into the lead lined clothing");
            return true;
        }
        System.out.println("You don't have any protective clothing");
        return false;
    }
}







