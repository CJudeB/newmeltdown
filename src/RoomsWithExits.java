public class RoomsWithExits {

    /* Room instance variables mapping

        location variable

        null,
        1,
        2,
        3 ....
        26

        wall variable

        north,
        south,
        east,
        west

     */

    public static class Room {
        private int location;
        private int wall;


        public Room (int location, int wall) {
            this.location = location;
            this.wall = wall;

        }
        String[] walls = {"north", "south", "east", "west"};

        String[] locations = {null, "1", "2", "3", "4", "5", "6",
                "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
                "17", "18", "19", "20", "21", "22", "23", "24", "25"};

        public String toString() {
            String[] locations = {null, "1", "2", "3", "4", "5", "6",
                    "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
                    "17", "18", "19", "20", "21", "22", "23", "24", "25"};
            String[] walls = {"north", "south", "east", "west"};
            String s = locations[this.location] + " of " + walls[this.wall];
            return s;

        }
        }

    public static void main(String[] args) {
        Room room = new Room(9, 3);
        System.out.println(room);
    }

}
