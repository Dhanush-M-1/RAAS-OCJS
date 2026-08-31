#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
ll f[200005][11];
ll ans[200005][11];
ll g[11];
const ll mod=1e9+7;
void solve(){
	for(int i=0;i<=9;i++){
		for(int j=0;j<=9;j++) f[0][j]=0;
		f[0][i]=1;
		for(int j=1;j<=200000;j++){
			for(int k=2;k<=9;k++)
				f[j][k]=f[j-1][k-1];
			f[j][1]=(f[j-1][9]+f[j-1][0])%mod;
			f[j][0]=f[j-1][9];
			ans[j][i]=0;
			for(int k=0;k<=9;k++)
				ans[j][i]=(ans[j][i]+f[j][k])%mod;
		}
	}
}
int main(){
	std::ios::sync_with_stdio(false);
	solve();
	int t;
	cin>>t;
	while(t--){
		memset(g,0,sizeof(g));
		ll n,m;
		cin>>n>>m;
		while(n){
			g[n%10]++;
			n/=10;
		}
		ll res=0;
		for(int i=0;i<=9;i++)
			res=(res+g[i]*ans[m][i]%mod)%mod;
		cout<<res<<endl;
	}
}