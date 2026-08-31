#include <bits/stdc++.h>
using namespace std;
struct pt {
  int a, b, ind;
  pt() {}
  pt(int a, int b, int ind) : a(a), b(b), ind(ind) {}
};
const int inf = 1e9;
int n, k;
void solve(int tc) {
  scanf("%d", &n);
  scanf("%d", &k);
  vector<pt> ar(n);
  for (int i = 0; i < n; ++i) {
    int a, b;
    scanf("%d", &a);
    scanf("%d", &b);
    ar[i] = pt(a, b, i + 1);
  }
  sort(ar.begin(), ar.end(), [](pt &x, pt &y) -> bool {
    if (x.b == y.b) return x.a < y.a;
    return x.b < y.b;
  });
  vector<vector<int> > dp(n + 1, vector<int>(k + 1, -inf));
  vector<vector<int> > trace(n + 1, vector<int>(k + 1, -1));
  dp[0][0] = 0;
  for (int i = 1; i <= n; ++i) {
    for (int j = 0; j <= min(k, n); ++j) {
      if (j > 0 and
          dp[i][j] < dp[i - 1][j - 1] + ar[i - 1].a + (j - 1) * ar[i - 1].b) {
        dp[i][j] = dp[i - 1][j - 1] + ar[i - 1].a + (j - 1) * ar[i - 1].b;
        trace[i][j] = 1;
      }
      if (dp[i][j] < dp[i - 1][j] + (k - 1) * ar[i - 1].b) {
        dp[i][j] = dp[i - 1][j] + (k - 1) * ar[i - 1].b;
        trace[i][j] = 0;
      }
    }
  }
  int moves = 2 * n - k;
  cout << moves << "\n";
  vector<int> ans[2];
  while (n > 0) {
    assert(trace[n][k] != -1);
    int p = trace[n][k];
    ans[p].emplace_back(ar[n - 1].ind);
    k -= p;
    --n;
  }
  reverse(ans[1].begin(), ans[1].end());
  reverse(ans[0].begin(), ans[0].end());
  for (int i = 0; i < (int)ans[1].size() - 1; ++i) {
    cout << ans[1][i] << " ";
  }
  for (int it : ans[0]) {
    cout << it << " " << -it << " ";
  }
  cout << ans[1].back() << "\n";
}
int main() {
  int tt = 1;
  scanf("%d", &tt);
  for (int i = 1; i <= tt; ++i) {
    solve(i);
  }
  return 0;
}
