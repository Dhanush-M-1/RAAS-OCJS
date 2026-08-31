import java.util.Scanner;

public class codeforces433A {
	
	static public void main(String[] args) {
		 Scanner scan = new Scanner(System.in);
	     int n =scan.nextInt();
	     int intArray[] = new int[n];
	     for(int i=0;i<n;i++) {
	    	 intArray[i] = scan.nextInt();
	     }
	     int p=0;
	     int q=0;
	     
	     //Each apple weights 100 grams or 200 grams
	     for(int i=0;i<n;i++) {
	    	 if(intArray[i]==100)
	    		 p++;   //the number of 100 apples
	    	 else
	    		 q++;   //the number of 200 apples		 
	     }
	     /***
	     if(q==0&&p%2==0)
	    	 System.out.println("YES");	     
	     else if(p==0&&q%2==0)
	    		 System.out.println("YES");
	     else if(p!=0&&q!=0&&p==2*q)
	    	 System.out.println("YES");
	     else
	    	 System.out.println("NO");***/
	     
	     System.out.println(p%2==0 && (q%2==0||q%2==1&&p>=2)?"YES":"NO");
	}

}
