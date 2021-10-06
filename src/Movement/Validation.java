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

    public String validateInput(String input, String tIntractable){
        if(input.equalsIgnoreCase(tIntractable)){
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

    public static boolean onCartTile(int tRef, Player player){

        if(player.isInCart()){
        if((tRef == 0 || tRef == 1 || tRef == 2 || tRef == 5 || tRef == 10)){
            return true;
        }else
        return false;
        }
        return player.isInCart();
    }
}








