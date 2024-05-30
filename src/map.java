import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class map {
  public static Graphics2D g2d;
  public static BufferedImage bufferedImage;
  public static int backgroundImageWidth;
  public static int backgroundImageHeight;
  public static double scale = 0.8;
  public static int scaledBackgroundImageWidth;
  public static int scaledBackgroundImageHeight;

  public static void mapLawn(BufferedImage buffer, int ALL_DOTS_Width, int ALL_DOTS_Height, Image gramSprit,
      Image DecoLawn01, Image DecoLawn02,
      int[] randomX, int[] randomY, int quantidadeDeco, int[] randomX2, int[] randomY2, int quantidadeDeco2) {
    g2d = buffer.createGraphics();
    try {
      bufferedImage = (BufferedImage) gramSprit;
      backgroundImageWidth = bufferedImage.getWidth();
      backgroundImageHeight = bufferedImage.getHeight();
      scaledBackgroundImageWidth = (int) (backgroundImageWidth * scale);
      scaledBackgroundImageHeight = (int) (backgroundImageHeight * scale);
      // Desenha as imagens de fundo
      for (int y = 0; y < ALL_DOTS_Height; y += scaledBackgroundImageHeight) {
        for (int x = 0; x < ALL_DOTS_Width; x += scaledBackgroundImageWidth) {
          g2d.drawImage(gramSprit, x, y, scaledBackgroundImageWidth, scaledBackgroundImageHeight, null);
        }
      }
      for (int i = 0; i < quantidadeDeco2; i++) {
        g2d.drawImage(DecoLawn02, randomX2[i], randomY2[i], 100, 100, null);
      }
      for (int i = 0; i < quantidadeDeco; i++) {
        g2d.drawImage(DecoLawn01, randomX[i], randomY[i], 150, 150, null);
      }
    } finally {
      g2d.dispose();
    }
  }
}
