#include <bits/stdc++.h>
using namespace std;
long long read() {
  long long x = 0, f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = x * 10 + ch - '0';
    ch = getchar();
  }
  return x * f;
}
int n, m;
int a[5005], b[5005];
int f[5005], l[5005], r[5005], v[5005];
int main() {
  n = read();
  m = read();
  for (int i = 1; i <= n; i++) a[i] = 100000000;
  for (int i = 1; i <= m; i++) {
    f[i] = read();
    l[i] = read();
    r[i] = read();
    v[i] = read();
  }
  for (int k = 1; k <= m; k++) {
    if (f[k] == 1)
      for (int i = l[k]; i <= r[k]; i++) b[i] += v[k];
    else
      for (int i = l[k]; i <= r[k]; i++) a[i] = min(a[i], v[k] - b[i]);
  }
  for (int i = 1; i <= n; i++) b[i] = a[i];
  for (int k = 1; k <= m; k++) {
    if (f[k] == 1)
      for (int i = l[k]; i <= r[k]; i++) b[i] += v[k];
    else {
      int mx = -100000000;
      for (int i = l[k]; i <= r[k]; i++) mx = max(mx, b[i]);
      if (mx != v[k]) {
        puts("NO");
        return 0;
      }
    }
  }
  puts("YES");
  for (int i = 1; i <= n; i++) printf("%d ", a[i]);
  return 0;
}
