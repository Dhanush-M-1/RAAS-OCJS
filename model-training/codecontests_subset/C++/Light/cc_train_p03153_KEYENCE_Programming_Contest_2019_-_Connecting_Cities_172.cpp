#include<bits/stdc++.h>
#define rep(i, n) for(int i = 0; i < n; i++)
using namespace std;
typedef long long ll;
ll qmin(ll a, ll b){
	return (a < b) ? a : b;
}

ll n, d;
ll a[200200];
vector< pair< ll, pair<ll, ll> > > edge;

void solve(int l, int r){
	if(l >= r) return ;
	int mid = (l+r) >> 1;
	solve(l, mid);
	solve(mid+1, r);
	int mnpos1 = l;
	for(int i = l; i <= mid; i++){
		if(a[i] + (mid - i) * d < a[mnpos1] + (mid - mnpos1) * d) mnpos1 = i;
	}
	ll mnpos2 = mid+1;
	for(int i = mid+1; i <= r; i++){
		if(a[i] + (i - mid) * d < a[mnpos2] + (mnpos2 - mid) * d) mnpos2 = i;
	}
	for(int i = l; i <= mid; i++) edge.push_back(make_pair(a[mnpos2] + a[i] + (mnpos2 - i) * d, make_pair(i, mnpos2)));
	for(int i = mid+1; i <= r; i++) edge.push_back(make_pair(a[i] + a[mnpos1] + (i - mnpos1) * d, make_pair(i, mnpos1)));
}

int par[200200];
int get_par(int now){
	return par[now] = ((par[now] == now) ? now : get_par(par[now]));
}
void unite(int a, int b){
	par[get_par(a)] = get_par(b);
}
ll ans = 0;

int main(){
	scanf("%lld%lld", &n, &d);
	rep(i, n) par[i] = i;
	rep(i, n) scanf("%lld", &a[i]);
	solve(0, n-1);
	sort(edge.begin(), edge.end());
	rep(i, edge.size()){
		if(get_par(edge[i].second.first) != get_par(edge[i].second.second)){
			ans += edge[i].first;
			unite(edge[i].second.first, edge[i].second.second); 
		}
	}
	cout << ans << endl;
	return 0;
}