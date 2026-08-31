
import java.util.Scanner;

public class TwoGram {
public static void main(String[] args) {
   Scanner sc=new Scanner (System.in);
   int l=sc.nextInt();
   String st=sc.next();
   int n=st.length();
   int x=0;
        int max=0;
      String rc=new String();
   for(int i=0;i<n-1;i++)
   {String st1=st.substring(i, i+2);
   for(int j=i;j<n-1;j++)
       {
          if(st.charAt(j)==st1.charAt(0)&&st.charAt(j+1)==st1.charAt(1))
          {
              ++x;
          }
       }
       if(x>max)
       {
           max=x;
           x=0;
           rc=st1;
           
       }
       x=0;
   }
   
    System.out.println(rc);
}
    
}
