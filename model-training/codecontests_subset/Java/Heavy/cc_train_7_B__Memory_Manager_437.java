import java.util.Arrays;
import java.util.Scanner;
public class Solution{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int m = sc.nextInt();
		boolean[] f = new boolean[m];
		int[] s = new int[0];
		int[] e = new int[0];
		for(int i=0;i<m;i++) f[i] = false;
		for(int i=0;i<t;i++){
			String c = sc.next();
			if(c.equals("alloc")){
				int p = sc.nextInt();
				int d = 0;
				boolean y = false;
				for(int j=0;j<f.length;j++){
					if(!f[j]) d++;
					else d=0;
					if(d>=p){
						y = true;
						s = Arrays.copyOf(s,s.length+1);
						s[s.length-1] = j-p+1;
						e = Arrays.copyOf(e,e.length+1);
						e[e.length-1] = j;
						for(int k=s[s.length-1];k<=e[e.length-1];k++) f[k]=true;
						System.out.println(s.length);
						break;
					}
				}
				if(!y) System.out.println("NULL");
//				else System.out.println(Arrays.toString(f));
			}else if(c.equals("erase")){
				int p = sc.nextInt();
				if(p>s.length||p<1||s[p-1]==-1) System.out.println("ILLEGAL_ERASE_ARGUMENT");
				else{
					for(int j=s[p-1];j<=e[p-1];j++) f[j] = false;
					s[p-1] = -1;
//					System.out.println(Arrays.toString(f));
				}
			}else{
				int v = 0;
				for(int j=0;j<f.length;j++) if(f[j]) v++;
				int x = 0;
				int min = -1;
				int mink = -1;
//				System.out.println(Arrays.toString(s));
//				System.out.println(Arrays.toString(e));
				for(int j=0;j<s.length;j++){
					for(int k=0;k<s.length;k++){
						if(s[k]>=x&&s[k]!=-1&&(min==-1||s[k]<min)){
							min = s[k];
							mink = k;
						}
					}
					if(min!=-1){
						e[mink] = e[mink]-s[mink]+x;
						s[mink] = x;
						x = e[mink]+1;
						if(e[mink]==v) break;
					}
					min = -1;
				}
				Arrays.fill(f,false);
				Arrays.fill(f,0,v,true);
//				System.out.println(Arrays.toString(f));
//				System.out.println(Arrays.toString(s));
//				System.out.println(Arrays.toString(e));
			}
		}
	}
}