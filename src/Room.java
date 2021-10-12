import java.util.Scanner;

public class Room {

            class room {

                private String room;
                private Integer setRoomNo;

                public String getRoom() {
                    return room;
                }
                public void setRoom(String name) {
                    this.room = room;
                }
                public Integer getRoomNo() {
                    return setRoomNo;
                }
                public void setRoomNo(Integer setRoomNo) {
                    this.setRoomNo = setRoomNo;
                }

            }

    // Tokenizing test using String.split method. It processes input into an array of tokens.
    // Delimiter is set to handle one or more white spaces now but can be altered to suit if needed.
    // Below example is just set-up to print to test what it does.
    public static class InputHandler {
        String[] allWords;
        String[] processInput;

        public void handler(String s) {

            Scanner sc = new Scanner(System.in);
            String items = sc.nextLine();
           processInput = items.split("\\s+");
           int bits = 0;

            for (int i = 0; i < processInput.length; i++){
                System.out.println(processInput[i]);
                bits++;
            }

        }

       /* public String getHandler() {
            return handler;
        }*/


        public String processor() {
           // String temp;
            return null;
        }


        public static void main(String[] args) {
           // String temp;



        }
    }
}


