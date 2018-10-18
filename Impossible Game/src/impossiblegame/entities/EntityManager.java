package impossiblegame.entities;

import java.awt.Graphics;
import java.util.ArrayList;

import impossiblegame.Handler;

public class EntityManager {
	
	private ArrayList<Entity> entities = new ArrayList<Entity>();
	private Player player;
	private Handler handler;
	
	public EntityManager(Handler handler) {
		this.handler = handler;
	}
	
	public void update() {
		for(int i = 0; i < entities.size(); i++) {
			entities.get(i).update();
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < entities.size(); i++) {
			entities.get(i).render(g);
		}
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
	}
	
	public void removeEntity(Entity e) {
		entities.remove(e);
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	
	
}
