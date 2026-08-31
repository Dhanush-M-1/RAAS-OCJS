import java.util.Scanner;
public class CowsAndPokerGame {
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        int count=0, counti=0;
        int n=input.nextInt();
        String s=input.next();
        if(s.contains("I"))
        {
                    for(int i=0; i<s.length();i++)
            {
               if(s.substring(i,i+1).contains("I"))
                counti++;
            }
            if(counti>1)
                System.out.println(0);
            else
                System.out.println(1);
        }
        else
        {
            for(int i=0; i<=s.length()-1;i++)
            {
               if(s.substring(i,i+1).contains("A"))
                count++;
            }
            System.out.println(count);
        }
    }
}