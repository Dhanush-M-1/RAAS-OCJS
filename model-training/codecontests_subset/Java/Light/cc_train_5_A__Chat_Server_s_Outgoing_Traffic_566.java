import java.util.*;

public class Solution5A
{
    public static void main(String[] args)
    {
        Scanner inp = new Scanner(System.in);
        int count = 0, sum = 0;
        while(inp.hasNextLine())
        {
            String str = inp.nextLine();
            if(str.length() == 0) break;
            if(str.charAt(0) == '+') count++;
            else if(str.charAt(0) == '-') count--;
            else 
            {
                String[] s = str.split(":");
                if(s.length == 1) sum = sum;
                else sum += s[1].length() * count;
            }
        }
        System.out.print(sum);
    }
}