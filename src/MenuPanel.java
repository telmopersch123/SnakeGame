import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.Border;

public class MenuPanel extends JPanel {
  private static JButton startButton;
  private static JButton settingsButton;
  private static JButton MapButton;
  private static JButton OutfitButton;
  private static JLabel backgroundLabel;
  static JPanel overlayPanel;
  private static boolean buttonsEnabled = true;
  static JPanel loadingPanel;
  static int CorPretaLoading = 255;
  static JPanel loadingComponents;
  static LoadingSpinner spinner;

  public static void painelLoading() {
    loadingPanel = new JPanel();
    loadingPanel.setBackground(new Color(0, 0, 0, 255));
    loadingPanel.setOpaque(true);
    loadingPanel.setVisible(false);
    loadingPanel.setLayout(new BorderLayout());
  }

  private JLabel SnakeImagem;
  private Timer animationTimer;
  private JButton BotaoExit;
  private StretchIcon backgroundClosedHover;
  private StretchIcon backgroundClosedUNHover;
  private JButton comoButton;

  public MenuPanel() {
    setLayout(new GridBagLayout());
    GridBagConstraints Menu = new GridBagConstraints();

    try {
     
      painelLoading();
    
      Font Fonts = loadFont.loadFont("resources/fontes/fontGeral.ttf", 20);
      ImageIcon buttonReturn = new StretchIcon("resources/Menu/return.png");
      ImageIcon buttonImage = new StretchIcon("resources/Menu/buttonRock.png");
      ImageIcon configImage = new StretchIcon("resources/Menu/configuracoesbutton.png");

    
      Image backgroundImage = ImageIO.read(new File("resources/Menu/thumbMenu.png"));
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      backgroundImage = backgroundImage.getScaledInstance((int) screenSize.getWidth(), (int) screenSize.getHeight(),
          Image.SCALE_SMOOTH); 
      backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
      backgroundLabel.setLayout(new GridBagLayout());

    
      GridBagConstraints bgConstraints = new GridBagConstraints();
      bgConstraints.gridx = 0;
      bgConstraints.gridy = 0;
      bgConstraints.gridwidth = GridBagConstraints.REMAINDER;
      bgConstraints.gridheight = GridBagConstraints.REMAINDER;
      bgConstraints.fill = GridBagConstraints.BOTH;
      bgConstraints.weightx = 1.0;
      bgConstraints.weighty = 1.0;
      if (Game.NotificationGameDesblocked) {
        if (Game.DesblockedPontuation >= 0) {
          NotificationDesblocked.SumirFundo = false;
          if (Game.DesblockedPontuation == 0) {
            Game.DesblockedPontuation = -1;
          }
        }
        overlayPanel = new JPanel() {
          @Override
          protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            if (!NotificationDesblocked.SumirFundo) {
              g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f)); 
            } else {
              g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.0f)); 
            }
            g2d.setColor(Color.BLACK); 
            g2d.fillRect(0, 0, getWidth(), getHeight());
            g2d.dispose();
          }
        };
        overlayPanel.setOpaque(false); 
        add(overlayPanel, bgConstraints);
      }
    
      add(backgroundLabel, bgConstraints);
    
      add(loadingPanel, bgConstraints);
  
      backgroundClosedUNHover = new StretchIcon("resources/Notification/removerNotiunHover.png");
      backgroundClosedHover = new StretchIcon("resources/Notification/removerNotiHover.png");
      BotaoExit = new JButton("", backgroundClosedUNHover);
      BotaoExit.addActionListener(e -> {
        System.exit(0);
      });
      MenuPanel.addShadow(BotaoExit, "", Fonts, 50, 50, false);
      NotificationDesblocked.hoverbuttonExit(BotaoExit, backgroundClosedUNHover, backgroundClosedHover);
      Menu.gridx = 0;
      Menu.gridy = 0;
      Menu.anchor = GridBagConstraints.NORTHWEST;
      Menu.weightx = 1.0; 
      Menu.insets = new Insets(-390, 10, 0, 0);
      backgroundLabel.add(BotaoExit, Menu);
    
      startButton = new JButton("Iniciar Jogo", buttonImage);
      addShadow(startButton, "Iniciar Jogo", Fonts, 150, 50, false);
      startButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          MusicPlayer.AudioClick();
          MusicPlayer.stopMusicMenu();
          if (!buttonsEnabled) {
            return;
          }

          ///
          if (Game.ManterAnimation) {
            backgroundLabel.setVisible(false);
            loadingPanel.setVisible(true);
            startButton.setVisible(false);
            MapButton.setVisible(false);
            OutfitButton.setVisible(false);
            settingsButton.setVisible(false);
          }
          if (Game.RemoverAnimation) {
            Game.aparecerAposLoading = true;
          }
          SwingUtilities.invokeLater(() -> {

            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(MenuPanel.this);
            topFrame.getContentPane().removeAll();
            Game game = new Game();
            new Thread(game).start();
            topFrame.add(game);
            topFrame.revalidate();
            topFrame.repaint();
            game.requestFocusInWindow();
            Game.nodeSnake = Game.ComprimentoCobra;
            Game.ValueFinal = 0;
            Game.ValueDecoNormal = 0;
            Game.quanti.clear();
            Game.quantiComplexo.clear();
            Game.DecoracaoX = new int[0];
            Game.DecoracaoY = new int[0];
            Game.DecoComplexoX = new int[0];
            Game.DecoComplexoY = new int[0];
            decoracao.posicoesDeco(Game.FrameWidth,
                Game.FrameHeight, Game.ALL_DOTS_Width, Game.ALL_DOTS_Height, Game.walls_x,
                Game.walls_y);
            if (Game.ManterAnimation) {
              backgroundLabel.setVisible(true);
              loadingPanel.setVisible(false);
              startButton.setVisible(true);
              MapButton.setVisible(true);
              OutfitButton.setVisible(true);
              settingsButton.setVisible(true);
            }

          });
        }
      });
      Menu.gridy = 1;
      Menu.anchor = GridBagConstraints.CENTER;
      Menu.insets = new Insets(10, 0, 10, 0);
      backgroundLabel.add(startButton, Menu);
      MapButton = new JButton("Mapa", buttonImage);
      MapButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          MusicPlayer.AudioClick();
          if (!buttonsEnabled) {
            return;
          }
          JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(MenuPanel.this);
          MenuPanel.this.setVisible(false);
          MapPanel mapPanel = new MapPanel(buttonReturn);
          topFrame.add(mapPanel);
          topFrame.revalidate();
          topFrame.repaint();
        }
      });

      addShadow(MapButton, "Mapa", Fonts, 150, 50, false);
      Menu.gridy = 2;
      backgroundLabel.add(MapButton, Menu);

      OutfitButton = new JButton("Skin", buttonImage);
      OutfitButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          MusicPlayer.AudioClick();
          if (!buttonsEnabled) {
            return;
          }
          JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(MenuPanel.this);
          MenuPanel.this.setVisible(false);
          SkinPanel skinPanel = new SkinPanel(buttonReturn);
          topFrame.add(skinPanel);
          topFrame.revalidate();
          topFrame.repaint();
        }
      });
      addShadow(OutfitButton, "Skin", Fonts, 150, 50, false);
      Menu.gridy = 3;
      backgroundLabel.add(OutfitButton, Menu);
   
      comoButton = new JButton("Como Jogar!", buttonImage);
      comoButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          MusicPlayer.AudioClick();
          if (!buttonsEnabled) {
            return;
          }
          JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(MenuPanel.this);
          MenuPanel.this.setVisible(false);
          ComoPanel comoPanel = new ComoPanel(buttonReturn);
          topFrame.add(comoPanel);
          topFrame.revalidate();
          topFrame.repaint();
        }
      });
      addShadow(comoButton, "Como Jogar!", Fonts, 150, 50, false);
      Menu.gridy = 4;
      backgroundLabel.add(comoButton, Menu);
     
      settingsButton = new JButton("", configImage);
      settingsButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          MusicPlayer.AudioClick();
          if (!buttonsEnabled) {
            return;
          }
          JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(MenuPanel.this);
          MenuPanel.this.setVisible(false);
          ConfPanel confPanel = new ConfPanel(buttonReturn);
          topFrame.add(confPanel);
          topFrame.revalidate();
          topFrame.repaint();
        }
      });
      addShadow(settingsButton, "", Fonts, 70, 70, false);
      Menu.gridy = 5;
      Menu.insets = new Insets(0, 15, -390, 0);
      Menu.anchor = GridBagConstraints.SOUTHWEST; 
      backgroundLabel.add(settingsButton, Menu);
      if (Game.NotificationGameDesblocked) {
        SwingUtilities.invokeLater(new Runnable() {
          @Override
          public void run() {
            NotificationDesblocked.showNotification((JFrame) SwingUtilities.getWindowAncestor(
                MenuPanel.this), "Desbloqueado!");
            MusicPlayer.notification();
          }
        });
      }
      BufferedImage snakeBackground = ImageIO.read(new File("resources/Menu/snakeMenu.png"));
      int numY = 6;
      int numX = 8;
      int frameWidth = snakeBackground.getWidth() / numX; 
      int frameHeight = snakeBackground.getHeight() / numY; 
      int newFrameWidth = frameWidth + 50; 
      int newFrameHeight = frameHeight + 50; 
      BufferedImage[] frames = new BufferedImage[numY * numX];
      int index = 0;

      for (int row = 0; row < numY; row++) {
        for (int col = 0; col < numX; col++) {
          int x = col * frameWidth;
          int y = row * frameHeight;
          BufferedImage originalFrame = snakeBackground.getSubimage(x, y, frameWidth, frameHeight);
          BufferedImage resizedFrame = new BufferedImage(newFrameWidth, newFrameHeight, originalFrame.getType());
          Graphics2D g2d = resizedFrame.createGraphics();
          g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
          g2d.drawImage(originalFrame, 0, 0, newFrameWidth, newFrameHeight, null);
          g2d.dispose();
          frames[index++] = resizedFrame;
        }
      }
      SnakeImagem = new JLabel(new ImageIcon(frames[0]));

      Timer timer = new Timer(50, e -> {
        currentFrame = (currentFrame + 1) % frames.length;
        SnakeImagem.setIcon(new ImageIcon(frames[currentFrame]));
      });
      timer.start();
      Menu.gridx = 0;
      Menu.gridy = 6;
      Menu.anchor = GridBagConstraints.CENTER;
      Menu.insets = new Insets(0, 0, -800, 0);
      backgroundLabel.add(SnakeImagem, Menu);

    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  int currentFrame = 0;

  public static void setButtonsEnabled(boolean enabled) {
    buttonsEnabled = enabled;
  }

  public static void addShadow(JButton button, String text, Font font, int width, int height, boolean Apos) {
  
    button.setForeground(new Color(0, 0, 0));
    Font originalFont = font; 
    button.setFont(originalFont);
   
    button.setPreferredSize(new Dimension(width, height));
    button.setBorder(BorderFactory.createEmptyBorder());
   
    button.setOpaque(false);
    button.setContentAreaFilled(false);
    button.setBorderPainted(false);
  
    JPanel textPanel = new JPanel();
    textPanel.setOpaque(false);
    JLabel textLabel = new JLabel(text);
    if (width == 220 && Apos) {
      textLabel.setForeground(Color.WHITE);
    } else {
      textLabel.setForeground(new Color(255, 255, 255, 0));
    }
    if (width != 220) {
      textLabel.setForeground(Color.WHITE);
    }
    textLabel.setFont(font);
    textPanel.add(textLabel);
    Border border = BorderFactory.createEmptyBorder(6, 11, 5, 10);
    textPanel.setBorder(border);
   
    button.setLayout(new BorderLayout());
    button.add(textPanel, BorderLayout.CENTER);
    button.setFocusPainted(false);
    Border defaultBorder = button.getBorder();
    Border hoverBorder = BorderFactory.createLineBorder(Color.YELLOW, 2);
    if (width != 220 || width == 220 && Apos) {
      if (text != "Reiniciar" && text != "Inicio") {
        button.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseEntered(MouseEvent e) {
            MusicPlayer.AudioHover();
            if (text != "X") {
              if (!buttonsEnabled) {
                return;
              }
            }
            button.setBorder(hoverBorder);
          }

          @Override
          public void mouseExited(MouseEvent e) {
            if (text != "X") {
              if (!buttonsEnabled) {
                return;
              }
            }
            button.setBorder(defaultBorder);
          }
        });
      } else {
        if (text == "Reiniciar" || text == "Inicio") {
          button.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
              textLabel.setForeground(Color.BLACK);
              MusicPlayer.AudioHover();
            }

            @Override
            public void mouseExited(MouseEvent e) {
              textLabel.setForeground(Color.WHITE);
            }
          });
        }
      }
    }
  }
}

class StretchIcon extends ImageIcon {
  public StretchIcon(String filename) {
    super(filename);
  }

  @Override
  public int getIconWidth() {
    return 0;
  }

  @Override
  public int getIconHeight() {
    return 0;
  }

  @Override
  public void paintIcon(Component c, Graphics g, int x, int y) {
    Image image = getImage();
    int width = c.getWidth();
    int height = c.getHeight();
    g.drawImage(image, 0, 0, width, height, null);
  }

}
