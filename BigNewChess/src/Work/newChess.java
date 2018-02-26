package Work;


import java.util.Scanner;

import java.lang.Exception;
import java.lang.Error;

class Board{
	protected static char[][] myboard;
	
	public Board() {
		//Initialize board
		myboard = new char [20][23];
	}
	
	public void setup()
	{
		 for(int i = 0; i < 20; i++)
			{
				for (int p = 0; p < 23; p++)
				{
					myboard[i][p] = ' ';
				}
			}
		 
		 //Initialize setup of player 1
			for(int q = 4; q < 9 ; q+=4)
			{
				for(int a = 5; a< 18; a += 4)
				{
					myboard[a][q] = '1';
				}
			}
			{

				myboard[3][6] = '1';
				myboard[7][6] = '1';
				myboard[11][6] = '1';
				myboard[15][6] = '1';
				}
			
			//Initialize Player 2
			for(int a = 3; a < 16; a+=4)
			{
				myboard[a][14] = '2';
				myboard[a][18] = '2';
			}
			
			{

			myboard[5][16] = '2';
			myboard[9][16] = '2';
			myboard[13][16] = '2';
			myboard[17][16] = '2';
			}
			
			//Generate number grid setup
			myboard[3][2] = '0';
			myboard[5][2] = '1';
			myboard[7][2] = '2';
			myboard[9][2] = '3';
			myboard[11][2] = '4';
			myboard[13][2] = '5';
			myboard[15][2] = '6';
			myboard[17][2] = '7';
			
			myboard[0][4] = '0';
			myboard[0][6] = '1';
			myboard[0][8] = '2';
			myboard[0][10] = '3';
			myboard[0][12] = '4';
			myboard[0][14] = '5';
			myboard[0][16] = '6';
			myboard[0][18] = '7';
			
			myboard[2][3] = '+';
			myboard[19][3] = '+';
			myboard[2][19] = '+';
			myboard[19][19] = '+';
		
			//Generate Borders
			for(int x = 3; x < 19; x++)
			{
				myboard[x][3] = '-';
				myboard[x][19] = '-';
			}
			
			for(int y = 4; y < 19; y++)
			{
				myboard[2][y] = '|';
				myboard[19][y] = '|';
			}
			
	}
	
	
	public void printboard() {
		for(int i = 0; i < 23; i++)
		{
			for (int p = 0; p < 20; p++)
			{
				if(p < 19)
				{
				System.out.print(myboard[p][i]);
				}
				else if(p == 19)
				{
					System.out.print(myboard[p][i] + "\n"); 
				}
			}

		}
	}
	
	public static char outBoard(int x, int y)
	{
		return myboard[x][y];
	}
	
	public static void boardChange(position pos1, position pos2, Player currentPlayer)
	{
		myboard[(2*pos1.x) + 3][2*(pos1.y) +4] = ' ';
		myboard[2*pos2.x + 3][2*pos2.y+4] = currentPlayer.playerSymbol;
	}
	
}

class MyException extends Exception{
	public MyException(String message) {
		super(message);
	}
}

class position {
	public int x;
	public int y;
	public int xConverted;
	public int yConverted;
	
	public position(int newx, int newy){
		this.x = newx;
		this.y = newy;
		
		this.xConverted = (this.x*2) +3;
		this.yConverted = (this.y*2)+4;
	}
	
	
	public Boolean isOnBoard() 
	{
			if (this.x<0 || this.x>7){
			return false;
		}
		else if (this.y < 0 || this.y > 7){
			return false;
		}
		else{
			return true;
				}
		
	}
}

class Player {
	public Boolean isPlayer1;
	public AbstractPiece[] PieceArray;
	char playerSymbol;
	
