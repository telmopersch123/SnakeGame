import java.awt.BorderLayout;
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

public class MapPanel extends JPanel {
  private JButton ReturnButton;
  private JButton DungeonButton;
  private JButton SwampButton;
  private JButton FieldButton;
  private JLabel backgroundLabel;

  public MapPanel(ImageIcon buttonReturn) {
    setLayout(new BorderLayout());

    // Usar JLayeredPane para controlar a ordem dos componentes
    JLayeredPane layeredPane = new JLayeredPane();
    layeredPane.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

    // Imagem de fundo
    try {
      ImageIcon buttonDungeonINCBack = new StretchIcon("resources/Menu/buttonInactive-Dungeon.png");
      ImageIcon buttonFieldINCBack = new StretchIcon("resources/Menu/buttonInactive-field.png");
      ImageIcon buttonSwampINCBack = new StretchIcon("resources/Menu/buttonInactive-swamp.png");
      /////
      ImageIcon buttonSwampBack = new StretchIcon("resources/Menu/button-swamp.png");
      ImageIcon buttonFieldBack = new StretchIcon("resources/Menu/button-field.png");
      ImageIcon buttonDungeonBack = new StretchIcon("resources/Menu/button-dungeon.png");
      //////
      Image backgroundImage = ImageIO.read(new File("resources/Menu/backgroundMenu.png"));
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      backgroundImage = backgroundImage.getScaledInstance((int) screenSize.getWidth(), (int) screenSize.getHeight(),
          Image.SCALE_SMOOTH); // Redimensionar a imagem
      backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
      backgroundLabel.setSize(screenSize);
      backgroundLabel.setLayout(new GridBagLayout()); // Definir layout para centralizar o texto
      layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

      // Botão de retorno
      ReturnButton = new JButton("", buttonReturn);
      ReturnButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(MapPanel.this);
          MenuPanel menuPanel = new MenuPanel(); // Crie uma nova instância de MenuPanel
          topFrame.getContentPane().removeAll();
          topFrame.getContentPane().add(menuPanel);
          topFrame.revalidate();
          topFrame.repaint();
        }
      });
      ReturnButton.setBounds(10, 10, 60, 40); // Posição do botão no canto superior esquerdo
      ReturnButtonImage(ReturnButton, 60, 40, new Font("Arial", Font.BOLD, 18));
      layeredPane.add(ReturnButton, JLayeredPane.PALETTE_LAYER);

      // Texto no mapa
      JLabel mapLabel = new JLabel("Cenários de Fuga");
      mapLabel.setFont(new Font("Arial", Font.BOLD, 36));
      mapLabel.setForeground(Color.WHITE); // Certificar-se de que o texto é visível sobre o fundo
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.insets = new Insets(10, 0, 10, 0);
      gbc.anchor = GridBagConstraints.CENTER;
      backgroundLabel.add(mapLabel, gbc);
      // Adicionar o layeredPane ao painel principal
      add(layeredPane, BorderLayout.CENTER);
      if (Game.MapDungeon) {
        DungeonButton = new JButton("Masmorra", buttonDungeonBack);
      } else if (!Game.MapDungeon) {
        DungeonButton = new JButton("Masmorra", buttonDungeonINCBack);
      }
      Font fontDungeon = new Font("Arial", Font.BOLD, 18);
      DungeonButton.setFont(fontDungeon);
      DungeonButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          Game.MapDungeon = true;
          Game.MapField = false;
          Game.MapSwamp = false;
          DungeonButton.setIcon(buttonDungeonBack);
          SwampButton.setIcon(buttonSwampINCBack);
          FieldButton.setIcon(buttonFieldINCBack);
          SwampButton.setPreferredSize(new Dimension(200, 50));
          FieldButton.setPreferredSize(new Dimension(200, 50));
          DungeonButton.setPreferredSize(new Dimension(400, 70));
          DungeonButton.revalidate();
          DungeonButton.repaint();
        }
      });
      ReturnButtonImage(DungeonButton, 300, 50, new Font("Arial", Font.BOLD, 18));
      gbc.gridx = 0;
      gbc.gridy = 1;
      backgroundLabel.add(DungeonButton, gbc);
      /////////////////////////
      if (Game.MapSwamp) {
        SwampButton = new JButton("Pântano", buttonSwampBack);
      } else if (!Game.MapSwamp) {
        SwampButton = new JButton("Pântano", buttonSwampINCBack);
      }
      Font fontSwamp = new Font("Arial", Font.BOLD, 18);
      SwampButton.setFont(fontSwamp);
      SwampButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          Game.MapDungeon = false;
          Game.MapField = false;
          Game.MapSwamp = true;
          DungeonButton.setIcon(buttonDungeonINCBack);
          SwampButton.setIcon(buttonSwampBack);
          FieldButton.setIcon(buttonFieldINCBack);
          SwampButton.setPreferredSize(new Dimension(400, 70));
          FieldButton.setPreferredSize(new Dimension(200, 50));
          DungeonButton.setPreferredSize(new Dimension(200, 50));
          SwampButton.revalidate();
          SwampButton.repaint();
        }
      });
      ReturnButtonImage(SwampButton, 300, 50, new Font("Arial", Font.BOLD, 18));
      gbc.gridx = 0;
      gbc.gridy = 2;
      backgroundLabel.add(SwampButton, gbc);
      /////////////////////////
      if (Game.MapField) {
        FieldButton = new JButton("Planície", buttonFieldBack);
      } else if (!Game.MapField) {
        FieldButton = new JButton("Planície", buttonFieldINCBack);
      }
      Font fontField = new Font("Arial", Font.BOLD, 18);
      FieldButton.setFont(fontField);
      FieldButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          Game.MapDungeon = false;
          Game.MapField = true;
          Game.MapSwamp = false;
          DungeonButton.setIcon(buttonDungeonINCBack);
          SwampButton.setIcon(buttonSwampINCBack);
          FieldButton.setIcon(buttonFieldBack);
          SwampButton.setPreferredSize(new Dimension(200, 50));
          FieldButton.setPreferredSize(new Dimension(400, 70));
          DungeonButton.setPreferredSize(new Dimension(200, 50));
          FieldButton.revalidate();
          FieldButton.repaint();
        }
      });
      ReturnButtonImage(FieldButton, 300, 50, new Font("Arial", Font.BOLD, 18));
      gbc.gridx = 0;
      gbc.gridy = 3;
      backgroundLabel.add(FieldButton, gbc);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public static void ReturnButtonImage(JButton button, int width, int height, Font font) {
    button.setForeground(new Color(0, 0, 0));
    // DESENHAR BOTAO
    button.setPreferredSize(new Dimension(width, height));
    button.setBorder(BorderFactory.createEmptyBorder());
    // Configuração do botão para ser transparente
    button.setOpaque(false);
    button.setContentAreaFilled(false);
    button.setBorderPainted(false);
    button.setFocusable(false);
    button.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        button.setForeground(Color.WHITE);
        button.setSize(new Dimension(width - 10, height - 5));
        button.revalidate();
        button.repaint();
      }

      @Override
      public void mouseExited(MouseEvent e) {
        button.setForeground(Color.BLACK);
        button.setSize(new Dimension(width, height));
        button.revalidate();
        button.repaint();
      }
    });
  }

}
