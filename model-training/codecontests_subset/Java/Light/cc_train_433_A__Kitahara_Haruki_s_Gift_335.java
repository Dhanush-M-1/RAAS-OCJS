import java.util.Scanner;
public class Main
{
	public static void main(String[] args) 
	{
		int[] a= new int[200]; 
		 Scanner s = new Scanner(System.in);
		 Integer n = s.nextInt();
		 int yi=0,er=0,sum=0;
		 
		 for(int i=0;i<n;i++)
		 {
			 a[i]= s.nextInt();
			 sum+=a[i];
			 if(a[i]==100)
				 yi++;
			 else
				 er++;
		 }
		 if(sum%2!=0)
		 {
			 System.out.print("NO");
		 }
		 else
		 {
			 if(er%2==1)
			 {
				 if(((yi-2)%2==0)&&yi>=2)
					 System.out.print("YES");
				 else
					 System.out.print("NO");
			 }
			 else
			 {
				 if(yi%2!=0)
					 System.out.print("NO");
				 else
					 System.out.print("YES");
			 }
		 }
	}

}

	   	      	 				 	  	 		 				