
	
	
import java.util.*;
import java.io.*;

public class marte{


private int contor=0;

public static void main (String args[]) throws Exception{

Scanner input=new Scanner(System.in);

HashMap<String, Integer> map= new HashMap<String, Integer>();
HashMap<String, Integer> map2= new HashMap<String, Integer>();
HashMap<Integer, Integer> finish= new HashMap<Integer, Integer>();
HashMap<Integer, Integer> maxime= new HashMap<Integer, Integer>();
	
	
		
		int n=input.nextInt();
		int ma=input.nextInt();
		
	//	System.out.println("n="+n); 
		
		
		int [] v=new int[n];
		int [] m=new int[11];
		
		for(int i=0;i<n;i++) 
		
		
		{v[i]=input.nextInt();
		
		m[v[i]]++;
		    
		 // System.out.println(i+" "+v[i]+" "+m[v[i]]) ;
		    
		    
		}
		
		
			
			Long result=0l;
			result=n*1l*(n-1)/2;
			
			
		//	System.out.println("rez="+result);
			
			for(int i=0;i<11;i++){
			    
			    
		
			
			result-=(m[i]*1l*(m[i]*1l-1))/2;
			
		
			
	
			
			
			}
			
			
//	for(int i=0;i<11;i++)
	//	System.out.print(m[i]+" ");
		System.out.println(result);
			
			
			
			
			
			
		    
		}
	
}
	

	
	
	
	
	
	
