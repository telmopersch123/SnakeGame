import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

public class LocaleUtils {
  static boolean teste = false;
  static Rectangle Decoracao;
  static Rectangle DecoracaoCom;

  public static ArrayList<Point> LocateFood(int FrameWidth, int FrameHeight, int WIDTH, int HEIGHT,
      ArrayList<Integer> walls_x,
      ArrayList<Integer> walls_y, Node[] nodeSnake) {
    ArrayList<Point> foodPositions = new ArrayList<>();
    // Variáveis para armazenar a posição da comida
    int[] foodX = new int[3];
    int[] foodY = new int[3];
    WIDTH = 18;
    HEIGHT = 18;
    ArrayList<Integer> snake_x = new ArrayList<>();
    ArrayList<Integer> snake_y = new ArrayList<>();
    for (int i = 0; i < nodeSnake.length; i++) {
      snake_x.add(nodeSnake[i].x);
      snake_y.add(nodeSnake[i].y);
    }
    // Loop para continuar gerando novas posições para a comida até que ela não
    // esteja dentro ou muito próxima das paredes
    boolean tooCloseToWall;

    do {
      tooCloseToWall = false; // Define como falso para cada iteração
      // Gera uma posição aleatória para a comida dentro da área do jogo
      foodX[0] = (int) (Math.random() * (FrameWidth - 100)) + 25;
      foodX[1] = (int) (Math.random() * (FrameWidth - 100)) + 25;
      foodX[2] = (int) (Math.random() * (FrameWidth - 100)) + 25;

      foodY[0] = (int) (Math.random() * (FrameHeight - 100)) + 25;
      foodY[1] = (int) (Math.random() * (FrameHeight - 100)) + 25;
      foodY[2] = (int) (Math.random() * (FrameHeight - 100)) + 25;
      for (int i = 0; i < nodeSnake.length; i++) {
        Rectangle SnakeRect = new Rectangle(snake_x.get(i), snake_y.get(i), WIDTH, HEIGHT);
        Rectangle foodRect1 = new Rectangle(foodX[0], foodY[0], WIDTH, HEIGHT);
        Rectangle foodRect2 = new Rectangle(foodX[1], foodY[1], 25, 25);
        Rectangle foodRect3 = new Rectangle(foodX[2], foodY[2], 25, 25);

        if (foodRect1.intersects(SnakeRect) || foodRect2.intersects(SnakeRect)
            || foodRect3.intersects(SnakeRect)) {
          tooCloseToWall = true;
          break;
        }
      }
      /////
      if (Game.DecoracaoX != null && Game.DecoracaoY != null && Game.DecoComplexoX != null
          && Game.DecoComplexoY != null && Game.quantiComplexo != null) {
        for (int i = 0; i < Game.ValueFinal; i++) {
          if (i < Game.ValueDecoNormal) {
            if (i < Game.DecoracaoX.length && i < Game.DecoracaoY.length) {
              Decoracao = new Rectangle(Game.DecoracaoX[i],
                  Game.DecoracaoY[i], 50, 50);
            }
          }
          if (i < Game.DecoComplexoX.length && i < Game.DecoComplexoY.length) {
            DecoracaoCom = new Rectangle(Game.DecoComplexoX[i],
                Game.DecoComplexoY[i], 132, 132);
          }
          Rectangle foodRect1 = new Rectangle(foodX[0], foodY[0], WIDTH, HEIGHT);
          Rectangle foodRect2 = new Rectangle(foodX[1], foodY[1], 30, 50);
          Rectangle foodRect3 = new Rectangle(foodX[2], foodY[2], 30, 30);
          if (foodRect1.intersects(Decoracao) || foodRect1.contains(Decoracao) ||
              foodRect2.intersects(Decoracao) || foodRect2.contains(Decoracao) ||
              foodRect3.intersects(Decoracao) || foodRect3.contains(Decoracao)) {
            tooCloseToWall = true;
            break; // Interrompe o loop assim que uma decoração próxima é encontrada
          }
          if (foodRect1.intersects(DecoracaoCom) || foodRect1.contains(DecoracaoCom) ||
              foodRect2.intersects(DecoracaoCom) || foodRect2.contains(DecoracaoCom) ||
              foodRect3.intersects(DecoracaoCom) || foodRect3.contains(DecoracaoCom)) {
            tooCloseToWall = true;
            break; // Interrompe o loop assim que uma decoração próxima é encontrada
          }
        }
      }
      ///////
      // Verifica se a comida está dentro ou muito próxima de alguma parede
      for (int i = 0; i < walls_x.size(); i++) {
        // Cria um retângulo para representar a parede atual
        Rectangle wallRect = new Rectangle(walls_x.get(i), walls_y.get(i), WIDTH, HEIGHT);
        Rectangle foodRect1 = new Rectangle(foodX[0], foodY[0], WIDTH, HEIGHT);
        Rectangle foodRect2 = new Rectangle(foodX[1], foodY[1], 30, 50);
        Rectangle foodRect3 = new Rectangle(foodX[2], foodY[2], 30, 30);
        if (foodRect1.intersects(wallRect) || foodRect1.contains(wallRect) ||
            foodRect2.intersects(wallRect) || foodRect2.contains(wallRect) ||
            foodRect3.intersects(wallRect) || foodRect3.contains(wallRect)) {
          tooCloseToWall = true;
          break; // Interrompe o loop assim que uma parede próxima é encontrada
        }
      }
      if (!tooCloseToWall) {
        foodPositions.add(new Point(foodX[0], foodY[0]));
        foodPositions.add(new Point(foodX[1], foodY[1]));
        foodPositions.add(new Point(foodX[2], foodY[2]));
      }
      // Repete o loop se a comida estiver muito próxima de alguma parede
    } while (tooCloseToWall);
    return foodPositions;
    // Define as coordenadas da comida com as coordenadas válidas geradas acima
  }

