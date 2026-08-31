import java.util.*;
import java.io.*;
import java.lang.*;
public class cf593 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
		 int answer1=0;
		 int answer2=0;
		 int nb=b-c/2;
		 if(c/2<=b) {answer1+=3*(c/2);
		   //System.out.println("c/2"+answer1);
		 }
		 else {
			 answer1+=3*b;
			// System.out.println("3b"+answer1);
		 }
		 
		 if(nb>=2) {
			 if(nb/2<=a) {answer1+=3*(nb/2);
			// System.out.println("nb/2"+answer1);
			 }
		 else {
			 answer1+=3*a;
			// System.out.println("3a"+answer1);
		 }
			 }
		 
	  int nnb=b-2*a;
	  if(2*a<=b) {
		  answer2+=3*a;
	  }else {
		  answer2+=3*(b/2);
	  }
	  if(nnb>=2) {
		  
		  if(nnb*2<=c) {
			  answer2+=nnb*3;
		  }else {
			  answer2+=3*(c/2);
		  }
		  
	  }
	  
	  int answer=Math.max(answer1, answer2);
	 // System.out.println(answer1+" -- "+answer2);
	  System.out.println(answer);
			
			
		}

	}

}
