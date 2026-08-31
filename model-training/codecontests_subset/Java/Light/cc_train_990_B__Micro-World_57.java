import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(), K = s.nextInt();
		int[] arr = new int[1000001];
		for(int i = 0; i < n; i++){
			int x = s.nextInt();
			arr[x]++;
		}
		
		int count = 0;
		for(int i = 0; i < arr.length;){
			if(arr[i] == 0){
				i++;
				continue;
			}else{
				int j = i + 1;
				for(j = i + 1; j < arr.length && j <= i + K; j++){
					if(arr[j] > 0){
						break;
					}
				}
				if(j == i + K + 1 || j == arr.length){
					count += arr[i];
				}
				i = j;
			}
		}
		System.out.println(count);
	}

}