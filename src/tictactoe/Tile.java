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
		return aTeam.get().toString();
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
		}
		else if ( pTeam == null ) 
		{
			aTeam = Optional.empty();
			aObserver.tileChanged();
		}
	}
	
	public AbstractObserver getObserver()
	{
		return aObserver;
	}
	
	@Override
	public boolean equals(Object pTile)
	{
		assert pTile.getClass().equals(Tile.class);
		return aTeam.equals(((Tile)pTile).aTeam);
	}
	
	@Override
	public int hashCode()
	{
		return aTeam.hashCode();
	}
}
