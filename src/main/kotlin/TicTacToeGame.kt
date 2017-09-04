/**
 * Created by Marcel on 9/3/2017.
 */
class TicTacToeGame {
    fun play(x: Int, y: Int) {
        if(x < 1 || x > 3){
            throw RuntimeException("X is outside board.")
        }
    }
}