import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class HapppyNumbers {
	public static class Numbers{
		public Numbers(int n, int a[]){
			this.next = n;
			this.values = a;
		}
		int next;
		int[] values;
	}
	public static TreeMap<Long, ArrayList<Numbers>> ways; 
	public static ArrayList<Long> parse(long value){
		if(value==0){
			ArrayList<Long> res = new ArrayList<Long>();
			for(int i=0;i<6;i++){
				res.add(0L);
			}
			return res;
		}
		long digit = value%10;
		for(Numbers v:ways.get(digit)){
			long newValue = (value - digit)/10 - v.next;
			if(newValue >= 0){
				ArrayList<Long> subres = parse(newValue);
				if(subres.size()!=0){
					ArrayList<Long> res = new ArrayList<Long>();
					for(int i=0;i<6;i++){
						res.add(subres.get(i)*10 + v.values[i]);
					}
					return res;
				}
			}
		}
		return new ArrayList<Long>();
	}
    public static void main(String[] args) throws IOException{
    	ways = new TreeMap<Long, ArrayList<Numbers>>();
    	for(int i4=0;i4<7;i4++){
    		for(int i7=0;i7<7-i4;i7++){
    			int i0=6-i7-i4;
    			int sum = i4*4+i7*7;
    			int val = sum%10;
    			int next = (sum-val)/10;
    			int a[] = new int[6];
    			for(int i=0;i<6;i++){
    				if(i<i7) a[i] = 7;
    				else if(i<i7+i4) a[i] = 4;
    				else a[i]= 0;
    			}
    			long value = val;
    			Numbers v = new Numbers(next, a);
    			if(!ways.containsKey(value)){
    				ways.put(value, new ArrayList<Numbers>());
    			}
    			ways.get(value).add(v);
    		}
    	}
    	BufferedReader reader = null;
    	try {
    		reader = new BufferedReader(new InputStreamReader(System.in));
    		int n = Integer.parseInt(reader.readLine());
			for(int i=0;i<n;i++){
				long value = Long.parseLong(reader.readLine());
				ArrayList<Long> result = parse(value);
				if(result.size()==0)
					System.out.println("-1");
				else{
					for(long dd:result){
						System.out.print(dd + " ");
					}
					System.out.println();
				}
			}
    	} finally {
    		if(reader != null)
			reader.close();
		}
	}
}
