import java.util.Arrays;
import java.util.Scanner;

public class Watermelon {
    static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int n=sc.nextInt();
	    int c=sc.nextInt();
	    int[] arr=new int[n];
	    int[] marr=new int[n-1];
	    for(int i=0;i<n;i++)
	    	arr[i]=sc.nextInt();
	   for(int i=0;i<marr.length;i++)
	   {
		   if(i!=arr.length-1)
			   marr[i]=(arr[i]-arr[i+1]);
	   }
	    sc.close();
	    Arrays.sort(marr);
       // display(marr);
        if((marr[marr.length-1]-c)>0)
        System.out.println(marr[marr.length-1]-c);
        else
        	System.out.println(0);
	}
	     
	 static void display(int[][] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++)
			System.out.print(arr[i][j]+" ");
			System.out.println();
		}	
		System.out.println();
	  }
	 static void display(int[] arr){
			for(int i=0;i<arr.length;i++){
				System.out.print(arr[i]+" ");
			}	
			System.out.println();
		
		  }
	 static String str(char[] carr){
		 String str="";
		 for(int i=0;i<carr.length;i++){
			    str=str+carr[i];
			}
		 return str;
	 }
	 
	}


