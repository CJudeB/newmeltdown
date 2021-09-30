package Movement;

import java.util.ArrayList;

public class Player {

    private String name ;
    private int Position, health = 100;
    private boolean inCart = false, isAlive = true;

    public Player(String name){
        this.name = name;
        this.Position = 18;
    }

    public int getPosition() {
        return Position;
    }

    public void setPosition(int xPosition) {
        this.Position = Position;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isInCart() {
        return inCart;
    }

    public void setInCart(boolean inCart) {
        this.inCart = inCart;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}

