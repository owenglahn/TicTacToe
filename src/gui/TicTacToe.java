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
			BoardView instanceView = new BoardView(instance);
			instanceView.setLayout();
			
			pStage.setScene(new Scene(root, DIMENSION, DIMENSION));
			pStage.show();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private void setAllOnAction(Board pBoard)
	{
		AbstractBoardObserver observer = pBoard.getObserver();
		for ( List<Tile> list : pBoard.getGrid() )
		{
			for ( Tile tile : list )
			{
				
			}
		}
	}
}
