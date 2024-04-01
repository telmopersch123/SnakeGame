import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RadialGradientPaint;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class snake {
  public static void snakePaint(Node[] nodeSnake, BufferedImage buffer, int WIDTH, int HEIGHT, Image bodyStraight,
      Image bodyCorner, Image tailImage, Image snakeHead,
      MyKeyBoardListener keyListener) {
    Graphics2D snakeBody = buffer.createGraphics();
    for (int z = 1; z < nodeSnake.length; z++) {

      int currX = nodeSnake[z].x;
      int currY = nodeSnake[z].y;
      int prevX = z > 0 ? nodeSnake[z - 1].x : currX;
      int prevY = z > 0 ? nodeSnake[z - 1].y : currY;
      int nextX = z < nodeSnake.length - 1 ? nodeSnake[z + 1].x : currX;
      int nextY = z < nodeSnake.length - 1 ? nodeSnake[z + 1].y : currY;
      boolean isCorner = (prevX != nextX) && (prevY != nextY);
      boolean isHorizontal = currY == prevY;
      int shadowSize = 10;
      Color shadowColor = new Color(0, 0, 0, 20); // Cor padrão da sombra
      if (isHorizontal) {
        // Se a cobra estiver na horizontal, ajuste a cor da sombra para ser mais suave
        shadowColor = new Color(0, 0, 0, 20); // Ou qualquer outro valor que você preferir
      }
      if (isCorner) {
        shadowColor = new Color(0, 0, 0, 5);
      }
      int centerX = nodeSnake[z].x + 12 / 2;
      int centerY = nodeSnake[z].y + 12 / 2 - 10;
      RadialGradientPaint gradientPaint = new RadialGradientPaint(
          centerX, centerY + shadowSize, shadowSize, // Posição e tamanho do gradiente
          new float[] { 0.0f, 1.0f }, // Frações de cores
          new Color[] { shadowColor, new Color(0, 0, 0, 0) } // Cores da sombra (começa opaca e termina
                                                             // transparente)
      );
      snakeBody.setPaint(gradientPaint);
      snakeBody.fillRect(currX - shadowSize / 2, currY - shadowSize / 2, WIDTH + shadowSize, HEIGHT + shadowSize);
    }
    // Desenha o corpo da cobra
    int angle = 0;
    // Desenhar a cobra

    for (int z = 1; z < nodeSnake.length; z++) {
      // transparente)
      int currX = nodeSnake[z].x;
      int currY = nodeSnake[z].y;
      int prevY = z > 0 ? nodeSnake[z - 1].y : currY;

      boolean isHorizontal = currY == prevY;
      if (isHorizontal) {
        // Rotaciona a imagem em 90 graus;
        AffineTransform rotation = AffineTransform.getQuadrantRotateInstance(1, currX + 14 / 2, currY + 14 / 2);
        Graphics2D rotated = (Graphics2D) snakeBody.create();
        rotated.transform(rotation);
        rotated.drawImage(bodyStraight, currX, currY, WIDTH + 4, HEIGHT + 4, null);
        rotated.dispose();
      } else {
        // Aplica uma transformação semelhante para movimentos verticais
        AffineTransform rotation = AffineTransform.getQuadrantRotateInstance(0, currX + 14 / 2, currY + 14 / 2);
        Graphics2D rotated = (Graphics2D) snakeBody.create();
        rotated.transform(rotation);
        rotated.drawImage(bodyStraight, currX, currY, WIDTH + 4, HEIGHT + 4, null);
        rotated.dispose();
      }

    }
    for (int z = 0; z < nodeSnake.length; z++) {
      Graphics2D Corner = buffer.createGraphics();
      int currX = nodeSnake[z].x;
      int currY = nodeSnake[z].y;
      int prevX = z > 0 ? nodeSnake[z - 1].x : currX;
      int prevY = z > 0 ? nodeSnake[z - 1].y : currY;
      int nextX = z < nodeSnake.length - 1 ? nodeSnake[z + 1].x : currX;
      int nextY = z < nodeSnake.length - 1 ? nodeSnake[z + 1].y : currY;
      boolean isCorner = (prevX != nextX) && (prevY != nextY);
      boolean horizontal = prevX != nextX;
      boolean vertical = prevY != nextY;
      boolean rightTurn = (prevX < currX && nextY > currY) || (prevY > currY && nextX < currX);
      boolean leftTurn = (prevX > currX && nextY < currY) || (prevY < currY && nextX > currX);
      if (isCorner) {
        if (vertical && rightTurn) {
          angle = 90;
        } else if (vertical && leftTurn) {
          angle = -90;
        } else if (horizontal && rightTurn) {
          angle = 0;
        } else if (horizontal && leftTurn) {
          angle = 180;
        } else if (horizontal && nextY < currY) {
          angle = 180;
        } else if (horizontal && nextY > currY) {
          angle = 0;
        } else if (vertical && nextX < currX) {
          angle = 180;
        } else if (vertical && nextX > currX) {
          angle = 0;
        }

        Corner.rotate(Math.toRadians(angle), nodeSnake[z].x + 15 / 2, nodeSnake[z].y + 15 / 2);
        Corner.drawImage(bodyCorner, currX, currY, WIDTH + 6, HEIGHT + 6, null);
        Corner.dispose();
      }
    }
    // DESENHAR O RABO
    for (int z = 0; z < nodeSnake.length; z++) {
      int currX = nodeSnake[z].x;
      int currY = nodeSnake[z].y;
      int prevX = z > 0 ? nodeSnake[z - 1].x : currX;
      int prevY = z > 0 ? nodeSnake[z - 1].y : currY;
      int nextX = z < nodeSnake.length - 1 ? nodeSnake[z + 1].x : currX;
      int nextY = z < nodeSnake.length - 1 ? nodeSnake[z + 1].y : currY;
      boolean horizontal = prevX != nextX;
      boolean vertical = prevY != nextY;
      Graphics2D tail = (Graphics2D) buffer.createGraphics();
      int width = 14;

      if (z == nodeSnake.length - 1) {
        if (horizontal && prevX < currX) {
          // direita
          tail.rotate(Math.toRadians(180), nodeSnake[z].x + width / 2, nodeSnake[z].y + width / 2);
        } else if (horizontal && prevX > currX) {
          // esquerda
          tail.rotate(Math.toRadians(0), nodeSnake[z].x + width / 2, nodeSnake[z].y + width / 2);
        } else if (vertical && prevY < currY) {
          // baixo
          tail.rotate(Math.toRadians(-90), nodeSnake[z].x + width / 2, nodeSnake[z].y + width / 2);
        } else if (vertical && prevY > currY) {
          // cima
          tail.rotate(Math.toRadians(90), nodeSnake[z].x + width / 2, nodeSnake[z].y + width / 2);
        }
        tail.drawImage(tailImage, nodeSnake[z].x - 3, nodeSnake[z].y, 14, 14, null);
        tail.dispose();
      }
    }
    // DESENHE A CABEÇA
    Graphics2D head = buffer.createGraphics();
    // Ajusta a posição da cabeça com base na direção
    if (keyListener.getDirection() == KeyEvent.VK_LEFT) {
      angle = 180;
    } else if (keyListener.getDirection() == KeyEvent.VK_RIGHT) {
      angle = 0;
    } else if (keyListener.getDirection() == KeyEvent.VK_UP) {
      angle = -90;
    } else if (keyListener.getDirection() == KeyEvent.VK_DOWN) {
      angle = 90;
    }
    int imageWidth = (int) (12 * 1.7); // Reduz a largura da imagem
    int imageHeight = (int) (12 * 1.5); // Reduz a altura da imagem
    int centerX = nodeSnake[0].x + 15 / 2;
    int centerY = nodeSnake[0].y + 15 / 2;

    // Ajusta a posição da cabeça para o centro do corpo da cobra
    int xPos = centerX - imageWidth / 2;
    int yPos = centerY - imageHeight / 2;
    // Rotação da cabeça
    head.rotate(Math.toRadians(angle), xPos + imageWidth / 2, yPos + imageHeight / 2); // Rotação em torno do centro da
    head.drawImage(snakeHead, xPos + 3, yPos, imageWidth, imageHeight, null); // Desenha a cabeça da cobra
  }
}
