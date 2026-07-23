import java.util.*;

public class nikita_and_books {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            long prev = 0;
            boolean ok = true;

            for (int i = 0; i < n - 1; i++) {
                long need = prev + 1;

                if (a[i] < need) {
                    ok = false;
                    break;
                }

                long extra = a[i] - need;
                a[i + 1] += extra;
                prev = need;
            }

            System.out.println(ok ? "YES" : "NO");
        }

        sc.close();
    }
}