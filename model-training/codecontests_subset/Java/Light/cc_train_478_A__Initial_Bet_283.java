import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
   Scanner sc=new Scanner(System.in);
   int a=sc.nextInt();
   int b=sc.nextInt();
   int c=sc.nextInt();
   int d=sc.nextInt();
   int e=sc.nextInt();
   if(a+b+c+d+e==0) System.out.println(-1);
   else if((a+b+c+d+e)%5==0) System.out.println((a+b+c+d+e)/5);
   else System.out.println(-1);
  }
}