class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        solve(0, board, ans);
        return ans;
    }

    private void solve(int row, char[][] board, List<List<String>> ans) {
        if (row == board.length) {
            ans.add(construct(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                solve(row + 1, board, ans);
                board[row][col] = '.'; 
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board) {
        int n = board.length;

        // column check
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }
}