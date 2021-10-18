package Movement;


import java.util.LinkedHashMap;


class Event {


    public Event() {

    }

    private static Player player;
    private static String displayM;
    private static String printHealth;
    private static String prologue;
    private static boolean hasVisited;

    public static boolean isInstrumentsUsed() {
        return instrumentsUsed;
    }

    public static void setInstrumentsUsed(boolean instrumentsUsed) {
        Event.instrumentsUsed = instrumentsUsed;
    }

    private static boolean instrumentsUsed;
    private static LinkedHashMap<String, String> tiles = new LinkedHashMap<>();
    private static LinkedHashMap<String, String> alternateTiles = new LinkedHashMap<>();


    public static LinkedHashMap<String, String> getAlternateTiles() {
        return alternateTiles;
    }

    public static void setAlternateTiles(LinkedHashMap<String, String> alternateTiles) {
        Event.alternateTiles = alternateTiles;
    }

    public static String getDisplayM() {
        return displayM;
    }

    public static void setDisplayM(String displayM) {
        Event.displayM = displayM;
    }

    public static String getPrintHealth() {
        return printHealth;
    }

    public static void setPrintHealth(String printHealth) {
        Event.printHealth = printHealth;
    }

    public static void getPrologue() {
    }

    public static void setPrologue(String prologue) {
        Event.prologue = prologue;
    }

    public static LinkedHashMap<String, String> getTiles() {
        return tiles;
    }

    public static void setTiles(LinkedHashMap<String, String> tiles) {
        Event.tiles = tiles;
    }




