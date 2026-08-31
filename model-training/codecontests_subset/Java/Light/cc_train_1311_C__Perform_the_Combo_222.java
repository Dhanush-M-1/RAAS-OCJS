/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
public class GFG {
	public static void main (String[] args) {
Scanner sc=new Scanner(System.in);
int t=sc.nextInt();
while(t>0){
    int n=sc.nextInt();
    int m=sc.nextInt();
    String str=sc.next();
    int count[]=new int[n];
    for(int i=0;i<m;i++){
        int l=sc.nextInt();
        count[--l]++;
    }
    int c[]=new int[n];
    
    for(int i=n-2;i>=0;i--){
        count[i]=count[i]+count[i+1];
       
    }
    for(int i=0;i<n;i++){
        count[i]++;
    }
    int arr[]=new int[26];
    for(int i=0;i<n;i++){
        arr[str.charAt(i)-97]=arr[str.charAt(i)-97]+count[i];
    }
    
    for(int i=0;i<26;i++)
    System.out.print(arr[i]+" ");
    System.out.println();
    t--;
}
	}
}