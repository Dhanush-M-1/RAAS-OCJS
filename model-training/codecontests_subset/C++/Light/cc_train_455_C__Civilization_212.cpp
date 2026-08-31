#include <bits/stdc++.h>
using namespace std;
const int o = 3e5 + 1;
int f[o], n, m, k, s[o], d[o], g[o], v[o], l;
vector<int> a[o];
int find(int x) { return f[x] == x ? x : f[x] = find(f[x]); }
void dfs(int x, int y) {
  int q = -1, w = -1;
  for (int i = 0; i < a[x].size(); i++) {
    if (a[x][i] == y) continue;
    dfs(a[x][i], x);
    int r = d[a[x][i]] + 1;
    d[x] = max(d[x], r);
    if (r > q)
      w = q, q = r;
    else if (r > w)
      w = r;
  }
  g[x] = max(0, max(q, max(w, q + w)));
  l = max(l, g[x]);
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> n >> m >> k;
  for (int i = 1; i <= n; i++) f[i] = i;
  for (int i = 1, x, y; i <= m; i++) {
    cin >> x >> y, f[find(x)] = find(y);
    a[x].push_back(y), a[y].push_back(x);
  }
  for (int i = 1; i <= n; i++)
    if (f[i] == i && !v[i]) l = 0, dfs(i, 0), s[i] = l, v[i] = 1;
  while (k--) {
    int q, x, y;
    cin >> q >> x, x = find(x);
    if (q == 1)
      cout << s[x] << "\n";
    else {
      cin >> y, y = find(y);
      if (x == y) continue;
      int z = (s[x] + 1) / 2 + (s[y] + 1) / 2 + 1;
      z = max(z, max(s[x], s[y]));
      f[find(x)] = find(y), s[find(x)] = z;
    }
  }
  return 0;
}
