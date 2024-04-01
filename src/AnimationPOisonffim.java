import java.util.Timer;
import java.util.TimerTask;

public class AnimationPOisonffim {
  private static Timer poisonFruitAnimationTimer;
  private static int poisonFruitAnimationInterval1 = 3;

  public static void AnimationFoodVenFim() {
    Game.poisonFruitAnimationRunning = true;
    poisonFruitAnimationTimer = new Timer();
    poisonFruitAnimationTimer.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        if (Game.poisonFruitWidthVen > 0 || Game.poisonFruitHeightVen > 0) {
          Game.poisonFruitWidthVen -= 1;
          Game.poisonFruitHeightVen -= 2;
          Game.colisionControlPoison = true;

        } else {
          poisonFruitAnimationTimer.cancel();
          poisonFruitAnimationTimer.purge();
        }

        // animationControlPoison.repaint();
      }
    }, 0, poisonFruitAnimationInterval1);
  }
}
