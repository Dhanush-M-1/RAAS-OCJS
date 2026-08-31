//package er85;

import java.util.Scanner;

public class first {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();

			int play_prev = 0;
			int clear_prev = 0;
			boolean possible = true;
			for(int i=0;i<n;i++)
			{
				int play = sc.nextInt();
				int clear = sc.nextInt();
				if(clear>play)
				{
					possible = false;
				}
				if(play<play_prev || clear<clear_prev)
				{
					possible = false;
				}
				if(play-play_prev < clear-clear_prev)
				{
					possible = false;
				}
				play_prev = play;
				clear_prev = clear;
				
			}
			if(possible== false)
			{
				System.out.println("NO");
			}
			else
			{
				System.out.println("YES");
			}
		}

	}

}
