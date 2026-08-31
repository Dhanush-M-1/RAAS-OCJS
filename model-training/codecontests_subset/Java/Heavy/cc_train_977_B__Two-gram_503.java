
import java.util.Scanner;

public class B977 {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        String input=sc.next();
        int length=0;
        String inputr = null;
        for (int i=0;i<input.length()-1;i++)
        {
            int occ=0;
            for (int j=0;j<input.length()-1;j++)
            {
                if (input.charAt(j)==input.charAt(i) && input.charAt(j+1)==input.charAt(i+1))

                {occ++;
                }

            }
            if (occ>length)
            
            {
                length=occ;
                inputr=input.charAt(i)+""+input.charAt(i+1);
            }
        }
        System.out.println(inputr);
    }
}
