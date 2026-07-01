class Solution {
    public int f(int i , int j , int dp[][] , int grid[][]){
        if(i==0 && j==0){
            return grid[0][0];
        }
        if(i<0 || j<0){
            return (int)1e9;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int down =  grid[i][j] + f(i-1,j,dp,grid);
        int right = grid[i][j] + f(i,j-1,dp,grid);
        dp[i][j] = Math.min(down,right);
        return dp[i][j];
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int i = 0; i<m ; i++){
            for(int j = 0 ; j<n ;j++){
                dp[i][j] = -1;
            }
        }
        return f(m-1,n-1,dp,grid);
    }
}