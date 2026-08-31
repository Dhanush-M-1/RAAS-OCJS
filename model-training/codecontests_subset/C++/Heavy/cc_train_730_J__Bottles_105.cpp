#include <bits/stdc++.h>
using namespace std;
const int maxn = (1 << 17) + 10;
const int inf = 0x3f3f3f3f;
const long long linf = 0x3f3f3f3f3f3f3f3f;
int n;
struct NODE {
  int a, b;
} node[110];
bool cmp(NODE x, NODE y) { return x.b > y.b; }
int dp[2][110][10010], sum[110];
int main() {
  ios_base::sync_with_stdio(false);
  cin >> n;
  int tot = 0, cnt = 0, tmp = 0;
  for (int i = 1; i <= n; i++) {
    cin >> node[i].a;
    tot += node[i].a;
  }
  for (int i = 1; i <= n; i++) {
    cin >> node[i].b;
  }
  if (n == 1) {
    cout << 1 << " " << 0 << endl;
    return 0;
  }
  sort(node + 1, node + 1 + n, cmp);
  for (int i = 1; i <= n; i++) {
    tmp += node[i].b;
    cnt++;
    if (tmp >= tot) break;
  }
  sum[0] = 0;
  for (int i = 1; i <= n; i++) {
    sum[i] = sum[i - 1] + node[i].a;
  }
  memset(dp, -inf, sizeof(dp));
  dp[0][0][0] = dp[1][0][0] = 0;
  int t = 0;
  for (int i = 1; i <= n; i++, t = t ^ 1) {
    for (int j = 1; j <= i && j <= cnt; j++) {
      for (int k = 0; k <= sum[i]; k++) {
        dp[t][j][k] = dp[t ^ 1][j][k];
        if (k >= node[i].a) {
          dp[t][j][k] =
              max(dp[t][j][k], dp[t ^ 1][j - 1][k - node[i].a] + node[i].b);
        }
      }
    }
  }
  for (int i = tot; i >= 0; i--) {
    if (dp[t ^ 1][cnt][i] >= tot) {
      cout << cnt << " " << tot - i << endl;
      break;
    }
  }
  return 0;
}
