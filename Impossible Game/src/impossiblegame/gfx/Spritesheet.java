package impossiblegame.gfx;

import java.awt.image.BufferedImage;

public class Spritesheet {
	
	private String path;
	private BufferedImage image;
	
	public Spritesheet(String path) {
		this.path = path;
	}

	public BufferedImage crop(int x, int y, int width, int height) {	
		image = ImageLoader.loadImage(path);
		return image.getSubimage(x, y, width, height);
	}

}
