//go to line 54 for some useful code.
#include <bits/stdc++.h>
using namespace std;
#ifdef LOCAL
#include "debug.hpp"
#else 
#define dbg(...) 47
#define dbgm(...) 47
#endif
// refer https://codeforces.com/blog/entry/66279
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
#pragma GCC optimization("unroll-loops")
//refer-> https://codeforces.com/blog/entry/62393 
struct custom_hash {
   static uint64_t splitmix64(uint64_t x) {
       // http://xorshift.di.unimi.it/splitmix64.c
       x += 0x9e3779b97f4a7c15;
       x = (x ^ (x >> 30)) * 0xbf58476d1ce4e5b9;
       x = (x ^ (x >> 27)) * 0x94d049bb133111eb;
       return x ^ (x >> 31);
   }
   size_t operator()(uint64_t x) const {
       static const uint64_t FIXED_RANDOM = chrono::steady_clock::now().time_since_epoch().count();
       return splitmix64(x + FIXED_RANDOM);
   }
};
typedef long long ll;
typedef unsigned long int ul;
typedef unsigned long long int ull;
typedef unsigned int ui;
typedef long double ld;
typedef pair<ll, ll> pll;
typedef vector<vector<ll>> matrix;
typedef vector<ll> vll;
typedef vector<int> vii;
typedef unordered_map<int,int, custom_hash> umap;
typedef unordered_set<int, custom_hash>uset;
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
#define fast_io() ios_base::sync_with_stdio(0);cin.tie(0);cout.tie(0)
#define oo INT64_MAX
ll const mran = 2e5+10;
ll const mod = 1e9+7;
// write your code here....
ll dp[mran][10];
void inline add(ll &a, ll b){
	a+=b;
	a%=mod;
}
void pre(){
	f(j, 0, 10)dp[0][j] =1;
	f(i, 1, mran){
		f(j, 0, 10){
			if(j<9) dp[i][j] = dp[i-1][j+1];
			else dp[i][j] = (dp[i-1][1]+dp[i-1][0])%mod;
		}
	}
}
void solve(){
	int n, m;
	cin>>n>>m;
	ll ans =0;
	while(n>0){
		int x = n%10;
		add(ans, dp[m][x]);
		n/=10;
	}
	cout<<ans<<endl;
}
int main()
{
	fast_io();
	cerr << "...............Console is yours! :)................." << endl;
	int T;
	cin>>T;
	int O = T;
	pre();
	while(T--){
		solve();
	}
	cerr<<".......^_^........."<<endl;
	return 0;
}
