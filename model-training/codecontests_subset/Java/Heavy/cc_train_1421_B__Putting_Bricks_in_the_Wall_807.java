
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class pp
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(br.readLine());
		while(test-->0){
		    int n=Integer.parseInt(br.readLine());
		    ArrayList<String> arr=new ArrayList();
		    for(int i=0;i<n;i++){
		        arr.add(br.readLine().trim());
		    }
		    
		    char a=arr.get(0).charAt(1);
		    char b=arr.get(1).charAt(0);
		    char c=arr.get(n-2).charAt(n-1);
		    char d=arr.get(n-1).charAt(n-2);
		    if(a==b){
		        if(c==d){
		            if(a!=c){
		                System.out.println(0);
		            }
		            else{
		                System.out.println(2);
		                System.out.println(1+" "+2);
		                System.out.println(2+" "+1);
		                
		            }
		        }
		        
		       else if(c!=d){
		            System.out.println(1);
		            if(c==a){
		            	System.out.println(String.valueOf(n-1)+" "+String.valueOf(n));
		            }
		            else if(d==a){
		                 
		            	System.out.println(String.valueOf(n)+" "+String.valueOf(n-1));
		            }
		        }
		    }
		    
		    
		    
		   else if(c==d){
		        if(a==c){
		             System.out.println(1);
		            System.out.println(1+" "+2);
		        }
		        else if(b==c){
		             System.out.println(1);
		                  System.out.println(2+" "+1);
		        }
		    }
		    
		    else{
		     if(a==c){
		        System.out.println(2);
		        System.out.println(2+" "+1);
		        System.out.println(String.valueOf(n-1)+" "+String.valueOf(n));
		        
		    }
		    
		    else if(b==c){
		        System.out.println(2);
		        System.out.println(1+" "+2);
		        System.out.println(String.valueOf(n-1)+" "+String.valueOf(n));
		        
		    }
		    }
		        
		    }
		}
	}
