import java.util.*;
import java.io.*;
public class b{

	public static void main(String [] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int [] a=new int[n];
		int max=-1;
		int s=0;
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
			max=Math.max(a[i],max);
			s+=a[i];
		}

		boolean valid=true;
		while(valid){
			int sum=0;
			for(int i=0;i<n;i++){
				sum+=(max-a[i]);
			}
			if(sum>s){
				System.out.println(max);
				valid=false;
				return;
			}
			max++;
		}


		
		
	}
}