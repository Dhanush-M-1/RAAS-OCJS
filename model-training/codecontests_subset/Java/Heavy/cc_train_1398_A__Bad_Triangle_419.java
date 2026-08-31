import java.util.*;
public class solution{
    private int t,n;
    private int[] A = new int[50005];
    public void Process()
    {
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        for (int ii = 1; ii <= t; ii++)
        {
            n = scanner.nextInt();
            for (int i = 0; i < n; i++)
            {
                A[i] = scanner.nextInt();
            }
            if (A[0] + A[1] <= A[n-1])
            {
                System.out.println("1 2 "+n);
            }
            else System.out.println("-1");
        }
        
    }
    public static void main(String args[])
    {
        solution s = new solution();
        s.Process();
    }
}