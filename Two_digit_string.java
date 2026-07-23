import java.util.*;
public class Two_digit_string{
    public static int Lcs_solve(int[] a, int[] b){
            int n = a.length;
            int m = b.length;
            int [][] matrix = new int[n+1][m+1];
            for(int i =1; i<=n;i++){
                for(int j =1; j<=m; j++){
                    if(a[i-1] == b[j-1]){
                        matrix[i][j] = matrix[i-1][j-1] +1;
                    }
                    else{
                        matrix[i][j] = Math.max(matrix[i-1][j],matrix[i][j-1]);
                    }
                }
            }
            int max = 0;
            for(int i=0;i<n+1;i++){
                for(int j =0; j<m+1; j++){
                    if(max<matrix[i][j]){
                        max= matrix[i][j];
                    }
                }
            }
            return max;
        }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
            for(int i =0; i<N; i++){
                String one = sc.next();
                String two = sc.next();
                int [] arr1 = new int[one.length()];
                int [] arr2 = new int[two.length()];
                int n = one.length();
                int m = two.length();
                for(int j =0; j<one.length(); j++){
                    arr1[j] = Character.getNumericValue(one.charAt(j));
                }
                for(int j =0; j<two.length(); j++){
                    arr2[j] = Character.getNumericValue(two.charAt(j));
                }
                for(int j =1; j<one.length();j++){
                    arr1[j] = (arr1[j-1] + arr1[j]) % 10;
                }
                for(int j =1; j<two.length();j++){
                    arr2[j] = (arr2[j-1] + arr2[j]) % 10;
                }
                if(arr1[n -1] == arr2[m -1]){
                    int ans = Lcs_solve(arr1,arr2);
                    System.out.println(ans);
                    
                }
                else{
                    System.out.println(-1);
                }
            }
        sc.close();
    }
}