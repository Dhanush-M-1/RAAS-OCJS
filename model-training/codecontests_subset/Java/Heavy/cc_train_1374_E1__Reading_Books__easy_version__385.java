/*
 ID: tommatt1
 LANG: JAVA
 TASK: 
*/
import java.util.*;
import java.io.*;
public class cf1374e2{
static PriorityQueue<pair> rem00;static PriorityQueue<pair> rem01;static PriorityQueue<pair> rem10;static PriorityQueue<pair> rem11;
static PriorityQueue<pair> add00;static PriorityQueue<pair> add01;static PriorityQueue<pair> add10;static PriorityQueue<pair> add11;
static long ans;
static int ak,bk,curm;
	public static void main(String[] args)throws IOException {
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		add00=new PriorityQueue<pair>();add01=new PriorityQueue<pair>();add10=new PriorityQueue<pair>();add11=new PriorityQueue<pair>();
		rem00=new PriorityQueue<pair>((a,b)->{return b.compareTo(a);});
		rem01=new PriorityQueue<pair>((a,b)->{return b.compareTo(a);});
		rem10=new PriorityQueue<pair>((a,b)->{return b.compareTo(a);});
		rem11=new PriorityQueue<pair>((a,b)->{return b.compareTo(a);});
		pair[] bks=new pair[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(bf.readLine());
			int t1=Integer.parseInt(st.nextToken());
			int a1=Integer.parseInt(st.nextToken());
			int b1=Integer.parseInt(st.nextToken());
			bks[i]=new pair(t1,a1,b1,i+1);
		}
		Arrays.sort(bks);
		for(pair i:bks) {
			if(i.a==1&&i.b==1) {
				add11.add(i);
			}
			else if(i.a==1) {
				add10.add(i);
			}
			else if(i.b==1) {
				add01.add(i);
			}
			else {
				add00.add(i);
				continue;
			}
			if(i.a==1&&i.b==1) {
				if(ak<k||bk<k) {
					add(i);
					if(ak>k&&!rem10.isEmpty()) {
						pair p=rem10.poll();
						remove(p);
					}
					if(bk>k&&!rem01.isEmpty()) {
						pair p=rem01.poll();
						remove(p);
					}
				}
				else {
					if(!rem10.isEmpty()&&!rem01.isEmpty()) {
						int old=rem10.peek().t+rem01.peek().t;
						if(old>i.t) {
							pair p1=rem10.poll();
							pair p2=rem01.poll();
							remove(p1);
							remove(p2);
							add(i);
						}
					}
				}
			}
			else if(i.a==1&&ak<k) {
				add(i);
			}
			else if(i.b==1&&bk<k){
				add(i);
			}
		}
		while(curm>m) {
			pair p=low(add11);
			pair rema=high(rem10);
			pair remb=high(rem01);
			if(p==null||rema==null||remb==null) {
				out.println(-1);
				out.close();
				System.exit(0);
			}
			remove(rema);
			remove(remb);
			add(p);
		}
		while(curm<m) {
			pair min00=low(add00);
			pair min10=low(add10);
			pair min01=low(add01);
			pair min11=low(add11);
			pair min=min(min(min00,min01),min(min10,min11));
			pair max11=high(rem11);
			if(max11==null|min10==null||min01==null) {
				if(min==null) {
					out.println(-1);
					out.close();
					System.exit(0);
				}
				add(min);
			}
			else {
				if(min.t<min01.t+min10.t-max11.t) {
					add(min);
				}
				else {
					remove(max11);
					add(min10);
					add(min01);
				}
			}
		}
		if(ak<k||bk<k) {
			out.println(-1);
			out.close();
			System.exit(0);
		}
		else {
			out.println(ans);
		}
		for(pair i:bks) {
			if(i.inc) {
				out.print(i.id+" ");
			}
		}
		out.println();
		out.close();
	}
	static pair low(PriorityQueue<pair> pq) {
		while(!pq.isEmpty()) {
			pair p=pq.peek();
			if(p.inc) pq.poll();
			else return p;
		}
		return null;
	}
	static pair high(PriorityQueue<pair> pq) {
		while(!pq.isEmpty()) {
			pair p=pq.peek();
			if(!p.inc) pq.poll();
			else return p;
		}
		return null;
	}
	static pair min(pair a, pair b) {
		if(a==null) return b;
		if(b==null) return a;
		return a.t<=b.t?a:b;
	}
	static void add(pair i) {
		i.inc=true;
		ans+=i.t;
		curm++;
		if(i.a==1&&i.b==1) {
			ak++;
			bk++;
			rem11.add(i);
		}
		else if(i.a==1) {
			ak++;
			rem10.add(i);
		}
		else if(i.b==1) {
			bk++;
			rem01.add(i);
		}
		else {
			rem00.add(i);
		}
	}
	static void remove(pair i) {
		i.inc=false;
		ans-=i.t;
		curm--;
		if(i.a==1&&i.b==1) {
			ak--;
			bk--;
			add11.add(i);
		}
		else if(i.a==1) {
			ak--;
			add10.add(i);
		}
		else if(i.b==1) {
			bk--;
			add01.add(i);
		}
		else {
			add00.add(i);
		}
	}
	static class pair implements Comparable<pair>{
		int t,a,b; boolean inc;int id;
		public pair(int t1,int x,int y,int id1) {
			t=t1;a=x;b=y;id=id1;
		}
		public int compareTo(pair p) {
			return t-p.t;
			//if(a>p.a) return 1;
		}
	}

}
