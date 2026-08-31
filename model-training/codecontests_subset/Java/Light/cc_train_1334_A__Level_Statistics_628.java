import java.io.*;
import java.util.*;

public class GFG {
	public static void main (String[] args)throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int t=Integer.parseInt(br.readLine());
	for(int k=0;k<t;k++){
	    int N = Integer.parseInt(br.readLine());
	    int[] play=new int[N];
	    int[] clear=new int[N];
	    for(int i=0;i<N;i++){
	        String[] input=br.readLine().split(" ");
	        play[i]=Integer.parseInt(input[0]);
	        clear[i]=Integer.parseInt(input[1]);
	    }
	    int pmax=play[0],flag=0,cmax=clear[0];
	    for(int i=1;i<N;i++){
	        if(play[i]<pmax){
	            System.out.println("NO");
	            flag=1;
	            break;
	        }
	        pmax=play[i];
	         if(clear[i]<cmax){
	            System.out.println("NO");
	            flag=1;
	            break;
	        }
	        cmax=clear[i];
	    }
	    if(flag==0){
	        for(int i=0;i<N;i++){
	            if(clear[i]>play[i]){
	                System.out.println("NO");
	                flag=1;
	                break;
	            }
	        }
	    }
	    
	    if(flag==0){
	        for(int i=0;i<N-1;i++){
	            if(play[i+1]-play[i]<clear[i+1]-clear[i]){
	                System.out.println("NO");
	                flag=1;
	                break;
	                
	            }
	        }
	    }
	    if(flag==0){
	        System.out.println("YES");
	    }
	    
	    
	}
	}
}