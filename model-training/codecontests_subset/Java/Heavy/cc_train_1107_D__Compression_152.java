
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class D1107 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new FileReader("F:/books/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer n = Integer.parseInt(br.readLine());
		
		Map<Character,String> mp = new HashMap<Character,String>();
		for(int i=0;i<16;i++) {
			mp.put(Integer.toHexString(i).toUpperCase().charAt(0), 
					String.format("%4s",Integer.toBinaryString(i))
					.replace(' ', '0') );
		}
		List<String> mat = new ArrayList<String>();
		for(int i=0;i<n;i++) {
//			mat.add(br.readLine());
			StringBuilder sb = new StringBuilder("");
			StringBuilder bsb = new StringBuilder(br.readLine());
			for(int j=0;j<bsb.length();j++) {
				sb.append(mp.get(bsb.charAt(j)));
			}
			mat.add(sb.toString());
		}
		int min = mat.stream()
				.map((x)->calcMin(new StringBuilder(x)))
				.reduce(Math::min)
				.get();
		int gcd = min;
		if(gcd!=1)
		for(int i=0;i<n;i+=gcd) {
			min = Math.min(min, calc2(mat,i,mp));
			if(min==1) break;
		}
		System.out.println(min);
	}

	private static int calc2(List<String> mat, int id, Map<Character, String> mp) {
		StringBuilder sb = 
					mat.stream()
		.map((x)->Character.toString(x.charAt(id)))
		.map((x)->new StringBuilder(x))
		.reduce(new StringBuilder(""),(x,y)->x.append(y));
		return calcMin(sb);
	}
	
	private static int calcMin(StringBuilder sb) {
		int idx = -1;
		int ret = sb.length();
		while(idx<sb.length()) {
			char c = sb.charAt((idx==-1)?0:idx);
			while(++idx<sb.length() && sb.charAt(idx)==c) ;
			ret = gcd(ret,idx);
			if(ret==1) return ret;
		}

//		System.out.println(sb.toString()+ " " +ret);
		return ret;
	}
	
	private static int gcd(int x,int y) {
		if(y>x) return gcd(y,x);
		if(y==0) return x;
		return gcd(y,x%y);
	}

}
