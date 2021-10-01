package Movement;

import java.util.Locale;

public class Items {

    private boolean cartKeyUsed = false;

    public boolean isCartKeyUsed() {
        return cartKeyUsed;
    }

    public void useItem(String invenItem, String tInteractable){
        String interactable =   tInteractable.toLowerCase();
        String item = invenItem.toLowerCase();

        if(item.equals("cart key") && interactable.equals("cart"))
        {
                this.cartKeyUsed = true;
                System.out.println("You use the key to start the cart");
            }else{
                System.out.println("This item can't be used here");
            }


        }
    }

