import java.util.*;
public class DisjointSet{
    public static int find(int [] ldr, int node){
        if(ldr[node] != node){
            ldr[node] = find(ldr, ldr[node]);
        }
        return ldr[node];
    }
    public static void join(int [] ldr, int r,int l){
        ldr[find(ldr, r)] = find(ldr, l);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] ldr = new int[n+1];
        for(int i =1;i<=n; i++){
            ldr[i] = i;
        }
        int m = sc.nextInt();
        for(int i=1;i<=m;i++){
            int l = sc.nextInt();
            int r = sc.nextInt();
            join(ldr,r,l);
        }
        System.out.println(Arrays.toString(ldr));
        HashSet<Integer> finals = new HashSet<>();
        for(int i=1;i<n+1;i++){
            finals.add(find(ldr,i));
        }
        System.out.println(finals);
        System.out.println(finals.size());
        sc.close();
    }

}