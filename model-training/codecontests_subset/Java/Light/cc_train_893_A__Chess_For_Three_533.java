import java.util.*;
public class ChessForThree
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int winner[] = new int[n];
        int loser[] = new int[n];
        int spectator[]= new int[n];
        boolean flag = true;
        int first = 1;
        for(int i=0; i<n; i++)
        {
            winner[i] = sc.nextInt();
        }
        spectator[0] = 3;
        loser[0] = winner[0]==1?2:1;
         for(int i=0; i<n-1; i++)
        {
            if(winner[i]!=winner[i+1])
            {
                loser[i+1] = winner [i];
                spectator[i+1] = loser [i];
            }
            else
            {
                
                spectator[i+1] = loser[i];
                loser[i+1] = spectator[i];
            }
            if((spectator[i+1]==winner[i+1])||(winner[0]==3))
            flag = false;
        }
    
        if(flag&&winner[0]!=3)
        System.out.println("YES");
        else
        System.out.println("NO");
    }
    
}