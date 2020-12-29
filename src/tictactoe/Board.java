package tictactoe;

import gui.AbstractBoardObserver;
import gui.BoardView;

import java.util.*;

public class Board {
	
	private final List<List<Tile>> aGrid = new ArrayList<List<Tile>>();
	private AbstractBoardObserver aObserver;

	public Board()
	{
		aObserver = new BoardView(this);
		for (int i = 0; i < 3; i++)
		{
			aGrid.add(new ArrayList<>());
			for (int j = 0; j < 3; j++)	
			{
				aGrid.get(i).add(new Tile());
			}
		}
	}
	
	public List<List<Tile>> getGrid()
	{
		return Collections.unmodifiableList(aGrid);
	}

	/*
	 * @pre this.containsTile(pTile)
	 */
	public void move(Team pTeam, Tile pTile) 
	{
		assert containsTile(pTile);
		pTile.setTeam(pTeam);
//		aObserver.tileChanged(pTile);
	}
	
	public boolean containsTile(Tile pTile)
	{
		for (List<Tile> list: aGrid)
		{
			if (list.contains(pTile)) return true;
		}
		return false;
	}
	
	public AbstractBoardObserver getObserver()
	{
		return aObserver;
	}
}
