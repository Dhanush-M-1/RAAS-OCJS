import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.Map.Entry;

public class abc {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int w=Integer.parseInt(br.readLine());
		while(w-->0) {
			int[] arr=new int[3];
			String[] ss=br.readLine().trim().split(" ");
			for(int i=0 ; i<3 ; i++) {
				arr[i]=Integer.parseInt(ss[i]);
			}
			if(arr[1]==0) {
				System.out.println(0);
				continue;
			}
			int a=arr[0];
			int b=arr[1];
			int c=arr[2];
			int count=0;
			int x=Math.min(c/2, b);
			count+=3*x;
			b-=x;
			int y=Math.min(b/2, a);
			count+=3*y;
			System.out.println(count);
		}
		
	}
}


/*
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int n=Integer.parseInt(br.readLine());
int[] arr=new int[n];
int[] dept=new int[n];
String[] ss=br.readLine().trim().split(" ");
for(int i=0 ; i<arr.length ; i++) {
	arr[i]=Integer.parseInt(ss[i]);
}
ss=br.readLine().trim().split(" ");
for(int i=0 ; i<dept.length ; i++) {
	dept[i]=Integer.parseInt(ss[i]);
}

int[] map2=new int[100001];

for(int i=0 ; i<dept.length ; i++) {
	map2[dept[i]]=i;
}
int max=0,ans=0;
for(int i=0 ; i<arr.length ; i++) {
	max=Math.max(max, map2[arr[i]]);
	if(max>map2[arr[i]]) {
		ans++;
	}
}
System.out.println(ans);
*/