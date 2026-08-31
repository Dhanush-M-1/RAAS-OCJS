import java.util.Scanner;

/**
 * Created by Kunaal on 10/21/17.
 */
public class Woodcutters {
	public static class Tree {
		int pos;
		int h;

		Tree(int p, int hh) {
			pos = p;
			h = hh;
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		if(n <= 2) {
			System.out.println(n);
			return;
		}

		Tree[] t = new Tree[n];

		for (int i = 0; i < n; i++) {
			t[i] = new Tree(scan.nextInt(), scan.nextInt());
		}

		int num = 2;
		for(int i = 1; i < n-1; i++) {
			if(t[i].pos - t[i].h > t[i-1].pos) {
				num++;
			} else if(t[i].pos + t[i].h < t[i+1].pos){
				t[i].pos += t[i].h;
				num++;
			}
		}
		System.out.println(num);
	}
}