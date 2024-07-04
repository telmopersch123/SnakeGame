import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SkinPanel extends JPanel {
  private JLabel backgroundLabel;
  private JButton ReturnButton;
  private JButton ClassicSkinButton;
  private JButton PoisonSkinButton;
  private JButton FireSkinButton;

  public SkinPanel(ImageIcon buttonReturn) {
    // Usar JLayeredPane para controlar a ordem dos componentes
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setLayout(null);
    JLayeredPane layeredPane = new JLayeredPane();
    layeredPane.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
    layeredPane.setPreferredSize(screenSize);
    layeredPane.setBounds(0, 0, screenSize.width, screenSize.height);

    try {
      // -fundo
      Font Fonts = loadFont.loadFont("resources/fontes/fontGeral.otf", 16);
      Font FontsTitulo = loadFont.loadFont("resources/fontes/fontGeral.otf", 34);
      Image backgroundImage = ImageIO.read(new File("resources/Menu/backgroundMenu.png"));
      ///
      ImageIcon buttonclassicoINCsnake = new StretchIcon("resources/Menu/botaoclassicoinativo.png");
      ImageIcon buttonpoisonINCsnake = new StretchIcon("resources/Menu/botaopoisoninativo.png");
      ImageIcon buttonfireINCsnake = new StretchIcon("resources/Menu/botaofireinativo.png");
      /////
      ImageIcon buttonclassicosnake = new StretchIcon("resources/Menu/botaoclassico.png");
      ImageIcon buttonpoisonsnake = new StretchIcon("resources/Menu/botaoposion.png");
      ImageIcon buttonfiresnake = new StretchIcon("resources/Menu/botaosnake.png");
      /////
      ImageIcon buttonclassicohover = new StretchIcon("resources/Menu/hover1.png");
      ImageIcon buttonpoisonhover = new StretchIcon("resources/Menu/hover2.png");
      ImageIcon buttonfirehover = new StretchIcon("resources/Menu/hover3.png");
      /////
      ImageIcon buttonclassicohoverinc = new StretchIcon("resources/Menu/hoverinc1.png");
      ImageIcon buttonpoisonhoverinc = new StretchIcon("resources/Menu/hoverinc2.png");
      ImageIcon buttonfirehoverinc = new StretchIcon("resources/Menu/hoverinc3.png");
      backgroundImage = backgroundImage.getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH); // Redimensionar
                                                                                                                    // //
                                                                                                                    // imagem
      backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
      backgroundLabel.setBounds(0, 0, screenSize.width, screenSize.height);
      backgroundLabel.setLayout(new GridBagLayout()); // Definir layout para centralizar o texto
      layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

      // Botão de retorno
      ReturnButton = new JButton("", buttonReturn);
      ReturnButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(SkinPanel.this);
          MenuPanel menuPanel = new MenuPanel(); // Crie uma nova instância de MenuPanel
          topFrame.getContentPane().removeAll();
          topFrame.getContentPane().add(menuPanel);
          topFrame.revalidate();
          topFrame.repaint();
        }
      });
      ReturnButton.setBounds(10, 10, 60, 40); // Posição do botão no canto superior esquerdo
      MapPanel.ReturnButtonImage(ReturnButton, 60, 40, Fonts);

      layeredPane.add(ReturnButton, JLayeredPane.PALETTE_LAYER);
      // Texto no mapa
      JLabel mapLabel = new JLabel("Skins Alternativas");
      mapLabel.setFont(FontsTitulo);
      mapLabel.setForeground(Color.WHITE); // Certificar-se de que o texto é visível sobre o fundo
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.insets = new Insets(10, 0, 10, 0);
      gbc.anchor = GridBagConstraints.CENTER;
      backgroundLabel.add(mapLabel, gbc);
      // BOTÕES
      if (Game.snakeClassica) {
        ClassicSkinButton = new JButton("", buttonclassicosnake);
      } else if (!Game.snakeClassica) {
        ClassicSkinButton = new JButton("", buttonclassicoINCsnake);
      }
      Font fontClassic = Fonts;
      ClassicSkinButton.setFont(fontClassic);
      ClassicSkinButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          Game.snakeClassica = true;
          Game.snakePoison = false;
          Game.snakeFire = false;
          ClassicSkinButton.setIcon(buttonclassicosnake);
          PoisonSkinButton.setIcon(buttonpoisonINCsnake);
          FireSkinButton.setIcon(buttonfireINCsnake);
          ClassicSkinButton.setPreferredSize(new Dimension(250, 80));
          PoisonSkinButton.setPreferredSize(new Dimension(150, 50));
          FireSkinButton.setPreferredSize(new Dimension(150, 50));
          ClassicSkinButton.revalidate();
          ClassicSkinButton.repaint();
        }
      });
      MapPanel.ReturnButtonImage(ClassicSkinButton, 150, 50, Fonts);

      gbc.gridx = 0;
      gbc.gridy = 1;
      backgroundLabel.add(ClassicSkinButton, gbc);
      ////
      if (Game.snakePoison) {
        PoisonSkinButton = new JButton("", buttonpoisonsnake);
      } else if (!Game.snakePoison) {
        PoisonSkinButton = new JButton("", buttonpoisonINCsnake);
      }
      Font fontPoison = Fonts;
      PoisonSkinButton.setFont(fontPoison);
      PoisonSkinButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          Game.snakeClassica = false;
          Game.snakePoison = true;
          Game.snakeFire = false;
          ClassicSkinButton.setIcon(buttonclassicoINCsnake);
          PoisonSkinButton.setIcon(buttonpoisonsnake);
          FireSkinButton.setIcon(buttonfireINCsnake);
          ClassicSkinButton.setPreferredSize(new Dimension(150, 50));
          PoisonSkinButton.setPreferredSize(new Dimension(250, 80));
          FireSkinButton.setPreferredSize(new Dimension(150, 50));
          PoisonSkinButton.revalidate();
          PoisonSkinButton.repaint();
        }
      });
      MapPanel.ReturnButtonImage(PoisonSkinButton, 150, 50, Fonts);

      gbc.gridx = 0;
      gbc.gridy = 2;
      backgroundLabel.add(PoisonSkinButton, gbc);
      ////
      if (Game.snakeFire) {
        FireSkinButton = new JButton("", buttonfiresnake);
      } else if (!Game.snakeFire) {
        FireSkinButton = new JButton("", buttonfireINCsnake);
      }
      Font fontFire = Fonts;
      FireSkinButton.setFont(fontFire);
      FireSkinButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          Game.snakeClassica = false;
          Game.snakePoison = false;
          Game.snakeFire = true;
          ClassicSkinButton.setIcon(buttonclassicoINCsnake);
          PoisonSkinButton.setIcon(buttonpoisonINCsnake);
          FireSkinButton.setIcon(buttonfiresnake);
          ClassicSkinButton.setPreferredSize(new Dimension(150, 50));
          PoisonSkinButton.setPreferredSize(new Dimension(150, 50));
          FireSkinButton.setPreferredSize(new Dimension(250, 80));
          FireSkinButton.revalidate();
          FireSkinButton.repaint();
        }
      });
      MapPanel.ReturnButtonImage(FireSkinButton, 150, 50, Fonts);

      gbc.gridx = 0;
      gbc.gridy = 3;
      backgroundLabel.add(FireSkinButton, gbc);
      /////////////
      hoveres(ClassicSkinButton, PoisonSkinButton, FireSkinButton, 150, 50, buttonclassicohover, buttonpoisonhover,
          buttonfirehover,
          buttonclassicohoverinc, buttonpoisonhoverinc, buttonfirehoverinc, buttonclassicosnake, buttonpoisonsnake,
          buttonfiresnake, buttonclassicoINCsnake, buttonpoisonINCsnake, buttonfireINCsnake);
      add(layeredPane);
      setPreferredSize(screenSize);
      setBounds(0, 0, screenSize.width, screenSize.height);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public static void hoveres(JButton buttonClassico,
      JButton buttonPoison,
      JButton buttonFire, int width, int height, ImageIcon buttonclassicohover,
      ImageIcon buttonpoisonhover, ImageIcon buttonfirehover, ImageIcon buttonclassicohoverinc,
      ImageIcon buttonpoisonhoverinc, ImageIcon buttonfirehoverinc, ImageIcon buttonclassicosnake,
      ImageIcon buttonpoisonsnake, ImageIcon buttonfiresnake, ImageIcon buttonclassicoINCsnake,
      ImageIcon buttonpoisonINCsnake, ImageIcon buttonfireINCsnake) {
    buttonClassico.setPreferredSize(new Dimension(width, height));
    buttonClassico.setBorder(BorderFactory.createEmptyBorder());
    buttonClassico.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        if (Game.snakeClassica) {
          buttonClassico.setIcon(buttonclassicohover);
        } else if (!Game.snakeClassica) {
          buttonClassico.setIcon(buttonclassicohoverinc);
        }

        buttonClassico.revalidate();
        buttonClassico.repaint();
      }

      @Override
      public void mouseExited(MouseEvent e) {
        if (Game.snakeClassica) {
          buttonClassico.setIcon(buttonclassicosnake);
        } else if (!Game.snakeClassica) {
          buttonClassico.setIcon(buttonclassicoINCsnake);
        }

        buttonClassico.revalidate();
        buttonClassico.repaint();
      }
    });
    buttonPoison.setPreferredSize(new Dimension(width, height));
    buttonPoison.setBorder(BorderFactory.createEmptyBorder());
    buttonPoison.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        if (Game.snakePoison) {
          buttonPoison.setIcon(buttonpoisonhover);
        } else if (!Game.snakePoison) {
          buttonPoison.setIcon(buttonpoisonhoverinc);
        }
        buttonPoison.revalidate();
        buttonPoison.repaint();
      }

      @Override
      public void mouseExited(MouseEvent e) {
        if (Game.snakePoison) {
          buttonPoison.setIcon(buttonpoisonsnake);
        } else if (!Game.snakePoison) {
          buttonPoison.setIcon(buttonpoisonINCsnake);
        }
        buttonPoison.revalidate();
        buttonPoison.repaint();
      }
    });
    buttonFire.setPreferredSize(new Dimension(width, height));
    buttonFire.setBorder(BorderFactory.createEmptyBorder());
    buttonFire.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        if (Game.snakeFire) {
          buttonFire.setIcon(buttonfirehover);
        } else if (!Game.snakeFire) {
          buttonFire.setIcon(buttonfirehoverinc);
        }
        buttonFire.revalidate();
        buttonFire.repaint();
      }

      @Override
      public void mouseExited(MouseEvent e) {
        if (Game.snakeFire) {
          buttonFire.setIcon(buttonfiresnake);
        } else if (!Game.snakeFire) {
          buttonFire.setIcon(buttonfireINCsnake);
        }
        buttonFire.revalidate();
        buttonFire.repaint();
      }
    });
  }
}
