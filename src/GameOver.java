import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GameOver {
  public static void drawGameOver(Graphics g, int width, int height, int FrameWidth, int FrameHeight, boolean gameOver,
      int score, int direction, Node[] nodeSnake, ArrayList<Integer> walls_x, ArrayList<Integer> walls_y, int macaX,
      int macaY, int WIDTH, int HEIGHT, Game game, JPanel panel) {
    Color overlayColor = new Color(0, 0, 0, 64);
    g.setColor(overlayColor);
    g.fillRect(0, 0, width, height);

    String msg = "Game Over";
    Font small = new Font("Helvetica", Font.BOLD, 14);
    java.awt.FontMetrics metr = g.getFontMetrics(small);
    // Coordenadas para centralizar o texto no eixo x
    int x = (width - metr.stringWidth(msg)) / 2;
    // Coordenadas para posicionar o texto verticalmente no centro da tela
    int y = height / 2;
    g.setColor(Color.WHITE);
    g.setFont(small);
    g.drawString(msg, x, y);

    boolean newGameButtonExists = false;
    for (int i = 0; i < panel.getComponentCount(); i++) {
      if (panel.getComponent(i) instanceof JButton) {
        JButton button = (JButton) panel.getComponent(i);
        if (button.getText().equals("New Game")) {
          newGameButtonExists = true;
          break;
        }
      }
    }

    // Se o botão "New Game" não existir, desenha o botão e adiciona-o ao JPanel
    if (!newGameButtonExists) {
      drawNewGameButton(g, width, height, FrameWidth, FrameHeight, gameOver, score, direction, nodeSnake, walls_x,
          walls_y, macaX, macaY, WIDTH, HEIGHT, game, panel);
    }
  }

  // Método para desenhar o botão "New Game"
  private static void drawNewGameButton(Graphics g, int width, int height, int FrameWidth, int FrameHeight,
      boolean gameOver,
      int score, int direction, Node[] nodeSnake, ArrayList<Integer> walls_x, ArrayList<Integer> walls_y, int macaX,
      int macaY, int WIDTH, int HEIGHT, Game game, JPanel panel) {
    int buttonWidth = 150; // largura desejada do botão
    int buttonHeight = 30; // altura desejada do botão
    int buttonX = (width - buttonWidth) / 2; // calcula a posição x para centralizar o botão horizontalmente
    int buttonY = height / 2 + 25; // posição y, pode ajustar conforme necessário
    // Criação do botão "New Game"
    JButton newGameButton = new JButton("New Game") {
      // Sobrescreve o método paintComponent para desenhar a forma arredondada e o
      // texto
      @Override
      protected void paintComponent(Graphics g) {
        if (!isOpaque()) {
          super.paintComponent(g);
          return;
        }
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, width - 1, height - 1, 10, 10);
        g2d.setColor(getBackground());
        g2d.fill(roundedRectangle);
        g2d.setColor(getForeground());
        g2d.draw(roundedRectangle);
        // Centraliza o texto dentro do botão
        java.awt.FontMetrics metrics = g.getFontMetrics(getFont());
        int x = (width - metrics.stringWidth(getText())) / 2;
        int y = ((height - metrics.getHeight()) / 2) + metrics.getAscent();
        g2d.setColor(getForeground());
        g2d.drawString(getText(), x, y);
        g2d.dispose();
      }

      // Sobrescreve o método contains para considerar a forma arredondada ao
      // verificar se um ponto está dentro do botão
      @Override
      public boolean contains(int x, int y) {
        if (new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 10, 10).contains(x, y)) {
          return true;
        } else {
          return false;
        }
      }
    };
    newGameButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
    newGameButton.setFocusPainted(false); // Remove a decoração de foco (quadrado
    // ao redor do botão)
    newGameButton.setBorder(BorderFactory.createEmptyBorder()); // Remove a borda
    newGameButton.setBackground(new Color(192, 192, 192, 128)); // Cinza transparente
    newGameButton.setForeground(Color.BLACK);

    newGameButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Reinicia as variáveis do jogo
        game.restartGame();

        // Remove o botão "New Game" do JPanel
        panel.remove(newGameButton);
        panel.revalidate();
        panel.repaint();
        new Thread(game).start();
      }
    });

    panel.add(newGameButton); // Adiciona o botão ao JPanel
  }
}
