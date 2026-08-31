#include <bits/stdc++.h>
//#include <bits/extc++.h>
#define ll long long
#define ull unsigned ll
#define endl "\n"
#define pb push_back
#define ms(v,x) memset(v,x,sizeof(v))
#define ff first
#define ss second
#define td(v) v.begin(),v.end()
#define rep(i,a,n) for (int i=(a);i<(n);i++)
#define per(i,a,n) for (int i=(n-1);i>=a;i--)
#define trav(a, x) for(auto& a : x)
#define re(v) {for(auto &_re : v) cin >> _re;}
#define pr(v) {for(auto _pr : v) cout << _pr << " "; cout << endl;}
//#define sz(x) (int)(x).size()
#define all(x) x.begin(), x.end()
#define pii pair<int,int>
#define pll pair<ll,ll>
#define vi vector<int>
#define vl vector<ll>
#define eb emplace_back
using namespace std;
using vvi = vector<vi>;
using vvl = vector<vl>;
const ll M = 1e9 + 7;
//const ll M = 998244353;
//const ll M = 1e9 + 9;
//const ll M = 1e6;
#define tiii tuple<int,int,int>
mt19937_64 rng(chrono::steady_clock::now().time_since_epoch().count());
ll binpow(ll a, ll b){
	ll ret = 1;
	while(b){
		if(b & 1){
			ret = ret * a % M;
		}
		a = a * a % M;
		b >>= 1;
	}
	return ret;
}
void solve(){
	int n, m;
	cin >> n >> m;
	vi basis(m + 1);
	vi nxt(m + 1);
	iota(td(nxt), 0);
	function<int (int)> f = [&](int i){
		if(nxt[i] == i or nxt[i] == -1) return nxt[i];
		return nxt[i] = f(nxt[i]);
	};
	vector<vector<int>> vecs(n);
	vector<int> s;
	for(int i=0;i<n;i++){
		int k; cin >> k;
		vecs[i].resize(k);
		re(vecs[i]);
		sort(td(vecs[i]));
		// check if is represented
		int a = f(vecs[i][0]);
		int b = -1;
		if(k > 1) b = f(vecs[i][1]);
		if(a == b){
			continue;
		}
		if(a == -1){
			if(b == -1) continue;
			basis[b] = 1;
			s.eb(i);
			nxt[b] = -1;
		}
		else{
			basis[a] = i;
			s.eb(i);
			nxt[a] = b;
		}
	}
	cout << binpow(2, s.size()) << " " << s.size() << endl;
	for(int x : s) cout << x + 1 << " ";
	cout << endl;
}
int32_t main(){
  ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
  //freopen(".in", "r", stdin);
	//freopen(".out", "w", stdout);	
	int t = 1;
	//cin >> t;
	while(t--){
		solve();
	}
}