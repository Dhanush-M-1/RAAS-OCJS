//package cf;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
public class USACO {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        //StringTokenizer st = new StringTokenizer(reader.readLine()," ");
        int t = Integer.parseInt(reader.readLine());
        for (int i=0;i<t;i++) {
        	int n = Integer.parseInt(reader.readLine());
        	StringTokenizer st = new StringTokenizer(reader.readLine()," ");
        	int g=0;
        	int s=0;
        	int b=0;
        	int same=Integer.parseInt(st.nextToken());
        	for (int j=1;j<n;j++) {
        		int x = Integer.parseInt(st.nextToken());
        		if (x!=same) {
        			if (g==0) g=j;
        			else if (s==0) {
        				if (j-g>g) s=j-g;
        			} else if (j<=n/2) {
        				if (j-s-g>g) b=j-s-g;
        			}
        		}
        		same=x;
        	}
        	if (b<1) System.out.println("0 0 0");
        	else System.out.println(g+" "+s+" "+b);
        }
        reader.close();
    }
}