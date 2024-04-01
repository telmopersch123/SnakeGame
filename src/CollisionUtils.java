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
}
