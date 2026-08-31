//goto line 42 for some useful code
#include <bits/stdc++.h>
using namespace std;
#ifdef LOCAL
#include "debug.hpp"
#else 
#define dbg(...) 47
#endif
// speed up hacks does not work with MSVC compilers
// refer https://codeforces.com/blog/entry/66279
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
#pragma GCC optimization("unroll-loops")
//  ..........................
 
typedef long long ll;
typedef unsigned long int ul;
typedef unsigned long long int ull;
typedef unsigned int ui;
typedef long double ld;
 
typedef pair<ll, ll> pll;
typedef vector<vector<ll>> matrix;
typedef vector<ll> vll;
 
#define f(i, x, n) for (int i = x; i < n; i++)
#define rf(i, n, x) for(int i=n;i>=x;--i)
#define all(x) (x).begin(), (x).end()
#define rall(x) (x).rbegin(), (x).rend()
#define F first
#define S second
#define pb push_back
#define endl "\n"
#define unique(v) v.erase(unique(v.begin(), v.end()), v.end());
#define mem(a, b) memset(a, b, sizeof(a))
#define fast_io()               \
	ios_base::sync_with_stdio(0); \
	cin.tie(0);                   \
	cout.tie(0)
 
const ll mod = 1e9+7;
const ll oo = INT64_MAX;
const int ran = 2e5+5;
//* for other functions and declarations .......
vector<int>parent, a;
vector<int> ans;
int root(int x){
	while(a[x] != x){
		a[x] = a[a[x]];
		x = a[x];
	}
	return x;
}
void uni(int x, int y){
	int p = root(x);
	int q = root(y);
	if(p<q) a[q] = p;
	else a[p] = q;
}
void solve(){	
	int n,m;
	cin>>n>>m;
	a.resize(m+1);
	for(int i=0;i<m+1;++i) a[i] = i;
	vector<vector<int>> inp(n);
	ll cnt = 1;
	f(i, 1, n+1){
		int k;
		cin>>k;
		int x, y=0;
		cin>>x;
		if(k ==2)cin>>y;
		int rx = root(x);
		int ry = root(y);
		if(rx == ry)continue;
		ans.pb(i);
		uni(x, y);
		cnt<<=1;
		cnt%=mod;
	}
	cout<<cnt<<" "<<ans.size()<<endl;
	for(auto &aa:ans)cout<<aa<<" ";
	cout<<endl;
}
int main()
{
	fast_io();
	cerr << "...............Console is yours! :)................." << endl;
	solve();
	cerr<<"......^_^....."<<endl;
	return 0;
}
