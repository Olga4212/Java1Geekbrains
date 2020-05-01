package lesson3;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static char[][] field;

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    private static final char HUMAN_DOT = 'X';
    private static final char AI_DOT = 'O';
    private static final char EMPTY_DOT = '.';

    private static final int FIELD_SIZE_X = 5;
    private static final int FIELD_SIZE_Y = 6;
    private static final int WIN_LINE_LENGTH = 3;

    // init field
    private static void initMap() {
        field = new char[FIELD_SIZE_Y][FIELD_SIZE_X];
        for (int y = 0; y < FIELD_SIZE_Y; y++) {
            for (int x = 0; x < FIELD_SIZE_X; x++) {
                field[y][x] = EMPTY_DOT;
            }
        }
    }

    // print field
    private static void printMap() {
        System.out.println("-------");
        for (int y = 0; y < FIELD_SIZE_Y; y++) {
            System.out.print("|");
            for (int x = 0; x < FIELD_SIZE_X; x++) {
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
            System.out.printf("Введите координаты хода X (от 1 до %d) и Y (от 1 до %d) через пробел: ", FIELD_SIZE_X, FIELD_SIZE_Y);
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
        return x >= 0 && x < FIELD_SIZE_X && y >= 0 && y < FIELD_SIZE_Y;
    }

    // ai turn
    private static void aiTurn() {
        int x;
        int y;
        do {
            x = RANDOM.nextInt(FIELD_SIZE_X);
            y = RANDOM.nextInt(FIELD_SIZE_Y);
        } while (!isEmptyCell(y, x));
        field[y][x] = AI_DOT;
    }

    // check win
    private static boolean checkWin(char testedSymbol) {
        int maxFieldSize = Math.max(FIELD_SIZE_X, FIELD_SIZE_Y);

        // check rows and cols
        for (int a = 0; a < maxFieldSize; a++) {
            int rowSum = 0;
            int columnSum = 0;
            for (int b = 0; b < maxFieldSize; b++) {

                if (a < FIELD_SIZE_Y && b < FIELD_SIZE_X) {
                    if (field[a][b] == testedSymbol) {
                        rowSum++;
                        if (rowSum >= WIN_LINE_LENGTH) {
                            return true;
                        }
                    } else {
                        rowSum = 0;
                    }
                }

                if (a < FIELD_SIZE_X && b < FIELD_SIZE_Y) {
                    if (field[b][a] == testedSymbol) {
                        columnSum++;
                        if (columnSum >= WIN_LINE_LENGTH) {
                            return true;
                        }
                    } else {
                        columnSum = 0;
                    }
                }
            }
        }

        // check diagonals 1
        for (int x = 0; x < maxFieldSize; x++) {
            int diagonal1Sum = 0;
            int diagonal2Sum = 0;
            for (int y = 0; y < maxFieldSize; y++) {
                if (y < FIELD_SIZE_Y && y + x < FIELD_SIZE_X) {
                    if (field[y][y + x] == testedSymbol) {
                        diagonal1Sum++;
                        if (diagonal1Sum >= WIN_LINE_LENGTH) {
                            return true;
                        }
                    } else {
                        diagonal1Sum = 0;
                    }
                }

                if (y < FIELD_SIZE_Y && y - x >= 0 && y - x < FIELD_SIZE_X) {
                    if (field[y][y - x] == testedSymbol) {
                        diagonal2Sum++;
                        if (diagonal2Sum >= WIN_LINE_LENGTH) {
                            return true;
                        }
                    } else {
                        diagonal2Sum = 0;
                    }
                }
            }
        }

        // check diagonals 2
        for (int x = 0; x < maxFieldSize; x++) {
            int diagonal1Sum = 0;
            int diagonal2Sum = 0;
            for (int y = 0; y < maxFieldSize; y++) {
                if (y + x < FIELD_SIZE_Y && FIELD_SIZE_X - y - 1 >= 0) {
                    if (field[y + x][FIELD_SIZE_X - y - 1] == testedSymbol) {
                        diagonal1Sum++;
                        if (diagonal1Sum >= WIN_LINE_LENGTH) {
                            return true;
                        }
                    } else {
                        diagonal1Sum = 0;
                    }
                }

                if (y - x >= 0 && y - x < FIELD_SIZE_X && FIELD_SIZE_X - y - 1 >= 0) {
                    if (field[y - x][FIELD_SIZE_X - y - 1] == testedSymbol) {
                        diagonal2Sum++;
                        if (diagonal2Sum >= WIN_LINE_LENGTH) {
                            return true;
                        }
                    } else {
                        diagonal2Sum = 0;
                    }
                }
            }
        }

        return false;
    }

    // check draw
    private static boolean isMapFull() {
        for (int y = 0; y < FIELD_SIZE_Y; y++) {
            for (int x = 0; x < FIELD_SIZE_X; x++) {
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

    private static boolean isGameFinished(char checkIsWinner, String s) {
        if (checkWin(checkIsWinner)) {
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