#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
ll d[100005],mod=1e9+7;
map<ll,ll> p;
int main(){
	ll n,m,x;
	cin>>n>>m;
	for(ll i=1;i<=m;i++){
		cin>>x;
		p[x]=1;
	}
	d[0]=1;
	if(p[1]==1) d[1]=0;
	else d[1]=1;
	for(ll i=2;i<=n;i++){
		if(p[i]==1) continue;
		d[i]=(d[i-1]%mod+d[i-2]%mod)%mod;
	}
	cout<<d[n]%mod<<endl;
}