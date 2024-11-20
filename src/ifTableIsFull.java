public class ifTableIsFull {


    public boolean isTableFull() {
        for (int row = 0; row < 9; row++) {

            if (board[row] == EMPTY) {
                return false;

            }
        }
        return true;
    }
}
