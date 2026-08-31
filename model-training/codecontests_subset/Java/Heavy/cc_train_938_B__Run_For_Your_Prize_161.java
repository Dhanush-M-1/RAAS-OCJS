import java.util.Arrays;
import java.util.Scanner;
public class Solution {

	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int max = 1000000;
		int division = max/2;
		int[] Me = new int[division];
		int[] Friend = new int[division];
		int MeMax = 0, FriendMax = 0, Mek = 0, FriendK = 0, num, i;
		for(i = 0 ; i < n ; i++){
			num = s.nextInt();
			if(num <= division)
			{
				MeMax = num;
			}				
			else {
				
				FriendMax = max - num + 1;
				break;
			}
		}
		for( i = i+1; i< n ;i++){
			
			num = s.nextInt();
		}
		
		int ans = (MeMax > FriendMax)?MeMax : FriendMax;
		System.out.println(ans - 1);
		
		
	}

}
