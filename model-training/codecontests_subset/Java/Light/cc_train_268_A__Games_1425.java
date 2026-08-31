//package coding;
import java.util.*;
public class Main {
	static Scanner scn= new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = scn.nextInt();
		int[][] arr = new int[n][2];
		
		for(int i =0;i<n;i++){
			arr[i][0] = scn.nextInt();
			arr[i][1] = scn.nextInt();
		}
		int ans =0;
		for(int i =0;i<n;i++){
			for(int j =0;j<n;j++){
				if(i!=j){
					if(arr[i][0]==arr[j][1]){
						ans++;
					}
				}
			}
		}
		System.out.println(ans);
	}
	
	
}
