package Movement;

public class Validation {

    private String [] cardinals = {"n","e","s","w"};
    private String [] inventory = new String [5];
    private String [] tileItems = new String [5];
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

        for (String a : inventory) {
            if (input.toLowerCase().equals(a)) {
                return a;
            }
        }

        for (String b : tileItems) {
            if (input.toLowerCase().equals(b)) {
                return b;
            }
        }
        return badInput;
    }
}





