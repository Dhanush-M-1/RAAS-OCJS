import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class min {
public static int minSec(int n, String s){
	int min=0;
	
	ArrayList<String>Locations = new ArrayList<String>(Arrays.asList(s.split(" ")));
	for(int i =0;i<Locations.size();i++){
		int newvar;
		if(Integer.parseInt(Locations.get(i))<=500000){
			newvar =Integer.parseInt(Locations.get(i))-1;
		}else{
			newvar =1000000-Integer.parseInt(Locations.get(i));
		}
		if(newvar>min){
			min=newvar;
		}
	}
	return min;
}
public static void main (String[]args) throws IOException{
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	String S = sc.nextLine();
	
	
	
	
	System.out.print(minSec(N,S));
}
static class Scanner {
	StringTokenizer st;
	BufferedReader br;

	Scanner(String file) throws FileNotFoundException {
		br = new BufferedReader(new FileReader(file)); }
	public Scanner(InputStream system) {
		br = new BufferedReader(new InputStreamReader(system)); }
	public String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken(); }
	public String nextLine() throws IOException {
		return br.readLine(); }
	public int nextInt() throws IOException {
		return Integer.parseInt(next()); }
	public double nextDouble() throws IOException {
		return Double.parseDouble(next()); }
	public char nextChar() throws IOException {
		return next().charAt(0); }
	public Long nextLong() throws IOException {
		return Long.parseLong(next()); }
	public boolean ready() throws IOException {
		return br.ready(); }
	public void waitForInput() {
		for (long i = 0; i < 3e9; i++); }
}

}