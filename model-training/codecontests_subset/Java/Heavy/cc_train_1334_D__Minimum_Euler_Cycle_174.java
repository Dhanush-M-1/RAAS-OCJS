import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class CE85D {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
	
		int t = sc.nextInt();
		for(int x=0; x<t; x++) {
			long n = sc.nextLong();
			long l = sc.nextLong();
			long r = sc.nextLong();
			
			long total = (n)*(n-1)+1;
			
			//System.out.println("totes" + total);
			
//			if(l == total && r==total) {
//				System.out.println(1);
//				continue;
//			}
			
			long first = 1;
			long second = 0;
			
			long sum = 0;
			
			while(true) {
				long next = 2*(n-first);
				//System.out.println(next);
				if(sum + next < l) {
					first += 1;
					sum += next;
				} else {
					break;
				}
				
				if(next == 2) {
					break;
				}
			}
			
			//System.out.println("sumdy" + sum);
			
			long diff = l - sum;
			second = first + 1 + ((diff-1)/2);
			
			//System.out.println("fgege" + first + " " + second);
			
			while(l <= r) {
				//System.out.println("ell"+ l);
				if(l == total) {
					System.out.print("1 ");
				} else {
					if(l%2 == 0) { //second
						System.out.print(second + " ");
						if(second < n) {
							second += 1;
						} else {
							first += 1;
							second = first + 1;
						}
					} else {
						System.out.print(first + " ");
					}
				}
				l++;
			}
			System.out.println();
		}
	}
	
	static class FastReader{BufferedReader br;StringTokenizer st;public FastReader()
	{br=new BufferedReader(new InputStreamReader(System.in));}
	String next(){while(st==null||!st.hasMoreElements())
	{try{st=new StringTokenizer(br.readLine());}
	catch(IOException e){e.printStackTrace();}}return st.nextToken();}
	int nextInt(){return Integer.parseInt(next());}
	long nextLong(){return Long.parseLong(next());}
	double nextDouble(){return Double.parseDouble(next());}
	String nextLine(){String str="";try{str=br.readLine();}
	catch(IOException e){e.printStackTrace();}return str;}}
}

/* 
int n = sc.nextInt();

for(int y=0; y<n; y++){
	int x = sc.nextInt();
}

int a = sc.nextInt();
int b = sc.nextInt();
int c = sc.nextInt();
int d = sc.nextInt();
int e = sc.nextInt();
*/
