#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e2 + 10;
vector<int> del, add;
int n, k, dp[maxn][maxn], pre[maxn][maxn];
struct minion {
  int a, b, id;
  bool operator<(const minion &A) const { return b == A.b ? a < A.a : b < A.b; }
  void read(int i) {
    id = i;
    scanf("%d%d", &a, &b);
  }
} da[maxn];
int main() {
  int t;
  scanf("%d", &t);
  while (t--) {
    scanf("%d%d", &n, &k);
    for (int i = 1; i <= n; ++i) da[i].read(i);
    sort(da + 1, da + n + 1);
    for (int i = 0; i <= n; ++i)
      for (int j = 0; j <= n; ++j) dp[i][j] = -1;
    dp[0][0] = 0;
    add.clear();
    del.clear();
    for (int i = 0; i < n; ++i)
      for (int j = 0; j <= k; ++j)
        if (dp[i][j] >= 0) {
          if (dp[i + 1][j] < dp[i][j]) {
            dp[i + 1][j] = dp[i][j];
            pre[i + 1][j] = 0;
          }
          if (j < k &&
              dp[i + 1][j + 1] < dp[i][j] + da[i + 1].a + da[i + 1].b * j) {
            dp[i + 1][j + 1] = dp[i][j] + da[i + 1].a + da[i + 1].b * j;
            pre[i + 1][j + 1] = 1;
          }
          if (dp[i + 1][j] < dp[i][j] + da[i + 1].b * (k - 1)) {
            dp[i + 1][j] = dp[i][j] + da[i + 1].b * (k - 1);
            pre[i + 1][j] = 2;
          }
        }
    for (int i = n, j = k; i; --i) {
      if (!pre[i][j]) continue;
      if (pre[i][j] == 1) {
        --j;
        add.push_back(da[i].id);
      } else {
        del.push_back(da[i].id);
      }
    }
    printf("%d\n", add.size() + del.size() * 2);
    for (int i = add.size() - 1; i; --i) printf("%d ", add[i]);
    for (auto x : del) printf("%d %d ", x, -x);
    printf("%d\n", add[0]);
  }
  return 0;
}
