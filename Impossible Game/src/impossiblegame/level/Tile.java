package impossiblegame.level;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import impossiblegame.Handler;
import impossiblegame.level.coinTiles.CoinTileGrey;
import impossiblegame.level.coinTiles.CoinTileWhite;
import impossiblegame.level.enemyTiles.EnemyGreyTileF;
import impossiblegame.level.enemyTiles.EnemyGreyTileXL;
import impossiblegame.level.enemyTiles.EnemyGreyTileXR;
import impossiblegame.level.enemyTiles.EnemyGreyTileYD;
import impossiblegame.level.enemyTiles.EnemyGreyTileYU;
import impossiblegame.level.enemyTiles.EnemyWhiteTileF;
import impossiblegame.level.enemyTiles.EnemyWhiteTileXL;
import impossiblegame.level.enemyTiles.EnemyWhiteTileXR;
import impossiblegame.level.enemyTiles.EnemyWhiteTileYD;
import impossiblegame.level.enemyTiles.EnemyWhiteTileYU;
import impossiblegame.level.playerTile.PlayerTile;

public class Tile {
	
	public static Tile[] tiles = new Tile[256];
	public static Tile tGrey = new GreyTile(0);
	public static Tile tWhite = new WhiteTile(1);
	public static Tile tGreen = new GreenTile(2);
	public static Tile tGreenFinish = new GreenTileFinish(3);
	public static Tile tBlue = new BlueTile(4);
	public static Tile tPlayer = new PlayerTile(5);
	public static Tile cGrey = new CoinTileGrey(10);
	public static Tile cWhite = new CoinTileWhite(11);
	public static Tile tGreyF = new EnemyGreyTileF(100);
	public static Tile tGreyXL = new EnemyGreyTileXL(102);
	public static Tile tGreyXR = new EnemyGreyTileXR(104);
	public static Tile tGreyYU = new EnemyGreyTileYU(101);
	public static Tile tGreyYD = new EnemyGreyTileYD(103);
	public static Tile tWhiteF = new EnemyWhiteTileF(110);
	public static Tile tWhiteXL = new EnemyWhiteTileXL(112);
	public static Tile tWhiteXR = new EnemyWhiteTileXR(114);
	public static Tile tWhiteYU = new EnemyWhiteTileYU(111);
	public static Tile tWhiteYD = new EnemyWhiteTileYD(113);
	
	protected int id;
	protected BufferedImage texture;
	protected int x, y;
	
	public static final int TILE_WIDTH = 32, TILE_HEIGHT = 32;
	
	public Tile(BufferedImage texture, int id) {
		this.id = id;
		this.texture = texture;
		tiles[id] = this;
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}

	public boolean isSolid() {
		return false;
	}
	
	public boolean isEnd() {
		return false;
	}
	
	public int getId() {
		return id;
	}
}
