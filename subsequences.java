import java.util.*;
class Test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        int n = str.length();
        for (int i = (1<<n)-1; i >=0; i--) {
            String ans = "";
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) !=0 ) {
                    ans += str.charAt(j);
                }
            }
            System.out.println(ans);

        }
        s.close();
    }
}