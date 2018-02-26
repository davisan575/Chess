package Work;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class newChessTest {

	Board someBoard;
	Player player1;
	Player player2;
	
	@Before
	public void mysetUp() {
		someBoard = new Board();
		player1 = new Player(true);
		player2 = new Player(false);
		
	}

	@Test
	public void testsetup() {
		someBoard.setup();
		assertEquals(someBoard.outBoard(3,6), '1');
	}

	@Test
	public void testCheckSelection() {
		someBoard.setup();
		position newPosition = new position(1,0);
		
		//should not work, no where for this piece to move to
			assertEquals(false,player1.PieceArray[0].ValidatePieceSelection(newPosition));
	
	}
	
	@Test
	public void testCheckMovement2() {
		someBoard.setup();
		position newPosition = new position(1,2);
		position movePosition = new position(2,3);
				
			assertEquals(true,player1.PieceArray[8].ValidatePieceSelection(newPosition));
	
			assertEquals(true,player1.PieceArray[8].ValidateMovementSelection(movePosition, newPosition)); 
	}
	
	@Test
	public void testMove() {
		position newPosition = new position(1,2);
		position movePosition = new position(2,3);
		player1.PieceArray[8].move(newPosition, movePosition, player1);
		assertEquals(someBoard.outBoard(movePosition.xConverted,movePosition.yConverted), '1');
	}
}
