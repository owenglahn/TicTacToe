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
}
