#include <bits/stdc++.h>
using namespace std;
const int maxn = 3010;
double ans = 0;
int n, l[maxn], e = 0;
int deg[maxn], dep[maxn], a[maxn], tot;
vector<int> sub[maxn], son[maxn];
struct Edge {
  int v, x;
} E[maxn << 1];
inline void addEdge(int u, int v) { E[e].v = v, E[e].x = l[u], l[u] = e++; }
void dfs(int u) {
  sub[u].push_back(u);
  for (int i = 0; i < son[u].size(); i++) {
    int v = son[u][i];
    dep[v] = dep[u] + 1;
    dfs(v);
    for (int _1 = 0; _1 < sub[u].size(); _1++) {
      for (int _2 = 0; _2 < sub[v].size(); _2++) {
        int x = sub[u][_1], y = sub[v][_2];
        int d = dep[x] + dep[y] - 2 * dep[u] + 1;
        ans += double(1) / d;
      }
    }
    for (int _ = 0; _ < sub[v].size(); _++) sub[u].push_back(sub[v][_]);
  }
}
int main() {
  memset(l, -1, sizeof(l));
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    int u, v;
    scanf("%d%d", &u, &v);
    ++u, ++v;
    addEdge(u, v), addEdge(v, u);
    ++deg[u], ++deg[v];
  }
  queue<int> Q;
  for (int i = 1; i <= n; i++)
    if (deg[i] == 1) Q.push(i);
  while (!Q.empty()) {
    int u = Q.front();
    Q.pop();
    for (int p = l[u]; p >= 0; p = E[p].x) {
      int v = E[p].v;
      if (deg[v] >= 2) {
        --deg[v];
        if (deg[v] == 1) Q.push(v);
        son[v].push_back(u);
      }
    }
  }
  for (int i = 1; i <= n; i++) {
    if (deg[i] >= 2) {
      int u = i, last = 0;
      do {
        for (int p = l[u]; p >= 0; p = E[p].x) {
          int v = E[p].v;
          if (deg[v] >= 2 && v != last) {
            last = u;
            u = v;
            break;
          }
        }
        a[++tot] = u;
      } while (u != i);
      break;
    }
  }
  for (int i = 1; i <= n; i++) {
    if (deg[i] >= 2) {
      dfs(i);
    }
  }
  for (int i = 1; i <= tot; i++) {
    for (int j = i + 1; j <= tot; j++) {
      for (int _1 = 0; _1 < sub[a[i]].size(); _1++) {
        for (int _2 = 0; _2 < sub[a[j]].size(); _2++) {
          int u = sub[a[i]][_1], v = sub[a[j]][_2];
          ans += double(1) / (dep[u] + dep[v] + j - i + 1);
          ans += double(1) / (dep[u] + dep[v] + tot - j + i + 1);
          ans -= double(1) / (dep[u] + dep[v] + tot);
        }
      }
    }
  }
  ans = ans * 2 + n;
  printf("%.10lf\n", ans);
  return 0;
}
