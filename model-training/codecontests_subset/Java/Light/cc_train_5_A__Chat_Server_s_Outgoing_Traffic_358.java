import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String a;
		int sum = 0;
		int cUsers = 0;
		while (sc.hasNextLine()) {
			try {
				a = sc.nextLine();
				if(a.charAt(0) == '+')
				{
					cUsers++;
				}
				else if(a.charAt(0) == '-')
				{
					cUsers--;
				}
				else {
					sum += (a.length() - a.indexOf(':')-1)*cUsers;
				}
			} catch (Exception e) {
				System.out.println(sum);
				System.exit(0);
			}
		}

		sc.close();

		System.out.println(sum);
	}

}
