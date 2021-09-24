package Movement;

import java.util.ArrayList;

public class Player {

    private String name ;
    private int position;

    public Player(String name){
        this.name = name;
        this.position = 19;

    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}

