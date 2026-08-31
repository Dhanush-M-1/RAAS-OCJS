import java.util.Arrays;
import java.util.Scanner;

public class SummoningMinions {

	public static void main(String[] args) {
		Scanner fs=new Scanner(System.in);
		int T=fs.nextInt();
		for (int tt=0; tt<T; tt++) {
			int n=fs.nextInt(), k=fs.nextInt();
			long ans=0;
			int[][] cost=new int[k][n];
			for (int i=0; i<n; i++) {
				int a=fs.nextInt(), b=fs.nextInt();
				ans+=(k-1)*(long)b;
				for (int spot=0; spot<k; spot++)
					cost[spot][i]=-(k-1)*b+spot*b+a;
			}
			Hungarian h=new Hungarian(cost);
			h.run();
			boolean[] chosen=new boolean[n];
			for (int i=0; i<k; i++) chosen[h.xy[i]]=true;
			System.out.println(k-1 + 2*(n-k) + 1);
			for (int i=0; i+1<k; i++) {
				System.out.print(1+h.xy[i]+" ");
			}
			for (int i=0; i<n; i++) if (!chosen[i]) System.out.print((1+i)+" -"+(1+i)+" ");
			System.out.println(h.xy[k-1]+1);
		}
	}

	// #rows of cost matrix MUST be <= #columns
	// xy[i] tells you what item i from the left matched with

	// Given a cost matrix, matches each row with a column that MAXIMIZES
	// total of selected edges.
	static class Hungarian {
		static int inf=100000000;
		int[][] c;
		int[] lx, ly, xy, yx, s, sx, p, q;
		int n, m;
		boolean[] S, T;

		public Hungarian(int[][] cost) {
			c=cost;
			n=c.length;
			m=c[0].length;
			// INIT: lx[n],xy[n],prev[n],q[n],ly[m],yx[m],s[m],sx[m]
			S=new boolean[n];
			T=new boolean[m];
			// #
			// Array initialization
			lx=new int[n];
			ly=new int[m];
			xy=new int[n];
			yx=new int[m];
			s=new int[m];
			sx=new int[m];
			p=new int[n];
			q=new int[n];
			// $
		}

		void augment() {
			int x, y, root=-1, wr=0, rd=0;
			Arrays.fill(p, -1);
			Arrays.fill(S, false);
			Arrays.fill(T, false);
			for (x=0; x<n; x++) {
				if (xy[x]==-1) {
					q[wr++]=root=x;
					p[x]=-2;
					S[x]=true;
					break;
				}
			}
			for (y=0; y<m; y++) {
				s[y]=lx[root]+ly[y]-c[root][y];
				sx[y]=root;
			}
			while (y>=m) {
				while (rd<wr&&y>=m) {
					x=q[rd++];
					for (y=0; y<m; y++) {
						if (c[x][y]==lx[x]+ly[y]&&!T[y]) {
							if (yx[y]==-1)
								break;
							T[y]=true;
							q[wr++]=yx[y];
							addToTree(yx[y], x);
						}
					}
				}
				if (y<m)
					break;
				updateLabels();
				wr=rd=0;
				for (y=0; y<m; y++) {
					if (!T[y]&&s[y]==0) {
						if (yx[y]==-1) {
							x=sx[y];
							break;
						} else {
							T[y]=true;
							if (!S[yx[y]]) {
								q[wr++]=yx[y];
								addToTree(yx[y], sx[y]);
							}
						}
					}

				}
			}
			for (int cx=x, cy=y, ty; cx!=-2; cx=p[cx], cy=ty) {
				ty=xy[cx];
				yx[cy]=cx;
				xy[cx]=cy;
			}
		}

		void updateLabels() {
			int x, y, delta=inf;
			for (y=0; y<m; y++)
				delta=Math.min(delta, !T[y]?s[y]:inf);
			for (x=0; x<n; x++)
				lx[x]-=S[x]?delta:0;
			for (y=0; y<m; y++) {
				ly[y]+=T[y]?delta:0;
				s[y]-=!T[y]?delta:0;
			}
		}

		void addToTree(int x, int prevX) {
			S[x]=true;
			p[x]=prevX;
			for (int y=0; y<m; y++) {
				if (lx[x]+ly[y]-c[x][y]<s[y]) {
					s[y]=lx[x]+ly[y]-c[x][y];
					sx[y]=x;
				}
			}
		}

		int run() {
			Arrays.fill(xy, -1);
			Arrays.fill(yx, -1);
			for (int x=0; x<n; x++)
				for (int y=0; y<m; y++)
					lx[x]=Math.max(lx[x], c[x][y]);
			for (int i=0; i<n; i++)
				augment();
			int ret=0;
			for (int x=0; x<n; x++)
				ret+=c[x][xy[x]];
			return ret;
		}
	}

}
