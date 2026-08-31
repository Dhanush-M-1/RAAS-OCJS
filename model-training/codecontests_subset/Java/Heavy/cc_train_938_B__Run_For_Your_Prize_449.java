import java.util.*;

public class CodeForces {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] prizes = new int[n];
        for(int i = 0; i < n; i++)
        {
        	prizes[i] = s.nextInt();
        }

        int friend1 = 1;
        int friend2 = 1000000;

        int friend1_pos = -1;
        int friend2_pos = n;

        int time1 = 0;
        int time2 = 0;

        while(true)
        {
        	if(prizes[friend1_pos + 1] > 500000)
        	{
        		time2 = time2 + friend2 - prizes[friend1_pos + 1];
        		break;
        	}
        	else
        	{
        		time1 = time1 + prizes[friend1_pos + 1] - friend1;
        		friend1_pos++;
        		friend1 = prizes[friend1_pos];
        	}
        	if(prizes[friend2_pos - 1] <= 500000)
        	{
        		time1 = time1 + prizes[friend2_pos - 1] - friend1;
        		break;
        	}
        	else
        	{
        		time2 = time2 + friend2 - prizes[friend2_pos - 1];
        		friend2_pos--;
        		friend2 = prizes[friend2_pos];
        	}
        }
        System.out.println((time1 + time2 + Math.abs(time1 - time2))/2);
    }
}
