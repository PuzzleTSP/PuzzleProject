//*** Author: Wiley Roemer
//*** Date Created: 10/15/18
//*** Date Modified: 10/22/18
//*** Description:

import java.util.*;

public class SoccerBoxGameboard {



  //Instance variables, 2D-array of BoardTile's functions as gameBoard
  //"blocks" functions as the list of pieces on the board.

  protected BoardTile[][] gameBoard = null;
  protected ArrayList<PuzzleBlock> blocks = new ArrayList<PuzzleBlock>(10);



  //Constructor, initializes the gameboard and pieces
  public SoccerBoxGameboard ( ) {

    gameBoard = new BoardTile[4][5];        //Create Board
    initBlocks();                       //Initialize puzzle blocks

    for( int i = 0; i < 4; i++ ) {
      for( int j = 0; j < 5; j++ ) {
        gameBoard[i][j] = new BoardTile(i, j);   //Initialize board tiles
        }
      }

    initOccupations();            //Assign puzzle blocks to their tiles

    }


/*
void initBlocks()

A method which creates the 10 puzzle piece objects and assigns them their
starting x/y positions.

*/

 public void initBlocks() {

   PuzzleBlock goal = new PuzzleBlock2x2(1, 0);
   blocks.add(goal);
   PuzzleBlock singleA = new PuzzleBlock1x1(1, 3);
   blocks.add(singleA);
   PuzzleBlock singleB = new PuzzleBlock1x1(1, 4);
   blocks.add(singleB);
   PuzzleBlock singleC = new PuzzleBlock1x1(2, 3);
   blocks.add(singleC);
   PuzzleBlock singleD = new PuzzleBlock1x1(2, 4);
   blocks.add(singleD);
   PuzzleBlock wide = new PuzzleBlock2x1(1, 2);
   blocks.add(wide);
   PuzzleBlock tallA = new PuzzleBlock1x2(0,1);
   blocks.add(tallA);
   PuzzleBlock tallB = new PuzzleBlock1x2(0,3);
   blocks.add(tallB);
   PuzzleBlock tallC = new PuzzleBlock1x2(3,1);
   blocks.add(tallC);
   PuzzleBlock tallD = new PuzzleBlock1x2(3,3);
   blocks.add(tallD);
   
 }



 public void initOccupations() {

   for( PuzzleBlock p : blocks ) {
     if( p instanceof PuzzleBlock2x2 ) {
       int x = p.getX();
       int y = p.getY();

       gameBoard[x][y].setOccupied( p );
       gameBoard[x+1][y].setOccupied( p );
       gameBoard[x][y+1].setOccupied( p );
       gameBoard[x+1][y+1].setOccupied( p );

     } else if( p instanceof PuzzleBlock1x2 ) {
       int x = p.getX();
       int y = p.getY();

       gameBoard[x][y].setOccupied(p);
       gameBoard[x][y+1].setOccupied(p);
     } else if( p instanceof PuzzleBlock2x1 ) {
       int x = p.getX();
       int y = p.getY();

       gameBoard[x][y].setOccupied(p);
       gameBoard[x+1][y].setOccupied(p);
     } else {
       int x = p.getX();
       int y = p.getY();

       gameBoard[x][y].setOccupied(p);
     }
   }

 }

}
