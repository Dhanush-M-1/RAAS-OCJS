#include <bits/stdc++.h>
using namespace std;
const int maxn = 5205;
int a[maxn][maxn];
char b[maxn];
int c[maxn][maxn];
int n;
bool pd(int i) {
  for (int j = 1; j <= n - i + 1; j += i) {
    for (int k = 1; k <= n - i + 1; k += i) {
      int x = j + i - 1;
      int y = k + i - 1;
      int s = a[x][y] - a[x][k - 1] - a[j - 1][y] + a[j - 1][k - 1];
      if (s == 0 || s == i * i) {
        continue;
      } else
        return false;
    }
  }
  return true;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%s", b);
    for (int j = 0; j < n / 4; j++) {
      int x;
      if (b[j] >= '0' && b[j] <= '9')
        x = b[j] - '0';
      else
        x = b[j] - 'A' + 10;
      for (int k = 3, p = 1; k >= 0; k--, p++) {
        c[i][j * 4 + p] = x >> k & 1;
      }
    }
  }
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      a[i][j] = a[i - 1][j] + a[i][j - 1] - a[i - 1][j - 1] + c[i][j];
    }
  }
  int ans = 1;
  for (int i = 1; i * i <= n; i++) {
    if (n % i == 0) {
      if (pd(i)) ans = max(ans, i);
      if (i * i != n) {
        if (pd(n / i)) ans = max(ans, n / i);
      }
    }
  }
  printf("%d\n", ans);
}
