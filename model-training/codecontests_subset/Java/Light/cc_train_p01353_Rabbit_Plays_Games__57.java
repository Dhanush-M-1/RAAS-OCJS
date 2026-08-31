import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	public static class Monstar implements Comparable<Monstar>{
		long atk, times;

		public Monstar(long atk, long times) {
			super();
			this.atk = atk;
			this.times = times;
		}

		@Override
		public int compareTo(Monstar o) {
			final long own = this.atk * o.times;
			final long oth = o.atk * this.times;
			
			if(own < oth){
				return 1;
			}else if(own > oth){
				return -1;
			}else{
				return 0;
			}
		}

		@Override
		public String toString() {
			return "Monstar [atk=" + atk + ", times=" + times + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		final int n = sc.nextInt();
		
		final int hp  = sc.nextInt();
		final int atk = sc.nextInt();
		final int dif = sc.nextInt();
		final int spd = sc.nextInt();
		
		long cur_hp = hp;
		//Monstar[] monstars = new Monstar[n];
		ArrayList<Monstar> monstars = new ArrayList<Monstar>();
		
		boolean end = false;
		for(int i = 0; i < n; i++){
			final int h = sc.nextInt();
			final int a = sc.nextInt();
			final int d = sc.nextInt();
			final int s = sc.nextInt();
			
			final int ene_atk = Math.max(a - dif, 0);
			if(spd < s){
				cur_hp -= ene_atk;
			}
			
			final int own_atk = Math.max(atk - d, 0);
			if(own_atk <= 0 && !(ene_atk <= 0)){
				end = true;
			}else if(ene_atk > 0){
				int times = h / own_atk;
				if(h % own_atk != 0){
					times++;
				}
				
				monstars.add(new Monstar(ene_atk, times));
			}
		}
		
		//System.out.println(Arrays.toString(monstars));
		
		if(end){
			System.out.println(-1);
			return;
		}
		
		Collections.sort(monstars);
		long time = 0;
		for(Monstar monstar : monstars){
			time += monstar.times;
			
			cur_hp -= monstar.atk * (time - 1);
			
			if(cur_hp <= 0){
				break;
			}
		}
		
		if(cur_hp <= 0){
			System.out.println(-1);
		}else{
			System.out.println(hp - cur_hp);
		}
	}
	
public static class Scanner {
		private BufferedReader br;
		private StringTokenizer tok;
		
		public Scanner(InputStream is) throws IOException{
			br = new BufferedReader(new InputStreamReader(is));
			getLine();
		}
		
		private void getLine() throws IOException{
			while(tok == null || !tok.hasMoreTokens()){
				tok = new StringTokenizer(br.readLine());
			}
		}
		
		private boolean hasNext(){
			return tok.hasMoreTokens();
		}
		
		public String next() throws IOException{
			if(hasNext()){
				return tok.nextToken();
			}else{
				getLine();
				return tok.nextToken();
			}
		}
		
		public int nextInt() throws IOException{
			if(hasNext()){
				return Integer.parseInt(tok.nextToken());
			}else{
				getLine();
				return Integer.parseInt(tok.nextToken());
			}
		}
		
		public long nextLong() throws IOException{
			if(hasNext()){
				return Long.parseLong(tok.nextToken());
			}else{
				getLine();
				return Long.parseLong(tok.nextToken());
			}
		}
		
		public double nextDouble() throws IOException{
			if(hasNext()){
				return Double.parseDouble(tok.nextToken());
			}else{
				getLine();
				return Double.parseDouble(tok.nextToken());
			}
		}
	}

}