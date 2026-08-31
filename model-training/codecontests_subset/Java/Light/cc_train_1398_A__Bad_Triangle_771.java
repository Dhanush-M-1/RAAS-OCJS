//package faltu;
import java.util.Arrays;
import java.util.Scanner;

public class Atlassiantest {
public static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t=scn.nextInt();
		for(int w=0;w<t;w++){
			int n=scn.nextInt();
			
			int arr[]=new int[n];
			for(int i=0;i<n;i++){
				arr[i]=scn.nextInt();
			}
			Arrays.sort(arr);
			if(arr[0]+arr[1]>arr[n-1]){
				System.out.println(-1);
			}else{
				System.out.println(1+" "+2+" "+n);
			}
		}
		
			
		
		
	
		
	}

	
}
   
   
