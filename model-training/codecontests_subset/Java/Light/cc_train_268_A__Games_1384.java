import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P268A_Games {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// begin reading inputs
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader reader = new BufferedReader(isr);

			// reading inputs
			int nTeams = Integer.parseInt(reader.readLine());
			int[] homeUniforms = new int[nTeams];
			int[] awayUniforms = new int[nTeams];

			for (int i = 0; i < nTeams; i++) {
				String[] line = reader.readLine().split(" ");
				homeUniforms[i] = Integer.parseInt(line[0]);
				awayUniforms[i] = Integer.parseInt(line[1]);
			}

			reader.close();
			isr.close();
			// end reading inputs

			int count = 0;

			for (int i = 0; i < nTeams - 1; i++) {
				for (int j = i + 1; j < awayUniforms.length; j++) {
					if (homeUniforms[i] == awayUniforms[j]) {
						count++;
					}

					if (homeUniforms[j] == awayUniforms[i]) {
						count++;
					}
				}
			}

			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
