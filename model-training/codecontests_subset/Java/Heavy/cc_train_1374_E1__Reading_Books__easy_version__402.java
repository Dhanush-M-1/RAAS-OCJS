import java.util.*;
import java.io.*;
import java.lang.Math;
import java.util.Random;


public class Solution{


	public static void main(String[] args) throws Exception{

		FastScanner fs = new FastScanner();
		

		int n = fs.nextInt(), k = fs.nextInt();

		ArrayList<Book> listA = new ArrayList<Book>(n);
		ArrayList<Book> listB = new ArrayList<Book>(n);
		ArrayList<Book> listBoth = new ArrayList<Book>(n);

		int sigA = 0, sigB = 0;

		for(int i=0;i<n;i++){
			int t = fs.nextInt(), a = fs.nextInt(), b = fs.nextInt();
			sigA += a;
			sigB += b;
			if(a==1 && b==1)
			listBoth.add(new Book(t,a,b));
			else if(a==1)
				listA.add(new Book(t,a,b));
			else if(b==1)
				listB.add(new Book(t,a,b));
		}

		if(sigA<k || sigB<k){
			System.out.println(-1);
		}

		else{

			Collections.sort(listA);
			Collections.sort(listB);
			Collections.sort(listBoth);


			int nA = listA.size(), nB = listB.size(), nC = listBoth.size();
			int a=0, b=0, c=0;			
				

			int num = k;
			int ans = 0;
			while(num>0){
				if(a<nA && b<nB && c<nC){
					int val = listBoth.get(c).t - listA.get(a).t - listB.get(b).t;
					if(val<0){
						ans += listBoth.get(c).t;
						c++;
						num--;
					}
					else{
						ans += listA.get(a).t + listB.get(b).t;
						a++;
						b++;
						num--;
					}
				}
				else if(a==nA || b==nB){
					ans += listBoth.get(c).t;
					c++;
					num--;
				}

				else if(c==nC){
					ans += listA.get(a).t + listB.get(b).t;
					a++;
					b++;
					num--;
				}
			}

			System.out.println(ans);



		}
			
		
	}

	static class Book implements Comparable<Book>{
		int t,a,b;

		public Book(int t, int a, int b){
			this.t = t;
			this.a = a;
			this.b = b;
		}

		public int compareTo(Book b){
			return Integer.compare(this.t,b.t);
		}
	}

	


	static class FastScanner{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		public String next(){
			while(!st.hasMoreElements()){
				try{
					st = new StringTokenizer(br.readLine());
				} catch(IOException e){
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		public int nextInt(){
			return Integer.parseInt(next());
		}

		public int[] readArray(int n){
			int[] a = new int[n];
			for(int i=0;i<n;i++)
				a[i] = nextInt();
			return a;
		}

		public long nextLong(){
			return Long.parseLong(next());
		}

	}

}