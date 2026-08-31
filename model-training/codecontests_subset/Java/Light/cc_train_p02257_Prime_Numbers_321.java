import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//prime numbers
		Scanner in = new Scanner(System.in);
	      int prime =0;
	      int n = in.nextInt();
	      int[] array = new int[n];
	      for(int i =0;i<n;i++){
	         array[i]= in.nextInt();
	      }
	      for(int j = 0; j<n;j++){
	    	  Boolean primeN = true;
	         for(int x = 2;x<Math.sqrt(array[j]+1);x++) {
	        	 if(array[j]%x==0) {
	        		 primeN = false;
	        	 }
	         }
	         if(primeN==true) {
	        	 prime+=1;
	         }
	         
	      }
	      System.out.println(prime);
}}
