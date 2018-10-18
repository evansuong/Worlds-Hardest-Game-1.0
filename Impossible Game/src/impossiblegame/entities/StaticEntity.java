package impossiblegame.entities;

import impossiblegame.Handler;

public abstract class StaticEntity extends Entity{
	
	protected boolean pickedUp = false;

	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}
}
