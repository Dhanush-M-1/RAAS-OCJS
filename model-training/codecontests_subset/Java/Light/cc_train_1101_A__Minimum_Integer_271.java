import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   Scanner sc=new Scanner(System.in);
   int q=sc.nextInt();
   int l,r,d,s=1;
   for(int i=0;i<q;i++)
   {
	   l=sc.nextInt();
	   r=sc.nextInt();
	   d=sc.nextInt();
	    if(l>d)
	      System.out.println(d);
	    else
	    System.out.println((r/d+1)*d);
   }
	}

}

   	  		 			   		  	 				