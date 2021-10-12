package Movement;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Map {

    private BufferedImage visual = null;
    private Player player;
    private Tile tile;
    static Map mapPane;

    public static Map getMapPane() {
        return mapPane;
    }

    public static void setMapPane(Map mapPane) {
        Map.mapPane = mapPane;
    }

    //public static Map mapPane = new Map(Player player);

    public Map mapPane() throws IOException {

        BufferedImage visual = ImageIO.read(Objects.requireNonNull(getClass().getResource("/map/package/smallMap.jpg")));
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

        return mapPane;

    }
}

