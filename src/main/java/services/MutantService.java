package services;

import org.springframework.stereotype.Service;

@Service
public class MutantService {

    private static final int SEQUENCE_LENGTH = 4;

    public boolean isMutant(String[] dna) {
        char[][] matrix = convertToMatrix(dna);
        int sequenceCount = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (hasHorizontalSequence(matrix, row, col) ||
                        hasVerticalSequence(matrix, row, col) ||
                        hasDiagonalRightSequence(matrix, row, col) ||
                        hasDiagonalLeftSequence(matrix, row, col)) {

                    sequenceCount++;
                    if (sequenceCount > 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private char[][] convertToMatrix(String[] dna) {
        int size = dna.length;
        char[][] matrix = new char[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i] = dna[i].toCharArray();
        }

        return matrix;
    }

    private boolean hasHorizontalSequence(char[][] matrix, int row, int col) {
        if (col + SEQUENCE_LENGTH > matrix.length) {
            return false;
        }
        for (int i = 1; i < SEQUENCE_LENGTH; i++) {
            if (matrix[row][col] != matrix[row][col + i]) {
                return false;
            }
        }
        return true;
    }

    private boolean hasVerticalSequence(char[][] matrix, int row, int col) {
        if (row + SEQUENCE_LENGTH > matrix.length) {
            return false;
        }
        for (int i = 1; i < SEQUENCE_LENGTH; i++) {
            if (matrix[row][col] != matrix[row + i][col]) {
                return false;
            }
        }
        return true;
    }

    private boolean hasDiagonalRightSequence(char[][] matrix, int row, int col) {
        if (row + SEQUENCE_LENGTH > matrix.length || col + SEQUENCE_LENGTH > matrix.length) {
            return false;
        }
        for (int i = 1; i < SEQUENCE_LENGTH; i++) {
            if (matrix[row][col] != matrix[row + i][col + i]) {
                return false;
            }
        }
        return true;
    }

    private boolean hasDiagonalLeftSequence(char[][] matrix, int row, int col) {
        if (row + SEQUENCE_LENGTH > matrix.length || col - SEQUENCE_LENGTH + 1 < 0) {
            return false;
        }
        for (int i = 1; i < SEQUENCE_LENGTH; i++) {
            if (matrix[row][col] != matrix[row + i][col - i]) {
                return false;
            }
        }
        return true;
    }
}
