import java.util.Scanner;

public class Main {

	// 点A(a,b)と点B(c,d)を結ぶ直線と点C(e,f)と点D(g,h)を結ぶ線分が交差するか判定
	public static boolean isIntersect (double a, double b, double c, double d,
										double e, double f, double g, double h) {
		double ta = (f - b) * (a - c) + (a - e) * (b - d);
		double tb = (h - b) * (a - c) + (a - g) * (b - d);
		return ta * tb < 0;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (sc.hasNextLine()) {
			double[] nums = new double[8];
			String[] str = sc.nextLine().split(",");
			for (int i = 0; i < nums.length; i++)
				nums[i] = Double.parseDouble(str[i]);
			boolean b = isIntersect(nums[0],nums[1],nums[4],nums[5],nums[2],nums[3],nums[6],nums[7]) &&
						isIntersect(nums[2],nums[3],nums[6],nums[7],nums[0],nums[1],nums[4],nums[5]);
			System.out.println(b ? "YES" : "NO");
		}

	}

}