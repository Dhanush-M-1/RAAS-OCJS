import java.util.Arrays;
import java.util.Scanner;


public class Mathshow1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int k = input.nextInt();
		int m = input.nextInt();
		int[] arr = new int[k];
		int total=0;
		for(int i=0; i<k;i++){
			arr[i] = input.nextInt();
			total+=arr[i];
		}
		int max=-1;
		Arrays.sort(arr);
		for(int i=0; i<=n;i++){
			int points = i*(k+1);
			long rem = m-i*total;
			if(rem <0 )continue;
			for(int j=0; j<k;j++){
				int picks = Math.min(n-i,(int)rem/arr[j]);
				if(picks==0){
					break;
				}
				points+=picks;
				rem-=picks*arr[j];
			}
			
			max = Math.max(points,max);
		}
		System.out.println(max);
				
				
		
	}

}
