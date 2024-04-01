import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class loadImages {

  public static BufferedImage[] Images(
      int WIDTH, int HEIGHT) {
    BufferedImage[] images = new BufferedImage[20];
    try {
      images[0] = ImageIO.read(new File("resources/snakes/head.png"));
      images[1] = ImageIO.read(new File("resources/snakes/tail.png"));
      images[2] = ImageIO.read(new File("resources/snakes/body.png"));
      images[3] = ImageIO.read(new File("resources/snakes/fold.png"));

      images[4] = ImageIO.read(new File("resources/map_lawn/gram.png"));
      images[5] = ImageIO.read(new File("resources/map_lawn/rock.png"));

      images[6] = ImageIO.read(new File("resources/foods/apple.png"));

      images[7] = ImageIO.read(new File("resources/map_lawn/decoration_Lawn01.png"));
      images[8] = ImageIO.read(new File("resources/map_lawn/decoration_Lawn02.png"));

      images[9] = ImageIO.read(new File("resources/foods/applePoison.png"));

      images[10] = ImageIO.read(new File("resources/foods/appleEnergy.png"));
      images[11] = ImageIO.read(new File("resources/animation/FoodPoison/PoisonDeathAnimation.png"));
      images[12] = ImageIO.read(new File("resources/animation/snakeColision/BeatEffect.png"));
      images[13] = ImageIO.read(new File("resources/animation/snakeColision/spritesheetEnergyPartBody.png"));
      images[14] = ImageIO.read(new File("resources/animation/snakeColision/spritesheetEnergyPartTail.png"));
      images[15] = ImageIO.read(new File("resources/animation/snakeColision/spritesheetEnergyFinal.png"));
      images[16] = ImageIO.read(new File("resources/animation/snakeColision/ColidianEnergy.png"));
      images[17] = ImageIO.read(new File("resources/animation/snakeColision/ColidianEnergyFood.png"));
      images[18] = ImageIO.read(new File("resources/animation/snakeColision/ColidianPoisonFood.png"));
      images[19] = ImageIO.read(new File("resources/animation/snakeColision/colidianClassic.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return images;
  }
}
