import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		while (sc.hasNext()) {
			int c=sc.nextInt();
			int v0=sc.nextInt();
			int v1=sc.nextInt();
			int a=sc.nextInt();
			int l=sc.nextInt();
			int count=0;
			int index=0;
			int cursum=0;
			int t=1;
			boolean first=true;
			while(cursum<c){
				if(first){
					cursum+=v0;
					count++;
					first=false;
				}else{
					cursum+=Math.min(v0+t*a, v1);
					cursum-=l;
					t++;
					count++;
				}
			}
			pw.println(count);
			pw.flush();
		}
	}
}