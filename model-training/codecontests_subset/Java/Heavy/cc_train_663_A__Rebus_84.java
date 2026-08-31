import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rebus {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(
				System.in)));
		
		String str = in.nextLine();
		List<Character> operations = new ArrayList<Character>();
		int n = 0;
		int plusCnt = 1;
		int minusCnt = 0;
		for (int i=0; i<str.length(); i+=2) {
			char ch = str.charAt(i);
			if (ch == '+') {
				operations.add(ch);
				plusCnt++;
			} else if (ch == '-') {
				operations.add(ch);
				minusCnt++;
			} else if (ch == '=') {
				n = Integer.parseInt(str.substring(i+2));
				break;
			}
		}
		
		boolean isPossible = false;
		String result = "";
		int max = plusCnt * n - minusCnt;
		int min = plusCnt - minusCnt * n;
		if (n > max || n < min) {
			// impossible
		} else if (plusCnt - minusCnt == n) {
			isPossible = true;
			result = str.replace("?", "1");
		} else if (plusCnt - minusCnt < n) {
			int[] plusNum = new int[plusCnt];
			int numToAdd = n - plusCnt + minusCnt;
			for (int i=0; i<plusCnt; i++) {
				plusNum[i] = 1;
				if (numToAdd >= n-1) {
					plusNum[i] += n-1;
					numToAdd -= n-1;
				} else if (numToAdd > 0) {
					plusNum[i] += numToAdd;
					numToAdd = 0;
				}
			}
			if (numToAdd == 0) {
				isPossible = true;
				result += plusNum[0];
				int cur = 1;
				for (int i=0; i<operations.size(); i++) {
					if (operations.get(i) == '-') {
						result += " - 1";
					} else {
						result += " + " + plusNum[cur];
						cur++;
					}
				}
				result += " = " + n;
			}
		} else {
			int[] minusNum = new int[minusCnt];
			int numToSub = plusCnt - minusCnt - n;
			for (int i=0; i<minusCnt; i++) {
				minusNum[i] = 1;
				if (numToSub >= n-1) {
					minusNum[i] += n-1;
					numToSub -= n-1;
				} else if (numToSub > 0) {
					minusNum[i] += numToSub;
					numToSub = 0;
				}
			}
			if (numToSub == 0) {
				isPossible = true;
				result += 1;
				int cur = 0;
				for (int i=0; i<operations.size(); i++) {
					if (operations.get(i) == '+') {
						result += " + 1";
					} else {
						result += " - " + minusNum[cur];
						cur++;
					}
				}
				result += " = " + n;
			}
		}
		
		if (isPossible) {
			System.out.println("Possible");
			System.out.println(result);
		} else {
			System.out.println("Impossible");
		}
	}
}