#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 10;
int n, m, h[maxn], u, v, d[maxn], sg[maxn], vis[maxn], chc[maxn], hed[maxn], ed,
    s[maxn], cnt;
struct edge {
  int to, nex;
  edge(int _ = 0, int __ = 0) : to(_), nex(__) {}
} e[maxn];
inline void add(int u, int v) {
  e[++ed] = edge(v, hed[u]);
  hed[u] = ed;
}
void topsort() {
  queue<int> Q;
  for (int i = (1); i <= (n); ++i)
    if (!d[i]) Q.push(i);
  while (!Q.empty()) {
    int u = Q.front();
    Q.pop();
    s[++cnt] = u;
    for (int i = hed[u], v = e[i].to; i; i = e[i].nex, v = e[i].to)
      if (!(--d[v])) Q.push(v);
  }
}
int main() {
  scanf("%d%d", &n, &m);
  for (int i = (1); i <= (n); ++i) scanf("%d", &h[i]);
  for (int i = (1); i <= (m); ++i) scanf("%d%d", &u, &v), add(u, v), ++d[v];
  topsort();
  for (int w = (n); w >= (1); --w) {
    int u = s[w];
    for (int i = hed[u], v = e[i].to; i; i = e[i].nex, v = e[i].to)
      vis[sg[v]] = u;
    sg[u] = 0;
    while (vis[sg[u]] == u) ++sg[u];
    chc[sg[u]] ^= h[u];
  }
  for (int i = (n); i >= (0); --i)
    if (chc[i]) {
      puts("WIN");
      int u = 0;
      for (int j = (1); j <= (n); ++j)
        if (sg[j] == i && (h[j] > (h[j] ^ chc[i]))) {
          u = j, h[j] ^= chc[i], chc[i] = 0;
          break;
        }
      for (int j = hed[u], v = e[j].to; j; j = e[j].nex, v = e[j].to)
        h[v] ^= chc[sg[v]], chc[sg[v]] = 0;
      for (int j = (1); j <= (n); ++j) printf("%d ", h[j]);
      puts("");
      return 0;
    }
  puts("LOSE");
  return 0;
}
