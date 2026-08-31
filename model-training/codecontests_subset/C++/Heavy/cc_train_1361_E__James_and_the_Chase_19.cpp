#include <bits/stdc++.h>
using namespace std;
const double eps = 1e-14;
struct edge {
  int v, nxt;
} e[300001];
vector<int> gen[300001];
int head[300001], cnt, fz[300001], rt, sum, n, m, id[300001], dfn[300001], tot,
    low[300001], low1[300001], rk[300001], used[100001];
bool vis[300001], al[300001], flag = 0, interest[300001];
inline void add(int u, int v) {
  e[++cnt].v = v, e[cnt].nxt = head[u], head[u] = cnt;
}
inline void check(int u) {
  vis[u] = 1;
  al[u] = 1;
  for (int i = head[u]; i; i = e[i].nxt) {
    int to = e[i].v;
    if (al[to] && !vis[to]) {
      flag = 1;
      continue;
    } else if (al[to]) {
      fz[u]++, gen[u].push_back(to);
      continue;
    }
    check(to);
  }
  vis[u] = 0;
}
int tmptmptmp;
inline void dfs(int u) {
  dfn[u] = low[u] = low1[u] = ++tot;
  rk[tot] = u;
  al[u] = 1;
  for (int i = head[u]; i; i = e[i].nxt) {
    int v = e[i].v;
    if (!al[v]) {
      dfs(v);
      if (low[v] < low[u])
        low1[u] = low[u], low[u] = low[v];
      else if (low[v] < low1[u])
        low1[u] = low[v];
      if (low1[v] < low[u])
        low1[u] = low[u], low[u] = low1[v];
      else if (low1[v] < low1[u])
        low1[u] = low1[v];
    } else {
      if (dfn[v] < low[u])
        low1[u] = low[u], low[u] = dfn[v];
      else if (dfn[v] < low1[u])
        low1[u] = dfn[v];
    }
  }
}
inline void dfs1(int now) {
  al[now] = 1;
  if (!(low[now] < dfn[now] && low1[now] < dfn[now]) && interest[rk[low[now]]])
    interest[now] = 1;
  for (int i = head[now]; i; i = e[i].nxt) {
    int to = e[i].v;
    if (al[to]) continue;
    dfs1(to);
  }
}
int main() {
  int T;
  cin >> T;
  while (T--) {
    cin >> n >> m;
    cnt = 0;
    flag = 0;
    rt = sum = 0;
    for (int i = 1; i <= n; i++) {
      head[i] = 0;
      fz[i] = 0;
      id[i] = i;
      used[i] = 0;
      interest[i] = 0;
      gen[i].clear();
      dfn[i] = 0;
      low[i] = low1[i] = rk[i] = vis[i] = 0;
      al[i] = 0;
    }
    for (int i = 0; i < m; i++) {
      int u, v;
      scanf("%d%d", &u, &v);
      add(u, v);
    }
    if (m == 0) {
      printf("1\n");
      continue;
    }
    int Sum = 0;
    for (int i = 1; i <= 100; i++) {
      random_shuffle(id + 1, id + 1 + n);
      for (int j = 1; j <= n; j++) vis[j] = al[j] = 0;
      flag = 0;
      if (used[id[1]]) continue;
      used[id[1]] = 1;
      check(id[1]);
      if (!flag) {
        rt = id[1];
        break;
      }
    }
    if (!rt) {
      cout << "-1" << endl;
      continue;
    }
    interest[rt] = 1;
    tot = 0;
    for (int i = 1; i <= n; i++) al[i] = 0;
    dfs(rt);
    for (int i = 1; i <= n; i++) al[i] = 0;
    dfs1(rt);
    int temp = 0;
    for (int i = 1; i <= n; i++) {
      if (interest[i]) temp++;
    }
    if (1.0 * temp / n - 0.2 < -eps) {
      printf("-1\n");
      continue;
    }
    for (int i = 1; i <= n; i++) {
      if (interest[i]) {
        printf("%d ", i);
      }
    }
    printf("\n");
  }
  return 0;
}
