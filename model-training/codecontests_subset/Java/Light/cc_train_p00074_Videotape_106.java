import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	private	static	BufferedReader br = null;

	static {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]	video = null;

		while ((video = parseVideo()) != null) {
			if (video[0] == -1 && video[1] == -1 && video[2] == -1) {
				break;
			}

			System.out.printf("%02d:%02d:%02d\n", video[0], video[1], video[2]);

			video[0] *= 3;
			video[1] *= 3;
			video[2] *= 3;
			video[1] += video[2] / 60; 
			video[2]  = video[2] % 60; 
			video[0] += video[1] / 60; 
			video[1]  = video[1] % 60; 

			System.out.printf("%02d:%02d:%02d\n", video[0], video[1], video[2]);
		}
	}

	private static int[] parseVideo() {
		int[]		video = null;
		String[]	split = null;
		String		strIn = null;

		if ((strIn = parseStdin()) != null) {
			if (!strIn.equals("-1 -1 -1")) {
				split    = strIn.split(" ");
				video    = new int[3];
				video[0] = 2 - Integer.parseInt(split[0]); 
				video[1] = 0 - Integer.parseInt(split[1]); 
				video[2] = 0 - Integer.parseInt(split[2]); 
	
				if (video[2] < 0) {
					video[1]--;
					video[2] += 60;
				}
	
				if (video[1] < 0) {
					video[0]--;
					video[1] += 60;
				}
			}
		}
		
		return video;
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