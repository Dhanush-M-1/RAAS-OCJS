import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B {
	public static void main(String[] args) {
		BufferedReader buf = new BufferedReader(
				new InputStreamReader(System.in));
		String s = "";
		try {
			s = buf.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int[] pole = new int[s.length()];
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < pole.length; i++) {
			if (s.charAt(i) == '-')
				pole[i] = -1;
			else
				pole[i] = Integer.parseInt(s.charAt(i) + "");
		}
		for (int i = 0; i < pole.length - 9; i++) {
			if (pole[i + 2] == -1 && pole[i + 5] == -1 && pole[i] != -1
					&& pole[i + 1] != -1 && pole[i + 3] != -1
					&& pole[i + 4] != -1 && pole[i + 6] != -1
					&& pole[i + 7] != -1 && pole[i + 8] != -1
					&& pole[i + 9] != -1) {
				int mesiac = Integer.parseInt(pole[i + 3] + "" + pole[i + 4]);
				if (mesiac < 1 || mesiac > 12)
					continue;
				int rok = Integer.parseInt(pole[i + 6] + "" + pole[i + 7] + ""
						+ pole[i + 8] + "" + pole[i + 9]);
				if (rok < 2013 || rok > 2015)
					continue;
				int den = Integer.parseInt(pole[i] + "" + pole[i + 1]);
				if (den < 1 || den > 31)
					continue;
				if (mesiac == 2)
					if (den > 28)
						continue;
				if (!(mesiac == 1 || mesiac == 3 || mesiac == 5 || mesiac == 7
						|| mesiac == 8 || mesiac == 10 || mesiac == 12)) {
					if (den > 30)
						continue;
				}
				String datum = "";
				for (int j = 0; j < 10; j++) {
					if(pole[i+j]!=-1)
						datum += (pole[i + j]);
					else datum+="-";
				}
				list.add(datum);
			}
		}
		Collections.sort(list);
		String akt = -1 + "";
		int pocet = 0;
		int maxPocet = 0;
		String cislomax = -1 + "";
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(akt)) {
				pocet++;
			} else {
				if (pocet >= maxPocet) {
					maxPocet = pocet;
					cislomax = akt;
				}
				akt = list.get(i);
				pocet = 0;
			}
		}
		if (pocet >= maxPocet) {
			maxPocet = pocet;
			cislomax = akt;
		}

		String vyst = cislomax;
		if (!cislomax.equals(-1 + ""))
			System.out.println(vyst);
	}
}
