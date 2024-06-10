import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class decoracao {
  public static Graphics2D g2d;

  public static List<Imagem> imagens = new ArrayList<>();
  private static Image Bush_blue_flowers;
  private static Image Bush_orange_flowers1;
  private static Image Bush_simple1_1;
  private static BufferedImage Bush_simple2_1;
  private static BufferedImage Glade_Objects_Top_Down_Pixel_Art2;
  private static BufferedImage Glade_Objects_Top_Down_Pixel_Art3;
  private static BufferedImage Rock1_grass_shadow1;
  private static BufferedImage Rock1_grass_shadow3;
  private static BufferedImage Fruit_tree3;
  ///
  private static BufferedImage Christmas_tree2;
  private static BufferedImage Swamp_Objects_Top_Down_Pixel_Art2;
  private static BufferedImage Glade_Objects_Top_Down_Pixel_Art66;
  private static BufferedImage Tree2;
  private static BufferedImage Glade_Objects_OTop_ODown_OPixel_OArt3_O1;
  private static BufferedImage Glade_Objects_Top_Down_Pixel_Art3_2;
  private static BufferedImage Glade_Objects_Top_Down_Pixel_Art44;
  private static BufferedImage Brown_gray_ruins3;
  private static BufferedImage Brown_gray_ruins1;
  private static BufferedImage dragao_rock;
  private static BufferedImage sprite_sheet_moinho;
  private static BufferedImage sprite_sheet_placa;
  private static BufferedImage casadamonga;
  // ----------------IMAGENS SWAMP
  private static BufferedImage Broken_tree_shadow2_3;
  private static BufferedImage Broken_tree_shadow2_4;
  private static BufferedImage Orange_mushrooms1_grass_shadow;
  private static BufferedImage Oval_leaf_tree33;
  private static BufferedImage Rock4_grass_shadow34;

  static {
    try {
      // MAPA FIELD

      ///// decorações simples

      Bush_blue_flowers = ImageIO.read(new File("resources/map_field/obstaculos_normal/Bush_blue_flowers2.png"));
      Bush_orange_flowers1 = ImageIO
          .read(new File("resources/map_field/obstaculos_normal/Bush_orange_flowers1.png"));
      Bush_simple1_1 = ImageIO.read(new File("resources/map_field/obstaculos_normal/Bush_simple1_1.png"));
      Bush_simple2_1 = ImageIO.read(new File("resources/map_field/obstaculos_normal/Bush_simple2_1.png"));
      Fruit_tree3 = ImageIO.read(new File("resources/map_field/obstaculos_normal/Fruit_tree3.png"));
      Glade_Objects_Top_Down_Pixel_Art2 = ImageIO
          .read(new File("resources/map_field/obstaculos_normal/Glade_Objects_Top_Down_Pixel_Art2.png"));
      Glade_Objects_Top_Down_Pixel_Art3 = ImageIO
          .read(new File("resources/map_field/obstaculos_normal/Glade_Objects_Top_Down_Pixe_Art3.png"));
      Rock1_grass_shadow1 = ImageIO.read(new File("resources/map_field/obstaculos_normal/Rock1_grass_shadow1.png"));
      Rock1_grass_shadow3 = ImageIO.read(new File("resources/map_field/obstaculos_normal/Rock1_grass_shadow3.png"));
      ///// decorações complexas
      Christmas_tree2 = ImageIO.read(new File("resources/map_field/obstaculos_complexos/Christmas_tree2.png"));
      Glade_Objects_Top_Down_Pixel_Art66 = ImageIO
          .read(new File("resources/map_field/obstaculos_complexos/Glade_Objects_Top_Down_Pixel_Art66.png"));
      Tree2 = ImageIO.read(new File("resources/map_field/obstaculos_complexos/Tree2.png"));
      Glade_Objects_Top_Down_Pixel_Art3_2 = ImageIO
          .read(new File("resources/map_field/obstaculos_complexos/Glade_Objects_Top_Down_Pixel_Art3_2.png"));
      Glade_Objects_OTop_ODown_OPixel_OArt3_O1 = ImageIO
          .read(new File("resources/map_field/obstaculos_complexos/Glade_Objects_OTop_ODown_OPixel_OArt3_O1.png"));
      Glade_Objects_Top_Down_Pixel_Art44 = ImageIO
          .read(new File("resources/map_field/obstaculos_complexos/Glade_Objects_Top_Down_Pixel_Art44.png"));
      Brown_gray_ruins3 = ImageIO.read(new File("resources/map_field/obstaculos_complexos/Brown_gray_ruins3.png"));
      Brown_gray_ruins1 = ImageIO.read(new File("resources/map_field/obstaculos_complexos/Brown_gray_ruins1.png"));
      dragao_rock = ImageIO.read(new File("resources/map_field/obstaculos_complexos/dragao_rock.png"));
      sprite_sheet_moinho = ImageIO
          .read(new File("resources/map_field/obstaculos_complexos/sprite_sheet_moinho.png"));
      sprite_sheet_placa = ImageIO
          .read(new File("resources/map_field/obstaculos_complexos/sprite_sheet_placa.png"));
      casadamonga = ImageIO.read(new File("resources/map_field/obstaculos_complexos/casadamonga.png"));
      ////
      // MAPA SWAMP - DECORAÇÃO SIMPLES
      Broken_tree_shadow2_3 = ImageIO
          .read(new File("resources/map_swamp/obstaculos_normal/Broken_tree_shadow2_3.png"));
      Broken_tree_shadow2_4 = ImageIO
          .read(new File("resources/map_swamp/obstaculos_normal/Broken_tree_shadow2_4.png"));
      Orange_mushrooms1_grass_shadow = ImageIO
          .read(new File("resources/map_swamp/obstaculos_normal/Orange_mushrooms1_grass_shadow.png"));
      Oval_leaf_tree33 = ImageIO.read(new File("resources/map_swamp/obstaculos_normal/Oval_leaf_tree33.png"));
      Rock4_grass_shadow34 = ImageIO
          .read(new File("resources/map_swamp/obstaculos_normal/Rock4_grass_shadow34.png"));

      ///// decorações complexas

    } catch (IOException ex) {
      ex.printStackTrace();
    }

  }

  public static void posicoesDeco(int FrameWidth, int FrameHeight, int ALL_DOTS_Width, int ALL_DOTS_Height,
      ArrayList<Integer> walls_x,
      ArrayList<Integer> walls_y) {
    int PorcentagemX = (15 * FrameWidth) / 100;
    int PorcentagemY = (10 * FrameWidth) / 100;
    int PorcentagemCOMX = (15 * FrameWidth) / 100;
    int PorcentagemCOMY = (15 * FrameWidth) / 100;
    ///
    int valueDecoSimples = 0;
    int valueDecoComplexo = 0;
    if (Game.MapField) {
      valueDecoSimples = 9;
    } else if (Game.MapSwamp) {
      valueDecoSimples = 5;
    } else if (Game.MapDungeon) {
      valueDecoSimples = 0;
    }
    if (Game.MapField) {
      valueDecoComplexo = 12;
    } else if (Game.MapSwamp) {
      valueDecoComplexo = 0;
    } else if (Game.MapDungeon) {
      valueDecoComplexo = 0;
    }

    for (int i = 0; i < valueDecoSimples; i++) {
      Game.quanti.add((int) (Math.random() * 3) + 1);
    }

    for (int i = 0; i < Game.quanti.size(); i++) {
      Game.ValueFinal += Game.quanti.get(i);
      Game.ValueDecoNormal += Game.quanti.get(i);
    }
    ///
    for (int i = 0; i < valueDecoComplexo; i++) {
      Game.quantiComplexo.add((int) (Math.random() + 0.5));
    }

    for (int i = 0; i < Game.quantiComplexo.size(); i++) {
      Game.ValueFinal += Game.quantiComplexo.get(i);
    }
    if (Game.DecoracaoX != null && Game.DecoracaoY != null && Game.DecoComplexoX != null
        && Game.DecoComplexoY != null) {
      Game.DecoracaoX = new int[Game.ValueFinal];
      Game.DecoracaoY = new int[Game.ValueFinal];
      Game.DecoComplexoX = new int[Game.ValueFinal];
      Game.DecoComplexoY = new int[Game.ValueFinal];
      for (int i = 0; i < Game.ValueFinal; i++) {
        int x, y;
        int x1, y1;
        do {
          x = (int) (Math.random() * (FrameWidth - PorcentagemX)) + 100;
          y = (int) (Math.random() * (FrameHeight - PorcentagemY)) + 50;
          x1 = (int) (Math.random() * (FrameWidth - PorcentagemCOMX)) + 150;
          y1 = (int) (Math.random() * (FrameHeight - PorcentagemCOMY)) + 150;
        } while (isWallPosition(x, y, walls_x, walls_y, x1, y1)
            || containsPosition(x, y, Game.DecoracaoX, Game.DecoracaoY, x1, y1, Game.DecoComplexoX,
                Game.DecoComplexoY));
        if (i < Game.ValueDecoNormal) {
          Game.DecoracaoX[i] = x;
          Game.DecoracaoY[i] = y;
        }
        Game.DecoComplexoX[i] = x1;
        Game.DecoComplexoY[i] = y1;
      }
    }
  }

  private static boolean isWallPosition(int x, int y, ArrayList<Integer> walls_x, ArrayList<Integer> walls_y, int x1,
      int y1) {
    Rectangle imageRect = new Rectangle(x, y, 30, 30); // tamanho da imagem decorativa
    Rectangle imageRectComplexa = new Rectangle(x1, y1, 100, 100);
    for (int i = 0; i < walls_x.size(); i++) {
      Rectangle wallRect = new Rectangle(walls_x.get(i), walls_y.get(i), 10, 10);
      if (imageRect.intersects(wallRect) || imageRectComplexa.intersects(wallRect)) {
        return true;
      }
    }
    return false;
  }

  private static boolean containsPosition(int x, int y, int[] DecoracaoX, int[] DecoracaoY, int x1,
      int y1, int[] DecoComplexoX, int[] DecoComplexoY) {
    Rectangle imageRect = new Rectangle(x, y, 30, 30); // tamanho da imagem decorativa
    Rectangle imageRectComplexa = new Rectangle(x1, y1, 100, 100);
    for (int i = 0; i < DecoracaoX.length; i++) {
      Rectangle otherRect = new Rectangle(DecoracaoX[i], DecoracaoY[i], 30, 30);
      Rectangle otherRectComplexa = new Rectangle(DecoComplexoX[i], DecoComplexoY[i], 100, 100);
      if (imageRect.intersects(otherRect) || imageRect.intersects(otherRectComplexa) || imageRectComplexa
          .intersects(otherRectComplexa) || imageRectComplexa.intersects(otherRect)) {
        return true;
      }
    }
    return false;
  }

  public static int numFramesXMo = 6; // Ajuste conforme necessário
  public static int numFramesYMo = 1; // Supondo que todas as animações estão na mesma linha
  public static int frameWidthMo = 200; // Largura do frame redimensionado
  public static int frameHeightMo = 330; // Altura do frame redimensionado
  private static int frameIntervalMo = 1000;
  public static int totalFramesMo = numFramesXMo * numFramesYMo;
  public static long currentTimeMoinho = System.currentTimeMillis();
  private static long lastFrameTimeMo = 0;
  public static Graphics2D ImagemMoinho;
  ///
  public static int numFramesXBan = 6; // Ajuste conforme necessário
  public static int numFramesYBan = 1; // Supondo que todas as animações estão na mesma linha
  public static int frameWidthBan = 200; // Largura do frame redimensionado
  public static int frameHeightBan = 330; // Altura do frame redimensionado
  private static int frameIntervalBan = 1000;
  public static int totalFramesBan = numFramesXBan * numFramesYBan;
  public static long currentTimeBandeira = System.currentTimeMillis();
  private static long lastFrameTimeBan = 0;
  public static Graphics2D ImagemBandeira;

  public static void decoracaoField(BufferedImage buffer) {
    g2d = buffer.createGraphics();

    imagens.clear(); // Limpa a lista de imagens
    int index = 0;

    //// Decorações simples
    for (int i = 0; i < Game.quanti.get(0); i++) {
      imagens.add(new Imagem(Bush_blue_flowers, Game.DecoracaoX[index], Game.DecoracaoY[index], 28, 28));
      index++;
    }
    for (int i = 0; i < Game.quanti.get(1); i++) {
      imagens.add(new Imagem(Bush_orange_flowers1, Game.DecoracaoX[index], Game.DecoracaoY[index], 35, 37));
      index++;
    }
    for (int i = 0; i < Game.quanti.get(2); i++) {
      imagens.add(new Imagem(Bush_simple1_1, Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
      index++;
    }
    for (int i = 0; i < Game.quanti.get(3); i++) {
      imagens.add(new Imagem(Bush_simple2_1, Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
      index++;
    }
    for (int i = 0; i < Game.quanti.get(4); i++) {
      imagens.add(new Imagem(Fruit_tree3,
          Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
      index++;
    }
    for (int i = 0; i < Game.quanti.get(5); i++) {
      imagens.add(new Imagem(Glade_Objects_Top_Down_Pixel_Art2,
          Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
      index++;
    }
    for (int i = 0; i < Game.quanti.get(6); i++) {
      imagens.add(new Imagem(Glade_Objects_Top_Down_Pixel_Art3,
          Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
      index++;
    }
    for (int i = 0; i < Game.quanti.get(7); i++) {
      imagens.add(new Imagem(Rock1_grass_shadow1,
          Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
      index++;
    }
    for (int i = 0; i < Game.quanti.get(8); i++) {
      imagens.add(new Imagem(Rock1_grass_shadow3,
          Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
      index++;
    }

    // Decorações Complexas

    for (int i = 0; i < Game.quantiComplexo.size(); i++) {
      if (Game.quantiComplexo.get(i) > 0) {
        switch (i) {
          case 0:
            imagens.add(new Imagem(Christmas_tree2, Game.DecoComplexoX[1], Game.DecoComplexoY[1], 60, 60));
            break;
          case 1:
            imagens.add(new Imagem(Tree2, Game.DecoComplexoX[2], Game.DecoComplexoY[2], 60, 60));
            break;
          case 2:
            imagens.add(new Imagem(Glade_Objects_OTop_ODown_OPixel_OArt3_O1, Game.DecoComplexoX[3],
                Game.DecoComplexoY[3], 51, 73));
            break;
          case 3:
            imagens.add(
                new Imagem(Glade_Objects_Top_Down_Pixel_Art3_2, Game.DecoComplexoX[4], Game.DecoComplexoY[4], 92, 93));
            break;
          case 4:
            imagens.add(
                new Imagem(Glade_Objects_Top_Down_Pixel_Art66, Game.DecoComplexoX[5], Game.DecoComplexoY[5], 57, 60));
            break;
          case 5:
            imagens.add(
                new Imagem(Glade_Objects_Top_Down_Pixel_Art44, Game.DecoComplexoX[6], Game.DecoComplexoY[6], 74, 90));
            break;
          case 6:
            imagens.add(new Imagem(dragao_rock, Game.DecoComplexoX[7], Game.DecoComplexoY[7], 147, 111));
            break;
          case 7:
            imagens.add(new Imagem(Brown_gray_ruins3, Game.DecoComplexoX[8], Game.DecoComplexoY[8], 64, 64));
            break;
          case 8:
            imagens.add(new Imagem(Brown_gray_ruins1, Game.DecoComplexoX[9], Game.DecoComplexoY[9], 112, 112));
            break;
          case 9:
            BufferedImage Moinho = (BufferedImage) sprite_sheet_moinho;
            int sx = (Game.currentFrame10 % numFramesXMo) * (Moinho.getWidth() /
                numFramesXMo);
            int sy = (Game.currentFrame10 / numFramesXMo) * (Moinho.getHeight() /
                numFramesYMo);
            int sw = Moinho.getWidth() / numFramesXMo;
            int sh = Moinho.getHeight() / numFramesYMo;
            ImagemMoinho = buffer.createGraphics();
            AffineTransform at = new AffineTransform();
            at.scale((double) (100 + 2) / sw, (double) (134 + 2) / sh);
            // Create an AffineTransformOp object with the AffineTransform
            AffineTransformOp op = new AffineTransformOp(at,
                AffineTransformOp.TYPE_BILINEAR);
            // Apply the transform to the image
            BufferedImage scaledImage = op.filter(Moinho.getSubimage(sx, sy, sw, sh),
                null);
            ImagemMoinho.drawImage(scaledImage, Game.DecoComplexoX[10],
                Game.DecoComplexoY[10], null);
            long currentTimeMoinho = System.currentTimeMillis();
            Game.currentFrame10 = (Game.currentFrame10 + 1) % totalFramesMo;
            if (currentTimeMoinho - lastFrameTimeMo >= frameIntervalMo) {
              lastFrameTimeMo = currentTimeMoinho - (currentTimeMoinho % frameIntervalMo);
              Game.currentFrame10 = (Game.currentFrame10 + 1) % totalFramesMo;
            }
            break;
          case 10:
            BufferedImage bandeira = (BufferedImage) sprite_sheet_placa;
            int sx1 = (Game.currentFrame11 % numFramesXBan) * (bandeira.getWidth() /
                numFramesXBan);
            int sy1 = (Game.currentFrame11 / numFramesXBan) * (bandeira.getHeight() /
                numFramesYBan);
            int sw1 = bandeira.getWidth() / numFramesXBan;
            int sh1 = bandeira.getHeight() / numFramesYBan;
            ImagemBandeira = buffer.createGraphics();
            AffineTransform at1 = new AffineTransform();
            at1.scale((double) (30 + 2) / sw1, (double) (54 + 2) / sh1);
            // Create an AffineTransformOp object with the AffineTransform
            AffineTransformOp op1 = new AffineTransformOp(at1,
                AffineTransformOp.TYPE_BILINEAR);
            // Apply the transform to the image
            BufferedImage scaledImage1 = op1.filter(bandeira.getSubimage(sx1, sy1, sw1,
                sh1),
                null);
            ImagemBandeira.drawImage(scaledImage1, Game.DecoComplexoX[11],
                Game.DecoComplexoY[11], null);
            long currentTimeBandeira = System.currentTimeMillis();
            Game.currentFrame11 = (Game.currentFrame11 + 1) % totalFramesBan;
            if (currentTimeBandeira - lastFrameTimeBan >= frameIntervalBan) {
              lastFrameTimeBan = currentTimeBandeira - (currentTimeBandeira %
                  frameIntervalBan);
              Game.currentFrame11 = (Game.currentFrame11 + 1) % totalFramesBan;
            }
            break;
          case 11:
            imagens.add(new Imagem(casadamonga, Game.DecoComplexoX[12], Game.DecoComplexoY[12], 101, 77));
            break;
          default:
            break;
        }
      }

    }

    ///////////////////////
    for (Imagem imagem : imagens) {
      g2d.drawImage(imagem.getImagem(), imagem.getX(), imagem.getY(), imagem.getWidth(), imagem.getHeight(), null);
    }
    g2d.dispose();
  }

  public static void decoracaoSwamp(BufferedImage buffer) {
    g2d = buffer.createGraphics();
    imagens.clear();
    int index = 0;
    /// -Simples
    for (int i = 0; i < Game.quanti.get(0); i++) {
      imagens.add(new Imagem(Broken_tree_shadow2_3, Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
      index++;
    }
    for (int i = 0; i < Game.quanti.get(1); i++) {
      imagens.add(new Imagem(Broken_tree_shadow2_4, Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
      index++;
    }
    for (int i = 0; i < Game.quanti.get(2); i++) {
      imagens.add(new Imagem(Orange_mushrooms1_grass_shadow, Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
      index++;
    }
    for (int i = 0; i < Game.quanti.get(3); i++) {
      imagens.add(new Imagem(Oval_leaf_tree33, Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
      index++;
    }
    for (int i = 0; i < Game.quanti.get(4); i++) {
      imagens.add(new Imagem(Rock4_grass_shadow34, Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
      index++;
    }
    /// -Complexas
    for (Imagem imagem : imagens) {
      g2d.drawImage(imagem.getImagem(), imagem.getX(), imagem.getY(), imagem.getWidth(), imagem.getHeight(), null);
    }
    g2d.dispose();
  }

  public static void decoracaoDungeon() {

  }
}

class Imagem {
  private Image imagem;
  private int x;
  private int y;
  private int width;
  private int height;

  public Imagem(Image imagem, int x, int y, int width, int height) {
    this.imagem = imagem;
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  public Image getImagem() {
    return imagem;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }
}
