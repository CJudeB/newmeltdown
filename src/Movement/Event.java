package Movement;


import java.util.LinkedHashMap;
import java.util.Objects;


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
                    
                    /-------------------------------------------------------------------------------------------------------\\
                    1A
                    
                    You recall there is a back-up coolant pipeline in the reactor tower.
                    You'll have to climb the exterior bridge to turn on the auxiliary coolant system.
                    As you climb stairs you pause to consider your choice.
                    You can turn on the back-up pipeline without a tool, but will the bridge be safe?
                    
                    Type "Yes" to continue up, toward the bridge?
                    Otherwise continue toward the pipeline to the east or the exit to the south.
                     
                    """);


            tiles.put("1", """
                    
                    /-------------------------------------------------------------------------------------------------------\\
                    1B
                                        
                    You stumble eastward trying not to stumble and fall. If you do fall, you know you won't have to energy to get up.
                    You can continue east to the coolant facility or head back west.
           
                    """);


            tiles.put("2", """
                    
                    /-------------------------------------------------------------------------------------------------------\\
                    1C
                    
                    You arrive at a narrow steel door labelled "Coolant Facility".
                    You can head south to try and repair the coolant pipeline or head back west.
                    
                    You're not sure you have the energy to make it back to the exit now, you realise.
                    This might be the end of the road.

                    """);


            tiles.put("3", "1d_");

            tiles.put("4", "1e_");

            tiles.put("5", """
                    
                    /-------------------------------------------------------------------------------------------------------\\
                    2A
                    
                    You pass more offices. You see a stairwell in the distance in the north.
                    
                    You can continue north or head back south.

                    """);

            tiles.put("6", "2b_");

            tiles.put("7", """
                    
                    /-------------------------------------------------------------------------------------------------------\\
                    2C
                    
                    You can see the problem with the coolant pipeline.
                    One of the pipes is blocked and needs to be shut-off and the coolant re-directed.
 
                    """);


            tiles.put("8", "2d_");

            tiles.put("9", "2e_");

            tiles.put("10", """
                    
                    /-------------------------------------------------------------------------------------------------------\\
                    3A
                    
                    You arrive at the facilities’ foyer. Through the massive glass lined entrance, you can see emergency services
                    and military congregating. The exit is right here, you can escape now.
                    
                    The coolant pipeline needs repairing though. There's no getting around that fact.
                    
                    There is one of the plant's small utility carts parked nearby, but there’s no key in the ignition.
                    If you can start that cart you'll move twice the speed you can on foot.
               
                    """);

            tiles.put("11", "3b_");

            tiles.put("12", "3c_");

            tiles.put("13", "3d_");

            tiles.put("14", "3e");


            tiles.put("15", """
                    
                    /-------------------------------------------------------------------------------------------------------\\
                    4A
                    
                    You arrive at a T junction. Deserted administration offices line the walls. Your memory is retuning though. \s
                    The main entrance is to the north, not far away. To the south there there a just more offices.

                    """);


            tiles.put("16", """
                    
                    /-------------------------------------------------------------------------------------------------------\\
                    4B
                    
                    You continue west where the hall is heavily obstructed by debris. It’s slow going and by the time you navigate\s
                    through, you’re shaking with fatigue. You notice your hands look sun burnt.
                   
                    You can continue west down the hall or head back east.
                   
                    """);


            tiles.put("17", """
                    
                    /-------------------------------------------------------------------------------------------------------\\
                    4C
                    
                    You enter a wide hall. The damage here is worse than the control room whole sections of the
                    building have caved in. Through gaps in the ceiling you notice plumes of smoke billowing overhead
                    from the north east, where the reactor is.
                    
                    Silvery ash fills the air, falling like snow. You notice a metallic taste in your mouth.
                    
                    You can continue west down the hall or head back east.
                    
                    """);

            tiles.put("18", """
                    
                    /-------------------------------------------------------------------------------------------------------\\
                    4D
                    
                    You get up, woozy, legs like lead. This is a control room, you recall, or what’s left of it.\s
                    On the far side of the room where the damage is worst you see two bodies, a mess of limbs and masonry.
                    You shudder – that’s Alexi and Pasha from your section.
                    
                    You have to get out of here.
                    A draft is blowing from the west exit, and an acrid smell.  To the east is another exit.
                    You try and focus but you've no idea where they lead, the persistent, violent whine of the siren does not help.\s
                    
                    A map of the facility has fallen from its frame and lies on floor nearby.
                    You may need that map. (Type pick-up map)
                    
                    """);

            tiles.put("19", """
                    
                    /-------------------------------------------------------------------------------------------------------\\
                    4E
                    
                    You enter another control room - home to a dizzying array of monitoring apparatus.
                    Some memory is returning now - this room is familiar.
                    You notice one panel, labelled 'core-regulator', is lit-up like an angry fairground attraction.
                    You do not like the look of that panel. There is an exit west, where you entered, or south.
                    
                    """);

            tiles.put("20", """ 
                         
                    /-------------------------------------------------------------------------------------------------------\\
                    5A
                    
                    The hall bends north and you approach a stretch of workshops. You see a utility cart in one of them,\s
                    the type used to transport light goods around the facility. It’s in disrepair unfortunately.
                    You grab hold of a workbench to keep from falling, almost toppling a jerry-can.
                    You could have.
                    
                    """);

            tiles.put("21", """
                                                  
                    /-------------------------------------------------------------------------------------------------------\\
                    5B
                     
                    You approach a line of built-in storage cabinets. Several lie face down on the floor, wrenched from the wall.
                    None of the combination locks are open though. You notice something  etched into the back of one cabinet.
                    
                    4b*1c-5c, (2a*3b%1b)-3d, 3d+=3d.
                    
                    Did you just hear a Geiger dosimeter? In the moments between siren phases, you swear you did, from this same cabinet.
                    You put your ear to the metal and the clicking. The noise is chilling, only extreme radiation can cause that reading.
                    You consider the etchings again - Hazmat suits are stored with Geiger dosimeters you recall.
                    
                    """);

            tiles.put("22", """ 
                    
                    /-------------------------------------------------------------------------------------------------------\\
                    5C
                    
                    You can make out a bend in the hall far ahead. You have to use the wall to support yourself now.
                    
                    You can move west or east along the hall.
                    
                    """);

            tiles.put("23", """ 
                    
                    /-------------------------------------------------------------------------------------------------------\\
                    5D
                    
                    You approach an abandoned security checkpoint consisting of a guard’s booth and turnstile.\s
                    On the floor by the booth, is an overturned card table and a half empty bottle of Stolichnaya.\s
                    Looks like the guard was in a hurry to leave.
                  
                    """);

            tiles.put("24", """ 
                    
                    /-------------------------------------------------------------------------------------------------------\\
                    5E
                    
                    You enter a massive corridor that curves to the west. The reverberating of the siren is especially loud in here,
                    
                    A man is slumped on the floor, his white uniform stained dark with blood. He becomes very animated when he sees you,
                    yells and waves you over. You approach, and see he his terribly wounded.
                    You can barely hear what he’s saying due to siren. You catch a few words.
                    Something’s blown? Coolant tower?...Repair the pipeline?... He is telling you to repair the pipeline.
                    To agree, type 'ok'.Otherwise simply move on.
                    
                    """);

            tiles.put("25", """ 
                    
                    /-------------------------------------------------------------------------------------------------------\\
                    
                    HELP MENU
                    
                    
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
                    
                    /-------------------------------------------------------------------------------------------------------\\
                    4E
                    
                    You are relieved to discover the instruments are familiar to you.
                    What you can't understand, or rather, what you cannot believe, is what the readings are showing.
                    They must have been damaged in the accident, or whatever caused the roof to cave in.
                    
                    Yes, there is no other explanation - for the readings to be accurate, the reactor would have be on
                    the brink of a meltdown, and that’s impossible.
                    
                    If they were genuine though, which they are not - but if they were, a meltdown must be stopped.
                    There is an exit west, where you entered, or south.

                    """);
            tiles.put("27", """           
                    move n, s, e, w       	|     use (item)      	|       pick-up (item)	    |	    help help
                    inventory i           	|     map m           	|       quit q		        | 	    exit exit
                    drop (item)
                    
                    """);

            String s = Integer.toString(player.getPosition());
            System.out.println(tiles.get(s));
            if((Objects.equals(tile.gettCart(), "cart")) && (!s.equals("10")) && !player.isInCart()) {
                System.out.println("The cart sits nearby.");
            }
            for (String item : tile.gettItems()) {
                    System.out.println("There is a " + item + " here.");
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
                    
                    /-------------------------------------------------------------------------------------------------------\\
                    1A
                    
                    You have passed this way before. Is there a reason you have backtracked?
                    Every second you stay in this place is a second closer to death.
                    You decided to stay on the ground level and not risk the bridge.
                    
                    You can move south or east from here.
                 
                    """);
            alternateTiles.put("1", """
                    
                    /-------------------------------------------------------------------------------------------------------\\
                    1B
                    
                    You have passed this way before. Is there a reason you have backtracked?
                    Every second you stay in this place is a second closer to death.
                    
                    You can move east toward the coolant facility or west.

                    """);
            alternateTiles.put("2", """
                    
                    /-------------------------------------------------------------------------------------------------------\\
                    1C
                    
                    You have passed this way before. Is there a reason you have backtracked?
                    Every second you stay in this place is a second closer to death.
                    
                    You can move east toward the coolant facility or west.
                    

                    
                    """);
            alternateTiles.put("3", """
                    
                    /-------------------------------------------------------------------------------------------------------\\
                    
                    
                    
                    """);
            alternateTiles.put("4", """
                    
                    /-------------------------------------------------------------------------------------------------------\\
                    
                    You have passed this way before. Is there a reason you have backtracked?
                    Every second you stay in this place is a second closer to death. \s
                    
                    """);
            alternateTiles.put("5", """
                    
                    /-------------------------------------------------------------------------------------------------------\\
                    2A
                    
                    You have passed this way before. Is there a reason you have backtracked?
                    Every second you stay in this place is a second closer to death.
                    You can travel north toward the coolant facility or head south toward the exit.
                    
                    """);
            alternateTiles.put("6", """
                    /-------------------------------------------------------------------------------------------------------\\
                    You have passed this way before. Is there a reason you have backtracked?
                    Every second you stay in this place is a second closer to death. \s
                    
                    """);
            alternateTiles.put("7", """
                    
                    /-------------------------------------------------------------------------------------------------------\\
                    2C
                    
                    You have passed this way before. You are in the coolant facility. The coolant pipeline must be repaired.
                    Every second you stay in this place is a second closer to death.
                    
                    You can exit the coolant facility to the north.
                    
                    
                    """);
            alternateTiles.put("8", """
                    /-------------------------------------------------------------------------------------------------------\\
                    
                    
                    """);
            alternateTiles.put("9", """
                    /-------------------------------------------------------------------------------------------------------
                    
                    
                    """);
            alternateTiles.put("10", """
                    /-------------------------------------------------------------------------------------------------------\\
                    3A
                    
                    You have passed this way before. Is there a reason you have backtracked?
                    Every second you stay in this place is a second closer to death.
                    
                    You can escape the facility here via the exit or head north or back south.
                    
                    
                    """);
            alternateTiles.put("11", """
                    /-------------------------------------------------------------------------------------------------------
                    
                    
                    """);
            alternateTiles.put("12", """
                    /-------------------------------------------------------------------------------------------------------
                    
                    
                    """);
            alternateTiles.put("13", """
                    /-------------------------------------------------------------------------------------------------------
                    
                    
                    """);
            alternateTiles.put("14", """
                    /-------------------------------------------------------------------------------------------------------
                    
                    
                    """);
            alternateTiles.put("15", """
                    /-------------------------------------------------------------------------------------------------------
                    4A
                    
                    You have passed this way before. Is there a reason you have backtracked?
                    Every second you stay in this place is a second closer to death. You are at a T junction.
                    
                    You can travel east toward the control room, north toward the exit or south.
                    
                    """);
            alternateTiles.put("16", """
                    
                    /-------------------------------------------------------------------------------------------------------\\
                    4B
                    
                    You have passed this way before. Is there a reason you have backtracked?
                    Every second you stay in this place is a second closer to death.
                    
                    You can travel east or west along the hall.
                    
                    """);
            alternateTiles.put("17", """
                    
                    /-------------------------------------------------------------------------------------------------------\\
                    4C
                    
                    You have passed this way before. Is there a reason you have backtracked?
                    Every second you stay in this place is a second closer to death.
                    
                    You can travel east or west along the hall.
                    
                    """);
            alternateTiles.put("18", """
                    
                    /-------------------------------------------------------------------------------------------------------\\
                    4D
                    
                    You have passed this way before, this is the control room where you woke.
                    Is there a reason you have backtracked? Every second you stay in this place is a second closer to death.
                    
                    You can travel east toward the control room? north toward the exit or south.
                    
                    """);
            alternateTiles.put("19", """
                    
                    /-------------------------------------------------------------------------------------------------------\\
                    4E
                    
                    You have passed this way before. The core-regulator panel is in this room.
                    Is there a reason you have backtracked? Every second you stay in this place is a second closer to death.
                    
                    You can travel west toward the control room where you woke or south.
                    
                    """);
            alternateTiles.put("20", """
                    
                    /-------------------------------------------------------------------------------------------------------\\
                    5A
                    
                    You have passed this way before. Is there a reason you have backtracked?
                    Every second you stay in this place is a second closer to death.
                    
                    You are at the end of the corridor - you can travel east or north from here.
                    
                    """);
            alternateTiles.put("21", """
                    
                    /-------------------------------------------------------------------------------------------------------\\
                    5B
                    
                    You have passed this way before. Is there a reason you have backtracked?
                    Every second you stay in this place is a second closer to death.
                    
                    The cabinet with the etchings is here - it reads: 4b*1c-5c, (2a*3b%1b)-3d, 3d+=3d.
                    
                    You can travel east or west from here, along the corridor.
                    
                    """);
            alternateTiles.put("22", """
                    
                    /-------------------------------------------------------------------------------------------------------\\
                    5C
                    
                    You have passed this way before. Is there a reason you have backtracked?
                    Every second you stay in this place is a second closer to death.
                    
                    You can travel west or east along the corridor from here.
                    
                    """);
            alternateTiles.put("23", """
                    
                    /-------------------------------------------------------------------------------------------------------\\
                    5D
                    
                    You have passed this way before. You are at the abandoned checkpoint. Is there a reason you have backtracked?
                    Every second you stay in this place is a second closer to death.
                    
                    You can travel east or north from here.
                    
                    """);
            alternateTiles.put("24", """
                    
                    /-------------------------------------------------------------------------------------------------------\\
                    5E
                    
                    You have passed this way before. The engineer you met earlier is still here, still passed out.
                    Is there a reason you have backtracked? Every second you stay in this place is a second closer to death.
                    
                    You can travel west down the corridor or north.
                    
                    """);

            //methods to print alternateTiles HashMap variables
            String alt = Integer.toString(player.getPosition());
            System.out.println(alternateTiles.get(alt));
            if(tile.gettCart() == "cart") {
                System.out.println("The cart sits nearby.");
            }
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

        prologue =
                """
                /-------------------------------------------------------------------------------------------------------\\
                                        
                                   #    # ###### #      ##### #####   ####  #    # #    #\s
                                   ##  ## #      #        #   #    # #    # #    # ##   #\s
                                   # ## # #####  #        #   #    # #    # #    # # #  #\s
                                   #    # #      #        #   #    # #    # # ## # #  # #\s
                                   #    # #      #        #   #    # #    # ##  ## #   ##\s
                                   #    # ###### ######   #   #####   ####  #    # #    #\s
                                        
                                        
                Somewhere in the Soviet Union, 1984.
                
                The siren jolts you from unconsciousness.
                
                You come-to in what looks like a warzone, lying among rubble and dust, a pulsing ache in your head.
                The first thing you notice, beside the pain, is that the ceiling has partially collapsed.
                This explains your headache, and your confusion - You have no memory of where you are, or what's happening,
                you realise - It's a blank slate. For a moment the memory of who YOU ARE feels like it might slip away.
                No. that memory you still have.
                
                'I’m an Energetiki power engineer with the ministry of Electrification'. You say resolutely.
                'I work here, at this nuclear power plant'.
                
                To begin type start.
                
                """;
        System.out.println(prologue);


    }

}