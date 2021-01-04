package tictactoe;

import java.util.*;

public class Board {
	
	private final List<List<Tile>> aGrid = new ArrayList<List<Tile>>();
	{
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
	
	public boolean hasWinner()
	{
		return isColumnWin() || isRowWin() || isDiagonalWin();
	}
	
	private boolean isColumnWin()
	{
		for ( int i = 0 ; i < 3 ; i++ )
		{
			if ( aGrid.get(0).get(i).equals(aGrid.get(1).get(i)) && aGrid.get(0).get(i).equals(aGrid.get(2).get(i)) 
					&& !aGrid.get(0).get(i).isBlank()) 
				return true;
		}
		return false;
	}
	
	private boolean isRowWin()
	{
		for ( List<Tile> list : aGrid )
		{
			if ( list.get(0).isBlank() ) return false;
			if ( list.get(0).equals(list.get(1)) && list.get(0).equals(list.get(2))) 
				return true;
		}
		return false;
	}
	
	private boolean isDiagonalWin()
	{
		Tile topLeft = aGrid.get(0).get(0);
		Tile topRight = aGrid.get(0).get(2);
		Tile center = aGrid.get(1).get(1);
		Tile bottomRight = aGrid.get(2).get(2);
		Tile bottomLeft = aGrid.get(2).get(0);
		return (topLeft.equals(center) && topLeft.equals(bottomRight) && ! topLeft.isBlank())  
				|| (topRight.equals(center) && topRight.equals(bottomLeft) && ! topRight.isBlank());
	}
	
	public void clear()
	{
		for ( List<Tile> list : aGrid )
		{
			for ( Tile tile : list )
			{
				tile.setTeam(null);
			}
		}
	}
}
