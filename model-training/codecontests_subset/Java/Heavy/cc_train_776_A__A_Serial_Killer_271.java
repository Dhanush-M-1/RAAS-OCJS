import java.io.*;
import java.lang.Math.*;

public final class SerialKiller{

	public static void main(String args[]) throws Exception{

		String ini[] = Br.getString().split(" ");
		int N = Br.getInt();

		String list[] = new String[2];
		println(ini[0] + " " + ini[1]);
		for(int n=0; n<N; n++){
			list = Br.getString().split(" ");
			if(list[0].equals(ini[0]))
				ini[0] = list[1];
			else
				ini[1] = list[1];

			println(ini[0] + " " + ini[1]);
		}
	}

	// class for Reader
	static class Br {

		final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		static int getInt() throws IOException{
			return Integer.parseInt(br.readLine());
		}

		static long getLong() throws IOException{
			return Long.parseLong(br.readLine());
		}

		static double getDouble() throws IOException{
			return Double.parseDouble(br.readLine());
		}

		static int[] getIntA() throws IOException{
			String temp[] = br.readLine().split(" ");
			int l = temp.length;

			int a[] = new int[l];

			for(int i=0; i<l; i++){
				a[i] = Integer.parseInt(temp[i]);
			}

			return a;
		}

		static int[] getIntA(int l) throws IOException{
			String temp[] = br.readLine().split(" ");
			int a[] = new int[l];

			for(int i=0; i<l; i++){
				a[i] = Integer.parseInt(temp[i]);
			}

			return a;
		}

		static long[] getLongA(int l) throws IOException{
			String temp[] = br.readLine().split(" ");
			long a[] = new long[l];

			for(int i=0; i<l; i++){
				a[i] = Long.parseLong(temp[i]);
			}

			return a;
		}

		static String getString() throws IOException{
			return br.readLine();
		}

	}

	// class for MaTh libraries
	static class Mt{
		static double precision = 0.00001;

		static double sqrt(double a){
			return newton_raphson(a, a/2);
		}

		static double newton_raphson(double a, double guess){
			if(guess*guess - a <= precision)
				return guess;

			guess = guess - (guess * guess - a)/ (2 * guess);
			return newton_raphson(a, guess);
		}

		static long modPow(long a, long x, long p){

			long ans = 1;
			while(x > 0){
				if(x %2 !=0){
					ans = (ans*a)%p;
				}
				a = (a*a)%p;
				x/=2;
			}

			return (ans%p);
		}
	}

	static<T> void print(T s){
		System.out.print(s);
	}

	static<T> void println(T s){
		System.out.println(s);
	}
}