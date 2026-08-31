import java.util.Scanner;

//Videotape
public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int h = sc.nextInt();
			int m = sc.nextInt();
			int s = sc.nextInt();
			if(h==-1)break;
			int x = h*3600+m*60+s;
			int r = 7200 - x;
			int r3 = 7200*3-x*3;
			if(r<0)r=0;
			if(r3<0)r3=0;
			int h1 = r/3600;
			r%=3600;
			int m1 = r/60;
			r%=60;
			int h2 = r3/3600;
			r3%=3600;
			int m2 = r3/60;
			r3%=60;
			System.out.printf("%02d:%02d:%02d\n", h1, m1, r);
			System.out.printf("%02d:%02d:%02d\n", h2, m2, r3);
		}
	}
}