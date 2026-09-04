class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(board, word, i, j, 0, m, n)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board, String word, int i, int j, int k, int m, int n) {
        if (k == word.length()){
            return true;
        }
        if (i < 0 || i >= m || j < 0 || j >= n){
            return false;
        }
        if (board[i][j] != word.charAt(k)){
            return false;
        }
        char ch = board[i][j];
        board[i][j] = '*';
        boolean ans = search(board, word, i + 1, j, k + 1, m, n) || search(board, word, i - 1, j, k + 1, m, n)|| search(board, word, i, j + 1, k + 1, m, n)|| search(board, word, i, j - 1, k + 1, m, n);
        board[i][j] = ch;
        return ans;
    }
}