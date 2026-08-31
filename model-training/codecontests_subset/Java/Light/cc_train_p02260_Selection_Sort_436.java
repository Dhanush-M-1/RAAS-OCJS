import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int len = scanner.nextInt();
		int nums[] = new int[len];
		int count = 0;

		for (int i = 0; i < nums.length; i++) {
			nums[i] = scanner.nextInt();
		}

		int minIdx = 0;

		for (int j = 0; j < nums.length; j++) {
			minIdx = j;
			for (int j2 = j; j2 < nums.length; j2++) {
				if (nums[j2] < nums[minIdx]) {
					minIdx = j2;
				}
			}
			if (minIdx != j) {
				int minValue = nums[minIdx];
				nums[minIdx] = nums[j];
				nums[j] = minValue;
				count++;
			}
		}
		new Main().arrayToString(nums);
		System.out.println(count);
	}

	public void arrayToString(int[] arr) {
		for (int i = 0; i < arr.length; i++) {

			if (i == arr.length - 1) {
				System.out.println(arr[i]);
			} else {
				System.out.print(arr[i] + " ");
			}
		}
	}

}
