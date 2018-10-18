package impossiblegame.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import impossiblegame.Handler;
import impossiblegame.level.Tile;

public abstract class Entity {

	protected float x, y;
	protected int xMove, yMove;
	protected int width, height;
	protected Handler handler;
	protected Rectangle collisionBox;

	public Entity(Handler handler, float x, float y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		collisionBox = new Rectangle(0, 0, width, height);
	}
	
	public void reset(String path) {
		handler.getLevel().loadWorld(path);
	}
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset){
		return new Rectangle((int) (x + collisionBox.x + xOffset), (int) (y + collisionBox.y + yOffset), collisionBox.width, collisionBox.height);
	}
	
	public boolean isPickable() {
		return false;
	}
	
	public boolean isEnemy() {
		return false;
	}

	public abstract void update();

	public abstract void render(Graphics g);

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Rectangle getCollisionBox() {
		return collisionBox;
	}

	public void setCollisionBox(Rectangle collisionBox) {
		this.collisionBox = collisionBox;
	}

}
