import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.prefs.Preferences;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicSliderUI;

public class CustomSlider extends JSlider {
    private Image backgroundImage;
    private Image thumbImage;
    private static Preferences prefs = Preferences.userNodeForPackage(CustomSlider.class);
    private static final String SLIDER_POSITION_KEY = "slider_position";

    public CustomSlider(Image backgroundImage, Image thumbImage) {
        super();
        this.backgroundImage = backgroundImage;
        this.thumbImage = thumbImage;

        int sliderPosition = prefs.getInt(SLIDER_POSITION_KEY, (getMaximum() - getMinimum()) / 2);
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

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int mouseX = e.getX();
                int thumbWidth = thumbImage.getWidth(null);
                int minPos = thumbWidth / 2;
                int maxPos = getWidth() - thumbWidth / 2;

                // Calcular o novo valor baseado na posição do mouse
                int newValue = (int) Math.round((double) (mouseX - minPos) / (maxPos - minPos) * getMaximum());

                // Ignorar cliques entre 1 e 20
                // Se o novo valor estiver entre 1 e 10, ir para a posição 1
                if (newValue >= -10 && newValue <= 10) {
                    setValue(5);
                } else {
                    setValue(newValue);
                }

            }
        });

    }

    public void updateImages(Image background, Image thumb) {
        this.backgroundImage = background;
        this.thumbImage = thumb;
        repaint(); // Repaint para aplicar as mudanças
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
            // Não pintar a trilha
        }

        private static final int OFFSET = 5;

        @Override
        public void paintThumb(Graphics g) {
            int thumbWidth = thumbImage.getWidth(null);
            int thumbHeight = thumbImage.getHeight(null);
            int x = thumbRect.x - thumbWidth / 2;
            int y = thumbRect.y + (thumbRect.height - thumbHeight) / 2;

            if (slider.getValue() == slider.getMinimum()) {
                x = Math.max(0, thumbRect.x - thumbWidth / 2 + OFFSET + 10);
            } else if (slider.getValue() == slider.getMaximum()) {
                x = Math.min(slider.getWidth() - thumbWidth, thumbRect.x - thumbWidth / 2 - OFFSET);
            }

            g.drawImage(thumbImage, x, y, thumbWidth, thumbHeight, null);
        }

    }

}
