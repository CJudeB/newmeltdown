package Movement;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Map {

    private BufferedImage visual;
    private Player player;
    private Tile tile;
    static Map reactorMap;
    JFrame pane = new JFrame();
    JLabel jLab = new JLabel();
    private boolean hasWindow = false;


    public Map geReactorMap() {
        return reactorMap;
    }

    public static void setReactorMap(Map reactorMap) {
        Map.reactorMap = reactorMap;
    }


    /**
     * Instantiates a new Map. Takes the bufferedImage and sets it as a image to be displayed in the JFrame
     * Also creates a window listener to hide the JFrame when it is no longer the active window
     *
     * @throws IOException the io exception
     */
    public Map() throws IOException {

        BufferedImage visual = ImageIO.read(Objects.requireNonNull(getClass().getResource("/map/package/img.png")));
        ImageIcon iMap = new ImageIcon(visual);
        this.pane.getContentPane().setBackground(Color.BLACK);
        this.pane.setLayout(new FlowLayout());
        this.pane.setSize(1155, 775);
        this.jLab.setIcon(iMap);
        this.pane.add(jLab);
                this.pane.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowDeactivated(WindowEvent e) {
                        pane.setAlwaysOnTop(false);
                        pane.setVisible(false);
                        System.out.println("\nYou put the map away\n>");
                    }
                });

    }


    /**
     * Display map. Checks if the player has a map in the inventory and if they do will set
     * the JFrame to visible if it is not already open. Or it will tell them they don't have a map
     *
     * @param item the item the player wanted to use
     */
    public void displayMap(String item ,Player player) {
        Validation v =new Validation();
        if(v.validateInput(item, player.getInventory()).equalsIgnoreCase("map")) {
            if (!pane.isVisible()) {
                this.pane.setVisible(true);
                this.pane.setAlwaysOnTop(true);
                System.out.println("You take a look at the map");
            } else {
                this.pane.setAlwaysOnTop(false);
                this.pane.setVisible(false);
                System.out.println("\nYou put the map away\n>");
            }
        }else{
            System.out.println("I don't have a map");
        }
    }
}



