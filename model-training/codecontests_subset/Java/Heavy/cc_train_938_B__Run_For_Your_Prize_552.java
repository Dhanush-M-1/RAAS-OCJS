import java.util.Arrays;
import java.util.Scanner;

public class RunforPrize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n;i++)arr[i] = input.nextInt();
		Arrays.sort(arr);
		int i=0;
		while(i<n && arr[i]<=500000){
			i++;
		}
		i--;
		
		if(i==-1){
			System.out.println(1000000-arr[0]);
		    return;
		}
		
		if(i!=n){
			int start = arr[i];
			if(i+1 !=n){
				int end = arr[i+1];
			   System.out.println(Math.max(start-1,1000000-end));
			}
			else{
				System.out.println(arr[i]-1);
			}
		}
		
			
	}

}
