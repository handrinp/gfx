package org.handrinp.gfx;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GImage {
    public static final String DEFAULT_IMAGE_NAME = "image.png";

    private File outputFile;
    private int width;
    private int height;
    private BufferedImage image;

    public GImage(int width, int height, String fileName) {
        this.width = width;
        this.height = height;
        outputFile = new File(fileName);
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    public GImage(int width, int height) {
        this(width, height, DEFAULT_IMAGE_NAME);
    }

    public void set(int x, int y, int color) {
        image.setRGB(x, height - y - 1, color);
    }

    public void set(int x, int y, int r, int g, int b) {
        set(x, y, (r << 16) + (g << 8) + b);
    }

    public void drawLine(int x1, int y1, int x2, int y2, int color) {
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(new Color(color));
        g2d.drawLine(x1, height - y1 - 1, x2, height - y2 - 1);
        g2d.dispose();
    }

    public void drawLine(int x1, int y1, int x2, int y2, int r, int g, int b) {
        drawLine(x1, y1, x2, y2, (r << 16) + (g << 8) + b);
    }

    public boolean save() {
        boolean success = true;

        try {
            ImageIO.write(image, "png", outputFile);
        } catch (IOException e) {
            success = false;
        }

        return success;
    }
}

