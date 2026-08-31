#include <bits/stdc++.h>
using namespace std;
#define rep(i,N) for(int i=0;i<int(N);++i)

typedef long long ll;
const int inf = 1e9;

int main() {
	ll N,M;
	cin>>N>>M;
	vector<ll> a(N),b(N),c(M),d(M),D(N),ans(N);
	rep(i,N)cin>>a[i]>>b[i];
	rep(i,M)cin>>c[i]>>d[i];
	rep(i,N){
		D[i]=inf;
		rep(j,M){
			ll dis = abs(a[i]-c[j])+abs(b[i]-d[j]);
			if(D[i]>dis){
				ans[i]=j+1;
				D[i] = dis;
			}
		}
	}
	rep(i,N)
	cout<<ans[i]<<endl;
}