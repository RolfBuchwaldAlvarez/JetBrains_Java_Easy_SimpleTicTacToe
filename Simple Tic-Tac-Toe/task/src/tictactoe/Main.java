package tictactoe;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        char[][] playGrid = new char[3][3];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < playGrid.length; i++) {
            for (int j = 0; j < playGrid[0].length; j++) {
                playGrid[i][j] = '_';
            }
        }

        String numberOne = "";
        String numberTwo = "";
        boolean entryError = true;
        boolean gameNotYetFinished = true;
        int playGridFillCount = 1;

        while (gameNotYetFinished) {
            printPlayGrid(playGrid);
            numberOne = sc.next();
            numberTwo = sc.next();
            while (entryError) {
                boolean entryErrorExists = entryErrorExists(playGrid, numberOne, numberTwo);
                if (entryErrorExists) {
                    numberOne = sc.next();
                    numberTwo = sc.next();
                } else {
                    if (playGridFillCount % 2 == 0) {
                        playGrid[Integer.parseInt(numberOne) - 1][Integer.parseInt(numberTwo) - 1] = 'O';
                    } else {
                        playGrid[Integer.parseInt(numberOne) - 1][Integer.parseInt(numberTwo) - 1] = 'X';
                    }
                    entryError = false;
                }
            }

            String result = result(playGrid, playGridFillCount);
            if (result.equals("X wins") || result.equals("O wins") || result.equals("Draw"))  {
                gameNotYetFinished = false;
                printPlayGrid(playGrid);
                System.out.println(result);
            }
            playGridFillCount++;
            entryError = true;
        }
    }

    private static boolean entryErrorExists(char[][] playGrid, String numberOne, String numberTwo) {
        if (entryIsNotANumber(numberOne, numberTwo)) {
            System.out.println("You should enter numbers!");
            System.out.println("Enter the coordinates: ");
            return true;
        } else if (entryIsOutOfRange(numberOne, numberTwo)) {
            System.out.println("Coordinates should be from 1 to 3!");
            System.out.println("Enter the coordinates: ");
            return true;
        } else if (cellIsAlreadyOccupied(playGrid, numberOne, numberTwo)) {
            System.out.println("This cell is occupied! Choose another one!");
            System.out.println("Enter the coordinates: ");
            return true;
        } else {
            return false;
        }
    }

    private static boolean cellIsAlreadyOccupied(char[][] playGrid, String numberOne, String numberTwo) {
        return playGrid[Integer.parseInt(numberOne) - 1][Integer.parseInt(numberTwo) - 1] != '_';
    }

    private static boolean entryIsNotANumber(String numberOne, String numberTwo) {
        return numberOne.isEmpty() || numberTwo.isEmpty() || (!numberOne.matches(".*\\d.*") && numberOne.length() > 1) || (!numberTwo.matches(".*\\d.*") && numberTwo.length() > 1);
    }

    private static boolean entryIsOutOfRange(String numberOne, String numberTwo) {
        return Integer.parseInt(numberOne) > 3 || Integer.parseInt(numberOne) <= 0 || Integer.parseInt(numberTwo) > 3 || Integer.parseInt(numberTwo) <= 0;
    }

    private static void printPlayGrid(char[][] playGrid) {
        System.out.println("---------");
        System.out.printf("| %c %c %c |%n", playGrid[0][0], playGrid[0][1], playGrid[0][2]);
        System.out.printf("| %c %c %c |%n", playGrid[1][0], playGrid[1][1], playGrid[1][2]);
        System.out.printf("| %c %c %c |%n", playGrid[2][0], playGrid[2][1], playGrid[2][2]);
        System.out.println("---------");
        System.out.println("Enter the coordinates: ");
    }

    private static String result(char[][] playGrid, int playGridFillCount) {
        int fieldCounter = 0;
        if (isImpossible(playGrid)) {
            return "Impossible";
        }
        if (winnerExists(playGrid)) {
            return playGridFillCount % 2 != 0 ? "X wins" : "O wins";
        }
        for (char[] symbols : playGrid) {
            for (char symbol : symbols) {
                if (symbol != '_')
                fieldCounter++;
            }
        }
        if (fieldCounter == 9 && !winnerExists(playGrid)) {
            return "Draw";
        }
        return "";
    }

    private static boolean isImpossible(char[][] playGrid) {
        int xCount = 0;
        int oCount = 0;
        for (char[] chars : playGrid) {
            for (int j = 0; j < playGrid[0].length; j++) {
                if (chars[j] == 'X') {
                    xCount++;
                }
                if (chars[j] == 'O') {
                    oCount++;
                }
            }
        }
        return Math.abs(xCount - oCount) >= 2;
    }

    private static boolean winnerExists(char[][] playGrid) {
        return (((playGrid[0][0] == playGrid[0][1] && playGrid[0][1] == playGrid[0][2])
            || (playGrid[0][0] == playGrid[1][0] && playGrid[1][0] == playGrid[2][0])) && playGrid[0][0] != '_')
            || (((playGrid[0][2] == playGrid[1][2] && playGrid[1][2] == playGrid[2][2])
            || (playGrid[2][0] == playGrid[2][1] && playGrid[2][1] == playGrid[2][2])) && playGrid[2][2] != '_')
            || (((playGrid[0][2] == playGrid[1][1] && playGrid[1][1] == playGrid[2][0])
            || (playGrid[0][1] == playGrid[1][1] && playGrid[1][1] == playGrid[2][1])
            || (playGrid[1][0] == playGrid[1][1] && playGrid[1][1] == playGrid[1][2])
            || (playGrid[0][0] == playGrid[1][1] && playGrid[1][1] == playGrid[2][2])) && playGrid[1][1] != '_');
    }
}
