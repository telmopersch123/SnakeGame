import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class loadFont {
  public static Font loadFont(String path, float size) {
    Font font = null;
    try {
      File fontFile = new File(path);
      font = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(size);
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      ge.registerFont(font);
    } catch (IOException | FontFormatException e) {
      e.printStackTrace();
      // Tratar erro ao carregar fonte, por exemplo, usar uma fonte padrão
      font = new Font("Arial", Font.PLAIN, (int) size);
    }
    return font;
  }
}
