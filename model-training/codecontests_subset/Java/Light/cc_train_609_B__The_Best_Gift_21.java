import java.util.Scanner;


public class TheBestGift {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int[] z = new int[m+1];
		int[] arr = new int[n];
		int counter=0;
		for(int i=0; i<n;i++)z[input.nextInt()]++;
		
		for(int i=1; i<=m;i++){
			for(int j=i+1; j<=m;j++){
				counter+=z[i]*z[j];
			}
		}
		System.out.println(counter);
	}

}
