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

    public class Player{


    }

    public static class Room {
        private int location;
        private int wall;


        public Room (int location, int wall) {
            this.location = location;
            this.wall = wall;

        }
        String[] walls = {null, "north", "south", "east", "west"};

        String[] locations = {null, "1", "2", "3", "4", "5", "6",
                "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
                "17", "18", "19", "20", "21", "22", "23", "24", "25"};

        public String toString() {
            String[] locations = {null, "1", "2", "3", "4", "5", "6",
                    "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
                    "17", "18", "19", "20", "21", "22", "23", "24", "25"};
            String[] walls = {null, "north", "south", "east", "west"};
            String s = "\nLocation on a 5 x 5 grid and direction at location where\nnorth = 1,\nsouth = 2,\neast = 3,\nwest = 4: \n\n" + locations[this.location] + " facing " + walls[this.wall];
            return s;
        }
        }

    public static void main(String[] args) {
        Room room = new Room(25, 4);
        System.out.println(room);
    }

}
