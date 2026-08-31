import java.util.Scanner;

public class BadTriangle {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int tt= in.nextInt();

		for(int t=0; t<tt;t++) {

			int[] arr = new int[in.nextInt()];

			for(int i=0;i<arr.length;i++) {
				arr[i]=in.nextInt();
			}

			String ans=-1+"";

			/*
			 * If there are values available which cannot make a triangle, this loop will stop.
			 */
			for(int i=2;i<arr.length;i++) {
				if(arr[0]+arr[1]<=arr[i]) {
					ans=1+" "+2+ " "+Integer.valueOf(i+1); 
					break;
				}
			}
			

			System.out.println(ans);
		}
	}
	
}


