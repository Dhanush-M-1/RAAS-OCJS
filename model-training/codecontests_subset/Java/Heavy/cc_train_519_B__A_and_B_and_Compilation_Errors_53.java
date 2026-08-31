import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

public class Codechef2 {
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
	        int n  = scan.nextInt();
	        int[] a = new int[n];
	        int[] b = new int[n-1];
	        int[] c = new int[n-2];
	        for(int i=0;i<n;i++) 	a[i] = scan.nextInt();
	        for(int i=0;i<n-1;i++) b[i] = scan.nextInt();
	        for(int i=0;i<n-2;i++) c[i] = scan.nextInt();
	        Arrays.sort(a);
	        Arrays.sort(b);
	        Arrays.sort(c);
	        int flag=0;
	        for(int i=0;i<n-1;i++) {
	        	if(a[i]!=b[i]) {
	        		System.out.println(a[i]);
	        		flag=1;
	        		break;
	        	}
	        	
	        }
	        if(flag==0) System.out.println(a[n-1]);
	        flag=0;
	        for(int i=0;i<n-2;i++) {
	        	if(b[i]!=c[i]) {
	        		System.out.println(b[i]);
	        		flag=1;
	        		break;
	        	}
	        	
	        }  
	        if(flag==0) System.out.println(b[n-2]);
	        
	        
	}
}