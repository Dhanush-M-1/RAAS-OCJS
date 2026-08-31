import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for(int arrayIndex = 0; arrayIndex < n; arrayIndex++) {
			nums[arrayIndex] = sc.nextInt();
		}
		int swapCount = 0;
		for(int index = 0; index < n; index++) {
			int minj = index;
			for(int j = index; j < n; j++) {
				if(nums[j] < nums[minj]) {
					minj = j;
				}
			}
			if(index != minj) {
				swapCount++;
			}
			int work = nums[index];
			nums[index] = nums[minj];
			nums[minj] = work;
		}
		printArray(nums);
		System.out.println(swapCount);
	}
	public static void printArray(int[] array) {
		int arrayLength = array.length;
		for(int index = 0; index < arrayLength - 1; index++) {
			System.out.print(array[index] + " ");
		}
		System.out.println(array[arrayLength - 1]);
	}
}