import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Z519BHASH {

	public static void main(String[] args) throws NumberFormatException, IOException { 
		Z519BHASH z = new Z519BHASH();
		String[] niz = z.glavnaMetoda();
		ispis(niz);
	}
	
	public String[] glavnaMetoda() throws NumberFormatException, IOException { 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		String[] nizIspis = new String[2];
		
		HashMap<String, Integer> mapa = new HashMap<String, Integer>();
		HashMap<String, Integer> mapa2 = new HashMap<String, Integer>();
		HashMap<String, Integer> mapa3 = new HashMap<String, Integer>();
		String[] linija = br.readLine().split(" ");
		String[] linija2 = br.readLine().split(" ");
		String[] linija3 = br.readLine().split(" ");
		
		mapa = dodajUMapu(mapa, linija);
		mapa2 = dodajUMapu(mapa2, linija2);
		mapa3 = dodajUMapu(mapa3, linija3);
		
		nizIspis[0] = ispitajMape(mapa, mapa2);
		nizIspis[1] = ispitajMape(mapa2, mapa3);
		return nizIspis;
	}
	
	public String toString(char[] linija) { 
		String rez ="";
		for(int i=0; i<linija.length; i++) {
			rez += linija[i] + "";
		}
		return rez;
	}
	public static void ispis(String[] niz) { 
		for(int i=0; i<niz.length; i++) { 
			System.out.println(niz[i]);
		}
	}
	public HashMap<String, Integer> dodajUMapu(HashMap<String, Integer> mapa, String[] linija) {
		for(String c : linija)  {
			if(!mapa.containsKey(c)) {
				mapa.put(c, 1);
			}
			else { 
				mapa.put(c, mapa.get(c)+1);
			}
		}
		return mapa;
	}
	public String ispitajMape(HashMap<String, Integer> mapa1,HashMap<String, Integer> mapa2) {
		
		String c = " ";
		for (Map.Entry entry : mapa1.entrySet()) {
			if(mapa2.containsKey(entry.getKey())) {
				int value = mapa2.get(entry.getKey());
				if((int)entry.getValue() != value) {
					c = (String) entry.getKey();
				}
				else { 
					continue;
				}
			}
			else {
				c = (String) entry.getKey();
			}
		}
		return c;
	}
}
