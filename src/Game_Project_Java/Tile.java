package Game_Project_Java;
import java.util.ArrayList;

public class Tile {



    private String tDescription, tIntractable, tCart;
    private ArrayList<String> tItems = new ArrayList<>();
    private boolean tN, tE, tS, tW, hasVisited;
    private int damVal;


    public Tile(String tDescription, String tIntractable, String tCart, boolean hasVisited, boolean tN, boolean tE, boolean tS, boolean tW, int damVal) {

        this.tDescription = tDescription;
        this.tIntractable = tIntractable;
        this.tCart = tCart;
        this.tN = tN;
        this.tE = tE;
        this.tS = tS;
        this.tW = tW;
        this.damVal = damVal;
        this.hasVisited = false;

    }

    public Boolean gettN() {
        return tN;
    }

    public Boolean gettE() {
        return tE;
    }

    public Boolean gettS() {
        return tS;
    }

    public Boolean gettW() {
        return tW;
    }

    public String gettDescription() {
        return tDescription;
    }

    public String gettIntractable() {
        return tIntractable;
    }

    public String gettCart() {
        return tCart;
    }

    public void settCart(String tCart) {
        this.tCart = tCart;
    }

    public int getDamVal() {
        return damVal;

    }

    public void settItems(String item) {
        this.tItems.add(item);
    }

    public ArrayList<String> gettItems() {
        return tItems;
    }

    /**
     * Remove an item from the tile item array.
     *
     * @param item the item
     */
    public void removeItem(String item) {

        for (int i = 0; i < tItems.size(); i++) {
            if (item.equals(this.tItems.get(i))) {
                this.tItems.remove(i);
            }
        }
    }

    public boolean isHasVisited() {
        return hasVisited;
    }

    public void setHasVisited(boolean hasVisited) {
        this.hasVisited = hasVisited;
    }
}
