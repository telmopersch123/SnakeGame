import java.awt.Rectangle;
import java.util.ArrayList;

public class CollisionUtils {
  public static boolean ThisNearBorder(int x, int y, int FrameWidth, int FrameHeight, int WIDTH, int HEIGHT) {
    return x < 50 || x > FrameWidth - 50 || y < 50 || y > FrameHeight - 50;
  }

  public static boolean ThisNearWalls(int x, int y, ArrayList<Integer> walls_x, ArrayList<Integer> walls_y, int WIDTH,
      int HEIGHT) {
    for (int i = 0; i < walls_x.size(); i++) {
      double distance = Math.sqrt(Math.pow(x - walls_x.get(i), 2) + Math.pow(y - walls_y.get(i), 2));
      if (distance < 50) {
        return true;
      }
    }
    return false;
  }

  public static boolean ThisDecoration(int x, int y, int[] DecoracaoX, int[] DecoracaoY, int WIDTH, int HEIGHT) {
    for (int i = 0; i < DecoracaoX.length; i++) {
      Rectangle imageRect = new Rectangle(DecoracaoX[i], DecoracaoY[i], 70, 70);
      Rectangle snakeRect = new Rectangle(x, y, WIDTH, HEIGHT);
      if (imageRect.intersects(snakeRect) || distance(x, y, DecoracaoX[i], DecoracaoY[i]) < 200) {
        return true;
      }
    }
    return false;
  }

  private static int distance(int x1, int y1, int x2, int y2) {
    return (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
  }
}
