import java.util.Timer;
import java.util.TimerTask;

public class AnimationPOison {
  private static int poisonFruitAnimationInterval0 = 6;
  private static int poisonFruitAnimationInterval1 = 6;
  private static Timer poisonFruitAnimationTimer;
  private static Timer poisonFruitAnimationTimer2;
  private static boolean increaseSizeVen = true;

  public static void AnimationFoodVenInic(AnimationControlPoison animationControlPoison) {

    Game.poisonFruitAnimationRunning = true;
    poisonFruitAnimationTimer = new Timer();
    poisonFruitAnimationTimer.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {

        if (increaseSizeVen) {
          if (Game.poisonFruitWidthVen < 35 || Game.poisonFruitHeightVen < 60) {
            Game.poisonFruitWidthVen++;
            Game.poisonFruitHeightVen++;
            Game.colidionPoiControlTimerAnimation = true;
          } else {
            increaseSizeVen = false;
          }
        } else {
          if (Game.poisonFruitWidthVen > 25 || Game.poisonFruitHeightVen > 50) {
            Game.poisonFruitWidthVen--;
            Game.poisonFruitHeightVen--;
            Game.colidionPoiControlTimerAnimation = true;
          } else {
            Game.colidionPoiControlTimerAnimation = false;
            Game.colisionControlPoison = false;
            poisonFruitAnimationTimer.cancel();
            poisonFruitAnimationTimer.purge();
            increaseSizeVen = true;
          }
        }

      }
    }, 0, poisonFruitAnimationInterval0);
  }

  public static void AnimationFoodVenInicColision(Game game) {

    Game.poisonFruitAnimationRunning = true;
    poisonFruitAnimationTimer2 = new Timer();
    poisonFruitAnimationTimer2.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {

        if (increaseSizeVen) {
          if (Game.poisonFruitWidthVen < 35 || Game.poisonFruitHeightVen < 60) {
            Game.poisonFruitWidthVen++;
            Game.poisonFruitHeightVen++;
            Game.colidionPoiControlTimerAnimation = true;
          } else {
            increaseSizeVen = false;
          }
        } else {
          if (Game.poisonFruitWidthVen > 25 || Game.poisonFruitHeightVen > 50) {
            Game.poisonFruitWidthVen--;
            Game.poisonFruitHeightVen--;
            Game.colidionPoiControlTimerAnimation = true;
          } else {
            Game.colidionPoiControlTimerAnimation = false;
            Game.colisionControlPoison = false;
            poisonFruitAnimationTimer2.cancel();
            poisonFruitAnimationTimer2.purge();
            increaseSizeVen = true;
          }
        }

        game.repaint();

      }
    }, 0, poisonFruitAnimationInterval1);
  }
}
