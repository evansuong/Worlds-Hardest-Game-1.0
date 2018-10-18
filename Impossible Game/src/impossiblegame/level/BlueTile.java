package impossiblegame.level;

import java.awt.Graphics;

import impossiblegame.gfx.Assets;

public class BlueTile extends Tile{

	public BlueTile(int id) {
		super(Assets.tBlue, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
}
