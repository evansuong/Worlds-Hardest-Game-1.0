package impossiblegame.entities;

import java.awt.Rectangle;

import impossiblegame.Handler;
import impossiblegame.level.Tile;
import impossiblegame.states.State;

public abstract class MovingEntity extends Entity{

	protected int speed;
	protected int coinsPickedUp = 0;

	public MovingEntity(Handler handler, float x, float y, int width, int height, int speed) {
		super(handler, x, y, width, height);
		this.speed = speed;

		collisionBox = new Rectangle(0, 0, width, height);
	}

	public boolean checkEntityCollisions(float xOffset, float yOffset){
		for(Entity e : handler.getLevel().getEntityManager().getEntities()){
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) {
				if(e.isPickable()) {
					handler.getLevel().getEntityManager().removeEntity(e);
					coinsPickedUp++;
				}
				if(e.isEnemy()) {
					handler.getGameState().newLevel();
				}
				return true;
			}
		}
		return false;
	}

	public void moveX(){
		
		checkEntityCollisions(xMove, 0);
		
		//moving right
		if(xMove > 0){
			int nextX = (int) (x + xMove + collisionBox.x + collisionBox.width) / Tile.TILE_WIDTH;
			if(checkFinish(nextX, (int) (y + collisionBox.y) / Tile.TILE_HEIGHT) &&
					checkFinish(nextX, (int) (y + collisionBox.y + collisionBox.height) / Tile.TILE_HEIGHT)){
				State.setState(handler.getTransitionState());
			}
			if(!getTileCollisions(nextX, (int) (y + collisionBox.y) / Tile.TILE_HEIGHT) &&
					!getTileCollisions(nextX, (int) (y + collisionBox.y + collisionBox.height) / Tile.TILE_HEIGHT)){
				x += xMove;
			}else{
				x = nextX * Tile.TILE_WIDTH - collisionBox.x - collisionBox.width -1;
			}
		
		//moving left
		}else if(xMove < 0){
			int nextX = (int) (x + xMove + collisionBox.x) / Tile.TILE_WIDTH;
			if(checkFinish(nextX, (int) (y + collisionBox.y) / Tile.TILE_HEIGHT) &&
					checkFinish(nextX, (int) (y + collisionBox.y + collisionBox.height) / Tile.TILE_HEIGHT)){
				State.setState(handler.getTransitionState());
			}
			if(!getTileCollisions(nextX, (int) (y + collisionBox.y) / Tile.TILE_HEIGHT) &&
					!getTileCollisions(nextX, (int) (y + collisionBox.y + collisionBox.height) / Tile.TILE_HEIGHT)){
				x += xMove;
			}else{
				x = nextX * Tile.TILE_WIDTH + Tile.TILE_WIDTH - collisionBox.x ;
			}
		}
	}
	
	public void moveY(){
		
		checkEntityCollisions(0, yMove);
	
		//moving up
		if(yMove < 0){
			int nextY = (int) (y + yMove + collisionBox.y) / Tile.TILE_HEIGHT;
			
			if(checkFinish(nextY, (int) (y + collisionBox.y) / Tile.TILE_HEIGHT) &&
					checkFinish(nextY, (int) (y + collisionBox.y + collisionBox.height) / Tile.TILE_HEIGHT)){
				State.setState(handler.getTransitionState());
			}
			if(!getTileCollisions((int) (x + collisionBox.x) / Tile.TILE_WIDTH, nextY) &&
					!getTileCollisions((int) (x + collisionBox.x + collisionBox.width) / Tile.TILE_WIDTH, nextY)){
				y += yMove;
			}else{
				y = nextY * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - collisionBox.y;
			}
		
		//moving down
		}else if(yMove > 0){
			int nextY = (int) (y + yMove + collisionBox.y + collisionBox.height) / Tile.TILE_HEIGHT;
			
			if(checkFinish(nextY, (int) (y + collisionBox.y) / Tile.TILE_HEIGHT) &&
					checkFinish(nextY, (int) (y + collisionBox.y + collisionBox.height) / Tile.TILE_HEIGHT)){
				State.setState(handler.getTransitionState());
			}
			if(!getTileCollisions((int) (x + collisionBox.x) / Tile.TILE_WIDTH, nextY) &&
					!getTileCollisions((int) (x + collisionBox.x + collisionBox.width) / Tile.TILE_WIDTH, nextY)){
				y += yMove;
			}else{
				y = nextY * Tile.TILE_HEIGHT - collisionBox.y - collisionBox.height -1;
			}
		}
	}
	
	private boolean getTileCollisions(int x, int y) {
		return handler.getLevel().getTile(x, y).isSolid();
	}
	
	private boolean checkFinish(int x, int y) {
		if(handler.getLevel().getCoinCount() == coinsPickedUp) {
			return handler.getLevel().getTile(x, y).isEnd();
		}else {
			return false;
		}
		
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Rectangle getCollisionBox() {
		return collisionBox;
	}

	public void setCollisionBox(Rectangle collisionBox) {
		this.collisionBox = collisionBox;
	}

}
