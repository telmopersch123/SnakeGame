import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class AnimationSnakeDeath {
  private static Timer removeSegmentTimer;

  private final static int REMOVE_SEGMENT_INTERVAL = 20;

  public static void AnimationSnake(Game game, ArrayList<Point> foodPositions) {

    if (foodPositions.size() >= 2) {
      if (Game.snakeClassica || Game.snakeFire) {
        Point foodPosition1 = foodPositions.get(1);
        game.macaPOX = foodPosition1.x;
        game.macaPOY = foodPosition1.y;
      } else {
        Point foodPosition0 = foodPositions.get(0);
        game.macaX = foodPosition0.x;
        game.macaY = foodPosition0.y;
      }
    }

    game.segmentsToRemove = game.nodeSnake.length / 2;
    Game.ControlVelocity += game.nodeSnake.length / 2;
    // Inicialize o timer para remover os segmentos gradativamente

    removeSegmentTimer = new Timer();
    removeSegmentTimer.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        if (game.gameOver) {
          removeSegmentTimer.cancel();
          removeSegmentTimer.purge();
          return;
        }
        if (game.segmentsToRemove > 0) {
          // Remova um segmento da cobra
          game.nodeSnake = Arrays.copyOf(game.nodeSnake, game.nodeSnake.length - 1);
          game.segmentsToRemove--;

          // Redesenha a tela
          // repaint();
        } else {
          // Cancela o timer quando todos os segmentos forem removidos
          removeSegmentTimer.cancel();
          removeSegmentTimer.purge();

          // Não há mais segmentos para remover, então atualize a posição da fruta
          // venenosa apenas uma vez

        }
      }
    }, 0, REMOVE_SEGMENT_INTERVAL);
  }
}
