package impossiblegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import impossiblegame.display.Display;
import impossiblegame.gfx.Assets;
import impossiblegame.input.KeyManager;
import impossiblegame.level.Level;
import impossiblegame.states.GameState;
import impossiblegame.states.MenuState;
import impossiblegame.states.State;
import impossiblegame.states.TransitionState;

public class Gameplay implements Runnable {

	//window
	private Display display;
	private int width, height;
	private String title;

	//graphics
	private BufferStrategy bs;
	private Graphics g;
	private Assets assets;

	//handler
	private Handler handler;
	
	//game run
	private Thread thread;
	private boolean running = false;
	
	//states
	private State menuState;
	private State gameState;
	private State transitionState;
	
	//input managers
	private KeyManager keyManager;
	
	public Gameplay(String title, int width, int height) {
		this.width = width;
		this.height = height;
		display = new Display();
		display.newWindow(title, width, height);
		
		keyManager = new KeyManager();
	}

	// INITIALIZE
	private void init() {
		display.getFrame().addKeyListener(keyManager);
		
		Assets.init();
		
		handler = new Handler(this);
		menuState = new MenuState(handler);
		gameState = new GameState(handler);
		transitionState = new TransitionState(handler);
		State.setState(gameState);
	}

	public void run() {
		init();

		// GAMELOOP

		int fps = 60;
		double timePerTick = 1_000_000_000 / fps;
		double timeChange = 0;
		long currentTime;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while (running) {
			currentTime = System.nanoTime();
			timeChange += currentTime - lastTime;
			timer += currentTime - lastTime;
			lastTime = currentTime;
			
			if(timeChange >= timePerTick) {
				update();
				render();
				ticks++;
				timeChange = 0;
			}
			if(timer >= 1_000_000_000) {
				System.out.println(ticks);
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}
	
	private void update() {
		State.getState().update();
	}

	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		State.getState().render(g);
		
		bs.show();
		g.dispose(); 
	}

	public synchronized void start() {
		if (running)
			return;
		thread = new Thread(this);
		running = true;
		thread.start();
	}

	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public State getMenuState() {
		return menuState;
	}

	public void setMenuState(State menuState) {
		this.menuState = menuState;
	}

	public State getGameState() {
		return gameState;
	}

	public void setGameState(State gameState) {
		this.gameState = gameState;
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public void setKeyManager(KeyManager keyManager) {
		this.keyManager = keyManager;
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

	public State getTransitionState() {
		return transitionState;
	}

	public void setTransitionState(State transitionState) {
		this.transitionState = transitionState;
	}
	
}
