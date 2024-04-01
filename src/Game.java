import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel implements Runnable {
  int DISTANCE = 0;
  int WIDTH = 10;
  int HEIGHT = 10;
  int largerCollisionArea = 12;
  int FrameWidth = 550;
  int FrameHeight = 550;
  int ALL_DOTS = 600;
  int x[] = new int[ALL_DOTS];
  int y[] = new int[ALL_DOTS];
  Boolean[] Direcoes = new Boolean[4];
  Rectangle headCollisionArea;
  Rectangle headCollisionAreaPO;
  int quantidadeDeco = 0;
  int quantidadeDeco2 = 0;
  int[] randomX2 = new int[4];
  int[] randomY2 = new int[4];
  int[] randomX = new int[3];
  int[] randomY = new int[3];
  // SNAKES
  private Image snakeHead;
  private Image bodyStraight;
  private Image bodyCorner;
  private Image tailImage;

  // MAP - LAWN
  private Image gramSprit;
  private Image rockSprit;
  private Image DecoLawn01;
  private Image DecoLawn02;

  // FOODS
  private Image appleSprit;
  private Image applePoison;
  private Image appleEnergy;

  public static int poisonFruitWidthVen = 25; // Largura original da fruta envenenada
  public static int poisonFruitHeightVen = 50; // Altura original da fruta envenenada

  public static int poisonFruitWidthErn = 20;
  public static int poisonFruitHeightErn = 20;
  public static int poisonFruitWidthCla = 18;
  public static int poisonFruitHeightCla = 18;

  /// Animations
  private Image DeathPoison;
  private Image BeatEffect;
  Image EnergyAnimationBody;
  Image EnergyAnimationTail;
  Image EnergyAnimationFinal;
  Image ColidianEnergy;
  Image ColidianEnergyFood;
  Image ColidianPoisonFood;
  Image colidianClassic;
  private boolean VerificDistance = false;
  boolean gameOver = false;
  BufferedImage buffer; // Buffer for double buffering
  public ArrayList<Integer> walls_x = new ArrayList<>();
  public ArrayList<Integer> walls_y = new ArrayList<>();
  private MyKeyBoardListener keyListener;
  public int direction = KeyEvent.VK_RIGHT;
  public Node[] nodeSnake = new Node[40];
  public int score = 0;
  public int macaX = 0, macaY = 0;
  public int macaENX = 0, macaENY = 0;
  public int macaPOX = 0, macaPOY = 0;
  public int count = 0;

  ///
  private static boolean animationFinished = false;
  private boolean poisonDeathAnimationPlaying = false;

  public long lastVenomAnimationTime1 = System.currentTimeMillis();
  public long lastVenomAnimationTimeEnergy = System.currentTimeMillis();
  public long TeleportEnergyVerif = System.currentTimeMillis();
  public long ControlTimerVelocity = System.currentTimeMillis();
  public long ajudantsClaTimer = System.currentTimeMillis();
  public long ControlAPOSSuporte = System.currentTimeMillis();
  public long ControlSpriteSheet = System.currentTimeMillis();
  public long ControlSpriteSheetColidion = System.currentTimeMillis();
  public boolean TimerVerif = false;
  public boolean ColidionEnergyCla = false;
  public boolean ColidionEnergyConfirmed = false;
  public static boolean colisionControlPoison = false;
  public static boolean colisionControlEnergy = false;
  public boolean venomAnimationPlayed = false;
  public boolean ernegyAnimationPlayed = false;
  public Timer timer = new Timer();
  public Timer timerEnergy = new Timer();
  public boolean timerCancelled = false;
  public boolean lit = false;
  // animation snake
  int segmentsToRemove = 0;
  int segmentsToRemoveTemporary = 0;
  public static int ControlVelocity = 700;
  private double rotationAngle = 0;
  static boolean poisonFruitAnimationRunning = false;
  public boolean Segunds = false;
  public boolean ControlTeleport = false;
  public boolean ControlColisionEnergy = false;
  public boolean VelocityControl = false;
  public static Timer poisonFruitAnimationTimer;
  public boolean colidionClaControlTimerAnimation = false;
  public static boolean colidionPoiControlTimerAnimation = false;
  public static boolean colidionEneControlTimerAnimation = false;
  public static boolean ColisionEnergy = false;
  public static boolean SpreetSheetInitial = false;
  public static boolean SpreetSheetFinale = false;
  public static boolean ControlAPOSColidionTimer = false;
  public static boolean ControlEnergyColidianBoolean = false;
  public static boolean ControEletriFinal = false;
  public static boolean ControlEnergy = false;
  public static int PosColidianEnergyX = 0;
  public static int PosColidianEnergyY = 0;
  public static int PosColidianPoisonX = 0;
  public static int PosColidianPoisonY = 0;
  public static int PosColidianClassicX = 0;
  public static int PosColidianClassicY = 0;
  public static int currentFrame9 = 0;
  public static int currentFrame8 = 0;
  public static int currentFrame7 = 0;
  public static int currentFrame6 = 0;
  public static int currentFrame5 = 0;
  public static int currentFrame4 = 0;
  public static int currentFrame3 = 0;
  public static int currentFrame2 = 0;
  public static int currentFrame1 = 0;
  public static boolean VerifiEnergyAnimation = false;
  public static boolean ControlOneAnimation = false;
  public static boolean ControlOneAnimationPoison = false;
  public static boolean ControlOneAnimationClassic = false;
  public static boolean ControlOneAnimationClassicAtivar = false;

  private void initializeKeyListener() {
    if (!gameOver) {
      keyListener = new MyKeyBoardListener(this, direction);
      this.addKeyListener(keyListener);
    }

  }

  public Game() {
    // Iniciar Imagens do JOGO
    Image[] imagens = loadImages.Images(WIDTH, HEIGHT);
    snakeHead = imagens[0];
    tailImage = imagens[1];
    bodyStraight = imagens[2];
    bodyCorner = imagens[3];
    gramSprit = imagens[4];
    rockSprit = imagens[5];
    appleSprit = imagens[6];
    DecoLawn01 = imagens[7];
    DecoLawn02 = imagens[8];
    applePoison = imagens[9];
    appleEnergy = imagens[10];
    DeathPoison = imagens[11];// Animation fruta venenada
    BeatEffect = imagens[12];// Animation Batida
    EnergyAnimationBody = imagens[13];
    EnergyAnimationTail = imagens[14];
    EnergyAnimationFinal = imagens[15];
    ColidianEnergy = imagens[16];
    ColidianEnergyFood = imagens[17];
    ColidianPoisonFood = imagens[18];
    colidianClassic = imagens[19];
    ///////////////////////////////////
    initializeKeyListener();
    Random random = new Random();
    quantidadeDeco = (int) (Math.random() * 3 + 1);
    quantidadeDeco2 = (int) (Math.random() * 4 + 1);
    for (int i = 0; i < quantidadeDeco; i++) {
      randomX[i] = random.nextInt(ALL_DOTS - 150);
      randomY[i] = random.nextInt(ALL_DOTS - 150);
    }

    for (int i = 0; i < quantidadeDeco2; i++) {
      randomX2[i] = random.nextInt(ALL_DOTS - 150);
      randomY2[i] = random.nextInt(ALL_DOTS - 150);
    }

    this.setPreferredSize(new Dimension(ALL_DOTS, ALL_DOTS));
    this.setFocusable(true);
    buffer = new BufferedImage(ALL_DOTS, ALL_DOTS, BufferedImage.TYPE_INT_ARGB); // Initialize buffer

    // iniciar a parede
    // ArrayList<ArrayList<Integer>> walls = LocaleUtils.LocateWall(FrameWidth,
    // FrameHeight, WIDTH, HEIGHT, 20);
    // walls_x = walls.get(0);
    // walls_y = walls.get(1);

    // iniciar a cobra
    StartSnake();

    headCollisionArea = new Rectangle(nodeSnake[0].x - largerCollisionArea / 2,
        nodeSnake[0].y - largerCollisionArea / 2,
        WIDTH + largerCollisionArea, HEIGHT + largerCollisionArea);

    // iniciar a comida

    ArrayList<Point> foodPositions = LocaleUtils.LocateFood(FrameWidth, FrameHeight, WIDTH, HEIGHT, walls_x, walls_y,
        nodeSnake);
    if (foodPositions.size() >= 2) {
      Point foodPosition0 = foodPositions.get(0);
      Point foodPosition1 = foodPositions.get(1);

      macaX = foodPosition0.x;
      macaY = foodPosition0.y;
      macaENX = -100;
      macaENY = -100;
      if (!TimerVerif) {
        macaPOX = -100;
        macaPOY = -100;
      } else if (TimerVerif) {
        macaPOX = foodPosition1.x;
        macaPOY = foodPosition1.y;

      }
    }

  }

  // Método principal para iniciar o jogo
  public static void main(String args[]) {
    Game game = new Game();
    JFrame frame = new JFrame("Snake");
    frame.add(game);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

    new Thread(game).start();
  }

  // Loop principal do jogo, onde a lógica e renderização são atualizadas
  public void drawCollisionAnimation(Graphics g, double rotationAngle) {
    if (nodeSnake.length > 0) { // Verifica se há algum nó no array
      int positionX = nodeSnake[0].x; // Coordenada X do primeiro nó
      int positionY = nodeSnake[0].y; // Coordenada Y do primeiro nó
      // Calcula as coordenadas de desenho para centralizar a animação em torno do nó
      int drawX = positionX - BeatEffect.getWidth(null) / 40 + 26; // Centraliza a imagem horizontalmente
      int drawY = positionY - BeatEffect.getHeight(null) / 40 / 40 + 5; // Centraliza a imagem verticalmente
      Animation.AnimationColidion(buffer, BeatEffect, rotationAngle, drawX, drawY);
    }
  }

  @Override
  public void run() {
    while (!gameOver) {

      if (VerificDistance) {
        VerificDistance = false;
      }
      tick();

      boolean[] collisionResult = checkedColisson.CheckedColisson(gameOver, WIDTH, HEIGHT, FrameWidth, FrameHeight,
          walls_x, walls_y, nodeSnake, largerCollisionArea, headCollisionArea, poisonDeathAnimationPlaying);
      gameOver = collisionResult[0];
      poisonDeathAnimationPlaying = collisionResult[1];
      repaint();
      try {
        Thread.sleep(ControlVelocity / 60);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    while (gameOver && !poisonDeathAnimationPlaying) {
      // Renderize a animação de colisão
      rotationAngle += 1;
      rotationAngle %= 360;
      if (keyListener != null) {
        this.removeKeyListener(keyListener);
      }
      // Renderiza a animação de colisão no buffer
      drawCollisionAnimation(buffer.getGraphics(), rotationAngle);

      // Renderiza o buffer na tela
      repaint();

      try {
        Thread.sleep(10); // Ajuste conforme necessário para a taxa de atualização da animação
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  // Método para desenhar os elementos do jogo na tela
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (buffer == null) {
      return;
    }

    // Desenha os elementos do jogo no buffer
    map.mapLawn(buffer, ALL_DOTS, gramSprit, DecoLawn01, DecoLawn02, randomX, randomY, quantidadeDeco, randomX2,
        randomY2, quantidadeDeco2);

    // Desenha a COBRA
    snake.snakePaint(nodeSnake, buffer, WIDTH, HEIGHT, bodyStraight, bodyCorner, tailImage, snakeHead, keyListener);

    // Desenha as animação do jogo
    if (!gameOver) {
      if (!animationFinished && poisonDeathAnimationPlaying) {
        int positionX = 0;
        int positionY = 0;
        for (int i = 0; i < nodeSnake.length; i++) {
          positionX = nodeSnake[0].x;
          positionY = nodeSnake[0].y;
        }

        if (!ControlOneAnimationPoison) {
          Animation.AnimationColidianPoisonFood(buffer, ColidianPoisonFood, nodeSnake, PosColidianPoisonX,
              PosColidianPoisonY);
        }
        animationFinished = Animation.AnimationPoisonDeath(buffer, DeathPoison, animationFinished, positionX,
            positionY, keyListener);
      }
      if (ControlEnergyColidianBoolean) {
        if (!ControlOneAnimation) {
          Animation.AnimationColidianEnergyFood(buffer, ColidianEnergyFood, nodeSnake, PosColidianEnergyX,
              PosColidianEnergyY);
        }
        Animation.AnimationColisionEnergy(this, buffer,
            ColidianEnergy,
            nodeSnake, PosColidianEnergyX, PosColidianEnergyY);
      }

    }
    if (SpreetSheetInitial) {
      Animation.AnimationEnergyTemporary(this, buffer,
          EnergyAnimationBody,
          EnergyAnimationTail, nodeSnake);
    } else if (!SpreetSheetInitial && SpreetSheetFinale) {

      Animation.AnimationEnergyTemporaryFinal(buffer, EnergyAnimationFinal, nodeSnake);

    }
    if (ControlOneAnimationClassicAtivar) {
      if (!ControlOneAnimationClassic) {
        Animation.AnimationColidianClassicFood(buffer, colidianClassic, nodeSnake,
            PosColidianClassicX, PosColidianClassicY);

      }
    }
    // Desenha a comidas
    food.classicFood(g, buffer, macaX, macaY, appleSprit, poisonFruitWidthCla, poisonFruitHeightCla);
    food.PoisonFood(g, buffer, macaPOX, macaPOY, applePoison, poisonFruitWidthVen, poisonFruitHeightVen);
    food.EnergyFood(this, g, buffer, macaENX, macaENY, appleEnergy,
        poisonFruitWidthErn, poisonFruitHeightErn);
    // Desenha as paredes
    walls.lawnWalls(buffer.getGraphics(), walls_x, walls_y, rockSprit);
    if (nodeSnake.length < 30) {
      gameOver = true;
    }
    // Renderiza o buffer na tela
    g.drawImage(buffer, 0, 0, null);

    // Se o jogo terminou, desenha a animação de colisão e a tela de game over
    if (gameOver) {

      // Desenha a animação de colisão no buffer
      if (!poisonDeathAnimationPlaying) {

        drawCollisionAnimation(buffer.getGraphics(), rotationAngle);
      }

      // Renderiza o buffer na tela novamente para mostrar a animação de colisão
      g.drawImage(buffer, 0, 0, null);

      // Desenha a tela de game over
      GameOver.drawGameOver(g, getWidth(), getHeight(), FrameWidth, FrameHeight, gameOver, score, direction, nodeSnake,
          walls_x, walls_y, macaX, macaY, WIDTH, HEIGHT, this, this);
    }
  }

  // Método para atualizar a lógica do jogo
  public void tick() {
    // Movendo o corpo da cobra

    VerificDistance = keyListener.getVerif();
    for (int z = 0; z < nodeSnake.length; z++) {
      int currX = nodeSnake[z].x;
      int currY = nodeSnake[z].y;
      int prevX = z > 0 ? nodeSnake[z - 1].x : currX;
      int prevY = z > 0 ? nodeSnake[z - 1].y : currY;
      int nextX = z < nodeSnake.length - 1 ? nodeSnake[z + 1].x : currX;
      int nextY = z < nodeSnake.length - 1 ? nodeSnake[z + 1].y : currY;
      boolean isCorner = (prevX != nextX) && (prevY != nextY);
      if (VerificDistance && isCorner) {
        DISTANCE = 5;
      } else {
        DISTANCE = 1;
      }

      if (VelocityControl) {
        ControlVelocity = 400;
      } else {
        ControlVelocity = 700;
      }
    }

    move.SnakeMove(nodeSnake, keyListener.getDirection(), DISTANCE);

    headCollisionArea = new Rectangle(nodeSnake[0].x - largerCollisionArea / 2,
        nodeSnake[0].y - largerCollisionArea / 2,
        8 + largerCollisionArea, 8 + largerCollisionArea);

    headCollisionAreaPO = new Rectangle(nodeSnake[0].x - 12 / 2,
        nodeSnake[0].y - 60 / 2,
        10, 15);

    ArrayList<Point> foodPositions = LocaleUtils.LocateFood(FrameWidth, FrameHeight, WIDTH, HEIGHT, walls_x, walls_y,
        nodeSnake);

    Rectangle fruitArea = new Rectangle(macaX, macaY, WIDTH, HEIGHT);
    Rectangle fruitPOArea = new Rectangle(macaPOX, macaPOY, 20, 20);

    if (headCollisionArea.intersects(fruitArea)) {
      ControlOneAnimationClassicAtivar = true;
      PosColidianClassicX = macaX;
      PosColidianClassicY = macaY;

      if (!colidionClaControlTimerAnimation) {
        Animation.AnimationFoodCla(this);
      }

      if (!ColidionEnergyConfirmed) {
        ColidionEnergyCla = true;
      }

      if (foodPositions.size() >= 2) {
        Point foodPosition0 = foodPositions.get(0);
        macaX = foodPosition0.x;
        macaY = foodPosition0.y;
        ControlOneAnimationClassic = false;
      }

      for (int i = 0; i < 10; i++) {
        // Adiciona um novo nó ao final da cobra
        int lastIndex = nodeSnake.length - 1;
        Node newTailNode = new Node(nodeSnake[lastIndex].x, nodeSnake[lastIndex].y);

        // Calcula a direção do último segmento em relação ao penúltimo segmento
        int dx = nodeSnake[lastIndex].x - nodeSnake[lastIndex - 1].x;
        int dy = nodeSnake[lastIndex].y - nodeSnake[lastIndex - 1].y;

        // Adiciona o novo segmento na direção oposta ao último segmento
        newTailNode.x += dx;
        newTailNode.y += dy;

        // Adiciona o novo segmento ao final da cobra
        nodeSnake = Arrays.copyOf(nodeSnake, nodeSnake.length + 1);
        nodeSnake[lastIndex + 1] = newTailNode;
      }
      // Aumente o tamanho da cobra, ajuste a pontuação, etc.
      // Restante do código...
    }
    if (headCollisionAreaPO.intersects(fruitPOArea)) {
      Game.PosColidianPoisonX = macaPOX;
      Game.PosColidianPoisonY = macaPOY;
    }
    if (!colisionControlPoison) {
      if (headCollisionAreaPO.intersects(fruitPOArea)) {

        if (foodPositions.size() >= 2) {
          Point foodPosition1 = foodPositions.get(1);

          macaPOX = foodPosition1.x;
          macaPOY = foodPosition1.y;

          ControlOneAnimationPoison = false;
        }
        animationFinished = false;
        poisonDeathAnimationPlaying = true;
        venomAnimationPlayed = true;
        lastVenomAnimationTime1 = System.currentTimeMillis();
        if (!colidionPoiControlTimerAnimation) {
          AnimationPOison.AnimationFoodVenInicColision(this);
        }
        if (!gameOver) {
          AnimationSnakeDeath.AnimationSnake(this, foodPositions);
        }
      }
    }

    if (!gameOver) {

      AnimationControlPoison animationControlPoison = new AnimationControlPoison();
      animationControlPoison.updateVenomAnimation(this);

      AnimationEnergyControl animationEnergyControl = new AnimationEnergyControl();
      animationEnergyControl.updateEnergyAnimation(this);
    }

  }

  public void StartSnake() {

    // Inicializa os nós da cobra em posições diferentes
    int snakeX, snakeY; // Variáveis para armazenar as coordenadas da cabeça da cobra
    boolean tooCloseToWallSnake; // Variável para verificar se a cobra está muito próxima da parede

    do {
      // Gera coordenadas aleatórias para a cabeça da cobra dentro dos limites do
      // quadro do jogo
      snakeX = new Random().nextInt(FrameWidth - WIDTH);
      snakeY = new Random().nextInt(FrameWidth - WIDTH);

      tooCloseToWallSnake = false; // Inicializa a variável como falsa
      // Verifica se a cobra está muito próxima de uma parede
      for (int i = 0; i < walls_x.size(); i++) {
        Rectangle wallRect = new Rectangle(walls_x.get(i), walls_y.get(i), WIDTH, HEIGHT);
        Rectangle snakeRect = new Rectangle(snakeX, snakeY, WIDTH, HEIGHT);
        if (wallRect.contains(snakeRect)) {
          tooCloseToWallSnake = true; // Define como verdadeiro se a cobra está perto de uma parede
          break; // Sai do loop, já que encontrou uma parede próxima
        }
      }
    } while (tooCloseToWallSnake || // Repete o processo se a cobra estiver muito próxima de uma parede
        CollisionUtils.ThisNearBorder(snakeX, snakeY, FrameWidth, FrameHeight, WIDTH, HEIGHT) ||
        // Verifica se a cobra
        // está muito próxima
        // da borda do quadro
        CollisionUtils.ThisNearWalls(snakeX, snakeY, walls_x, walls_y, WIDTH, HEIGHT));
    // Verifica se a cobra está
    // muito próxima de outras
    // paredes

    // Define as coordenadas da cabeça da cobra
    nodeSnake[0] = new Node(snakeX, snakeY);
    // Inicializa o restante do corpo da cobra com as mesmas coordenadas da cabeça
    for (int i = 1; i < nodeSnake.length; i++) {
      nodeSnake[i] = new Node(snakeX, snakeY);
    }

  }

  public void restartGame() {
    TimerVerif = false;
    gameOver = false;
    score = 0;
    direction = KeyEvent.VK_RIGHT;
    initializeKeyListener();
    nodeSnake = new Node[40];
    walls_x.clear();
    walls_y.clear();
    // ArrayList<ArrayList<Integer>> walls = LocaleUtils.LocateWall(FrameWidth,
    // FrameHeight, WIDTH, HEIGHT, 20);
    // walls_x = walls.get(0);
    // walls_y = walls.get(1);
    StartSnake();
    Random random = new Random();
    quantidadeDeco = (int) (Math.random() * 3 + 1);
    quantidadeDeco2 = (int) (Math.random() * 4 + 1);
    for (int i = 0; i < quantidadeDeco; i++) {
      randomX[i] = random.nextInt(ALL_DOTS - 150);
      randomY[i] = random.nextInt(ALL_DOTS - 150);
    }
    for (int i = 0; i < quantidadeDeco2; i++) {
      randomX2[i] = random.nextInt(ALL_DOTS - 150);
      randomY2[i] = random.nextInt(ALL_DOTS - 150);
    }
    map.mapLawn(buffer, ALL_DOTS, gramSprit, DecoLawn01, DecoLawn02, randomX, randomY, quantidadeDeco, randomX2,
        randomY2, quantidadeDeco2);
    ArrayList<Point> foodPositions = LocaleUtils.LocateFood(FrameWidth, FrameHeight, WIDTH, HEIGHT, walls_x, walls_y,
        nodeSnake);
    if (foodPositions.size() >= 2) {
      Point foodPosition0 = foodPositions.get(0);
      macaX = foodPosition0.x;
      macaY = foodPosition0.y;
      macaPOX = -100;
      macaPOY = -100;
      macaENX = -100;
      macaENY = -100;
    }
    ControlVelocity = 700;
    animationFinished = true;
    poisonDeathAnimationPlaying = false;
    venomAnimationPlayed = false;
    ernegyAnimationPlayed = false;
    lastVenomAnimationTime1 = System.currentTimeMillis(); // Reinicia o tempo aqui
    TeleportEnergyVerif = System.currentTimeMillis();
    lastVenomAnimationTimeEnergy = System.currentTimeMillis();
    ControlTimerVelocity = System.currentTimeMillis();
    ControlAPOSSuporte = System.currentTimeMillis();
    ControlSpriteSheet = System.currentTimeMillis();
    ControlSpriteSheetColidion = System.currentTimeMillis();
    TimerVerif = false;
    count = 0;
    VelocityControl = false;
    ColidionEnergyCla = false;
    ColidionEnergyConfirmed = false;
    ControlTeleport = false;
    Segunds = false;
    ControlColisionEnergy = false;
    ColisionEnergy = false;
    SpreetSheetInitial = false;
    SpreetSheetFinale = false;
    ControlAPOSColidionTimer = false;
    ControlEnergyColidianBoolean = false;
    ControlOneAnimationClassicAtivar = false;
    currentFrame1 = 0;
    currentFrame4 = 0;
    currentFrame3 = 0;
    currentFrame2 = 0;
    currentFrame5 = 0;
    currentFrame6 = 0;
    currentFrame7 = 0;
    currentFrame8 = 0;
    currentFrame9 = 0;

    if (timer != null) {
      timer.cancel();
      timer.purge();
    }
    timer = new Timer();
    if (timerEnergy != null) {
      timerEnergy.cancel();
      timerEnergy.purge();
    }
    timerEnergy = new Timer();

  }

}
