#include <bits/stdc++.h>
using namespace std;
const int N = 3e5 + 1;
bool v[N];
int n, m, q, f[N], x, y, d[N], M, g[N], t;
vector<int> a[N];
int F(int x) {
  if (f[x] == x) return x;
  return f[x] = F(f[x]);
}
void D(int k, int f) {
  v[k] = true;
  for (int i = 0; i < a[k].size(); i++)
    if (a[k][i] != f) {
      d[a[k][i]] = d[k] + 1;
      if (d[a[k][i]] > d[M]) M = a[k][i];
      D(a[k][i], k);
    }
}
int main() {
  ios::sync_with_stdio(false);
  cin >> n >> m >> q;
  for (int i = 1; i <= n; i++) f[i] = i;
  while (m-- && cin >> x >> y) {
    a[x].push_back(y), a[y].push_back(x), x = F(x), y = F(y);
    if (x != y) f[y] = x;
  }
  for (int i = 1; i <= n; i++)
    if (!v[i]) d[i] = 0, M = i, D(i, 0), d[M] = 0, D(M, 0), g[F(i)] = d[M];
  while (q-- && cin >> t >> x)
    if (t == 1)
      cout << g[F(x)] << '\n';
    else {
      cin >> y;
      x = F(x), y = F(y);
      if (x != y)
        f[y] = x,
        g[x] = max(max(g[x], g[y]), (g[x] + 1) / 2 + (g[y] + 1) / 2 + 1);
    }
  return 0;
}
