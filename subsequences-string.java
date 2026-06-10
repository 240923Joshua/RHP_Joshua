import java.util.*;
class subsequencesString {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first string:");
        String str1 = sc.nextLine();
        System.out.println("Enter the second string:");
        String str2 = sc.nextLine();
        int n = str1.length();
        int m = str2.length();
        int[][] matrix = new int[n+1][m+1];
        for(int i =0; i<n+1; i++){
            for(int j = 0; j<m+1; j++){
                if(i == 0 || j == 0){
                    matrix[i][j] = 0;
                }
                else{
                    if (str1.charAt(i-1) == str2.charAt(j-1)){
                        matrix[i][j] = matrix[i-1][j-1] +1;
                    }
                    else{
                        matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
                }
            }
        }
    }
        String result = "";
        int max =0;
        for(int i =0; i<n+1; i++){
            for(int j = 0; j<m+1; j++){
                if((matrix[i][j] > max) && (matrix[i][j] != max)){
                    max = matrix[i][j];
                    result += str1.charAt(i-1);
                }
            }
        }
        
        System.out.println("the matrix is : ");
        for(int i =0; i<n+1; i++){
            for(int j = 0; j<m+1; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("The length of the longest common subsequence is: " + max);
        System.out.println("The longest common subsequence is: " + result);
        sc.close();
    }
}
