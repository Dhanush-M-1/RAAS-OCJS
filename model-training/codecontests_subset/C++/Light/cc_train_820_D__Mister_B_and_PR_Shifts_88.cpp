#include <bits/stdc++.h>
using namespace std;
int i, j, k, m, n, s, t;
int read() {
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
long long mn, c[1001000], a[1001000];
int main() {
  n = read();
  for (i = 1; i <= n; i++) a[i] = read();
  for (i = 1; i <= n; i++) {
    if (i == a[i]) {
      c[1]++;
      c[n - i + 1] += i + i - n - 2;
      c[n - i + 2] += -1 - 2 * i + 1 + n;
    }
    if (i > a[i]) {
      c[0] += i - a[i];
      c[1] += 1 - i + a[i];
      c[n - i + 1] += a[i] + a[i] - 2 - n;
      c[n - i + 2] += -1 - a[i] * 2 + 1 + n;
      c[n - i + a[i] + 1] += 2;
    }
    if (i < a[i]) {
      c[0] += a[i] - i;
      c[1] += -1 - a[i] + i;
      c[a[i] - i + 1] += 2;
      c[n - i + 1] += a[i] + a[i] - 2 - n;
      c[n - i + 2] += -1 - a[i] * 2 + 1 + n;
    }
  }
  mn = (long long)n * n;
  for (i = 1; i < n; i++) c[i] += c[i - 1];
  for (i = 1; i < n; i++) c[i] += c[i - 1];
  for (i = 0; i < n; i++) {
    if (c[i] < mn) {
      mn = c[i];
      j = i;
    }
  }
  cout << mn << " " << j << endl;
}
