/* --- author: dxm --- */
#include<bits/stdc++.h>
using namespace std;

#define INF 1e9
#define Inf 1e18
#define rep(i,n) for(int (i)=0;(i)<n;i++)
#define REP(i,n) for(int (i)=1;(i)<=n;i++)
#define mp make_pair
#define pb push_back
#define pii pair<int,int>
#define fst first
#define snd second
typedef long long ll;
typedef double db;
typedef long double ldb;
typedef unsigned int uint;
typedef unsigned long long ull;
#define DEBUG

const int maxn=100005;
int x,k,q;
int a[maxn],b[maxn],c[maxn],r[maxn];

int main(){
#ifndef DEBUG
	freopen("my.in","r",stdin);
	freopen("my.out","w",stdout);
#endif
	scanf("%d%d",&x,&k);
	REP(i,k)scanf("%d",&r[i]);
	b[0]=x;
	REP(i,k){
		a[i]=a[i-1];b[i]=b[i-1];
		if(i&1){
			a[i]=max(a[i],min(r[i]-r[i-1]-c[i-1],b[i]));
			c[i]=max(a[i-1]+c[i-1]-r[i]+r[i-1],0)-a[i];
		}
		else{
			b[i]=min(b[i],max(x-(r[i]-r[i-1])-c[i-1],a[i]));
			c[i]=min(b[i-1]+c[i-1]+r[i]-r[i-1],x)-b[i];
		}
//		cout<<a[i]<<" "<<b[i]<<" "<<c[i]<<endl;
	} 
	scanf("%d",&q);
	while(q--){
		int t,ini;
		scanf("%d%d",&t,&ini);
		int pos=upper_bound(r+1,r+1+k,t)-r-1,ans=c[pos];
		if(ini<=a[pos])ans+=a[pos];
		else if(ini>=b[pos])ans+=b[pos];
		else ans+=ini;
		if(pos&1)ans=min(x,ans+(t-r[pos]));
		else ans=max(0,ans-(t-r[pos]));
		printf("%d\n",ans);
	}
	return 0;
}

/*
Input:
-----------------
Output:
*/