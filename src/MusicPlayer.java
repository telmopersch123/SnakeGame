
import java.io.File;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import java.util.Timer;
import java.util.TimerTask;
public class MusicPlayer {

  public static void AudioClick() {
    try {
      File soundFile = new File("resources/audios/clicksound.wav");
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
      Clip clip = AudioSystem.getClip();
      clip.open(audioInputStream);
      clip.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void AudioHover() {
    try {
      File soundFile = new File("resources/audios/hoversound.wav");
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
      Clip clip = AudioSystem.getClip();
      clip.open(audioInputStream);
      clip.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void AudioGameOver() {
    try {
      File soundFile = new File("resources/audios/Jogo/gameover.wav");
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
      Clip clip = AudioSystem.getClip();
      clip.open(audioInputStream);
      clip.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void AudioGameWins() {
    try {
      File soundFile = new File("resources/audios/Jogo/musicwins.wav");
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
      Clip clip = AudioSystem.getClip();
      clip.open(audioInputStream);
      clip.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void DetailsGameWins() {
    try {
      File soundFile = new File("resources/audios/Jogo/DetailsGameWins.wav");
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
      Clip clip = AudioSystem.getClip();
      clip.open(audioInputStream);
      clip.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void notification() {
    try {
      File soundFile = new File("resources/audios/Jogo/musicaNotification.wav");
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
      Clip clip = AudioSystem.getClip();
      clip.open(audioInputStream);
      clip.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void explosao() {
    try {
      File soundFile = new File("resources/audios/Jogo/explosaodeath.wav");
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
      Clip clip = AudioSystem.getClip();
      clip.open(audioInputStream);
      clip.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void HeatFood() {
    try {
      File soundFile = new File("resources/audios/Jogo/heatfood.wav");
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
      Clip clip = AudioSystem.getClip();
      clip.open(audioInputStream);
      clip.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void colisianpoisonfood() {
    try {
      File soundFile = new File("resources/audios/Jogo/colisianpoisonfood.wav");
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
      Clip clip = AudioSystem.getClip();
      clip.open(audioInputStream);
      clip.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void Colisao() {
    try {
      File soundFile = new File("resources/audios/Jogo/deathcolisian.wav");
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
      Clip clip = AudioSystem.getClip();
      clip.open(audioInputStream);
      clip.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void deathFome() {
    try {
      File soundFile = new File("resources/audios/Jogo/deathfome.wav");
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
      Clip clip = AudioSystem.getClip();
      clip.open(audioInputStream);
      clip.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void aumentovelocity3x() {
    try {
      File soundFile = new File("resources/audios/Jogo/aumentovelocity3x.wav");
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
      Clip clip = AudioSystem.getClip();
      clip.open(audioInputStream);
      clip.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void ovoBreak() {
    try {
      File soundFile = new File("resources/audios/Jogo/ovoBreak.wav");
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
      Clip clip = AudioSystem.getClip();
      clip.open(audioInputStream);
      clip.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  static Clip clipMusicMenu;
  private static boolean isPlaying = false;
  
  public static void musicMenu() {
    try {
      File soundFile = new File("resources/audios/Jogo/musicamenu-unica.wav");
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
      clipMusicMenu = AudioSystem.getClip();
      clipMusicMenu.open(audioInputStream);

      // Adiciona um listener para reiniciar a música após 5 segundos
      clipMusicMenu.addLineListener(new LineListener() {
        @Override
        public void update(LineEvent event) {
          if (event.getType() == LineEvent.Type.STOP) {
         
            new Thread(() -> {
              try {
                Thread.sleep(10000);
                clipMusicMenu.setFramePosition(0);
                clipMusicMenu.start();
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            }).start();
          }
        }
      });

      if (!isPlaying) {
        clipMusicMenu.start(); // Começa a tocar a música uma vez
        isPlaying = true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // Método para parar a música
  public static void stopMusicMenu() {
    if (clipMusicMenu != null && clipMusicMenu.isRunning()) {
      clipMusicMenu.stop();
      clipMusicMenu.close();
      isPlaying = false;
    }
  }
  private static Clip colisianenergyClip;
  private static boolean isEnergyPlayingColisian = false;

  public static void colisianenergyfood() {
    try {
      if (colisianenergyClip == null) {
        File soundFile = new File("resources/audios/Jogo/colisianfoodeletric.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        colisianenergyClip = AudioSystem.getClip();
        colisianenergyClip.open(audioInputStream);
      }
      if (!isEnergyPlayingColisian) {
        colisianenergyClip.loop(Clip.LOOP_CONTINUOUSLY);
        isEnergyPlayingColisian = true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void stopEnergytimeColisian() {
    if (colisianenergyClip != null && isEnergyPlayingColisian) {
      colisianenergyClip.stop();
      isEnergyPlayingColisian = false;
    }
  }

  private static Clip RaioCaindoClip;
  private static boolean isEnergyPlayingRaioCaindo = false;

  public static void RaioCaindo() {
    try {
      if (RaioCaindoClip == null) {
        File soundFile = new File("resources/audios/Jogo/RaioCaindo.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        RaioCaindoClip = AudioSystem.getClip();
        RaioCaindoClip.open(audioInputStream);

        // Adiciona um LineListener para verificar quando o som termina
        RaioCaindoClip.addLineListener(new LineListener() {
          @Override
          public void update(LineEvent event) {
            if (event.getType() == LineEvent.Type.STOP) {
              RaioCaindoClip.stop();
              RaioCaindoClip.setFramePosition(0);
              AnimationEnergyControl.CaiuRaio = false; // Define a variável como false
              isEnergyPlayingRaioCaindo = false;
            }
          }
        });
      }
      if (!isEnergyPlayingRaioCaindo) {
        RaioCaindoClip.start();
        isEnergyPlayingRaioCaindo = true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void stopEnergytimeRaioCaindo() {
    if (RaioCaindoClip != null && isEnergyPlayingRaioCaindo) {
      RaioCaindoClip.stop();
      isEnergyPlayingRaioCaindo = false;
    }
  }

  private static Clip energyClip;
  private static boolean isEnergyPlaying = false;

  public static void energytime() {
    try {
      if (energyClip == null) {
        File soundFile = new File("resources/audios/Jogo/energytime.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        energyClip = AudioSystem.getClip();
        energyClip.open(audioInputStream);
      }
      if (!isEnergyPlaying) {
        energyClip.loop(Clip.LOOP_CONTINUOUSLY);
        isEnergyPlaying = true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void stopEnergytime() {
    if (energyClip != null && isEnergyPlaying) {
      energyClip.stop();
      isEnergyPlaying = false;
    }
  }
}