	public Player (Boolean isItPlayer1)
	{
		if (isItPlayer1 == true)
		{
			isPlayer1 = true;
			playerSymbol = '1';
			PieceArray = new BlackPiece[12];
			for (int i = 0; i < 12; i++)
			{
				PieceArray[i] = new BlackPiece();
				PieceArray[i].currentPosition = new position(0,0);
			}
			//PieceArray = new BlackPiece[12];
			PieceArray[0].currentPosition.x = 1;
			PieceArray[0].currentPosition.y = 0;
			PieceArray[1].currentPosition.x = 3;
			PieceArray[1].currentPosition.y = 0;
			PieceArray[2].currentPosition.x = 5;
			PieceArray[2].currentPosition.y = 0;
			PieceArray[3].currentPosition.x = 7;
			PieceArray[3].currentPosition.y = 0;
				
			PieceArray[4].currentPosition.x = 0;
			PieceArray[4].currentPosition.y = 1;
			PieceArray[5].currentPosition.x = 2;
			PieceArray[5].currentPosition.y = 1;
			PieceArray[6].currentPosition.x = 4;
			PieceArray[6].currentPosition.y = 1;
			PieceArray[7].currentPosition.x = 6;
			PieceArray[7].currentPosition.y = 1;
			
			PieceArray[8].currentPosition.x = 1;
			PieceArray[8].currentPosition.y = 2;
			PieceArray[9].currentPosition.x = 3;
			PieceArray[9].currentPosition.y = 2;
			PieceArray[10].currentPosition.x = 5;
			PieceArray[10].currentPosition.y = 2;
			PieceArray[11].currentPosition.x = 7;
			PieceArray[11].currentPosition.y = 2;
			
		}
		
		else if (isItPlayer1 == false)
		{
			isPlayer1 = false;
			playerSymbol = '2';
			PieceArray = new WhitePiece[12];
			for (int i = 0; i < 12; i++)
			{
				PieceArray[i] = new WhitePiece();
				PieceArray[i].currentPosition = new position(0,0);
			}
			PieceArray[0].currentPosition.x = 0;
			PieceArray[0].currentPosition.y = 5;
			PieceArray[1].currentPosition.x = 2;
			PieceArray[1].currentPosition.y = 5;
			PieceArray[2].currentPosition.x = 4;
			PieceArray[2].currentPosition.y = 5;
			PieceArray[3].currentPosition.x = 6;
			PieceArray[3].currentPosition.y = 5;
			
			PieceArray[4].currentPosition.x = 1;
			PieceArray[4].currentPosition.y = 6;
			PieceArray[5].currentPosition.x = 3;
			PieceArray[5].currentPosition.y = 6;
			PieceArray[6].currentPosition.x = 5;
			PieceArray[6].currentPosition.y = 6;
			PieceArray[7].currentPosition.x = 7;
			PieceArray[7].currentPosition.y = 6;
			
			PieceArray[8].currentPosition.x = 0;
			PieceArray[8].currentPosition.y = 7;
			PieceArray[9].currentPosition.x = 2;
			PieceArray[9].currentPosition.y = 7;
			PieceArray[10].currentPosition.x = 4;
			PieceArray[10].currentPosition.y = 7;
			PieceArray[11].currentPosition.x = 6;
			PieceArray[11].currentPosition.y = 7;
		}
		
	}
}

interface Piece {
	public void move(position pos1, position pos2, Player currentPlayer);
	public Boolean ValidatePieceSelection(position pieceSelection);
	public Boolean ValidateMovementSelection(position moveSelection, position checkPosition);
}

abstract class AbstractPiece implements Piece {
	public position currentPosition;
	//public Player owner;
	
	public AbstractPiece(){
		
	}

	@Override
	public void move(position pos1, position pos2, Player currentPlayer) {
		
		Board.boardChange(pos1, pos2, currentPlayer);
		
	}

	//Don't need these 2 as long as AbstractPiece is abstract
	//public Boolean ValidatePieceSelection(position selectPosition){
		
	//}
	//public Boolean ValidateMovementSelection(position movePosition){
		
	//}
}


class BlackPiece extends AbstractPiece{

	public BlackPiece() {
	}
	
	@Override
	public Boolean ValidatePieceSelection(position selectPosition){
			if(selectPosition.isOnBoard())
			{
			position tempPos = new position((selectPosition.x+1), (selectPosition.y+1));
			position tempPos2 = new position((selectPosition.x-1), (selectPosition.y+1));
			if(Board.outBoard(2*(selectPosition.x)+3, 2*(selectPosition.y)+4) == '1' && Board.outBoard(2*(selectPosition.x+1)+3, 2*(selectPosition.y+1)+4) == ' ' && tempPos.isOnBoard())
			{
				return true;
			}
			else if (Board.outBoard(2*(selectPosition.x)+3, 2*(selectPosition.y)+4) == '1' && Board.outBoard(2*(selectPosition.x-1)+3, 2*(selectPosition.y+1)+4) == ' ' && tempPos2.isOnBoard())
			{
				return true;
			}
			else
			{
				return false;
				
			}
		}
		else
		{
			return false;
		}
		
	}
	
