package gui;

import javafx.scene.control.Button;
import tictactoe.Tile;

public class TileView extends Button implements AbstractObserver {
	
	private final Tile aTile;
	private boolean aPositionSet = false;
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
	 * @pre !aTile.isBlank()
	 */
	@Override
	public void tileChanged() 
	{
		assert ! aTile.isBlank();
		setText(aTile.getTeamAsString());
	}
	
	/*
	 * @pre ! aPositionSet
	 */
	public void setLayout(int pX, int pY)
	{
		assert ! aPositionSet;
		setLayoutX(pX);
		setLayoutY(pY);
		aPositionSet = true;
	}
}
