package gui;

import javafx.scene.control.Button;
import tictactoe.Tile;

public class TileView extends Button implements AbstractObserver {
	
	private final Tile aTile;
	{
		setStyle("-fx-font-size: 4em; ");
	}
	
	/*
	 * @pre pTile != null
	 */
	public TileView( Tile pTile )
	{
		assert pTile != null;
		aTile = pTile;
	}

	/*
	 */
	@Override
	public void tileChanged() 
	{
		if ( aTile.isBlank() ) 
		{
			setText(null);
			return;
		}
		setText(aTile.getTeamAsString());
	}
}
