import java.util.Scanner;
public class prob{
         public static void main(String[]args){
		 Scanner input = new Scanner(System.in);
		 int a,b;
		 int temp;
		 
		  a = input.nextInt();
		  b = input.nextInt();
		  int p1 = 1;
		  int p2 = 1;
		  int count1 = 0;
		  int count2 = 0;
		  if(a > b){
		    temp = a;
			a = b;
			b = temp;
		  }
		  
		  while(a < b){
		  a++;
		  count1 += p1;
		  p1++;
		  int k = b - 1;
		  if(k >= a)
		  {
		  b--;
		  count2 += p2;
		  p2++;
		  }
		      
			  
			  
		  }
		  System.out.printf("%d",count1 + count2);
		 }
}