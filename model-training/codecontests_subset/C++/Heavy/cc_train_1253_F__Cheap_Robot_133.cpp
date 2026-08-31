#include <bits/stdc++.h>
using namespace std;
const int N = 3e6 + 10;
const int mod = 998244353;
void read(int &a) {
  a = 0;
  int d = 1;
  char ch;
  while (ch = getchar(), ch > '9' || ch < '0')
    if (ch == '-') d = -1;
  a = ch ^ 48;
  while (ch = getchar(), ch >= '0' && ch <= '9')
    a = (a << 3) + (a << 1) + (ch ^ 48);
  a *= d;
}
int f[N], head[N], cnt;
long long ans[N], dis[N];
bool vis[N];
vector<pair<int, int> > tmp[N];
struct note {
  int u, v, next;
  long long w;
} edge[N];
void add(int u, int v, long long w) {
  edge[++cnt].next = head[u];
  edge[cnt].v = v;
  edge[cnt].w = w;
  head[u] = cnt;
}
struct node {
  int u, v;
  long long w;
  bool operator<(const node &x) const { return w < x.w; }
} e[N];
priority_queue<pair<long long, int>, vector<pair<long long, int> >,
               greater<pair<long long, int> > >
    q;
void distra(int k, int n) {
  fill(dis, dis + n + 1, 1e18);
  for (register int i = 1; i <= k; i++) dis[i] = 0, q.push({0, i});
  while (!q.empty()) {
    int t = q.top().second;
    q.pop();
    if (vis[t]) continue;
    vis[t] = 1;
    for (register int i = head[t]; i; i = edge[i].next) {
      int v = edge[i].v;
      if (!vis[v] && dis[v] > dis[t] + edge[i].w)
        q.push({dis[v] = dis[t] + edge[i].w, v});
    }
  }
}
int getv(int v) { return f[v] = v == f[v] ? v : getv(f[v]); }
int main() {
  int n, m, k, q;
  read(n), read(m), read(k), read(q);
  for (register int i = 1; i <= m; i++) {
    int u, v, w;
    read(u), read(v), read(w);
    add(u, v, w), add(v, u, w);
    e[i] = node{u, v, w};
  }
  distra(k, n);
  for (register int i = 1; i <= m; i++) e[i].w += dis[e[i].u] + dis[e[i].v];
  sort(e + 1, e + 1 + m);
  for (register int i = 1; i <= n; i++) f[i] = i;
  for (register int i = 1; i <= q; i++) {
    int u, v;
    read(u), read(v);
    tmp[u].push_back({v, i});
    tmp[v].push_back({u, i});
  }
  for (register int i = 1; i <= m; i++) {
    int t1 = getv(e[i].u), t2 = getv(e[i].v);
    if (t1 == t2) continue;
    if (tmp[t1].size() > tmp[t2].size()) swap(t1, t2);
    for (auto it : tmp[t1]) {
      if (getv(it.first) == t2)
        ans[it.second] = e[i].w;
      else
        tmp[t2].push_back(it);
    }
    f[t1] = t2;
  }
  for (register int i = 1; i <= q; i++) printf("%I64d\n", ans[i]);
  return 0;
}
