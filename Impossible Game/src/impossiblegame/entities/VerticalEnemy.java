package impossiblegame.entities;

import impossiblegame.Handler;

public class VerticalEnemy extends Enemy {
	
	private int distance;
	private boolean direction;
	private int yMin, yMax;

	public VerticalEnemy(Handler handler, float x, float y, int distance, int speed,
			boolean direction) {
		super(handler, x, y, speed);
		this.distance = distance;
		this.direction = direction;
		if (direction) {
			yMin = (int) y;
			yMax = (int) y + distance;
		} 
		if(!direction){
			yMax = (int) y;
			yMin = (int) y - distance;
			speed = -speed;
		}
	}

	@Override
	public void update() {
		checkDirection();
		yMove = speed;
		moveY();
	}

	public void checkDirection() {
		if (y > yMax)
			speed = -speed;
		if (y < yMin)
			speed = -speed;
	}
}
