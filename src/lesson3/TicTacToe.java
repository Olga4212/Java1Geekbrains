package lesson3;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static int fieldSizeY;
    private static int fieldSizeX;
    private static char[][] field;

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    private static final char HUMAN_DOT = 'X';
    private static final char AI_DOT = 'O';
    private static final char EMPTY_DOT = '.';

    // init field
    private static void initMap() {
        fieldSizeY = 3;
        fieldSizeX = 3;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = EMPTY_DOT;
            }
        }
    }

    // print field
    private static void printMap() {
        System.out.println("-------");
        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print("|");
            for (int x = 0; x < fieldSizeX; x++) {
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }
    }

    // human turn
    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.printf("Введите координаты хода X и Y (от 1 до %d) через пробел: ", fieldSizeX);
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(y, x) || !isEmptyCell(y, x));
        field[y][x] = HUMAN_DOT;
    }

    // is cell empty
    private static boolean isEmptyCell(int y, int x) {
        return field[y][x] == EMPTY_DOT;
    }

    // is cell valid
    private static boolean isValidCell(int y, int x) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    // ai turn
    private static void aiTurn() {
        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(y, x));
        field[y][x] = AI_DOT;
    }

    // check win
    private static boolean checkWin(char c) {
        for (int y = 0; y < fieldSizeY; y++){
            boolean isRowWin = true;
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] != c ) {
                    isRowWin = false;
                }
            }
            if (isRowWin){
                return true;
            }
        }

        for (int x = 0; x < fieldSizeX; x++){
            boolean isColWin = true;
            for (int y = 0; y < fieldSizeY; y++) {
                if (field[y][x] != c ) {
                    isColWin = false;
                }
            }
            if (isColWin){
                return true;
            }
        }

        boolean isDiagonal1Win = true;
        for (int x = 0; x < fieldSizeX; x++){
            if (field[x][x] != c) {
                isDiagonal1Win = false;
            }
        }
        if (isDiagonal1Win) {
            return true;
        }

        boolean isDiagonal2Win = true;
        for (int x = 0; x < fieldSizeX; x++){
            if (field[x][fieldSizeX-x-1] != c) {
                isDiagonal2Win = false;
            }
        }
        if (isDiagonal2Win) {
            return true;
        }
        return false;
    }

    // check draw
    private static boolean isMapFull() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isEmptyCell(y, x)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        while (true) {
            initMap();
            printMap();
            while (true) {
                humanTurn();
                printMap();
                if (isGameFinished(HUMAN_DOT, "Human win!")) break;
                aiTurn();
                printMap();
                if (isGameFinished(AI_DOT, "AI win!")) break;
            }
            System.out.println("Play again?");
            if (!SCANNER.next().equals("Y"))
                break;
        }
        SCANNER.close();

    }

    private static boolean isGameFinished(char aiDot, String s) {
        if (checkWin(aiDot)) {
            System.out.println(s);
            return true;
        }
        if (isMapFull()) {
            System.out.println("draw!");
            return true;
        }
        return false;
    }
}