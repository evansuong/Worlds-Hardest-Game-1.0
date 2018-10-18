package impossiblegame.display;

import java.awt.Canvas;

import javax.swing.JFrame;

public class Display extends JFrame{
	
	JFrame frame;
	Canvas canvas;
	
	public void newWindow(String title, int width, int height) {
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setSize(width, height);
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
	
	

}
