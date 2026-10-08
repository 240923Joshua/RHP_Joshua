import java.util.*;
class Sofa{
    int fc, fr, sc, sr, count;
    public Sofa(int fr, int fc, int sr, int sc, int count){
        this.fr = fr;
        this.fc = fc;
        this.sc = sc;
        this.sr = sr;
        this.count = count;
    }
}
public class moving_sofa{
    final static int diff[][] = {{1,0,1,0},{-1,0,-1,0},{0,1,0,1},{0,-1,0,-1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int flag = 0;
        char[][]grid = new char[n][m];
        for(int i =0; i<n; i++){
            for(int j=0; j<m; j++){
                grid[i][j] = sc.next().charAt(0);
            }
        }
        Queue<Sofa> queue = new ArrayDeque<>();
        int[] temp1 = new int[2];
        int[] temp2 = new int[2];
        Sofa s = new Sofa(0,0,0,0,0);
        boolean visited[][][][] = new boolean[n][m][n][m];
        outer:
        for(int i =0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 's'){
                    temp1[0] = i;
                    temp1[1] = j;
                    if(grid[i+1][j] == 's' && i+1<n){
                        temp2[0] = i+1;
                        temp2[1] = j;
                        s = new Sofa(temp1[0], temp1[1], temp2[0], temp2[1],0);
                    }
                    else{
                        temp2[0] = i;
                        temp2[1] = j+1;
                        s = new Sofa(temp1[0], temp1[1], temp2[0], temp2[1],0);
                    }
                    break outer;
                }
            }  
        }
        visited[s.fr][s.fc][s.sr][s.sc] = true;
        queue.add(s);
        //int count[][] = new int[n][m];
        while(!(queue.isEmpty())){
            Sofa curr = queue.poll();
            if(grid[curr.fr][curr.fc]=='S' && grid[curr.sr][curr.sc]=='S'){
                System.out.println(curr.count);
                flag++;
                return;
            }
            for(int i =0; i<4; i++){
                int far = (curr.fr) + diff[i][0];
                int fac = curr.fc + diff[i][1];
                int sar = curr.sr + diff[i][2];
                int sac = curr.sc + diff[i][3];
                if(far<n && far>=0 && fac<m && fac>=0 && sar<n && sar>=0 && sac<m && sac>=0 && grid[far][fac]!='H' && grid[sar][sac]!='H'){
                    if(!(visited[far][fac][sar][sac])){
                        visited[far][fac][sar][sac] = true;
                        queue.add(new Sofa(far, fac, sar, sac, curr.count + 1));
                    }
                }
            }
            
            for (int i = 0; i < 2; i++) {
                int pr = i == 0 ? curr.fr : curr.sr;
                int pc = i == 0 ? curr.fc : curr.sc;
                int orr = i == 0 ? curr.sr : curr.fr;
                int occ = i == 0 ? curr.sc : curr.fc;

                int dr = orr - pr, dc = occ - pc;
                int[][] perp = {{-dc, dr}, {dc, -dr}};
                for (int[] p : perp) {
                    int nr = pr + p[0], nc = pc + p[1];     
                    int cr = orr + p[0], cc = occ + p[1];   
                    if (nr<n && nr>=0 && nc<m && nc>=0 && cr<n && cr>=0 && cc<m && cc>=0 && grid[nr][nc]!='H' && grid[cr][cc]!='H'){           //by Joshua D
                        int a = i == 0 ? pr : nr;
                        int b = i == 0 ? pc : nc;
                        int c = i == 0 ? nr : pr;
                        int e = i == 0 ? nc : pc;
                        if (!(visited[a][b][c][e])){
                            visited[a][b][c][e] = true;
                            queue.add(new Sofa(a, b, c, e, curr.count + 1));
                        }
                    }
                }
            }
        }
        if(flag==0) System.out.println("Impossible");
        sc.close();
    }
}