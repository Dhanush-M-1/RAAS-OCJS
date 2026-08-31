import java.util.Scanner;
import java.util.Arrays;
import java.lang.String;
import java.math.BigInteger;


  
public class JavaApplication1 {

//    static int myfunction(int a){
//      return result;
//    }


    public static void main(String[] args) {
  
        
        Scanner sc = new Scanner(System.in);
        
        String A = sc.nextLine();
        String B = sc.nextLine();
        String C = sc.nextLine();
        
        int LA = A.length();
        
        int[] AC = new int[27];
        int[] BC = new int[27];
        int[] CC = new int[27];
        
        
        for(int i = 0; i < A.length(); i++)
        {
           AC[Character.getNumericValue(A.charAt(i)) - 9]++;
        }
        
        for(int i = 0; i < B.length(); i++)
        {
           BC[Character.getNumericValue(B.charAt(i)) - 9]++;
        }
        
        for(int i = 0; i < C.length(); i++)
        {
           CC[Character.getNumericValue(C.charAt(i)) - 9]++;
        }
        
        int minn = A.length() + 11;
        for(int i = 1; i <= 26; i++)
        {
          if((AC[i] == 0)&&(BC[i]!= 0))
          {
            minn = 0;
            break;
          }
          if((AC[i] != 0)&&(BC[i] != 0))
          {
            minn = Math.min(minn, AC[i]/BC[i]);
          }
        }
        
        int Bx = minn;
        
        for(int i = 1; i <= 26; i++)
        {
           AC[i] = AC[i] - BC[i]*Bx;
        }
        
        
        // loop for second string
        
        minn = A.length() + 11;
        for(int i = 1; i <= 26; i++)
        {
          if((AC[i] == 0)&&(CC[i]!= 0))
          {
            minn = 0;
            break;
          }
          if((AC[i] != 0)&&(CC[i] != 0))
          {
            minn = Math.min(minn, AC[i]/CC[i]);
          }
        }
        
        int Cx = minn;
        
        for(int i = 1; i <= 26; i++)
        {
           AC[i] = AC[i] - CC[i]*Cx;
        }
        
//        System.out.println(Bx);
 //       System.out.println(Cx);

        while(Bx != 0)
        {
          for(int i = 1; i <= 26; i++)
          {
            AC[i] += BC[i];
          }
          
          minn = A.length() + 11;
          for(int i = 1; i <= 26; i++)
          {
            if((AC[i] == 0)&&(CC[i]!= 0))
            {
              minn = 0;

              break;
            }
            if((AC[i] != 0)&&(CC[i] != 0))
            {
              minn = Math.min(minn, AC[i]/CC[i]);
            }
          }
        
          int NCx = minn;
        
          if(NCx == 0)
          {
            for(int i = 1; i <= 26; i++)
            {
              AC[i] -= BC[i];
            }
            break;
          }
        
          Cx += NCx;
          Bx--;
          for(int i = 1; i <= 26; i++)
          {
             AC[i] = AC[i] - CC[i]*NCx;
          }
        }
        
        // fcking w result
        
        for(int i = 0; i < Bx; i++)
        {
          System.out.print(B);  
        }
        for(int i = 0; i < Cx; i++)
        {
          System.out.print(C);  
        }
        for(int i = 1; i < 27; i++)
        {
          for(int j = 0; j < AC[i]; j++)
          {
            System.out.print((char)(96 + i));
          }
        }
        
        
        
        

 
//        int n = sc.nextInt(); 
//        int[] x = new int[n+1];

//        var = myfunction(123,234);
     
//        System.out.println(maxx);

   }
}