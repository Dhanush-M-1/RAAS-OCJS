import java.util.*;
import java.math.*;
public class Sol {
      public static void main(String[] args) {
    	  Scanner ip=new Scanner(System.in);
    	  int n=ip.nextInt();
    	  int arr[]=new int[n];
    	  int oddC=0;
    	  int evenC=0;
    	  for(int i=0;i<n;i++) {
    		  arr[i]=ip.nextInt();
    		  if(arr[i]%2==0) {
    			  evenC++;  
    		  }else {
    			  oddC++;
    		  }
    	  }
    	  int evenA[]=new int[evenC];
    	  int oddA[]=new int[oddC];
    	  int j=0;
    	  int k=0;
    	  for(int i=0;i<n;i++) {
    		  if(arr[i]%2==0) {
    			  evenA[j]=arr[i];
    			  j++;
    		  }else {
    			  oddA[k]=arr[i];
    			  k++;
    		  }
    	  }
    	  if(Math.abs(oddC-evenC)<=1) {
    		  System.out.println(0);
    	  }else {
    		  Arrays.sort(oddA);
    		  Arrays.sort(evenA);
    		  if(oddA.length>evenA.length) {
    			  int sum=0;
    			  for(int m=0;m<oddA.length-evenA.length-1;m++) {
    				  sum+=oddA[m];
    			  }
    			  System.out.println(sum);
    		  }else {
    			  int sum=0;
    			  for(int m=0;m<evenA.length-oddA.length-1;m++) {
    				  sum+=evenA[m];
    			  }
    			  System.out.println(sum);
    		  }
    		  
    	  }
      }
}