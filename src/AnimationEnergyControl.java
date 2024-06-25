import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AnimationEnergyControl {

  void updateEnergyAnimation(Game game, BufferedImage buffer, Image explosionDeath) {

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
      if (ControlTimerVelocity >= 10000) {
        game.VelocityControl = false;
        game.ControlTimerVelocity = System.currentTimeMillis();
      }
    } else {
      game.ControlTimerVelocity = System.currentTimeMillis();
    }
    if (TeleportEnergy >= 4800 && !game.ernegyAnimationPlayed) {
      AnimationEnergyFim.AnimationFoodErnFim();
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
          AnimationEnergy.AnimationFoodErnInic(this);
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
          Game.posicaoXEnergy = Game.PosColidianEnergyX;
          Game.posicaoYEnergy = Game.PosColidianEnergyY;
          Game.NovaPosicaoEnergy0 = Game.posicaoYEnergy - 40;
          Game.widhtEnergyW = 0;
          Game.widhtEnergyH = 0;
          Game.TransparentEnergy = 0.1f;
          NumberAnimation.restartAnimationEnergy(game);
          Game.colidianEnergy = true;
        }

      }
    }
    if (Game.ControlEnergyColidianBoolean) {
      if (ControlEnergyColidion <= 1500) {
        if (!Game.snakeFire) {
          Game.ControlVelocityFinal = 2000;
        } else {
          Game.ControlVelocityFinal = 10000;
        }

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
            AnimationEnergy.AnimationFoodErnInic(this);
          }
        }
      }
    }

    if (Game.ControlAPOSColidionTimer) {

      if (ControlEnergySpreet > 1000 && ControlEnergySpreet < 10000) {
        if (Game.snakeClassica || Game.snakePoison) {
          Game.SpreetSheetInitial = true;
          Game.SpreetSheetFinale = false;
        }

        game.VelocityControl = true;

        if (Game.snakeFire) {
          if (ControlEnergySpreet >= 1000 && ControlEnergySpreet <= 1050) {
            Game.checkedEsplo = true;
            Game.ControlOneAnimationESPLO = false;

          }
          if (ControlEnergySpreet >= 1500) {
            Game.colisianEnergySumir = true;
          }
          if (ControlEnergySpreet >= 2200) {
            Game.colisianEnergyMorrer = true;
          }
        }
      } else if (ControlEnergySpreet >= 10000 && ControlEnergySpreet <= 10700) {
        if (Game.snakeClassica || Game.snakePoison) {
          Game.SpreetSheetInitial = false;
          Game.SpreetSheetFinale = true;

        } else if (ControlEnergySpreet > 10700) {
          Game.SpreetSheetFinale = false;
        } else if (ControlEnergySpreet >= 11000) {
          game.ControlSpriteSheet = System.currentTimeMillis();
        }
      }
    }
    if (Game.snakeFire) {
      if (Game.checkedEsplo) {
        if (!Game.ControlOneAnimationESPLO) {
          AnimationEnergyControl.animationDeathExplosion(buffer, explosionDeath);
        }
      }
    }
    /////
    if (Game.ColisionEnergy) {
      if (ControlAPOS <= 10000) {
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

      if (TeleportEnergy >= 6000) {
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

  private static long lastFrameTimees = System.currentTimeMillis();
  private static int frameIntervales = 100;
  static int numFramesXes = 8; // Ajuste conforme necessário
  static int numFramesYes = 1; // Supondo que todas as animações estão na mesma linha
  static int totalFrameses = numFramesXes * numFramesYes;

  public static void animationDeathExplosion(BufferedImage buffer, Image explosionDeath) {
    BufferedImage EnergyAnimationColision = (BufferedImage) explosionDeath;
    Graphics2D Explosao = buffer.createGraphics();
    int numFramesX = 8; // Ajuste conforme necessário
    int numFramesY = 1; // Supondo que todas as animações estão na mesma linha
    int frameWidth = 500; // Largura do frame redimensionado
    int frameHeight = 500; // Altura do frame redimensionado
    int totalFrameses = numFramesX * numFramesY;
    long currentTimees = System.currentTimeMillis();

    int sx = (Game.currentFrame27 % numFramesX) * (EnergyAnimationColision.getWidth() / numFramesX);
    int sy = (Game.currentFrame27 / numFramesX) * (EnergyAnimationColision.getWidth() / numFramesX);
    int sw = EnergyAnimationColision.getWidth() / numFramesX;
    int sh = EnergyAnimationColision.getHeight() / numFramesY;
    BufferedImage resizedImageColision = Animation.resizeImage(
        EnergyAnimationColision.getSubimage(sx, sy, sw, sh),
        frameWidth,
        frameHeight);
    for (int i = 0; i < Game.nodeSnake.length; i += 10) {
      Explosao.drawImage(resizedImageColision, Game.nodeSnake[i].x - 15, Game.nodeSnake[i].y - 13, 40, 40, null);
    }

    if (currentTimees - lastFrameTimees > frameIntervales) {
      Game.currentFrame27 = (Game.currentFrame27 + 1) % totalFrameses;
      lastFrameTimees = currentTimees;
      if (Game.currentFrame27 == totalFrameses - 1) {
        Game.ControlOneAnimationESPLO = true;
        lastFrameTimees = System.currentTimeMillis();
      }
    }
  }
}
