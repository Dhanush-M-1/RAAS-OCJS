

import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int n=sc.nextInt();
	    int ans1=0;
	    int ans2=0;
	    int ans3=0;
	    int ans4=0;
	    
	    for(long j=1;j<=n;j++) {
	    	 String s=sc.next();
	    	 
	    	 if(s.equals("AC"))ans1++;
	    	 else if(s.equals("WA"))ans2++;
	    	 else if(s.equals("TLE"))ans3++;
	    	 else if(s.equals("RE"))ans4++;
	    	 
	     }
	    
	    
	   System.out.println("AC x "+ans1);
	   System.out.println("WA x "+ans2);
	   System.out.println("TLE x "+ans3);
	   System.out.println("RE x "+ans4);
	}
}

