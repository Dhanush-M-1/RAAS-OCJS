import java.util.Scanner;

public class BeautifulContest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		while(t-->0) {
			int n = input.nextInt();
			int[] a = new int[n];
			
			for(int i=0;i<n;i++) {
				a[i]=input.nextInt();
			}
			
			if(n<6) {
				System.out.println(0+" "+0+" "+0);
				continue;
			}
			
			int g = 0;
			int s = 0;
			int b = 0;
			
			StringBuilder st = new StringBuilder("");
			int ct = 1;
			int i=1;
			for(;i<a.length;i++) {
				if(a[i]==a[i-1])
					ct++;
				else {
					st.append(a[i-1]+"_"+ct+" ");
					ct=1;
				}
			}
			
			st.append(a[i-1]+"_"+ct+" ");
			//System.out.println(st.toString());
			
			String[] as = st.toString().split(" ");
			
			int ind = -1;
			int tc = 0;
			int tot = n/2;
			for(i=0;i<as.length;i++) {
				String[] str = as[i].split("_");
				int cx = Integer.valueOf(str[1]);
				tc+=cx;
				if(tc<=tot) ind++;
				if(ind == 0) g+=cx;
			}
			
			//System.out.println(g);
			
			for(i=ind;i>=1;i--) {
				String[] str = as[i].split("_");
				int cx = Integer.valueOf(str[1]);
				if(b<=g) b+=cx;
				else break;
			}
			
			//System.out.println(b);
			while(i>=1) {
				String[] str = as[i].split("_");
				int cx = Integer.valueOf(str[1]);
				s+=cx;
				i--;
			}
			
			if(s==0||g==0||b==0||(s+b+g)>tot||g>=s||g>=b) {
				s=0;
				g=0;
				b=0;
			}
			
			System.out.println(g+" "+s+" "+b);
		}
	}

}
