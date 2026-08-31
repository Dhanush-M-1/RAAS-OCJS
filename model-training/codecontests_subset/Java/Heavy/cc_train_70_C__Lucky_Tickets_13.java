
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		HashMap<Fraction,Integer> m1 = new HashMap<Fraction,Integer>();
		HashMap<Fraction,Integer> m2 = new HashMap<Fraction,Integer>();
		String[] input = br.readLine().split(" ");
		int maxX = Integer.parseInt(input[0]);
		int maxY = Integer.parseInt(input[1]);
		int w = Integer.parseInt(input[2]);
		int lucky = 0;
		Fraction f;
		for(int x = 1;x<=maxX;x++){
			f = new Fraction(x,rev(x));
			m1.put(f, get(m1,f)+1);
		}
		int y = 0;
		while (lucky<w && y<maxY){
			y++;
			f = new Fraction(rev(y),y);
			m2.put(f,get(m2,f)+1);
			lucky += get(m1,f);
		}
		if (lucky<w) System.out.println(-1);
		else{
			int ans1 = maxX;
			int ans2 = y;
			long mul = maxX*y;
			while(maxX>1){
				f = new Fraction(maxX,rev(maxX));
				lucky-=get(m2,f);
				m1.put(f,get(m1,f)-1);
				while (lucky<w && y<maxY){
					y++;
					f = new Fraction(rev(y),y);
					m2.put(f,get(m2,f)+1);
					lucky += get(m1,f);
				}
				long comp = y*(maxX-1);
				if (comp<mul && lucky>=w){
					mul = comp;
					ans1 = maxX-1;
					ans2 = y;
				}
				maxX--;
			}
			System.out.println(ans1+" "+ans2);
		}
	}
	public static int rev (int num){
		int reversedNum = 0;
		while (num != 0) {
		    reversedNum = reversedNum * 10 + num % 10;
		    num = num / 10;
		}
		return reversedNum;
	}
	public static int get (HashMap<Fraction,Integer> m, Fraction key){
		if (m.containsKey(key)) return m.get(key);
		else return 0;
	}
}
class Fraction{
	int num,den;
	Fraction(int a, int b){
		int gcd = gcd(a,b);
		num = a/gcd;
		den = b/gcd;
	}
	int gcd(int a, int b){
		int r;
		int max = Math.max(a,b);
		int min = Math.min(a,b);
		while(min>0) {
	        r = max % min;
	        max = min;
	        min = r;
	    }
	    return max;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + den;
		result = prime * result + num;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fraction other = (Fraction) obj;
		if (den != other.den)
			return false;
		if (num != other.num)
			return false;
		return true;
	}
}