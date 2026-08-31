
import java.util.Scanner;

public class ques2  {
    public static void main(String[] args) {
      Scanner scan=new Scanner(System.in);
      String s="";
      int u=0,n=0;
      if (scan.hasNext())
          n=scan.nextInt();
      if (scan.hasNext())
          s=scan.next();
      for (int i=0;i<n-1;i++){
          if (s.charAt(i)>s.charAt(i+1)){
              System.out.println("YES");
              System.out.println((i+1)+" "+(i+2));
              u=1;
              break;
          }
      }
      if (u==0){
          System.out.println("NO");
      }

    }
}
