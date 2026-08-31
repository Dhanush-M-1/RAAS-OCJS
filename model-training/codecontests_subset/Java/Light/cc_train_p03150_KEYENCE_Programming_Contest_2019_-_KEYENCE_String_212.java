import java.util.Scanner;

public class Main {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String[] sArray = s.split("");
		String end = getEnd(sArray);
		if(s.endsWith(end)) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}

	private static String getEnd(String[] sArray) {
		String end = "keyence";
		if(!sArray[0].equals("k")) {
			return end;
		}
		end = end.substring(1);
		if(!sArray[1].equals("e")) {
			return end;
		}
		end = end.substring(1);
		if(!sArray[2].equals("y")) {
			return end;
		}
		end = end.substring(1);
		if(!sArray[3].equals("e")) {
			return end;
		}
		end = end.substring(1);
		if(!sArray[4].equals("n")) {
			return end;
		}
		end = end.substring(1);
		if(!sArray[5].equals("c")) {
			return end;
		}
		end = end.substring(1);
		if(!sArray[6].equals("e")) {
			return end;
		}
		end = end.substring(1);
		return end;
	}
}