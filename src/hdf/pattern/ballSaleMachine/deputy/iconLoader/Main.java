package hdf.pattern.ballSaleMachine.deputy.iconLoader;


import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeAndWait(ImageFrame::new);
    }

    public static class ImageFrame extends JFrame {
        private ImageComponent imageComponent;

        public ImageFrame() {
            Map<String, String> cds = new HashMap<>();
            cds.put("google photos", "https://cdn.slashgear.com/wp-content/uploads/2019/11/google_Main-1280x720.jpg");
            cds.put("black cube", "https://dummyimage.com/600x400/000/fff");
            cds.put("beer", "https://cdn-icons.flaticon.com/png/512/6142/premium/6142381.png?token=exp=1638102825~hmac=76bcdd6d24823bf146fa34e26818bc79");
            final JMenuBar jMenuBar = new JMenuBar();
            final JMenu jMenu = new JMenu("Images");

            cds.entrySet()
                    .stream()
                    .map(entry -> {
                        final JMenuItem jMenuItem = new JMenuItem(entry.getKey());
                        jMenuItem.addActionListener(event -> {
                            imageComponent.setIcon(getImageProxy(entry.getValue()));
                            super.repaint();
                        });
                        return jMenuItem;
                    })
                    .forEach(jMenu::add);
            jMenuBar.add(jMenu);
            imageComponent = new ImageComponent(getImageProxy(cds.get("beer")));

            super.getContentPane().add(imageComponent);
            super.setJMenuBar(jMenuBar);
            super.setSize(1000, 1000);
            super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            super.setVisible(true);
        }

        private ImageProxy getImageProxy(final String name) {
            try {
                return new ImageProxy(new URL(name));
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
