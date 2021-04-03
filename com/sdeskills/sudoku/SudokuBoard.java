package com.sdeskills.sudoku;

import java.io.FileInputStream;
import java.util.*;
import java.io.FileNotFoundException;

import com.sdeskills.sudoku.SudokuConstants;
import com.sdeskills.sudoku.SudokuBoardState;

public class SudokuBoard {
  private int board[][];

  public SudokuBoard() {
    board = new int[SudokuConstants.BOARD_ROW_SIZE][SudokuConstants.BOARD_COL_SIZE];
    fillBoardWithValues(SudokuConstants.INVALID_VALUE);
  }

  /**
   * Fills the board with @param -value
   */
  private void fillBoardWithValues(int value) {
    for (int i = 0; i < this.board.length; i++) {
      for (int j = 0; j < this.board[0].length; j++) {
        this.board[i][j] = value;
      }
    }
  }

  /**
    validates the current state of sudoku board.
  */
  public SudokuBoardState validate() {
    SudokuBoardState boardState = SudokuBoardState.SOLVED;
    int filledCells = 0;
    int row = 0;
    int col = 0;
    for(row = 0; row < this.board.length; row += 3) {
      col = 0;
      Set<Integer> seen = new TreeSet<Integer>();
      for(int i = row; i < row+3; i++) {
        for(int j = col; j < col+3; j++) {
          if(this.board[i][j] == SudokuConstants.INVALID_VALUE) {
            continue;
          } else if(seen.contains(this.board[i][j])) {
            return SudokuBoardState.INVALID;
          } else {
            seen.add(this.board[i][j]);
            filledCells++;
          }
        }
      }
      col += 3;
      seen = new TreeSet<Integer>();
      for(int i = row; i < row+3; i++) {
        for(int j = col; j < col+3; j++) {
          if(this.board[i][j] == SudokuConstants.INVALID_VALUE) {
            continue;
          } else if(seen.contains(this.board[i][j])) {
            return SudokuBoardState.INVALID;
          } else {
            seen.add(this.board[i][j]);
            filledCells++;
          }
        }
      }
      col += 3;
      seen = new TreeSet<Integer>();
      for(int i = row; i < row+3; i++) {
        for(int j = col; j < col+3; j++) {
          if(this.board[i][j] == SudokuConstants.INVALID_VALUE) {
            continue;
          } else if(seen.contains(this.board[i][j])) {
            return SudokuBoardState.INVALID;
          } else {
            seen.add(this.board[i][j]);
            filledCells++;
          }
        }
      }
    }
    if(filledCells == this.board.length * this.board[0].length) {
      return SudokuBoardState.SOLVED;
    }
    if (filledCells > 0 && filledCells < this.board.length * this.board[0].length) {
      return SudokuBoardState.VALID;
    }
    if(filledCells == 0) {
      return SudokuBoardState.EMPTY;
    }

    return boardState;
  }

  public void loadBoardFromFile(String filename) throws FileNotFoundException {
    FileInputStream fis = new FileInputStream(filename);
    Scanner fileScanner = new Scanner(fis);
    while(fileScanner.hasNextLine()) {
      String []val = fileScanner.nextLine().split(" ");
      int x = Integer.parseInt(val[0]);
      int y = Integer.parseInt(val[1]);
      int cellValue = Integer.parseInt(val[2]);
      x--; y--;
      this.board[x][y] = cellValue;
    }
  }
}