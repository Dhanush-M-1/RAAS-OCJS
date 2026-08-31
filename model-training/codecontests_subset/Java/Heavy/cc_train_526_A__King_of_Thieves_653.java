import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KingOfThieves {

	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("/home/bala/temp/1/A-sample.in"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		reader.readLine();
		char[] in = reader.readLine().toCharArray();
		int firstPlatformLoc = 0;
		while (firstPlatformLoc < in.length && in[firstPlatformLoc] == '.')
			firstPlatformLoc++;
		boolean isPossible = false;
		int jumpLength = 0, startLoc = 0, curLoc = 0;
		for (jumpLength = 1; jumpLength < in.length && !isPossible; jumpLength++) {
			for (startLoc = firstPlatformLoc; startLoc < in.length; startLoc++) {
				int successiveCount = 0;
				for (curLoc = startLoc; curLoc < in.length; curLoc += jumpLength) {
					if (in[curLoc] == '*')
						successiveCount++;
					else {
						successiveCount = 0;
						break;
					}
					if (successiveCount == 5) {
						isPossible = true;
						break;
					}
				}
			}
		}
		if (isPossible) {
			System.out.println("yes");
//			System.out.println(jumpLength + "\t" + startLoc + "\t" + curLoc);
		} else
			System.out.println("no");
		// reader.close();
	}
}
