
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanneauImage extends JPanel {

    private ImageIcon image;

    public PanneauImage() {
        super();
        this.image = null;
    }

    public PanneauImage(ImageIcon img) {
        super();
        this.image = img;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
        repaint();
    }

    //Fait la convertion de ImageIcon a Image. J'aurais sans doute dus faire un objet BouttonImage plutôt que PanneauImage
    public void paint(Graphics g) {
        super.paint(g);
        if (this.image != null) {
            Image tmp = this.image.getImage();
            g.drawImage(tmp, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
}
