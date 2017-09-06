/**
 * Created by Marcel on 9/3/2017.
 */
class TicTacToeGame {

    private val board = Array(3) { Array(3) { '\u0000' } }
    private var player = '\u0000'

    fun play(x: Int, y: Int): String {
        checkAxis(x)
        checkAxis(y)
        player = nextPlayer()
        setPlayerInBoard(x, y, player)
        if(isWinner()){
            return player + " is the winner"
        }
        return "No winner"
    }

    private fun setPlayerInBoard(x: Int, y: Int, player: Char) {
        if (board[x - 1][y - 1] != '\u0000') {
            throw RuntimeException("Board is occupied.")
        } else {
            board[x - 1][y - 1] = player
        }
    }

    private fun checkAxis(axis: Int) {
        if (axis < 1 || axis > 3) {
            throw RuntimeException("Position is outside board.")
        }
    }

    private fun isWinner(): Boolean {
        for (row in 0..2){
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true
            }else if(board[0][row] == player && board[1][row] == player && board[2][row] == player){
                return true
            }
        }

        return false
    }

    fun nextPlayer(): Char{
        if(player == 'X'){
            return 'O'
        }
        return 'X'
    }
}
