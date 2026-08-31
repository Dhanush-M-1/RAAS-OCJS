import java.util.Scanner;

public class Bark{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		String input=scan.next();
		int n=scan.nextInt();
		String[] words = new String[n];
		
		for(int i=0;i<n;i++){
			words[i]=scan.next();
		}for(int k=0;k<n;k++){
			for(int j=0;j<n;j++){
				String cat=words[k]+words[j];
				if(cat.contains(input)){
					System.out.println("YES");
					return;
				}
			}
		}
		System.out.println("NO");
	}
}