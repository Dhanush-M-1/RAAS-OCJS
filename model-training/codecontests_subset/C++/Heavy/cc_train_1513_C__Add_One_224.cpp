/**
 * author : madhav
 * handle : madhav10
**/
#include <bits/stdc++.h>
using namespace std;

#define For(start,end,inc) for( int i=(start);i<(end);i+=inc)
typedef long long ll;

int nax=1e6+15;
vector<ll> f(nax,0);
vector<ll> num(10,0);
ll convert(){
	int mod=1e9+7;
	vector<ll> tmp(10,0);
	For(1,10,1){
		tmp[i]=num[i-1];
	}
	tmp[0]=(num[9])%mod;
	tmp[1]=(tmp[1]+num[9])%mod;
	ll ans=0;
	For(0,10,1){
		ans=(ans+tmp[i])%mod;
		num[i]=tmp[i];
	}
	return ans;
}

void solve(){
	int n,m,mod=1e9+7;
	cin>>n>>m;
	ll ans=0;
	while(n>0){
		int tmp=n%10;
		ans=(ans+f[m+tmp])%mod;
		n=n/10;
	}
	cout<<ans<<"\n";
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int T;
	f[0]=1;
	num[0]=1;
	For(1,nax,1){
		f[i]=convert();
		//cout<<f[i]<<" ";
	}
	cin>>T;
	while(T--){
		solve();
	}
    return 0;
}

