import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class c731 {

	public static void main(String[] args) {
//		System.out.println(1);
FastReader sc = new FastReader();
int t = sc.nextInt();
for(int o = 0 ; o<t;o++) {
int k = sc.nextInt();
int n = sc.nextInt(); 
int m = sc.nextInt();
int[]arr1 = new int[n];
int []arr2 = new int[m];
for(int i = 0 ; i<n;i++) {
	arr1[i] = sc.nextInt();
}
for(int i = 0 ; i<m;i++) {
	arr2[i] = sc.nextInt();
}
int[] ans = new int[n+m];
int i = 0;
int j = 0;
int v =  0;
while(i<n && j<m) {
//	System.out.println(i);
	if(arr1[i]<=arr2[j]) {
		ans[v] = arr1[i];
		i++;
	
	}else {
		ans[v] = arr2[j];
		j++;
	}
v++;
//System.out.println(v);
}
if(i<n) {
	for(int p = i ; p<n;p++) {
		ans[v] = arr1[p];
		v++;
	}
}
if(j<m) {
	for(int p = j ; p<m;p++) {
		ans[v] = arr2[p];
		v++;
	}
}
int f = 0;
		for(int p = 0 ; p<n+m;p++) {
			if(ans[p]==0) {
				k++;
			}
			if(ans[p]>k) {
				f =1 ;
				break;
			}
//			System.out.print(ans[p] + " ");
		}

if(f==1) {
	System.out.println(-1);
continue;
}

for(int p = 0 ; p<n+m;p++) {
	
	System.out.print(ans[p] + " ");
}
System.out.println();
}
	}

}
class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader()
    {
        br = new BufferedReader(
            new InputStreamReader(System.in));
    }

    String next()
    {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());

            
            
            
            
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() { return Integer.parseInt(next()); }

    long nextLong() { return Long.parseLong(next()); }

    double nextDouble()
    {
        return Double.parseDouble(next());
    }

    String nextLine()
    {
        String str = "";
        try {
            str = br.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}