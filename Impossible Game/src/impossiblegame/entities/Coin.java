package impossiblegame.entities;

import java.awt.Graphics;

import impossiblegame.Handler;
import impossiblegame.gfx.Assets;

public class Coin extends StaticEntity{
	
	private static final int COIN_WIDTH = 14, COIN_HEIGHT = 14;

	public Coin(Handler handler, float x, float y) {
		super(handler, x, y, COIN_WIDTH, COIN_HEIGHT);
	}
	
	@Override
	public boolean isPickable() {
		return true;
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.coin, (int) x, (int) y, COIN_WIDTH, COIN_HEIGHT, null);
	}

}
