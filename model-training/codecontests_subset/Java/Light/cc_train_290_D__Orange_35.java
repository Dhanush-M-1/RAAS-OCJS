import java.util.Scanner;


public class fourth {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String line= sc.next();
		int number = sc.nextInt();
		String response = "";
		line = line.toLowerCase();
		for(int i=0;i<line.length();i++)
		{
			if(line.charAt(i)-'a'<number)
			{
				response = response + (""+line.charAt(i)).toUpperCase();
			}
			else response = response + ""+line.charAt(i);
		}
		System.out.println(response);
	}

}
