package impossiblegame.states;

import java.awt.Graphics;

import impossiblegame.Handler;
import impossiblegame.entities.Enemy;
import impossiblegame.entities.EntityManager;
import impossiblegame.entities.Player;
import impossiblegame.level.Level;

public class GameState extends State {

	private Level level;
	private int levelNumber = 1;
	private String levelPath;
	private String level1 = "res/worlds/level1.txt";

	public GameState(Handler handler) {
		super(handler);
		newLevel();
		handler.setLevel(level);
	}
	
	@Override
	public void newLevel() {
		System.out.println("hit");
		level = new Level(handler, getLevelPath());
		handler.setLevel(level);
	}

	@Override
	public String getLevelPath() {
		switch (levelNumber) {
		case 1:
			levelPath = level1;
		}
		return levelPath;
	}

	@Override
	public void update() {
		handler.getKeyManager().update();
		level.update();
		handler.getLevel().getEntityManager().update();
	}

	@Override
	public void render(Graphics g) {
		level.render(g);
		handler.getLevel().getEntityManager().render(g);
	}
}
