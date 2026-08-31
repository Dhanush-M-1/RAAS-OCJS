#include <bits/stdc++.h>
using namespace std;
int T, n, m, head[200010], o = 0, deg[200010], id[200010], val[200010],
                           a[200010];
bool vis[200010];
queue<int> q;
struct edge {
  int to, link, w;
} e[400010];
void add_edge(int u, int v) {
  e[++o].to = v, e[o].link = head[u], head[u] = o, e[o].w = 1;
  e[++o].to = u, e[o].link = head[v], head[v] = o, e[o].w = 0;
  deg[u]++;
}
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i]);
  for (int i = 1, u, v; i <= m; i++) scanf("%d%d", &u, &v), add_edge(u, v);
  for (int i = 1; i <= n; i++)
    if (!deg[i]) q.push(i);
  while (!q.empty()) {
    int u = q.front();
    q.pop();
    for (int i = head[u]; i; i = e[i].link)
      if (e[i].w) vis[id[e[i].to]] = true;
    while (vis[id[u]]) id[u]++;
    for (int i = head[u]; i; i = e[i].link)
      if (e[i].w) vis[id[e[i].to]] = false;
    val[id[u]] ^= a[u];
    for (int i = head[u]; i; i = e[i].link)
      if (!e[i].w) {
        if (!(--deg[e[i].to])) q.push(e[i].to);
      }
  }
  int pos = -1;
  for (int i = 0; i <= n; i++)
    if (val[i]) pos = i;
  if (pos < 0) return puts("LOSE"), 0;
  for (int i = 1; i <= n; i++)
    if (id[i] == pos) {
      if ((val[id[i]] ^ a[i]) >= a[i]) continue;
      a[i] ^= val[id[i]], val[id[i]] = 0;
      for (int j = head[i]; j; j = e[j].link)
        if (e[j].w) {
          a[e[j].to] ^= val[id[e[j].to]], val[id[e[j].to]] = 0;
        }
      break;
    }
  puts("WIN");
  for (int i = 1; i <= n; i++) printf("%d ", a[i]);
  puts("");
}
