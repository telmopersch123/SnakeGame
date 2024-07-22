import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class NotificationDesblocked {
    static boolean SumirFundo = false;
    public static ImageIcon backgroundClosedUNHover;
    public static ImageIcon backgroundClosedHover;
    static JButton closeButton;
    private static Image originalImage;
    private static Image originalImage2;
    static JLabel imageLabel;
    static JPanel TextPanel;
    static Image resizedImage;
    static Image resizedImage2;

    public static void showNotification(JFrame parentFrame, String message) {
        // Criar um JPanel personalizado com fundo transparente

        MenuPanel.setButtonsEnabled(false);
        Font Fonts = loadFont.loadFont("resources/fontes/fontGeral.ttf", 18);
        int desiredWidth = 500; // Largura desejada
        int desiredHeight = 400; // Altura desejada
        JWindow window = new JWindow(parentFrame);

        window.setBackground(new Color(0, 0, 0, 0)); // Fundo completamente transparente
        window.setOpacity(0f);
        window.setLayout(new BorderLayout());
        JPanel panel = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                setOpaque(false);
                try {
                    Image backgroundImage = ImageIO.read(new File("resources/Notification/guiNotification.png"));
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        panel.setLayout(new GridBagLayout());
        backgroundClosedUNHover = new StretchIcon("resources/Notification/removerNotiunHover.png");
        backgroundClosedHover = new StretchIcon("resources/Notification/removerNotiHover.png");
        //
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagConstraints gbcButton = new GridBagConstraints();
        gbcButton.gridx = 1;
        gbcButton.gridy = 0;
        gbcButton.weightx = 1.0;
        gbcButton.weighty = 1.0;
        gbcButton.anchor = GridBagConstraints.NORTH;
        if (Game.MapLiberation == "Pântano") {
            gbcButton.insets = new Insets(35, 0, 0, 45); // Adicionar margem superior
            gbc.insets = new Insets(-170, 5, 0, 0); // Adicionar margem superior
        } else if (Game.MapLiberation == "Masmorra") {
            gbcButton.insets = new Insets(35, 0, 0, 53); // Adicionar margem superior
        } else if (Game.SnakeLiberation == "Boitata") {
            gbcButton.insets = new Insets(35, 0, 0, 42); // Adicionar margem superior
            gbc.insets = new Insets(-170, 10, 0, 0); // Adicionar margem superior
        }
        // gbc.insets = new java.awt.Insets(0, 0, 0, 0); // Adicionar margem superior
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setOpaque(false);
        closeButton = new JButton("", backgroundClosedUNHover);
        closeButton.addActionListener(e -> {
            MusicPlayer.AudioClick();
            SumirFundo = true;
            MenuPanel.overlayPanel.revalidate();
            MenuPanel.overlayPanel.repaint();
            MenuPanel.setButtonsEnabled(true);
            Game.NotificationGameDesblocked = false;
            window.dispose(); // Fechar o diálogo ao clicar no botão "X"
        });

        MenuPanel.addShadow(closeButton, "", Fonts, 50, 50, false);
        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                closeButton.setIcon(backgroundClosedHover);
                MusicPlayer.AudioHover();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                closeButton.setIcon(backgroundClosedUNHover);
            }
        });
        buttonPanel.add(closeButton, BorderLayout.EAST);
        panel.add(buttonPanel, gbcButton);

        /////////////
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        ////////////////////////////

        if (Game.DesblockedPontuation >= 1 && Game.MapLiberation != null) {
            gbc.gridx = 0;
            JLabel MAPA = new JLabel("Novo Mapa :" + Game.MapLiberation);
            MAPA = new TextShadow("Novo Mapa :" + Game.MapLiberation, Color.WHITE, Color.BLACK, Fonts);
            MAPA.setHorizontalAlignment(JLabel.CENTER); // Centralizar o texto
            gbc.gridy = 1;
            panel.add(MAPA, gbc);
            ChamarImagemMapa();
            panel.add(imageLabel, gbc);
        }
        //////////////////////////////////////////
        if (Game.DesblockedPontuation <= 1) {
            JLabel SKIN = new JLabel("Nova Skin :" + Game.SnakeLiberation);
            SKIN = new TextShadow("Nova Skin :" + Game.SnakeLiberation, Color.WHITE, Color.BLACK, Fonts);
            SKIN.setHorizontalAlignment(JLabel.CENTER); // Centralizar o texto
            gbc.gridy = 2;
            if (Game.MapLiberation == "Masmorra") {
                gbc.insets = new Insets(-30, 0, 75, 0); // Adicionar margem superior
            }
            panel.add(SKIN, gbc);
            ChamarImagemSkin();
            panel.add(imageLabel, gbc);
        }
        panel.setBorder(BorderFactory.createEmptyBorder(0, 125, 0, 0));
        /////////////////////////////////////////

        TextPanel = new JPanel(new BorderLayout());
        TextPanel.setOpaque(false);
        JLabel DESBLOCKEDtext = new JLabel(message);
        DESBLOCKEDtext = new TextShadow(message, Color.WHITE, Color.BLACK, Fonts);
        TextPanel.add(DESBLOCKEDtext, BorderLayout.CENTER);
        if (Game.SnakeLiberation == "Boitata") {
            TextPanel.setBorder(BorderFactory.createEmptyBorder(120, 0, 0, 8));
        } else if (Game.MapLiberation == "Pântano") {
            TextPanel.setBorder(BorderFactory.createEmptyBorder(120, 0, 0, 5));
        } else if (Game.MapLiberation == "Masmorra") {
            gbc.insets = new Insets(-30, 0, 65, 5); // Adicionar margem superior
        }

        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER; // Centraliza verticalmente
        panel.add(TextPanel, gbc);
        //////////////////////////////////////
        window.add(panel);
        window.pack();
        window.setSize(desiredWidth, desiredHeight);
        window.setLocationRelativeTo(parentFrame);
        window.setVisible(true);
        window.setOpacity(1f);
    }

    public static void ChamarImagemMapa() {
        try {
            if (Game.MapLiberation == "Pântano") {
                originalImage = ImageIO.read(new File("resources/Notification/IconSwamp.png"));
            } else if (Game.MapLiberation == "Masmorra") {
                originalImage = ImageIO.read(new File("resources/Notification/IconDungeon.png"));
            }
            if (Game.MapLiberation == "Pântano" || Game.SnakeLiberation == "Boitata") {
                resizedImage = originalImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            } else {
                resizedImage = originalImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            }

            ImageIcon icon = new ImageIcon(resizedImage);
            imageLabel = new JLabel(icon);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void ChamarImagemSkin() {
        //////////////////////////////
        try {
            if (Game.SnakeLiberation == "Venenosa") {
                originalImage2 = ImageIO.read(new File("resources/Notification/iconPoisonsnake.png"));
            } else if (Game.SnakeLiberation == "Boitata") {
                originalImage2 = ImageIO.read(new File("resources/Notification/iconFiresnake.png"));
            }
            if (Game.MapLiberation == "Pântano" || Game.SnakeLiberation == "Boitata") {
                resizedImage2 = originalImage2.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            } else {
                resizedImage2 = originalImage2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            }
            ImageIcon icon2 = new ImageIcon(resizedImage2);
            imageLabel = new JLabel(icon2);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
