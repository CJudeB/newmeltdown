package Movement;

import java.util.LinkedHashMap;

class Event {


    private static Player player;


    public Event() {

    }

    public static String getPrologue() {
        return prologue;
    }

    public static void setPrologue(String prologue) {
        Event.prologue = prologue;
    }

    private static String prologue;
    private static LinkedHashMap<String, String> tiles = new LinkedHashMap<>();

    public static LinkedHashMap<String, String> getTiles() {
        return tiles;
    }

    public static void setTiles(LinkedHashMap<String, String> tiles) {
        Event.tiles = tiles;
    }

    public static String currentEvent(Player player) {


        tiles.put("0", """
                /-------------------------------------------------------------------------------------------------------\n
                (Storyline takes control of player here).\n
                You decide to climb the exterior bridge where you can turn on an auxiliary coolant system.
                As you climb stairs the dosimeter cuts out. Story driven choice presented here.\sGo up or – you die on the roof.\n
                Stay ground level – remain downstairs you can save the day. 1a
                                                           
                """);


        tiles.put("1", """
                /-------------------------------------------------------------------------------------------------------\n
                You either skip this tile in cart or there’s nothing to see here especially. 1b
                                      
                """);


        tiles.put("2", """
                /-------------------------------------------------------------------------------------------------------\n
                Storyline makes it clear you have to exit cart if you want to go south into coolant facility. 1c\s
                """);


        tiles.put("3", "1d_");

        tiles.put("4", "1e_");

        tiles.put("5", """
                /-------------------------------------------------------------------------------------------------------\\\n
                You skip this tile if you're in the cart. There's nothing to see here on foot. \s. 2a
                """);

        tiles.put("6", "2b_");

        tiles.put("7", """
                /-------------------------------------------------------------------------------------------------------\\\n
                Storyline 2 ending. Possible challenge here or is just bringing wrench and making it here enough?.\n\n,
                If you have wrench you can prevent a meltdown. Your fate is unclear.2c\s
                """);


        tiles.put("8", "2d_");

        tiles.put("9", "2e_");

        tiles.put("10", """
                /-------------------------------------------------------------------------------------------------------\\\n
                You arrive at the facilities’ foyer. Through the massive glass lined entrance, you can see emergency services and military congregating.\s
                Leads to ending 1.\n
                \n(‘Another’ if from south) or (‘A’ if from east) + ‘small utility cart is parked nearby, but there’s no key in the ignition.’
                                               
                """);

        tiles.put("11", "3c_");

        tiles.put("12", "3d_");

        tiles.put("13", "3e_");

        tiles.put("14", """
                /-------------------------------------------------------------------------------------------------------\\\n
                                        
                """);


        tiles.put("15", """
                /-------------------------------------------------------------------------------------------------------\\\n
                You arrive at a T junction. Deserted administration offices line the walls. Your memory is retuning though. \s
                The main entrance is to the north, not far away. To the south there there a just more offices. 4a
                """);


        tiles.put("16", """
                /-------------------------------------------------------------------------------------------------------\\\n
                You continue west where the hall is heavily obstructed by debris. It’s slow going and by the time you navigate\s
                through, you’re shaking with fatigue. You notice your hands look sunburnt. 4b\s
                """);


        tiles.put("17", """
                /-------------------------------------------------------------------------------------------------------\\\n
                \nYou enter a wide hall. The damage here is worse than the control room whole sections of the
                building have caved in. Through gaps in the ceiling you notice plumes of smoke billowing overhead
                rising from the north east, where the reactor is.\n
                Silvery ash fills the air, falling like snow. You notice a metallic taste in your mouth.4c\s\s
                """);

        tiles.put("18", """
                /-------------------------------------------------------------------------------------------------------\n
                You get up, woozy, legs like lead. This is a control room, you recall, or what’s left of it.\s
                On the far side of the room where the damage is worst you see two bodies, a mess of limbs and masonry.\s 
                You shudder – that’s Alexi and Pasha from your section. \nYou have to get out of here.\n
                A draft is blowing from the west exit, and an acrid smell.  To the east is another exit. 
                \nYou try and focus but you've no idea where they lead, the persistent, violent whine of the siren does not help.\s
                \nA map of the facility has fallen its frame and lies on floor nearby. 4d\n
                """);

        tiles.put("19", """
                /-------------------------------------------------------------------------------------------------------\\\n
                You enter another control room - home to a dizzying array of monitoring apparatus.\nYour memory is returning now - this room is familiar.
                You can't help notice a panel labelled 'Core Regulator', lit-up like an angry fairground attraction.
                You do not like the look of that panel.\n\nThere are two exits -to the west, where you entered, or south. 4e
                """);

        tiles.put("20", """      
                /-------------------------------------------------------------------------------------------------------\\\n
                The hall bends north and you approach a stretch of workshops. Inside one room you see a utility cart,\s
                the type used to transport light goods around the facility. It’s in disrepair unfortunately.
                Your legs suddenly turn to jelly and you have to hold onto a workbench to keep from collapsing, almost toppling a row of jerry cans.\n\n
                When the spell passes you continue. 5a
                """);

        tiles.put("21", """
                                              
                 /-------------------------------------------------------------------------------------------------------\\\n
                You approach a line of built-in storage lockers. Several lie face down on the floor, wrenched from the wall.
                None of the combination locks are open though. You notice something  etched into the back of one locker.
                \n4b*1c-5c, (2a*3b%1b)-3d, 3d+=3d.\n
                Did you just hear a Geiger dosimeter? In the moments between siren phases, you swear you did, from this same locker.
                \nYou put your ear to the metal and the clicking. The noise is chilling, only extreme radiation can cause that reading.
                You consider the etchings again - Hazmat suits are stored with Geiger dosimeters you recall. .5b\s
                """);

        tiles.put("22", """ 
                /-------------------------------------------------------------------------------------------------------\\\n
                \nYou can make out a bend in the hall ahead. You have to use the wall to support yourself now. 5c
                """);

        tiles.put("23", """ 
                /-------------------------------------------------------------------------------------------------------\\\n
                You approach an abandoned security checkpoint consisting of a guard’s booth and turnstile.\s
                On the floor by the booth, is an overturned card table and a half empty bottle of Stolichnaya.\s
                Looks like the guard was in a hurry to leave. 5d
                \s
                """);

        tiles.put("24", """ 
                /-------------------------------------------------------------------------------------------------------\\\n
                \nYou enter a massive corridor that curves to the west. The reverberating of the siren is especially loud in here,
                A man is slumped on the floor, his white uniform stained dark with blood. He becomes very animated when he sees you,
                yells and waves you over." You approach, and see he his terribly wounded. You can barely hear what he’s saying due to siren.
                You catch a few words. Something’s blown? Coolant tower?...Had you seen the readings he wants to know? What were the readings? 5e
                \s
                """);

        tiles.put("25", """ 
                /-------------------------------------------------------------------------------------------------------\\\n
                move n, s, e, w       	|     use (item)      	|       pick-up (item)	|	menu menu
                inventory i           	|     map m           	|       quit q		    | 	exit exit\n
                Enter text commands to control your character. Take note of the descriptions, and the map.
                You have 100 health.  You lose health every turn from environmental damage.
                Each turn you must choose to either move or use/drop an item. You cannot do both.5e
                (Except with drop - you can drop an item and pickup a different item in the same turn)
                                        
                To pickup, drop, or use (interact with) an item, type the keyword (use, drop or pick-up) and item name.
                To move or exit type the keyword move or exit and the direction, n, s, e, w
                                        
                To view map type m, to view inventory type i, your inventory holds up to 5 items (not including map)
                To access this menu type menu. To quit game type q.
                """);


        String s = Integer.toString(player.getPosition());
        return tiles.get(s);
    }

    public static String initialDescription(String prologue) {

        prologue = "\n" +
                "" +
                "/-------------------------------------------------------------------------------------------------------\n" +
                "\nSomewhere in the Soviet Union, 1984.\n\nThe siren jolts you from unconsciousness.\n\n" +
                "You come-to in what looks like a warzone, lying among rubble and dust, a pulsing ache in your head.\n" +
                "The first thing you notice, beside the pain, is that the ceiling has partially collapsed. \n" +
                "This explains your headache, and your confusion - You have no memory of where you are, or what's happening,\n" +
                "you realise - It's a blank slate. For a moment the memory of who YOU ARE feels like it might slip away.\n\n" +
                "No. that memory you still have.\n\n" +
                "'I’m an Energetiki power engineer with the ministry of Electrification'. You say resolutely. \n" +
                "'I work here, at this nuclear power plant'.\n\n" +
                "To begin type start.\n\n";

        System.out.println(prologue);
        return prologue;


    }

    public static void displayMenu() {
        String displayM;
        displayM = tiles.get("25");
        System.out.println(displayM);
    }
}


