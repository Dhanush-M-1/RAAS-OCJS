/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
     public static class pair{
        int first,second;
        pair(int a , int b){
            first = a;
            second = b;
        }
    }
    
     public static class triplate{
        int row,colom,steps;
        triplate(int a , int b , int c){
            row = a;
            colom = b;
            steps = c;
        }
    }
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		 Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	                        	int x0 = sc.nextInt();
		                     	int y0 = sc.nextInt();
			                 	int x1 = sc.nextInt();
			             		int y1 = sc.nextInt();
					          	int n = sc.nextInt();
						HashSet<String> valid = new HashSet<String>();
						
					    HashSet<String> visited = new HashSet<String>();
						
	                      	for(int i =1;i<=n;i++){
		                      int row = sc.nextInt();
		                       int c1 = sc.nextInt();
		                        int c2 = sc.nextInt();
		                        
		                        for(int j =c1;j<=c2;j++){
		                           
		                            valid.add((String.valueOf(row)+" "+String.valueOf(j)));
		                        }
		                        	}
		                        	
		                        	
		                        	
                         int dx[]={-1,-1,-1,0,1,1,1,0};
                         int dy[]={-1,0,1,1,1,0,-1,-1};
		                        	
		                        	// 0 = row , 1 = colom ,2 =  steps
		                  ArrayList<triplate> queue = new ArrayList<triplate>();   
		                  
		                       
		                       queue.add(new triplate(x0 , y0 , 0));
		                       //adding in visited array
                               
                                visited.add(String.valueOf(x0)+" "+String.valueOf(y0));
                                
		                       //apply BFS
		                       boolean not_found  = true ;
		                       int final_steps = -1;
		                       
		                       while(queue.size() != 0 && not_found){
		                           // pop top else
		                           int row_no = queue.get(0).row;
		                           int col_no = queue.get(0).colom;
		                           int step = queue.get(0).steps;
		                           
		                           queue.remove(0);
		                           
		                        //  System.out.println("Reached : "+ row_no +" "+col_no);
		                           
		                           // check it is the final destinaton?
		                           if(row_no == x1 && col_no == y1){
		                               not_found = false;
		                               final_steps = step;
		                           }else{
		                               // moveing king in 8 directions
		                               
		                               for(int j =0 ;j<8;j++){
		                               
		                              int new_row = row_no + dx[j];
		                              int new_colom = col_no + dy[j];
		                              
		                              if(valid.contains(String.valueOf(new_row)+" "+String.valueOf(new_colom))==true && visited.contains(String.valueOf(new_row)+" "+String.valueOf(new_colom))==false){
		                                  queue.add(new triplate(new_row , new_colom , step + 1));
		                                  visited.add(String.valueOf(new_row)+" "+String.valueOf(new_colom));
		                                  
		                              }
		                              
		                              
		                               
		                               }
		                               
		                           }
		                           
		                           
		                       }
		                       
		                       System.out.println(final_steps);
		                        	
			
			
			
			
	}
}
