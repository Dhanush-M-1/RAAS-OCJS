import java.util.Scanner;
public class Wizard {
   public static void main(String[] args)
   {
       Scanner input=new Scanner(System.in);
       int n=input.nextInt();
       int x=input.nextInt();
       int y=input.nextInt();
       int p;
       p=(int)Math.ceil(y*n*0.01)-x;
       if(p>=0)
       System.out.println(p);
       else
           System.out.println("0");
       input.close();
   }
}