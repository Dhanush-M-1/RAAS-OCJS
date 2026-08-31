import java.util.*;
import java.io.*;
class Main{
	public static void main(String[]args){
		Scanner in=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out, true);
		int n=in.nextInt();
		int a[]=new int[n];
		int count=0;
		for(int i=0;i<n;i++){
			a[i]=in.nextInt();
		}
		for(int i=0;i<n;i++){
			int min=i;
			
			for(int j=i;j<n;j++){
				if(a[j]<a[min]){
					min=j;
				}
			}
			if(i!=min)
				count++;
			int temp=a[i];
			a[i]=a[min];
			a[min]=temp;
		}
		for(int i=0;i<n;i++){
			if(i==n-1)
				out.printf(a[i]+"\n");
			else
				out.print(a[i]+" ");
		}
		out.println(count);
	}
}
