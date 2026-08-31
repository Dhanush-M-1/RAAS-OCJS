import java.awt.Point;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;

public class Solution implements Runnable {

	BufferedReader in;
	PrintWriter out;
	StringTokenizer tok = new StringTokenizer("");

	public static void main(String[] args) {
		new Thread(null, new Solution(), "", 256 * (1L << 20)).start();
	}

	public void run() {
		try {
			long t1 = System.currentTimeMillis();
			if (System.getProperty("ONLINE_JUDGE") != null) {
				in = new BufferedReader(new InputStreamReader(System.in));
				out = new PrintWriter(System.out);
			} else {
				in = new BufferedReader(new FileReader("input.txt"));
				out = new PrintWriter("output.txt");
			}
			Locale.setDefault(Locale.US);
			solve();
			in.close();
			out.close();
			long t2 = System.currentTimeMillis();
			//System.err.println("Time = " + (t2 - t1));
		} catch (Throwable t) {
			t.printStackTrace(System.err);
			System.exit(-1);
		}
	}

	String readString() throws IOException {
		while (!tok.hasMoreTokens()) {
			tok = new StringTokenizer(in.readLine());
		}
		return tok.nextToken();
	}

	int readInt() throws IOException {
		return Integer.parseInt(readString());
	}

	long readLong() throws IOException {
		return Long.parseLong(readString());
	}

	double readDouble() throws IOException {
		return Double.parseDouble(readString());
	}

	// solution

	void solve() throws IOException {
		int libros=readInt();
		int dias=readInt();
		int pesos[]=new int[libros+1];
		int array[]=new int[dias];
		pesos[0]=0;
		
		int index=1;
		for(;index<libros+1;index++){
			pesos[index]=readInt();
		}
		index=0;
		for(;index<dias;index++){
			array[index]=readInt();
		}
		index=0;
		int peso=0;
		
		for(index=0;index<dias;index++){
			
			//recorremos todos los anteriores y sumamos sus valores hasta que nos salgamos del array por <0 o encontremos el mismo numero que tenemos en el indice actual
			int posLoc=index-1;
			for(;posLoc>=0;posLoc--){
				
				if(array[posLoc]==array[index]){
					//quitamos el numero en el que nos hemos quedado y dejamos de sumar
					array[posLoc]=0;
					break;
				}else{
					peso+=pesos[array[posLoc]];
				}
				
			}
			
			
			
		}
		out.print(peso);
		
	}

}