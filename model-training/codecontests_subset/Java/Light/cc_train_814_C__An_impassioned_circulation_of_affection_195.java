import java.util.Scanner;
public class C{
	public static void main(String[]__){
		
		
		Scanner scan = new Scanner(System.in);
		int length = scan.nextInt();
		String s =scan.next();
		//created to pre_process the maximum length obtainable after checking whether the same character appears more than ocnce
		int [][] dp = new int[26][length+1];
		
		for ( int i=0; i < length;i++){
			int column = 0;
			for  ( int j=i;j<length;j++){
				if(s.charAt(i)!=s.charAt(j))// move to other column
					column++;
				dp[s.charAt(i)-'a'][column] = Math.max(dp[s.charAt(i)-'a'][column], j-i+1);
				// if they are not equal, answer will be based on the index i+1
			}
		}
		// loop on the dp array. if the letter is not found, then largest Koyomoti will be found based on the number of max moves allowed
		
		for ( int[] subArray:dp ){
			for ( int i=1;i<=length;i++){
				subArray[i]= Math.max(Math.min(length, subArray[i-1]+1),subArray[i]);
			}
		}
		
		
		int steps = scan.nextInt();
		for ( int i =0; i < steps;i++){
			
			int pos = scan.nextInt();
			String str = scan.next();
			int max = dp[str.charAt(0)-'a'][pos];
			System.out.println(max);
		}
		
			scan.close();
	}
}