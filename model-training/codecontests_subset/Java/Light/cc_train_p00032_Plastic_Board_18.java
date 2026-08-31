import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	int recangCount = 0;
	int rhomCount = 0;
	while (sc.hasNextLine()) {
	    int a;
	    int b;
	    int c;
	    String[] input = sc.nextLine().split(",");
	    if ("".equals(input[0])) {
		break;
	    }

	    a = Integer.parseInt(input[0]);
	    b = Integer.parseInt(input[1]);
	    c = Integer.parseInt(input[2]);

	    if (isRectangle(a, b, c)) {
		recangCount++;
	    }

	    if (isRhombus(a, b)) {
		rhomCount++;
	    }
	}

	System.out.println(recangCount);
	System.out.println(rhomCount);
    }

    private static boolean isRectangle(int a, int b, int c) {
	if (a == b) {
	    return false;
	}

	if (a * a + b * b != c * c) {
	    return false;
	}

	return true;
    }

    private static boolean isRhombus(int a, int b) {
	if (a != b) {
	    return false;
	}
	return true;
    }
}