package impossiblegame.entities;

import impossiblegame.Handler;

public class FreeEnemy extends Enemy{
	
	private float xMin, xMax, yMin, yMax;

	public FreeEnemy(Handler handler, float x, float y, int speed, float xMin, float xMax, float yMin, float yMax) {
		super(handler, x, y, speed);
		
	}

}
