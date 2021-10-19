package Game_Project_Java;

public class Selection {


    /**
     * Direction selection int. Selects the integer amount the player should move in reference to the tile array
     *
     * @param input  the input from the user
     * @param player the player instance from game
     * @return the integer value that the player should move
     */
    public int directionSelection(String input, Player player) {
        int output;
        switch (input) {
            case "n" -> {
                if(player.isInCart() && (player.getPosition() == 24 || player.getPosition() == 5)){
                    output = -5;
                }else if(player.isInCart()) {
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
                if(player.isInCart() && (player.getPosition() == 2 || player.getPosition() == 15 || player.getPosition() == 19)){
                    output = 5;
                    if(player.isInCart() && (player.getPosition() == 2)){
                        player.setInCart(false);
                    }
                }else if(player.isInCart())
                    output = 10;
                else
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










