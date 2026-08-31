import java.util.*;
import java.io.*;
public class MisterBAndBookReading {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int c = Integer.parseInt(st.nextToken());
		int vo = Integer.parseInt(st.nextToken());
		int mp = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		ArrayList<Integer> pages = new ArrayList<>();
		ArrayList<Integer> pageNo = new ArrayList<>();
		
		pages.add(vo);
		pageNo.add(vo);
		
		if(pageNo.get(0)>=c) {
			System.out.println(1);
			System.exit(0);
		}
		
		for(int i =1; ; i++) {
			if(vo+(i*a) <= mp) {
				pages.add(vo+(i*a));
				
			}
			else {
				pages.add(mp);
			}
			pageNo.add(pageNo.get(i-1)+pages.get(i)-l);
			
			if(pageNo.get(i)>=c) {
				System.out.println(pageNo.size());
				System.exit(0);
			}
			
		}
		
		
	}

}