import java.util.Scanner;

public class _805A {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int firstNum = s.nextInt();
		int secondNum = s.nextInt();
		if (firstNum % 2 == 0 && secondNum % 2 == 0)
			System.out.print("2");
		if (firstNum % 2 != 0 && secondNum % 2 != 0 && firstNum != secondNum)
			System.out.print("2");
		if ((firstNum % 2 == 0 && secondNum % 2 != 0) || (firstNum % 2 != 0 && secondNum % 2 == 0))
			System.out.print("2");
		if (firstNum % 2 != 0 && secondNum % 2 != 0 && firstNum == secondNum)
			System.out.print(firstNum);
	}

}
