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

  public static void mapField(BufferedImage buffer, int ALL_DOTS_Width, int ALL_DOTS_Height, Image gramSprit,
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

  public static void mapSwamp(BufferedImage buffer, int ALL_DOTS_Width, int ALL_DOTS_Height, Image chao_swamp,
      Image small_trunk, Image chao1, Image chao2, Image chao3, int quantidadeDecoSmallTrunk, int quantidadeDecoChao1,
      int quantidadeDecoChao2, int quantidadeDecoChao3, int[] randomSX, int[] randomSY,
      int[] randomSX1, int[] randomSY1, int[] randomSX2, int[] randomSY2, int[] randomSX3, int[] randomSY3) {
    g2d = buffer.createGraphics();
    try {
      bufferedImage = (BufferedImage) chao_swamp;
      backgroundImageWidth = bufferedImage.getWidth();
      backgroundImageHeight = bufferedImage.getHeight();
      scaledBackgroundImageWidth = (int) (backgroundImageWidth * scale);
      scaledBackgroundImageHeight = (int) (backgroundImageHeight * scale);
      // Desenha as imagens de fundo
      for (int y = 0; y < ALL_DOTS_Height; y += scaledBackgroundImageHeight) {
        for (int x = 0; x < ALL_DOTS_Width; x += scaledBackgroundImageWidth) {
          g2d.drawImage(chao_swamp, x, y, scaledBackgroundImageWidth, scaledBackgroundImageHeight, null);
        }
      }

      for (int i = 0; i < quantidadeDecoChao1; i++) {
        g2d.drawImage(chao1, randomSX1[i], randomSY1[i], 274, 369, null);
      }
      for (int i = 0; i < quantidadeDecoChao2; i++) {
        g2d.drawImage(chao2, randomSX2[i], randomSY2[i], 44, 170, null);
      }
      for (int i = 0; i < quantidadeDecoChao3; i++) {
        g2d.drawImage(chao3, randomSX3[i], randomSY3[i], 519, 369, null);
      }
      for (int i = 0; i < quantidadeDecoSmallTrunk; i++) {
        g2d.drawImage(small_trunk, randomSX[i], randomSY[i], 64, 64, null);
      }
    } finally {
      g2d.dispose();
    }
  }

  public static void mapDungeon(BufferedImage buffer, int ALL_DOTS_Width, int ALL_DOTS_Height, Image chao_dungeon,
      Image dragon_bone, Image skull_bone, Image tibia_bone, int quantidadeDecoDragonBone, int quantidadeDecoSkullBone,
      int quantidadeDecoTibiaBone, int[] randomDX, int[] randomDY, int[] randomDX1, int[] randomDY1, int[] randomDX2,
      int[] randomDY2) {
    g2d = buffer.createGraphics();
    try {
      bufferedImage = (BufferedImage) chao_dungeon;
      backgroundImageWidth = bufferedImage.getWidth();
      backgroundImageHeight = bufferedImage.getHeight();
      scaledBackgroundImageWidth = (int) (backgroundImageWidth * scale);
      scaledBackgroundImageHeight = (int) (backgroundImageHeight * scale);
      // Desenha as imagens de fundo
      for (int y = 0; y < ALL_DOTS_Height; y += scaledBackgroundImageHeight) {
        for (int x = 0; x < ALL_DOTS_Width; x += scaledBackgroundImageWidth) {
          g2d.drawImage(chao_dungeon, x, y, scaledBackgroundImageWidth, scaledBackgroundImageHeight, null);
        }
      }
      for (int i = 0; i < quantidadeDecoTibiaBone; i++) {
        g2d.drawImage(tibia_bone, randomDX2[i], randomDY2[i], 30, 30, null);
      }
      for (int i = 0; i < quantidadeDecoSkullBone; i++) {
        g2d.drawImage(skull_bone, randomDX1[i], randomDY1[i], 20, 20, null);
      }
      for (int i = 0; i < quantidadeDecoDragonBone; i++) {
        g2d.drawImage(dragon_bone, randomDX[i], randomDY[i], 212, 176, null);
      }
    } finally {
      g2d.dispose();
    }
  }
}
