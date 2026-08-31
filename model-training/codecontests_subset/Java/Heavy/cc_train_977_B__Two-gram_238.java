import java.util.Scanner;
public class A{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String stringEnter = sc.next();
		
		String[] arrStr = new String[n - 1];
		int[] arrNum = new int[n - 1];
		
		for(int counter = 0; counter < n - 1; counter++) {
			arrNum[counter] = 0;
		}
		
		int realPos = 0;
		for(int counter = 0; counter < n - 1; counter++) {
			String current = "";
			current += stringEnter.charAt(counter) + "" + stringEnter.charAt(counter + 1);
			boolean flag = true;
			for(int innerCounter = 0; innerCounter < n - 1; innerCounter++) {
				if(arrStr[innerCounter] != null && arrStr[innerCounter].equals(current)) {
					arrNum[innerCounter]++;
					flag = false;
					break;
				}
			}
			if(flag) {
				arrStr[realPos] = current;
				arrNum[realPos] += 1;
				realPos++;
			}
			
		}
		int max = 0;
		for(int counter = 1; counter < n - 1; counter++) {
			if(arrNum[counter] > arrNum[max]) {
				max = counter;
			}
		}
		
		System.out.println(arrStr[max]);
		
	}

}
