import java.util.Scanner;

public class ClassTester {
	
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args)  {
		int amountTeams = in.nextInt();
		int homeForm[] = new int[amountTeams];
		int exitForm[] = new int[amountTeams];
		int counter = 0;
			for(int i = 0;i < amountTeams;i++) {
				homeForm[i] = in.nextInt();
				exitForm[i] = in.nextInt();
			}
			
			for(int i = 0;i < amountTeams;i++) 
				for(int j = 0;j < amountTeams;j++) {
					if(homeForm[i] == exitForm[j]) 
						counter++;
				}
		System.out.println(counter);
	}
}