package Movement;

import java.util.ArrayList;

public class Validation {

    private String[] cardinals = {"n", "e", "s", "w"};
    private String[] tileItems = new String[5];
    private String badInput = "badInput";

    public String validateInput(String input) {


        if (input.toLowerCase().equals("n") || input.toLowerCase().equals("north")) {
            return cardinals[0];
        } else if (input.toLowerCase().equals("e") || input.toLowerCase().equals("east")) {
            return cardinals[1];
        } else if (input.toLowerCase().equals("s") || input.toLowerCase().equals("south")) {
            return cardinals[2];
        } else if (input.toLowerCase().equals("w") || input.toLowerCase().equals("west")) {
            return cardinals[3];
        }
        return badInput;
    }

    public String validateInput(String input, ArrayList<String> tInven) {
        String item = input.toLowerCase();
        for (String a : tInven) {
            if (item.equals(a)) {
                return item;
            }
        }
        return badInput;
    }

    public String validateInput(String input, String pInven[]) {
        String item = input.toLowerCase();
        for (String i : pInven) {
            if (item.equals(i)) {
                return item;
            }

        }
        return badInput;
    }
}








