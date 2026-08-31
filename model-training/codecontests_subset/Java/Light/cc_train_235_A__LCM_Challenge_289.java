import java.util.*;


public class Solution {

	
public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
	 long n = sc.nextLong();
	 
	 
	 
	 
	 
	 
	 if(n<3) {
		 System.out.println(n);
	 }
	 else if(n==6) {
		System.out.println(60); 
	 }
	 else {
		 if(n%2==0) {
			 if(n%3==0) { System.out.println((n-2)*(n-1)*(n-3));}
			 
			 else { System.out.println(n*(n-1)*(n-3));}
			 
			}
		 else {
			 System.out.println(n*(n-1)*(n-2));
		 }
		 
	 }
	  
	  
    }
}

