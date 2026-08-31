import java.util.*;

public class minstep
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        if (e-s < 2)
            System.out.print(s);
        else
            System.out.print("2");
    }
}