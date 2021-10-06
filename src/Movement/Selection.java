package Movement;

public class Selection {


    public int directionSelection(String input, Player player) {
        int output;
        switch (input) {
            case "n" -> {
                if(player.isInCart()){
                    output = -10;
                }else
                    output = -5;
                return output;
            }
            case "e" -> {
                if(player.isInCart()){
                    output = 2;
                }else
                output = 1;
                return output;
            }
            case "s" -> {
                if(player.isInCart() && (player.getPosition() == 10 || player.getPosition() == 2)){
                    output = 5;
                }else if (player.isInCart()) {
                    output = 10;
                }else
                    output = 5;
                return output;
            }
            case "w" -> {
                if(player.isInCart()){
                    output = -2;
                }else
                output = -1;
                return output;

            }
            default -> {
                output = 0;
                return output;
            }
        }
    }

}










