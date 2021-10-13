package Movement;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Map {

    private BufferedImage visual;
    private Player player;
    private Tile tile;
    static Map reactorMap;

    public Map geReactorMap() {
        return reactorMap;
    }

    public static void setReactorMap(Map reactorMap) {
        Map.reactorMap = reactorMap;
    }


    public void reactorMap() throws IOException {

        BufferedImage visual = ImageIO.read(Objects.requireNonNull(getClass().getResource("/map/package/img.png")));
        ImageIcon iMap = new ImageIcon(visual);
        JFrame pane = new JFrame();
        pane.getContentPane().setBackground(Color.BLACK);
        pane.setLayout(new FlowLayout());
        pane.setSize(1155, 775);
        JLabel jLab = new JLabel();
        jLab.setIcon(iMap);
        pane.add(jLab);
        pane.setVisible(true);
        pane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}



