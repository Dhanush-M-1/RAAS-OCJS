

import java.io.*;

public class C3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new C3();
	}
	C3() throws IOException {
		in = new StreamTokenizer(new InputStreamReader(System.in));
	   	out = new PrintWriter(new OutputStreamWriter(System.out));
	   	long n = nextInt();
	   	long[] a = new long[(int)n];
	   	for(int i = 0;i<n;i++) a[i] = nextInt();
	   	//System.out.println(-2%2);
	   	out.print(1);
	   	out.print(' ');
	   	out.println(n);
	   	for(int i = 0;i<n;i++) {
	   		out.print(a[i]*-n);
	   		out.print(' ');
	   		a[i] -= a[i]*n; 
	   	}
	   	out.println();
	   	out.print(1);
	   	out.print(' ');
	   	out.println(Math.max(n-1, 1L));
	   	for(int i = 0;i<n-1;i++) {
	   		out.print(a[i]*-1L);
	   		out.print(' ');
	   	}
	   	if(n==1) out.print(0);
	   	out.println();
	   	out.println(n+" "+n);
	   	out.print(-a[(int)n-1]);
	   	out.close();
	}
	StreamTokenizer in;
    PrintWriter out;
    int nextInt() throws IOException {
    	in.nextToken();
    	return (int) in.nval;
    }

}
