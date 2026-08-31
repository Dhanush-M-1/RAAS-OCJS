
import java.util.*;
public class FinalTest {

   
    public static void main(String[] args) {
          Scanner input=new Scanner(System.in);
          int n=input.nextInt();
          int k=input.nextInt();
          int max =0;
          for(int i=1;i<=n;i++)
          {
              int x = input.nextInt();
              if(k%x==0)
              {
                  max =Math.max(max,x);
              }
              
              
          }
             System.out.println(k/max);
              
           
    
    
    }
}
