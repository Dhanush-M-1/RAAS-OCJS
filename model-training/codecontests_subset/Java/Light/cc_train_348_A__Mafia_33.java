import java.util.Scanner;

//import BadPrices.Scanner;


public class Mafia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input =new Scanner(System.in);
		int n = input.nextInt();
		long[] arr = new long[n];
		long max = 0;
	    long  total = 0;
		for(int i=0; i<n;i++){
			arr[i] = input.nextInt();
			if(arr[i]>max)max = arr[i];
			
			total+=arr[i];
		}
		long val = (int)Math.ceil(total*1.0/(n-1));

		System.out.println(Math.max(val,max));
	}

}
