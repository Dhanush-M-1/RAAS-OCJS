import java.util.Arrays;
import java.util.Scanner;


public class OfficeKey {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();
		int z = input.nextInt();
		int[] arr = new int[n];
		int[] brr = new int[k];
		long mina = 999999999999999999L;
		for(int i=0; i<n;i++)arr[i] = input.nextInt();
		for(int i=0; i<k;i++)brr[i] = input.nextInt();
		Arrays.sort(arr);
		Arrays.sort(brr);
		for(int i=0;i<=k-n;i++){
			long dist = 0L;
			for(int j=0;j<n;j++){
				 dist = Math.max(dist,Math.abs(brr[i+j]-arr[j])+ Math.abs(z-brr[j+i]));
				 
			}
			//System.out.println(min);
			if(dist<mina)mina = dist;
		}
		System.out.println(mina);
				
				
	}

}
