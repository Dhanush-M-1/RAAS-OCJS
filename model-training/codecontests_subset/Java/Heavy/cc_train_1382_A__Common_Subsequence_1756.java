import java.util.*;

public class CommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Scanner sc = new Scanner(System.in);
				int t = sc.nextInt();
				for(int i=0;i<t;i++) {
					int n = sc.nextInt();
					int m = sc.nextInt();
					List<Integer> an = new ArrayList<>();
					List<Integer> bm = new ArrayList<>();
					for(int j=0;j<n;j++)
						an.add(sc.nextInt());
					for(int j=0;j<m;j++)
						bm.add(sc.nextInt());
					int len=0;
					int res=0,che=0;
					for(int j=0;j<n;j++) {
						if(bm.contains(an.get(j)))
							{res = an.get(j);che=1;break;}
					}
					if(che==1) {
						System.out.println("YES");
						System.out.println("1 "+res);
					}else
						System.out.println("NO");
				}

	}

}
