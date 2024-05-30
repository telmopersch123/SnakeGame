import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

public class AnimationEnergyControl {

  void updateEnergyAnimation(Game game) {

    ArrayList<Point> foodPositions = LocaleUtils.LocateFood(game.FrameWidth,
        game.FrameHeight,
        game.WIDTH,
        game.HEIGHT,
        game.walls_x,
        game.walls_y,
        game.nodeSnake);
    Rectangle headCollisionAreaEN = new Rectangle(game.nodeSnake[0].x - 12 / 2,
        game.nodeSnake[0].y - 30 / 2,
        15, 15);
    Rectangle fruitEnergyArea = new Rectangle(game.macaENX, game.macaENY, 18, 15);
    Point foodPosition2 = foodPositions.get(2);

    long elapsedTimeEnergy = System.currentTimeMillis() - game.lastVenomAnimationTimeEnergy;
    long TeleportEnergy = System.currentTimeMillis() - game.TeleportEnergyVerif;
    long ControlTimerVelocity = System.currentTimeMillis() - game.ControlTimerVelocity;
    long ControlAPOS = System.currentTimeMillis() - game.ControlAPOSSuporte;
    long ControlEnergySpreet = System.currentTimeMillis() - game.ControlSpriteSheet;
    long ControlEnergyColidion = System.currentTimeMillis() - game.ControlSpriteSheetColidion;
    if (game.VelocityControl) {
      if (ControlTimerVelocity >= 5000) {
        game.VelocityControl = false;
        game.ControlTimerVelocity = System.currentTimeMillis();
      }
    } else {
      game.ControlTimerVelocity = System.currentTimeMillis();
    }
    if (TeleportEnergy >= 1800 && !game.ernegyAnimationPlayed) {
      // AnimationEnergyFim.AnimationFoodErnFim();
      game.ernegyAnimationPlayed = true;
    }
    if (game.ColidionEnergyCla) {

      if (elapsedTimeEnergy >= 2000) {
        game.Segunds = true;
      }
      if (game.Segunds) {
        game.macaENX = foodPosition2.x;
        game.macaENY = foodPosition2.y;
        if (!Game.colidionEneControlTimerAnimation) {
          // AnimationEnergy.AnimationFoodErnInic(this);
        }
        game.ColidionEnergyCla = false;
        game.ColidionEnergyConfirmed = true;
        game.ControlTeleport = true;
        game.ControlColisionEnergy = true;
      }
    } else {
      game.lastVenomAnimationTimeEnergy = System.currentTimeMillis();
    }
    if (!Game.colisionControlEnergy) {
      if (game.ControlColisionEnergy) {
        if (headCollisionAreaEN.intersects(fruitEnergyArea)) {
          Game.PosColidianEnergyX = game.macaENX;
          Game.PosColidianEnergyY = game.macaENY;
          Game.ControlEnergyColidianBoolean = true;
        }

      }
    }
    if (Game.ControlEnergyColidianBoolean) {
      if (ControlEnergyColidion <= 1500) {

        Game.ControlVelocity = 2000;
        Game.currentFrame4 = 0;
      }
      if (ControlEnergyColidion <= 2500) {
        Game.ControlEnergyColidianBoolean = true;
        Game.VerifiEnergyAnimation = true;
      } else if (ControlEnergyColidion > 2500) {

        Game.ControlEnergyColidianBoolean = false;
      }
    } else {
      Game.ControlOneAnimation = false;
      game.ControlSpriteSheetColidion = System.currentTimeMillis();
      Game.VerifiEnergyAnimation = false;
    }

    if (!Game.colisionControlEnergy) {
      if (game.ControlColisionEnergy) {
        if (headCollisionAreaEN.intersects(fruitEnergyArea)) {
          game.ernegyAnimationPlayed = true;

          Game.ColisionEnergy = true;
          Game.ControlAPOSColidionTimer = true;
          game.macaENX = -100;
          game.macaENY = -100;

          game.TeleportEnergyVerif = System.currentTimeMillis();
          if (!Game.colidionEneControlTimerAnimation) {
            // AnimationEnergy.AnimationFoodErnInic(this);
          }
        }
      }
    }

    if (Game.ControlAPOSColidionTimer) {
      if (ControlEnergySpreet > 1000 && ControlEnergySpreet < 5000) {
        Game.SpreetSheetInitial = true;
        game.VelocityControl = true;
        Game.SpreetSheetFinale = false;
      } else if (ControlEnergySpreet >= 5000 && ControlEnergySpreet <= 5700) {
        Game.SpreetSheetInitial = false;
        Game.SpreetSheetFinale = true;
      } else if (ControlEnergySpreet > 5700) {
        Game.SpreetSheetFinale = false;
      } else if (ControlEnergySpreet >= 6000) {
        game.ControlSpriteSheet = System.currentTimeMillis();
      }
    }

    if (Game.ColisionEnergy) {
      if (ControlAPOS <= 6000) {
        Game.ControlAPOSColidionTimer = true;
      } else {
        Game.ControlAPOSColidionTimer = false;
        if (!Game.ControlAPOSColidionTimer) {
          game.macaENX = foodPosition2.x;
          game.macaENY = foodPosition2.y;
        }
        Game.ColisionEnergy = false;
        game.ControlSpriteSheet = System.currentTimeMillis();
      }
    } else {
      Game.ControlAPOSColidionTimer = false;
      game.ControlAPOSSuporte = System.currentTimeMillis();
      game.ControlSpriteSheet = System.currentTimeMillis();
    }

    if (game.ControlTeleport) {
      if (TeleportEnergy >= 0 && TeleportEnergy <= 20) {
        game.ernegyAnimationPlayed = false;
      }

      if (TeleportEnergy >= 2000) {
        if (!Game.colidionEneControlTimerAnimation) {
          AnimationEnergy.AnimationFoodErnInic(this);
        }
        if (!Game.ControlAPOSColidionTimer) {
          game.macaENX = foodPosition2.x;
          game.macaENY = foodPosition2.y;
        }

        game.TeleportEnergyVerif = System.currentTimeMillis();

      }

    } else {
      game.TeleportEnergyVerif = System.currentTimeMillis();
    }

  }
}
