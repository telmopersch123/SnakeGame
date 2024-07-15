import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.prefs.Preferences;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicSliderUI;

public class CustomSlider extends JSlider {
    private final Image backgroundImage;
    private final Image thumbImage;
    private static Preferences prefs = Preferences.userNodeForPackage(CustomSlider.class);
    private static final String SLIDER_POSITION_KEY = "slider_position";

    public CustomSlider(Image backgroundImage, Image thumbImage) {
        super();
        this.backgroundImage = backgroundImage;
        this.thumbImage = thumbImage;

        int sliderPosition = prefs.getInt(SLIDER_POSITION_KEY, (getMaximum() - getMinimum()) / 2); // Default to middle                                                                                  // position
        setValue(sliderPosition);
        setUI(new CustomSliderUI(this));
        setOpaque(false);
        setPreferredSize(new Dimension(200, 40));

        addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int newValue = getValue();
                prefs.putInt(SLIDER_POSITION_KEY, newValue);
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
        super.paintComponent(g);
    }

    private class CustomSliderUI extends BasicSliderUI {
        public CustomSliderUI(JSlider b) {
            super(b);
        }

        @Override
        public void paintTrack(Graphics g) {
            // Do not paint track
        }

        @Override
        public void paintThumb(Graphics g) {
            int thumbWidth = thumbImage.getWidth(null);
            int thumbHeight = thumbImage.getHeight(null);
            int x = thumbRect.x;
            int y = thumbRect.y + (thumbRect.height - thumbHeight) / 2;
            g.drawImage(thumbImage, x, y, thumbWidth, thumbHeight, null);
        }
    }
}
