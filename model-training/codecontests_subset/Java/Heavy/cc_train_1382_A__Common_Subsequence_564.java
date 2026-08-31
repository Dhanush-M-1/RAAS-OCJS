import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Scanner in= new Scanner(System.in);
     int t=in.nextInt();
     for(int i=0;i<t;i++)
     {
    	 int n1=in.nextInt();
    	 int n2=in.nextInt();
    	 int arr1[]=new int[n1];
    	 int arr2[]=new int[n2];
    	 int arr3[]=new int [10000];
    	 for(int j=0;j<n1;j++)
    	 {
    		 arr1[j]=in.nextInt();
    	 }
    	 for(int j=0;j<n2;j++)
    	 {
    		 arr2[j]=in.nextInt();
    	 }
    	 int h=0;
    	 for(int j=0;j<n1;j++)
    	 {
    		 for(int k=0;k<n2;k++)
    		 {
    			 if(arr1[j]==arr2[k])
    			 {
    			   arr3[h]=arr2[k];
    			   h++;
    			 }
    		 }
    	 }
    	
    	 if(h>=1)
    	 {
    		 System.out.println("YES");
    		 System.out.print(1+" ");
             
    		 
    			 System.out.print(arr3[0]);
    		 
    		  System.out.println();
    	 }
        
    	 else
    	 {
    		 System.out.println("NO");
    	 }
    	 
     }
	}

}