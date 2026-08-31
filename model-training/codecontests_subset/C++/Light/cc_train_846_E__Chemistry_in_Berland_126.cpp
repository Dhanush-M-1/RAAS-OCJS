#include <bits/stdc++.h>
using namespace std;
const int mx = 1e5 + 10;
const long long int oo = 1e18;
vector<int> g[mx];
long long int b[mx], a[mx], k[mx];
int p[mx];
vector<int> lyr[mx];
void dfs(int u, int l = 0) {
  lyr[l].push_back(u);
  for (int v : g[u])
    if (v != p[u]) dfs(v, l + 1);
}
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) scanf("%lld", b + i);
  for (int i = 0; i < n; i++) scanf("%lld", a + i);
  for (int i = 1; i < n; i++) {
    scanf("%d %lld", p + i, k + i);
    --p[i];
    g[p[i]].push_back(i);
  }
  dfs(0);
  bool ok = true;
  for (int l = n - 1; l > 0 && ok; l--)
    for (int u : lyr[l]) {
      int pu = p[u];
      long long int dx = b[u] - a[u];
      if (dx >= 0)
        b[pu] += dx, b[u] -= dx;
      else {
        dx = -dx;
        if (k[u] <= oo / dx) {
          b[u] += dx;
          b[pu] -= k[u] * dx;
          if (b[pu] <= -oo) ok = false;
        } else
          ok = false;
      }
    }
  if (b[0] < a[0]) ok = false;
  if (ok)
    puts("YES");
  else
    puts("NO");
  return 0;
}
