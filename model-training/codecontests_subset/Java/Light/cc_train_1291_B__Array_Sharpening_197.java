import java.util.*;
import java.io.*;
import java.text.NumberFormat;


public class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T=Integer.parseInt(br.readLine());
		int n;
		int arr[];
		boolean up[], down[], flag;
		for(int t=0;t<T;t++) {
			n=Integer.parseInt(br.readLine());
			arr=new int[n];
			up=new boolean[n];
			down=new boolean[n];
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			up[0]=true;
			down[n-1]=true;
			for(int i=1;i<arr.length;i++) {
				up[i]=up[i-1]&&(arr[i]>=i);
				down[n-i-1]=down[n-i]&&(arr[n-i-1]>=i);
			}
			flag=false;
			for(int i=0;i<n && (!flag);i++) {
				flag=up[i]&&down[i];
			}
			if(flag)
				bw.write("Yes");
			else
				bw.write("No");
			if(t!=T-1)
				bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
	private static int getDigit(char ch) {
		return ch-'0';
	}
}