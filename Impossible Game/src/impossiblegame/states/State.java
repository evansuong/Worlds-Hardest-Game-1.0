package impossiblegame.states;

import java.awt.Graphics;

import impossiblegame.Handler;

public abstract class State {
	
	Handler handler;
	
	public State(Handler handler) {
		this.handler = handler;
	}
	
	private static State currentState = null;

	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}

	public abstract void update();
	
	public abstract void render(Graphics g);

	public String getLevelPath() {
		return null;
	}
	
	public void newLevel() {
		
	}
}
