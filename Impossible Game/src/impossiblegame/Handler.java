package impossiblegame;

import impossiblegame.input.KeyManager;
import impossiblegame.level.Level;
import impossiblegame.states.GameState;
import impossiblegame.states.State;

public class Handler {
	
	private Gameplay game;
	private Level level;
	
	public Handler(Gameplay game) {
		this.game = game;
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}
	
	public State getGameState() {
		return game.getGameState();
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
	
	public State getTransitionState() {
		return game.getTransitionState();
	}
}
