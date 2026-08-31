import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class A {

	public static void main(String[] args) throws Exception {
//		StringTokenizer stok = new StringTokenizer(new Scanner(new File("F:/books/input.txt")).useDelimiter("\\A").next());
		StringTokenizer stok = new StringTokenizer(new Scanner(System.in).useDelimiter("\\A").next());
		StringBuilder sb = new StringBuilder();
		Integer test = Integer.parseInt(stok.nextToken());
		for(int tst=0;tst<test;tst++) {
			Integer a = Integer.parseInt(stok.nextToken());
			Integer b = Integer.parseInt(stok.nextToken());
			Integer c = Integer.parseInt(stok.nextToken());
			int v1 = c/2;
			int v2 = b;
			int v = Math.min(v1, v2);
			long tot = v*3;
			b-=v;
			v1 = b/2;
			v2=a;
			v = Math.min(v1, v2);
			tot+=v*3;
			sb.append(tot+"\n");
		}
		System.out.println(sb);
	}

}
