package Movement;

import java.util.ArrayList;

public class Validation {

    private String[] cardinals = {"n", "e", "s", "w"};
    private String[] tileItems = new String[5];
    private String badInput = "badInput";

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

    public String validateInput(String input, ArrayList<String> tInven) {
        for (String a : tInven) {
            if (input.equalsIgnoreCase(a)) {
                return input;
            }
        }
        return badInput;
    }

    public String validateInput(String input, String tInteractable){
        if(input.equalsIgnoreCase(tInteractable)){
            return input;
        }else
            return badInput;
    }

    public String validateInput(String input, String pInven[]) {
        for (String i : pInven) {
            if (input.equalsIgnoreCase(i)) {
                return input;
            }

        }
        return badInput;
    }
}








