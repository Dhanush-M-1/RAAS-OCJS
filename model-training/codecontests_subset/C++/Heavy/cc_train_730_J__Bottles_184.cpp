#include <bits/stdc++.h>
using namespace std;
inline int ra() {
  int x = 0, f = 1;
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
int a[100005], b[100005];
int f[100005], size[100005];
int main() {
  int n = ra(), sum = 0, tot = 0;
  memset(size, 0x7, sizeof(size));
  size[0] = 0;
  for (int i = 1; i <= n; i++) a[i] = ra(), sum += a[i];
  for (int i = 1; i <= n; i++) b[i] = ra(), tot += b[i];
  for (int i = 1; i <= n; i++)
    for (int j = tot; j >= 0; j--) {
      if (size[j] + 1 == size[j + b[i]])
        f[j + b[i]] = max(f[j + b[i]], f[j] + a[i]);
      if (size[j] + 1 < size[j + b[i]]) {
        size[j + b[i]] = size[j] + 1;
        f[j + b[i]] = f[j] + a[i];
      }
    }
  int anssz = 0x3f3f3f3f, ans;
  for (int i = sum; i <= tot; i++) {
    if (anssz == size[i]) ans = max(ans, f[i]);
    if (anssz > size[i]) {
      anssz = size[i];
      ans = f[i];
    }
  }
  printf("%d %d", anssz, sum - ans);
  return 0;
}
