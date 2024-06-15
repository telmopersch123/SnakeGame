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
  private static BufferedImage aglomerado_cogubranco;
  private static BufferedImage aglomerado_coguroxo;
  private static BufferedImage Blue_green_balls_tree1;
  private static BufferedImage Brown_ruins1;
  private static BufferedImage cemiterio;
  private static BufferedImage Luminous_tree1;
  private static BufferedImage Luminous_tree2;
  private static BufferedImage Luminous_tree3;
  private static BufferedImage Mega_tree2;
  private static BufferedImage Rock_statue_deer_ground_shadow;
  private static BufferedImage SwampObjectsTopDownPixelArt3;
  private static BufferedImage SwampObjectsTopDownPixelArt4;
  private static BufferedImage SwamppObjectsTopDownPixelArt2;
  private static BufferedImage SwampTopDownTilesetPixelArt3;
  private static BufferedImage SwampTopDownTilesetPixelArt31;
  private static BufferedImage SwampTopDownTilesetPixelArt32;
  private static BufferedImage SwampTopDownTilesetPixelArt33;
  private static BufferedImage SwampTopDownTilesetPixelArt34;
  private static BufferedImage SwampTopDownTilesetPixelArt35;
  private static BufferedImage SwampTopDownTilesetPixelArt36;
  private static BufferedImage SwampTopDownTilesetPixelArt42;
  private static BufferedImage Willow1;
  private static BufferedImage Willow2;
  private static BufferedImage Willow3;
  private static BufferedImage Yellow_ruins1;
  private static BufferedImage spritesheet1;
  private static BufferedImage spritesheet2;
  private static BufferedImage spritesheetarvore1;
  private static BufferedImage spritesheetarvore3;
  private static BufferedImage spritesheetarvore2;
  private static BufferedImage spriteshetlago1;
  private static BufferedImage spritsheethomemcristal;

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
      aglomerado_cogubranco = ImageIO
          .read(new File("resources/map_swamp/obstaculos_complexos/aglomerado_cogubranco.png"));
      aglomerado_coguroxo = ImageIO
          .read(new File("resources/map_swamp/obstaculos_complexos/aglomerado_coguroxo.png"));
      Blue_green_balls_tree1 = ImageIO
          .read(new File("resources/map_swamp/obstaculos_complexos/Blue_green_balls_tree1.png"));
      Brown_ruins1 = ImageIO
          .read(new File("resources/map_swamp/obstaculos_complexos/Brown_ruins1.png"));
      cemiterio = ImageIO
          .read(new File("resources/map_swamp/obstaculos_complexos/cemiterio.png"));
      Luminous_tree1 = ImageIO
          .read(new File("resources/map_swamp/obstaculos_complexos/Luminous_tree1.png"));
      Luminous_tree2 = ImageIO
          .read(new File("resources/map_swamp/obstaculos_complexos/Luminous_tree2.png"));
      Luminous_tree3 = ImageIO
          .read(new File("resources/map_swamp/obstaculos_complexos/Luminous_tree3.png"));
      Mega_tree2 = ImageIO
          .read(new File("resources/map_swamp/obstaculos_complexos/Mega_tree2.png"));
      Rock_statue_deer_ground_shadow = ImageIO
          .read(new File("resources/map_swamp/obstaculos_complexos/Rock_statue_deer_ground_shadow.png"));
      SwampObjectsTopDownPixelArt3 = ImageIO
          .read(new File("resources/map_swamp/obstaculos_complexos/SwampObjectsTopDownPixelArt3.png"));
      SwampObjectsTopDownPixelArt4 = ImageIO
          .read(new File("resources/map_swamp/obstaculos_complexos/SwampObjectsTopDownPixelArt4.png"));
      SwamppObjectsTopDownPixelArt2 = ImageIO
          .read(new File("resources/map_swamp/obstaculos_complexos/SwamppObjectsTopDownPixelArt2.png"));
      SwampTopDownTilesetPixelArt3 = ImageIO
          .read(new File("resources/map_swamp/obstaculos_complexos/SwampTopDownTilesetPixelArt3.png"));
      SwampTopDownTilesetPixelArt31 = ImageIO
          .read(new File("resources/map_swamp/obstaculos_complexos/SwampTopDownTilesetPixelArt31.png"));
      SwampTopDownTilesetPixelArt32 = ImageIO
          .read(new File("resources/map_swamp/obstaculos_complexos/SwampTopDownTilesetPixelArt32.png"));
      SwampTopDownTilesetPixelArt33 = ImageIO
          .read(new File("resources/map_swamp/obstaculos_complexos/SwampTopDownTilesetPixelArt33.png"));
      SwampTopDownTilesetPixelArt34 = ImageIO
          .read(new File("resources/map_swamp/obstaculos_complexos/SwampTopDownTilesetPixelArt34.png"));
      SwampTopDownTilesetPixelArt35 = ImageIO
          .read(new File("resources/map_swamp/obstaculos_complexos/SwampTopDownTilesetPixelArt35.png"));
      SwampTopDownTilesetPixelArt36 = ImageIO
          .read(new File("resources/map_swamp/obstaculos_complexos/SwampTopDownTilesetPixelArt36.png"));
      SwampTopDownTilesetPixelArt42 = ImageIO
          .read(new File("resources/map_swamp/obstaculos_complexos/SwampTopDownTilesetPixelArt42.png"));
      Willow1 = ImageIO
          .read(new File("resources/map_swamp/obstaculos_complexos/Willow1.png"));
      Willow2 = ImageIO
          .read(new File("resources/map_swamp/obstaculos_complexos/Willow2.png"));
      Willow3 = ImageIO
          .read(new File("resources/map_swamp/obstaculos_complexos/Willow3.png"));
      Yellow_ruins1 = ImageIO
          .read(new File("resources/map_swamp/obstaculos_complexos/Yellow_ruins1.png"));
      spritesheetarvore1 = ImageIO
          .read(new File("resources/map_swamp/obstaculos_complexos/spritesheetarvore1.png"));
      spritesheetarvore2 = ImageIO
          .read(new File("resources/map_swamp/obstaculos_complexos/spritesheetarvore2.png"));
      spritesheetarvore3 = ImageIO
          .read(new File("resources/map_swamp/obstaculos_complexos/spritesheetarvore3.png"));
      spriteshetlago1 = ImageIO
          .read(new File("resources/map_swamp/obstaculos_complexos/spriteshetlago1.png"));
      spritsheethomemcristal = ImageIO
          .read(new File("resources/map_swamp/obstaculos_complexos/spritsheethomemcristal.png"));
    } catch (IOException ex) {
      ex.printStackTrace();
    }

  }

  public static void posicoesDeco(int FrameWidth, int FrameHeight, int ALL_DOTS_Width, int ALL_DOTS_Height,
      ArrayList<Integer> walls_x,
      ArrayList<Integer> walls_y) {
    int PorcentagemX = (10 * FrameWidth) / 100;
    int PorcentagemY = (10 * FrameWidth) / 100;
    int PorcentagemCOMX = (10 * FrameWidth) / 100;
    int PorcentagemCOMY = (10 * FrameWidth) / 100;
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
      valueDecoComplexo = 32;
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
      Game.quantiComplexo.add(1);
    }

    for (int i = 0; i < Game.quantiComplexo.size(); i++) {
      Game.ValueFinal += Game.quantiComplexo.get(i);
    }

    if (Game.DecoracaoX != null && Game.DecoracaoY != null && Game.DecoComplexoX != null
        && Game.DecoComplexoY != null) {
      Game.DecoracaoX = new int[Game.ValueDecoNormal];
      Game.DecoracaoY = new int[Game.ValueDecoNormal];
      Game.DecoComplexoX = new int[Game.ValueFinal];
      Game.DecoComplexoY = new int[Game.ValueFinal];

      for (int i = 0; i < Game.ValueFinal; i++) {
        int x, y;
        int x1, y1;
        do {
          x = (int) (Math.random() * (FrameWidth - PorcentagemX)) + 50;
          y = (int) (Math.random() * (FrameHeight - PorcentagemY)) + 50;
          x1 = (int) (Math.random() * (FrameWidth - PorcentagemCOMX)) + 70;
          y1 = (int) (Math.random() * (FrameHeight - PorcentagemCOMY)) + 70;
        } while (isWallPosition(x, y, walls_x, walls_y, x1, y1) || containsPosition(x, y, Game.DecoracaoX,
            Game.DecoracaoY, x1, y1, Game.DecoComplexoX, Game.DecoComplexoY));
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
    Rectangle imageRectComplexa = new Rectangle(x1, y1, 150, 150);
    for (int i = 0; i < walls_x.size(); i++) {
      Rectangle wallRect = new Rectangle(walls_x.get(i), walls_y.get(i), 10, 10);
      if (imageRect.intersects(wallRect) || imageRectComplexa.intersects(wallRect)) {
        return true;
      }
    }
    return false;
  }

  static Rectangle otherRect;
  static Rectangle otherRectComplexa;

  private static boolean containsPosition(int x, int y, int[] DecoracaoX, int[] DecoracaoY, int x1,
      int y1, int[] DecoComplexoX, int[] DecoComplexoY) {
    Rectangle imageRect = new Rectangle(x, y, 30, 30); // tamanho da imagem decorativa
    Rectangle imageRectComplexa = new Rectangle(x1, y1, 120, 120);
    for (int i = 0; i < Game.ValueFinal; i++) {
      if (i < DecoComplexoY.length && i < DecoComplexoY.length) {
        if (i < Game.ValueDecoNormal) {
          otherRect = new Rectangle(DecoracaoX[i], DecoracaoY[i], 30, 30);
        }

        otherRectComplexa = new Rectangle(DecoComplexoX[i], DecoComplexoY[i], 120, 120);
      }
      if (imageRect.intersects(otherRect)) {
        return true;
      } else if (imageRect.intersects(otherRectComplexa)) {
        return true;
      } else if (imageRectComplexa.intersects(otherRectComplexa)) {
        return true;
      } else if (imageRectComplexa.intersects(otherRect)) {
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
  //
  public static Graphics2D ImagemArvore1;
  public static Graphics2D ImagemArvore2;
  public static Graphics2D ImagemArvore3;

  public static int numFramesXArv = 6; // Ajuste conforme necessário
  public static int numFramesYArv = 1; // Supondo que todas as animações estão na mesma linha
  public static int frameWidthArv = 500; // Largura do frame redimensionado
  public static int frameHeightArv = 500; // Altura do frame redimensionado
  private static int frameIntervalArv = 100;
  private static int frameIntervalArv1 = 100;
  private static int frameIntervalArv2 = 100;

  public static int totalFramesArv = numFramesXArv * numFramesYArv;

  public static long currentTimeArv = System.currentTimeMillis();
  public static long currentTimeArv1 = System.currentTimeMillis();
  public static long currentTimeArv2 = System.currentTimeMillis();

  private static long lastFrameTimeArv = 0;
  private static long lastFrameTimeArv1 = 0;
  private static long lastFrameTimeArv2 = 0;

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
    for (int i = 0; i < Game.quantiComplexo.size(); i++) {
      if (Game.quantiComplexo.get(i) > 0) {
        switch (i) {
          case 0:
            if (Game.DecoComplexoX.length > 1 && Game.DecoComplexoY.length > 1) {

              imagens.add(new Imagem(aglomerado_cogubranco, Game.DecoComplexoX[1],
                  Game.DecoComplexoY[1], 38, 49));
            }
            break;
          case 1:
            if (Game.DecoComplexoX.length > 2 && Game.DecoComplexoY.length > 2) {

              imagens.add(new Imagem(aglomerado_coguroxo, Game.DecoComplexoX[2],
                  Game.DecoComplexoY[2], 47, 45));
            }
            break;
          case 2:
            if (Game.DecoComplexoX.length > 3 && Game.DecoComplexoY.length > 3) {

              imagens.add(new Imagem(Blue_green_balls_tree1, Game.DecoComplexoX[3],
                  Game.DecoComplexoY[3], 50, 64));
            }
            break;
          case 3:
            if (Game.DecoComplexoX.length > 4 && Game.DecoComplexoY.length > 4) {

              imagens.add(
                  new Imagem(Brown_ruins1, Game.DecoComplexoX[4], Game.DecoComplexoY[4], 112,
                      112));
            }
            break;
          case 4:
            if (Game.DecoComplexoX.length > 5 && Game.DecoComplexoY.length > 5) {

              imagens.add(
                  new Imagem(cemiterio, Game.DecoComplexoX[5], Game.DecoComplexoY[5], 99, 83));
            }
            break;
          case 5:
            if (Game.DecoComplexoX.length > 6 && Game.DecoComplexoY.length > 6) {

              imagens.add(new Imagem(Yellow_ruins1,
                  Game.DecoComplexoX[6],
                  Game.DecoComplexoY[6], 112, 112));
            }

            break;
          case 6:
            if (Game.DecoComplexoX.length > 7 && Game.DecoComplexoY.length > 7) {
              imagens.add(
                  new Imagem(Rock_statue_deer_ground_shadow,
                      Game.DecoComplexoX[7],
                      Game.DecoComplexoY[7], 94, 94));
            }
            break;
          case 7:
            if (Game.DecoComplexoX.length > 8 && Game.DecoComplexoY.length > 8) {
              imagens
                  .add(new Imagem(SwamppObjectsTopDownPixelArt2,
                      Game.DecoComplexoX[8],
                      Game.DecoComplexoY[8], 50,
                      60));
            }
            break;
          case 8:
            if (Game.DecoComplexoX.length > 9 && Game.DecoComplexoY.length > 9) {

              imagens
                  .add(new Imagem(SwampObjectsTopDownPixelArt3,
                      Game.DecoComplexoX[9],
                      Game.DecoComplexoY[9], 98, 123));
            }
            break;
          case 9:
            if (Game.DecoComplexoX.length > 10 && Game.DecoComplexoY.length > 10) {

              imagens
                  .add(new Imagem(SwampObjectsTopDownPixelArt4,
                      Game.DecoComplexoX[10],
                      Game.DecoComplexoY[10], 63, 52));
            }
            break;
          case 10:
            if (Game.DecoComplexoX.length > 11 && Game.DecoComplexoY.length > 11) {

              imagens.add(new Imagem(Mega_tree2,
                  Game.DecoComplexoX[11],
                  Game.DecoComplexoY[11], 123, 123));
            }

            break;
          case 11:
            if (Game.DecoComplexoX.length > 12 && Game.DecoComplexoY.length > 12) {
            }
            imagens
                .add(
                    new Imagem(SwampTopDownTilesetPixelArt3,
                        Game.DecoComplexoX[12],
                        Game.DecoComplexoY[12], 81, 91));
            break;
          case 12:
            if (Game.DecoComplexoX.length > 13 && Game.DecoComplexoY.length > 13) {
            }
            imagens.add(
                new Imagem(SwampTopDownTilesetPixelArt31,
                    Game.DecoComplexoX[13],
                    Game.DecoComplexoY[13], 32, 49));
            break;
          case 13:
            if (Game.DecoComplexoX.length > 14 && Game.DecoComplexoY.length > 14) {
              imagens.add(
                  new Imagem(SwampTopDownTilesetPixelArt32,
                      Game.DecoComplexoX[14],
                      Game.DecoComplexoY[14], 81, 131));
            }

            break;
          case 14:
            if (Game.DecoComplexoX.length > 15 && Game.DecoComplexoY.length > 5) {
            }
            imagens.add(
                new Imagem(SwampTopDownTilesetPixelArt33,
                    Game.DecoComplexoX[15],
                    Game.DecoComplexoY[15], 68, 67));
            break;
          case 15:
            if (Game.DecoComplexoX.length > 16 && Game.DecoComplexoY.length > 16) {
            }
            imagens
                .add(new Imagem(SwampTopDownTilesetPixelArt34,
                    Game.DecoComplexoX[16],
                    Game.DecoComplexoY[16], 49,
                    60));
            break;
          case 16:
            if (Game.DecoComplexoX.length > 17 && Game.DecoComplexoY.length > 17) {
              imagens
                  .add(new Imagem(SwampTopDownTilesetPixelArt35,
                      Game.DecoComplexoX[17],
                      Game.DecoComplexoY[17], 62,
                      81));
            }
            break;
          case 17:
            if (Game.DecoComplexoX.length > 18 && Game.DecoComplexoY.length > 18) {
              imagens
                  .add(new Imagem(SwampTopDownTilesetPixelArt36, Game.DecoComplexoX[18],
                      Game.DecoComplexoY[18], 32,
                      56));
            }
            break;
          case 18:
            if (Game.DecoComplexoX.length > 19 && Game.DecoComplexoY.length > 19) {
              imagens
                  .add(new Imagem(SwampTopDownTilesetPixelArt42,
                      Game.DecoComplexoX[19],
                      Game.DecoComplexoY[19], 77,
                      44));
            }
            break;
          case 19:
            if (Game.DecoComplexoX.length > 20 && Game.DecoComplexoY.length > 20) {
              imagens.add(new Imagem(Luminous_tree3,
                  Game.DecoComplexoX[20],
                  Game.DecoComplexoY[20], 63, 85));
            }
            break;
          case 20:
            if (Game.DecoComplexoX.length > 21 && Game.DecoComplexoY.length > 21) {

              imagens.add(new Imagem(Luminous_tree2,
                  Game.DecoComplexoX[21],
                  Game.DecoComplexoY[21], 64, 83));
            }

            break;
          case 21:
            if (Game.DecoComplexoX.length > 22 && Game.DecoComplexoY.length > 22) {
              imagens.add(new Imagem(Willow1,
                  Game.DecoComplexoX[22],
                  Game.DecoComplexoY[22], 79, 81));
            }
            break;
          case 22:
            if (Game.DecoComplexoX.length > 23 && Game.DecoComplexoY.length > 23) {
              imagens.add(new Imagem(Willow2, Game.DecoComplexoX[23],
                  Game.DecoComplexoY[23], 67, 75));
            }
            break;
          case 23:
            if (Game.DecoComplexoX.length > 24 && Game.DecoComplexoY.length > 24) {
              imagens.add(new Imagem(Willow3, Game.DecoComplexoX[24],
                  Game.DecoComplexoY[24], 63, 64));
            }
            break;
          case 24:
            if (Game.DecoComplexoX.length > 25 && Game.DecoComplexoY.length > 25) {

              imagens.add(
                  new Imagem(Luminous_tree1, Game.DecoComplexoX[25], Game.DecoComplexoY[25],
                      70,
                      93));
            }
            break;
          case 25:
            if (Game.DecoComplexoX.length > 26 && Game.DecoComplexoY.length > 26) {
              BufferedImage arvore1 = (BufferedImage) spritesheetarvore1;
              int sx1 = (Game.currentFrame11 % numFramesXArv) * (arvore1.getWidth() /
                  numFramesXArv);
              int sy1 = (Game.currentFrame11 / numFramesXArv) * (arvore1.getHeight() /
                  numFramesYArv);
              int sw1 = arvore1.getWidth() / numFramesXArv;
              int sh1 = arvore1.getHeight() / numFramesYArv;
              ImagemArvore1 = buffer.createGraphics();
              AffineTransform at1 = new AffineTransform();
              at1.scale((double) (66 + 2) / sw1, (double) (65 + 2) / sh1);
              // Create an AffineTransformOp object with the AffineTransform
              AffineTransformOp op1 = new AffineTransformOp(at1,
                  AffineTransformOp.TYPE_BILINEAR);
              // Apply the transform to the image
              BufferedImage scaledImage1 = op1.filter(arvore1.getSubimage(sx1, sy1, sw1,
                  sh1),
                  null);
              ImagemArvore1.drawImage(scaledImage1, Game.DecoComplexoX[26],
                  Game.DecoComplexoY[26], null);
              long currentTimeArv = System.currentTimeMillis();

              if (currentTimeArv - lastFrameTimeArv >= frameIntervalArv) {
                lastFrameTimeArv = currentTimeArv - (currentTimeArv %
                    frameIntervalArv);
                Game.currentFrame11 = (Game.currentFrame11 + 1) % totalFramesArv;
              }
            }
            break;
          case 26:
            if (Game.DecoComplexoX.length > 27 && Game.DecoComplexoY.length > 27) {
              BufferedImage arvore1 = (BufferedImage) spritesheetarvore2;
              int sx1 = (Game.currentFrame12 % numFramesXArv) * (arvore1.getWidth() /
                  numFramesXArv);
              int sy1 = (Game.currentFrame12 / numFramesXArv) * (arvore1.getHeight() /
                  numFramesYArv);
              int sw1 = arvore1.getWidth() / numFramesXArv;
              int sh1 = arvore1.getHeight() / numFramesYArv;
              ImagemArvore2 = buffer.createGraphics();
              AffineTransform at1 = new AffineTransform();
              at1.scale((double) (80 + 2) / sw1, (double) (96 + 2) / sh1);
              // Create an AffineTransformOp object with the AffineTransform
              AffineTransformOp op1 = new AffineTransformOp(at1,
                  AffineTransformOp.TYPE_BILINEAR);
              // Apply the transform to the image
              BufferedImage scaledImage1 = op1.filter(arvore1.getSubimage(sx1, sy1, sw1,
                  sh1),
                  null);
              ImagemArvore2.drawImage(scaledImage1,
                  Game.DecoComplexoX[27],
                  Game.DecoComplexoY[27], null);
              long currentTimeArv1 = System.currentTimeMillis();

              if (currentTimeArv1 - lastFrameTimeArv1 >= frameIntervalArv1) {
                lastFrameTimeArv1 = currentTimeArv1 - (currentTimeArv1 %
                    frameIntervalArv1);
                Game.currentFrame12 = (Game.currentFrame12 + 1) % totalFramesArv;
              }
            }
            break;
          case 27:
            if (Game.DecoComplexoX.length > 28 && Game.DecoComplexoY.length > 28) {
              BufferedImage arvore2 = (BufferedImage) spritesheetarvore3;
              int sx1 = (Game.currentFrame13 % numFramesXArv) * (arvore2.getWidth() /
                  numFramesXArv);
              int sy1 = (Game.currentFrame13 / numFramesXArv) * (arvore2.getHeight() /
                  numFramesYArv);
              int sw1 = arvore2.getWidth() / numFramesXArv;
              int sh1 = arvore2.getHeight() / numFramesYArv;
              ImagemArvore3 = buffer.createGraphics();
              AffineTransform at1 = new AffineTransform();
              at1.scale((double) (92 + 2) / sw1, (double) (128 + 2) / sh1);
              // Create an AffineTransformOp object with the AffineTransform
              AffineTransformOp op1 = new AffineTransformOp(at1,
                  AffineTransformOp.TYPE_BILINEAR);
              // Apply the transform to the image
              BufferedImage scaledImage1 = op1.filter(arvore2.getSubimage(sx1, sy1, sw1,
                  sh1),
                  null);
              ImagemArvore3.drawImage(scaledImage1,
                  Game.DecoComplexoX[28],
                  Game.DecoComplexoY[28], null);
              long currentTimeArv2 = System.currentTimeMillis();

              if (currentTimeArv2 - lastFrameTimeArv2 >= frameIntervalArv2) {
                lastFrameTimeArv2 = currentTimeArv2 - (currentTimeArv2 %
                    frameIntervalArv2);
                Game.currentFrame13 = (Game.currentFrame13 + 1) % totalFramesArv;
              }
            }
            break;
          case 28:
            //////
            break;
          case 29:
            //////
            break;
          case 30:
            //////
            break;
          default:
            break;
        }
      }
    }
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
