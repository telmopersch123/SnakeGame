import java.awt.Rectangle;
import java.util.ArrayList;

public class checkedColisson {
  public static boolean[] CheckedColisson(boolean gameOver, int WIDTH, int HEIGHT, int FrameWidth, int FrameHeight,
      ArrayList<Integer> walls_x, ArrayList<Integer> walls_y, Node[] nodeSnake, int largerCollisionArea,
      Rectangle headCollisionArea, boolean poisonDeathAnimationPlaying) {

    // colisão com o painel
    if (nodeSnake[0].x >= -10 && nodeSnake[0].x <= -3 || nodeSnake[0].x >= 590 && nodeSnake[0].x <= 600 ||
        nodeSnake[0].y >= -10 && nodeSnake[0].y <= -3 || nodeSnake[0].y >= 590 && nodeSnake[0].y <= 600) {
      gameOver = true;
      poisonDeathAnimationPlaying = false;
    }
    // colisão com a cobra
    for (int i = 1; i < nodeSnake.length; i++) {
      if (nodeSnake[0].x == nodeSnake[i].x && nodeSnake[0].y == nodeSnake[i].y) {
        gameOver = true;
        poisonDeathAnimationPlaying = false;
        break;
      }
    }
    largerCollisionArea = 5;
    headCollisionArea = new Rectangle(nodeSnake[0].x - largerCollisionArea / 2,
        nodeSnake[0].y - largerCollisionArea / 2,
        5 + largerCollisionArea, 5 + largerCollisionArea);

    // colisão com as paredes
    for (int i = 0; i < walls_x.size(); i++) {
      Rectangle wallArea = new Rectangle(walls_x.get(i), walls_y.get(i), 15, 15);
      if (headCollisionArea.intersects(wallArea)) {
        poisonDeathAnimationPlaying = false;
        // A cabeça da cobra colidiu com uma parede
        // Isso geralmente significa que o jogo acabou
        gameOver = true;
      }
    }

    return new boolean[] { gameOver, poisonDeathAnimationPlaying };
  }
}
