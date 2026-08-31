import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    int sum=0,n=in.nextInt();
	    int[] home=new int[n];
	    int[] guest=new int[n];
	    for(int i=0;i<n;i++){
	    home[i]=in.nextInt();
	    guest[i]=in.nextInt();
	    }
	    for(int i=0;i<n;i++){
	    	for(int j=0;j<n;j++){
	    		if(home[i]==guest[j]&&i!=j)
	    			sum++;
	    	}
	    }
	 System.out.println(sum);
	}
}


