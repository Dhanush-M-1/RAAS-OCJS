#include <bits/stdc++.h>
using namespace std;
int n, m, a[1005], nob[1005], off, dp[1005];
int main() {
  scanf("%d%d", &n, &m);
  for (int i = (1); i <= (n); i++) scanf("%d", &a[i]), nob[a[i]] = 1;
  dp[0] = 1;
  for (int i = (1); i <= (n); i++)
    if (!nob[i]) {
      int cnt = 0, x = i, f = 0;
      while (x) {
        if (f) ++off;
        if (x == m) f = 1;
        ++cnt;
        x = a[x];
      }
      if (!f) {
        for (int i = n; i >= cnt; i--) dp[i] |= dp[i - cnt];
      }
    }
  for (int i = (0); i <= (n); i++)
    if (dp[i]) printf("%d\n", i + off + 1);
}
