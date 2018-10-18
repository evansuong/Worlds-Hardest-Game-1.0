package impossiblegame.entities;

import java.awt.Color;
import java.awt.Graphics;

import impossiblegame.Handler;
import impossiblegame.gfx.Assets;

public class Enemy extends MovingEntity {

	private int xMin, xMax, yMin, yMax;
	private boolean xDirection, yDirection;
	
	private static final int ENEMY_WIDTH = 20, ENEMY_HEIGHT = 20;

	public Enemy(Handler handler, float x, float y, int speed) {
		super(handler, x, y, ENEMY_WIDTH, ENEMY_HEIGHT, speed);
		collisionBox.x = 0;
		collisionBox.y = 0;
		collisionBox.width = ENEMY_WIDTH;
		collisionBox.height = ENEMY_HEIGHT;
	}
	
	@Override
	public boolean isEnemy() {
		return true;
	}

	@Override
	public void update() {
		if (yDirection) {
			yMove = speed;
			moveY();
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.enemy, (int) x, (int) y, width, height, null);
	}

	public void moveX() {
		x += speed;
	}

	public void moveY() {
		y += speed;
	}

}
