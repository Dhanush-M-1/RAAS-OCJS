

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in) ;
		int n = input.nextInt() ;
		int teams[][] = new int[n][2] ;
		int count = 0 ;
		for (int i = 0 ; i < n ; i ++)
		{
			for (int j = 0 ; j < 2 ; j++)
			{
				teams[i][j] = input.nextInt() ;
			}
		}
		for (int i = 0 ; i < n ; i ++)
		{
			for (int j = 0 ; j < n ; j ++)
			{
				if (teams[i][0] == teams[j][1])
				{
					count ++ ;
				}
			}
		}
		System.out.println(count);
	}

}
