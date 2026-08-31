
import java.util.*;

public class combo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s= new Scanner(System.in);

		int t= s.nextInt();

		while(t-->0) {

			int n= s.nextInt();
			int m= s.nextInt();

			String str= s.next();
			int[] help= new int[m];

			for(int i=0; i<m;i++) {
				help[i]= s.nextInt();
			}

			Arrays.sort(help);
			int[] arr= new int[26];

			for(int i=0; i<m;i++) {

				if(i==0) {
					String small = str.substring(0,help[i]); 

					for(int j=0; j<small.length();j++) {
						arr[small.charAt(j)-'a'] += (m-i);
					}
				}
				else {
					String small = str.substring(help[i-1],help[i]); 

					for(int j=0; j<small.length();j++) {
						arr[small.charAt(j)-'a'] += (m-i);
					}
				}
			}

			for(int i=0; i<str.length();i++) {
				arr[str.charAt(i)-'a'] += 1;
			}
			
			for(int i=0; i<arr.length;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
	}

}
