import javax.imageio.ImageIO
import java.awt.*
import java.awt.image.BufferedImage

/**
 * Simple Wrapper around the core Java image writing libraries.
 */
class ImageWriter {
    BufferedImage img
    String fileName
    String type
    def background = Color.GRAY
    def line = Color.WHITE
    def context

    ImageWriter(String fileName, int width, int height, type = 'png') {
        this.img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
        this.fileName = fileName
        this.type = type
        createImageContext(width, height)
    }

    void createImageContext(int width, int height) {
        context = img.createGraphics()
        context.color = background
        context.fillRect(0, 0, width, height);
    }

    ImageWriter drawLine(int startRow, int startCol, int endRow, int endCol) {
        context.color = line
        context.drawLine(startRow, startCol, endRow, endCol)
        this
    }

    void save() {
        context.dispose()
        File file = new File(fileName);
        ImageIO.write(img, type, file);
    }
}

new ImageWriter('test.png', 250, 250)
        .drawLine(1, 1, 1, 10)
        .drawLine(1, 1, 10, 1)
        .save();