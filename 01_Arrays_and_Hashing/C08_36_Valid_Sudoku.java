// Check if board is a valid sudoku:

// 5 3 . . 7 . . . .
// 6 . . 1 9 5 . . .
// . 9 8 . . . . 6 .
// 8 . . . 6 . . . 3
// 4 . . 8 . 3 . . 1
// 7 . . . 2 . . . 6
// . 6 . . . . 2 8 .
// . . . 4 1 9 . . 5
// . . . . 8 . . 7 9


// 8 3 . . 7 . . . .
// 6 . . 1 9 5 . . .
// . 9 8 . . . . 6 .
// 8 . . . 6 . . . 3
// 4 . . 8 . 3 . . 1
// 7 . . . 2 . . . 6
// . 6 . . . . 2 8 .
// . . . 4 1 9 . . 5
// . . . . 8 . . 7 9

import java.util.*;

public class C08_36_Valid_Sudoku {
    public static void main(String[] args) {
        // -----------Driver Code----------------
        Scanner sc = new Scanner(System.in);
        int size = 9;
        char[][] mat = new char[size][size];
        for (int i = 0; i < size; i++) {
            // Input each line as a string
            // convert it into char array &
            // then store each row into the matrix.
            String str = sc.nextLine();
            String[] parts = str.trim().split(" ");
            char[] row = new char[parts.length];
            for (int j = 0; j < parts.length; j++) {
                row[j] = parts[j].charAt(0);
            }
            mat[i] = row;
        }

        System.out.println(isValidSudoku(mat));

        sc.close();
        // -----------Driver Code----------------
    }

    public static boolean isValidSudoku(char[][] board) {
        int size = 9;
        Set<Character>[] rowSets = new HashSet[size];
        Set<Character>[] colSets = new HashSet[size];
        Set<Character>[] boxSets = new HashSet[size];

        for (int i = 0; i < size; i++) {
            rowSets[i] = new HashSet<>();
            colSets[i] = new HashSet<>();
            boxSets[i] = new HashSet<>();
        }

        // Traverse all elements one-by-one
        // and check in respective sets
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                char val = board[i][j];

                if (val == '.') {
                    continue;
                }

                // Check the row
                if (rowSets[i].contains(val)) {
                    return false;
                }
                rowSets[i].add(val);

                // Check the column
                if (colSets[j].contains(val)) {
                    return false;
                }
                colSets[j].add(val);

                // Check the Box
                int boxIndex = (i / 3) * 3 + (j / 3);
                if (boxSets[boxIndex].contains(val)) {
                    return false;
                }
                boxSets[boxIndex].add(val);
            }
        }

        return true;
    }
}