
/**
 * 
 * Question 6
 *
 */
public class Q6 {

    private final int MATRIX_SIZE;
    private int[][] tmp;
    private int[][] visited;
    private int[] xAxis = { 0, 0, -1, 1 };
    private int[] yAxis = { 1, -1, 0, 0 };

    public Q6(int matrixSize) {
        MATRIX_SIZE = matrixSize;
        visited = new int[matrixSize][matrixSize];
        tmp = new int[matrixSize][matrixSize];
        fillMatrix();
    }

    /**
     * Fills the matrix by -1.
     */
    private void fillMatrix() {
        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                visited[i][j] = -1;
                tmp[i][j] = -1;
            }
        }
    }

    /**
     * Wrapper function of recursive fillWithSnake function. Top-left corner is
     * chosen for starting.
     */
    public void solveGame() {
        visited[0][0] = 1; // stars from the top-left corner
        if(!fillWithSnake(1, 1, 0, 0))
            System.out.println("No configuration to fill array!");
    }

    /**
     * 
     * @param snakeID the snake ID holds current snake number to differentiate
     *                snakes (1,2,3,...)
     * @param moveNum the move number is used for counting moves of snakes.
     * @param coorX   the x coordinate of snake - default value is 0
     * @param coorY   the y coordinate of snake - default value is 0
     * @return        true if array is filled by snakes otherwise return false
     */
    public boolean fillWithSnake(int snakeID, int moveNum, int coorX, int coorY) {

        boolean flag = false;

        /* Increment snakeID to differentiate snakes*/
        if (moveNum == MATRIX_SIZE) {
            moveNum = 0;
            snakeID++;
        }

        /* Successfull filling operation.. */
        if (snakeID == MATRIX_SIZE + 1) {
            displayMatrix();
            return true;
        }

        for (int i = 0; i < xAxis.length; ++i) {

            int X = coorX + xAxis[i];
            int Y = coorY + yAxis[i];

            if (moveCheck(X, Y) && visited[X][Y] == -1) {

                visited[X][Y] = snakeID;   
                flag = fillWithSnake(snakeID, moveNum + 1, X, Y);

                // Backtracking part
                visited[X][Y] = -1;
            }
        }
        return flag;
    }

    /**
     * Check validity of next move. Coordinate numbers must not exceed the size of
     * the matrix
     * 
     * @param x the x coordinate of snake
     * @param y the y coordinate of snake
     * @return true if next move is valid.
     */
    public boolean moveCheck(int x, int y) {
        return !(x < 0 || y < 0 || x >= MATRIX_SIZE || y >= MATRIX_SIZE);
    }

    
    /**
     * Displays matrix.
     */
    public void displayMatrix() {

        int count = 0;

        /* Comparing with last result */
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp.length; j++) {
                if (tmp[i][j] == visited[i][j])
                    count++;
            }
        }

        if (count == MATRIX_SIZE * MATRIX_SIZE)
            return;

        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                tmp[i][j] = visited[i][j];
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("********");
    }
}