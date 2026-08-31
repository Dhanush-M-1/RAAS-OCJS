import java.util.Scanner;
import java.util.Arrays;
public class MyClass {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while(t-->0)
      {
          int count = 0;
          int n = sc.nextInt();
          if(n==1){
              System.out.println("0");
          }
          
          else if(n%6==0)
          {
              while(n%6==0)
              {
                  n=n/6;
                  count++;
              }
              while(n%3==0)
              {
                  n=n/3;
                  count=count+2;
              }
              if(n==1)
              {
                  System.out.println(count);
              }
              else
              {
                  System.out.println("-1");
              }
          }
           else if(n%3!=0)
           {
                System.out.println("-1");
          }
          else if(n%3==0)
          {
              while(n%3==0)
              {
                  n=n/3;
                  count=count+2;
              }
              if(n==1)
              {
                  System.out.println(count);
              }
              else
              {
                  System.out.println("-1");
              }
              
          }
      }
    }
}