package Movement;

public class Cart {

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

    
    public boolean useCart(String item, String tIntractable, Player player) {
        Validation v = new Validation();
        if (item.equalsIgnoreCase(tIntractable)) {
            if (v.validateInput("fuel", player.getInventory()).equalsIgnoreCase("fuel") && v.validateInput("cart-key", player.getInventory()).equalsIgnoreCase("cart-key")) {
                System.out.println("You re-fuel the cart and start it with the key and get in");
                this.cartKeyUsed = true;
                this.fuelUsed = true;

            } else if (v.validateInput("fuel", player.getInventory()).equalsIgnoreCase("fuel") && !v.validateInput("cart-key", player.getInventory()).equalsIgnoreCase("cart-key")) {
                System.out.println("You re-fuel the cart but it's still needs a key to start it");
                this.fuelUsed = true;
            } else if (!v.validateInput("fuel", player.getInventory()).equalsIgnoreCase("fuel") && !v.validateInput("cart-key", player.getInventory()).equalsIgnoreCase("cart-key")) {
                System.out.println("It seems to need fuel and a key");
            }else if(!v.validateInput("fuel", player.getInventory()).equalsIgnoreCase("fuel") && v.validateInput("cart-key", player.getInventory()).equalsIgnoreCase("cart-key")){
                if(this.fuelUsed){
                    System.out.println("You use the cart-key to start the cart and get in");
                    this.cartKeyUsed = true;
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
