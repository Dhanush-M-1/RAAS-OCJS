#include <bits/stdc++.h>
using namespace std;
int read() {
  int x = 0, f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = (x << 3) + (x << 1) + (ch ^ 48);
    ch = getchar();
  }
  return x * f;
}
int n, d, a[200005], f[200005], ans, pre;
int main() {
  n = read();
  d = read();
  for (int i = 1; i <= n; i++) a[i] = read();
  f[n] = max(0, a[n]);
  for (int i = n - 1; i >= 1; i--) f[i] = max(f[i + 1] + a[i], a[i]);
  for (int i = 1; i <= n; i++) {
    pre += a[i];
    if (pre > d) return puts("-1"), 0;
    if (a[i] == 0) {
      if (pre < 0) ans++, pre = d - f[i];
      if (pre < 0) return puts("-1"), 0;
    }
  }
  printf("%d\n", ans);
}
