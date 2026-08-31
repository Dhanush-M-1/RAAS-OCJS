#include<iostream>
#include<cstdio>
#include<cstdlib>
#include<algorithm>
#define N 100010
#define ll long long
using namespace std;
ll num[N],ans[N];
struct ques{
	int a,t,id;
	bool operator <(const ques b)const{return t<b.t;}
}q[N];
int main()
{
	ll x;
	int n;
	scanf("%lld%d",&x,&n);
	for(int i=1;i<=n;i++) scanf("%lld",&num[i]);
	int m;
	scanf("%d",&m);
	for(int i=1;i<=m;i++) scanf("%d%d",&q[i].t,&q[i].a),q[i].id=i;
	sort(q+1,q+m+1);
	ll u=1,r=0,up=x,down=0,opt=-1;
	ll sum=0;
	while(u<=m)
	{
		if(num[r+1]<q[u].t && r<n)
        {
        	ll res=0;
            r++;
            res=opt*(num[r]-num[r-1]);
            down=max(0ll,min(x,down+res));
			up=max(0ll,min(x,up+res));
            sum+=res;
			opt=-opt;
        }
		else
		{
			ll cnt=q[u].t-num[r];
			ll res=max(down,min(up,q[u].a+sum));
			ans[q[u].id]=max(0ll,min(x,res+opt*cnt));
			u++;
        }
    }
	for(int i=1;i<=m;i++) printf("%lld\n",ans[i]);
	return 0;
}
