import java.util.*;
public class problem268a{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] hu = new int[n];
		int[] gu = new int[n];
		for(int i = 0 ; i < n ; i++){
			hu[i] = sc.nextInt();
			gu[i] = sc.nextInt();
		}
		int ans = 0;
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < n ; j++){
				if(hu[j] == gu[i])
					ans++;
			}
		}
		System.out.println(ans);
	}
}