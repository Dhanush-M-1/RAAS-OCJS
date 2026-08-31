#include <bits/stdc++.h>
using namespace std;
int n;
struct Edge {
  int to, next;
};
const int maxn = 6060;
Edge e[maxn];
int st[maxn], tot = -1;
void add(int u, int v) {
  e[++tot].to = v;
  e[tot].next = st[u];
  st[u] = tot;
}
bool vis[3030], cir[maxn];
int fa[maxn], dep[maxn], C;
void prep(int now) {
  for (int i = st[now]; i != -1; i = e[i].next)
    if (e[i].to != fa[now]) {
      fa[e[i].to] = now;
      dep[e[i].to] = dep[now] + 1;
      prep(e[i].to);
    }
}
int f[maxn];
int find(int x) {
  if (f[x] == x) return x;
  return f[x] = find(f[x]);
}
void Union(int a, int b) { f[find(a)] = find(b); }
void init() {
  memset(st, -1, sizeof(st));
  cin >> n;
  int U, V;
  for (int i = 1; i <= n; i++) f[i] = i;
  for (int i = 1; i <= n; i++) {
    int u, v;
    cin >> u >> v;
    u++;
    v++;
    if (find(u) == find(v)) {
      U = u, V = v;
      continue;
    }
    add(u, v);
    add(v, u);
    Union(u, v);
  }
  dep[1] = 1;
  prep(1);
  add(U, V);
  add(V, U);
  if (dep[U] > dep[V]) swap(U, V);
  while (dep[V] > dep[U]) {
    cir[V] = true;
    V = fa[V];
  }
  while (fa[V] != fa[U]) {
    cir[V] = true;
    cir[U] = true;
    V = fa[V];
    U = fa[U];
  }
  if (V == U)
    cir[V] = true;
  else
    cir[V] = cir[fa[V]] = true;
  for (int i = 1; i <= n; i++)
    if (cir[i]) C++;
}
int cnt, cy;
double ans = 0;
int Start;
void dfs(int now) {
  vis[now] = true;
  cnt++;
  cy += cir[now];
  if (cy > 1) {
    double a = cnt, b = cnt + C - 2 * cy + 2, c = cnt - cy + C;
    if (a != 0 && b != 0 && c != 0) ans += 1.0 / a + 1.0 / b - 1.0 / c;
  } else
    ans += 1.0 / cnt;
  for (int i = st[now]; i != -1; i = e[i].next)
    if (!vis[e[i].to]) dfs(e[i].to);
  cy -= cir[now];
  cnt--;
}
void work() {
  for (int i = 1; i <= n; i++) {
    memset(vis, 0, sizeof(vis));
    Start = i;
    dfs(i);
  }
  cout << fixed << setprecision(9) << ans << endl;
}
void debug() {
  for (int i = 1; i <= n; i++)
    if (cir[i]) cout << i << " ";
}
int main() {
  init();
  work();
  return 0;
}
