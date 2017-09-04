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
    fun `when X Outside Board Then Runtime Exception`() {
        ticTacToe.play(5,2)
    }
}



