#include<iostream>
#include<vector>
#include<algorithm>
#include<cstring>
#include<cstdio>
#include<cmath>
#include<cstdlib>
#include<ctime>
#include<queue>
#include<set>
#include<map>
#include<stack>
#include<bitset>
using namespace std;
typedef long long LL;
const int N=2e5;
int gi() {
	int w=0;bool q=1;char c=getchar();
	while ((c<'0'||c>'9') && c!='-') c=getchar();
	if (c=='-') q=0,c=getchar();
	while (c>='0'&&c <= '9') w=w*10+c-'0',c=getchar();
	return q? w:-w;
}
int R[N],ans[N];
struct P{ int t,a,id; inline bool operator < (const P &b) const { return t<b.t; } }p[N];
int main()
{
	int s=gi(),n=gi(),m,i,t,k,l=0,r=s,d,sum=0;
	for (i=1;i<=n;i++) R[i]=gi();
	for (i=1,m=gi();i<=m;i++) p[i].t=gi(),p[i].a=gi(),p[i].id=i;
	sort(p+1,p+1+m);
	for (i=k=1,d=-1;i<=m;i++) {
		for (;k<=n&&R[k]<=p[i].t;k++,d*=-1) {
			l=max(0,l+d*(R[k]-R[k-1]));l=min(l,s);
			r=max(0,r+d*(R[k]-R[k-1]));r=min(r,s);
			sum+=d*(R[k]-R[k-1]);
		}
		t=max(p[i].a+sum,l);t=min(t,r);
		t=max(0,t+d*(p[i].t-R[k-1]));t=min(t,s);
		ans[p[i].id]=t;
	}
	for (i=1;i<=m;i++)
		printf("%d\n",ans[i]);
	return 0;
}
