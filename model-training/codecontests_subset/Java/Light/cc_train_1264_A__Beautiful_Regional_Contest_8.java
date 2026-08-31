import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n,t=sc.nextInt();
		int []arr;
		while(t-->0){
			n=sc.nextInt();
			arr=new int[n];
			int z=0;
			for(int i=0;i<n;i++)
				arr[i]=sc.nextInt();
			int idx=n/2-1;
			while(idx>=0&&arr[idx]==arr[n/2])
				idx--;
			if(idx==-1){
				System.out.println("0 0 0");
				continue;
			}
			int g=0,s=0,b=0;
			for(int i=0;i<=idx;i++){
				if(i>0&&arr[i-1]!=arr[i])
					z++;
				if(z==0)
					g++;
				else{
					if(z==1||s<=g){
						s++;
						z=1;
					}
					else
						b++;
				}
			}
			if(z<2){
				System.out.println("0 0 0");
				continue;
			}
			if(b<=g||s<=g){
				System.out.println("0 0 0");
				continue;
			}
			else{
				System.out.println(g+" "+s+" "+b);
				continue;
			}
		}
	}
}