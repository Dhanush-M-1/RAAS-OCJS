#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef long double ld;
typedef vector<ll> vi;
typedef pair<ll,ll> pi;
typedef vector<pi> vpi;
typedef long double ld;
#define pb emplace_back
#define mp make_pair
#define lb lower_bound
#define ub upper_bound
#define ALL(x) x.begin(), x.end()
#define SZ(x) (ll)x.size()
#define f first
#define s second
#define MAXN 200100

pi t;
ll A[MAXN];
ll nearest[MAXN];
ll N,K;
ll done[MAXN];
vi V;

ll val(ll x, ll y){
	return A[x] + A[y] + K*abs(y-x);
}

int main(){
	cin>>N>>K;
	for (ll i=1;i<=N;++i)cin>>A[i];
	t = mp(1e18,-1);
	for (ll i=N;i>=1;--i){
		nearest[i] = t.s;
		if (K*i + A[i] < t.f){
			t = mp(K*i+A[i], i);
		}
	}
	ll cur = 1;
	V.pb(1);
	while (nearest[cur] != -1){
		done[cur] = 1;
		cur = nearest[cur];
		V.pb(cur);
	}
	done[cur] = 1;
	ll ans = 0;
	ll bestp = A[1] - K;

	for (ll i=1;i<SZ(V);++i){
		ans += bestp + V[i]*K + A[V[i]];
		// cout<<V[i]<<' '<<ans<<'\n';
		bestp = min(bestp, A[V[i]]-K*V[i]);
	}

	bestp = A[1] - K;
	for (ll i=0;i<SZ(V) - 1;++i){
		for (ll j=V[i]+1;j<V[i+1];++j){
			ans += min(bestp + j*K + A[j], val(V[i+1], j));
			bestp = min(bestp, A[j] - K*j);
		}
		bestp = min(bestp, A[V[i+1]]-K*V[i+1]);
	}
	cout<<ans;
}
