class Solution {
    int rows;
    int columns;
    public void dfs(int row , int col , char grid[][] ,boolean visited[][]){
        if (row < 0 || row >= rows || col < 0 || col >= columns || grid[row][col] == '0' || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        int adjlist[][] = {{row-1,col},{row,col+1},{row+1,col},{row,col-1}};
        for(int neighbour[] : adjlist){
            dfs(neighbour[0],neighbour[1],grid,visited);
        }
    }
    public int numIslands(char[][] grid) {
        rows = grid.length;
        columns = grid[0].length;
        int island = 0;
        boolean visited[][] = new boolean[rows][columns];
        for(int i = 0 ; i<rows ; i++){
            for(int j = 0 ; j<columns ; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(i,j,grid,visited);
                    island++ ;
                }
            }
        }
        return island;
    }
}