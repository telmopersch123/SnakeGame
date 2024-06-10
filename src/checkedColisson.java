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
