// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
public class Main {
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int a[]= new int[20];
		for(int i=0;i<n;i++){
		    int x = in.nextInt();
		    a[x]++;
		}
		int total = 0;
		for(int i= 1;i<m;i++){
		    for(int j = i+1;j<=m;j++){
		        total += a[i]*a[j];
		    }
		}
		System.out.println(total);
        
	}
}