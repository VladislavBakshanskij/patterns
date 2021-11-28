package hdf.pattern.ballSaleMachine.deputy.iconLoader;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.concurrent.CompletableFuture;

public class ImageProxy implements Icon {
    private final URL imageUrl;
    private volatile ImageIcon image;

    public ImageProxy(final URL imageUrl) {
        this.imageUrl = imageUrl;
    }

    public synchronized void setImage(final ImageIcon image) {
        this.image = image;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        if (image == null) {
            g.drawString("Loading icon from internet...", x + 300, y + 300);
            CompletableFuture.supplyAsync(() -> new ImageIcon(imageUrl))
                    .thenAcceptAsync(image -> {
                        setImage(image);
                        c.repaint();
                    });
//            new Thread(() -> {
//                setImage(new ImageIcon(imageUrl));
//                c.repaint();
//            }).start();
        } else {
            g.clearRect(0, 0, 100, 1000);
            image.paintIcon(c, g, 200, 200);
        }
    }

    @Override
    public int getIconWidth() {
        return image == null ? 800 : image.getIconWidth();
    }

    @Override
    public int getIconHeight() {
        return image == null ? 800 : image.getIconHeight();
    }
}
