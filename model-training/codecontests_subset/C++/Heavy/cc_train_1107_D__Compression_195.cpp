#include <bits/stdc++.h>
const int maxn = 5205;
using namespace std;
int n, a[maxn][maxn], m;
int cnt, sum[maxn][maxn], x[maxn];
bool check(int x) {
  int now;
  for (int i = x; i <= n; i += x) {
    for (int j = x; j <= n; j += x) {
      now = sum[i][j] - sum[i - x][j] - sum[i][j - x] + sum[i - x][j - x];
      if (now == 0 || now == x * x)
        continue;
      else
        return 0;
    }
  }
  return 1;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n / 4; j++) {
      scanf("%1x", &m);
      cnt = 0;
      while (m) {
        a[i][j * 4 - cnt++] = (m % 2);
        m >>= 1;
      }
    }
  }
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + a[i][j];
    }
  }
  cnt = 0;
  for (int i = 1; i <= n; i++) {
    if (n % i == 0) {
      x[++cnt] = i;
    }
  }
  for (int k = cnt; k >= 1; k--) {
    if (check(x[k])) {
      printf("%d\n", x[k]);
      break;
    }
  }
}