	@Override
	public Boolean ValidateMovementSelection(position movePosition, position checkPosition){
		try {
			
		if((movePosition.y ==  checkPosition.y+ 1) && ((movePosition.x == checkPosition.x +1) || (movePosition.x == checkPosition.x - 1)) && movePosition.isOnBoard())
		{
			if (Board.outBoard(movePosition.xConverted, movePosition.yConverted) == ' ')
			{
				return true;
			}
			else
			{
				throw new MyException("Invalid move position");
			}
		}
		else
		{
			throw new MyException("Invalid move position");
		}
		}
		
		catch (MyException e){
			System.out.println("Invalid entry");
			return false;
		}
	}
	
	
}

class WhitePiece extends AbstractPiece{
	
	public WhitePiece() {
	}
	@Override
	public Boolean ValidatePieceSelection(position selectPosition){
		try {
			if(selectPosition.isOnBoard())
			{
				position tempPos = new position((selectPosition.x+1), (selectPosition.y-1));
				position tempPos2 = new position((selectPosition.x-1), (selectPosition.y-1));
				if(Board.outBoard(2*(selectPosition.x)+3, 2*(selectPosition.y)+4) == '2' && Board.outBoard(2*(selectPosition.x+1)+3, 2*(selectPosition.y-1)+4) == ' ' && tempPos.isOnBoard())
				{
					return true;
				}
				else if (Board.outBoard(2*(selectPosition.x)+3, 2*(selectPosition.y)+4) == '2' && Board.outBoard(2*(selectPosition.x-1)+3, 2*(selectPosition.y-1)+4) == ' ' && tempPos2.isOnBoard())
				{
					return true;
				}
				else
				{
					throw new MyException("Invalid piece selection");
					
				
				}
			}
			else
			{
				throw new MyException("Invalid piece selection");
				
			}
		}
		catch (MyException e) 
		{
			return false;
		}
	
	}

	
	@Override
	public Boolean ValidateMovementSelection(position movePosition, position checkPosition)
	{
		try {
			
		if((movePosition.y ==  checkPosition.y- 1) && ((movePosition.x == checkPosition.x +1) || (movePosition.x == checkPosition.x - 1)) && movePosition.isOnBoard())
		{
			if (Board.outBoard(2*movePosition.x+3, 2*movePosition.y+4) == ' ')
			{
				return true;
			}
			else
			{
				throw new MyException("Invalid selection");
			}
		}

		else
		{
			throw new MyException("Invalid selection");
		}
		
		}
		catch (MyException e) {
			System.out.println("Invalid entry");
			return false;
		}
	
	}
}

public class newChess {
	
	public static void main(String[] args) {
		
		Board myBoard = new Board();
		Player player1 = new Player(true);
		Player player2 = new Player(false);
		myBoard.setup();
		System.out.println("Welcome to virtual checkers!");
		myBoard.printboard();//Print out the board
		
		Scanner s = new Scanner(System.in);
		int GamePlay = 1;
		Player playerhold;
		playerhold = player1;
		//AbstractPiece piecehold;
		int placeholder = 0;
		
		while(GamePlay == 1)
		{
			int inputx = 0;
			int inputy = 0;
			
			
			Boolean proceed = false;
			position checkPosition = new position(0,0); //declare out here for later use
			while(proceed == false)
			{
			
			System.out.println("Please enter x coordinate of piece you want to move: ");
			inputx = s.nextInt();
			System.out.println("Please enter y coordinate of piece you want to move: ");
			inputy = s.nextInt();
			position tempPosition = new position (inputx, inputy);
			checkPosition = tempPosition;
			
			
			for(int i = 0; i < 12; i++)
			{
				
				if(playerhold.PieceArray[i].ValidatePieceSelection(checkPosition))
				{
					
					placeholder = i;
					proceed = true;
					break;
				}
			}
			if(proceed == true)
			{
			break;	
			}
			}
			
			proceed = false;
			position newPosition = new position(0,0);
			
			
			while(proceed == false)
			{
				
				System.out.println("Please enter x coordinate of where you want to move piece to: ");
				int movex = s.nextInt();
				System.out.println("Please enter y coordinate of where you want to move piece to: ");
				int movey = s.nextInt();
				position tempPosition = new position (movex, movey);
				newPosition = tempPosition;
			
				if(playerhold.PieceArray[placeholder].ValidateMovementSelection(newPosition, checkPosition))
				{
					proceed = true;
				}
				
			}
			
			
			playerhold.PieceArray[placeholder].move(checkPosition, newPosition, playerhold);
			
			if(playerhold == player1)
			{
				playerhold = player2;
			}
			
			else if (playerhold == player2)
			{
				playerhold = player1;
			}
			
			proceed = false; //reset
			myBoard.printboard();//Print out the board
			
			
			}
		
	}	

}




