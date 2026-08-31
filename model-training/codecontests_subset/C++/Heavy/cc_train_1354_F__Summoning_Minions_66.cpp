#include <bits/stdc++.h>
using namespace std;
const int maxn = 100 + 5;
struct node {
  long long x, y;
  int id;
  bool operator<(const node &ope) const { return y < ope.y; }
} a[maxn];
bool vis[maxn][maxn];
long long dp[maxn][maxn];
bool vis2[maxn];
inline void init() {
  memset(dp, -1, sizeof(dp));
  memset(vis, false, sizeof(vis));
  memset(vis2, false, sizeof(vis2));
}
void solve(int n, int k) {
  init();
  dp[0][0] = 0;
  sort(a + 1, a + 1 + n);
  for (int i = 1; i <= n; ++i) {
    int t = ((i) < (k) ? (i) : (k));
    for (int j = 0; j <= t; ++j) {
      if (dp[i - 1][j] >= 0) dp[i][j] = dp[i - 1][j] + (k - 1) * 1ll * a[i].y;
      if (j > 0 && dp[i - 1][j - 1] >= 0) {
        if (dp[i][j] >= dp[i - 1][j - 1] + a[i].x + (j - 1) * 1ll * a[i].y)
          continue;
        dp[i][j] = dp[i - 1][j - 1] + a[i].x + (j - 1) * 1ll * a[i].y;
        vis[i][j] = true;
      }
    }
  }
}
void print(int n, int k) {
  printf("%d\n", k + (n - k) * 2);
  for (int i = n, j = k; i > 0 && j >= 0; --i) {
    if (vis[i][j]) vis2[i] = true, --j;
  }
  int t = 0;
  for (int i = 1; i <= n; ++i) {
    if (!vis2[i]) continue;
    if (++t == k) {
      t = a[i].id;
      break;
    }
    printf("%d ", a[i].id);
  }
  for (int i = 1; i <= n; ++i) {
    if (!vis2[i]) printf("%d %d ", a[i].id, -a[i].id);
  }
  printf("%d\n", t);
}
int main() {
  int T;
  scanf("%d", &T);
  while (T--) {
    int n, k;
    scanf("%d%d", &n, &k);
    for (int i = 1; i <= n; ++i) {
      scanf("%lld%lld", &a[i].x, &a[i].y);
      a[i].id = i;
    }
    solve(n, k);
    print(n, k);
  }
  return 0;
}
