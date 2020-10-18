package lc36;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] loop = {0, 3, 6, 9};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Set<Character> dupCheck = new HashSet<>();
                for (int a = loop[i]; a < loop[i + 1]; a++) {
                    for (int b = loop[j]; b < loop[j + 1]; b++) {
                        if (board[a][b] != '.') {
                            if (!dupCheck.contains(board[a][b])) {
                                dupCheck.add(board[a][b]);
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            Set<Character> dupCheck1 = new HashSet<>();
            Set<Character> dupCheck2 = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!dupCheck1.contains(board[i][j])) {
                        dupCheck1.add(board[i][j]);
                    } else {
                        return false;
                    }
                }
                if (board[j][i] != '.') {
                    if (board[j][i] != '.' && !dupCheck2.contains(board[j][i])) {
                        dupCheck2.add(board[j][i]);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}