import java.lang.*;
import java.io.*;
import java.util.*;
public class Solution{

		public static void main(String args[]){
	    Scanner in = new Scanner(System.in);
	    int n=in.nextInt();
	    int m=in.nextInt();
	    int [] y=new int[m];
	    for(int i=0;i<n;i++){
	    	int s=in.nextInt();
	    	for(int j=0;j<s;j++){
	    		int g=in.nextInt();
	    		y[g-1]=9;
	    	}
	    }
	    int i=0;
	    for(i=0;i<m;i++){
	    	if(y[i]!=9)
	    		{System.out.println("NO");break;}
	    }
	    if(i==m)
	    	System.out.println("YES");
	   
	    
	 }}