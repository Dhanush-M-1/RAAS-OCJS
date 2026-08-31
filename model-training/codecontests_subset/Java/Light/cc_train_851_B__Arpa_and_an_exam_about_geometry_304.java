import java.util.*;
public class Main 
{
    public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long ax = input.nextInt();
		long ay = input.nextInt();

		long bx = input.nextInt();
		long by = input.nextInt();

		long cx = input.nextInt();
		long cy = input.nextInt();

		if (((ax - bx) * (ax - bx) + (ay - by) * (ay - by) != (cx - bx)
				* (cx - bx) + (cy - by) * (cy - by))
				|| ((ax + cx) / 2.0 == bx && (ay + cy) / 2.0 == by))
			System.out.println("No");
		else
			System.out.println("Yes");
	}

}