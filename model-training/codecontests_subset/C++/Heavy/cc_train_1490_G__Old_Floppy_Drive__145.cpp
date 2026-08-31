#include<bits/stdc++.h>
using namespace std;
const int N=2e5+200;
typedef long long ll;
ll a[N],b[N];
ll sum[N];
int main()
{
	int T;scanf("%d",&T);
	while(T--)
	{
		ll mx=-1e18;memset(sum,0,sizeof sum);
		int n,m;scanf("%d%d",&n,&m);
		for(int i=1;i<=n;i++)scanf("%lld",&a[i]);
		for(int i=1;i<=n;i++){sum[i]=sum[i-1]+a[i],mx=max(mx,sum[i]);}
		ll qq=sum[n];
		for(int i=1;i<=n;i++){sum[i]=max(sum[i],sum[i-1]);}
		while(m--)
		{
			ll x,w=0;scanf("%lld",&x);
			if(x>mx){
				if(qq<=0){
					printf("-1 ");continue;
				}
				else {
					 w=(x-mx+qq-1)/qq;
					x-=w*qq;
				}
			}
			int pos=lower_bound(sum+1,sum+n+1,x)-sum;
			printf("%lld ",w*n+pos-1);
		}
		printf("\n");
	}
}