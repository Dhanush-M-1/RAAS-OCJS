//#pragma GCC optimize(2)
// Happy TLE and WA every day!
// by: zxb the vegetable chicken
#include<bits/stdc++.h>
#define mp              make_pair
#define rep(i,n)        for(int i = 0; i < n; i++)
#define foreach(i,c)    for(VAR(i, (c).begin()); i != (c).end(); ++i)
#define BINF            0x7fffffff
#define INF             0x3f3f3f3f
#define LINF            4557430888798830399
#define pb              push_back
#define F               first
#define S               second
#define Time            clock()/CLOCKS_PER_SEC
#define read            ZXBs_fast_input
#define write           ZXBs_fast_output
#define int             long long
//#define usingFiles
using namespace std;

typedef unsigned int ui;
typedef pair<int, int> pii;
typedef long long ll;

inline bool read(int& x){
	x = 0;
	int c;
	int sign = 1;
	while( (c = getchar()) < '0' || c > '9' ) if(c == '-') sign = -1;
	x = c ^ '0';
	while( (c = getchar()) >= '0' && c <= '9' ) x = (x<<3) + (x<<1) + (c ^ '0');
	x *= sign;
	return 1;
}

inline bool write(int x){
	if(x >= 10) write(x / 10);
	putchar(x % 10 + '0');
	return 1;
}

const int rp = 666666;
const bool debug = 1;
const bool I_good_vegetable_a = 1;

int n, d;
int a[200200];
int dpL[200200];
int dpR[200200];

signed main(){
	ios::sync_with_stdio(false);
	#ifdef usingFiles
		freopen("input.txt", "r", stdin);
		freopen("output.txt", "w", stdout);
	#endif
	cin >> n >> d;
	rep(i, n) cin >> a[i];
	int res = d * (n - 1);
	rep(i, n) res += a[i];
	dpL[0] = a[0];
	for(int i = 1; i < n; i++){
		dpL[i] = min(a[i], dpL[i - 1] + d);
	}
	dpR[n - 1] = a[n - 1];
	for(int i = n - 2; i >= 0; i--){
		dpR[i] = min(a[i], dpR[i + 1] + d);
	}
	for(int i = 1; i < n - 1; i++){
		res += min(dpL[i], dpR[i]);
	}
	cout << res << endl;
	return 0;
}