import java.util.*;
class matrix{
    
    public static void display(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static long[] getFSMAX(long[][] dp, int row, int col){
        long fmax = Math.max(dp[row][0], dp[row][col-1]);
        long smax = Long.min(dp[row][0], dp[row][col-1]);
        for(int i=1; i<col-1; i++){
            if(dp[row][i] > fmax){
                smax = fmax;
                fmax = dp[row][i];
            } else if(dp[row][i] > smax){
                smax = dp[row][i];
            }
        }
        return new long[]{fmax, smax};
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns of the matrix:");
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] matrix = new int[r][c];
        System.out.println("Enter the elements of the matrix:");
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("The matrix is:");
        display(matrix);
        
        long [][] dp = new long[r][c];
        for(int i=0; i<c; i++){
            dp[0][i] = matrix[0][i];
        }
        
        for(int i=1; i<r; i++){
            long fsmax[] = getFSMAX(dp, i-1, c);
            for(int j=0; j<c; j++){
                if (dp[i-1][j]==fsmax[0]){
                    dp[i-1][j] = fsmax[1] + matrix[i][j];
                }
                else{
                    dp[i-1][j] = fsmax[0] + matrix[i][j];
                }
            }
        }
        
        System.out.println("The maximum path sum is: " + getFSMAX(dp,r-2,c)[0]);
        sc.close();
    }
}
