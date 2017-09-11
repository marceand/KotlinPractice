import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Created by Marcel on 9/3/2017.
 */
class TicTacToeTest {

    private lateinit var ticTacToe: TicTacToeGame

    @Before
    fun setUp() {
        ticTacToe = TicTacToeGame()
    }

    @Test(expected = RuntimeException::class)
    fun `when X outside board then runtime exception`() {
        ticTacToe.play(5,2)
    }

    @Test(expected = RuntimeException::class)
    fun `when Y outside board then runtime exception`() {
        ticTacToe.play(2,5)
    }

    @Test(expected = RuntimeException::class)
    fun `when occupied then tuntime exception`() {
        ticTacToe.play(2,1)
        ticTacToe.play(2,1)
    }

    @Test
    fun `given first turn when next player then X`() {
        assertEquals('X', ticTacToe.nextPlayer())
    }

    @Test
    fun `given last turn was was X when next player then O`() {
        ticTacToe.play(1,1)
        assertEquals('O', ticTacToe.nextPlayer())
    }

    @Test
    fun `when play then no winner`() {
        assertEquals("No winner", ticTacToe.play(1,1))
    }

    @Test
    fun `when play and whole horizontal line then winner`() {
        ticTacToe.play(1,1)  // X
        ticTacToe.play(2,1)  // O
        ticTacToe.play(1,2)  // X
        ticTacToe.play(2,2)  // O
        assertEquals("X is the winner", ticTacToe.play(1,3))
    }

    @Test
    fun `when play and whole vertical line then winner`() {
        ticTacToe.play(2,1) // X
        ticTacToe.play(1,3)  // O
        ticTacToe.play(3,1)  // X
        ticTacToe.play(2,3)  // O
        ticTacToe.play(2,2)  // X
        assertEquals("O is the winner", ticTacToe.play(3,3))
    }

    @Test
    fun `when play and top bottom diagonal line then winner`() {
        ticTacToe.play(1,1) // X
        ticTacToe.play(1,2) // O
        ticTacToe.play(2,2) // X
        ticTacToe.play(1,3) // O
        assertEquals("X is the winner", ticTacToe.play(3,3))
    }

    @Test
    fun `when play and bottom top diagonal liiine then winner`() {
        ticTacToe.play(1,3)  // X
        ticTacToe.play(1,1)  // O
        ticTacToe.play(2,2)  // X
        ticTacToe.play(1,2)  // O
        assertEquals("X is the winner", ticTacToe.play(3,1))
    }

    @Test
    fun `when all boxes are filled then draw`() {
        ticTacToe.play(1,1)
        ticTacToe.play(1,2)
        ticTacToe.play(1,3)
        ticTacToe.play(2,1)
        ticTacToe.play(2,3)
        ticTacToe.play(2,2)
        ticTacToe.play(3,1)
        ticTacToe.play(3,3)
        assertEquals("The result is draw", ticTacToe.play(3,2))
    }
}



