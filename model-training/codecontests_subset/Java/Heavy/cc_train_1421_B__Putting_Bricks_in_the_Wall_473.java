import java.io.*;
import java.util.*;
public class Pb{
	public static void main(String[] args) throws IOException{
		FastReader sc = new FastReader();
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(java.io.FileDescriptor.out),"ASCII"),512);
		int t = sc.nextInt();
		while(t-- > 0){
			int n = sc.nextInt();
			char[][] ch = new char[n][n];
			for(int i=0;i<n;i++){
				ch[i] = sc.nextLine().toCharArray();
			}
			if(ch[0][1] == ch[1][0]){
				if(ch[n-2][n-1] == ch[n-1][n-2]){
					if(ch[0][1] == ch[n-2][n-1]){
						out.write(2 + "");
						out.write('\n');
						out.write(1 + " " + 2);
						out.write('\n');
						out.write(2 + " " + 1);
					}else{
						out.write(0 + "");
					}
				}else{
					out.write(1 + "");
					out.write('\n');
					if(ch[n-2][n-1] == ch[0][1]) out.write((n-1) + " " + n);
					else out.write(n + " " + (n-1));
				}
			}else{
				if(ch[n-2][n-1] == ch[n-1][n-2]){
					out.write(1 + "");
					out.write('\n');
					if(ch[0][1] == ch[n-2][n-1]) out.write(1 + " " + 2);
					else out.write(2 + " " + 1);
				}else{
					out.write(2 + "");
					out.write('\n');
					out.write(1 + " " + 2);
					out.write('\n');
					if(ch[n-2][n-1] != ch[0][1]){
						out.write((n-1) + " " + n);
					}else{
						out.write(n + " " + (n-1));
					}
				}
			}
			out.write('\n'); 
		}
		out.flush();
	}
}
class FastReader{
	BufferedReader br;
	StringTokenizer st;
	public FastReader(){
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	String next(){
		while(st == null || !st.hasMoreElements()){
			try{ 
				st = new StringTokenizer(br.readLine()); 
			} 
			catch (IOException  e){ 
				e.printStackTrace(); 
			} 
		} 
		return st.nextToken();
	}
	int nextInt(){ 
        return Integer.parseInt(next()); 
	}
    long nextLong(){ 
        return Long.parseLong(next()); 
    }
    double nextDouble(){ 
        return Double.parseDouble(next()); 
    }
    String nextLine(){ 
        String str = ""; 
        try{ 
            str = br.readLine(); 
        } 
		catch (IOException e){ 
            e.printStackTrace(); 
        } 
        return str; 
    }
}