import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = scanner.nextInt();

        selectionSort(n, nums);
    }

    private static void selectionSort(int n, int[] a) {
    	int sw = 0;
    	for (int i = 0; i < n - 1; i++) {
    		int minj = i;
    		for (int j = i + 1; j < n; j++) {
    			if (a[minj] > a[j]) minj = j;
    		}
    		if (minj != i) {
    			int tmp = a[i];
    			a[i] = a[minj];
    			a[minj] = tmp;
    			sw++;
     		}
    	}
    	trace(a);
    	System.out.println(sw);
    }

    private static void trace(int[] nums) {
    	System.out.println(Arrays.toString(nums).replaceAll("[\\[\\],]", ""));
    }

}
