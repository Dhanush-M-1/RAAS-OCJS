import java.util.*;
public class Main {
 public static void main(String args[])
 {
	// System.out.println(1);
	 Scanner input=new Scanner(System.in);
	 int n=input.nextInt();
	 input.hasNextLine();
	 String s=input.next();
	 int len=s.length();
	 int num0=0;int num1=0;
	 for(int i=0;i<n;i++)
	 {
		 if(s.charAt(i)=='0')num0++;
		 else num1++;
	 }
	 if(num0!=num1)
	 {
		 System.out.println(1);
		 System.out.println(s);
		 
	 }
	 else
	 {
		 System.out.println(2);
		 System.out.print(s.charAt(0)+" "+s.substring(1, len));
	 }
 }
}

					 	  						  		     	     	