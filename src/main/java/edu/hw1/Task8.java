package edu.hw1;

public final class Task8 {

    private Task8() {
    }

    public static boolean knightBoardCapture(int[][] chessBoard) {
        final int BOARD_SIZE = 8;

        if (chessBoard.length != BOARD_SIZE || chessBoard[0].length != BOARD_SIZE) {
            return false;
        }

        for (var line : chessBoard) {
            for (int cell : line) {
                if (cell != 0 && cell != 1) {
                    return false;
                }
            }
        }

        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (chessBoard[row][col] == 0) {
                    continue;
                }

                int[][] neighbours = {
                    {row + 2, col + 1},
                    {row + 2, col - 1},
                    {row - 2, col + 1},
                    {row - 2, col - 1},
                    {row + 1, col - 2},
                    {row + 1, col + 2},
                    {row - 1, col + 2},
                    {row - 1, col - 2}
                };

                for (var cell : neighbours) {
                    var rowNeighbour = cell[0];
                    var colNeighbour = cell[1];

                    if (rowNeighbour >= 0 && rowNeighbour < BOARD_SIZE && colNeighbour >= 0 && colNeighbour < BOARD_SIZE
                        && chessBoard[rowNeighbour][colNeighbour] == 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
