import java.util.*;
public class No_of_turns{
    final static int diff[][] = {{0,-1},{0,1},{1,0},{-1,0}}; 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int per[] = new int[2];
        char grid[][] = new char[n][m];
        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                char ch = sc.next().charAt(0);
                grid[i][j] = ch;
                if(ch == 'P'){
                    per[0] = i;
                    per[1] = j;
                }
            }
        }
        Queue<int[]> q = new ArrayDeque<>();
        int visited[][] = new int [n][m];
        for (int[] row : visited) {
            Arrays.fill(row, -1);
        }
        
        visited[per[0]][per[1]] = 0;
        q.add(per);
        while(!(q.isEmpty())){
            int temp[] = q.poll();
            for(int i =0; i<4; i++){
                int ar = temp[0] + diff[i][0];
                int ac = temp[1] + diff[i][1];

                while (ar<n && ar>=0 && ac<m && ac>=0 && grid[ar][ac] != 'x'){//bj Joshua D
                    if(visited[ar][ac] == -1){
                        visited[ar][ac] = visited[temp[0]][temp[1]] + 1;
                        int t[] = new int[2];
                        t[0] = ar;
                        t[1] = ac;
                        q.add(t);
                    }
                    if(grid[ar][ac] == 'D'){
                        System.out.print(visited[ar][ac] - 1);
                        return;
                    }
                    ar += diff[i][0];
                    ac += diff[i][1];
                }
                

            }
        }
        System.out.println("Impossible");
        sc.close();


    }
}