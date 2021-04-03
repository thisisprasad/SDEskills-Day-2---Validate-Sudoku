package com.sdeskills.sudoku;

import com.sdeskills.sudoku.SudokuConstants;

public class SudokuBoard {
  private int board[][];

  public SudokuBoard() {
    board = new int[SudokuConstants.BOARD_ROW_SIZE][SudokuConstants.BOARD_COL_SIZE];
    fillBoardWithValues(SudokuConstants.INVALID_VALUE);
  }

  /**
    Fills the board with @param -value
  */
  private void fillBoardWithValues(int value) {
    for(int i = 0; i < this.board.length; i++) {
      for(int j = 0; j < this.board[0].length; j++) {
        this.board[i][j] = value;
      }
    }
  }
}