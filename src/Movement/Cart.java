package Movement;

public class Cart {

    private  static boolean cartKeyUsed = false;
    private  static boolean fuelUsed = false;

    public static boolean isCartKeyUsed() {
        return cartKeyUsed;
    }

    public  static boolean isFuelUsed() {
        return fuelUsed;
    }

    public static void setCartKeyUsed(boolean cartKeyUsed) {
        cartKeyUsed = cartKeyUsed;
    }

    public static void setFuelUsed(boolean fuelUsed) {
        fuelUsed = fuelUsed;
    }


    public static boolean useCart(String item, String tIntractable, Player player) {
        Validation v = new Validation();
        String [] pInven = player.getInventory();
        if(player.isInCart()){
            System.out.println("You get out of the cart");
            return false;
        }else if(!player.isInCart() && fuelUsed && cartKeyUsed){
            System.out.println("You get into the cart");
            return true;
        }
        if (item.equalsIgnoreCase(tIntractable)) {
            if (v.validateInput("fuel", player.getInventory()).equalsIgnoreCase("fuel") && v.validateInput("cart-key", player.getInventory()).equalsIgnoreCase("cart-key")) {
                System.out.println("You re-fuel the cart and start it with the key and get in");
                cartKeyUsed = true;
                fuelUsed = true;
                player.removeItems("cart-key");
                player.removeItems("fuel");

            } else if (v.validateInput("fuel", player.getInventory()).equalsIgnoreCase("fuel") && !v.validateInput("cart-key", player.getInventory()).equalsIgnoreCase("cart-key")) {
                System.out.println("You re-fuel the cart but it's still needs a key to start it");
                fuelUsed = true;
                player.removeItems("fuel");

                } else if (!v.validateInput("fuel", player.getInventory()).equalsIgnoreCase("fuel") && !v.validateInput("cart-key", player.getInventory()).equalsIgnoreCase("cart-key")) {
                if(fuelUsed){
                    System.out.println("I still need the key");
                }else {
                    System.out.println("It seems to need fuel and a key");
                }
            } else if(!v.validateInput("fuel", player.getInventory()).equalsIgnoreCase("fuel") && v.validateInput("cart-key", player.getInventory()).equalsIgnoreCase("cart-key")){
                if(fuelUsed) {
                    System.out.println("You use the cart-key to start the cart and get in");
                    cartKeyUsed = true;
                    player.removeItems("cart-key");

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
