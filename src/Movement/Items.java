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
        }else {
            System.out.println("This item can't be used here");
        }
    }
}






