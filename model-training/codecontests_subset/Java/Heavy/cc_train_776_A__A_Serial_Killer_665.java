

import java.util.Scanner;

public class serialKiller {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String[] pDead = new String[2];
		for(int i=0;i<2;i++)
			pDead[i]=input.next();
	
		int days = input.nextInt();
		String[] dead = new String[days*2];
		for(int i=0;i<days*2;i++)
		{
			dead[i]=input.next();
		}
		for(int i=0;i<2;i++)
			System.out.print(pDead[i]+" ");
		System.out.println();
		for(int i=0;i<dead.length;i++)
		{
			
				for(int j=0;j<2;j++)
				{
					if(pDead[j].equals(dead[i]))
						pDead[j]=dead[i+1];
				}
				System.out.print(pDead[0]+" "+pDead[1]);
				System.out.println();
			i++;
		}
		
		
		

	}

}
