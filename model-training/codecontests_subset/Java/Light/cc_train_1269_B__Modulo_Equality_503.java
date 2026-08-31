//package cf;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
public class USACO {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter (System.out);
        //BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        StringTokenizer st = new StringTokenizer(reader.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        StringTokenizer st2 = new StringTokenizer(reader.readLine()," ");
        for (int i=0;i<n;i++) a.add(Integer.parseInt(st2.nextToken())%m);
        StringTokenizer st3 = new StringTokenizer(reader.readLine()," ");
        for (int i=0;i<n;i++) b.add(Integer.parseInt(st3.nextToken())%m);
        Collections.sort(a);
        Collections.sort(b);
        int min=1000000999;
        for (int i=0;i<n;i++) {
        	int x = (b.get(i)-a.get(0)+m)%m;
        	int fail=0;
        	for (int j=1;j<n;j++) {
        		if ((b.get((i+j)%n)-a.get(j)+m)%m!=x) fail++;
        	}
        	if (fail==0) min=Math.min(x, min);
        }
        out.println(min);
        reader.close();
        out.close();
    }
}