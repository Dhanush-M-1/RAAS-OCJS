#include <bits/stdc++.h>
using namespace std;
static const int INF = 0x3f3f3f3f;
static const long long INFL = 0x3f3f3f3f3f3f3f3fLL;
template <typename T, typename U>
static void amin(T &x, U y) {
  if (y < x) x = y;
}
template <typename T, typename U>
static void amax(T &x, U y) {
  if (x < y) x = y;
}
int main() {
  int n;
  while (~scanf("%d", &n)) {
    vector<int> a(n);
    for (int i = 0; i < n; ++i) scanf("%d", &a[i]);
    vector<int> b(n);
    for (int i = 0; i < n; ++i) scanf("%d", &b[i]);
    int S = accumulate(a.begin(), a.end(), 0);
    vector<vector<int> > dp(n + 1, vector<int>(S + 1, INF));
    const int Base = (int)1e5;
    dp[0][0] = 0;
    for (int(i) = 0; (i) < (int)(n); ++(i)) {
      for (int(j) = 0; (j) < (int)(S + 1); ++(j)) {
        int x = dp[i][j];
        if (x == INF) continue;
        amin(dp[i + 1][j], x + a[i]);
        amin(dp[i + 1][min(S, j + b[i])], x + Base);
      }
    }
    int ans = dp[n][S];
    printf("%d %d\n", ans / Base, ans % Base);
  }
  return 0;
}
