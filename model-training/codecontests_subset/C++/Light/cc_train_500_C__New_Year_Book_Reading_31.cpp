#include <bits/stdc++.h>
using namespace std;
inline int read() {
  int x = 0, k = 1;
  char c = getchar();
  while (c < '0' || c > '9') {
    if (c == '-') k = -1;
    c = getchar();
  }
  while (c >= '0' && c <= '9')
    x = (x << 3) + (x << 1) + (c ^ 48), c = getchar();
  return x * k;
}
int w[505], n, cnt, b[505], ans = (1 << 30), m, ed[1005];
bool use[505];
inline int work() {
  int t = 0;
  for (int i = 2; i <= m; i++) {
    for (int j = 1; j <= n; j++) {
      if (b[j] == ed[i]) {
        for (int k = j - 1; k; k--) {
          t += w[b[k]];
          b[k + 1] = b[k];
        }
        b[1] = ed[i];
        break;
      }
    }
  }
  return t;
}
int main() {
  n = read(), m = read();
  for (int i = 1; i <= n; i++) {
    w[i] = read();
  }
  for (int i = 1; i <= m; i++) {
    ed[i] = read();
    if (!use[ed[i]]) {
      use[ed[i]] = 1;
      b[++cnt] = ed[i];
    }
  }
  printf("%d", work());
  return 0;
}
