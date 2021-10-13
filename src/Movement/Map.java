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


    public Map() throws IOException {

        BufferedImage visual = ImageIO.read(Objects.requireNonNull(getClass().getResource("/map/package/img.png")));
        ImageIcon iMap = new ImageIcon(visual);
        this.pane.getContentPane().setBackground(Color.BLACK);
        this.pane.setLayout(new FlowLayout());
        this.pane.setSize(1155, 775);
        this.jLab.setIcon(iMap);
        this.pane.add(jLab);
                pane.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowDeactivated(WindowEvent e) {
                        pane.setVisible(false);
                        System.out.println("\nYou put the map away");
                    }
                });

    }


    public void displayMap() {
        if (!pane.isVisible()) {
            this.pane.setVisible(true);
            System.out.println("You take a look at the map");
        } else {
            System.out.println("I already have the map out");
        }
    }
}



