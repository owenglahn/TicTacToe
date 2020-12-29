package tictactoe;

import java.util.Optional;

import gui.AbstractObserver;
import gui.TileView;

public class Tile {
	
	private Optional<Team> aTeam = Optional.empty();
	private final AbstractObserver aObserver = new TileView(this);
	
	public boolean isBlank()
	{
		return aTeam.isEmpty();
	}
	
	/*
	 * @pre ! aTeam.isEmpty()
	 */
	public String getTeamAsString()
	{
		assert ! aTeam.isEmpty();
		return aTeam.toString();
	}
	
	/*
	 * 
	 */
	public void setTeam(Team pTeam)
	{
		if (aTeam.isEmpty()) 
		{
			aTeam = Optional.ofNullable(pTeam);
			aObserver.tileChanged();
		} else {
			return;
		}
	}
	
	public AbstractObserver getObserver()
	{
		return aObserver;
	}
	
	public void setLayout(int pX, int pY)
	{
		assert aObserver.getClass().equals(TileView.class);
		((TileView)aObserver).setLayout(pX, pY);
	}
}
