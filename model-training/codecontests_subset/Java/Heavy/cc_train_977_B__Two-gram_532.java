import java.io.*;
import java.util.*;

public class twogram {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner lect = new Scanner(System.in);

		HashMap<String, Integer> hm = new HashMap<String, Integer>();

		int n=lect.nextInt();
		lect.nextLine();
		String cad = lect.nextLine();
		for (int i = 0; i < cad.length() - 1; i++) {

			String act = (cad.charAt(i) + "") + (cad.charAt(i + 1) + "");

			if (hm.containsKey(act)) {
				hm.replace(act, hm.get(act) + 1);
			} else {
				hm.put(act, 1);
			}
		}
		
		String max="";
		int nMax=0;
		for(String k:hm.keySet()) {
			
			int act =hm.get(k);
			if(act>nMax) {
				nMax=act;
				max=k;
			}
				
			
			
		}
		System.out.println(max);

	}

}
