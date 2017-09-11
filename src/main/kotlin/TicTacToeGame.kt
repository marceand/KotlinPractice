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
        setPlayerOnBoard(x, y, player)
        if(isWinner()){
            return player + " is the winner"
        }else if(draw()){
            return "The result is draw"
        }
        return "No winner"
    }

    private fun draw(): Boolean {

        for(row in 0..2){
            for(column in 0..2){
                if(board[row][column]=='\u0000'){
                    return false
                }
            }
        }

        return true
    }

    private fun setPlayerOnBoard(x: Int, y: Int, player: Char) {
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

        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true
        }else if(board[2][0] == player && board[1][1] == player && board[0][2] == player){
            return true
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
