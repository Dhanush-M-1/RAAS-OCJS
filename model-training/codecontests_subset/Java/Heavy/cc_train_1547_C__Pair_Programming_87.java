/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

public class GFG {
    
   	public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		scn.nextLine();
		
		while(t-- > 0){
		    int p = scn.nextInt();
		    int n = scn.nextInt();
		    int m = scn.nextInt();
		   
		    int[] arr1 = new int[n];
		    int[] arr2 = new int[m];
		    
		    for(int i=0; i<n+m; i++){
		        if(i < n){
		            arr1[i] = scn.nextInt();
		        }
		        else{
		            arr2[i-n] = scn.nextInt();
		        }
		    }
		    
		    String str = "";
		    int j=0, k=0;
		    int tag =0;
		    for(int i=0; i<n+m; i++){
		        if(j < n  &&  k < m){
		            if(arr1[j] == 0){
		                str += arr1[j] + " ";
		                p++;
		                j++;
		            }
		            else if(arr2[k] == 0){
		                str += arr2[k] + " ";
		                p++;
		                k++;
		            }
		            else{
		                int page1 = arr1[j];
		                int page2 = arr2[k];
		                
		                if(p < page1  &&  p < page2){
		                    tag = 1;
		                    break;
		                }
		                else if(page1 <= p){
		                    str += arr1[j] + " ";
		                    j++;
		                }
		                else{
		                    str += arr2[k] + " ";
		                    k++;
		                }
		            }
		        }
		        else if(j < n){
		            if(arr1[j] == 0){
		                str += arr1[j] + " ";
		                p++;
		                j++;
		            }
		            else{
		                int page1 = arr1[j];
		                
		                if(p < page1){
		                    tag = 1;
		                    break;
		                }
		                else{
		                    str += arr1[j] + " ";
		                    j++;
		                }
		            }
		        }
		        else{
		            if(arr2[k] == 0){
		                str += arr2[k] + " ";
		                p++;
		                k++;
		            }
		            else{
    	                int page2 = arr2[k];
    	                
    	                if(p < page2){
    	                    tag = 1;
    	                    break;
    	                }
    	                else{
    	                    str += arr2[k] + " ";
    	                    k++;
    	                }
		            }
	            }
		    }
		    
		    if(tag == 1){
		        System.out.println("-1");
		        continue;
		    }
		    else{
		        System.out.println(str);
		    }
		}
	}
}