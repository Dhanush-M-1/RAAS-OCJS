#include <bits/stdc++.h>
using namespace std;
#define ll long long
#define pb push_back
#define mp make_pair
const int N=200050;
const int M=2*N;
const ll inf=9e18;
struct SegmentTree
{
	ll mn[M];
	void init(){ for(int i=0;i<M;i++) mn[i]=inf;}
	SegmentTree(){ init();}
	void Set(int i, ll f){ i+=N;for(;i;i>>=1) mn[i]=min(mn[i],f);}
	ll Get(int l, int r)
	{
		ll ans=inf;
		for(l+=N,r+=N;l<=r;l>>=1,r>>=1)
		{
			if(l%2==1) ans=min(ans,mn[l++]);
			if(r%2==0) ans=min(ans,mn[r--]);
		}
		return ans;
	}
} L,R;
int a[N];
ll dp[N],tmp[N];
ll Solve(int n, int D)
{
	set<int> st;
	vector<pair<int,int> > work;
	for(int i=1;i<=n;i++) work.pb(mp(a[i],i));
	sort(work.begin(),work.end());
    ll ans=0;
    for(int j=0;j<n;j++)
	{
		int i=work[j].second;
		if(j!=0)
		{
			bool lf=0,rf=0;
			ll l=L.Get(1,i-1);
			if(l!=inf) lf=1;
			l+=a[i]+(ll)i*D;
			ll r=R.Get(i+1,n);
			if(r!=inf) rf=1;
			r+=a[i]-(ll)i*D;
			ll add=min(l,r);
			if(lf && rf) add=min(add,(ll)a[i]*2);
			//printf("%i %lld l:%lld %lld r:%lld\n",i,add,l,L.Get(1,i-1),r);
			ans+=add;
		}
		L.Set(i,a[i]-(ll)i*D);
		R.Set(i,a[i]+(ll)i*D);
		//printf("Ins:%lld %lld\n",a[i]-(ll)i*D,a[i]+(ll)i*D);
	}
	return ans;
}
int main()
{
	int n,i,D;
	scanf("%i %i",&n,&D);
	for(i=1;i<=n;i++) scanf("%i",&a[i]);
	if(n==1) return 0*printf("0\n");
	printf("%lld\n",Solve(n,D));
	/*ll ans=0;
	for(i=2;i<n;i++) ans+=a[i]*2;
	ans+=a[1]+a[n];
	ll sum;
	ans+=(ll)D*(n-1);
	sum=ans;
	int id=1;
	for(i=2;i<=n;i++) if(a[i]<a[id]) id=i;
	dp[id]=0;
	ll mn=a[id]-(ll)id*D;
	for(i=id+1;i<=n;i++)
	{
		dp[i]=mn+a[i]+(ll)i*D+dp[i-1];
		mn=min(mn,a[i]-(ll)i*D);
	}
	tmp[id]=0;
	mn=a[id]+(ll)id*D;
	for(i=id-1;i>=1;i--)
	{
		tmp[i]=mn+a[i]-(ll)i*D+tmp[i+1];
		mn=min(mn,a[i]+(ll)i*D);
	}
	//for(i=1;i<=n;i++) ans=min(ans,dp[i]+tmp[i]);
	//for(i=1;i<=n;i++) printf("i:%i dp:%lld tmp:%lld\n",i,dp[i],tmp[i]);
	ans=min(ans,dp[n]+tmp[1]);
	printf("%lld\n",ans);*/
	/*for(i=1;i<=n;i++)
	{
		tmp[i]=a[i]-(ll)i*D;
		if(i>1) tmp[i]=min(tmp[i],tmp[i-1]);
	}
	ll ret=0;
	mn=a[n]+(ll)n*D;
	for(i=n-1;i>=1;i--)
	{
		ret+=tmp[i]+mn;
		mn=min(mn,a[i]+(ll)i*D);
	}
	printf("%lld\n",ret);*/
	return 0;
}