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

    public void setCartKeyUsed(boolean cartKeyUsed) {
        this.cartKeyUsed = cartKeyUsed;
    }

    public void setFuelUsed(boolean fuelUsed) {
        this.fuelUsed = fuelUsed;
    }

    public void useItem(String invenItem, String tIntractable) {
        String intractable = tIntractable.toLowerCase();
        String item = invenItem.toLowerCase();

        //Super messy but wanted to add interaction with cart to include re-fuel first then key.
        // I do think re-fueling and using key should happen in one turn.
        // TBH not sure where useItem should be called to get let the player to also use the key.

        if (item.equals("fuel") && intractable.equals("cart")) {
            this.fuelUsed = true;
            System.out.println("You've re-fueled the cart. What next?");
            useItem(invenItem, tIntractable);

            if (item.equals("cart key") && intractable.equals("cart")) {
                this.cartKeyUsed = true;
                System.out.println("You use the key to start the cart");
            } else {
                System.out.println("This item can't be used here");
            }
        } else {
            System.out.println("This item can't be used here");
        }
    }



    public static boolean useWrench (String item, String tIntractable, Player player) {
        Validation v = new Validation();
        //If not holding wrench
        if (!v.validateInput(item, player.getInventory()).equalsIgnoreCase("wrench")) {
            //If player on 2C
            if(tIntractable.equalsIgnoreCase("pipeline")){
                System.out.println("If you had a tool you might be able to  fix the pipe");
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







