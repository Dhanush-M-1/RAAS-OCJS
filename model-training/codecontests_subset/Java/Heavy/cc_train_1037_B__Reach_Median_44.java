import java.util.Scanner;
import java.util.Arrays;

public class CF1037B {
	static final Scanner sc = new Scanner(System.in);
	
	static long getRequiredMedian(int[] numsArr, int requiredMedian) {
		Arrays.sort(numsArr);
		int middleIdx = numsArr.length/2;
		long operationsOnLesser = 0;
		long operationsOnGreater = 0;
		
		// Need to modify numbers greater than requiredMedian on the left side
		for (int i = 0; i < middleIdx; ++i) {
			operationsOnLesser += Math.max(0, numsArr[i] - requiredMedian);
		}
		
		// Need to modify numbers smaller than requiredMedian on the right side
		for (int i = middleIdx+1; i < numsArr.length; ++i) {
			operationsOnGreater += Math.max(0, requiredMedian - numsArr[i]);
		}
		
		int necessaryChange = Math.abs(numsArr[middleIdx] - requiredMedian);
		return operationsOnLesser + operationsOnGreater + necessaryChange;
	}
		
	public static void main(String[] args) {
		int nums = sc.nextInt();
		int[] numsArr = new int[nums];
		
		int requiredMedian = sc.nextInt();
		
		for (int n = 0; n < nums; ++n) {
			numsArr[n] = sc.nextInt();
		}
		
		long operations = getRequiredMedian(numsArr, requiredMedian);
		System.out.print(operations);
	}
}
