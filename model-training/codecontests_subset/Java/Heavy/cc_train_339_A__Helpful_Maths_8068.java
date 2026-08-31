import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class T
{
    public static void main(String[] args)
    {
        new T().run();
    }

    public int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        while (a != b)
        {
            if (a > b)
                a -= b;
            else
                b -= a;
        }
        return a;
    }

    public void run()
    {
        final Scanner sc = new Scanner(System.in);

        String s = sc.next();

        String strs = Arrays.stream(s.split("\\+")).map(Integer::parseInt).sorted().map(String::valueOf).collect(Collectors.joining("+"));

        System.out.println(strs);
    }
}
