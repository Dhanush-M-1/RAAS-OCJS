#include <bits/stdc++.h>
using namespace std;
int read() {
  int x = 0;
  bool flg = false;
  char ch = getchar();
  for (; !isdigit(ch); ch = getchar())
    if (ch == '-') flg = true;
  for (; isdigit(ch); ch = getchar()) x = (x << 3) + (x << 1) + (ch ^ 48);
  return flg ? -x : x;
}
int n, m, h[200010], g[200010];
vector<int> e[200010];
int d[200010];
int p[200010], hd, tl;
int sg[200010];
int get(int o) {
  static int vis[200010];
  for (const int &v : e[o]) vis[sg[v]] = o;
  int z = 0;
  while (vis[z] == o) ++z;
  return z;
}
void work(int o) {
  h[o] ^= g[sg[o]];
  g[sg[o]] = 0;
  for (const int &v : e[o]) {
    if (sg[v] >= sg[o]) continue;
    int w = g[sg[v]];
    h[v] ^= w;
    g[sg[v]] ^= w;
  }
  for (int i(1), _i(n); i <= _i; i++) printf("%d ", h[i]);
  puts("");
}
void solve() {
  n = read(), m = read();
  for (int i(1), _i(n); i <= _i; i++) h[i] = read();
  while (m--) {
    int u = read(), v = read();
    e[u].push_back(v), ++d[v];
  }
  for (int i(1), _i(n); i <= _i; i++)
    if (!d[i]) p[++tl] = i;
  while (hd < tl) {
    int u = p[++hd];
    for (const int &v : e[u])
      if (!--d[v]) p[++tl] = v;
  }
  for (int i(n), _i(1); i >= _i; i--)
    sg[p[i]] = get(p[i]), g[sg[p[i]]] ^= h[p[i]];
  int q = -1;
  for (int i(n), _i(0); i >= _i; i--)
    if (g[i]) {
      q = i;
      break;
    }
  if (!~q) return puts("LOSE"), void();
  puts("WIN");
  for (int i(1), _i(n); i <= _i; i++)
    if (sg[i] == q && (g[sg[i]] ^ h[i]) < h[i]) {
      work(i);
      return;
    }
  assert(0);
}
int main() {
  for (int T = 1; T--;) solve();
  return 0;
}
