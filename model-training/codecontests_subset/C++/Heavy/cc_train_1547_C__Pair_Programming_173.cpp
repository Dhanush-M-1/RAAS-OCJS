#include <bits/stdc++.h>
using namespace std;
#define endl '\n'
template<class A, class B>void tostring(pair<A, B>p) { cerr<<"(" + to_string(p.first) + ", " + to_string(p.second) + ")";}
template<class A>void tostring(A v) {int f = 1;string r = "{";for (auto& x : v) {if (!f) {r += ", ";}f = 0;r += to_string(x);}r += "}\n";cerr<<r;}
void _out() { cerr << endl; }template<typename H, typename... T> void _out(H h, T... t) { cerr << ' ' << h; _out(t...); }
void show() { cerr << endl; }template<typename H, typename... T> void show(H h, T... t) { cerr<<h<<' '; show(t...); }
#define see(...) cerr << "(" << #__VA_ARGS__ << "):", _out(__VA_ARGS__)
#define rep(i, l, r) for(int i=(int)(l);i<=(int)(r);i++)
#define per(i, r, l) for(int i=(int)(r);i>=(int)(l);i--)
#define all(x) (x).begin(), (x).end()
#define all1(x) (x).begin()+1, (x).end()
#define pb push_back
#define ub upper_bound
#define lb lower_bound
#define int long long
typedef pair<int, int> pii; typedef vector<int> vi; typedef vector<vi> vvi; typedef vector<pii> vp; typedef vector<vp> vvp;
#define fi first
#define se second
//const int N = 1e5+100;
//const int mod=1e9+7;

void solve(int tase) {
	int k, n, m;cin >> k >> n >> m;
	vi a(n+2),b(m+2);
	rep(i,1,n)cin >> a[i];
	rep(i,1,m)cin >> b[i];
	
	bool f = 1;
	
	int i = 1, j = 1;
	vi ans;
	
	while(i<=n||j<=m){
		while(i<=n&&a[i]==0){
			i ++;
			ans.pb(0);
			k ++;
		}
		while(j<=m&&b[j]==0){
			j ++;
			ans.pb(0);
			k ++;
		}
		
		if(i>n && j>m)break; 
		if(i<=n && a[i] > k && (j>m)){
			f = 0;break;
		}
		if(j<=m && b[j] > k && (i>n)){
			f = 0;break;
		}
		if(i<=n&&a[i]>k&&j<=m&&b[j]>k){
			f = 0;break;
		}
		
		int ii = i;
		rep(t,ii,n){
			if((a[t]!=0) && a[t]<=k){
				ans.pb(a[t]);i ++;
			}
			else break;
		}
		int jj = j;
		rep(t,jj,m){
			if((b[t]!=0) && b[t]<=k){
				ans.pb(b[t]);j ++;
			}
			else break;
		}
	}
	
	if(!f)cout << -1 << endl;
	else {
		for(auto i : ans) cout << i << ' ';
		cout << endl;
	}
}

signed main() {
	ios::sync_with_stdio(0); cin.tie(0);
#ifndef ONLINE_JUDGE 
	freopen("E:\\in.txt", "r", stdin);
#endif
	int T; cin >> T; rep(i, 1, T) solve(i);
}