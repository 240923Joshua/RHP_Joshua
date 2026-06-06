import java.util.*;
class matrix_col{
    public static long[] getFSMAX (long[][] dp,int r, int c){
        long fmax = Long.MIN_VALUE;
        long smax = Long.MIN_VALUE;
        int maxrow = -1;
        for(int i=0;i<r;i++){
            if(dp[i][c] > fmax){
                smax = fmax;
                fmax = dp[i][c];
                maxrow = i;
            } else if(dp[i][c] > smax){
                smax = dp[i][c];
            }
        }
        return new long[] {fmax, smax, maxrow};
    } 
    public static void main(String[] args){
        System.out.println("enter row and column");
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        System.out.println("Enter the matrix values:");
        int [][] matrix = new int[r][c];
        long [][] dp = new long[r][c];
        for (int i=0; i<r; i++){
            for (int j=0; j<c; j++){
                matrix[i][j] = sc.nextInt();
                if(j==0){
                    dp[i][j] = matrix[i][j];
                }
            }
        }
        for (int j = 1; j<c; j++){
            long[] fsmax = getFSMAX(dp, r, j-1);
            for (int i = 0; i<r; i++){
                if(i == fsmax[2]){
                    dp[i][j] = fsmax[1] + matrix[i][j];
                }
                else{
                    dp[i][j] = fsmax[0] + matrix[i][j];
                }
            }
        }
        System.out.println("The maximum path sum is: " + getFSMAX(dp,r,c-1)[0]);
        sc.close();

    }
}