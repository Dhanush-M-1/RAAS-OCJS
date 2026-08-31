import java.util.Scanner;

public class Prob915A
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int answer = -1;

        int numBuckets = input.nextInt();

        int gLength = input.nextInt();

        for(int i = 0; i < numBuckets; i++)
        {
            int currentBucket = input.nextInt();

            if(gLength%currentBucket == 0 && currentBucket > answer)
            {
                answer = currentBucket;
            }
        }
        System.out.println(gLength/answer);
    }
}
