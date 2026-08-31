#include <bits/stdc++.h>
using namespace std;
const int INF = int(1e9) + 7;
const int maxd = int(3e5) + 11;
const int maxe = int(3e5) + 11;
int tot = 0, topt = 0;
int head[maxd];
int S, T, e[210][210];
struct Edge {
  int from, to, cap, cost, next;
  Edge() {}
  Edge(int x, int y, int a, int b, int c)
      : from(x), to(y), cap(a), cost(b), next(c) {}
} eage[maxe * 2];
void add(int x, int y, int a, int b) {
  e[x][y] = tot;
  eage[tot] = Edge(x, y, a, b, head[x]), head[x] = tot++;
  eage[tot] = Edge(y, x, 0, -b, head[y]), head[y] = tot++;
  return;
}
bool used[maxd], vis[maxd];
int dis[maxd];
queue<int> que;
int ans = 0;
bool spfa() {
  for (int i = 0; i < maxd; i++) used[i] = false, dis[i] = INF, vis[i] = false;
  while (que.size()) que.pop();
  que.push(S);
  used[S] = true;
  dis[S] = 0;
  while (que.size()) {
    int u = que.front();
    que.pop();
    used[u] = false;
    for (int i = head[u]; ~i; i = eage[i].next)
      if (eage[i].cap && dis[eage[i].to] > dis[u] + eage[i].cost) {
        int v = eage[i].to;
        dis[v] = dis[u] + eage[i].cost;
        if (!used[v]) {
          used[v] = true;
          que.push(v);
        }
      }
  }
  return (dis[T] <= 0);
}
int dfs(int u, int flow) {
  if (u == T) {
    ans += dis[u] * flow;
    return flow;
  }
  vis[u] = true;
  int ret = 0;
  for (int i = head[u]; ~i; i = eage[i].next)
    if (!vis[eage[i].to] && eage[i].cap &&
        dis[eage[i].to] == dis[u] + eage[i].cost) {
      int v = eage[i].to;
      int newf = dfs(v, min(flow, eage[i].cap));
      eage[i].cap -= newf;
      eage[i ^ 1].cap += newf;
      ret += newf;
      flow -= newf;
      if (!flow) break;
    }
  if (!ret) dis[u] = -1;
  return ret;
}
int MCMF() {
  ans = 0;
  while (spfa()) dfs(S, INF);
  return ans;
}
int _, n, k, id[80], a[maxe], b[maxe], kid[80], aa[80];
void init() {
  memset(head, -1, sizeof head);
  memset(eage, 0, sizeof eage);
  memset(id, 0, sizeof id);
  memset(e, -1, sizeof e);
  tot = 0;
  topt = 0;
}
void solve() {
  scanf("%d%d", &n, &k);
  S = ++topt;
  for (int i = 1; i <= n; i++) id[i] = ++topt;
  for (int i = 1; i <= k + 1; i++) kid[i] = ++topt;
  T = ++topt;
  for (int i = 1; i <= n; i++) add(S, id[i], 1, 0);
  for (int i = 1; i <= k; i++) add(kid[i], T, 1, 0);
  add(kid[k + 1], T, n - k, 0);
  for (int i = 1; i <= n; i++) scanf("%d%d", &a[i], &b[i]);
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= k; j++)
      add(id[i], kid[j], 1, -(a[i] + b[i] * (j - 1)));
    add(id[i], kid[k + 1], 1, -(b[i] * (k - 1)));
  }
  MCMF();
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= k; j++)
      if (e[id[i]][kid[j]] != -1) {
        if (eage[e[id[i]][kid[j]]].cap == 0) aa[j] = i;
      }
  printf("%d\n", n + (n - k));
  for (int i = 1; i < k; i++) printf("%d ", aa[i]);
  for (int i = 1; i <= n; i++)
    if (eage[e[id[i]][kid[k + 1]]].cap == 0) printf("%d %d ", i, -i);
  printf("%d\n", aa[k]);
  return;
}
int main() {
  scanf("%d", &_);
  while (_--) init(), solve();
  return 0;
}
