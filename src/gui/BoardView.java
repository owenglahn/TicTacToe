package gui;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import tictactoe.Board;
import tictactoe.Tile;
import java.util.*;

public class BoardView extends Parent implements AbstractBoardObserver {
	
	private final Board aModel;
	private List<List<Button>> aTileViews = new ArrayList<>();
	
	public BoardView(Board pModel)
	{
		aModel = pModel;
		for ( int i = 0 ; i < aModel.getGrid().size(); i++ )
		{
			aTileViews.add(new ArrayList<Button>());
			for ( int j = 0; j < aModel.getGrid().get(i).size() ; j++ )
			{
				aTileViews.get(i).add(new Button());
			}
		}
	}
	
	public void setLayout()
	{
		int separation = TicTacToe.DIMENSION/3;
		int startingPoint = -separation/2;
		for ( List<Button> list : aTileViews )
		{
			int counter = 1;
			for ( Button button : list )
			{
				button.setLayoutX(startingPoint + separation * counter);
				counter ++;
			}
		}
	}
	
//	/*
//	 * @pre pTile != null, ! pTile.isBlank()
//	 */
//	public void tileChanged(Tile pTile)
//	{
//		assert pTile != null && ! pTile.isBlank();
//		int[] coords = pTile.getPosition(aModel);
//		getButtonAtCoords(coords).setText(pTile.getTeam().toString());
//	}
	
	/*
	 * @pre pCoords.length == 2
	 */
	private Button getButtonAtCoords(int[] pCoords)
	{
		assert pCoords.length == 2;
		return aTileViews.get(pCoords[0]).get(pCoords[1]);
	}
}
