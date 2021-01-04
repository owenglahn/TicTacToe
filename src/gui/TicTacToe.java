package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.util.*;

import tictactoe.*;

public class TicTacToe extends Application 
{
	public static final int DIMENSION = 300;
	private static Team aCurrentTeam = Team.X;

	public static void main(String[] pArgs) 
	{
		launch(pArgs);
	}

	@Override
	public void start(Stage pStage) throws Exception 
	{
		try {
			pStage.setTitle("Tic-Tac-Toe");
			GridPane root = new GridPane();
			Board instance = new Board();
			setButtonSizes(instance);
			List<HBox> rows = setRows(instance);
			for ( int i = 0 ; i < rows.size() ; i++ )
			{
				root.addRow(i, rows.get(i));
			}
			setTilesOnAction(instance);
			pStage.setScene(new Scene(root, DIMENSION, DIMENSION + 20));
			pStage.show();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
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
						changeCurrentTeam();
						if ( pBoard.hasWinner() )
							declareWinner(tile.getTeamAsString());
					}
				});
			}
		}
	}
	
	/*
	 * @pre pBoard != null, pBoard.getGrid().size() == 3
	 */
	private static List<HBox> setRows(Board pBoard)
	{
		assert pBoard != null && pBoard.getGrid().size() == 3;
		List<HBox> rows = new ArrayList<>();
		HBox top = new HBox();
		HBox middle = new HBox();
		HBox bottom = new HBox();
		HBox restartBox = new HBox();
		Button restart = new Button("Restart Game");
		restart.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) 
			{
				pBoard.clear();
				aCurrentTeam = Team.X;
			}
			
		});
		restart.setPrefWidth(DIMENSION);
		restart.setStyle("-fx-background-color: LimeGreen;");
		rows.add(top);
		rows.add(middle);
		rows.add(bottom);
		rows.add(restartBox);
		for ( Tile tile : pBoard.getGrid().get(0) )
		{
			top.getChildren().add((TileView)tile.getObserver());
		}
		for ( Tile tile : pBoard.getGrid().get(1) )
		{
			middle.getChildren().add((TileView)tile.getObserver() );
		}
		for ( Tile tile : pBoard.getGrid().get(2) )
		{
			bottom.getChildren().add((TileView)tile.getObserver());
		}
		restartBox.getChildren().add(restart);
		return rows;
	}
	
	private static void setButtonSizes(Board pBoard)
	{
		for ( List<Tile> list : pBoard.getGrid() )
		{
			for ( Tile tile : list )
			{
				((TileView)tile.getObserver()).setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
				((TileView)tile.getObserver()).setPrefSize(DIMENSION/3, DIMENSION/3);
			}
		}
	}
	
	private static void changeCurrentTeam()
	{
		aCurrentTeam = Team.values()[(aCurrentTeam.ordinal() + 1) % 2];
	}
	
	private static void declareWinner(String pTeamName)
	{
		Alert winMessage = new Alert(Alert.AlertType.INFORMATION);
		winMessage.setHeaderText("Winner is " + pTeamName + "!");
		winMessage.show();
	}
}
