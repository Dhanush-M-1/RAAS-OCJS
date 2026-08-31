import java.util.Scanner;

public class Two_Grams {

	public static void main(String[] args) {

		Scanner scan =  new Scanner(System.in);

		int n = scan.nextInt();
		scan.nextLine();
		String s = scan.nextLine();
		int fx = -1;
		int max = 0;

		for(int i = 0; i < n-1; i++){

			String sub = "" + s.charAt(i) + s.charAt(i+1);
			int count = 1;

			for (int j = i+1; j < n-1; j++) {

				String temp = "" + s.charAt(j) + s.charAt(j+1);

				if(sub.equals(temp)){
					count++;
				}
			}

			if(count > max){
				max = count;
				fx = i;
			}

		}

		String res = "" + s.charAt(fx) + s.charAt(fx+1);
		System.out.println(res);
	}

}
