
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true){
			final int N = sc.nextInt();
			
			if(N == 0){
				break;
			}
			
			int[] array = new int[N];
			
			for(int i = 0; i < N; i++){
				array[i] = sc.nextInt();
			}
			
			int count = 0;
			for(int i = N-1; i >= 1; i--){
				for(int j = 0; j < i; j++){
					if(array[j] > array[j+1]){
						int tmp = array[j];
						array[j] = array[j+1];
						array[j+1] = tmp;
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
		
	}

}