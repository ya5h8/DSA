class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        boolean[][][] dp = new boolean[m][n][m + n];

        int startBalance = grid[0][0] == '(' ? 1 : -1;

        if (startBalance < 0) {
            return false;
        }

        dp[0][0][startBalance] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                for (int balance = 0; balance < m + n; balance++) {

                    if (!dp[i][j][balance]) {
                        continue;
                    }

                    if (i + 1 < m) {
                        int newBalance = balance +
                                (grid[i + 1][j] == '(' ? 1 : -1);

                        if (newBalance >= 0) {
                            dp[i + 1][j][newBalance] = true;
                        }
                    }

                    if (j + 1 < n) {
                        int newBalance = balance +
                                (grid[i][j + 1] == '(' ? 1 : -1);

                        if (newBalance >= 0) {
                            dp[i][j + 1][newBalance] = true;
                        }
                    }
                }
            }
        }

        return dp[m - 1][n - 1][0];
    }
}