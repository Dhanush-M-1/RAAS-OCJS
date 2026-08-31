import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        int i=0,sum=0;
        int hun=0,thun=0;
        for(i=0;i<n;i++)
        {
        	arr[i] = scanner.nextInt();
        	sum += (arr[i]/100);
        	if(arr[i]==100)
        		hun = 1;
        	else
        		thun = 1;
        }
        scanner.close();
        if(thun == 1 && hun == 1)
        {
        	if(sum%2==0)
        		System.out.print("YES");
        	else
        		System.out.print("NO");
        }
        else if((thun ==1 && hun == 0) || (hun == 1 && thun==0))
        {
        	if(n%2==0)
        		System.out.print("YES");
        	else
        		System.out.print("NO");
        }
        	
	}
}
	
	
	
    




