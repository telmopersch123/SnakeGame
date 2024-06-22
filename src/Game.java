import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Game extends JPanel implements Runnable {
  int DISTANCE = 0;
  int WIDTH = 10;
  int HEIGHT = 10;
  int largerCollisionArea = 12;
  public static int ValueFinal;
  public static int ValueDecoNormal;
  public static int ValueDecoComplexo;
  static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  public static int FrameWidth = (int) screenSize.getWidth();
  public static int FrameHeight = (int) screenSize.getHeight();
  static int ALL_DOTS_Width = (int) screenSize.getWidth();
  static int ALL_DOTS_Height = (int) screenSize.getHeight();
  int x[] = new int[ALL_DOTS_Width];
  int y[] = new int[ALL_DOTS_Height];
  Boolean[] Direcoes = new Boolean[4];
  Rectangle headCollisionArea;
  Rectangle headCollisionAreaPO;
  static int quantidadeDeco = 0;
  static int quantidadeDeco2 = 0;
  static int[] randomX2 = new int[4];
  static int[] randomY2 = new int[4];
  static int[] randomX = new int[3];
  static int[] randomY = new int[3];
  int[] randomXS0 = new int[4];
  int[] randomYS0 = new int[4];
  // SNAKES
  private Image snakeHead;
  private Image bodyStraight;
  private Image bodyCorner;
  private Image tailImage;
  //
  private Image snakeHeadPoison;
  private Image bodyStraightPoison;
  private Image bodyCornerPoison;
  private Image tailImagePoison;
  private Image manchasAmarelas;
  //
  private Image fogoComplementar;
  private Image fogoFinal;
  private Image snakeHeadFire;
  private Image bodyStraightFire;
  private Image bodyCornerFire;
  private Image tailImageFire;
  // MAP - LAWN
  private Image gramSprit;
  private Image rockSprit;
  private Image DecoLawn01;
  private Image DecoLawn02;
  private Image painelRock;
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
  private Image explosionDeath;
  private Image DeathPoison;
  private Image DeathPoison2;
  private Image BeatEffect;
  Image EnergyAnimationBody;
  Image EnergyAnimationTail;
  Image EnergyAnimationFinal;
  Image ColidianEnergy;
  Image ColidianEnergyFood;
  Image ColidianPoisonFood;
  Image colidianClassic;
  //////
  Image chao_swamp;
  Image rock_swamp;
  Image spriteshetlago1;
  Image spriteshetlago2;
  Image spriteshetlago3;
  Image small_trunk;
  Image chao1;
  Image chao2;
  Image chao3;
  Image chao4;
  Image chao5;
  Image swamp1;
  Image swamp2;
  Image swamp3;
  Image swamp4;

  /////
  Image chao_dungeon;
  Image rock_dungeon;

  Image dragon_bone;
  Image skull_bone;
  Image tibia_bone;
  Image gold1;
  Image gold2;
  Image gold3;
  //////
  private boolean VerificDistance = false;
  boolean gameOver = false;
  BufferedImage buffer; // Buffer for double buffering
  public static ArrayList<Integer> walls_x = new ArrayList<>();
  public static ArrayList<Integer> walls_y = new ArrayList<>();
  private MyKeyBoardListener keyListener;
  public int direction = KeyEvent.VK_RIGHT;
  public static Node[] nodeSnake = new Node[40];
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
  public static int currentFrame27 = 0;
  public static int currentFrame26 = 0;
  public static int currentFrame25 = 0;
  public static int currentFrame24 = 0;
  public static int currentFrame23 = 0;
  public static int currentFrame22 = 0;
  public static int currentFrame21 = 0;
  public static int currentFrame20 = 0;
  public static int currentFrame19 = 0;
  public static int currentFrame18 = 0;
  public static int currentFrame17 = 0;
  public static int currentFrame16 = 0;
  public static int currentFrame15 = 0;
  public static int currentFrame14 = 0;
  public static int currentFrame13 = 0;
  public static int currentFrame12 = 0;
  public static int currentFrame11 = 0;
  public static int currentFrame10 = 0;
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
  public static boolean ControlOneAnimationESPLO = false;
  public static boolean ControlOneAnimationPoison = false;
  public static boolean ControlOneAnimationClassic = false;
  public static boolean ControlOneAnimationClassicAtivar = false;
  public static Graphics2D painelBordas;
  public static int borderWidth = 20;
  public static int drawX;
  public static int drawY;
  public static int positionX;
  public static int positionY;
  public static Graphics2D g2d;
  public static boolean NewButtonGame;
  public static boolean MapDungeon = false;
  public static boolean MapSwamp = false;
  public static boolean MapField = true;
  public static boolean snakeClassica = true;
  public static boolean snakePoison = false;
  public static boolean snakeFire = false;
  private static int quantidadeDecoSmallTrunk;
  private static int quantidadeDecoChao1;
  private static int quantidadeDecoChao2;
  private static int quantidadeDecoChao3;
  private static int quantidadeDecoChao4;
  private static int quantidadeDecoChao5;
  private static int quantidadeDecoGold1;
  private static int quantidadeDecoGold2;
  private static int quantidadeDecoGold3;
  static int[] randomSX = new int[7];
  static int[] randomSY = new int[7];
  static int[] randomSX1 = new int[2];
  static int[] randomSY1 = new int[2];
  static int[] randomSX2 = new int[3];
  static int[] randomSY2 = new int[3];
  static int[] randomSX3 = new int[1];
  static int[] randomSY3 = new int[1];
  ///
  static int[] randomDX = new int[1];
  static int[] randomDY = new int[1];
  static int[] randomDX1 = new int[15];
  static int[] randomDY1 = new int[15];
  static int[] randomDX2 = new int[15];
  static int[] randomDY2 = new int[15];
  static int[] randomSX4 = new int[16];
  static int[] randomSY4 = new int[16];
  static int[] randomSX5 = new int[16];
  static int[] randomSY5 = new int[16];
  static int[] randomSX6 = new int[16];
  static int[] randomSY6 = new int[16];
  static int[] randomSX7 = new int[16];
  static int[] randomSY7 = new int[16];
  static int[] randomSX8 = new int[10];
  static int[] randomSY8 = new int[10];
  static int[] randomSX9 = new int[10];
  static int[] randomSY9 = new int[10];
  static int[] randomDX3 = new int[10];
  static int[] randomDY3 = new int[10];
  static int[] randomDX4 = new int[10];
  static int[] randomDY4 = new int[10];
  static int[] randomDX5 = new int[10];
  static int[] randomDY5 = new int[10];
  public static int[] DecoracaoX = new int[0];
  public static int[] DecoracaoY = new int[0];
  public static int[] DecoComplexoX = new int[0];
  public static int[] DecoComplexoY = new int[0];
  private static int quantidadeDecoDragonBone;
  private static int quantidadeDecoSkullBone;
  private static int quantidadeDecoTibiaBone;
  private static int quantidadeDecoSwamp1;
  private static int quantidadeDecoSwamp2;
  private static int quantidadeDecoSwamp3;
  private static int quantidadeDecoSwamp4;
  JButton newGameButton;
  JButton RevertMenuButton;
  JButton button;
  JPanel meuPainel = this;
  JLabel messageLabel;
  Font newgameFont;
  Font revertmenuFont;
  ImageIcon buttonImage;
  JLabel label;
  double rotationAngle = 0;
  Image lavaNormal;
  Image lavaSkull;

  public static boolean colisianEnergy = false;
  public static ArrayList<Integer> quanti = new ArrayList<>();
  public static ArrayList<Integer> quantiComplexo = new ArrayList<>();

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
    painelRock = imagens[20];
    chao_swamp = imagens[21];
    rock_swamp = imagens[22];
    chao_dungeon = imagens[23];
    rock_dungeon = imagens[24];
    small_trunk = imagens[25];
    chao1 = imagens[26];
    chao2 = imagens[27];
    chao3 = imagens[28];
    dragon_bone = imagens[29];
    skull_bone = imagens[30];
    tibia_bone = imagens[31];
    swamp1 = imagens[32];
    swamp2 = imagens[33];
    swamp3 = imagens[34];
    swamp4 = imagens[35];
    spriteshetlago1 = imagens[36];
    spriteshetlago2 = imagens[37];
    spriteshetlago3 = imagens[38];
    chao4 = imagens[39];
    chao5 = imagens[40];
    gold1 = imagens[41];
    gold2 = imagens[42];
    gold3 = imagens[43];
    lavaNormal = imagens[44];
    lavaSkull = imagens[45];
    tailImagePoison = imagens[46];
    bodyCornerPoison = imagens[47];
    bodyStraightPoison = imagens[48];
    snakeHeadPoison = imagens[49];
    tailImageFire = imagens[50];
    bodyCornerFire = imagens[51];
    bodyStraightFire = imagens[52];
    snakeHeadFire = imagens[53];
    fogoComplementar = imagens[54];
    fogoFinal = imagens[55];
    manchasAmarelas = imagens[56];
    DeathPoison2 = imagens[57];
    explosionDeath = imagens[58];
    ///////////////////////////////////
    initializeKeyListener();

    this.setPreferredSize(new Dimension(ALL_DOTS_Width, ALL_DOTS_Height));
    this.setFocusable(true);
    buffer = new BufferedImage(ALL_DOTS_Width, ALL_DOTS_Height, BufferedImage.TYPE_INT_ARGB); // Initialize buffer
    // iniciar a parede
    if (MapField) {
      ArrayList<ArrayList<Integer>> walls = LocaleUtils.LocateWall(FrameWidth,
          FrameHeight, WIDTH, HEIGHT, 20);
      walls_x = walls.get(0);
      walls_y = walls.get(1);
    }
    Location_deco();

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
      if (snakePoison) {
        macaX = -100;
        macaY = -100;
      } else {
        macaX = foodPosition0.x;
        macaY = foodPosition0.y;
      }
      if (snakePoison) {
        macaPOX = foodPosition1.x;
        macaPOY = foodPosition1.y;
      }

      macaENX = -100;
      macaENY = -100;
      if (!TimerVerif) {
        if (snakePoison) {
          macaX = -100;
          macaY = -100;
        }
        if (Game.snakeClassica || Game.snakeFire) {
          macaPOX = -100;
          macaPOY = -100;
        }
      } else if (TimerVerif) {
        if (snakePoison) {
          macaX = foodPosition0.x;
          macaY = foodPosition0.y;
        }
        if (Game.snakeClassica || Game.snakeFire) {
          macaPOX = foodPosition1.x;
          macaPOY = foodPosition1.y;
        }
      }
    }

  }

  public static void Location_deco() {
    Random random = new Random();
    //////////////////
    if (MapField) {

      quantidadeDeco = (int) (Math.random() * 3 + 1);
      quantidadeDeco2 = (int) (Math.random() * 4 + 1);
      for (int i = 0; i < quantidadeDeco; i++) {
        randomX[i] = random.nextInt(ALL_DOTS_Width);
        randomY[i] = random.nextInt(ALL_DOTS_Height);
      }
      ///
      for (int i = 0; i < quantidadeDeco2; i++) {
        randomX2[i] = random.nextInt(ALL_DOTS_Width);
        randomY2[i] = random.nextInt(ALL_DOTS_Height);
      }
    }
    if (MapSwamp) {

      ////// Swamp
      quantidadeDecoSmallTrunk = (int) (Math.random() * 6 + 2);
      quantidadeDecoChao1 = (int) (Math.random() * 2 + 1);
      quantidadeDecoChao2 = (int) (Math.random() * 3 + 1);
      quantidadeDecoChao3 = (int) (Math.random() * 1 + 1);
      quantidadeDecoChao4 = (int) (Math.random() * 6 + 3);
      quantidadeDecoChao5 = (int) (Math.random() * 6 + 3);
      quantidadeDecoSwamp1 = (int) (Math.random() * 10 + 5);
      quantidadeDecoSwamp2 = (int) (Math.random() * 10 + 5);
      quantidadeDecoSwamp3 = (int) (Math.random() * 10 + 5);
      quantidadeDecoSwamp4 = (int) (Math.random() * 10 + 5);

      for (int i = 0; i < quantidadeDecoSmallTrunk; i++) {
        randomSX[i] = random.nextInt(ALL_DOTS_Width);
        randomSY[i] = random.nextInt(ALL_DOTS_Height);
      }
      ///
      for (int i = 0; i < quantidadeDecoChao1; i++) {
        randomSX1[i] = random.nextInt(ALL_DOTS_Width);
        randomSY1[i] = random.nextInt(ALL_DOTS_Height);
      }
      ///
      for (int i = 0; i < quantidadeDecoChao2; i++) {
        randomSX2[i] = random.nextInt(ALL_DOTS_Width);
        randomSY2[i] = random.nextInt(ALL_DOTS_Height);
      }
      ///
      for (int i = 0; i < quantidadeDecoChao3; i++) {
        randomSX3[i] = random.nextInt(ALL_DOTS_Width);
        randomSY3[i] = random.nextInt(ALL_DOTS_Height);
      }
      ///
      for (int i = 0; i < quantidadeDecoChao4; i++) {
        randomSX8[i] = random.nextInt(ALL_DOTS_Width);
        randomSY8[i] = random.nextInt(ALL_DOTS_Height);
      }
      ///
      for (int i = 0; i < quantidadeDecoChao5; i++) {
        randomSX9[i] = random.nextInt(ALL_DOTS_Width);
        randomSY9[i] = random.nextInt(ALL_DOTS_Height);
      }
      ///
      for (int i = 0; i < quantidadeDecoSwamp1; i++) {
        randomSX4[i] = random.nextInt(ALL_DOTS_Width);
        randomSY4[i] = random.nextInt(ALL_DOTS_Height);
      }
      ///
      for (int i = 0; i < quantidadeDecoSwamp2; i++) {
        randomSX5[i] = random.nextInt(ALL_DOTS_Width);
        randomSY5[i] = random.nextInt(ALL_DOTS_Height);
      }
      ///
      for (int i = 0; i < quantidadeDecoSwamp3; i++) {
        randomSX6[i] = random.nextInt(ALL_DOTS_Width);
        randomSY6[i] = random.nextInt(ALL_DOTS_Height);
      }
      ///
      for (int i = 0; i < quantidadeDecoSwamp4; i++) {
        randomSX7[i] = random.nextInt(ALL_DOTS_Width);
        randomSY7[i] = random.nextInt(ALL_DOTS_Height);
      }
      ///
    }
    if (MapDungeon) {

      ////// Dungeon
      quantidadeDecoDragonBone = (int) (Math.random() * 1 + 1);
      quantidadeDecoSkullBone = (int) (Math.random() * 10 + 5);
      quantidadeDecoTibiaBone = (int) (Math.random() * 10 + 5);
      quantidadeDecoGold1 = (int) (Math.random() * 6 + 3);
      quantidadeDecoGold2 = (int) (Math.random() * 6 + 3);
      quantidadeDecoGold3 = (int) (Math.random() * 6 + 3);
      for (int i = 0; i < quantidadeDecoDragonBone; i++) {
        randomDX[i] = random.nextInt(ALL_DOTS_Width);
        randomDY[i] = random.nextInt(ALL_DOTS_Height);
      }
      for (int i = 0; i < quantidadeDecoSkullBone; i++) {
        randomDX1[i] = random.nextInt(ALL_DOTS_Width);
        randomDY1[i] = random.nextInt(ALL_DOTS_Height);
      }
      for (int i = 0; i < quantidadeDecoTibiaBone; i++) {
        randomDX2[i] = random.nextInt(ALL_DOTS_Width);
        randomDY2[i] = random.nextInt(ALL_DOTS_Height);
      }
      for (int i = 0; i < quantidadeDecoGold1; i++) {
        randomDX3[i] = random.nextInt(ALL_DOTS_Width);
        randomDY3[i] = random.nextInt(ALL_DOTS_Height);
      }
      for (int i = 0; i < quantidadeDecoGold2; i++) {
        randomDX4[i] = random.nextInt(ALL_DOTS_Width);
        randomDY4[i] = random.nextInt(ALL_DOTS_Height);
      }
      for (int i = 0; i < quantidadeDecoGold3; i++) {
        randomDX5[i] = random.nextInt(ALL_DOTS_Width);
        randomDY5[i] = random.nextInt(ALL_DOTS_Height);
      }
    }
  }

  // Método principal para iniciar o jogo
  public static void main(String args[]) {
    Game game = new Game();
    JFrame frame = new JFrame("Snake Game");
    frame.add(game);
    frame.setResizable(false);
    frame.setUndecorated(true); // Remove as bordas da janela
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Define a janela para tela
    // cheia
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define o comportamento ao fechar a janela
    MenuPanel menuPanel = new MenuPanel();
    frame.add(menuPanel);
    frame.setVisible(true);
  }

  public void drawCollisionAnimation(Graphics g, double rotationAngle) {
    if (nodeSnake.length > 0) { // Verifica se há algum nó no array

      positionX = nodeSnake[0].x; // Coordenada X do primeiro nó
      positionY = nodeSnake[0].y; // Coordenada Y do primeiro nó
      // Calcula as coordenadas de desenho para centralizar a animação em torno do nó
      drawX = positionX - BeatEffect.getWidth(null) / 40 + 26; // Centraliza a imagem horizontalmente
      drawY = positionY - BeatEffect.getHeight(null) / 40 / 40 + 5; // Centraliza a imagem verticalmente
      Animation.AnimationColidion(buffer, BeatEffect, drawX, drawY, rotationAngle);
    }
  }

  // Loop principal do jogo, onde a lógica e renderização são atualizadas
  @Override
  public void run() {
    while (!gameOver) {
      if (VerificDistance) {
        VerificDistance = false;
      }

      tick();
      ResultadoColisao resultadoColisao = checkedColisson.verificarColisao(gameOver, WIDTH, HEIGHT, FrameWidth,
          FrameHeight,
          walls_x, walls_y, nodeSnake, largerCollisionArea, headCollisionArea,
          poisonDeathAnimationPlaying,
          borderWidth, FrameWidth, FrameHeight);
      gameOver = resultadoColisao.gameOver;
      poisonDeathAnimationPlaying = resultadoColisao.animacaoMorteVenenoAtiva;

      try {
        Thread.sleep(ControlVelocity / 60);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    // Renderizar a animação de colisão
    while (gameOver && !poisonDeathAnimationPlaying && !Game.snakeFire) {
      rotationAngle += 1;
      rotationAngle %= 360;
      if (keyListener != null) {
        this.removeKeyListener(keyListener);
      }
      drawCollisionAnimation(buffer.getGraphics(), rotationAngle);
      try {
        Thread.sleep(10); // Ajuste conforme necessário para a taxa de atualização da animação
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void Animation() {
    if (!animationFinished && snakePoison) {
      if (!ControlOneAnimationPoison) {
        Animation.AnimationColidianPoisonFood(buffer, ColidianPoisonFood, nodeSnake,
            PosColidianPoisonX,
            PosColidianPoisonY);
      }
    }

    if (!animationFinished && poisonDeathAnimationPlaying) {
      int positionX = 0;
      int positionY = 0;
      for (int i = 0; i < nodeSnake.length; i++) {
        positionX = nodeSnake[0].x;
        positionY = nodeSnake[0].y;
      }

      if (snakeClassica || snakeFire) {
        if (!ControlOneAnimationPoison) {
          Animation.AnimationColidianPoisonFood(buffer, ColidianPoisonFood, nodeSnake, PosColidianPoisonX,
              PosColidianPoisonY);
        }
      }
      animationFinished = Animation.AnimationPoisonDeath(buffer, DeathPoison, DeathPoison2, animationFinished,
          positionX,
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
    if (gameOver) {
      if (keyListener != null) {
        this.removeKeyListener(keyListener);
      }
      repaint();
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
    if (MapField) {
      map.mapField(buffer, ALL_DOTS_Width, ALL_DOTS_Height, gramSprit, DecoLawn01, DecoLawn02, randomX, randomY,
          quantidadeDeco, randomX2,
          randomY2, quantidadeDeco2);
    }
    if (MapSwamp) {
      map.mapSwamp(buffer, ALL_DOTS_Width, ALL_DOTS_Height, chao_swamp, small_trunk, chao1, chao2, chao3, chao4, chao5,
          swamp1, swamp2, swamp3, swamp4,
          quantidadeDecoSmallTrunk, quantidadeDecoChao1, quantidadeDecoChao2, quantidadeDecoChao3, quantidadeDecoChao4,
          quantidadeDecoChao5, randomSX, randomSY,
          randomSX1, randomSY1, randomSX2, randomSY2, randomSX3, randomSY3, randomSX4, randomSY4, randomSX5, randomSY5,
          randomSX6, randomSY6, randomSX7, randomSY7, randomSX8, randomSY8, randomSX9, randomSY9, quantidadeDecoSwamp1,
          quantidadeDecoSwamp2,
          quantidadeDecoSwamp3, quantidadeDecoSwamp4);
      decoracaoComplexaAcima.AcimaSwamp(buffer, spriteshetlago1, spriteshetlago2, spriteshetlago3);
    }
    if (MapDungeon) {
      map.mapDungeon(buffer, ALL_DOTS_Width, ALL_DOTS_Height, chao_dungeon, dragon_bone, skull_bone, tibia_bone, gold1,
          gold2, gold3,
          quantidadeDecoDragonBone, quantidadeDecoSkullBone, quantidadeDecoTibiaBone,
          quantidadeDecoGold1, quantidadeDecoGold2, quantidadeDecoGold3, randomDX, randomDY, randomDX1,
          randomDY1, randomDX2, randomDY2, randomDX3, randomDY3, randomDX4, randomDY4, randomDX5, randomDY5);
      decoracaoComplexaAcima.AcimaDungeon(buffer, lavaNormal, lavaSkull);
    }

    // Desenha a COBRA

    if (snakeClassica) {
      snake.snakePaint(nodeSnake, buffer, WIDTH, HEIGHT, bodyStraight, bodyCorner, tailImage, snakeHead, keyListener,
          null, null, null);
    }
    if (snakePoison) {
      snake.snakePaint(nodeSnake, buffer, WIDTH, HEIGHT, bodyStraightPoison, bodyCornerPoison, tailImagePoison,
          snakeHeadPoison, keyListener, manchasAmarelas, null, null);
    }
    if (!colisianEnergy) {
      if (snakeFire) {
        snake.snakePaint(nodeSnake, buffer, WIDTH, HEIGHT, bodyStraightFire, bodyCornerFire, tailImageFire,
            snakeHeadFire,
            keyListener, null, fogoComplementar, fogoFinal);
      }
    }
    // Desenha a comidas
    food.classicFood(g, buffer, macaX, macaY, appleSprit, poisonFruitWidthCla,
        poisonFruitHeightCla);
    food.PoisonFood(g, buffer, macaPOX, macaPOY, applePoison,
        poisonFruitWidthVen, poisonFruitHeightVen);
    food.EnergyFood(this, g, buffer, macaENX, macaENY, appleEnergy,
        poisonFruitWidthErn, poisonFruitHeightErn);
    // Desenha as paredes
    if (MapField) {
      walls.lawnWalls(buffer.getGraphics(), walls_x, walls_y, rockSprit);
      decoracao.decoracaoField(buffer);
    }
    if (MapSwamp) {
      decoracao.decoracaoSwamp(buffer);
    }
    if (MapDungeon) {
      decoracao.decoracaoDungeon(buffer);
    }

    // Desenha as animação do jogo
    Animation();
    Colidian(rock_swamp, rock_dungeon);
    // Renderiza o buffer na tela
    g.drawImage(buffer, 0, 0, null);
    // Se o jogo terminou, desenha a animação de colisão se a tela de game over

    if (gameOver) {
      if (!poisonDeathAnimationPlaying && !Game.snakeFire) {
        drawCollisionAnimation(buffer.getGraphics(), rotationAngle);
      }
      g.drawImage(buffer, 0, 0, null);
      GameOver(g);
    }

  }

  private void addCenteredComponent(Container container, Component component, int gridy) {
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.gridx = 0;
    constraints.gridy = gridy;
    constraints.anchor = GridBagConstraints.CENTER;
    constraints.insets = new Insets(10, 0, 10, 0);
    container.add(component, constraints);
  }

  public void GameOver(Graphics g) {
    meuPainel.setLayout(new GridBagLayout());
    /////
    Game game = this;
    // Fundo Transparente-Preto 50%
    g.setColor(new Color(0, 0, 0, 127));
    g.fillRect(0, 0, getWidth(), getHeight());
    // Botão de Reiniciar
    boolean newGameButtonExists = false;
    for (int i = 0; i < this.getComponentCount(); i++) {
      if (this.getComponent(i) instanceof JButton) {
        button = (JButton) this.getComponent(i);
        if (button.getText().equals("Reiniciar")) {
          newGameButtonExists = true;
          break;
        }
      }
    }
    if (!newGameButtonExists) {
      // Texto de gameOver
      meuPainel.removeAll();
      label = new JLabel("Você Morreu!");
      label.setFont(new Font("Arial", Font.BOLD, 24));
      label.setForeground(Color.WHITE);
      meuPainel.add(label);

      buttonImage = new StretchIcon("resources/Menu/buttonRock.png");
      newGameButton = new JButton("Reiniciar", buttonImage);
      newgameFont = new Font("Arial", Font.BOLD, 24);

      newGameButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          meuPainel.remove(RevertMenuButton);
          meuPainel.remove(newGameButton);
          meuPainel.remove(label);
          restartGame();
          new Thread(game).start();
        }
      });
      meuPainel.add(newGameButton); // Add the button to the panel
      MenuPanel.addShadow(newGameButton, "Reiniciar", newgameFont, 150, 50);
      addCenteredComponent(meuPainel, newGameButton, 1);

      RevertMenuButton = new JButton("Inicio", buttonImage);
      revertmenuFont = new Font("Arial", Font.BOLD, 24);
      MenuPanel.addShadow(RevertMenuButton, "Inicio", revertmenuFont, 150, 50);
      RevertMenuButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          JFrame GameSnake = (JFrame) SwingUtilities.getWindowAncestor(Game.this);
          meuPainel.remove(RevertMenuButton);
          restartGame();
          GameSnake.getContentPane().removeAll();
          GameSnake.add(new MenuPanel());
          GameSnake.revalidate();
          GameSnake.repaint();
        }
      });
      meuPainel.add(RevertMenuButton); // Add the button to the panel
      addCenteredComponent(meuPainel, RevertMenuButton, 2);

      meuPainel.revalidate(); // Revalidate the panel
      meuPainel.repaint(); // Repaint the panel
    }
  }

  public void Colidian(Image rock_swamp, Image rock_dungeon) {
    g2d = buffer.createGraphics();
    if (MapField) {
      for (int x = 0; x < FrameWidth; x += borderWidth) {
        g2d.drawImage(painelRock, x, 0, borderWidth, borderWidth, null); // Borda superior
        g2d.drawImage(painelRock, x, FrameHeight - borderWidth, borderWidth, borderWidth, null); // Borda
        // inferior
      }
      for (int y = 0; y < FrameHeight; y += borderWidth) {
        g2d.drawImage(painelRock, 0, y, borderWidth, borderWidth, null); // Borda esquerda
        g2d.drawImage(painelRock, FrameWidth - borderWidth, y, borderWidth, borderWidth, null); // Borda direita
      }
    }
    if (MapSwamp) {
      for (int x = 0; x < FrameWidth; x += borderWidth) {
        g2d.drawImage(rock_swamp, x, 0, borderWidth, borderWidth, null); // Borda superior
        g2d.drawImage(rock_swamp, x, FrameHeight - borderWidth, borderWidth, borderWidth, null); // Borda
        // inferior
      }
      for (int y = 0; y < FrameHeight; y += borderWidth) {
        g2d.drawImage(rock_swamp, 0, y, borderWidth, borderWidth, null); // Borda esquerda
        g2d.drawImage(rock_swamp, FrameWidth - borderWidth, y, borderWidth, borderWidth, null); // Borda direita
      }
    }
    if (MapDungeon) {
      for (int x = 0; x < FrameWidth; x += borderWidth) {
        g2d.drawImage(rock_dungeon, x, 0, borderWidth, borderWidth, null); // Borda superior
        g2d.drawImage(rock_dungeon, x, FrameHeight - borderWidth, borderWidth, borderWidth, null); // Borda
        // inferior
      }
      for (int y = 0; y < FrameHeight; y += borderWidth) {
        g2d.drawImage(rock_dungeon, 0, y, borderWidth, borderWidth, null); // Borda esquerda
        g2d.drawImage(rock_dungeon, FrameWidth - borderWidth, y, borderWidth, borderWidth, null); // Borda direita
      }
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
    ////////////
    if (headCollisionArea.intersects(fruitArea)) {
      ControlOneAnimationClassicAtivar = true;
      PosColidianClassicX = macaX;
      PosColidianClassicY = macaY;
      if (foodPositions.size() >= 2) {
        Point foodPosition0 = foodPositions.get(0);
        macaX = foodPosition0.x;
        macaY = foodPosition0.y;
        ControlOneAnimationClassic = false;
      }
      if (snakeClassica || snakeFire) {
        if (!colidionClaControlTimerAnimation) {
          Animation.AnimationFoodCla(this);
        }
      }

      if (!ColidionEnergyConfirmed) {
        ColidionEnergyCla = true;
      }
      if (Game.snakePoison) {
        ControlOneAnimationPoison = true;
        animationFinished = false;
        poisonDeathAnimationPlaying = true;
        venomAnimationPlayed = true;
        if (!gameOver) {
          AnimationSnakeDeath.AnimationSnake(this, foodPositions);
        }
        lastVenomAnimationTime1 = System.currentTimeMillis();
      }

      if (Game.snakeClassica || Game.snakeFire) {
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
      }
    }
    ///////////////////////////////////////////////
    if (headCollisionAreaPO.intersects(fruitPOArea)) {
      PosColidianPoisonX = macaPOX;
      PosColidianPoisonY = macaPOY;

    }
    if (!colisionControlPoison) {
      if (headCollisionAreaPO.intersects(fruitPOArea)) {
        if (foodPositions.size() >= 2) {
          Point foodPosition1 = foodPositions.get(1);

          macaPOX = foodPosition1.x;
          macaPOY = foodPosition1.y;
          ControlOneAnimationPoison = false;
        }
        if (snakePoison) {
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
          if (!ColidionEnergyConfirmed) {
            ColidionEnergyCla = true;
          }
        }

        animationFinished = false;
        venomAnimationPlayed = false;
        if (snakePoison) {
          if (!colidionPoiControlTimerAnimation) {
            AnimationPOison.AnimationFoodClaInicColision(this);
          }
        }

        if (snakeClassica || snakeFire) {
          poisonDeathAnimationPlaying = true;
          if (!colidionPoiControlTimerAnimation) {
            AnimationPOison.AnimationFoodVenInicColision(this);
          }
          lastVenomAnimationTime1 = System.currentTimeMillis();
          if (snakeClassica) {
            if (!gameOver) {
              AnimationSnakeDeath.AnimationSnake(this, foodPositions);
            }
          }
        } else {
          poisonDeathAnimationPlaying = false;
        }

      }
    }

    AnimationControlPoison animationControlPoison = new AnimationControlPoison();
    animationControlPoison.updateVenomAnimation(this);

    AnimationEnergyControl animationEnergyControl = new AnimationEnergyControl();
    animationEnergyControl.updateEnergyAnimation(this, buffer, explosionDeath);
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

      // Verifica se a cabeça da cobra está próxima de uma parede
      for (int i = 0; i < walls_x.size(); i++) {
        Rectangle wallRect = new Rectangle(walls_x.get(i), walls_y.get(i), WIDTH, HEIGHT);
        Rectangle snakeRect = new Rectangle(snakeX, snakeY, WIDTH, HEIGHT);

        if (wallRect.contains(snakeRect)) {
          tooCloseToWallSnake = true; // Define como verdadeiro se a cabeça da cobra está perto de uma parede
          break; // Sai do loop, já que encontrou uma parede próxima
        }
      }

    } while (tooCloseToWallSnake
        || CollisionUtils.ThisNearBorder(snakeX, snakeY, FrameWidth, FrameHeight, WIDTH, HEIGHT)
        || CollisionUtils.ThisNearWalls(snakeX, snakeY, walls_x, walls_y, WIDTH, HEIGHT) || CollisionUtils
            .ThisDecoration(snakeX, snakeY, DecoracaoX, DecoracaoY, DecoComplexoY, DecoComplexoX, WIDTH, HEIGHT));

    // Define as coordenadas da cabeça da cobra
    nodeSnake[0] = new Node(240, 240);
    // nodeSnake[0] = new Node(snakeX, snakeY);

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
    if (MapField) {
      walls_x.clear();
      walls_y.clear();
      ArrayList<ArrayList<Integer>> walls = LocaleUtils.LocateWall(FrameWidth,
          FrameHeight, WIDTH, HEIGHT, 20);
      walls_x = walls.get(0);
      walls_y = walls.get(1);
    }

    Location_deco();
    ValueFinal = 0;
    ValueDecoComplexo = 0;
    ValueDecoNormal = 0;
    quanti.clear();
    quantiComplexo.clear();
    Game.DecoracaoX = new int[0];
    Game.DecoracaoY = new int[0];
    Game.DecoComplexoX = new int[0];
    Game.DecoComplexoY = new int[0];
    decoracao.posicoesDeco(FrameWidth, FrameHeight, ALL_DOTS_Width, ALL_DOTS_Height, walls_x, walls_y);
    StartSnake();
    ArrayList<Point> foodPositions = LocaleUtils.LocateFood(FrameWidth, FrameHeight, WIDTH, HEIGHT, walls_x, walls_y,
        nodeSnake);
    if (foodPositions.size() >= 2) {
      Point foodPosition0 = foodPositions.get(0);
      Point foodPosition1 = foodPositions.get(1);
      if (snakePoison) {
        macaX = -100;
        macaY = -100;
      } else {
        macaX = foodPosition0.x;
        macaY = foodPosition0.y;
      }
      if (snakeClassica || snakeFire) {
        macaPOX = -100;
        macaPOY = -100;
      } else {

        macaPOX = foodPosition1.x;
        macaPOY = foodPosition1.y;
      }
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
    colisianEnergy = false;
    ControlOneAnimationESPLO = true;
    currentFrame1 = 0;
    currentFrame4 = 0;
    currentFrame3 = 0;
    currentFrame2 = 0;
    currentFrame5 = 0;
    currentFrame6 = 0;
    currentFrame7 = 0;
    currentFrame8 = 0;
    currentFrame9 = 0;
    currentFrame10 = 0;
    currentFrame11 = 0;
    currentFrame12 = 0;
    currentFrame13 = 0;
    currentFrame14 = 0;
    currentFrame15 = 0;
    currentFrame16 = 0;
    currentFrame17 = 0;
    currentFrame18 = 0;
    currentFrame19 = 0;
    currentFrame20 = 0;
    currentFrame21 = 0;
    currentFrame22 = 0;
    currentFrame23 = 0;
    currentFrame24 = 0;
    currentFrame25 = 0;
    currentFrame26 = 0;
    currentFrame27 = 0;
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
