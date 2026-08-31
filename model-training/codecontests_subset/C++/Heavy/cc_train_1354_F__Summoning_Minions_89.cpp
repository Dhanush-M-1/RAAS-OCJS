#include <bits/stdc++.h>
using namespace std;
using lld = long long;
const int INF = 1e9;
const int MAXN = 75;
struct Minion {
  int a, b;
  int nr;
};
bool operator<(const Minion& a, const Minion& b) {
  if (a.b != b.b) return a.b < b.b;
  return a.nr < b.nr;
}
int dp[MAXN + 5][MAXN + 5];
void query(void) {
  int n, k;
  cin >> n >> k;
  vector<Minion> t(n);
  for (int i = 0; i < n; i++) {
    cin >> t[i].a >> t[i].b;
    t[i].nr = i + 1;
  }
  sort(t.begin(), t.end());
  for (int i = 0; i <= n; i++)
    for (int j = 0; j <= k; j++) dp[i][j] = -INF;
  dp[0][0] = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j <= k; j++)
      dp[i + 1][j] = max(dp[i + 1][j], dp[i][j] + t[i].b * (k - 1));
    for (int j = 1; j <= k; j++)
      dp[i + 1][j] =
          max(dp[i + 1][j], dp[i][j - 1] + t[i].a + t[i].b * (j - 1));
  }
  vector<int> res, rem;
  int x = n, y = k;
  while (x > 0) {
    if (y > 0 &&
        dp[x][y] == dp[x - 1][y - 1] + t[x - 1].a + t[x - 1].b * (y - 1)) {
      res.push_back(t[x - 1].nr);
      x--, y--;
    } else {
      rem.push_back(t[x - 1].nr);
      x--;
    }
  }
  reverse(res.begin(), res.end());
  cout << 2 * n - k << "\n";
  for (int i = 0; i < k - 1; i++) cout << res[i] << " ";
  for (int i : rem) cout << i << " " << -i << " ";
  cout << res.back() << "\n";
}
int main(void) {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  int q;
  cin >> q;
  while (q--) query();
  return 0;
}
