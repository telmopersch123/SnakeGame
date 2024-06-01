import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MapPanel extends JPanel {
  private JButton ReturnButton;
  private JLabel backgroundLabel;

  public MapPanel(ImageIcon buttonImage) {
    setLayout(new GridBagLayout());

    // imagem de fundo
    try {
      Image backgroundImage = ImageIO.read(new File("resources/backgroundMenu.png"));
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

      ReturnButton = new JButton("Retornar", buttonImage);
      ReturnButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(MapPanel.this);
          MenuPanel menuPanel = new MenuPanel(); // Create a new instance of MenuPanel
          topFrame.getContentPane().removeAll();
          topFrame.getContentPane().add(menuPanel);
          topFrame.revalidate();
          topFrame.repaint();
        }
      });
      MenuPanel.addShadow(ReturnButton, "Retornar", new Font("Arial", Font.PLAIN, 24), 150, 50);
      GridBagConstraints Menu = new GridBagConstraints();
      Menu.gridy = 0;
      backgroundLabel.add(ReturnButton, Menu);
      JLabel mapLabel = new JLabel("Essa é a tela do mapa!");
      mapLabel.setFont(new Font("Arial", Font.BOLD, 36));

      Menu.gridx = 0;
      Menu.gridy = 1;
      Menu.insets = new Insets(10, 0, 10, 0);
      backgroundLabel.add(mapLabel, Menu);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
