import java.util.*;
import java.io.*;
public class Woodcutters
{
	static int[][][] memoize;
	static tree[] arr;
	public static void main(String args[]) throws Exception
	{
		BufferedReader f=new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader f=new BufferedReader(new FileReader("Woodcutters.in"));
		int runs=Integer.parseInt(f.readLine());
		arr=new tree[runs];
		for(int x=0;x<runs;x++)
		{
			StringTokenizer st=new StringTokenizer(f.readLine());
			arr[x]=new tree(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		memoize=new int[runs][3][3];
		for(int a=0;a<runs;a++)
			for(int b=0;b<3;b++)
				for(int c=0;c<3;c++)
					memoize[a][b][c]=-1;
		System.out.println(Math.max(solve(0,0,2),solve(0,1,2)));
	}
	public static int solve(int pos,int cur_dir,int prev_dir)
	{
		if(pos==arr.length) return 0;
		// if(cur_dir==0&&pos!=0)
			// System.out.println(pos+" "+cur_dir+" "+prev_dir+" "+(arr[pos].pos-arr[pos].height)+" "+(arr[pos-1].pos+arr[pos-1].height));
		if(cur_dir==0&&pos!=0&&(arr[pos].pos-arr[pos].height<=arr[pos-1].pos||(prev_dir==1&&arr[pos].pos-arr[pos].height<=arr[pos-1].pos+arr[pos-1].height))) return Integer.MIN_VALUE;
		if(cur_dir==1&&pos!=arr.length-1&&arr[pos].pos+arr[pos].height>=arr[pos+1].pos) return Integer.MIN_VALUE;
		if(memoize[pos][cur_dir][prev_dir]!=-1) return memoize[pos][cur_dir][prev_dir];
		// System.out.println("pos: "+pos+" cur_dir: "+cur_dir);
		//try cutting left, right, and not cutting at all
		int one=solve(pos+1,0,cur_dir)+1;
		int two=solve(pos+1,1,cur_dir)+1;
		int three=solve(pos+1,2,cur_dir);
		// System.out.println("pos: "+pos+" cur_dir: "+cur_dir+" prev_dir: "+prev_dir+" one: "+one+" two: "+two+" three: "+three);
		return memoize[pos][cur_dir][prev_dir]=Math.max(one,Math.max(two,three));
	}
}
class tree
{
	int pos,height;
	public tree(int a,int b)
	{
		pos=a;
		height=b;
	}
}