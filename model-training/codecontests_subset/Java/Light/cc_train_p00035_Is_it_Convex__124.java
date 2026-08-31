import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while((input = br.readLine()) != null) {
			String[] p = input.split(",");
			float[] pf = new float[p.length];
			for (int i = 0; i < p.length; i++) {
				pf[i] = Float.parseFloat(p[i]);
				// System.out.printf("pf[%d] = %f\n", i, pf[i]);
			}
			float v1x = pf[2] - pf[0];
			float v1y = pf[3] - pf[1];
			float v2x = pf[4] - pf[2];
			float v2y = pf[5] - pf[3];
			float v3x = pf[6] - pf[4];
			float v3y = pf[7] - pf[5];
			float v4x = pf[0] - pf[6];
			float v4y = pf[1] - pf[7];

			float ext1 = exterior(v1x, v1y, v2x, v2y);
			float ext2 = exterior(v2x, v2y, v3x, v3y);
			float ext3 = exterior(v3x, v3y, v4x, v4y);
			float ext4 = exterior(v4x, v4y, v1x, v1y);

			boolean[] sign = new boolean[4];

			sign[0] = (ext1 > 0);
			sign[1] = (ext2 > 0);
			sign[2] = (ext3 > 0);
			sign[3] = (ext4 > 0);

			boolean result = true;
			for (int i = 0; i < 4; i++) {
				if (sign[i] != sign[0]) {
					result = false;
					break;
				}
			}
			if (result) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	public static float exterior(float x1, float y1, float x2, float y2) {
		float ext =  x1 * y2 - y1 * x2;
		// System.out.println(ext);
		return ext;
	}
}