import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class ConfPanel extends JPanel {

  static JLabel backgroundLabel;
  private static Image backgroundImageMenu;
  private static JLabel backgroundLabel2;
  private static JPanel verticalPanel;
static JPanel ferramentasConfiguracoes;
  private static JLabel texto;
  private static JButton ButtonRemoverAnimacao;
  private static JLabel texto2;
  private static JLabel texto3;
  private JButton ReturnButton;
  Image backgroundImage;
  Font Fonts;
  private GridBagConstraints gbc;
  private Font FontsTitulo;
  private ImageIcon botafundobotao1;
  private StretchIcon botaorock00;
  private ImageIcon fundoButtonSom;
  private static JButton buttonControlSom;
  private ImageIcon fundoControl;
  private ImageIcon fundoControlVolume;
  private static JLabel ControlVolume;
  private static JButton buttonSom;
  private static JLabel textManter;
  private static JLabel FundoBotaoManter;
  private static JButton ButtonManter;
  private static JLabel textRemocao;
  private static JLabel FundoBotaoRemover;
  private static ArrayList<JComponent> configLabels;
  private static JButton Botaosuperior;
  private static JButton Botaoesquerdo;
  private static JButton Botaodireito;
  private static JButton Botaoinferior;
  private static StretchIcon botaosuperior;
  private static StretchIcon botaoesquerdo;
  private static StretchIcon botaoedireito;
  private static Icon botaoeinferior;
  static CustomSlider slider;
  static JPanel sliderPanel;

  public ConfPanel(ImageIcon buttonReturn) {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    try {
      backgroundImage = ImageIO.read(new File("resources/Menu/backgroundMenu.png"));
      backgroundImage = backgroundImage.getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
      Fonts = loadFont.loadFont("resources/fontes/fontGeral.otf", 16);
      FontsTitulo = loadFont.loadFont("resources/fontes/fontGeral.otf", 34);
    } catch (IOException ex) {
      ex.printStackTrace();
    }

    setLayout(null);
    JLayeredPane layeredPane = new JLayeredPane();
    layeredPane.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
    layeredPane.setPreferredSize(screenSize);
    layeredPane.setBounds(0, 0, screenSize.width, screenSize.height);
    backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
    backgroundLabel.setBounds(0, 0, screenSize.width, screenSize.height);
    backgroundLabel.setLayout(new GridBagLayout());
    layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

    gbc = new GridBagConstraints();

    gbc.anchor = GridBagConstraints.CENTER;

    ReturnButton = new JButton("", buttonReturn);
    ReturnButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(ConfPanel.this);
        MenuPanel menuPanel = new MenuPanel(); // Crie uma nova instância de MenuPanel
        topFrame.getContentPane().removeAll();
        topFrame.getContentPane().add(menuPanel);
        topFrame.revalidate();
        topFrame.repaint();
      }
    });
    ReturnButton.setBounds(10, 10, 100, 80); // Posição do botão no canto superior esquerdo
    MapPanel.ReturnButtonImage(ReturnButton, 100, 80, Fonts);
    layeredPane.add(ReturnButton, JLayeredPane.PALETTE_LAYER);
    // ================
    JLabel mapLabel = new JLabel("Configurações");
    mapLabel.setFont(FontsTitulo);
    mapLabel.setForeground(Color.WHITE);
    gbc.gridx = 0;
    gbc.gridy = 1;
    backgroundLabel.add(mapLabel, gbc);
    // ================
    ComponetsVerticais(Fonts);
    gbc.gridy = GridBagConstraints.RELATIVE;
    gbc.anchor = GridBagConstraints.NORTH;
    gbc.gridy = 2;
    gbc.insets = new Insets(50, 0, 0, 0); // Add top padding to move the panel
    // down
    backgroundLabel.add(verticalPanel, gbc);
    // ================
    FerramentasdeConfig(Fonts);
    gbc.gridy = 2;
    gbc.anchor = GridBagConstraints.CENTER;
    backgroundLabel.add(ferramentasConfiguracoes, gbc);
    // ================
    ImagemFundo();
    gbc.gridy = 2;
    backgroundLabel.add(backgroundLabel2, gbc);
    // ================
    add(layeredPane);
    setPreferredSize(screenSize);
    setBounds(0, 0, screenSize.width, screenSize.height);
  }

  public void FerramentasdeConfig(Font Fonts) {
    configLabels = new ArrayList<>();

    ferramentasConfiguracoes = new JPanel(new GridBagLayout());

    ferramentasConfiguracoes.setOpaque(false);
    GridBagConstraints gbc = new GridBagConstraints();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    ferramentasConfiguracoes.setPreferredSize(screenSize);
    ferramentasConfiguracoes.setBounds(0, 0, screenSize.width, screenSize.height);

    texto = new JLabel("Opções de Movimentação");
    texto.setFont(Fonts);
    texto.setForeground(Color.WHITE);
    gbc.gridx = 1;
    gbc.gridy = 0;
    ferramentasConfiguracoes.add(texto, gbc);
    configLabels.add(texto);
    /// ====================================
    botaosuperior = new StretchIcon("resources/Menu/up.png");
    Botaosuperior = new JButton(KeyEvent.getKeyText(Game.keyPressedSuperior), botaosuperior);

    Botaosuperior.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ConfPanel.this.requestFocusInWindow();
        ConfPanel.this.addKeyListener(new KeyAdapter() {
          @Override
          public void keyPressed(KeyEvent event) {
            Game.keyPressedSuperior = event.getKeyCode();

            // Remove the KeyListener after the first key press
            ConfPanel.this.removeKeyListener(this);
            Botaosuperior.setText(KeyEvent.getKeyText(Game.keyPressedSuperior));
            Botaosuperior.setForeground(Color.WHITE);
            Botaosuperior.revalidate();
            Botaosuperior.repaint();
          }
        });
      }
    });
    ConfigButton(Botaosuperior, Fonts, 120, 120, "");
    addHoverEffect(Botaosuperior, 120, 120);
    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.insets = new Insets(50, 0, 0, 0);
    ferramentasConfiguracoes.add(Botaosuperior, gbc);
    configLabels.add(Botaosuperior);
    /// -----
    botaoesquerdo = new StretchIcon("resources/Menu/left.png");
    Botaoesquerdo = new JButton(KeyEvent.getKeyText(Game.keyPressedEsquerda), botaoesquerdo);

    Botaoesquerdo.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ConfPanel.this.requestFocusInWindow();
        ConfPanel.this.addKeyListener(new KeyAdapter() {
          @Override
          public void keyPressed(KeyEvent event) {
            Game.keyPressedEsquerda = event.getKeyCode();
            // Remove the KeyListener after the first key press
            ConfPanel.this.removeKeyListener(this);
            Botaoesquerdo.setText(KeyEvent.getKeyText(Game.keyPressedEsquerda));
            Botaoesquerdo.setForeground(Color.WHITE);
            Botaoesquerdo.revalidate();
            Botaoesquerdo.repaint();
          }
        });
      }
    });
    ConfigButton(Botaoesquerdo, Fonts, 120, 120, "");
    addHoverEffect(Botaoesquerdo, 120, 120);
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.insets = new Insets(20, 0, 0, 0);
    ferramentasConfiguracoes.add(Botaoesquerdo, gbc);
    configLabels.add(Botaoesquerdo);
    /// -----
    botaoedireito = new StretchIcon("resources/Menu/right.png");
    Botaodireito = new JButton(KeyEvent.getKeyText(Game.keyPressedDireita), botaoedireito);

    Botaodireito.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ConfPanel.this.requestFocusInWindow();
        ConfPanel.this.addKeyListener(new KeyAdapter() {
          @Override
          public void keyPressed(KeyEvent event) {
            Game.keyPressedDireita = event.getKeyCode();
            // Remove the KeyListener after the first key press
            ConfPanel.this.removeKeyListener(this);
            Botaodireito.setText(KeyEvent.getKeyText(Game.keyPressedDireita));
            Botaodireito.setForeground(Color.WHITE);
            Botaodireito.revalidate();
            Botaodireito.repaint();
          }
        });
      }
    });
    ConfigButton(Botaodireito, Fonts, 120, 120, "");
    addHoverEffect(Botaodireito, 120, 120);
    gbc.gridx = 2;
    gbc.gridy = 2;
    gbc.insets = new Insets(20, 0, 0, 0);
    ferramentasConfiguracoes.add(Botaodireito, gbc);
    configLabels.add(Botaodireito);
    /// -----
    botaoeinferior = new StretchIcon("resources/Menu/down.png");
    Botaoinferior = new JButton(KeyEvent.getKeyText(Game.keyPressedInferior), botaoeinferior);

    Botaoinferior.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ConfPanel.this.requestFocusInWindow();
        ConfPanel.this.addKeyListener(new KeyAdapter() {
          @Override
          public void keyPressed(KeyEvent event) {
            Game.keyPressedInferior = event.getKeyCode();
            // Remove the KeyListener after the first key press
            ConfPanel.this.removeKeyListener(this);
            Botaoinferior.setText(KeyEvent.getKeyText(Game.keyPressedInferior));
            Botaoinferior.setForeground(Color.WHITE);
            Botaoinferior.revalidate();
            Botaoinferior.repaint();
          }
        });
      }
    });
    ConfigButton(Botaoinferior, Fonts, 120, 120, "");
    addHoverEffect(Botaoinferior, 120, 120);
    gbc.gridx = 1;
    gbc.gridy = 3;
    gbc.insets = new Insets(20, 0, 0, 0);
    ferramentasConfiguracoes.add(Botaoinferior, gbc);
    configLabels.add(Botaoinferior);
    /// ====================================
    /// ====================================
    /// ====================================
    /// ====================================
    /// ====================================
    /// ====================================
    botaorock00 = new StretchIcon("resources/Menu/buttonRock00.png");
    ButtonRemoverAnimacao = new JButton("Remover Animação", botaorock00);
    ButtonRemoverAnimacao.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ButtonManter.setForeground(Color.WHITE);
        ButtonRemoverAnimacao.setForeground(Color.BLACK);
        Game.RemoverAnimation = true;
        Game.ManterAnimation = false;
      }
    });
    ConfigButton(ButtonRemoverAnimacao, Fonts, 200, 80, "");
    if (Game.RemoverAnimation) {
      ButtonManter.setForeground(Color.WHITE);
      ButtonRemoverAnimacao.setForeground(Color.BLACK);
    }
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.insets = new Insets(-70, 0, 0, 0);
    ferramentasConfiguracoes.add(ButtonRemoverAnimacao, gbc);
    ButtonRemoverAnimacao.setVisible(false);
    configLabels.add(ButtonRemoverAnimacao);
    //// ----------
    gbc.gridy = 1;
    gbc.insets = new Insets(-150, 0, 0, 0);
    textRemocao = new JLabel(
        "<html><div style='width: 280px; text-align: center;'>Removendo as animações, as interações intuitivas não apareceram mais, e também poderá melhorar o seu desempenho.</div></html>");
    textRemocao.setFont(Fonts);
    textRemocao.setPreferredSize(new Dimension(200, 200));
    textRemocao.setForeground(Color.WHITE);
    ferramentasConfiguracoes.add(textRemocao, gbc);
    textRemocao.setVisible(false);
    configLabels.add(textRemocao);
    //// ----------
    int width = 380;
    int height = 250;
    gbc.insets = new Insets(0, 0, 0, 0);
    botafundobotao1 = new ImageIcon("resources/Menu/fundobotaoremover.png");
    Image image = botafundobotao1.getImage();
    Image newImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    botafundobotao1 = new ImageIcon(newImage);
    FundoBotaoRemover = new JLabel(botafundobotao1);
    FundoBotaoRemover.setPreferredSize(new Dimension(width, height)); // Defina o tamanho preferido
    FundoBotaoRemover.setSize(new Dimension(width, height));
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.insets = new Insets(0, 0, 0, 0);
    ferramentasConfiguracoes.add(FundoBotaoRemover, gbc);
    FundoBotaoRemover.setVisible(false);
    configLabels.add(FundoBotaoRemover);
    /// ====================================
    /// ====================================
    ButtonManter = new JButton("Manter Animação", botaorock00);
    ButtonManter.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ButtonRemoverAnimacao.setForeground(Color.WHITE);
        ButtonManter.setForeground(Color.BLACK);
        Game.RemoverAnimation = false;
        Game.ManterAnimation = true;
      }
    });
    ConfigButton(ButtonManter, Fonts, 200, 80, "");
    if (Game.ManterAnimation) {
      ButtonRemoverAnimacao.setForeground(Color.WHITE);
      ButtonManter.setForeground(Color.BLACK);
    }
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.insets = new Insets(-70, 0, 0, 0);
    ferramentasConfiguracoes.add(ButtonManter, gbc);
    ButtonManter.setVisible(false);
    configLabels.add(ButtonManter);
    //// ----------
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.insets = new Insets(-150, 0, 0, 0);
    textManter = new JLabel(
        "<html><div style='width: 280px; text-align: center;'>Mantendo as animações, a interações intuítivas iram continuar, talvez o seu desempenho será afetado.</div></html>");
    textManter.setFont(Fonts);
    textManter.setPreferredSize(new Dimension(200, 200));
    textManter.setForeground(Color.WHITE);
    ferramentasConfiguracoes.add(textManter, gbc);
    textManter.setVisible(false);
    configLabels.add(textManter);
    //// ----------
    FundoBotaoManter = new JLabel(botafundobotao1);
    FundoBotaoManter.setPreferredSize(new Dimension(width, height)); // Defina o tamanho preferido
    FundoBotaoManter.setSize(new Dimension(width, height));
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.insets = new Insets(0, 0, 0, 0);
    ferramentasConfiguracoes.add(FundoBotaoManter, gbc);
    FundoBotaoManter.setVisible(false);
    configLabels.add(FundoBotaoManter);
    /// ====================================
    /// ====================================
    /// ====================================
    /// ====================================
    /// ====================================
    /// ====================================
    texto2 = new JLabel("Musicas");
    texto2.setFont(Fonts);
    texto2.setForeground(Color.WHITE);
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.insets = new Insets(0, 0, 0, 0);
    ferramentasConfiguracoes.add(texto2, gbc);
    texto2.setVisible(false);
    configLabels.add(texto2);
    /// ====================================
    fundoButtonSom = new ImageIcon("resources/Menu/SomButton.png");
    Image image2 = fundoButtonSom.getImage();
    Image resizedImage2 = image2.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
    ImageIcon resizedIcon = new ImageIcon(resizedImage2);
    buttonSom = new JButton("", resizedIcon);
    ConfigButton(buttonSom, Fonts, 100, 100, "");
    buttonSom.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

      }
    });
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.insets = new Insets(0, 0, 0, 0);
    ferramentasConfiguracoes.add(buttonSom, gbc);
    buttonSom.setVisible(false);
    configLabels.add(buttonSom);
    // ----
    Image thumbImage = new ImageIcon("resources/Menu/buttonArrastar.png").getImage().getScaledInstance(20, 20,
        Image.SCALE_SMOOTH);
    Image backgroundImage = new ImageIcon("resources/Menu/barraVolume.png").getImage();
    slider = new CustomSlider(backgroundImage, thumbImage);
    slider.setBorder(BorderFactory.createEmptyBorder());
    slider.setFocusable(false);
    slider.setMajorTickSpacing(10);
    slider.setMinorTickSpacing(1);
    slider.setPreferredSize(new Dimension(200, 40));
    slider.setMaximumSize(new Dimension(200, 40));
    slider.setMinimumSize(new Dimension(200, 40));
    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.insets = new Insets(0, 0, 0, 0);
    gbc.weightx = 1.0;
    gbc.fill = GridBagConstraints.HORIZONTAL;

    sliderPanel = new JPanel();
    sliderPanel.setLayout(new BorderLayout());
    sliderPanel.setOpaque(false);
    sliderPanel.add(slider, BorderLayout.CENTER);
    ferramentasConfiguracoes.add(sliderPanel, gbc);
    sliderPanel.setVisible(false);
    configLabels.add(sliderPanel);
    /// ====================================
    /// ====================================
    /// ====================================
    /// ====================================
    /// ====================================
    /// ====================================
    texto3 = new JLabel("Dificuldade");
    texto3.setFont(Fonts);
    texto3.setForeground(Color.WHITE);
    gbc.gridx = 0;
    gbc.gridy = 0;
    ferramentasConfiguracoes.add(texto3, gbc);
    texto3.setVisible(false);
    configLabels.add(texto3);
  }

  public static void setAllLabelsInvisible() {
    for (JComponent component : configLabels) {
      component.setVisible(false);
    }
  }

  public static void addHoverEffect(JButton button, int normalWidth, int normalHeight) {
    button.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        button.setSize(normalWidth + 10, normalHeight + 10);

      }

      @Override
      public void mouseExited(MouseEvent e) {
        button.setSize(normalWidth, normalHeight);
      }
    });
  }

  public static void ComponetsVerticais(Font Fonts) {
    verticalPanel = new JPanel(new GridBagLayout());
    verticalPanel.setOpaque(false);
    GridBagConstraints gbc = new GridBagConstraints();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    verticalPanel.setPreferredSize(screenSize);
    verticalPanel.setBounds(0, 0, screenSize.width, screenSize.height);

    ImageIcon fundoBotaoConfig = new StretchIcon("resources/Menu/botoesConfigFundo.png");
    JButton Controles = new JButton("Teclado", fundoBotaoConfig);
    Controles.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setAllLabelsInvisible();
        texto.setVisible(true);
        Botaosuperior.setVisible(true);
        Botaoesquerdo.setVisible(true);
        Botaodireito.setVisible(true);
        Botaoinferior.setVisible(true);
      }
    });
    ConfigButton(Controles, Fonts, 150, 40, "Teclado");
    addHoverEffect(Controles, Color.WHITE, Color.DARK_GRAY);
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.insets = new Insets(0, 20, 0, 0);
    verticalPanel.add(Controles, gbc);
    //////
    JButton Animação = new JButton("Animação", fundoBotaoConfig);
    Animação.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setAllLabelsInvisible();
        ButtonRemoverAnimacao.setVisible(true);
        FundoBotaoRemover.setVisible(true);
        textRemocao.setVisible(true);
        ButtonManter.setVisible(true);
        FundoBotaoManter.setVisible(true);
        textManter.setVisible(true);
      }
    });
    ConfigButton(Animação, Fonts, 150, 40, "Animação");
    addHoverEffect(Animação, Color.WHITE, Color.DARK_GRAY);
    gbc.gridx = 1;
    gbc.gridy = 0;
    verticalPanel.add(Animação, gbc);
    //////
    JButton áudio = new JButton("Áudio", fundoBotaoConfig);
    áudio.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        setAllLabelsInvisible();
        texto2.setVisible(true);
        buttonSom.setVisible(true);
        sliderPanel.setVisible(true);
        // buttonControlSom.setVisible(true);
        // ControlVolume.setVisible(true);
      }
    });
    ConfigButton(áudio, Fonts, 150, 40, "Áudio");
    addHoverEffect(áudio, Color.WHITE, Color.DARK_GRAY);
    gbc.gridx = 2;
    gbc.gridy = 0;
    verticalPanel.add(áudio, gbc);
    //////
    JButton Dificuldade = new JButton("Dificuldade", fundoBotaoConfig);
    Dificuldade.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setAllLabelsInvisible();
        texto3.setVisible(true);
      }
    });
    ConfigButton(Dificuldade, Fonts, 150, 40, "Dificuldade");
    addHoverEffect(Dificuldade, Color.WHITE, Color.DARK_GRAY);
    gbc.gridx = 3;
    gbc.gridy = 0;
    verticalPanel.add(Dificuldade, gbc);
  }

  public static void addHoverEffect(JButton button, Color normalColor, Color hoverColor) {
    button.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        button.setForeground(hoverColor);
      }

      @Override
      public void mouseExited(MouseEvent e) {
        button.setForeground(normalColor);
      }
    });
  }

  public static void ConfigButton(JButton button, Font font, int width, int height, String text) {
    button.setForeground(Color.WHITE);
    button.setFont(font);
    button.setPreferredSize(new Dimension(width, height));
    button.setMinimumSize(new Dimension(width, height)); // Adiciona o tamanho mínimo
    button.setMaximumSize(new Dimension(width, height)); // Adiciona o tamanho máximo
    button.setBorder(BorderFactory.createEmptyBorder());
    button.setOpaque(false);
    button.setContentAreaFilled(false);
    button.setBorderPainted(false);

    JPanel textPanel = new JPanel();
    textPanel.setOpaque(false);
    JLabel textLabel = new JLabel(text);
    textLabel.setFont(font);
    textLabel.setForeground(Color.DARK_GRAY);
    textPanel.add(textLabel);
    Border border = BorderFactory.createEmptyBorder(6, 15, 5, 10); // Ajuste conforme necessário
    textPanel.setBorder(border);
    button.setLayout(new BorderLayout());
    button.add(textPanel, BorderLayout.CENTER);
    button.setFocusPainted(false);
  }

  public static void ImagemFundo() {
    try {
      backgroundImageMenu = ImageIO.read(new File("resources/Menu/fundoConfigMenu.png"));
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    Dimension imageSize = new Dimension(750, 700);
    backgroundImageMenu = backgroundImageMenu.getScaledInstance((int) imageSize.getWidth(), (int) imageSize.getHeight(),
        Image.SCALE_SMOOTH);
    backgroundLabel2 = new JLabel(new ImageIcon(backgroundImageMenu));
    backgroundLabel2.setSize(imageSize);
    backgroundLabel2.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
  }
}
