import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

public class NumberAnimation {

  private static int NumberInterval = 50;
  private static Timer DeathElevacao;
  private static int DeathInterval = 50;
  private static Timer EnergyElevacao;
  private static int EnergyInterval = 50;

  public static void NumberAnimationMais(BufferedImage buffer, Image NumberMais1, int posicaoX,
      int posicaoY, int widhtNumberW, int widhtNumberH, float TransparentNumber) {
    Graphics2D NumberMais = buffer.createGraphics();
    float transparency = TransparentNumber;
    AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
        transparency);
    NumberMais.setComposite(ac);
    NumberMais.drawImage(NumberMais1, posicaoX, posicaoY, widhtNumberW, widhtNumberH, null);
    NumberMais.dispose();
  }

  public static void restartAnimation(Game game) {
    if (Game.NumberElevacao != null) {
      Game.NumberElevacao.cancel();
      Game.NumberElevacao.purge();
    }
    Game.possibilitiNumberFinal = false;
    Game.colidianClassico = false;
    AnimationNumberInitial(game);
  }

  public static void AnimationNumberInitial(Game game) {
    if (Game.NumberElevacao != null) {
      Game.NumberElevacao.cancel();
      Game.NumberElevacao.purge();
    }
    Game.NumberElevacao = new Timer();
    Game.NumberElevacao.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        if (Game.posicaoYNumber >= Game.NovaPosicao0) {
          Game.posicaoYNumber--;
          if (Game.widhtNumberW <= 20) {
            Game.widhtNumberW++;
            Game.widhtNumberH++;
          }
          if (Game.TransparentNumber <= 0.90f) {
            Game.TransparentNumber += 0.1f;
          }
        } else {
          Game.NovaPosicao0 = Game.posicaoYNumber - 40;
          Game.possibilitiNumberFinal = true;
          AnimationNumberFinal(game);
        }

        game.repaint();
      }
    }, 0, NumberInterval);
  }

  public static void AnimationNumberFinal(Game game) {
    if (Game.NumberElevacao != null) {
      Game.NumberElevacao.cancel();
      Game.NumberElevacao.purge();
    }
    Game.NumberElevacao = new Timer();
    Game.NumberElevacao.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        if (Game.posicaoYNumber >= Game.NovaPosicao0) {
          Game.posicaoYNumber--;
          if (Game.TransparentNumber >= 0.1f) {
            Game.TransparentNumber -= 0.1f;
          }
        } else {
          Game.possibilitiNumberFinal = false;
          Game.colidianClassico = false;

        }

        game.repaint();
      }
    }, 0, NumberInterval);
  }

  /////////

  public static void NumberAnimationDeath(BufferedImage buffer, Image DeathIcon, int posicaoX,
      int posicaoY, int widhtDeathW, int widhtDeathH, float TransparentDeath) {
    Graphics2D NumberMais = buffer.createGraphics();
    float transparency = TransparentDeath;
    AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
        transparency);
    NumberMais.setComposite(ac);
    NumberMais.drawImage(DeathIcon, posicaoX, posicaoY + 30, widhtDeathW, widhtDeathH, null);
    NumberMais.dispose();
  }

  public static void restartAnimationDeath(Game game) {
    if (Game.DeathElevacao != null) {
      Game.DeathElevacao.cancel();
      Game.DeathElevacao.purge();
    }
    Game.possibilitiDeathFinal = false;
    Game.colidianDeath = false;
    AnimationDeathInitial(game);
  }

  public static void AnimationDeathInitial(Game game) {
    if (DeathElevacao != null) {
      DeathElevacao.cancel();
      DeathElevacao.purge();
    }
    DeathElevacao = new Timer();
    DeathElevacao.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        if (Game.posicaoYDeath >= Game.NovaPosicaoDeath0) {
          Game.posicaoYDeath--;
          if (Game.widhtDeathW <= 25) {
            Game.widhtDeathW++;
            Game.widhtDeathH++;
          }
          if (Game.TransparentDeath <= 0.90f) {
            Game.TransparentDeath += 0.1f;
          }
        } else {
          Game.NovaPosicaoDeath0 = Game.posicaoYDeath - 40;
          Game.possibilitiDeathFinal = true;
        }

        game.repaint();
      }
    }, 0, DeathInterval);
  }

  public static void AnimationDeathFinal(Game game) {
    if (DeathElevacao != null) {
      DeathElevacao.cancel();
      DeathElevacao.purge();
    }
    DeathElevacao = new Timer();
    DeathElevacao.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        if (Game.posicaoYDeath >= Game.NovaPosicaoDeath0) {
          Game.posicaoYDeath--;
          if (Game.TransparentDeath >= 0.1f) {
            Game.TransparentDeath -= 0.1f;
          }
        } else {
          Game.possibilitiDeathFinal = false;
          Game.colidianDeath = false;
        }

        game.repaint();
      }
    }, 0, DeathInterval);
  }

  /////////
  public static void NumberAnimationEnergy(BufferedImage buffer, Image DeathIcon, int posicaoX,
      int posicaoY, int widhtDeathW, int widhtDeathH, float TransparentDeath) {
    Graphics2D NumberMais = buffer.createGraphics();
    float transparency = TransparentDeath;
    AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
        transparency);
    NumberMais.setComposite(ac);
    NumberMais.drawImage(DeathIcon, posicaoX, posicaoY + 30, widhtDeathW, widhtDeathH, null);
    NumberMais.dispose();
  }

  public static void restartAnimationEnergy(Game game) {
    if (Game.EnergyElevacao != null) {
      Game.EnergyElevacao.cancel();
      Game.EnergyElevacao.purge();
    }
    Game.possibilitiEnergyFinal = false;
    Game.colidianEnergy = false;
    AnimationEnergyInitial(game);
  }

  public static void AnimationEnergyInitial(Game game) {
    if (EnergyElevacao != null) {
      EnergyElevacao.cancel();
      EnergyElevacao.purge();
    }
    EnergyElevacao = new Timer();
    EnergyElevacao.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        if (Game.posicaoYEnergy >= Game.NovaPosicaoEnergy0) {
          Game.posicaoYEnergy--;
          if (Game.widhtEnergyW <= 25) {
            Game.widhtEnergyW++;
            Game.widhtEnergyH++;
          }
          if (Game.TransparentEnergy <= 0.90f) {
            Game.TransparentEnergy += 0.1f;
          }
        } else {
          Game.NovaPosicaoEnergy0 = Game.posicaoYEnergy - 40;
          Game.possibilitiEnergyFinal = true;
        }

        game.repaint();
      }
    }, 0, EnergyInterval);
  }

  public static void AnimationEnergyFinal(Game game) {
    if (EnergyElevacao != null) {
      EnergyElevacao.cancel();
      EnergyElevacao.purge();
    }
    EnergyElevacao = new Timer();
    EnergyElevacao.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        if (Game.posicaoYEnergy >= Game.NovaPosicaoEnergy0) {
          Game.posicaoYEnergy--;
          if (Game.TransparentEnergy >= 0.1f) {
            Game.TransparentEnergy -= 0.1f;
          }
        } else {
          Game.possibilitiEnergyFinal = false;
          Game.colidianEnergy = false;
        }

        game.repaint();
      }
    }, 0, EnergyInterval);
  }
}
