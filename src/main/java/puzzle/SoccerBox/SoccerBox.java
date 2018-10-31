//*** Author: Wiley Roemer
//*** Date Created: 10/15/18
//*** Date Modified: 10/22/18
//*** Description:

import puzzle.*;
import javafx.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.*;
import javafx.scene.layout.Pane;

public class SoccerBox implements Puzzle {

	
	SoccerBoxGameboard gameBoard = new SoccerBoxGameboard();
	
	
	Pane gameScreen = null;
	Rectangle board = null;
	
@Override
public String getName() {
	return "Soccer Box";
}
	


@Override
public Pane run() {
   gameScreen = new Pane();
	
   
  
  return gameScreen;
}


@Override
public void exit() {
  
}
	
	

public Rectangle drawBoard( Rectangle board ) {
	
	return board;
}

	
}