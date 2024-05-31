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
  private JButton startButton;
  private JButton settingsButton;
  private JButton MapButton;
  private JButton OutfitButton;
  private JLabel backgroundLabel;
  private Border border;
  private int raio;
  private Graphics2D g2d;

  public void BordaArredondada(int raio) {
    this.raio = raio;
  }

  public MenuPanel() {
    setLayout(new GridBagLayout());
    GridBagConstraints Menu = new GridBagConstraints();

    try {
      // Carregue a imagem do fundo
      Image backgroundImage = ImageIO.read(new File("resources/thumbMenu.png"));
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
      add(backgroundLabel, bgConstraints);

      // Adicione os botões sobre a imagem de fundo

      ImageIcon buttonImage = new StretchIcon("resources/buttonRock.png");

      startButton = new JButton("Iniciar Jogo", buttonImage);
      startButton.setBorder(BorderFactory.createEmptyBorder());
      Color borderColor = Color.decode("#8B4513");
      border = BorderFactory.createLineBorder(borderColor, 2);
      startButton.setBorder(border);
      // Define a nova borda do botão
      startButton.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
          border = BorderFactory.createLineBorder(Color.WHITE, 2);
          startButton.setBorder(border);
        }

        @Override
        public void mouseExited(MouseEvent e) {
          border = BorderFactory.createLineBorder(borderColor, 2);
          startButton.setBorder(border);
        }
      });

      startButton.setForeground(Color.WHITE);
      startButton.setFont(new Font("Arial", Font.PLAIN, 24));
      startButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(MenuPanel.this);
          topFrame.getContentPane().removeAll();
          Game game = new Game();
          topFrame.add(game);
          topFrame.revalidate();
          new Thread(game).start();
          game.requestFocusInWindow();
        }
      });
      Menu.gridx = 0;
      Menu.gridy = 0;
      Menu.insets = new Insets(10, 0, 10, 0);
      backgroundLabel.add(startButton, Menu);

      buttonImage = new StretchIcon("resources/buttonTexture.jpg");
      MapButton = new JButton("Mapa", buttonImage);
      MapButton.setFont(new Font("Arial", Font.PLAIN, 24));
      MapButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          // Ação para o botão de mapa
        }
      });
      Menu.gridy = 1;
      backgroundLabel.add(MapButton, Menu);

      buttonImage = new StretchIcon("resources/buttonTexture.jpg");
      OutfitButton = new JButton("Skin", buttonImage);
      OutfitButton.setFont(new Font("Arial", Font.PLAIN, 24));
      OutfitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          // Ação para o botão de skins
        }
      });
      Menu.gridy = 2;
      backgroundLabel.add(OutfitButton, Menu);

      buttonImage = new StretchIcon("resources/buttonTexture.jpg");
      settingsButton = new JButton("Configurações", buttonImage);
      settingsButton.setFont(new Font("Arial", Font.PLAIN, 24));
      settingsButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          // Ação para o botão de configurações
        }
      });
      Menu.gridy = 3;
      backgroundLabel.add(settingsButton, Menu);

    } catch (IOException ex) {
      ex.printStackTrace();
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
