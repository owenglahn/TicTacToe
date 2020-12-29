package tictactoe;

import java.util.List;
import java.util.Optional;

import gui.TileView;

public class Tile {
	
	private Optional<Team> aTeam;
	
	public boolean isBlank()
	{
		return aTeam.isEmpty();
	}
	
	public Optional<Team> getTeam()
	{
		return aTeam;
	}
	
	public void setTeam(Team pTeam)
	{
		aTeam = Optional.ofNullable(pTeam);
	}
	
	/*
	 * @pre Board.INSTANCE.containsTile(this)
	 */
	public int[] getPosition(Board pBoard)
	{
		assert pBoard.containsTile(this);
		int[] pos = new int[2];
		List<List<Tile>> grid = pBoard.getGrid();
		for (int i = 0; i < 3; i++)
		{
			if (grid.get(i).contains(this)) 
			{
				pos[0] = i;
				pos[1] = grid.get(i).indexOf(this);
			}
		}
		return pos;
	}
}
