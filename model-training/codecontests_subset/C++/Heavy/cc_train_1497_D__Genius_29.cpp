#include<bits/stdc++.h>
using namespace std;

#define rep(i, a, n) for(int i=(a); i<(n); ++i)
#define per(i, a, n) for(int i=(a); i>(n); --i)
#define pb emplace_back
#define mp make_pair
#define clr(a, b) memset(a, b, sizeof(a))
#define all(x) (x).begin(),(x).end()
#define lowbit(x) (x & -x)
#define fi first
#define se second
#define lson o<<1
#define rson o<<1|1
#define gmid l[o]+r[o]>>1

using LL = long long;
using ULL = unsigned long long;
using pii = pair<int,int>;
using PLL = pair<LL, LL>;
using UI = unsigned int;

const int mod = 1e9 + 7;
const int inf = 0x3f3f3f3f;
const double EPS = 1e-8;
const double PI = acos(-1.0);

const int N = 5010;

int T, n, a[N], b[N];
LL dp[2][N], mx[N], g[N];

int main(){
	LL ans, cur;
	scanf("%d", &T);
	while(T--){
		scanf("%d", &n);
		rep(i, 1, n+1)	scanf("%d", a+i);
		rep(i, 1, n+1)	scanf("%d", b+i);

		if(n == 1){
			puts("0");
			continue;
		}

		rep(i, 0, n+1){
			dp[0][i] = dp[1][i] = -1;
			g[i] = -1;
		}

		ans = 0;

		rep(i, 1, n+1){
			rep(j, 1, n+1)	dp[1][j] = -1;

			dp[1][i] = 0;
			mx[i] = 0;

			if(i == 1){
				swap(dp[0], dp[1]);
				continue;
			}

			per(j, i-1, 0){
				if(a[i] != a[j]){
					dp[1][j] = max(dp[1][j], mx[j] + abs(b[j] - b[i]));
					if(j < i - 1)	dp[1][j] = max(dp[1][j], g[j] + abs(b[j] - b[i]));
				}
			}

			swap(dp[0], dp[1]);

			rep(j, 1, i)	mx[i] = max(mx[i], dp[0][j]);

			ans = max(ans, mx[i]);

			cur = dp[0][i];

			per(j, i-1, 0){
				if(a[i] != a[j]){
					g[j] = max(g[j], cur + abs(b[i] - b[j]));
					ans = max(ans, g[j]);
				}
				cur = max(cur, dp[0][j]);
			}
		}

		printf("%lld\n", ans);
	}
	return 0;
}