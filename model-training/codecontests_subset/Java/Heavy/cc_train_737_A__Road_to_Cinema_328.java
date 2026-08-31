import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class elmovies {
	public static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static PrintWriter pw = new PrintWriter(System.out);
	final static boolean debugmode = true;
	public static int k = 7; // for 10^9 + k mods.
	public static long STMOD = 1000000000 + k; // 10^9 + k
	public static void main(String[] args) throws IOException{
		int ncars = getInt();
		int stations = getInt();
		int epoint = getInt();
		int timeCut = getInt();
		int[][] cars = new int[ncars][2];
		for(int i = 0;i<ncars;i++){
			cars[i][1] = getInt();
			cars[i][0] = getInt();
		}
		int[] restpoints = new int[stations+2];
		for(int i = 0;i<stations;i++){
			restpoints[i+1] = getInt();
		}
		restpoints[stations+1] = epoint;
		restpoints[0] = 0;
		Arrays.sort(restpoints);
		Arrays.sort(cars, new java.util.Comparator<int[]>(){

			@Override
			public int compare(int[] arg0, int[] arg1) {
				// TODO Auto-generated method stub
				return arg0[0]-arg1[0];
			}});
		if(!testcar(cars[cars.length-1][0], restpoints, timeCut)){
			submit(-1,true);
			return;
		}
		int hi = cars.length-1;
		int lo = -1;
		while(Math.abs(hi-lo) > 1){
			int mid = hi + lo;
			mid /= 2;
			if(testcar(cars[mid][0], restpoints, timeCut)){
				//System.out.println(Arrays.toString(cars[mid])+" worked!");
				hi = mid;
			}
			else{
				//System.out.println(Arrays.toString(cars[mid])+" failed.!");

				lo = mid;
			}
		}
		int ccost = cars[hi][1];
		for(int i = hi;i<cars.length;i++){
			ccost = Math.min(ccost, cars[i][1]);
		}
		submit(ccost,true);
	}
	public static boolean testcar(double mxf,int[] rp,double limit){
		//System.out.println(Arrays.toString(rp));
		double ttime = 0;
		for(int dest = 1;dest < rp.length;dest++){
			double v = time(rp[dest]-rp[dest-1],mxf);
			if(v == -1){
				return false; // unreachable.
			}
			ttime += v;
			if(ttime > limit){
				return false;
			}
		}
		//System.out.println("Made with: "+mxf+" in "+ttime);
		return true;
	}
	public static double time(double distance, double fuels){
		if(distance <= fuels/2){
			return distance;
		}
		else if(distance > fuels){
			return -1;
		}
		double k = 2*distance - fuels;
		return distance + k;
	}
	public static void setInputFile(String fn) throws IOException{
		sc = new BufferedReader(new FileReader(fn));
	}
	public static void setOutputFile(String fn) throws IOException{
		 pw = new PrintWriter(new BufferedWriter(new FileWriter(fn)));
	}
	public static int GCD(int a, int b) {
		   if (b==0) return a;
		   return GCD(b,a%b);
	}
	public static double log(int k, int v){
		return Math.log(k)/Math.log(v);
	}
	
	public static long longpower(int a,int b){
		long[] vals = new long[(int) (log(b,2)+2)];
		vals[0] = a;
		vals[1] = a*a;
		for(int i = 1;i<vals.length;i++){
			vals[i] = vals[i-1]*vals[i-1];
		}
		long ans = 1;
		int cindex = 0;
		while(b != 0){
			if (b % 2 == 1){
				ans *= vals[cindex];
			}
			cindex += 1;
			b /= 2;
		}
		return ans;
		
		
	}
	
	public static void debug(String toPrint){
		if(!debugmode) {return;}
		pw.println("[DEBUG]: "+toPrint);
	}
	public static void  submit(int[] k,boolean close){
		pw.println(Arrays.toString(k));
		if(close){
			pw.close();
		}
	}
	public static void submit(int p,boolean close){
		pw.println(Integer.toString(p));
		if(close){
			pw.close();
		}
	}
	public static void submit(String k,boolean close){
		pw.println(k);
		if(close){
			pw.close();
		}
	}
	public static void submit(double u,boolean close){
		pw.println(Double.toString(u));
		if(close){
			pw.close();
		}
	}
	public static void submit(long lng,boolean close){
		pw.println(Long.toString(lng));
		if(close){
			pw.close();
		}
		
	}
	public static void submit(){
		pw.close();
	}
	public static int getInt() throws IOException{
		if (st != null && st.hasMoreTokens()){
			return Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(sc.readLine());
		return Integer.parseInt(st.nextToken());
	}
	public static long getLong() throws IOException{
		if (st != null && st.hasMoreTokens()){
			return Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(sc.readLine());
		return Long.parseLong(st.nextToken());
	}
	public static double getDouble()throws IOException{
		if (st != null && st.hasMoreTokens()){
			return Double.parseDouble(st.nextToken());
		}
		st = new StringTokenizer(sc.readLine());
		return Double.parseDouble(st.nextToken());
	}
	public static String getString()throws IOException{
		if(st != null && st.hasMoreTokens()){
			return st.nextToken();
		}
		st = new StringTokenizer(sc.readLine());
		return st.nextToken();
	}
	public static String getLine() throws IOException{
		return sc.readLine();
	}
	public static int[][] readMatrix(int lines,int cols) throws IOException{
		int[][] matrr = new int[lines][cols];
		for (int i = 0;i < lines;i++){
			for(int j = 0;j < cols;j++){
				matrr[i][j] = getInt();
			}
		}
		return matrr;
	}
	public static int[] readArray(int lines) throws IOException{
		int[] ar = new int[lines];		
		for (int i = 0;i<lines;i++) ar[i] =getInt();
		return ar;
	}
	
}
