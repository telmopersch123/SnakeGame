import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

public class MyKeyBoardListener implements KeyListener {
  private int initialDirection;
  private int currentDirection = 0;
  private boolean initialVerif = false;

  private Timer timer;

  private Timer timerBlock;
  private boolean canPress = true;

  public MyKeyBoardListener(Game game, int direction) {
    this.initialDirection = direction;
    timer = new Timer(10, e -> resetVerif());
    timerBlock = new Timer(100, e -> canPress = true);
    timerBlock.setRepeats(false);

  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {

    int key = e.getKeyCode();

    if ((key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_UP
        || key == KeyEvent.VK_DOWN) && Math.abs(key - initialDirection) != 2 && canPress) {
      // Verifica se a tecla pressionada é uma direção válida e não oposta à direção
      // atual
      Game.cobraParada = true;
      initialDirection = key;
      canPress = false;
      timerBlock.restart();

    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    // Parar o movimento quando a tecla é solta
    int key = e.getKeyCode();
    if (key != currentDirection) {
      initialVerif = true;
    }
    if ((key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_UP
        || key == KeyEvent.VK_DOWN) && Math.abs(key - initialDirection) != 2) {
      currentDirection = e.getKeyCode();
    }
    ;

    timer.restart();
  }

  public int getDirection() {
    return initialDirection;
  }

  public boolean getVerif() {
    return initialVerif;
  }

  private void resetVerif() {
    initialVerif = false;
  }

  public void setDirection(int direction) {
    // Não é necessário implementar este método
  }
}
