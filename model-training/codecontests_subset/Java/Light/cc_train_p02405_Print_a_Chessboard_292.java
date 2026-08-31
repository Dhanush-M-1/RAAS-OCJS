import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder out = new StringBuilder();
		while (true) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			if (H == 0 && W == 0)
				break;
			for (int h = 0; h < H; ++h) {
				for (int w = 0; w < W; ++w)
					if ((h + w) % 2 == 0)
						out.append("#");
					else
						out.append(".");
				out.append("\n");
			}
			out.append("\n");
		}
		System.out.print(out);
	}
}
