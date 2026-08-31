#include<bits/stdc++.h>

using namespace std;
const int N = 1e6+100;
typedef long long ll;
const ll mod = 1000000007;
ll f[N];
bool vis[N];
int main(){
	ll n,m,x;
	cin>>n>>m;
	for(int i=1;i<=m;i++){
		cin>>x;vis[x]=1;
	}
	f[0]=1;
	f[1]=1;
	if(vis[1]) f[1]=0;
	for(int i=2;i<=n;i++){
		if(vis[i]) f[i]=0;
		else f[i]=(f[i-1]%mod+f[i-2]%mod)%mod;
	}
	cout<<f[n]%mod<<endl;
	return 0;
}
