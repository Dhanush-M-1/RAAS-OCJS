#include <bits/stdc++.h>
using namespace std;
const long long maxn = 2e2 + 100;
const long long mod = 1e9 + 7;
const long long base = 1e18;
pair<pair<long long, long long>, long long> a[maxn];
long long dp[maxn][maxn];
bool par[maxn][maxn];
bool lf(pair<pair<long long, long long>, long long> a,
        pair<pair<long long, long long>, long long> b) {
  return a.first.second < b.first.second;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  if (fopen("TRIPLES.inp", "r")) {
    freopen("TRIPLES.inp", "r", stdin);
    freopen("TRIPLES.out", "w", stdout);
  }
  long long t;
  cin >> t;
  while (t--) {
    long long n, k;
    cin >> n >> k;
    for (int i = 1; i <= n; i++) {
      cin >> a[i].first.first >> a[i].first.second;
      a[i].second = i;
    }
    sort(a + 1, a + n + 1, lf);
    dp[0][0] = 0;
    for (int j = 1; j <= k; j++) dp[0][j] = -base;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= k; j++) {
        dp[i][j] = -base;
        if (j) {
          dp[i][j] = max(
              dp[i - 1][j - 1] + a[i].first.first + a[i].first.second * (j - 1),
              dp[i][j]);
          if (dp[i][j] == dp[i - 1][j - 1] + a[i].first.first +
                              a[i].first.second * (j - 1)) {
            par[i][j] = 1;
          }
        }
        dp[i][j] = max(dp[i][j], dp[i - 1][j] + (k - 1) * a[i].first.second);
        if (dp[i][j] == dp[i - 1][j] + (k - 1) * a[i].first.second) {
          par[i][j] = 0;
        }
      }
    }
    pair<long long, long long> nw = make_pair(n, k);
    vector<long long> vt;
    vector<long long> vt1;
    while (nw != make_pair(0ll, 0ll)) {
      auto p = nw;
      if (par[p.first][p.second])
        vt.push_back(a[p.first].second);
      else
        vt1.push_back(a[p.first].second);
      nw.second -= par[p.first][p.second];
      nw.first--;
    }
    cout << k + (n - k) * 2 << "\n";
    reverse(vt.begin(), vt.end());
    for (int i = 0; i < vt.size() - 1; i++) cout << vt[i] << " ";
    for (auto to : vt1) cout << to << " " << -to << " ";
    cout << vt.back() << " ";
    cout << "\n";
  }
}
