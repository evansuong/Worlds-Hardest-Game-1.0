package impossiblegame.level;

public class GreenTileFinish extends GreenTile{

	public GreenTileFinish(int id) {
		super(id);
	}
	
	@Override
	public boolean isEnd() {
		return true;
	}
}
