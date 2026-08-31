import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO ?????????????????????????????????????????????
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for(int i = 0; i < n; i++){
			String people = br.readLine();

			String input = br.readLine();

			System.out.println(solve(people, input));
		}
	}

	static String solve(String people, String str){
		char[] pArray = people.toCharArray();
		int n = pArray.length;

		String result = str;
		for(int i = n - 1; i >= 0; i--){
//			System.out.println("next "+pArray[i]);
			switch (pArray[i]) {
			case 'J' :
				result = decodeJ(result);
				break;
			case 'C' :
				result = decodeC(result);
				break;
			case 'E' :
				result = decodeE(result);
				break;
			case 'A' :
				result = decodeA(result);
				break;
			case 'P' :
				result = decodeP(result);
				break;
			case 'M' :
				result = decodeM(result);
				break;
			}
		}

		return result;
	}

	static String decodeJ(String str){
//		System.out.println("Decode J");
		StringBuffer sb = new StringBuffer();
		sb.append(str.charAt(str.length() - 1));
		sb.append(str.substring(0, str.length() - 1));

//		System.out.println("J "+sb);
		return sb.toString();
	}

	static String decodeC(String str){
		StringBuffer sb = new StringBuffer();
		sb.append(str.substring(1));
		sb.append(str.charAt(0));

//		System.out.println("C "+sb);
		return sb.toString();
	}

	static String decodeE(String str){
		StringBuffer sb = new StringBuffer();
		int len = str.length();

		sb.append(str.substring((len - 1)/2 + 1));
		if(len % 2 == 1){
			sb.append(str.charAt(len/2));
		}
		sb.append(str.substring(0, len/2));

//		System.out.println("E "+sb);
		return sb.toString();
	}

	static String decodeA(String str){
		StringBuffer sb = new StringBuffer(str);

//		System.out.println("A "+sb);
		return sb.reverse().toString();
	}

	static String decodeP(String str){
		char[] cArray = str.toCharArray();
		for(int i = 0; i < str.length(); i++){
			if(cArray[i] == '0'){
				cArray[i] = '9';
			}
			else if(Character.isDigit(cArray[i])){
				cArray[i]--;
			}
		}
//		System.out.println("P "+ new String(cArray));
		return new String(cArray);
	}

	static String decodeM(String str){
		char[] cArray = str.toCharArray();
		for(int i = 0; i < str.length(); i++){
			if(cArray[i] == '9'){
				cArray[i] = '0';
			}
			else if(Character.isDigit(cArray[i])){
				cArray[i]++;
			}
		}
//		System.out.println("M "+ new String(cArray));

		return new String(cArray);
	}
}