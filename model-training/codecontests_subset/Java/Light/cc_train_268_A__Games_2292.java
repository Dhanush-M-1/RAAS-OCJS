import java.util.Scanner;

public class Games {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		TeamC[] t = new TeamC[scan.nextInt()];
		for(int i = 0; i < t.length; i++) {
			t[i] = new TeamC();
			t[i].h = scan.nextInt();
			t[i].a =scan.nextInt();
		}
		int n =0;
		for(int i = 0; i < t.length-1; i++) {
			for(int j = i+1; j< t.length; j++) {
				if(t[i].h == t[j].a) n++;
				if(t[j].h == t[i].a) n++;
			}
		}
		System.out.println(n);
		scan.close();
	}

}
class TeamC{
	int h;// home clothes
	int a;// away \\
}