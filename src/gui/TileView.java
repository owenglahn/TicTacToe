package gui;

import javafx.scene.control.Button;
import tictactoe.Tile;

public class TileView extends Button implements AbstractBoardObserver {
	
	private Tile aTile;
	
	/*
	 * @pre pTile != null
	 */
	public TileView( Tile pTile )
	{
		assert pTile != null;
		aTile = pTile;
	}

	/*
	 * @pre !aTile.isBlank()
	 */
	@Override
	public void tileChanged() 
	{
		assert ! aTile.isBlank();
		setText(aTile.getTeam().get().toString());
	}

}
