package impossiblegame.level;

import java.awt.Graphics;

import impossiblegame.Handler;
import impossiblegame.entities.Coin;
import impossiblegame.entities.Enemy;
import impossiblegame.entities.EntityManager;
import impossiblegame.entities.HorizontalEnemy;
import impossiblegame.entities.Player;
import impossiblegame.entities.VerticalEnemy;
import impossiblegame.utils.utils;

public class Level {
	
	private int width, height, speed, distance, coinCount;
	private int[][] tileArray;
	private Handler handler;
	
	//x and y offset to center the enemies and coins to the center of their tile
	private static final int ENEMY_X_OFFSET = 6, ENEMY_Y_OFFSET = 6;
	private static final int COIN_X_OFFSET = 9, COIN_Y_OFFSET = 9;
	
	private EntityManager entityManager;
	
	public Level(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler);
		loadWorld(path);
	}
	
	/**
	 * converts information from the world.txt file into tileArray[][] and entityManager
	 * 
	 * @param path: specifies the path to the desired world file
	 */
	public void loadWorld(String path) {
		String file = utils.fileToString(path);
		String[] worldInfo = file.split("\\s+");
		
		width = utils.toInteger(worldInfo[0]);
		height = utils.toInteger(worldInfo[1]);
		speed = utils.toInteger(worldInfo[2]);
		distance = utils.toInteger(worldInfo[3]);
		coinCount = utils.toInteger(worldInfo[4]);
	
		tileArray = new int[width][height];
		
		//load tiles and entities in their desired spawn locations
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				
				//loads tiles into tileArray[][] in their desired locations
				tileArray[i][j] = utils.toInteger(worldInfo[(i + j * width) + 5]);
			
				//if statements used to load entities in their desired spawn locations
				if(tileArray[i][j] == 5)
					entityManager.addEntity(new Player(handler, i * Tile.TILE_HEIGHT, j * Tile.TILE_HEIGHT, 3));
				
				if(tileArray[i][j] == 102 || tileArray[i][j] == 112)
					entityManager.addEntity(new HorizontalEnemy
							(handler, i * Tile.TILE_WIDTH + ENEMY_X_OFFSET, j * Tile.TILE_HEIGHT + ENEMY_Y_OFFSET, 
									distance * Tile.TILE_WIDTH, speed, false));
				
				if(tileArray[i][j] == 104 || tileArray[i][j] == 114)
					entityManager.addEntity(new HorizontalEnemy
							(handler, i * Tile.TILE_WIDTH + ENEMY_X_OFFSET, j * Tile.TILE_HEIGHT + ENEMY_Y_OFFSET, 
									distance * Tile.TILE_WIDTH, speed, true));
				
				if(tileArray[i][j] == 101 || tileArray[i][j] == 111)
					entityManager.addEntity(new VerticalEnemy
							(handler, i * Tile.TILE_WIDTH + ENEMY_X_OFFSET, j * Tile.TILE_HEIGHT + ENEMY_Y_OFFSET, 
									distance * Tile.TILE_HEIGHT, speed, false));
				
				if(tileArray[i][j] == 103 || tileArray[i][j] == 113)
					entityManager.addEntity(new VerticalEnemy
							(handler, i * Tile.TILE_WIDTH + ENEMY_X_OFFSET, j * Tile.TILE_HEIGHT + ENEMY_Y_OFFSET, 
									distance * Tile.TILE_HEIGHT, speed, true));
				
				if(tileArray[i][j] == 10 || tileArray[i][j] == 11)
					entityManager.addEntity(new Coin
							(handler, i * Tile.TILE_WIDTH + COIN_X_OFFSET, j * Tile.TILE_HEIGHT + COIN_Y_OFFSET));
			}
		}
	}

	/**
	 * returns a tile at a specified x and y location
	 * 
	 * @param x: column of tile
	 * @param y: row of tile
	 * @return t: returned Tile
	 */
	public Tile getTile(int i, int j) {
		Tile t = Tile.tiles[tileArray[i][j]];
		if(t == null)
			return Tile.tBlue;
		return t;
	}
	
	/**
	 * Renders all tiles in tileArray[][]
	 * 
	 * @param g: graphics object
	 */
	public void render(Graphics g) {
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				getTile(i, j).render(g, i * Tile.TILE_WIDTH, j * Tile.TILE_HEIGHT);
			}
		}
	}

	//Getters and Setters
	public int getCoinCount() {
		return coinCount;
	}

	public void setCoinCount(int coinCount) {
		this.coinCount = coinCount;
	}

	public int[][] getTileArray() {
		return tileArray;
	}

	public void setTileArray(int[][] tileArray) {
		this.tileArray = tileArray;
	}	

	public EntityManager getEntityManager() {
		return entityManager;
	}


	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void update() {
		
	}
}
