import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final double A = sc.nextDouble();
        final double B = sc.nextDouble();
        final double C = sc.nextDouble();

        double[] D = new double[N];

        for(int i = 0; i < N; ++i)
        {
            D[i] = sc.nextDouble();
        }
        Arrays.sort(D);

        double k = C;
        double d = A;
        for(int i = D.length - 1; 0 <= i; --i)
        {
            if(k / d < (k + D[i]) / (d + B))
            {
                k += D[i];
                d += B;
            }
        }

        System.out.println((int)(k / d));
    }
}