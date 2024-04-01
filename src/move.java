import java.awt.event.KeyEvent;

public class move {
  public static Node[] SnakeMove(Node[] nodeSnake, int newDirection, int DISTANCE) {
    for (int i = nodeSnake.length - 1; i > 0; i--) {
      nodeSnake[i].x = nodeSnake[i - 1].x;
      nodeSnake[i].y = nodeSnake[i - 1].y;
    }

    switch (newDirection) {
      case KeyEvent.VK_RIGHT:
        nodeSnake[0].x += DISTANCE;

        break;
      case KeyEvent.VK_LEFT:
        nodeSnake[0].x -= DISTANCE;
        break;
      case KeyEvent.VK_UP:
        nodeSnake[0].y -= DISTANCE;
        break;
      case KeyEvent.VK_DOWN:
        nodeSnake[0].y += DISTANCE;
        break;
    }

    return nodeSnake;
  }

}
