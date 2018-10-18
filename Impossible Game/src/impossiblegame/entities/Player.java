package impossiblegame.entities;

import java.awt.Color;
import java.awt.Graphics;

import impossiblegame.Handler;
import impossiblegame.gfx.Assets;
import impossiblegame.level.Level;
import impossiblegame.level.Tile;

public class Player extends MovingEntity{
	
	private static final int PLAYER_WIDTH = 24, PLAYER_HEIGHT = 24;

	public Player(Handler handler, float x, float y, int speed) {
		super(handler, x, y, PLAYER_WIDTH, PLAYER_HEIGHT, speed);
		collisionBox.x = 0;
		collisionBox.y = 0;
		collisionBox.width = width - 1;
		collisionBox.height = height - 1;
	}
	
	private void getInput() {	
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().right)
			xMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
			
		moveX();
		moveY();
	}
	
	@Override
	public void update() {
		getInput();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) x, (int) y, width, height, null);
	}
}
