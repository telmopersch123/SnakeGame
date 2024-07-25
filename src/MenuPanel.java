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
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.SwingUtilities;
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

  public MenuPanel() {
    setLayout(new GridBagLayout());
    GridBagConstraints Menu = new GridBagConstraints();

    try {

      // ========LOADING-----------
      painelLoading();
      // ==========================
      // Carregue a imagem dos botoes
      Font Fonts = loadFont.loadFont("resources/fontes/fontGeral.ttf", 20);
      ImageIcon buttonReturn = new StretchIcon("resources/Menu/return.png");
      ImageIcon buttonImage = new StretchIcon("resources/Menu/buttonRock.png");
      // Carregue a imagem do fundo
      Image backgroundImage = ImageIO.read(new File("resources/Menu/thumbMenu.png"));
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      backgroundImage = backgroundImage.getScaledInstance((int) screenSize.getWidth(), (int) screenSize.getHeight(),
          Image.SCALE_SMOOTH); // Redimensionar a imagem
      backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
      backgroundLabel.setLayout(new GridBagLayout());

      // Adicione o JLabel com a imagem ao fundo
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
              g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f)); // Transparência de 50%
            } else {
              g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.0f)); // Transparência de 0%
            }
            g2d.setColor(Color.BLACK); // Cor do fundo
            g2d.fillRect(0, 0, getWidth(), getHeight());
            g2d.dispose();
          }
        };
        overlayPanel.setOpaque(false); // Deixe o overlayPanel transparente
        add(overlayPanel, bgConstraints);
      }
      //
      add(backgroundLabel, bgConstraints);
      //
      add(loadingPanel, bgConstraints);
      //
      // SOMBREAMENTO NORMAL
      startButton = new JButton("Iniciar Jogo", buttonImage);
      addShadow(startButton, "Iniciar Jogo", Fonts, 150, 50, false);
      ////////////////////////////////////////////////
      startButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          MusicPlayer.AudioClick();
          MusicPlayer.restartExecutorService();
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
      Menu.gridx = 0;
      Menu.gridy = 0;
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
      Menu.gridy = 1;
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
      Menu.gridy = 2;
      backgroundLabel.add(OutfitButton, Menu);

      settingsButton = new JButton("Configurações", buttonImage);
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
      addShadow(settingsButton, "Configurações", Fonts, 180, 50, false);
      Menu.gridy = 3;
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
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public static void setButtonsEnabled(boolean enabled) {
    buttonsEnabled = enabled;
  }

  public static void addShadow(JButton button, String text, Font font, int width, int height, boolean Apos) {
    // Adicione os botões sobre a imagem de fundo
    button.setForeground(new Color(0, 0, 0));
    Font originalFont = font; // Armazena a fonte original do botão
    button.setFont(originalFont);
    // DESENHAR BOTAO
    button.setPreferredSize(new Dimension(width, height));
    button.setBorder(BorderFactory.createEmptyBorder());
    // Configuração do botão para ser transparente
    button.setOpaque(false);
    button.setContentAreaFilled(false);
    button.setBorderPainted(false);
    // Configuração da SOMBRA SIMPLES
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
    Border border = BorderFactory.createEmptyBorder(6, 11, 5, 10); // Ajuste conforme necessário
    textPanel.setBorder(border);
    // Configuração do hover;
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
