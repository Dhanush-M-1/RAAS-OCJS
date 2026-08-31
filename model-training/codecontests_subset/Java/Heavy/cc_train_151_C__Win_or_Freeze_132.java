import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Vector;


public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		String line=in.readLine();
		long ff=System.currentTimeMillis();
		double n=Double.parseDouble(line);
		BigInteger biN=new BigInteger(line);
		if(n==1 || biN.isProbablePrime(50)){
			out.println("1");
			out.println("0");
		}
		else{
			Vector<Integer> simple=new Vector<Integer>();
			simple.add(2);
			int size=(int) Math.round(Math.sqrt(n));
			boolean[] simpleBadCash=new boolean[size];
			for(int i=4; i<size; i+=2){
				simpleBadCash[i]=true;
			}
			for(int i=3; i<size; i+=2){
				if(simpleBadCash[i]) continue;
				simple.add(i);
				for(int z=i; z<size; z+=i){
					simpleBadCash[z]=true;
				}
			}
			int smplCount=0;
			Vector<BigInteger> vals=new Vector<BigInteger>();
			for(int i=0; i<simple.size(); i++){
				if(smplCount>=3) break;
				double curNum=n/simple.elementAt(i);
				while(Math.round(curNum)==curNum) {
					smplCount++;
					n=curNum;
					curNum=n/simple.elementAt(i);
					vals.add(new BigInteger(String.valueOf(simple.elementAt(i))));
				}
			}
			if(smplCount>=3 || (smplCount==2 && new BigInteger(String.valueOf((long)n)).isProbablePrime(50))){
	            out.println("1");               
	            out.println(vals.elementAt(0).multiply(vals.elementAt(1)));
	        }
	        else {
	            out.println("2");
	
	        }
		}
		out.close();
	}

}
