import java.util.Scanner;
import java.util.stream.IntStream;

public class ChessForThree
{
    public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int [] arr = new int [n];
        for(int i = 0; i < n; i++) arr [i] = input.nextInt();

        input.close();

        boolean status = true;
        int spectator = 3;

        for(int element: arr)
        {
            if(element == spectator)
                status = false;
            
            spectator = findLoser(element, spectator);    
        }
        
        if(status)
            System.out.println("YES");
        else
            System.out.println("NO");       
    }

    public static int findLoser(int winner, int spec)
    {
        return IntStream.rangeClosed(1, 3).filter(i -> i != winner && i != spec)
                        .findFirst().getAsInt();
    }
}