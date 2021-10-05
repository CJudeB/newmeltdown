package Movement;

public class Selection {


    public int directionSelection(String input) {
        int output;
        switch (input) {
            case "n" -> {
                output = -5;
                return output;
            }
            case "e" -> {
                output = 1;
                return output;
            }
            case "s" -> {
                output = 5;
                return output;
            }
            case "w" -> {
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










