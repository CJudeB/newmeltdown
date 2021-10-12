package MultiArray;

public class Definer {
    private String name;
    private String describe;

    public Definer(String vName, String vDescribe) {
        this.name = vName;
        this.describe = vDescribe;
    }

    public String getName() {
        return name;
    }

    public void setName(String vName) {
        this.name = vName;
    }

    public String getDescribe() {
        return describe;
    }


    public void setDescribe(String vDescribe) {
        this.describe = vDescribe;
    }

/*
    move n, s, e, w       	|     use (item)      	|       pick-up (item)	|	menu menu

    inventory i           	|     map m           	|       quit q		| 	exit exit


    Enter text commands to control your character.
    Take note of the descriptions, and the map.

    You have 100 health.  You lose health every turn from environmental damage.
    Each turn you must choose to either move or use/drop an item. You cannot do both.
            (Except with drop - you can drop an item and pickup a different item in the same turn).

    To pickup, drop, or use (interact with) an item, type the keyword (use, drop or pick-up) and item name.
    To move or exit type the keyword move or exit and the direction, n, s, e, w.

    To view map type m, to view inventory type i,, your inventory holds up to 5 items (not including map)
    To access this menu type menu. To quit game type q.
*/


}








