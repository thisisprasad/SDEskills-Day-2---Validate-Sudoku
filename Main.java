import com.sdeskills.sudoku.SudokuBoard;

import java.util.Scanner;
import java.io.FileNotFoundException;

class Main {
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    startGame();
  }

  private static void startGame() {
    SudokuBoard gameBoard = new SudokuBoard();
    loadBoardData(gameBoard);
    String result = gameBoard.validate().toString();
    System.out.println("Result: " + result);
  }

  private static void loadBoardData(SudokuBoard gameBoard) {
    System.out.println("1. Enter data from console for every cell of the board.");
    System.out.println("2. Load data from a file");
    int choice = sc.nextInt();
    switch (choice) {
    case 1:
      enterBoardFromConsole(gameBoard);
      break;
    case 2:
      loadBoardDataFromFile(gameBoard);
    }
  }

  private static void enterBoardFromConsole(SudokuBoard gameBoard) {
    int x = 0;
    int y = 0;
    int value = 0;
    while(x!=-1 && y!=-1 && value!=-1) {
      System.out.print("\tEnter cell(x, y) and value to insert in cell(-1 -1 -1 to exit): ");
      x = sc.nextInt();
      y = sc.nextInt();
      value = sc.nextInt();
      if(x == -1 && y == -1 && value == -1) {
        break;
      }
      gameBoard.setCell(x, y, value);
    }
  }

  private static void loadBoardDataFromFile(SudokuBoard gameBoard) {
    System.out.print("Enter file name: ");
    String filename = sc.next();
    try{
      gameBoard.loadBoardFromFile(filename);
    } catch (FileNotFoundException fnfe) {
      fnfe.printStackTrace();
    }
  }
}