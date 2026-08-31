#include <bits/stdc++.h>
using namespace std;
int n, need, sum, ans;
int f[110][10010], a[110], b[110];
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    need += a[i];
  }
  for (int i = 1; i <= n; i++) {
    scanf("%d", &b[i]);
    sum += b[i];
  }
  memset(f, 0xff, sizeof(f));
  f[0][0] = 0;
  for (int i = 1; i <= n; i++)
    for (int j = n; j >= 1; j--)
      for (int k = sum; k >= b[i]; k--)
        if (f[j - 1][k - b[i]] != -1)
          f[j][k] = max(f[j][k], f[j - 1][k - b[i]] + a[i]);
  ans = -1;
  for (int j = 1; j <= n; j++) {
    for (int k = need; k <= sum; k++) ans = max(ans, f[j][k]);
    if (ans != -1) {
      printf("%d %d", j, need - ans);
      break;
    }
  }
  return 0;
}
