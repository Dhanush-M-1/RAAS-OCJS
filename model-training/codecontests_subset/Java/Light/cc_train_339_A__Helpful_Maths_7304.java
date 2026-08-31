import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       Scanner a = new Scanner(System.in);
       String str = a.nextLine();

       if(str.length()==1)
       System.out.print(str);
       else
       {
           String[] s = str.split("\\+");
           Arrays.sort(s);
           for(int i=0;i<s.length-1;i++)
           {
               System.out.print(s[i]+"+");
           }
           System.out.print(s[s.length-1]);
       }



    }
}