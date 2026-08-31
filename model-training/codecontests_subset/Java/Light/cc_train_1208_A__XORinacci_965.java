import java.util.*;
 public class Ja{

 	 public static void main(String args[] ) throws Exception {

 	 	Scanner s=new Scanner(System.in);
 	 	int t=s.nextInt();
 	 	while(t-->0){
 	 		int r[]=new int[3];
 	 		r[0]=s.nextInt();
 	 		r[1]=s.nextInt();
 	 		int n=s.nextInt();

 	 		r[2]=r[0]^r[1];

 	 		//int n1=0;
 	 		
 	 			System.out.println(r[n%3]);
 	 	}
 	 	}
 }