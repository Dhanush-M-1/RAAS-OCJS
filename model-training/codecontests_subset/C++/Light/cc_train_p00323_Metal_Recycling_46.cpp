#include <bits/stdc++.h>
  
using namespace std;
  
#define rep(i,n) REP(i,0,n)
#define REP(i,s,e) for(int i=(s); i<(int)(e); i++)
#define pb push_back
#define all(r) (r).begin(),(r).end()
#define rall(r) (r).rbegin(),(r).rend()
#define fi first
#define se second
  
typedef long long ll;
typedef vector<int> vi;
typedef vector<ll> vl;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;
 
const int INF = 1e9;
const ll LINF = 1e18;
const ll MOD = 1e9 + 7;
double EPS = 1e-8;

int main(){
	int n;
	cin>>n;
	map<int, int> m;
	rep(i, n) {
		int a, b;
		cin>>a>>b;
		m[a+b]++;
	}
	bool update = true;
	while(update) {
		update = false;
		map<int, int> _m;
		for(auto& p : m) {
			if(p.se > 1) _m[p.fi +1] += p.se/2, _m[p.fi] += p.se % 2, update = true;
			else _m[p.fi] += p.se;
		}
		m = _m;
	}
	for(auto& p : m) {
		if(p.se > 0) cout<<p.fi<<" "<<0<<endl;
	}
}