import java.awt.Rectangle;
import java.util.ArrayList;

// 1 PROBLEMA - POSIÇÕES DE COLISÃO AONDE TEM NADA
// 2 PROBLEMA - NASCENDO AINDA FIGURA UMA NA POSIÇÃO DA OUTRA, TALVEZ TÁ, E NAS PAREDES TAMBÉM, ANALISAR OQUE PDOE SER
// 3 PROBLEMA - ORDEM DE DESENHAMENTO ESTRANHO, PEDRA EM CIMA DO MOINHO?
public class checkedColisson {
  public static Rectangle DecoCOMPLEXAChristmas;
  public static Rectangle casadamonga;
  public static Rectangle sprite_sheet_placa;
  public static Rectangle sprite_sheet_moinho;
  public static Rectangle Brown_gray_ruins1;
  public static Rectangle Brown_gray_ruins3;
  public static Rectangle dragao_rock;
  public static Rectangle Glade_Objects_Top_Down_Pixel_Art44;
  public static Rectangle Glade_ObjectssArt6;
  public static Rectangle Glade_ObjectsArt3_2;
  public static Rectangle Glade_ObjectsArt3;
  public static Rectangle DecoCOMPLEXATree2;
  public static Rectangle headCollisionAreaDeco;
  //
  private static Rectangle aglomerado_cogubranco;
  private static Rectangle aglomerado_coguroxo;
  private static Rectangle Blue_green_balls_tree1;
  private static Rectangle Brown_ruins1;
  private static Rectangle cemiterio;
  private static Rectangle Luminous_tree1;
  private static Rectangle Luminous_tree2;
  private static Rectangle Mega_tree2;
  private static Rectangle SwampObjectsTopDownPixelArt3;
  private static Rectangle SwampObjectsTopDownPixelArt4;
  private static Rectangle SwamppObjectsTopDownPixelArt2;
  private static Rectangle SwampTopDownTilesetPixelArt3;
  private static Rectangle SwampTopDownTilesetPixelArt31;
  private static Rectangle SwampTopDownTilesetPixelArt32;
  private static Rectangle SwampTopDownTilesetPixelArt33;
  private static Rectangle SwampTopDownTilesetPixelArt34;
  private static Rectangle SwampTopDownTilesetPixelArt35;
  private static Rectangle SwampTopDownTilesetPixelArt36;
  private static Rectangle SwampTopDownTilesetPixelArt42;
  private static Rectangle Luminous_tree3;
  private static Rectangle Rock_statue_deer_ground_shadow;
  private static Rectangle Willow1;
  private static Rectangle Willow2;
  private static Rectangle Willow3;
  private static Rectangle Yellow_ruins1;
  private static Rectangle spritesheetarvore1;

  public static ResultadoColisao verificarColisao(boolean gameOver, int WIDTH, int HEIGHT, int FrameWidth,
      int FrameHeight,
      ArrayList<Integer> walls_x, ArrayList<Integer> walls_y, Node[] nodeSnake,
      int largerCollisionArea, Rectangle headCollisionArea, boolean poisonDeathAnimationPlaying,
      int borderWidth, int getWidth, int getHeight) {

    if (nodeSnake.length < 30) {
      return new ResultadoColisao(true, true);
    }

    if (colisaoPainel(nodeSnake, borderWidth, getWidth, getHeight)) {
      return new ResultadoColisao(true, false);
    }

    if (colisaoCobra(nodeSnake)) {
      return new ResultadoColisao(true, false);
    }

    if (Game.MapField) {
      if (colisaoDecoField(nodeSnake, largerCollisionArea)) {
        return new ResultadoColisao(true, false);
      }
      if (colisaoParede(nodeSnake, walls_x, walls_y, largerCollisionArea)) {
        return new ResultadoColisao(true, false);
      }
    } else if (Game.MapSwamp) {
      if (colisaoDecoSwamp(nodeSnake, largerCollisionArea)) {
        return new ResultadoColisao(true, false);
      }
    }

    return new ResultadoColisao(gameOver, poisonDeathAnimationPlaying);
  }

  private static boolean colisaoPainel(Node[] nodeSnake, int borderWidth, int getWidth, int getHeight) {
    return (nodeSnake[0].y <= borderWidth || nodeSnake[0].y >= getHeight - 30 ||
        nodeSnake[0].x <= borderWidth || nodeSnake[0].x >= getWidth - 30);
  }

