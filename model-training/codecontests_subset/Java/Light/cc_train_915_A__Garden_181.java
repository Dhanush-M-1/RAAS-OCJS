import java.io.*;
import java.util.*;
import java.lang.*;
public class abc{
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int i,n=in.nextInt(),l=in.nextInt();
		int[]a=new int[n];
		for(i=0;i<n;i++){
			a[i]=in.nextInt();
		}
		Arrays.sort(a);
		for(i=n-1;i>=0;i--){
			if(l%a[i]==0){
				System.out.println(l/a[i]);
				break;
			}
		}
	}
}