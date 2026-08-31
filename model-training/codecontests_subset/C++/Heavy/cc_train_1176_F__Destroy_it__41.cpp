#include <bits/stdc++.h>
using namespace std;
const long long inf = 10000000000000000ll;
int n;
long long f[4][2], dp[200009][10];
vector<long long> c[4];
bool cmp(long long i, long long j) { return i > j; }
int main() {
  scanf("%d", &n);
  memset(dp, -0x3f, sizeof(dp));
  dp[0][0] = 0;
  for (int i = 1; i <= n; ++i) {
    int m, x, y;
    scanf("%d", &m);
    for (int j = 1; j <= 3; ++j) c[j].clear();
    for (int j = 1; j <= m; ++j) {
      scanf("%d%d", &x, &y);
      c[x].push_back(1ll * y);
    }
    for (int j = 1; j <= 3; ++j) sort(c[j].begin(), c[j].end(), cmp);
    memset(f, -0x3f, sizeof(f));
    if (c[3].empty()) c[3].push_back(-inf);
    if (c[2].empty()) c[2].push_back(-inf);
    while (c[1].size() < 3) c[1].push_back(-inf);
    f[1][0] = max(c[3][0], max(c[2][0], c[1][0]));
    f[1][1] = max(c[3][0], max(c[2][0], c[1][0])) << 1;
    f[2][0] = max(c[2][0] + c[1][0], c[1][0] + c[1][1]);
    f[2][1] = max(max(c[2][0], c[1][0]) * 2 + min(c[2][0], c[1][0]),
                  c[1][0] * 2 + c[1][1]);
    f[3][0] = c[1][0] + c[1][1] + c[1][2];
    f[3][1] = c[1][0] * 2 + c[1][1] + c[1][2];
    f[0][0] = 0;
    for (int mod = 0; mod <= 9; ++mod) {
      for (int j = 0; j <= 3; ++j) {
        int nex = (mod + j) % 10, flag = 0;
        if (nex < mod) flag = 1;
        dp[i][nex] = max(dp[i][nex], dp[i - 1][mod] + f[j][flag]);
      }
    }
  }
  long long ans = 0;
  for (int i = 0; i < 10; ++i) ans = max(ans, dp[n][i]);
  printf("%lld\n", ans);
  return 0;
}