  private static boolean colisaoCobra(Node[] nodeSnake) {
    for (int i = 1; i < nodeSnake.length; i++) {
      if (nodeSnake[0].x == nodeSnake[i].x && nodeSnake[0].y == nodeSnake[i].y) {
        return true;
      }
    }
    return false;
  }

  private static boolean colisaoDecoField(Node[] nodeSnake, int largerCollisionArea) {
    headCollisionAreaDeco = new Rectangle(nodeSnake[0].x, nodeSnake[0].y, 15, 15);
    if (Game.DecoracaoX != null && Game.DecoracaoY != null && Game.DecoComplexoX != null
        && Game.DecoComplexoY != null && Game.quantiComplexo != null) {
      for (int i = 0; i < Game.DecoracaoX.length; i++) {
        Rectangle Decoracao = new Rectangle(Game.DecoracaoX[i], Game.DecoracaoY[i],
            30, 30);
        if (headCollisionAreaDeco.intersects(Decoracao)) {
          return true;
        }
      }
      for (int i = 0; i < Game.quantiComplexo.size(); i++) {
        if (Game.quantiComplexo.get(i) > 0) {
          switch (i) {
            case 0:
              DecoCOMPLEXAChristmas = new Rectangle(Game.DecoComplexoX[1] + 10,
                  Game.DecoComplexoY[1] + 45, 40, 10);
              if (headCollisionAreaDeco.intersects(DecoCOMPLEXAChristmas)) {
                return true;
              }
              break;
            case 1:
              DecoCOMPLEXATree2 = new Rectangle(Game.DecoComplexoX[2] + 10,
                  Game.DecoComplexoY[2] + 45, 40, 10);
              if (headCollisionAreaDeco.intersects(DecoCOMPLEXATree2)) {
                return true;
              }
              break;
            case 2:
              Glade_ObjectsArt3 = new Rectangle(Game.DecoComplexoX[3] + 10,
                  Game.DecoComplexoY[3] + 50, 40, 10);
              if (headCollisionAreaDeco.intersects(Glade_ObjectsArt3)) {
                return true;
              }
              break;
            case 3:
              Glade_ObjectsArt3_2 = new Rectangle(Game.DecoComplexoX[4] + 35,
                  Game.DecoComplexoY[4] + 75, 40, 10);
              if (headCollisionAreaDeco.intersects(Glade_ObjectsArt3_2)) {
                return true;
              }
              break;
            case 4:
              Glade_ObjectssArt6 = new Rectangle(Game.DecoComplexoX[5] + 22,
                  Game.DecoComplexoY[5] + 50, 10, 10);
              if (headCollisionAreaDeco.intersects(Glade_ObjectssArt6)) {
                return true;
              }
              break;
            case 5:
              Glade_Objects_Top_Down_Pixel_Art44 = new Rectangle(Game.DecoComplexoX[6] + 10,
                  Game.DecoComplexoY[6] + 40, 50, 50);
              if (headCollisionAreaDeco.intersects(Glade_Objects_Top_Down_Pixel_Art44)) {
                return true;
              }
              break;
            case 6:
              dragao_rock = new Rectangle(Game.DecoComplexoX[7] + 25,
                  Game.DecoComplexoY[7] + 15, 75, 85);
              if (headCollisionAreaDeco.intersects(dragao_rock)) {
                return true;
              }
              break;
            case 7:
              Brown_gray_ruins3 = new Rectangle(Game.DecoComplexoX[8],
                  Game.DecoComplexoY[8] + 25, 64, 40);
              if (headCollisionAreaDeco.intersects(Brown_gray_ruins3)) {
                return true;
              }
              break;
            case 8:
              Brown_gray_ruins1 = new Rectangle(Game.DecoComplexoX[9] + 10,
                  Game.DecoComplexoY[9] + 15, 100, 90);
              if (headCollisionAreaDeco.intersects(Brown_gray_ruins1)) {
                return true;
              }
              break;
            case 9:
              sprite_sheet_moinho = new Rectangle(Game.DecoComplexoX[10] + 35,
                  Game.DecoComplexoY[10] + 100, 40, 40);
              if (headCollisionAreaDeco.intersects(sprite_sheet_moinho)) {
                return true;
              }
              break;
            case 10:
              sprite_sheet_placa = new Rectangle(Game.DecoComplexoX[11] + 15,
                  Game.DecoComplexoY[11] + 50, 10, 10);
              if (headCollisionAreaDeco.intersects(sprite_sheet_placa)) {
                return true;
              }
              break;
            case 11:
              casadamonga = new Rectangle(Game.DecoComplexoX[12],
                  Game.DecoComplexoY[12] + 10, 100, 67);
              if (headCollisionAreaDeco.intersects(casadamonga)) {
                return true;
              }
              break;
            default:
              break;
          }
        }
      }
    }

    return false;
  }

