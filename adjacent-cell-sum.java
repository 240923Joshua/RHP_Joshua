import java.util.*;
class AdjacentCellSum {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter row and column size:");
        System.out.print("row: ");
        int row = sc.nextInt();
        System.out.println();
        System.out.print("col: ");
        int col = sc.nextInt();
        System.out.println();

        int matrix[][] = new int[row][col];

        for (int i=0;i<row;i++){
            for (int j = 0; j<col;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int[][] adj = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        System.out.println("Input matrix:");
        for (int i=0;i<row;i++){
            for (int j = 0; j<col;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Adjacent cell sum:");
        for(int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                int sum = 0;
                for (int k=0;k<8;k++){
                    int r = i + adj[k][0];
                    int c = j + adj[k][1];
                    if (r>=0 && r<row && c>=0 && c<col){
                        sum += matrix[r][c];
                    }
                }
                System.out.print(sum + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}