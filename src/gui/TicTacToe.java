package gui;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.util.*;

import tictactoe.*;

public class TicTacToe extends Application 
{
	public static final int DIMENSION = 400;
	private static Team aCurrentTeam = Team.X;

	public static void main(String[] pArgs) 
	{
		launch(pArgs);
	}

	@Override
	public void start(Stage pStage) throws Exception 
	{// TODO
		try {
			pStage.setTitle("Tic-Tac-Toe");
			Parent root = new GridPane();
			Board instance = new Board();
			setTileViews(instance);
			setTilesOnAction(instance);
			pStage.setScene(new Scene(root, DIMENSION, DIMENSION));
			pStage.show();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private static void changeTeam()
	{
		aCurrentTeam = Team.values()[(aCurrentTeam.ordinal() + 1) % 2];
	}
	
	private static void setTilesOnAction(Board pBoard)
	{
		for ( List<Tile> list : pBoard.getGrid() )
		{
			for ( Tile tile : list )
			{
				((TileView)tile.getObserver()).setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent pEvent) 
					{
						tile.setTeam(aCurrentTeam);
						changeTeam();
					}
					
				});
			}
		}
	}
	
	private static void setTileViews(Board pBoard)
	{
		int separation = DIMENSION/3;
		int startingPoint = -separation/2;
		int countY = 1;
		for ( List<Tile> list : pBoard.getGrid() )
		{
			int countX = 1;
			int y = separation * countY + startingPoint;
			for ( Tile tile : list )
			{
				int x = separation * countX + startingPoint;
				tile.setLayout(x, y);
				countX++;
			}
			countY++;
		}
	}
}
