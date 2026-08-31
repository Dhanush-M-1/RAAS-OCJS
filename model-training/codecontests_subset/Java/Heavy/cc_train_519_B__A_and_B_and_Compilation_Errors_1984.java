import java.io.*;
import java.util.*;

public class Div2_294B{
	public static void main(String[] args) throws IOException{
		BufferedInputStream bis = new BufferedInputStream(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(bis));
		StringTokenizer st;
		int size = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> occ1 = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> occ2 = new HashMap<Integer, Integer>();
		Set<Integer>keys = null;
		st = new StringTokenizer(br.readLine());
		for(int j = 0;j < size;j++) {
			int error = Integer.parseInt(st.nextToken());
			int val = 0;
			if(occ1.containsKey(error))
				val = occ1.get(error);
			occ1.put(error, val+1);
		}
		for(int i = 1;i < 3;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j < size-i;j++) {
				int error = Integer.parseInt(st.nextToken());
				int val = 0;
				if(occ2.containsKey(error))
					val = occ2.get(error);
				occ2.put(error, val+1);
			}
			keys = occ1.keySet();
			for(int num:keys) {
				int val0 = occ1.get(num);
				int val = occ2.containsKey(num)?occ2.get(num):0;
				if(val!=val0)
					System.out.println(num);
			}
			occ1 = occ2;
			occ2 = new HashMap<Integer, Integer>();
		}
	}
}
