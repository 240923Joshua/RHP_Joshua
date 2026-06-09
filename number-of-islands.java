import java.util.*;
class numberOfIslands {
    final static int diff[][] = {{0,-1},{0,1},{-1,0},{1,0}};
    public static void dfs(char[][] grid, int i, int j, int R,int C){
        grid[i][j] = '0';
        for(int k = 0; k<4; k++){
            int ar = i + diff[k][0];
            int ac = j + diff[k][1];
            if (ac>=0 && ac<C && ar>=0 && ar<R){
                if (grid[ar][ac] == '1'){
                    dfs(grid,ar,ac,R,C);
                }
            }
        }
    }
    public static int numIslands(char[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        int island = 0;
        for (int i =0;i<R;i++){
            for (int j =0; j<C; j++){
                if (grid[i][j] == '1'){
                    island++;
                    dfs(grid,i,j,R,C);
                }
            }
        }
        return island;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter row and column size:");
        System.out.print("row: ");
        int row = sc.nextInt();
        System.out.println();
        System.out.print("col: ");
        int col = sc.nextInt();
        System.out.println();

        char[][] grid = new char[row][col];

        for (int i=0;i<row;i++){
            for (int j = 0; j<col;j++){
                grid[i][j] = sc.next().charAt(0);
            }
        }
        System.out.println("Input grid:");
        for (int i=0;i<row;i++){
            for (int j = 0; j<col;j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        int result = numIslands(grid);
        System.out.println("Number of islands: " + result);
        sc.close();
    }
}
