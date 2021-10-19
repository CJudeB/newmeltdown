package Movement;

import java.util.ArrayList;


public class Validation {

    private String[] cardinals = {"n", "e", "s", "w"};
    private String badInput = "badInput";

    /**
     * Validate input string to insure correct direction has been inputted.
     *
     * @param input the input from the user
     * @return the string back as entered if valid or badInput if not
     */
    public String validateInput(String input) {


        if (input.equalsIgnoreCase("n") || input.equalsIgnoreCase("north")) {
            return cardinals[0];
        } else if (input.equalsIgnoreCase("e") || input.equalsIgnoreCase("east")) {
            return cardinals[1];
        } else if (input.equalsIgnoreCase("s") || input.equalsIgnoreCase("south")) {
            return cardinals[2];
        } else if (input.equalsIgnoreCase("w") || input.equalsIgnoreCase("west")) {
            return cardinals[3];
        }
        return badInput;
    }

    /**
     * Validate input string against the tile items array to ensure that the item the player selected is on the tile
     *
     * @param input  the input from the user
     * @param tInven the tile items inventory
     * @return the string back as entered if it exists in the array
     */
    public String validateInput(String input, ArrayList<String> tInven) {
        for (String a : tInven) {
            if (input.equalsIgnoreCase(a)) {
                return input;
            }
        }
        return badInput;
    }

    /**
     * Validate input string against the tile items array to ensure that the item the player selected is in their inventory
     *
     * @param input  the input from the user
     * @param pInven the player inventory array
     * @return the string back as entered if it exists in the array
     */
    public String validateInput(String input, String pInven[]) {
        for (String i : pInven) {
            if (input.equalsIgnoreCase(i)) {
                return input;
            }

        }
        return badInput;
    }
}








