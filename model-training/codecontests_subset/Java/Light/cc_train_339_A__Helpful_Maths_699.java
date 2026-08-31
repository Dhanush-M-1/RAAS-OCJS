import java.io.*;
import java.util.*;
public class Hello
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int N = str.length();
        int one = 0;
        int two = 0;
        int tri = 0;
        int count = 0;
        for(int i=0;i<N;i++)
        {
            if(str.charAt(i)!='+')
            {
                char ch = str.charAt(i);
                if(ch=='1')
                    one++;
                else if(ch=='2')
                    two++;
                else
                    tri++;
                count++;
            }
        }
        int index=0;
        while(one-->0)
        {
            System.out.print("1");
            index++;
            if(index!=count)
                System.out.print("+");
        }
        while(two-->0)
        {
            System.out.print("2");
            index++;
            if(index!=count)
                System.out.print("+");
        }
        while(tri-->0)
        {
            System.out.print("3");
            index++;
            if(index!=count)
                System.out.print("+");
        }
    }
}