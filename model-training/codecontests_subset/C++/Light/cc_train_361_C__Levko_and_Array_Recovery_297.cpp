#include <bits/stdc++.h>
using namespace std;
const int INF = 1000000000;
const double eps = 1e-8;
const int maxn = 6000;
int ans[maxn];
int op[maxn];
int a[maxn];
int b[maxn];
int c[maxn];
int ans1[maxn];
int sum[maxn];
int main() {
  int n, m;
  while (cin >> n >> m) {
    memset(sum, 0, sizeof(sum));
    for (int i = (1); i <= (n); ++i) ans[i] = INF;
    for (int i = (1); i <= (m); ++i)
      scanf("%d%d%d%d", &op[i], &a[i], &b[i], &c[i]);
    int flag = 1;
    for (int i = (1); i <= (m); ++i) {
      if (op[i] == 1) {
        for (int j = (a[i]); j <= (b[i]); ++j) sum[j] += c[i];
      }
      if (op[i] == 2) {
        for (int j = (a[i]); j <= (b[i]); ++j) {
          ans[j] = min(ans[j], c[i] - sum[j]);
        }
      }
    }
    for (int i = (1); i <= (n); ++i) ans1[i] = ans[i];
    for (int i = (1); i <= (m); ++i) {
      if (op[i] == 1) {
        for (int j = (a[i]); j <= (b[i]); ++j) ans[j] += c[i];
      }
      if (op[i] == 2) {
        int Max = -INF;
        for (int j = (a[i]); j <= (b[i]); ++j) Max = max(Max, ans[j]);
        if (Max == c[i])
          continue;
        else {
          flag = 0;
          break;
        }
      }
    }
    if (flag) {
      cout << "YES" << endl;
      for (int i = (1); i <= (n); ++i) cout << ans1[i] << " ";
      cout << endl;
    } else
      cout << "NO" << endl;
  }
  return 0;
}
