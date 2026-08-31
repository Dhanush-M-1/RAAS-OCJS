#include <bits/stdc++.h>
#define rep(i,n)for(int i=0;i<(n);i++)
using namespace std;
typedef long long ll;

int r[200000];
ll a[200000],b[200000],c[200000];
int main(){
	ll x,k;scanf("%lld%lld",&x,&k);
	rep(i,k)scanf("%d",&r[i+1]);
	c[0]=x;
	rep(i,k){
		int s=r[i+1]-r[i];
		if(i%2==0)s=-s;
		a[i+1]=min(max(a[i]+s,0LL),x);
		b[i+1]=b[i]+s;
		c[i+1]=min(max(c[i]+s,0LL),x);
	}
	int q;scanf("%d",&q);
	rep(i,q){
		int t,d;scanf("%d%d",&t,&d);
		int j=upper_bound(r,r+k+1,t)-r-1;
		int s=t-r[j];
		if(j%2==0)s=-s;
		ll na=min(max(a[j]+s,0LL),x);
		ll nb=b[j]+s;
		ll nc=min(max(c[j]+s,0LL),x);
		printf("%lld\n",min(max(nb+d,na),nc));
	}
}