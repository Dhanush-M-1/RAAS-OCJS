import java.util.Scanner;

public class EC38_2
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int A[] = new int[n];

        int max_front = 0;
        int min_back = 0; int flag = 0;

        for (int i = 0; i < n; i++)
        {
            A[i] = in.nextInt();

            if(A[i] <= 500000)
            {
                max_front = A[i] - 1;
            }
            else if(A[i] > 500000 && flag == 0)
            {
                min_back = 1000000 - A[i];
                flag = 1;
            }
        }

        System.out.println(Math.max(max_front, min_back));
    }
}
