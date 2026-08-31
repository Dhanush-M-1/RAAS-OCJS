import java.util.Scanner;

public class A1043
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int opponentVotes = 0;
        int max = Integer.MIN_VALUE;
        int[] votes = new int[n];
        for (int i = 0; i < n; i++)
        {

            votes[i] = scanner.nextInt();
            if(votes[i] > max)
                max = votes[i];
            opponentVotes += votes[i];
        }
        int myMax = max;

        while(func(myMax, votes) <= opponentVotes)
            myMax++;
        System.out.println(myMax);


    }

    private static int func(int myMax, int[] votes)
    {
        int  sum = 0;
        for (int vote : votes)
        {
            sum = sum + myMax - vote;
        }
        return sum;
    }
}
