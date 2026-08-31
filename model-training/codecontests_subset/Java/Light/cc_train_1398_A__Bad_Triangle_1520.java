import java.util.Arrays;
import java.util.Scanner;


public class BadTriangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0){
			int x = sc.nextInt();
			long arr[] = new long[x];
			for(int i=0;i<x;i++)
				arr[i] = sc.nextLong();
			long sum = arr[0]+arr[1];
//			System.out.println(sum+" "+arr[x-1]);
				
			if(sum>arr[x-1])
				System.out.println("-1");
			else
				System.out.println(1+" "+2+" "+(x));
		}
		
	}

}
