import java.util.*;

public class a
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(Math.min(n/11, count8(in.next())));
        in.close();
    }
    
    public static int count8(String s)
    {
        if (s.indexOf("8") == -1)
            return 0;
        return 1+count8(s.substring(s.indexOf("8")+1));
    }
}