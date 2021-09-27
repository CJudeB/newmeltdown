package Movement;

public class Selection {


    public int directionSelection(String input) {
        int output;
        switch (input) {

            case "North", "north", "n", "N": {
                output = -5;
                return output;
            }
            case "East", "east", "e", "E": {
                output = 1;
                return output;
            }
            case "South", "south", "s", "S": {
                output = 5;
                return output;
            }
            case "West", "west", "w", "W": {
                output = -1;
                return output;

            }
            default:
                output = 0;
                return output;
        }
    }
}










