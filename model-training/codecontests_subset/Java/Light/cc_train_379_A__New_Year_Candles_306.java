
/* worrying about future ruins your present */


import java.util.Scanner;
public class Main {
   public static void main(String args[])
   {
	   Scanner sc= new Scanner(System.in);
	  int a ,b ,n ,r;
	  a=sc.nextInt();
	  b=sc.nextInt(); n=0;
	 for(int i=1;i<=a;i++){
		 n++;
		 if(i%b==0)
			 a++;
	 }
	   System.out.println(n);
	   
   }

}