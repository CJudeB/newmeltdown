package Movement;
import java.util.ArrayList;

public class Tile {

    public Tile(){}

    private String tDescription, tIteractable, tPuzzle;
    private ArrayList <String> tItems = new ArrayList<>();
    private boolean tN, tE, tS,tW;
    private int damVal;

    public Tile(String tDescription, String tInteractable, String tPuzzle, Boolean tN, Boolean tE, Boolean tS, Boolean tW, int damVal) {

        this.tDescription = tDescription;
        this.tIteractable = tInteractable;
        this.tPuzzle = tPuzzle;
        this.tN = tN;
        this.tE = tE;
        this.tS = tS;
        this.tW = tW;
        this.damVal = damVal;

    }

    public Boolean gettN()
    {
        return tN;
    }

    public Boolean gettE()
    {
        return tE;
    }

    public Boolean gettS()
    {
        return tS;
    }

    public Boolean gettW()
    {
        return tW;
    }

    public String gettDescription() {
        return tDescription;
    }

    public int getDamVal() {
        return damVal;

    }
        /*
   public void settDescription(String tDescription) {
        this.tDescription.add(tDescription);
    }   */

    public String gettItems(int index) {
        return tItems.get(index);
    }

    public void settItems(String item) {
        this.tItems.add(item);
    }

    public ArrayList<String> gettItems() {
        return tItems;
    }

    public void removeItem(String item){

        for (int i = 0 ; i < tItems.size(); i++){
                if(item.equals(this.tItems.get(i))){
                    this.tItems.remove(i);
            }
        }
    }

    public void printItems(){
        for (String i:tItems) {
            System.out.println(i);
        }
    }
}
