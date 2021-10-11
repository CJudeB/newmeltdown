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
            return false;
        }
        if (item.equalsIgnoreCase(tIntractable)) {
            if (v.validateInput("fuel", player.getInventory()).equalsIgnoreCase("fuel") && v.validateInput("cart-key", player.getInventory()).equalsIgnoreCase("cart-key")) {
                System.out.println("You re-fuel the cart and start it with the key and get in");
                cartKeyUsed = true;
                fuelUsed = true;
                for (int i = 0; i < pInven.length; i++) {
                    if (pInven[i].equals("cart-key") || pInven[i].equals("fuel")) {
                        pInven[i] = " ";
                        player.setInventory(pInven);
                    }
                }

            } else if (v.validateInput("fuel", player.getInventory()).equalsIgnoreCase("fuel") && !v.validateInput("cart-key", player.getInventory()).equalsIgnoreCase("cart-key")) {
                System.out.println("You re-fuel the cart but it's still needs a key to start it");
                fuelUsed = true;
                for (int i = 0; i < pInven.length; i++) {
                    if (pInven[i].equals("fuel")) {
                        pInven[i] = " ";
                        player.setInventory(pInven);
                        break;
                    }
                }
            } else if (!v.validateInput("fuel", player.getInventory()).equalsIgnoreCase("fuel") && !v.validateInput("cart-key", player.getInventory()).equalsIgnoreCase("cart-key")) {
                System.out.println("It seems to need fuel and a key");
            }else if(!v.validateInput("fuel", player.getInventory()).equalsIgnoreCase("fuel") && v.validateInput("cart-key", player.getInventory()).equalsIgnoreCase("cart-key")){
                if(fuelUsed){
                    System.out.println("You use the cart-key to start the cart and get in");
                    cartKeyUsed = true;
                    for (int i = 0; i < pInven.length; i++) {
                        if (pInven[i].equals("cart-key")) {
                            pInven[i] = " ";
                            player.setInventory(pInven);
                            break;
                        }
                    }
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
