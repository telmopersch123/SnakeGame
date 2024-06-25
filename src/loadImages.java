import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class loadImages {

  public static BufferedImage[] Images(
      int WIDTH, int HEIGHT) {
    BufferedImage[] images = new BufferedImage[64];
    try {
      images[0] = ImageIO.read(new File("resources/snakes/snakeGreen/head.png"));
      images[1] = ImageIO.read(new File("resources/snakes/snakeGreen/tail.png"));
      images[2] = ImageIO.read(new File("resources/snakes/snakeGreen/body.png"));
      images[3] = ImageIO.read(new File("resources/snakes/snakeGreen/fold.png"));

      images[4] = ImageIO.read(new File("resources/map_field/mapa/gram.png"));
      images[5] = ImageIO.read(new File("resources/map_field/mapa/rock.png"));

      images[6] = ImageIO.read(new File("resources/foods/apple.png"));

      images[7] = ImageIO.read(new File("resources/map_field/decoração/decoration_Lawn01.png"));
      images[8] = ImageIO.read(new File("resources/map_field/decoração/decoration_Lawn02.png"));

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
      images[20] = ImageIO.read(new File("resources/map_field/mapa/painelRock.png"));
      ////
      images[21] = ImageIO.read(new File("resources/map_swamp/mapa/chao-swamp.png"));
      images[22] = ImageIO.read(new File("resources/map_swamp/mapa/rock-swamp.png"));
      ////
      images[23] = ImageIO.read(new File("resources/map_dungeon/mapa/chao-dungeon.png"));
      images[24] = ImageIO.read(new File("resources/map_dungeon/mapa/rock-dungeon.png"));
      /////
      images[25] = ImageIO.read(new File("resources/map_swamp/decoração/small-trunk.png"));
      images[26] = ImageIO.read(new File("resources/map_swamp/decoração/chao1.png"));
      images[27] = ImageIO.read(new File("resources/map_swamp/decoração/chao2.png"));
      images[28] = ImageIO.read(new File("resources/map_swamp/decoração/chao3.png"));
      /////
      images[29] = ImageIO.read(new File("resources/map_dungeon/decoração/dragon-bone.png"));
      images[30] = ImageIO.read(new File("resources/map_dungeon/decoração/skull-bone.png"));
      images[31] = ImageIO.read(new File("resources/map_dungeon/decoração/tibia-bone.png"));
      ////
      images[32] = ImageIO.read(new File("resources/map_swamp/decoração/swamp1.png"));
      images[33] = ImageIO.read(new File("resources/map_swamp/decoração/swamp2.png"));
      images[34] = ImageIO.read(new File("resources/map_swamp/decoração/swamp3.png"));
      images[35] = ImageIO.read(new File("resources/map_swamp/decoração/swamp4.png"));
      images[36] = ImageIO.read(new File("resources/map_swamp/obstaculos_complexos/spriteshetlago1.png"));
      images[37] = ImageIO.read(new File("resources/map_swamp/obstaculos_complexos/spriteshetlago2.png"));
      images[38] = ImageIO.read(new File("resources/map_swamp/obstaculos_complexos/spriteshetlago3.png"));
      images[39] = ImageIO.read(new File("resources/map_swamp/decoração/chao4.png"));
      images[40] = ImageIO.read(new File("resources/map_swamp/decoração/chao5.png"));
      images[41] = ImageIO.read(new File("resources/map_dungeon/decoração/gold1.png"));
      images[42] = ImageIO.read(new File("resources/map_dungeon/decoração/gold2.png"));
      images[43] = ImageIO.read(new File("resources/map_dungeon/decoração/gold3.png"));
      images[44] = ImageIO.read(new File("resources/map_dungeon/obstaculos_complexos/lava.png"));
      images[45] = ImageIO.read(new File("resources/map_dungeon/obstaculos_complexos/lavaskull.png"));
      //
      images[46] = ImageIO.read(new File("resources/snakes/snakePoison/tail.png"));
      images[47] = ImageIO.read(new File("resources/snakes/snakePoison/fold.png"));
      images[48] = ImageIO.read(new File("resources/snakes/snakePoison/body.png"));
      images[49] = ImageIO.read(new File("resources/snakes/snakePoison/head.png"));
      //
      images[50] = ImageIO.read(new File("resources/snakes/snakeFire/tail.png"));
      images[51] = ImageIO.read(new File("resources/snakes/snakeFire/fold.png"));
      images[52] = ImageIO.read(new File("resources/snakes/snakeFire/body.png"));
      images[53] = ImageIO.read(new File("resources/snakes/snakeFire/head.png"));
      images[54] = ImageIO.read(new File("resources/snakes/snakeFire/fogocomplementar.png"));
      images[55] = ImageIO.read(new File("resources/snakes/snakeFire/fogofinal.png"));
      images[56] = ImageIO.read(new File("resources/snakes/snakePoison/manchasAmarelas.png"));
      images[57] = ImageIO.read(new File("resources/animation/FoodPoison/PoisonDeathAnimation20.png"));
      images[58] = ImageIO.read(new File("resources/animation/snakeColision/explosionDeath.png"));
      images[59] = ImageIO.read(new File("resources/animation/Egg/animationEgg.png"));
      images[60] = ImageIO.read(new File("resources/animation/Egg/animationEggBreak.png"));
      images[61] = ImageIO.read(new File("resources/numeroColisao.png"));
      images[62] = ImageIO.read(new File("resources/RaioIcon.png"));
      images[63] = ImageIO.read(new File("resources/PoisonDeathIcon.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return images;
  }
}
