/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int t[] = new int[n];
		t[0] = sc.nextInt()-1;
		t[1] = sc.nextInt()-1;
		t[2] = sc.nextInt()-1;
		t[3] = sc.nextInt()-1;
		int y = 4;
		for(int x = 0;x<n;x++){
			if(x==t[0]||x==t[1]||x==t[2]||x==t[3]) continue;
			t[y]=x;
			y++;
		}
		for(int i = 0;i<n;i++){
			t[i]++;
		}
		if(n==4){
			System.out.println(-1);
		}
		else if(n==5){
			if(k<=5){
				System.out.println(-1);
			}
			else{
				System.out.println(t[0] + " " + t[2] + " " + t[4] + " " + t[3] + " " + t[1]);
				System.out.println(t[2] + " " + t[0] + " " + t[4] + " " + t[1] + " " + t[3]);
			}
		}
		else{
			if(k<=n){
				System.out.println(-1);
			}
			else{
			System.out.print(t[0]+" ");
			System.out.print(t[3] + " ");
			for(int j = 4;j<n;j++){
				System.out.print(t[j] + " ");
			}
			System.out.print(t[2] + " ");
			System.out.print(t[1] + " ");
			System.out.println();
			
			System.out.print(t[2]+" ");
			System.out.print(t[1] + " ");
			for(int j = 4;j<n;j++){
				System.out.print(t[j] + " ");
			}
			System.out.print(t[0] + " ");
			System.out.print(t[3] + " ");
			System.out.println();
			}
		}
	}
}