import java.util.*;
class Dp_longest_Substring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string of 1's and 0's : ");
        String s = sc.nextLine();
        int n = s.length();
         int[] dp = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int maxLen = 0;

        for (int i = 0; i < n; i++) {

            int value = (s.charAt(i) == '1') ? 1 : -1;

            if (i == 0)
                dp[i] = value;
            else
                dp[i] = dp[i - 1] + value;

            if (map.containsKey(dp[i])) {

                int len = i - map.get(dp[i]);
                maxLen = Math.max(maxLen, len);
            } else {

                map.put(dp[i], i);
            }
        }
        System.out.println("max substring is" + maxLen);
        sc.close();
    }
}
