package com.zhenglinj.java.samples.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * the single-thread and multi-thread version solutions for N Queens problem
 *
 * output:
 *
 * Single-thread solution total used time(ms): 13198
 * Multi-thread solution total used time(ms): 6971
 */
public class NQueensMultithreadedSolution {
    private static ExecutorService pool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {
        NQueensMultithreadedSolution solution = new NQueensMultithreadedSolution();
        solution.solve();
    }

    private void solve() {
        int gridSize = 14;
        List<String> result = new ArrayList<String>();

        try {
            NQueensSolver solver = new NQueensSolver(gridSize);

            long start = System.currentTimeMillis();

            solver.solve0();

            long end = System.currentTimeMillis();
            result.add("Single-thread solution total used time(ms): " + (end - start));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            NQueensSolver[] jobs = new NQueensSolver[gridSize];
            for (int i = 0; i < gridSize; i++) {
                jobs[i] = new NQueensSolver(gridSize, i);
            }
            long start = System.currentTimeMillis();

            for (int i = 0; i < gridSize; i++) {
                pool.execute(jobs[i]);
            }

            pool.shutdown();

            while (!pool.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Thread pool is running...");
            }

            long end = System.currentTimeMillis();
            result.add("Multi-thread solution total used time(ms): " + (end - start));
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println(String.join("\n", result));
    }

    /**
     * the N Queens solver to calculate result
     */
    private static class NQueensSolver implements Runnable {
        private int gridSize;
        private int firstRowQueenIdx; // used for multi-thread solution

        public NQueensSolver(int gridSize, int firstRowQueenIdx) {
            //If Grid is 1*1 or 2*2 or 3*3 then solution is not possible as,
            //In 1*1 or 2*2 grid, Queen placed in 1st row at any position will attack queen placed at all the positions in row 2.
            //In 3*3 grid, Queen placed in 1st row and 2nd row for all combinations position will attack queen placed at all the positions in row 3.
            if (gridSize < 4) {
                throw new IllegalArgumentException("gridSize should >= 4");
            }
            if (gridSize < firstRowQueenIdx) {
                throw new IllegalArgumentException("gridSize should >= firstRowQueenIdx");
            }
            this.gridSize = gridSize;
            this.firstRowQueenIdx = firstRowQueenIdx;
        }

        public NQueensSolver(int gridSize) {
            //If Grid is 1*1 or 2*2 or 3*3 then solution is not possible as,
            //In 1*1 or 2*2 grid, Queen placed in 1st row at any position will attack queen placed at all the positions in row 2.
            //In 3*3 grid, Queen placed in 1st row and 2nd row for all combinations position will attack queen placed at all the positions in row 3.
            if (gridSize < 4) {
                throw new IllegalArgumentException("gridSize should >= 4");
            }
            this.gridSize = gridSize;
        }

        /**
         * for multi-thread version
         */
        @Override
        public void run() {
            // use for multi-thread version
            int[][] board = new int[gridSize][gridSize];
            board[0][firstRowQueenIdx] = 1;
            placeAllQueens(board, 1);
        }

        /**
         * for single-thread version
         */
        public void solve0() {
            int[][] board = new int[gridSize][gridSize];
            placeAllQueens(board, 0);
        }

        /**
         * place all the queens starting from row
         * @param board
         * @param row
         * @return
         */
        private static boolean placeAllQueens(int board[][], int row) {
            if (row >= board.length) {
                return true;
            }

            boolean isAllQueensPlaced = false;
            for (int j = 0; j < board.length; j++) {
                isAllQueensPlaced = false;
                if (isSafe(board, row, j)) {
                    board[row][j] = 1;
                    isAllQueensPlaced = placeAllQueens(board, row + 1);
                }
                if (isAllQueensPlaced) {
                    if (row == board.length - 1) {
                        //printBoard(board);
                        board[row][j] = 0;
                        break;
                    } else {
                        board[row][j] = 0;
                        continue;
                    }
                } else {
                    board[row][j] = 0;
                }
            }

            return isAllQueensPlaced;
        }

        /**
         * check if the new queen in row/col of board safe or not
         * @param board
         * @param row
         * @param col
         * @return true for safe
         */
        private static boolean isSafe(int board[][], int row, int col) {
            //Check Left Upper Diagonal
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 1) {
                    return false;
                }
            }

            //Check Right Upper Diagonal
            for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
                if (board[i][j] == 1) {
                    return false;
                }
            }

            //Check in same Column
            for (int i = row - 1; i >= 0; i--) {
                if (board[i][col] == 1) {
                    return false;
                }
            }

            return true;
        }

        private static void printBoard(int[][] board) {
            StringBuilder sb = new StringBuilder();
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board.length; col++) {
                    if (board[row][col] == 1) {
                        sb.append("Q ");
                    } else {
                        sb.append("_ ");
                    }
                }
                sb.append("\n");
            }
            sb.append("\n");
            System.out.println(sb.toString());
        }
    }
}
