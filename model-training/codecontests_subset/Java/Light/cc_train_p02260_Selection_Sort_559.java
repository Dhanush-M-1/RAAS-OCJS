import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];

		for (int i=0; i<n; i++) {
			arr[i] = scanner.nextInt();
		}
		int len = arr.length;

		int count = 0;
		for (int i = 0; i < len ; i++) {
			int mini = i;
			for (int j = i; j < len; j++) {
				if (arr[j] < arr[mini]) {
					mini = j;
				}
			}
			if(mini != i){
      	    	int temp = arr[i];
      	    	arr[i] = arr[mini];
      	    	arr[mini] = temp;

					count++;
				}

		}

		for (int i=0; i < len-1; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println(arr[arr.length-1]);
		System.out.println(count);
	}

}