  private static boolean colisaoDecoSwamp(Node[] nodeSnake, int largerCollisionArea) {
    headCollisionAreaDeco = new Rectangle(nodeSnake[0].x, nodeSnake[0].y, 15, 15);
    if (Game.DecoracaoX != null && Game.DecoracaoY != null && Game.DecoComplexoX != null
        && Game.DecoComplexoY != null && Game.quantiComplexo != null) {
      for (int i = 0; i < Game.DecoracaoX.length; i++) {
        Rectangle Decoracao = new Rectangle(Game.DecoracaoX[i], Game.DecoracaoY[i],
            30, 30);
        if (headCollisionAreaDeco.intersects(Decoracao)) {
          return true;
        }
      }
    }
    for (int i = 0; i < Game.quantiComplexo.size(); i++) {
      if (Game.quantiComplexo.get(i) > 0) {
        switch (i) {
          case 0:
            if (Game.DecoComplexoX.length > 1 && Game.DecoComplexoY.length > 1) {
              aglomerado_cogubranco = new Rectangle(Game.DecoComplexoX[1] + 10,
                  Game.DecoComplexoY[1] + 20, 28, 29);
              if (headCollisionAreaDeco.intersects(aglomerado_cogubranco)) {
                return true;
              }
            }
            break;
          case 1:
            if (Game.DecoComplexoX.length > 2 && Game.DecoComplexoY.length > 2) {
              aglomerado_coguroxo = new Rectangle(Game.DecoComplexoX[2] + 7,
                  Game.DecoComplexoY[2] + 10, 40, 35);
              if (headCollisionAreaDeco.intersects(aglomerado_coguroxo)) {
                return true;
              }
            }
            break;
          case 2:
            if (Game.DecoComplexoX.length > 3 && Game.DecoComplexoY.length > 3) {
              Blue_green_balls_tree1 = new Rectangle(Game.DecoComplexoX[3] + 10,
                  Game.DecoComplexoY[3] + 20, 35, 45);
              if (headCollisionAreaDeco.intersects(Blue_green_balls_tree1)) {
                return true;
              }
            }
            break;
          case 3:
            if (Game.DecoComplexoX.length > 4 && Game.DecoComplexoY.length > 4) {
              Brown_ruins1 = new Rectangle(Game.DecoComplexoX[4],
                  Game.DecoComplexoY[4] + 50, 100, 60);
              if (headCollisionAreaDeco.intersects(Brown_ruins1)) {
                return true;
              }
            }
            break;
          case 4:
            if (Game.DecoComplexoX.length > 5 && Game.DecoComplexoY.length > 5) {
              cemiterio = new Rectangle(Game.DecoComplexoX[5] + 15,
                  Game.DecoComplexoY[5] + 15, 73, 55);
              if (headCollisionAreaDeco.intersects(cemiterio)) {
                return true;
              }
            }
            break;
          case 5:
            if (Game.DecoComplexoX.length > 6 && Game.DecoComplexoY.length > 6) {

              Yellow_ruins1 = new Rectangle(Game.DecoComplexoX[6] + 12,
                  Game.DecoComplexoY[6] + 37, 80, 60);
              if (headCollisionAreaDeco.intersects(Yellow_ruins1)) {
                return true;
              }
            }

            break;
          case 6:
            if (Game.DecoComplexoX.length > 7 && Game.DecoComplexoY.length > 7) {

              Rock_statue_deer_ground_shadow = new Rectangle(Game.DecoComplexoX[7] + 30,
                  Game.DecoComplexoY[7] + 60, 40, 30);
              if (headCollisionAreaDeco.intersects(Rock_statue_deer_ground_shadow)) {
                return true;
              }
            }

            break;
          case 7:
            if (Game.DecoComplexoX.length > 18 && Game.DecoComplexoY.length > 8) {
              SwamppObjectsTopDownPixelArt2 = new Rectangle(Game.DecoComplexoX[8] + 5,
                  Game.DecoComplexoY[8] + 30, 45, 30);
              if (headCollisionAreaDeco.intersects(SwamppObjectsTopDownPixelArt2)) {
                return true;
              }
            }

            break;
          case 8:
            if (Game.DecoComplexoX.length > 9 && Game.DecoComplexoY.length > 9) {
              SwampObjectsTopDownPixelArt3 = new Rectangle(Game.DecoComplexoX[9] + 25,
                  Game.DecoComplexoY[9] + 95, 60, 25);
              if (headCollisionAreaDeco.intersects(SwampObjectsTopDownPixelArt3)) {
                return true;
              }
            }
            break;
          case 9:
            if (Game.DecoComplexoX.length > 10 && Game.DecoComplexoY.length > 10) {
              SwampObjectsTopDownPixelArt4 = new Rectangle(Game.DecoComplexoX[10] + 8,
                  Game.DecoComplexoY[10] + 40, 58, 15);
              if (headCollisionAreaDeco.intersects(SwampObjectsTopDownPixelArt4)) {
                return true;
              }
            }
            break;
          case 10:
            if (Game.DecoComplexoX.length > 11 && Game.DecoComplexoY.length > 11) {
              Mega_tree2 = new Rectangle(Game.DecoComplexoX[11] + 25,
                  Game.DecoComplexoY[11] + 60, 60, 48);
              if (headCollisionAreaDeco.intersects(Mega_tree2)) {
                return true;
              }
            }
            break;
          case 11:
            if (Game.DecoComplexoX.length > 12 && Game.DecoComplexoY.length > 12) {

              SwampTopDownTilesetPixelArt3 = new Rectangle(Game.DecoComplexoX[12] + 25,
                  Game.DecoComplexoY[12] + 65, 45, 25);
              if (headCollisionAreaDeco.intersects(SwampTopDownTilesetPixelArt3)) {
                return true;
              }
            }
            break;
          case 12:
            if (Game.DecoComplexoX.length > 13 && Game.DecoComplexoY.length > 13) {

              SwampTopDownTilesetPixelArt31 = new Rectangle(Game.DecoComplexoX[13] + 6,
                  Game.DecoComplexoY[13] + 29, 25, 20);
              if (headCollisionAreaDeco.intersects(SwampTopDownTilesetPixelArt31)) {
                return true;
              }
            }
            break;
          case 13:
            if (Game.DecoComplexoX.length > 14 && Game.DecoComplexoY.length > 14) {

              SwampTopDownTilesetPixelArt32 = new Rectangle(Game.DecoComplexoX[14] + 20,
                  Game.DecoComplexoY[14] + 105, 40, 30);
              if (headCollisionAreaDeco.intersects(SwampTopDownTilesetPixelArt32)) {
                return true;
              }
            }
            break;
          case 14:
            if (Game.DecoComplexoX.length > 15 && Game.DecoComplexoY.length > 15) {

              SwampTopDownTilesetPixelArt33 = new Rectangle(Game.DecoComplexoX[15] + 35,
                  Game.DecoComplexoY[15] + 40, 30, 25);
              if (headCollisionAreaDeco.intersects(SwampTopDownTilesetPixelArt33)) {
                return true;
              }
            }
            break;
          case 15:
            if (Game.DecoComplexoX.length > 16 && Game.DecoComplexoY.length > 16) {

              SwampTopDownTilesetPixelArt34 = new Rectangle(Game.DecoComplexoX[16] + 15,
                  Game.DecoComplexoY[16] + 40, 20, 20);
              if (headCollisionAreaDeco.intersects(SwampTopDownTilesetPixelArt34)) {
                return true;
              }
            }
            break;
          case 16:
            if (Game.DecoComplexoX.length > 17 && Game.DecoComplexoY.length > 17) {

              SwampTopDownTilesetPixelArt35 = new Rectangle(Game.DecoComplexoX[17] + 10,
                  Game.DecoComplexoY[17] + 50, 45, 25);
              if (headCollisionAreaDeco.intersects(SwampTopDownTilesetPixelArt35)) {
                return true;
              }
            }
            break;
          case 17:
            if (Game.DecoComplexoX.length > 18 && Game.DecoComplexoY.length > 18) {

              SwampTopDownTilesetPixelArt36 = new Rectangle(Game.DecoComplexoX[18] + 5,
                  Game.DecoComplexoY[18] + 40, 20, 20);
              if (headCollisionAreaDeco.intersects(SwampTopDownTilesetPixelArt36)) {
                return true;
              }
            }
            break;
          case 18:
            if (Game.DecoComplexoX.length > 19 && Game.DecoComplexoY.length > 19) {

              SwampTopDownTilesetPixelArt42 = new Rectangle(Game.DecoComplexoX[19] + 5,
                  Game.DecoComplexoY[19] + 15, 60, 25);
              if (headCollisionAreaDeco.intersects(SwampTopDownTilesetPixelArt42)) {
                return true;
              }
            }
            break;
          case 19:
            if (Game.DecoComplexoX.length > 20 && Game.DecoComplexoY.length > 20) {

              Luminous_tree3 = new Rectangle(Game.DecoComplexoX[20] + 20,
                  Game.DecoComplexoY[20] + 60, 25, 30);
              if (headCollisionAreaDeco.intersects(Luminous_tree3)) {
                return true;
              }
            }
            break;
          case 20:
            if (Game.DecoComplexoX.length > 21 && Game.DecoComplexoY.length > 21) {
              Luminous_tree2 = new Rectangle(Game.DecoComplexoX[21] + 15,
                  Game.DecoComplexoY[21] + 60, 40, 25);
              if (headCollisionAreaDeco.intersects(Luminous_tree2)) {
                return true;
              }
            }
            break;
          case 21:
            if (Game.DecoComplexoX.length > 22 && Game.DecoComplexoY.length > 22) {

              Willow1 = new Rectangle(Game.DecoComplexoX[22] + 30,
                  Game.DecoComplexoY[22] + 50, 30, 30);
              if (headCollisionAreaDeco.intersects(Willow1)) {
                return true;
              }
            }
            break;
          case 22:
            if (Game.DecoComplexoX.length > 23 && Game.DecoComplexoY.length > 23) {

              Willow2 = new Rectangle(Game.DecoComplexoX[23] + 30,
                  Game.DecoComplexoY[23] + 55, 20, 25);
              if (headCollisionAreaDeco.intersects(Willow2)) {
                return true;
              }
            }
            break;
          case 23:
            if (Game.DecoComplexoX.length > 24 && Game.DecoComplexoY.length > 24) {

              Willow3 = new Rectangle(Game.DecoComplexoX[24] + 25,
                  Game.DecoComplexoY[24] + 45, 15, 20);
              if (headCollisionAreaDeco.intersects(Willow3)) {
                return true;
              }
            }
            break;
          case 24:
            if (Game.DecoComplexoX.length > 25 && Game.DecoComplexoY.length > 25) {
              Luminous_tree1 = new Rectangle(Game.DecoComplexoX[25] + 10,
                  Game.DecoComplexoY[25] + 70, 45, 30);
              if (headCollisionAreaDeco.intersects(Luminous_tree1)) {
                return true;
              }
            }
            break;
          case 25:
            if (Game.DecoComplexoX.length > 26 && Game.DecoComplexoY.length > 26) {
              spritesheetarvore1 = new Rectangle(Game.DecoComplexoX[26] + 5,
                  Game.DecoComplexoY[26] + 45, 40, 25);
              if (headCollisionAreaDeco.intersects(spritesheetarvore1)) {
                return true;
              }
            }
            break;
          default:
            break;
        }
      }
    }
    return false;
  }

  private static boolean colisaoParede(Node[] nodeSnake, ArrayList<Integer> walls_x, ArrayList<Integer> walls_y,
      int largerCollisionArea) {
    Rectangle headCollisionArea = new Rectangle(nodeSnake[0].x - largerCollisionArea / 2,
        nodeSnake[0].y - largerCollisionArea / 2,
        5 + largerCollisionArea, 5 + largerCollisionArea);

    for (int i = 0; i < walls_x.size(); i++) {
      Rectangle wallArea = new Rectangle(walls_x.get(i), walls_y.get(i), 15, 15);
      if (headCollisionArea.intersects(wallArea)) {
        return true;
      }
    }
    return false;
  }
}