    public static void currentEvent(Player player, boolean hasVisited, Tile tile) {

        String sPos;

        sPos = Integer.toString(player.getPosition());


        if (!hasVisited) {


            tiles.put("0", """
                    /-------------------------------------------------------------------------------------------------------\n
                    \n
                    You recall there is a back-up coolant pipeline in the reactor tower.
                    You'll have to climb the exterior bridge to turn on the auxiliary coolant system.
                    As you climb stairs you pause to consider your choice.
                    You can turn on the back-up pipeline without a tool, but will the bridge be safe?
                    Type "Yes" to continue up, toward the bridge?
                    Otherwise continue toward the pipeline to the east or the exit to the south.
                     
                      _____  _____  _____  _____  _____
                     | you || 1b  ||  1c ||  1d ||  1e |                 \s
                     |_____||_____||_____||_____||_____|\s
                      _____  _____  _____  _____  _____
                     | 2a  ||  2b ||  2c ||  2d ||  2e |                 \s
                     |_____||_____||_____||_____||_____|
                      _____  _____  _____  _____  _____
                     | 3a  || 3b  || 1c  ||  1d ||  3e |                 \s
                     |_____||_____||_____||_____||_____|
                      _____  _____  _____  _____  _____
                     | 4a  || 4b  ||  4c ||  4d ||  4e |                 \s
                     |_____||_____||_____||_____||_____|
                      _____  _____  _____  _____  _____
                     | 5a ||  5b  ||  5c ||  5d ||  5e |                 \s
                     |_____||_____||_____||_____||_____|                     
                             
                    """);


            tiles.put("1", """
                    /-------------------------------------------------------------------------------------------------------\\
                                        
                    You stumble eastward trying not to stumble and fall. If you do fall, you know you won't have to energy to get up.
                    
                    
                    
                                        
                                        
                                        
                                        
                                        
                                        
                    """);


            tiles.put("2", """
                    /-------------------------------------------------------------------------------------------------------\\\n
                    You arrive at a narrow steel door labelled "Coolant Facility". You will have to exit cart if you want to go south into coolant facility. 1c\s
                    \n\n\n\n\n\n
                    """);


            tiles.put("3", "1d_");

            tiles.put("4", "1e_");

            tiles.put("5", """
                    /-------------------------------------------------------------------------------------------------------\\\n
                    You pass more offices. You see a stairwell in the distance in the north. \s. 2a
                    \n\n\n\n\n\n
                    """);

            tiles.put("6", "2b_");

            tiles.put("7", """
                    /-------------------------------------------------------------------------------------------------------\\\n
                    You can see the problem with the coolant pipeline. One of the pipes is blocked and needs to be shut-off and the coolant re-directed.2c\s
                    \n\n\n\n\n\n
                    """);


            tiles.put("8", "2d_");

            tiles.put("9", "2e_");

            tiles.put("10", """
                    /-------------------------------------------------------------------------------------------------------\\\n
                    You arrive at the facilities’ foyer. Through the massive glass lined entrance, you can see emergency services\n
                    and military congregating.\s
                    Leads to ending 1.\n
                    \nThere is one of the plant's small utility carts parked nearby, but there’s no key in the ignition.\n\n
                    \n
                                                   
                    """);

            tiles.put("11", "3c_");

            tiles.put("12", "3d_");

            tiles.put("13", "3e_");

            tiles.put("14", "/-------------------------------------------------------------------------------------------------------\\\n" +
                    "" + printHealth + "");


            tiles.put("15", """
                    /-------------------------------------------------------------------------------------------------------\\\n
                    You arrive at a T junction. Deserted administration offices line the walls. Your memory is retuning though. \s
                    The main entrance is to the north, not far away. To the south there there a just more offices. \n\n
                    \n\n\n\n\n\n
                    
                    """);


            tiles.put("16", """
                    /-------------------------------------------------------------------------------------------------------\\\n
                    You continue west where the hall is heavily obstructed by debris. It’s slow going and by the time you navigate\s
                    through, you’re shaking with fatigue. You notice your hands look sunburnt. \n\n\s
                    \n\n\n\n\n\n
                    """);


            tiles.put("17", """
                    /-------------------------------------------------------------------------------------------------------\\\n
                    \nYou enter a wide hall. The damage here is worse than the control room whole sections of the
                    building have caved in. Through gaps in the ceiling you notice plumes of smoke billowing overhead
                    from the north east, where the reactor is.\n
                    Silvery ash fills the air, falling like snow. You notice a metallic taste in your mouth.\n\n
                    \n\n\n\n\n\n4C
                    """);

            tiles.put("18", """
                    /-------------------------------------------------------------------------------------------------------\n
                    You get up, woozy, legs like lead. This is a control room, you recall, or what’s left of it.\s
                    On the far side of the room where the damage is worst you see two bodies, a mess of limbs and masonry.\s 
                    You shudder – that’s Alexi and Pasha from your section. \nYou have to get out of here.\n
                    A draft is blowing from the west exit, and an acrid smell.  To the east is another exit. 
                    \nYou try and focus but you've no idea where they lead, the persistent, violent whine of the siren does not help.\s
                    \nA map of the facility has fallen from its frame and lies on floor nearby.\n
                    Type pick-up map.
                    
                    """);

            tiles.put("19", """
                    /-------------------------------------------------------------------------------------------------------\\\n
                    You enter another control room - home to a dizzying array of monitoring apparatus.
                    Some memory is returning now - this room is familiar.\n
                    You notice one panel, labelled 'core-regulator', is lit-up like an angry fairground attraction.\n
                    You do not like the look of that panel. There is an exit west, where you entered, or south.\n
                    
                    """);

            tiles.put("20", """      
                    /-------------------------------------------------------------------------------------------------------\\\n
                    The hall bends north and you approach a stretch of workshops. You see a utility cart in one of them,\s
                    the type used to transport light goods around the facility. It’s in disrepair unfortunately.\n
                    You grab hold of a workbench to keep from falling, almost toppling a jerry-can. \n\n
                    You needed that ride.
                    
                    """);

            tiles.put("21", """
                                                  
                     /-------------------------------------------------------------------------------------------------------\\\n
                    You approach a line of built-in storage lockers. Several lie face down on the floor, wrenched from the wall.
                    None of the combination locks are open though. You notice something  etched into the back of one locker.
                    \n4b*1c-5c, (2a*3b%1b)-3d, 3d+=3d.\n
                    Did you just hear a Geiger dosimeter? In the moments between siren phases, you swear you did, from this same locker.
                    \nYou put your ear to the metal and the clicking. The noise is chilling, only extreme radiation can cause that reading.
                    You consider the etchings again - Hazmat suits are stored with Geiger dosimeters you recall. \n\n
                    \n\n\n\n\n\n\s
                    """);

            tiles.put("22", """ 
                    /-------------------------------------------------------------------------------------------------------\\\n
                    \nYou can make out a bend in the hall far ahead. You have to use the wall to support yourself now. \n\n5c
                    \n\n\n\n\n\n
                    """);

            tiles.put("23", """ 
                    /-------------------------------------------------------------------------------------------------------\\\n
                    You approach an abandoned security checkpoint consisting of a guard’s booth and turnstile.\s
                    On the floor by the booth, is an overturned card table and a half empty bottle of Stolichnaya.\s
                    Looks like the guard was in a hurry to leave. \n\n5d
                    \n\n\n\n\n\n
                    \s
                    """);

            tiles.put("24", """ 
                    /-------------------------------------------------------------------------------------------------------\\\n
                    \nYou enter a massive corridor that curves to the west. The reverberating of the siren is especially loud in here,
                    A man is slumped on the floor, his white uniform stained dark with blood. He becomes very animated when he sees you,
                    yells and waves you over." You approach, and see he his terribly wounded. You can barely hear what he’s saying due to siren.
                    You catch a few words. Something’s blown? Coolant tower?...Repair the pipeline?... He is telling you to repair the pipeline.
                    To agree, type 'ok'.Otherwise simply move on.
                    """);

            tiles.put("25", """ 
                    /-------------------------------------------------------------------------------------------------------\\\n
                    move n, s, e, w       	|     use (item)      	|       pick-up (item)	    |	help help
                    inventory i           	|     map m           	|       quit q		        | 	exit exit\n
                    Enter text commands to control your character. Take note of the descriptions, and the map.
                    You have 100 health.  You lose health every turn from environmental damage.
                    Each turn you must choose to either move or use/drop an item. You cannot do both.5e
                    (Except with drop - you can drop an item and pickup a different item in the same turn)
                                            
                    To pickup, drop, or use (interact with) an item, type the keyword (use, drop or pick-up) and item name.
                    To move or exit type the keyword move or exit and the direction, n, s, e, w
                                            
                    To view map type m, to view inventory type i, your inventory holds up to 5 items (not including map)
                    To access this menu type menu. To quit game type q.
                    """);
            tiles.put("26", """ 
                    /-------------------------------------------------------------------------------------------------------\\\n
                    \nYou are relieved to discover the instruments are familiar to you.\n
                    What you can't understand, or rather, what you cannot believe, is what the readings are showing.
                    They must have been damaged in the accident, or whatever caused the roof to cave in.\n  
                    Yes, there is no other explanation - for the readings to be accurate, the reactor would have be on\n 
                    the brink of a meltdown, and that’s impossible.\n\n
                    If they were genuine though, which they are not - but if they were, a meltdown must be stopped.\n
                    There is an exit west, where you entered, or south.

                    \s
                    """);
            tiles.put("27", """ 
                    
                                        
                    move n, s, e, w       	|     use (item)      	|       pick-up (item)	    |	    help help
                    inventory i           	|     map m           	|       quit q		        | 	    exit exit
                    drop (item)
                    
                    
                    """);

            String s = Integer.toString(player.getPosition());
            System.out.println(tiles.get(s));
            for (String item : tile.gettItems())
            {System.out.println("There is a " + item + " here.");
            }
            System.out.println(tiles.get("27"));





            //variable to display health in events descriptions. To be concat into events.tile descriptions
         //   String healthDisplay = Integer.toString(player.getHealth());
            //    System.out.println(tiles.get(healthDisplay));

      //  }   if (sPos = "19"
        //   {
        }
         else {
            alternateTiles.put("0", """
                    /-------------------------------------------------------------------------------------------------------\n
                    You have passed this area before. You decided to stay on the ground level, it's too dangerous to venture onto the bridge.\n
                    Come to think of it, why have you back-tracked?\s
                    \n\n\n\n\n\n
                    """);
            alternateTiles.put("1", """
                    /-------------------------------------------------------------------------------------------------------\n
                    You have passed this way before. Is there a reason you have backtracked?\n Every second you stay in this place is a second closer to death. \s
                    \n\n\n\n\n\n
                    """);
            alternateTiles.put("2", """
                    /-------------------------------------------------------------------------------------------------------\n
                    You have passed this way before. Is there a reason you have backtracked?\n Every second you stay in this place is a second closer to death. \s
                    \n\n\n\n\n\n
                    """);
            alternateTiles.put("3", """
                    /-------------------------------------------------------------------------------------------------------\n
                    You have passed this way before. Is there a reason you have backtracked?\n Every second you stay in this place is a second closer to death. \s
                    \n\n\n\n\n\n
                    """);
            alternateTiles.put("4", """
                    /-------------------------------------------------------------------------------------------------------\n
                    You have passed this way before. Is there a reason you have backtracked?\n Every second you stay in this place is a second closer to death. \s
                    \n\n\n\n\n\n
                    """);
            alternateTiles.put("5", """
                    /-------------------------------------------------------------------------------------------------------\n
                    You have passed this way before. Is there a reason you have backtracked?\n Every second you stay in this place is a second closer to death. \s
                    \n\n\n\n\n\n
                    """);
            alternateTiles.put("6", """
                    /-------------------------------------------------------------------------------------------------------\n
                    You have passed this way before. Is there a reason you have backtracked?\n Every second you stay in this place is a second closer to death. \s
                    \n\n\n\n\n\n
                    """);
            alternateTiles.put("7", """
                    /-------------------------------------------------------------------------------------------------------\n
                    You have passed this way before. Is there a reason you have backtracked?\n Every second you stay in this place is a second closer to death. \s
                    \n\n\n\n\n\n
                    """);
            alternateTiles.put("8", """
                    /-------------------------------------------------------------------------------------------------------\n
                    You have passed this way before. Is there a reason you have backtracked?\n Every second you stay in this place is a second closer to death. \s
                    \n\n\n\n\n\n
                    """);
            alternateTiles.put("9", """
                    /-------------------------------------------------------------------------------------------------------\n
                    You have passed this way before. Is there a reason you have backtracked?\n Every second you stay in this place is a second closer to death. \s
                    \n\n\n\n\n\n
                    """);
            alternateTiles.put("10", """
                    /-------------------------------------------------------------------------------------------------------\n
                    You have passed this way before. Is there a reason you have backtracked?\n Every second you stay in this place is a second closer to death. \s
                    \n\n\n\n\n\n
                    """);
            alternateTiles.put("11", """
                    /-------------------------------------------------------------------------------------------------------\n
                    You have passed this way before. Is there a reason you have backtracked?\n Every second you stay in this place is a second closer to death. \s
                    \n\n\n\n\n\n
                    """);
            alternateTiles.put("12", """
                    /-------------------------------------------------------------------------------------------------------\n
                    You have passed this way before. Is there a reason you have backtracked?\n Every second you stay in this place is a second closer to death. \s
                    \n\n\n\n\n\n
                    """);
            alternateTiles.put("13", """
                    /-------------------------------------------------------------------------------------------------------\n
                    You have passed this way before. Is there a reason you have backtracked?\n Every second you stay in this place is a second closer to death. \s
                    \n\n\n\n\n\n
                    """);
            alternateTiles.put("14", """
                    /-------------------------------------------------------------------------------------------------------\n
                    You have passed this way before. Is there a reason you have backtracked?\n Every second you stay in this place is a second closer to death. \s
                    \n\n\n\n\n\n
                    """);
            alternateTiles.put("15", """
                    /-------------------------------------------------------------------------------------------------------\n
                    You have passed this way before. Is there a reason you have backtracked?\n Every second you stay in this place is a second closer to death. \s
                    \n\n\n\n\n\n
                    """);
            alternateTiles.put("16", """
                    /-------------------------------------------------------------------------------------------------------\n
                    You have passed this way before. Is there a reason you have backtracked?\n Every second you stay in this place is a second closer to death. \s
                    \n\n\n\n\n\n
                    """);
            alternateTiles.put("17", """
                    /-------------------------------------------------------------------------------------------------------\n
                    You have passed this way before. Is there a reason you have backtracked?\n Every second you stay in this place is a second closer to death. \s
                    \n\n\n\n\n\n
                    """);
            alternateTiles.put("18", """
                    /-------------------------------------------------------------------------------------------------------\n
                    You have passed this way before. Is there a reason you have backtracked?\n Every second you stay in this place is a second closer to death. \s
                    \n\n\n\n\n\n
                    """);
            alternateTiles.put("19", """
                    /-------------------------------------------------------------------------------------------------------\n
                    You have passed this way before. Is there a reason you have backtracked?\n Every second you stay in this place is a second closer to death. \s
                    \n\n\n\n\n\n
                    """);
            alternateTiles.put("20", """
                    /-------------------------------------------------------------------------------------------------------\n
                    You have passed this way before. Is there a reason you have backtracked?\n Every second you stay in this place is a second closer to death. \s
                    \n\n\n\n\n\n
                    """);
            alternateTiles.put("21", """
                    /-------------------------------------------------------------------------------------------------------\n
                    You have passed this way before. Is there a reason you have backtracked?\n Every second you stay in this place is a second closer to death. \s
                    \n\n\n\n\n\n
                    """);
            alternateTiles.put("22", """
                    /-------------------------------------------------------------------------------------------------------\n
                    You have passed this way before. Is there a reason you have backtracked?\n Every second you stay in this place is a second closer to death. \s
                    \n\n\n\n\n\n
                    """);
            alternateTiles.put("23", """
                    /-------------------------------------------------------------------------------------------------------\n
                    You have passed this way before. Is there a reason you have backtracked?\n Every second you stay in this place is a second closer to death. \s
                    \n\n\n\n\n\n
                    """);
            alternateTiles.put("24", """
                    /-------------------------------------------------------------------------------------------------------\n
                    You have passed this way before. Is there a reason you have backtracked?\n Every second you stay in this place is a second closer to death. \s
                    \n\n\n\n\n\n
                    """);

            //methods to print alternateTiles HashMap variables
            String alt = Integer.toString(player.getPosition());
            System.out.println(alternateTiles.get(alt));
            for (String item : tile.gettItems())
            {System.out.println("There is a " + item + " here.");
            }
            System.out.println(tiles.get("27"));

        }


        String printHealth = Integer.toString(player.getHealth());
        System.out.println(tiles.get(player.getPrintHealth()));


        //    public static void alternateCurrentEvent (Player player){


    }

    //public static void check


    public static void displayMenu() {
        String displayM;
        displayM = tiles.get("25");
        System.out.println(displayM);
    }

    public static void initialDescription() {

        prologue = "\n" +
                "" +
                "/-------------------------------------------------------------------------------------------------------\n\n" +
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


    }

}