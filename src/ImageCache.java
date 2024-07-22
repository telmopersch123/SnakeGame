import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

public class ImageCache {
  private static Map<String, Image> imageCache = new HashMap<>();

  public static Image getImage(String path) throws IOException {
    if (!imageCache.containsKey(path)) {
      Image image = ImageIO.read(new File(path));
      imageCache.put(path, image);
    }
    return imageCache.get(path);
  }
}
