import java.util.ArrayList;
import java.util.List;

        public class Room {

        public static void main(String args[]) {

            List<room> rooms = new ArrayList<room>();


            room room = new room();
            room.setRoom("A Room");
            room.setRoomNo(1);
            rooms.add(room);

            room = new room();
            room.setRoom("Another Room");
            room.setRoomNo(2);
            rooms.add(room);
        }
    }

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


