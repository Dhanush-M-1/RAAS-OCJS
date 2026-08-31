import java.util.*;
public class Guru{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tc = scan.nextInt();
		while(tc>0){
			int a = scan.nextInt();
			int b = scan.nextInt();
			int n = scan.nextInt();
			switch(n%3){
				case 0:
					System.out.println(a);
					break;
				case 1:
					System.out.println(b);
					break;
				default:
					System.out.println(a^b);
			}
			tc--;
		}
	}

}