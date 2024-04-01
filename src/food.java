import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class food {
  private static long lastFrameTimee = System.currentTimeMillis();
  private static long lastFrameTime = System.currentTimeMillis();
  private static final int frameInterval = 80; // Intervalo entre quadros em milissegundos
  public static int lastRenderedFrame = -1;

  public static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
    BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = resizedImage.createGraphics();
    AffineTransform transform = AffineTransform.getScaleInstance((double) targetWidth / originalImage.getWidth(),
        (double) targetHeight / originalImage.getHeight());
    AffineTransformOp scaleOp = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
    scaleOp.filter(originalImage, resizedImage);
    g2d.drawImage(resizedImage, 0, 0, null);
    g2d.dispose();
    return resizedImage;
  }

  public static void classicFood(Graphics g, BufferedImage buffer, int macaX, int macaY, Image appleSprit, int width,
      int height) {
    Graphics2D food = buffer.createGraphics();
    food.drawImage(appleSprit, macaX, macaY, width, height, null);
    food.dispose();
    g.drawImage(buffer, 0, 0, null);
  }

  public static void PoisonFood(Graphics g, BufferedImage buffer, int macaPOX, int macaPOY, Image applePoison,
      int width, int height) {
    int numFramesXx = 13; // Ajuste conforme necessário
    int numFramesYy = 1; // Supondo que todas as animações estão na mesma linha
    int frameWidthh = 100; // Largura do frame redimensionado
    int frameHeightt = 100; // Altura do frame redimensionado
    int totalFramess = numFramesXx * numFramesYy;
    int frameIntervall = 80; // Intervalo entre quadros em milissegundos
    BufferedImage EnergyAnimationFoodPoison = (BufferedImage) applePoison;
    Graphics2D food = buffer.createGraphics();

    long currentTime = System.currentTimeMillis();

    int sx = (Game.currentFrame6 % numFramesXx) * (EnergyAnimationFoodPoison.getWidth() / numFramesXx);
    int sy = (Game.currentFrame6 / numFramesXx) * (EnergyAnimationFoodPoison.getHeight() / numFramesXx);
    int sw = EnergyAnimationFoodPoison.getWidth() / numFramesXx;
    int sh = EnergyAnimationFoodPoison.getHeight() / numFramesYy;
    BufferedImage resizedImageFoodPoison = resizeImage(EnergyAnimationFoodPoison.getSubimage(sx, sy, sw, sh),
        frameWidthh,
        frameHeightt);
    Image scaledApplePoison = resizedImageFoodPoison.getScaledInstance(width, height,
        Image.SCALE_SMOOTH);
    food.drawImage(scaledApplePoison, macaPOX, macaPOY, null);

    // Atualize o quadro que foi renderizado

    // Atualize o quadro apenas quando o intervalo de tempo entre os quadros passar
    if (currentTime - lastFrameTimee > frameIntervall) {
      // Avance para o próximo quadro
      Game.currentFrame6 = (Game.currentFrame6 + 1) % totalFramess;
      lastFrameTimee = currentTime;

    }
  }

  public static void EnergyFood(Game game, Graphics g, BufferedImage buffer, int macaX, int macaY, Image appleEnergy,
      int width,
      int height) {
    BufferedImage EnergyAnimationFoodEnergy = (BufferedImage) appleEnergy;
    Graphics2D food = buffer.createGraphics();
    int numFramesX = 6; // Ajuste conforme necessário
    int numFramesY = 1; // Supondo que todas as animações estão na mesma linha
    int frameWidth = 500; // Largura do frame redimensionado
    int frameHeight = 500; // Altura do frame redimensionado
    int totalFrames = numFramesX * numFramesY;
    long currentTime = System.currentTimeMillis();
    int sx = (Game.currentFrame5 % numFramesX) * (EnergyAnimationFoodEnergy.getWidth() / numFramesX);
    int sy = (Game.currentFrame5 / numFramesX) * (EnergyAnimationFoodEnergy.getHeight() / numFramesX);
    int sw = EnergyAnimationFoodEnergy.getWidth() / numFramesX;
    int sh = EnergyAnimationFoodEnergy.getHeight() / numFramesY;
    BufferedImage resizedImageFoodEnergy = resizeImage(EnergyAnimationFoodEnergy.getSubimage(sx, sy, sw, sh),
        frameWidth,
        frameHeight);
    Image scaledAppleEnergy = resizedImageFoodEnergy.getScaledInstance(width, height,
        Image.SCALE_SMOOTH);
    food.drawImage(scaledAppleEnergy, macaX, macaY, null);

    if (currentTime - lastFrameTime > frameInterval) {
      Game.currentFrame5 = (Game.currentFrame5 + 1) % totalFrames;
      lastFrameTime = currentTime;
    }

  }

}
