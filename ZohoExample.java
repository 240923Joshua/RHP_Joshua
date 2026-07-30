import java.util.*;

public class ZohoExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String given = sc.next();

        int len = given.length();
        int[] stuff = new int[len];

        for (int i = 0; i < len; i++) {
            char ch = given.charAt(i);

            int n = len - 1 - i;   // correct position
            int mul = (int) Math.pow(10, n);

            int digit = ch - '0';

            for (int j = 0; j < digit && j < len; j++) {
                stuff[j] += mul;
            }
        }

        System.out.println(Arrays.toString(stuff));
        System.out.println(stuff.length);
    }
}