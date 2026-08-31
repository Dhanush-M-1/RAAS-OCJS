#include <bits/stdc++.h>
using namespace std;
inline int read() {
  int w = 0, f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    w = (w << 3) + (w << 1) + ch - 48;
    ch = getchar();
  }
  return w * f;
}
int n, m, f[600010], ans, siz[600010], st[600010], a[300010][2];
inline int find(int x) {
  if (f[x] == x)
    return f[x];
  else
    return f[x] = find(f[x]);
}
inline void merge(int x, int y) {
  int fx = find(x);
  int fy = find(y);
  if (fx == fy) return;
  f[fx] = fy;
  siz[fy] += siz[fx];
  return;
}
signed main() {
  n = read();
  m = read();
  for (int i = 1; i <= n; i++) {
    char ch;
    cin >> ch;
    st[i] = ch - '0';
  }
  for (int i = 1; i <= m; i++) {
    int tot = read();
    for (int j = 1; j <= tot; j++) {
      int x = read();
      if (!a[x][0])
        a[x][0] = i;
      else
        a[x][1] = i;
    }
  }
  m++;
  for (int i = 0; i <= 2 * m; i++) {
    f[i] = i;
    if (i <= m) siz[i] = 1;
  }
  siz[0] = 0x3f3f3f3f;
  siz[m] = 0;
  for (int i = 1; i <= n; i++) {
    int x = a[i][0];
    int y = a[i][1];
    if (!x) {
      cout << ans << endl;
      continue;
    }
    if (st[i] == 0 && find(x) != find(y + m)) {
      ans -= min(siz[find(x)], siz[find(x + m)]);
      ans -= min(siz[find(y)], siz[find(y + m)]);
      merge(x, y + m);
      merge(x + m, y);
      ans += min(siz[find(x)], siz[find(x + m)]);
      cout << ans << endl;
      continue;
    }
    if (st[i] == 1 && find(x) != find(y)) {
      ans -= min(siz[find(x)], siz[find(x + m)]);
      ans -= min(siz[find(y)], siz[find(y + m)]);
      merge(x, y);
      merge(x + m, y + m);
      ans += min(siz[find(x)], siz[find(x + m)]);
      cout << ans << endl;
      continue;
    }
    cout << ans << endl;
  }
  return 0;
}
