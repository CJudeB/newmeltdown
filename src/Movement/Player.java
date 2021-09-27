package Movement;

import java.util.ArrayList;

public class Player {

    private String name ;
    private int xPosition, yPosition;

    public Player(){}

    public Player(String name){
        this.name = name;
        this.xPosition = 1;

    }

    public int getPosition() {
        return xPosition;
    }

    public void setPosition(int xPosition) {
        this.xPosition = xPosition;
    }
}

