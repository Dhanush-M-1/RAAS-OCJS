import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Arrays;

class Main{
	public static void main(String[] args)throws Exception{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] numbers = new int[n];
		for(int i = 0; i < n; i++){
		    numbers[i] = scanner.nextInt();
		}
		int count = 0;
		int temp = 0;

		for(int i = 0; i < n; i++){
			int minj = i;
			for(int j = i; j < n; j++){
				if(numbers[j] < numbers[minj]){
					minj = j;
				}
			}
			if(i != minj){
			    temp = numbers[i];
    			numbers[i] = numbers[minj];
    			numbers[minj] = temp;
    			count++;
			}
		}

		for(int i = 0; i < n; i++){
			if(i == n-1){
				System.out.print(numbers[i]);
				System.out.print("\n");
			}else{
				System.out.print(numbers[i] + " ");
			}
		}
		System.out.println(count);
	}
}