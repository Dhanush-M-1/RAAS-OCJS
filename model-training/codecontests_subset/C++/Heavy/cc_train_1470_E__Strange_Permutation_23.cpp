#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

int main() {
	int t;
	cin >> t;
	
	while (t--) {
		int n, c, q;
		scanf("%d %d %d", &n, &c, &q);
		
		vector<int> p(n + 1);
		for (int i = 1; i <= n; i++) scanf("%d", &p[i]);
		
		vector<vector<ll>> tot(n + 2, vector<ll>(c + 1, 1));
		vector<vector<vector<ll>>> dp(n + 1, vector<vector<ll>>(c + 1, {0, 0}));
		
		for (int i = n; i >= 1; i--) {
			for (int _c = 0; _c <= c; _c++) {
				tot[i][_c] = tot[i + 1][_c];
				for (int len = 1; len <= _c && i + len <= n; len++) {
					tot[i][_c] += tot[i + len + 1][_c - len];
				}
			}
		}
		
		for (int i = n - 1; i >= 1; i--) {
			for (int _c = 0; _c <= c; _c++) {
				dp[i][_c] = dp[i + 1][_c];
				for (int len = 1; len <= _c && i + len <= n; len++) {
					int d = p[i] < p[i + len];
					dp[i][_c][d] += tot[i + len + 1][_c - len];
				}
			}
		}
		
		while (q--) {
			int pos;
			ll rank;
			scanf("%d %lld", &pos, &rank);
			
			if (tot[1][c] < rank) {
				puts("-1");
				continue;
			}
			
			int at = 1;
			int _c = c;
			
			while (true) {
				assert(at <= pos);
				int d = dp[at][_c][0] < rank - 1;
				ll diff = abs(dp[at][_c][0] - (rank - 1));
				int L = at, R = n + 1;
				while (L != R) {
					int mid = (L + R + 1) / 2;
					if (mid > n || dp[mid][_c][d] >= diff) L = mid;
					else R = mid - 1;
				}
				
				int to = L;
				// debug() << name(at) name(to) name(rank) name(diff) name(tot[at][_c]) name(dp[at][_c][0]);
				if (pos < to) {
					printf("%d\n", p[pos]);
					break;
				} else {
					assert(to < n);
					vector<pair<int, ll>> v{{0, dp[to + 1][_c][d]}};
					for (int len = 1; len <= _c && to + len <= n; len++) {
						if ((p[to] < p[to + len]) == d) {
							v.push_back({len, tot[to + len + 1][_c - len]});
						}
					}
					sort(v.begin(), v.end(), [&p, to, d](const pair<int, ll>& p1, const pair<int, ll>& p2) {
						return (p[to + p1.first] < p[to + p2.first]) == d;
					});
					// debug() << name(v);
					int len;
					ll poss;
					for (int i = 0; ; i++) {
						assert(i < v.size());
						if (diff <= v[i].second) {
							len = v[i].first;
							poss = v[i].second;
							break;
						}
						diff -= v[i].second;
					}
					
					_c -= len;
					if (pos <= to + len) {
						int _pos = to + len - (pos - to);
						printf("%d\n", p[_pos]);
						break;
					}
					at = to + len + 1;
					rank = d == 1 ? diff : poss + 1 - diff;
				}
			}
		}
	}
	
	return 0;
}