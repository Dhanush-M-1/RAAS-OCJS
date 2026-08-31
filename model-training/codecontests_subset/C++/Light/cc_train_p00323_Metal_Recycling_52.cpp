#include "bits/stdc++.h"
using namespace std;

//#define int long long
#define DBG 1
#define dump(o) if(DBG){cerr<<#o<<" "<<(o)<<" ";}
#define dumpl(o) if(DBG){cerr<<#o<<" "<<(o)<<endl;}
#define dumpc(o) if(DBG){cerr<<#o; for(auto &e:(o))cerr<<" "<<e;cerr<<endl;}
#define rep(i,a,b) for(int i=(a);i<(b);i++)
#define rrep(i,a,b) for(int i=(b)-1;i>=(a);i--)
#define all(c) begin(c),end(c)
const int INF = sizeof(int) == sizeof(long long) ? 0x3f3f3f3f3f3f3f3fLL : 0x3f3f3f3f;
const int MOD = (int)(1e9 + 7);
template<class T> bool chmax(T &a, const T &b) { if (a < b) { a = b; return true; } return false; }
template<class T> bool chmin(T &a, const T &b) { if (a > b) { a = b; return true; } return false; }
#define MAX 210000
signed main() {
	int N; cin >> N;
	int c[MAX] = {};
	rep(i, 0, N) {
		int a, b; cin >> a >> b;
		c[a + b]++;
	}
	rep(i, 0, MAX - 1) {
		c[i + 1] += c[i]/2;
		c[i] %= 2;
	}
	rep(i, 0, MAX) {
		if (c[i] == 0)continue;
		cout << i << " " << 0 << endl;
	}
	return 0;
}