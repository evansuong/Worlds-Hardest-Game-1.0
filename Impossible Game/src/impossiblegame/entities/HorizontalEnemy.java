package impossiblegame.entities;

import impossiblegame.Handler;

public class HorizontalEnemy extends Enemy {

	private int distance;
	private int xMax, xMin;
	private boolean direction;

	public HorizontalEnemy(Handler handler, float x, float y, int distance, int speed,
			boolean direction) {
		super(handler, x, y, speed);
		this.distance = distance;
		this.direction = direction;
		if (direction) {
			xMin = (int) x;
			xMax = (int) x + distance;
		} 
		if(!direction){
			xMax = (int) x;
			xMin = (int) x - distance;
			speed = -speed;
		}
	}

	@Override
	public void update() {
		checkDirection();
		xMove = speed;
		moveX();
	}

	public void checkDirection() {
		if (x > xMax)
			speed = -speed;
		if (x < xMin)
			speed = -speed;
	}
}
