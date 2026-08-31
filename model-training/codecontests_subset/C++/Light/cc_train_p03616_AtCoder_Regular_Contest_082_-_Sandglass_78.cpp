#include<bits/stdc++.h>
using namespace std;
#define MAXN 100005 
#define INF 0x3f3f3f3f
#define FIO "c"
#define ll long long
#define mid ((l+r)>>1)
#define lid (id<<1)
#define rid (id<<1|1)

template <class T>
inline void read(T &x)
{
	T f=1;x=0;
	char ch=getchar();
	for (;!isdigit(ch) && ch!='-';ch=getchar());
	if (ch=='-')	ch=getchar(),f=-1;
	for (;isdigit(ch);ch=getchar())	x=x*10+ch-'0';
	x*=f;
}
int N,X,Q,t,a,cur=1,pre,mx,mi,r[MAXN],delta,flag=-1,ans;

inline int f(int x,int mi=0,int mx=X){return (x<mi||x>mx)?((x<mi)?mi:mx):x;}
int main()
{
//	freopen(FIO".in","r",stdin);
//	freopen(FIO".out","w",stdout);
	read(X);read(N);
	for (int i=1;i<=N;i++)	read(r[i]);
	read(Q);
	mx=X;
	while (Q--)
	{
		read(t);read(a);
		while (t>=r[cur] && cur<=N)
		{
			delta=flag*(r[cur]-r[cur-1]);pre+=delta;
			mx=f(mx+delta);mi=f(mi+delta);
			flag=-flag;cur++;
		}
	 	ans = f(flag * (t - r[cur - 1]) + f(a + pre, mi, mx));  
		printf("%d\n",ans);
	}
	fclose(stdin);fclose(stdout);
	return 0;
}

