package Movement;

import static Movement.CalculateDamage.calculateDamage;

public class Cart {

    private  static boolean cartKeyUsed = false;
    private  static boolean fuelUsed = false;

    /**
     * Is cart key used boolean.
     *
     * @return the boolean
     */
    public static boolean isCartKeyUsed() {
        return cartKeyUsed;
    }

    /**
     * Is fuel used boolean.
     *
     * @return the boolean
     */
    public  static boolean isFuelUsed() {
        return fuelUsed;
    }

    /**
     * Use cart boolean. The method for interacting with the cart.
     *
     * @param item         the item entered by the user
     * @param tIntractable the tiles intractable item
     * @param player       the instance of the current player
     * @return the boolean returns to setCart setter
     */
    public static boolean useCart(String item, String tIntractable, Player player, Tile tile) {
        Validation v = new Validation();
        if(player.isInCart()){
            System.out.println("You get out of the cart");
            calculateDamage(player, tile);
            return false;
        }else if(!player.isInCart() && fuelUsed && cartKeyUsed){
            System.out.println("You get into the cart");
            calculateDamage(player, tile);
            return true;
        }
        if (item.equalsIgnoreCase(tIntractable)) {
            if (v.validateInput("jerry-can", player.getInventory()).equalsIgnoreCase("jerry-can") && v.validateInput("key", player.getInventory()).equalsIgnoreCase("key")) {
                System.out.println("You re-fuel the cart and start it with the key and get in");
                cartKeyUsed = true;
                fuelUsed = true;
                player.removeItems("key");
                player.removeItems("jerry-can");
                calculateDamage(player, tile);

            } else if (v.validateInput("jerry-can", player.getInventory()).equalsIgnoreCase("jerry-can") && !v.validateInput("key", player.getInventory()).equalsIgnoreCase("key")) {
                System.out.println("You re-fuel the cart but it's still needs a key to start it");
                fuelUsed = true;
                player.removeItems("jerry-can");
                calculateDamage(player, tile);

                } else if (!v.validateInput("jerry-can", player.getInventory()).equalsIgnoreCase("jerry-can") && !v.validateInput("key", player.getInventory()).equalsIgnoreCase("key")) {
                if(fuelUsed){
                    System.out.println("I still need the key");
                }else {
                    System.out.println("It seems to need fuel and a key");
                }
            } else if(!v.validateInput("jerry-can", player.getInventory()).equalsIgnoreCase("jerry-can") && v.validateInput("key", player.getInventory()).equalsIgnoreCase("key")){
                if(fuelUsed) {
                    System.out.println("You use the cart-key to start the cart and get in");
                    cartKeyUsed = true;
                    player.removeItems("key");
                    calculateDamage(player, tile);

                }else
                System.out.println("I have the key for the cart but it seems to be out of fuel");
            }
        }else
            System.out.println("There doesn't seem to be an item like that here");

        if (isCartKeyUsed() && isFuelUsed()) {
            return true;
        } else
            return false;

    }
}
