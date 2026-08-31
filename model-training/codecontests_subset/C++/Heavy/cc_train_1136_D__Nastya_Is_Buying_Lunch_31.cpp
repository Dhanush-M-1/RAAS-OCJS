#include <bits/stdc++.h>
using namespace std;
int read() {
  int w = 0, f = 1;
  char c = ' ';
  while (c < '0' || c > '9') c = getchar(), f = c == '-' ? -1 : f;
  while (c >= '0' && c <= '9') w = w * 10 + c - 48, c = getchar();
  return w * f;
}
int n, m, a[500005], b[500005], ans;
vector<int> e[500005];
signed main() {
  n = read(), m = read();
  for (int i = 1; i <= n; i++) a[i] = read();
  int x, y;
  for (int i = 1; i <= m; i++) {
    x = read(), y = read();
    e[y].push_back(x);
  }
  for (int i = n; i > 0; i--) {
    if (b[a[i]] == n - i - ans && i != n)
      ans++;
    else
      for (auto j : e[a[i]]) b[j]++;
  }
  printf("%d", ans);
  return 0;
}