  public static ArrayList<ArrayList<Integer>> LocateWall(int FrameWidth, int FrameHeight, int WIDTH, int HEIGHT,
      int numWalls) {
    ArrayList<Integer> walls_x = new ArrayList<>();
    ArrayList<Integer> walls_y = new ArrayList<>();

    for (int k = 0; k < numWalls; k++) {
      // Define as dimensões do quadrado ou retângulo perfeito
      int wallWidth = (int) (Math.random() * 4) + 1; // Largura aleatória entre 5 e 14
      int wallHeight = (int) (Math.random() * 2) + 1; // Altura aleatória entre 3 e 7

      // Define a posição inicial do quadrado ou retângulo
      int startX = (int) (Math.random() * (FrameWidth - wallWidth * WIDTH));
      int startY = (int) (Math.random() * (FrameHeight - wallHeight * HEIGHT));

      // Adiciona os pontos do quadrado ou retângulo à lista de paredes
      for (int i = startX; i < startX + wallWidth * WIDTH; i += WIDTH) {
        for (int j = startY; j < startY + wallHeight * HEIGHT; j += HEIGHT) {
          walls_x.add(i);
          walls_y.add(j);
        }
      }

      // Adiciona falhas aleatórias sobre o quadrado ou retângulo
      for (int i = 0; i < 20 * (wallWidth + wallHeight); i++) {
        int randomX = startX - 2 * WIDTH + (int) (Math.random() * (wallWidth * WIDTH + 4 * WIDTH));
        int randomY = startY - 2 * HEIGHT + (int) (Math.random() * (wallHeight * HEIGHT + 4 * HEIGHT));
        walls_x.add(randomX);
        walls_y.add(randomY);
      }
    }

    ArrayList<ArrayList<Integer>> walls = new ArrayList<>();
    walls.add(walls_x);
    walls.add(walls_y);

    return walls;
  }
}
