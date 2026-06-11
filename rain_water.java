import java.util.*;
public class rain_water {
    public static int trap(int[] height) {
        int n = height.length;
        int [] left = new int[n];
        int [] right = new int [n];
        int max = 0;
        for (int i=0; i<n; i++){
            max = Math.max(max, height[i]);
            left[i] = max;
        }
        max =0;
        for (int i=n-1; i>=0; i--){
            max = Math.max(max, height[i]);
            right[i] = max;
        }
        int water = 0;

        for (int i = 0; i < n; i++) {
            water += Math.min(left[i], right[i]) - height[i];
        }

        return water;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of inputs: ");
        int n = sc.nextInt();
        int[] water = new int[n];
        System.out.println("Enter the levels: ");
        for (int i =0; i<n; i++){
            water[i] = sc.nextInt();
        }
        int result = trap(water);
        System.out.println("The amount of water trapped is : " + result);
        sc.close();
    }
}
