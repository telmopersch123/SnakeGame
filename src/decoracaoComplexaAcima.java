import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class decoracaoComplexaAcima {
  public static int numFramesXArv = 6; // Ajuste conforme necessário
  public static int numFramesYArv = 1; // Supondo que todas as animações estão na mesma linha
  public static int frameWidthArv = 500; // Largura do frame redimensionado
  public static int frameHeightArv = 500; // Altura do frame redimensionado
  private static long lastFrameTimeArv3 = 0;
  private static int frameIntervalArv3 = 150;
  private static long lastFrameTimeArv4 = 0;
  private static long lastFrameTimeArv5 = 0;
  private static int frameIntervalArv4 = 150;
  private static int frameIntervalArv5 = 150;
  public static long currentTimeArv3 = System.currentTimeMillis();
  public static long currentTimeArv4 = System.currentTimeMillis();
  public static long currentTimeArv5 = System.currentTimeMillis();
  public static int totalFramesArv1 = numFramesXArv * numFramesYArv;
  public static int totalFramesArv2 = numFramesXArv * numFramesYArv;
  public static int totalFramesArv3 = numFramesXArv * numFramesYArv;
  public static Graphics2D lagoPantano;
  public static Graphics2D lagoPantano1;
  public static Graphics2D lagoPantano2;

  public static void Acima(BufferedImage buffer, Image spriteshetlago1, Image spriteshetlago2, Image spriteshetlago3) {
    for (int i = 0; i < Game.quantiComplexo.size(); i++) {
      if (Game.quantiComplexo.get(i) > 0) {
        switch (i) {
          case 28:
            if (Game.DecoComplexoX.length > 29 && Game.DecoComplexoY.length > 29) {
              BufferedImage lago = (BufferedImage) spriteshetlago1;
              int sx = (Game.currentFrame14 % numFramesXArv) * (lago.getWidth() /
                  numFramesXArv);
              int sy = (Game.currentFrame14 / numFramesXArv) * (lago.getHeight() /
                  numFramesYArv);
              int sw = lago.getWidth() / numFramesXArv;
              int sh = lago.getHeight() / numFramesYArv;
              lagoPantano = buffer.createGraphics();
              AffineTransform at = new AffineTransform();
              at.scale((double) (150 + 2) / sw, (double) (150 + 2) / sh);
              // Create an AffineTransformOp object with the AffineTransform
              AffineTransformOp op = new AffineTransformOp(at,
                  AffineTransformOp.TYPE_BILINEAR);
              // Apply the transform to the image
              BufferedImage scaledImage = op.filter(lago.getSubimage(sx, sy, sw,
                  sh),
                  null);
              lagoPantano.drawImage(scaledImage,
                  Game.DecoComplexoX[29],
                  Game.DecoComplexoY[29], null);
              long currentTimeArv3 = System.currentTimeMillis();

              if (currentTimeArv3 - lastFrameTimeArv3 >= frameIntervalArv3) {
                lastFrameTimeArv3 = currentTimeArv3 - (currentTimeArv3 %
                    frameIntervalArv3);
                Game.currentFrame14 = (Game.currentFrame14 + 1) % totalFramesArv1;
              }
            }
            break;
          case 29:
            if (Game.DecoComplexoX.length > 30 && Game.DecoComplexoY.length > 30) {
              BufferedImage lago1 = (BufferedImage) spriteshetlago2;
              int sx1 = (Game.currentFrame15 % numFramesXArv) * (lago1.getWidth() /
                  numFramesXArv);
              int sy1 = (Game.currentFrame15 / numFramesXArv) * (lago1.getHeight() /
                  numFramesYArv);
              int sw1 = lago1.getWidth() / numFramesXArv;
              int sh1 = lago1.getHeight() / numFramesYArv;
              lagoPantano1 = buffer.createGraphics();
              AffineTransform at1 = new AffineTransform();
              at1.scale((double) (150 + 2) / sw1, (double) (150 + 2) / sh1);
              // Create an AffineTransformOp object with the AffineTransform
              AffineTransformOp op1 = new AffineTransformOp(at1,
                  AffineTransformOp.TYPE_BILINEAR);
              // Apply the transform to the image
              BufferedImage scaledImage = op1.filter(lago1.getSubimage(sx1, sy1, sw1,
                  sh1),
                  null);
              lagoPantano1.drawImage(scaledImage,
                  Game.DecoComplexoX[30],
                  Game.DecoComplexoY[30], null);
              long currentTimeArv4 = System.currentTimeMillis();

              if (currentTimeArv4 - lastFrameTimeArv4 >= frameIntervalArv4) {
                lastFrameTimeArv4 = currentTimeArv4 - (currentTimeArv4 %
                    frameIntervalArv4);
                Game.currentFrame15 = (Game.currentFrame15 + 1) % totalFramesArv2;

              }
            }
            break;
          case 30:
            if (Game.DecoComplexoX.length > 31 && Game.DecoComplexoY.length > 31) {
              BufferedImage lago2 = (BufferedImage) spriteshetlago3;
              int sx2 = (Game.currentFrame16 % numFramesXArv) * (lago2.getWidth() /
                  numFramesXArv);
              int sy2 = (Game.currentFrame16 / numFramesXArv) * (lago2.getHeight() /
                  numFramesYArv);
              int sw2 = lago2.getWidth() / numFramesXArv;
              int sh2 = lago2.getHeight() / numFramesYArv;
              lagoPantano2 = buffer.createGraphics();
              AffineTransform at2 = new AffineTransform();
              at2.scale((double) (150 + 2) / sw2, (double) (150 + 2) / sh2);
              // Create an AffineTransformOp object with the AffineTransform
              AffineTransformOp op1 = new AffineTransformOp(at2,
                  AffineTransformOp.TYPE_BILINEAR);
              // Apply the transform to the image
              BufferedImage scaledImage = op1.filter(lago2.getSubimage(sx2, sy2, sw2,
                  sh2),
                  null);
              lagoPantano1.drawImage(scaledImage,
                  Game.DecoComplexoX[31],
                  Game.DecoComplexoY[31], null);
              long currentTimeArv5 = System.currentTimeMillis();

              if (currentTimeArv5 - lastFrameTimeArv5 >= frameIntervalArv5) {
                lastFrameTimeArv5 = currentTimeArv5 - (currentTimeArv5 %
                    frameIntervalArv5);
                Game.currentFrame16 = (Game.currentFrame16 + 1) % totalFramesArv3;

              }
            }
            break;
          default:
            break;
        }
      }
    }
  }
}
