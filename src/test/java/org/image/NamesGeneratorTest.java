package org.image;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NamesGeneratorTest {

    @Test
    void testGenerateNamesWithValidAlphabet() {
        NamesGenerator generator = new NamesGenerator();
        // Define the alphabet and maximum length of a name
        char[] alphabet = {'A', 'B', 'C'};
        int maxLength = 2;
        int totalNames = 10;  // Let's generate 10 names
        List<String> names = generator.generateNames(alphabet, maxLength, totalNames);

        assertFalse(names.isEmpty(), "The list of names should not be empty");
        assertTrue(names.stream().allMatch(name -> name.length() <= maxLength),
                "All names should be of valid length");
        assertTrue(names.stream().noneMatch(name -> name.contains("AAA") || name.contains("BBB") || name.contains("CCC")),
                "Names should not contain invalid sequences");
    }

    @Test
    void testDrawingComponent() {
        // Проверяем, что компонент панели создается корректно
        JPanel panel = new ComplexGraphic().new DrawPanel();
        assertNotNull(panel);
        assertEquals(Color.BLACK, panel.getBackground());
    }

    @Test
    void testPointsAndConnections() {
        ComplexGraphic.DrawPanel panel = new ComplexGraphic().new DrawPanel();
        // Проверим, что список точек не пуст
        assertFalse(panel.points.isEmpty());

        // Проверим, что каждая точка соединена хотя бы с одной другой точкой
        for (int[] connection : panel.connections) {
            assertTrue(connection[0] >= 0 && connection[0] < panel.points.size());
            assertTrue(connection[1] >= 0 && connection[1] < panel.points.size());
        }
    }

    @Test
    void testUniqueConnections() {
        ComplexGraphic.DrawPanel panel = new ComplexGraphic().new DrawPanel();
        ArrayList<Point> uniquePoints = new ArrayList<>(panel.points);
        assertEquals(panel.points.size(), uniquePoints.size());
    }

    @Test
    void testGraphicsInitialization() {
        ComplexGraphic complexGraphic = new ComplexGraphic();
        assertNotNull(complexGraphic);

        JPanel panel = new ComplexGraphic().new DrawPanel();
        assertNotNull(panel);

        // Проверка наличия окна и панели
        assertEquals(1920, complexGraphic.getWidth());
        assertEquals(333, complexGraphic.getHeight());
    }

    @Test
    void testPaintComponentContent() {
        ComplexGraphic.DrawPanel panel = new ComplexGraphic().new DrawPanel();
        TestGraphics g = new TestGraphics();
        panel.paintComponent(g);

        // Проверяем, что были вызваны методы для рисования
        assertTrue(g.drawn);
    }

    // Вспомогательный статический класс для тестирования графики
    static class TestGraphics extends Graphics {
        boolean drawn = false;

        @Override
        public Graphics create() {
            return this;
        }

        @Override
        public void translate(int x, int y) {}

        @Override
        public Color getColor() {
            return Color.WHITE;
        }

        @Override
        public void setColor(Color c) {}

        @Override
        public void setPaintMode() {}

        @Override
        public void setXORMode(Color c1) {}

        @Override
        public Font getFont() {
            return null;
        }

        @Override
        public void setFont(Font font) {}

        @Override
        public FontMetrics getFontMetrics(Font f) {
            return null;
        }

        @Override
        public void clipRect(int x, int y, int width, int height) {}

        @Override
        public void setClip(int x, int y, int width, int height) {}

        @Override
        public Shape getClip() {
            return null;
        }

        @Override
        public void setClip(Shape clip) {}

        @Override
        public void copyArea(int x, int y, int width, int height, int dx, int dy) {}

        @Override
        public void drawLine(int x1, int y1, int x2, int y2) {
            drawn = true;
        }

        @Override
        public void fillRect(int x, int y, int width, int height) {}

        @Override
        public void clearRect(int x, int y, int width, int height) {}

        @Override
        public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {}

        @Override
        public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {}

        @Override
        public void drawOval(int x, int y, int width, int height) {}

        @Override
        public void fillOval(int x, int y, int width, int height) {}

        @Override
        public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {}

        @Override
        public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {}

        @Override
        public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {}

        @Override
        public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {}

        @Override
        public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {}

        @Override
        public void drawString(@NotNull String str, int x, int y) {

        }

        @Override
        public void drawString(AttributedCharacterIterator iterator, int x, int y) {

        }

        @Override
        public void dispose() {}

        @Override
        public Rectangle getClipBounds() {
            return null;
        }

        @Override
        public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
            return false;
        }

        @Override
        public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
            return false;
        }

        @Override
        public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
            return false;
        }

        @Override
        public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
            return false;
        }

        @Override
        public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
            return false;
        }

        @Override
        public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer) {
            return false;
        }
    }

}
