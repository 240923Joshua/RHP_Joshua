import java.util.*;
class longestIncreasingPathMatrix {
    final static int diff[][] = {{0,-1},{0,1},{-1,0},{1,0}};
    public static int dfs(int[][] matrix, int[][] dp, int i, int j, int r,int c){
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        int adjmax = 0;
        for(int k=0;k<4;k++){
            int ar = i + diff[k][0];
            int ac = j + diff[k][1];
            if (ar>=0 && ar< r && ac>=0 && ac < c){
                if (matrix[ar][ac] > matrix[i][j]){
                    
                    adjmax = Math.max(adjmax, dfs(matrix,dp,ar,ac,r,c));
                }
            }
        }
        dp[i][j] = 1 + adjmax;
        return dp[i][j];
    }
    public static int longestIncreasingPath(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] dp = new int[r][c];
        for(int i = 0; i<r; i++){
            for(int j=0; j<c; j++){
                dp[i][j] = 0;
            }
        }
        int maxlen = 1;
        for (int i=0;i<r;i++){
            for (int j=0; j<c; j++){
                if(dp[i][j] == 0){
                    dfs(matrix,dp,i,j,r,c);
                    maxlen = Math.max(maxlen, dp[i][j]);
                }

            }
        }
        return maxlen;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter row and column size:");
        System.out.print("row: ");
        int row = sc.nextInt();
        System.out.println();
        System.out.print("col: ");
        int col = sc.nextInt();
        int matrix[][] = new int[row][col];
        for (int i=0;i<row;i++){
            for (int j = 0; j<col;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("Input matrix:");
        for (int i=0;i<row;i++){
            for (int j = 0; j<col;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        int result = longestIncreasingPath(matrix);
        System.out.println("The longest path length in the given matrix is : "+ result);
        sc.close();
    }
}
