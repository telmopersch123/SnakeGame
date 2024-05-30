import java.awt.Rectangle;
import java.util.ArrayList;

public class checkedColisson {
  public static ResultadoColisao verificarColisao(boolean gameOver, int WIDTH, int HEIGHT, int FrameWidth,
      int FrameHeight,
      ArrayList<Integer> walls_x, ArrayList<Integer> walls_y, Node[] nodeSnake,
      int largerCollisionArea, Rectangle headCollisionArea, boolean poisonDeathAnimationPlaying,
      int borderWidth, int getWidth, int getHeight) {

    if (nodeSnake.length < 30) {
      return new ResultadoColisao(true, true);
    }

    if (colisaoPainel(nodeSnake, borderWidth, getWidth, getHeight)) {
      return new ResultadoColisao(true, false);
    }

    if (colisaoCobra(nodeSnake)) {
      return new ResultadoColisao(true, false);
    }

    if (colisaoParede(nodeSnake, walls_x, walls_y, largerCollisionArea)) {
      return new ResultadoColisao(true, false);
    }

    return new ResultadoColisao(gameOver, poisonDeathAnimationPlaying);
  }

  private static boolean colisaoPainel(Node[] nodeSnake, int borderWidth, int getWidth, int getHeight) {
    return (nodeSnake[0].y <= borderWidth || nodeSnake[0].y >= getHeight - 30 ||
        nodeSnake[0].x <= borderWidth || nodeSnake[0].x >= getWidth - 30);
  }

  private static boolean colisaoCobra(Node[] nodeSnake) {
    for (int i = 1; i < nodeSnake.length; i++) {
      if (nodeSnake[0].x == nodeSnake[i].x && nodeSnake[0].y == nodeSnake[i].y) {
        return true;
      }
    }
    return false;
  }

  private static boolean colisaoParede(Node[] nodeSnake, ArrayList<Integer> walls_x, ArrayList<Integer> walls_y,
      int largerCollisionArea) {
    Rectangle headCollisionArea = new Rectangle(nodeSnake[0].x - largerCollisionArea / 2,
        nodeSnake[0].y - largerCollisionArea / 2,
        5 + largerCollisionArea, 5 + largerCollisionArea);

    for (int i = 0; i < walls_x.size(); i++) {
      Rectangle wallArea = new Rectangle(walls_x.get(i), walls_y.get(i), 15, 15);
      if (headCollisionArea.intersects(wallArea)) {
        return true;
      }
    }
    return false;
  }
}
