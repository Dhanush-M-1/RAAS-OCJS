#include "bits/stdc++.h"
#define MAXN 100009
#define INF 1000000007
#define mp(x,y) make_pair(x,y)
#define all(v) v.begin(),v.end()
#define pb(x) push_back(x)
#define wr cout<<"----------------"<<endl;
#define ppb() pop_back()
#define tr(ii,c) for(__typeof((c).begin()) ii=(c).begin();ii!=(c).end();ii++)
#define ff first
#define ss second
#define my_little_dodge 46
#define debug(x)  cerr<< #x <<" = "<< x<<endl;
using namespace std;

typedef long long ll;
typedef pair<int,int> PII;
template<class T>bool umin(T& a,T b){if(a>b){a=b;return 1;}return 0;}
template<class T>bool umax(T& a,T b){if(a<b){a=b;return 1;}return 0;}
const ll B=1e18+1;
const int C=5;
int n,c,q,arr[MAXN];
vector<PII>adj[MAXN];
ll dp[MAXN][C],par[MAXN][C];
ll dfs(int nd,int rem){
	if(rem<0)return 0;
	if(nd==n)return 1;
	ll &ret=dp[nd][rem];
	if(~ret)
		return ret;ret=0;
	tr(it,adj[nd])
		if(it->ss<=rem)
			ret=min(B,ret+dfs(nd+1+it->ss,rem-it->ss));
	return ret;		
}
vector<PII>cur;
int rec(int nd,int rem,ll th,int pos){
	if(nd==n){
		tr(it,cur)reverse(arr+it->ff,arr+it->ss+1);
		int ret=arr[pos];
		tr(it,cur)reverse(arr+it->ff,arr+it->ss+1);
		cur.clear();
		return ret;
	}
	int st=nd+1,en=n-1;
	if(st<=en){
		int to=nd;
		while(st+1<en){
			int i=(st+en)>>1;
			if(par[nd][rem]-par[i][rem]<th and th<=par[nd][rem]-par[i][rem]+dfs(i,rem))	
				st=i;
			else
				en=i;
		}int i=en;
		if(par[nd][rem]-par[i][rem]<th and th<=par[nd][rem]-par[i][rem]+dfs(i,rem))nd=i;
		else{
			i=st;
			if(par[nd][rem]-par[i][rem]<th and th<=par[nd][rem]-par[i][rem]+dfs(i,rem))nd=i;
		}
		th-=par[to][rem]-par[nd][rem];
	}
	tr(it,adj[nd]){
		if(th<=dfs(nd+1+it->ss,rem-it->ss)){
			if(it->ss)cur.pb(mp(nd,nd+it->ss));
			return rec(nd+1+it->ss,rem-it->ss,th,pos);
		}
		else th-=dfs(nd+1+it->ss,rem-it->ss);
	}return -1;
}
int main(){
//	freopen("file.in","r",stdin);
	int t;
	scanf("%d",&t);
	while(t--){
		memset(dp,-1,sizeof dp);
		scanf("%d%d%d",&n,&c,&q);
		for(int i=0;i<n;i++)scanf("%d",arr+i);
		for(int i=0;i<n;i++){
			adj[i].clear();
			for(int j=0;j<=c;j++)
				if(i+j<n)
					adj[i].pb(mp(arr[i+j],j));
			sort(all(adj[i]));
		}
		for(int j=0;j<=c;j++)
			for(int i=n;i>=0;i--){
				par[i][j]=par[i+1][j];
				tr(it,adj[i]){
					if(it->ss==0)break;
					par[i][j]=min(B,par[i][j]+dfs(i+it->ss+1,j-it->ss));
				}	
			}
		while(q--){
			ll k;int a;
			scanf("%d%lld",&a,&k);
			printf("%d\n",rec(0,c,k,a-1));	
		}
	}
	return 0;
}