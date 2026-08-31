#include<bits/stdc++.h>
#define rep(i,a,b) for(int i=(a);i<(b);++i)
#define per(i,a,b) for(int i=(b)-1;i>=(a);--i)
#define ll long long
#define lb(x) ((x)&-(x))
#define pii pair<int,int>
#define vi vector<int>
#define pb push_back
#define fi first
#define se second
#define de(x) cout<<#x<<" x"<<endl
#define LCAFA rep(i,1,20)rep(j,1,n+1)fa[j][i]=fa[fa[j][i-1]][i-1]
#define all(x) x.begin(),x.end()
#define ls(x) x<<1
#define rs(x) x<<1|1
#define pr(x) {for(auto v:x)cout<<v<<' ';cout<<#x<<endl;}
using namespace std;
const int N=3e4+9;
const ll mod=998244353;
const ll Inf=1e18;
/*
inline int add(int a,const int &b){
	a+=b;
	if(a>=mod)a-=mod;
	return a;
}
inline int sub(int a,const int &b){
	a-=b;
	if(a<0)a+=mod;
	return a;
}
inline int mul(const int &a,const int &b){return 1ll*a*b%mod;}
int jie[N],inv[N];
ll quick(ll a,ll b){
	ll res=1;
	while(b){
		if(b&1)res=res*a%mod;
		a=a*a%mod;
		b>>=1;
	}
	return res;
}
inline int C(int m,int n){
	if(n>m||m<0||n<0)return 0;
	return mul(mul(jie[m],inv[n]),inv[m-n]);
}
void pre(){
	inv[0]=inv[1]=1,jie[0]=1;
	rep(i,2,N)inv[i]=-1ll*mod/i*inv[mod%i]%mod+mod;
	rep(i,1,N)inv[i]=mul(inv[i],inv[i-1]),jie[i]=mul(jie[i-1],i);
}
*/
ll dp[N][5];
int p[N];
vi s[N];
ll L[N][5][16],R[N][5][16];
int main(){
	//pre();
	int T;
	scanf("%d",&T);
	while(T--){
		int n,c,q;
		scanf("%d%d%d",&n,&c,&q);
		rep(i,0,n)scanf("%d",&p[i]);
		rep(i,0,c+1)dp[n][i]=1;
		per(i,0,n){
			rep(j,0,c+1){
				dp[i][j]=0;
				rep(k,0,j+1){
					if(i+k<n)dp[i][j]+=dp[i+k+1][j-k];
				}
			}
		}
		rep(i,0,n){
			s[i].clear();
			rep(j,0,c+1){
				if(i+j<n)s[i].pb(j);
			}
			sort(all(s[i]),[&](int a,int b){return p[i+a]<p[i+b];});
		}
		int lim=0;
		while((1<<lim)<n)++lim;
		rep(i,0,n)rep(j,0,c+1)rep(k,0,lim+1)L[i][j][k]=R[i][j][k]=0;
		per(i,0,n){
			rep(j,0,c+1){
				if(i+j>=n)break;
				ll sum=0;
				for(auto v:s[i]){
					if(v>j)continue;
					if(v==0)break;
					sum+=dp[i+v+1][j-v];
				}
				L[i][j][0]=sum;
				R[i][j][0]=sum+dp[i+1][j];
				rep(k,1,lim+1){
					if(i+(1<<k)<=n){
						L[i][j][k]=L[i][j][k-1]+L[i+(1<<k-1)][j][k-1];
						R[i][j][k]=L[i][j][k-1]+R[i+(1<<k-1)][j][k-1];
					}
				}
			}
		}
		while(q--){
			int pos;
			ll id;
			scanf("%d%lld",&pos,&id);
			if(id>dp[0][c]){
				puts("-1");
				continue;
			}
			--pos;
			--id;
			int i=0,ans=p[pos],r=c;
		//	cout<<ans<<"ans\n";
			int cnt=0;
			while(i<n){
				++cnt;
				if(cnt>6)return 0;
				for(int j=lim;j>=0;--j){
					if(i+(1<<j)<=n&&L[i][r][j]<=id&&id<R[i][r][j]){
						id-=L[i][r][j];
						i+=1<<j;
					}
				}
				if(i==n)break;
			//	cout<<cnt<<' '<<i<<' '<<r<<' '<<id<<"i\n";
				for(auto v:s[i]){
					if(v>r)continue;
					if(id>=dp[i+v+1][r-v]){
						id-=dp[i+v+1][r-v];
					}
					else{
					//	cout<<v<<"v\n";
						int i1=i+v;
						r-=v;
						if(i<=pos&&pos<=i1){
							ans=p[i+i1-pos];
						}
						i=i1+1;
						break;
					}
				}
			}
				printf("%d\n",ans);
		}
	} 
}
/*
1
3 1 1
1 2 3
2 1

1
6 4 1
6 5 4 3 1 2
3 14

1
20 4 1
16 5 15 14 13 3 17 18 2 20 19 6 4 1 12 8 11 10 9 7
8 1100
*/
