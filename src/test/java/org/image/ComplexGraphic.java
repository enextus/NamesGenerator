package org.image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class ComplexGraphic extends JFrame {

    public ComplexGraphic() {
        this.setTitle("Complex Graphic Display");
        this.setSize(1920, 333); // Adjust the size to fit your graphic
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new DrawPanel());
    }

    class DrawPanel extends JPanel {
        ArrayList<Point> points = new ArrayList<>();
        int[][] connections; // Array to hold the connections between points

        public DrawPanel() {
            // Set the background color to black
            this.setBackground(Color.BLACK);

            // Define points (you can add more points as needed)
            points.add(new Point(50, 100));
            points.add(new Point(150, 150));
            points.add(new Point(250, 50));
            // Add more points here...

            // Define connections between points based on your specific pattern
            connections = new int[][]{
                    {0, 1}, {1, 2}, {2, 0}, // Example connections
                    // Add more connections here...
            };
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.WHITE);

            // Draw lines between points
            for (int[] conn : connections) {
                Point p1 = points.get(conn[0]);
                Point p2 = points.get(conn[1]);
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }
    }

    public static void main(String[] args) {
        System.out.printf("Hello and welcome!\n");

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new ComplexGraphic().setVisible(true);
        });
    }
}
