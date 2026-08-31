import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int q = reader.nextInt();
		int [][] tab = new int[q][3];
		int [] result = new int[q];
		String s = "";
		for(int i = 0; i< q; i++)			
			{for(int j = 0 ; j < 3 ; j++)
				tab[i][j] = reader.nextInt();	
			if(tab[i][2] > tab[i][1] || tab[i][2] < tab[i][0]) {
				result[i] = tab[i][2];
			}
			else
				{
					result[i] = ((tab[i][1]/tab[i][2])+1)*tab[i][2];
				}
			s += result[i]+ "\n";
			}
		System.out.println(s);
reader.close();
	}

}