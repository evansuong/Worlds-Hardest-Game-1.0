package impossiblegame.states;

import java.awt.Graphics;

import impossiblegame.Handler;
import impossiblegame.gfx.Assets;

public class TransitionState extends State{

	public TransitionState(Handler handler) {
		super(handler);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.background, 0, 0, handler.getWidth(), handler.getHeight(), null);
	}

}
