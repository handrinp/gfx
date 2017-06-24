package org.handrinp.gfx;

public class Main {
    private static int N = 640;
    private static int POINTS = 32;
    private static int K = 2;
    private static int[] px;
    private static int[] py;

    public static void main(String[] args) {
        if (args.length == 3) {
            N = Integer.parseInt(args[0]);
            POINTS = Integer.parseInt(args[1]);
            K = Integer.parseInt(args[2]);
        }

        px = new int[POINTS];
        py = new int[POINTS];
        GImage img = makeWhiteImage();
        drawCircle(img);
        drawLines(img);
        img.save();
    }

    private static GImage makeWhiteImage() {
        GImage img = new GImage(N, N);

        for (int x = 0; x < N; ++x) {
            for (int y = 0; y < N; ++y) {
                img.set(x, y, 255, 255, 255);
            }
        }

        return img;
    }

    private static void drawCircle(GImage img) {
        final int off = img.getWidth() >> 1;
        final int r = (off >> 1) + (off >> 2);

        for (int i = 0; i < POINTS; ++i) {
            px[i] = (int) (off + r * Math.cos(2 * i * Math.PI / POINTS));
            py[i] = (int) (off + r * Math.sin(2 * i * Math.PI / POINTS));
            img.set(px[i], py[i], 0);
        }
    }

    private static void drawLines(GImage img) {
        for (int start = 0; start < POINTS; ++start) {
            int end = (start * K) % POINTS;
            img.drawLine(img.getWidth() - px[start] - 1, py[start], img.getWidth() - px[end] - 1, py[end], 0);
        }
    }
}

