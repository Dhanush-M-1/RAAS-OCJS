import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class R307Div2B {

	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		char[] a=in.nextToken().toCharArray();
		char[] b=in.nextToken().toCharArray();
		char[] c=in.nextToken().toCharArray();
		
		int[] aaa=new int[26];
		int[] bbb=new int[26];
		int[] ccc=new int[26];
		for(int i=0;i<a.length;i++)
			aaa[a[i]-'a']++;
		for(int i=0;i<b.length;i++)
			bbb[b[i]-'a']++;
		for(int i=0;i<c.length;i++)
			ccc[c[i]-'a']++;

		StringBuffer ans=new StringBuffer("");
		if(Arrays.equals(b,c)){
			int min=getMin(aaa,bbb,new int[26]);
			
			for(int i=0;i<min;i++){
				ans.append(String.valueOf(b));
			}
			for(int i=0;i<26;i++)
				aaa[i]-=min*bbb[i];
			
			for(int i=0;i<26;i++)
				for(int j=0;j<aaa[i];j++)
					ans.append((char)(i+'a'));
		}else{
			int[] ddd=new int[26];
			int min1=getMin(aaa,bbb,ddd);
			int[] min={min1,0};
			for(int i=0;i<=min1;i++){
				for(int j=0;j<26;j++)
					ddd[j]=i*bbb[j];
				int min2=getMin(aaa,ccc,ddd);
				if(i+min2>min[0]+min[1]){
					min[0]=i;
					min[1]=min2;
				}
			}
			
			for(int i=0;i<min[0];i++){
				ans.append(String.valueOf(b));
			}
			
			for(int i=0;i<min[1];i++){
				ans.append(String.valueOf(c));
			}
			for(int i=0;i<26;i++){
				aaa[i]-=min[0]*bbb[i];
				aaa[i]-=min[1]*ccc[i];
			}
			
			for(int i=0;i<26;i++)
				for(int j=0;j<aaa[i];j++)
					ans.append((char)(i+'a'));
		}
		
		System.out.println(ans.toString());
	}
	
	static int getMin(int[] aaa,int[] bbb,int[] ccc) {
		int min=Integer.MAX_VALUE;
		for(int i=0;i<26;i++){
			if(bbb[i]>0)
				min=Math.min(min,(aaa[i]-ccc[i])/bbb[i]);
		}
		return min;
	}
	static class FastScanner{
		BufferedReader br;
		StringTokenizer st;
		public FastScanner(){br=new BufferedReader(new InputStreamReader(System.in));}
		String nextToken(){
			while(st==null||!st.hasMoreElements())
				try{st=new StringTokenizer(br.readLine());}catch(Exception e){}
			return st.nextToken();
		}
		int nextInt(){return Integer.parseInt(nextToken());}
		long nextLong(){return Long.parseLong(nextToken());}
		double nextDouble(){return Double.parseDouble(nextToken());}
	}
}
