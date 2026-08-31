import java.util.Scanner;


public class Bank {

    public static void main(String[] args) {
       String s;
       int n;
       Scanner in = new Scanner(System.in);
       n=in.nextInt();
       s=in.next();
       int ok=1;
       for(int i=0;i<s.length()&&ok==1;i++)
       {
           if(s.charAt(i)=='.') continue;
           for(int j=1;j<s.length()&&ok==1;j++)
           {
               int f=0;
               for(int k=0,c=0;c<5;k+=j,c++)
               {
                   if(i+k>=s.length()) break;
                   if(s.charAt(i+k)=='*')
                   {
                       f++;
                       
                   }
               }
               if(f==5)
               {
                   ok=0;
                  // System.out.println(i+" "+j);
                   System.out.println("yes\n");
                   break;
               }
           }
       }
       if(ok==1)
           System.out.println("no\n");
    
    }

}
