package org.handrinp.gfx;

public class Main {
    public static void main(String[] args) {
        final int n = 256;
        final int nPoints = 64;

        int[] px = new int[nPoints];
        int[] py = new int[nPoints];

        GImage img = new GImage(n, n);

        for (int x = 0; x < n; ++x) {
            for (int y = 0; y < n; ++y) {
                img.set(x, y, 255, 255, 255);
            }
        }

        for (int i = 0; i < nPoints; ++i) {
            px[i] = (int) Math.floor((n >> 1) + ((n >> 2) + (n >> 3)) * Math.cos(i * 2 * Math.PI / nPoints));
            py[i] = (int) Math.floor((n >> 1) + ((n >> 2) + (n >> 3)) * Math.sin(i * 2 * Math.PI / nPoints));
            img.set(px[i], py[i], 0);
        }

        img.save();
    }
}

