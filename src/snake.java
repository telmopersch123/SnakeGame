import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RadialGradientPaint;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class snake {
  public static int angle = 0;
  public static Graphics2D snakeBody;
  public static Graphics2D rotated;
  public static Graphics2D rotated2;
  public static Graphics2D Corner;
  public static Graphics2D tail;
  public static Graphics2D head;
  public static int currX;
  public static int currY;
  public static int prevX;
  public static int prevY;
  public static int nextX;
  public static int nextY;
  public static boolean isCorner;
  public static boolean isHorizontal;
  public static int shadowSize;
  public static Color shadowColor;
  public static int centerX;
  public static int centerY;
  public static RadialGradientPaint gradientPaint;
  ////////////////////////////
  public static boolean isHorizontal1;
  public static AffineTransform rotation;
  public static AffineTransform rotationfire;
  ////////////////////////////
  public static boolean horizontal;
  public static boolean vertical;
  public static boolean rightTurn;
  public static boolean leftTurn;
  public static int width = 14;
  ///////////////////////////
  public static int imageWidth;
  public static int imageHeight;
  public static int centerX2;
  public static int centerY2;
  public static int xPos;
  public static int yPos;

  public static void snakePaint(Node[] nodeSnake, BufferedImage buffer, int WIDTH, int HEIGHT, Image bodyStraight,
      Image bodyCorner, Image tailImage, Image snakeHead,
      MyKeyBoardListener keyListener, Image fogoComplementar, Image fogoFinal) {

    snakeBody = buffer.createGraphics();
    Graphics2D g2d = buffer.createGraphics();
    angle = 0;

    // Desenhar O CORPO
    for (int z = 1; z < nodeSnake.length; z++) {
      // transparente)
      currX = nodeSnake[z].x;
      currY = nodeSnake[z].y;
      prevY = z > 0 ? nodeSnake[z - 1].y : currY;
      isHorizontal1 = currY == prevY;
      if (isHorizontal1) {
        // Rotaciona a imagem em 90 graus;
        rotation = AffineTransform.getQuadrantRotateInstance(1, currX + 14 / 2, currY + 14 / 2);
        rotated = (Graphics2D) snakeBody.create();
        rotated.transform(rotation);
        rotated.drawImage(bodyStraight, currX, currY, WIDTH + 4, HEIGHT + 4, null);

        rotated.dispose();
      } else {
        // Aplica uma transformação semelhante para movimentos verticais

        rotation = AffineTransform.getQuadrantRotateInstance(0, currX + 14 / 2, currY + 14 / 2);
        rotated = (Graphics2D) snakeBody.create();
        rotated.transform(rotation);
        rotated.drawImage(bodyStraight, currX, currY, WIDTH + 4, HEIGHT + 4, null);

        rotated.dispose();
      }
    }

    // Desenhar a CURVATURA
    for (int z = 0; z < nodeSnake.length; z++) {
      Corner = buffer.createGraphics();
      currX = nodeSnake[z].x;
      currY = nodeSnake[z].y;
      prevX = z > 0 ? nodeSnake[z - 1].x : currX;
      prevY = z > 0 ? nodeSnake[z - 1].y : currY;
      nextX = z < nodeSnake.length - 1 ? nodeSnake[z + 1].x : currX;
      nextY = z < nodeSnake.length - 1 ? nodeSnake[z + 1].y : currY;
      isCorner = (prevX != nextX) && (prevY != nextY);
      horizontal = prevX != nextX;
      vertical = prevY != nextY;
      rightTurn = (prevX < currX && nextY > currY) || (prevY > currY && nextX < currX);
      leftTurn = (prevX > currX && nextY < currY) || (prevY < currY && nextX > currX);
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
      currX = nodeSnake[z].x;
      currY = nodeSnake[z].y;
      prevX = z > 0 ? nodeSnake[z - 1].x : currX;
      prevY = z > 0 ? nodeSnake[z - 1].y : currY;
      nextX = z < nodeSnake.length - 1 ? nodeSnake[z + 1].x : currX;
      nextY = z < nodeSnake.length - 1 ? nodeSnake[z + 1].y : currY;
      horizontal = prevX != nextX;
      vertical = prevY != nextY;
      tail = (Graphics2D) buffer.createGraphics();

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
    head = buffer.createGraphics();
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
    imageWidth = (int) (12 * 1.7); // Reduz a largura da imagem
    imageHeight = (int) (12 * 1.5); // Reduz a altura da imagem
    centerX = nodeSnake[0].x + 15 / 2;
    centerY = nodeSnake[0].y + 15 / 2;

    // Ajusta a posição da cabeça para o centro do corpo da cobra
    xPos = centerX - imageWidth / 2;
    yPos = centerY - imageHeight / 2;
    // Rotação da cabeça
    head.rotate(Math.toRadians(angle), xPos + imageWidth / 2, yPos + imageHeight / 2); // Rotação em torno do centro da
    head.drawImage(snakeHead, xPos + 3, yPos, imageWidth, imageHeight, null); // Desenha a cabeça da cobra

    ///
    for (int f = 10; f < nodeSnake.length; f += 10) {
      currX = nodeSnake[f].x;
      currY = nodeSnake[f].y;
      prevY = f > 0 ? nodeSnake[f - 1].y : currY;
      isHorizontal1 = currY == prevY;
      if (isHorizontal1) {
        rotationfire = AffineTransform.getRotateInstance(Math.toRadians(180), currX + 18 / 2, currY + 27 / 2);
        rotated2 = (Graphics2D) g2d.create();
        rotated2.transform(rotationfire);
        rotated2.drawImage(fogoComplementar, currX, currY, 20, 40, null);

        rotated2.dispose();
      } else {
        rotationfire = AffineTransform.getRotateInstance(Math.toRadians(90), currX + 28 / 2, currY + 27 / 2);
        rotated2 = (Graphics2D) g2d.create();
        rotated2.transform(rotationfire);
        rotated2.drawImage(fogoComplementar, currX, currY, 20, 40, null);
        rotated2.dispose();
      }
    }
  }
}
