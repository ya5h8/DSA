class Solution { 
    public int numIslands(char[][] grid) { 
        if (grid == null || grid.length == 0) return 0;
        
        int row = grid.length; 
        int col = grid[0].length; 
        int count = 0; 
        boolean visited[][] = new boolean[row][col]; 
        
        for(int i = 0; i < row; i++){ 
            for(int j = 0; j < col; j++){ 
                if(grid[i][j] == '1' && !visited[i][j]){ 
                    count++; 
                    dfs(grid, i, j, visited); 
                } 
            } 
        } 
        return count; 
    } 
    
    static void dfs(char[][] grid, int i, int j, boolean visited[][]){ 
        int rows = grid.length; 
        int cols = grid[0].length; 
        
        // Base case
        if(i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0' || visited[i][j]) 
            return; 
            
        visited[i][j] = true; 
        
        dfs(grid, i - 1, j, visited); // up 
        dfs(grid, i + 1, j, visited); // down 
        dfs(grid, i, j - 1, visited); // left 
        dfs(grid, i, j + 1, visited); // right 
    } 
}
