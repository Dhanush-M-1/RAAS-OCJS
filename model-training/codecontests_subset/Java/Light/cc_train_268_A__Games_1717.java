import java.io.*;
import java.util.*;
 
public class Main {
    
	public static void main(String[] args) {
	    Scanner sc= new Scanner(System.in);
	    int n = sc.nextInt(), ans=0, ele=0;
	    int a[][] = new int[n][2];
	    for(int q=0; q<n; q++){
	        for(int w=0; w<2; w++){
	            a[q][w]=sc.nextInt();
	        }
	    }
	    for(int q=0; q<n; q++){
	        for(int w=0; w<n; w++){
	            ele = a[q][0];
	            if(w!=q && ele==a[w][1]){
	                ans+=1;
	            }
	        }
	    }
	    System.out.println(ans);
    }
}
        
        
