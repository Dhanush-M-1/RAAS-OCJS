import java.util.Scanner;
public class Main{
   public static void main(String args[]){
       Scanner sc= new Scanner(System.in);
       int a,b,c;
       a=sc.nextInt();
       b=sc.nextInt();
       c=sc.nextInt();
       if(a<=b)System.out.println("0");
       else{
    	   if(((a-b)*c)%b==0)System.out.println(((a-b)*c/b));
    	   else System.out.println((a-b)*c/b+1);
       }
 }
}
  
