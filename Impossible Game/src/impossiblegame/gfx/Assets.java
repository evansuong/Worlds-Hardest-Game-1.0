package impossiblegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int IMAGE_WIDTH = 32, IMAGE_HEIGHT = 32;
	
	public static BufferedImage player, tBlue, tGrey, tWhite, tGreen, enemy, coin, background;
	private static Spritesheet spriteSheet;
	
	public static void init() {
		spriteSheet = new Spritesheet("/textures/spritesheet.png");
		background = ImageLoader.loadImage("/textures/background.png");
		
		tGrey = spriteSheet.crop(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
		tWhite = spriteSheet.crop(IMAGE_WIDTH, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
		player = spriteSheet.crop(IMAGE_WIDTH * 2, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
		enemy = spriteSheet.crop(IMAGE_WIDTH * 3, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
		tGreen = spriteSheet.crop(IMAGE_WIDTH * 4, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
		coin = spriteSheet.crop(IMAGE_WIDTH * 5, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
		tBlue = spriteSheet.crop(IMAGE_WIDTH * 6, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
	}

}
