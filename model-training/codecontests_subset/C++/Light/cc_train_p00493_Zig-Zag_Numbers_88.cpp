#include <iostream>
#include <string>
#include <cstdlib>
#include <cmath>
#include <vector>
#include <unordered_map>
#include <map>
#include <set>
#include <algorithm>
#include <queue>
#include <stack>
#include <functional>
#include <bitset>
#include <assert.h>
#include <unordered_map>
#include <fstream>
using namespace std;
typedef long long ll;
typedef vector<ll> vl;
typedef vector<vl> vvl;
typedef vector<char> vc;
typedef vector<string> vs;
typedef vector<bool> vb;
typedef vector<double> vd;
typedef pair<ll,ll> P;
typedef pair<int,int> pii;
typedef vector<P> vpl;
typedef tuple<ll,ll,ll> tapu;
#define rep(i,n) for(int i=0; i<(n); i++)
#define REP(i,a,b) for(int i=(a); i<(b); i++)
#define all(x) (x).begin(), (x).end()
#define rall(x) (x).rbegin(), (x).rend()
const int inf = 1<<30;
const ll linf = 1LL<<62;
const int MAX = 510000;
ll dy[8] = {1,-1,0,0,1,-1,1,-1};
ll dx[8] = {0,0,1,-1,1,-1,-1,1};
const double pi = acos(-1);
const double eps = 1e-7;
template<typename T1,typename T2> inline bool chmin(T1 &a,T2 b){
	if(a>b){
		a = b; return true;
	}
	else return false;
}
template<typename T1,typename T2> inline bool chmax(T1 &a,T2 b){
	if(a<b){
		a = b; return true;
	}
	else return false;
}
template<typename T> inline void print(T &a){
    rep(i,a.size()) cout << a[i] << " ";
    cout << "\n";
}
template<typename T1,typename T2> inline void print2(T1 a, T2 b){cout << a << " " << b << "\n";}
template<typename T1,typename T2,typename T3> inline void print3(T1 a, T2 b, T3 c){
	cout << a << " " << b << " " << c << "\n";
}
const int mod = 1e9 + 7;
//const int mod = 998244353;

int dp[505][505][10][3][2];
int m;
int M = 10000;

int solve(string s){
	int n = s.size();
	rep(i,n+1) rep(j,m) rep(k,10) rep(l,3) rep(o,2) dp[i][j][k][l][o] = 0;
	dp[0][0][0][1][0] = 1;
	rep(i,n){
		int c = s[i] - '0';
		rep(j,m){
			rep(k,10){
				rep(l,10){
					if(k+l == 0) dp[i+1][j][0][1][0] += dp[i][j][0][1][0];
					else if(l == 0){
						if(i == 0){
							if(k <= c) dp[i+1][(j*10+k)%m][k][1][(k<c)] += dp[i][j][0][1][0];
						}else{
							dp[i+1][(j*10+k)%m][k][1][1] += dp[i][j][0][1][0];
						}
					}else{
						if(k==l) continue;
						if(k<c) rep(o,2) dp[i+1][(j*10+k)%m][k][(k<l)*2][1] += dp[i][j][l][1][o];
						else if(k==c) rep(o,2) dp[i+1][(j*10+k)%m][k][(k<l)*2][o] += dp[i][j][l][1][o];
						else dp[i+1][(j*10+k)%m][k][(k<l)*2][1] += dp[i][j][l][1][1];
					}
					if(k == l) continue;
					if(k<c) rep(o,2) dp[i+1][(j*10+k)%m][k][(k<l)*2][1] += dp[i][j][l][(k>l)*2][o];
					else if(k==c) rep(o,2) dp[i+1][(j*10+k)%m][k][(k<l)*2][o] += dp[i][j][l][(k>l)*2][o];
					else dp[i+1][(j*10+k)%m][k][(k<l)*2][1] += dp[i][j][l][(k>l)*2][1];
					rep(o,3) rep(p,2) dp[i+1][(j*10+k)%m][k][o][p] %= M;
				}
			}
		}
	}
	ll ans = 0;
	rep(i,10) rep(j,3) rep(k,2){
		ans += dp[n][0][i][j][k];
		ans %= M;
	}
	ans = (ans - 1 + M) % M;
	return ans;
}

int main(){
	string a,b; cin >> a >> b;
	cin >> m;
	if(a.back() != '0') a.back()--;
	else{
		for(ll i=a.size()-1; i>=0; i--){
			if(a[i] != '0'){
				a[i]--;
				break;
			}
			a[i] = '9';
		}
		if(a[0] == '0') a.erase(a.begin());
	}
	cout << (solve(b) - solve(a) + M) % M << "\n";
}
