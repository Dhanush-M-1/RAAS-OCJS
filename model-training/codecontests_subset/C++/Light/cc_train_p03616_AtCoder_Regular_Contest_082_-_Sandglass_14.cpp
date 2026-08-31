#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 3e5+1;
const int inf = 0x7ffffff;

int X,k,Q,ans[N];
struct nd{int t,a,id;}q[N];
bool cmp(nd a,nd b){return a.t<b.t;}
int up(int &x){if(x<0)x=0;if(x>X)x=X;}
int main()
{
	scanf("%d%d",&X,&k);
	for(int i=1;i<=k;++i)scanf("%d",&q[i].t);
	scanf("%d",&Q);
	for(int i=1;i<=Q;++i)
	scanf("%d%d",&q[i+k].t,&q[i+k].a),q[i+k].id=i;
	sort(q+1,q+Q+k+1,cmp);
	int a=0,b=X,l=0,r=X,tag=-1,pre=0;
	for(int i=1;i<=Q+k;++i)
	{
		if(q[i].id)
		{
			int ret=0,res=q[i].t-pre;
			if(q[i].a<=l)ret=a;
			else if(q[i].a>=r)ret=b;
			else ret=a-l+q[i].a;
			ret+=res*tag;
			up(ret);
			ans[q[i].id]=ret;
		}
		else
		{
			
			int v=q[i].t-pre;
			if(tag==-1)
			{
				if(v>a)
				{
					b-=v;l+=v-a;
					up(b);up(l);
					if(r<l)r=l;
					a=0;
				}
				else	a-=v,b-=v;
			}
			else
			{
				if(v+b>X)
				{
					a+=v;r-=b+v-X;
					up(a);up(r);
					if(r<l)l=r;
					b=X;
				}
				else	a+=v,b+=v;
			}
			tag*=-1;
			pre=q[i].t;
		}
	}
	for(int i=1;i<=Q;++i)printf("%d\n",ans[i]);
}