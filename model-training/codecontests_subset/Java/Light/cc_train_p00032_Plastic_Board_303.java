import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	private	static	BufferedReader	br    = null;

	static {
		br  = new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]	aParam  = null;
		int		nSquare = 0;
		int		nDia    = 0;

		while((aParam = parseParam()) != null) {
			if (aParam[0] != 0 && aParam[1] != 0 && aParam[2] != 0) {
				if (aParam[0] == aParam[1]) {
					nDia++;
				}

				if ((aParam[0] * aParam[0] + aParam[1] * aParam[1]) == aParam[2] * aParam[2]) {
					nSquare++;
				}
			}
		}

		System.out.println(nSquare);
		System.out.println(nDia);
	}

	private static int[] parseParam() {
		int[]	aParam = null;
		String	strIn  = null;

		if ((strIn = parseStdin()) != null) {
			String[]	aN = strIn.split(",");
			aParam = new int[3];
			aParam[0] = Integer.parseInt(aN[0]);
			aParam[1] = Integer.parseInt(aN[1]);
			aParam[2] = Integer.parseInt(aN[2]);
		}
		
		return aParam;
	}

	private static String parseStdin() {
		String	strNum = null;

		try {
			String line = br.readLine();
			if (line != null) {
				if (!line.isEmpty()) {
					strNum = line;
				}
			}
		}
		catch (IOException e) {}

		return strNum;
	}
}