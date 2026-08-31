#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 10;
const int maxm = 2e5 + 10;
const int INF = 0x3f3f3f3f;
struct Edge {
  int v, next, id;
} edge[maxm * 2];
int n, m, k, res;
int U[maxn], V[maxn], du[maxn], Ans[maxn];
int head[maxn], cnt;
queue<int> q;
bool vis[maxn];
bool ok[maxn];
void add(int u, int v, int id) {
  edge[cnt].next = head[u];
  edge[cnt].v = v;
  edge[cnt].id = id;
  head[u] = cnt++;
}
void Bfs(int zz) {
  while (!q.empty()) {
    int x = q.front();
    q.pop();
    for (int i = head[x]; i != -1; i = edge[i].next) {
      int v = edge[i].v;
      if (vis[edge[i].id]) continue;
      du[v]--;
      vis[edge[i].id] = 1;
      if (du[v] < k) {
        if (!ok[v]) {
          q.push(v);
          Ans[zz]--;
          ok[v] = 1;
        }
      }
    }
  }
}
int main() {
  while (scanf("%d%d%d", &n, &m, &k) != EOF) {
    memset(du, 0, sizeof(du));
    memset(ok, 0, sizeof(ok));
    memset(vis, 0, sizeof(vis));
    memset(head, -1, sizeof(head));
    cnt = 0;
    while (!q.empty()) q.pop();
    for (int i = 1; i <= m; i++) {
      scanf("%d%d", U + i, V + i);
      du[U[i]]++;
      du[V[i]]++;
      add(U[i], V[i], i);
      add(V[i], U[i], i);
    }
    for (int i = 1; i <= n; i++) {
      if (du[i] < k) {
        q.push(i);
        ok[i] = 1;
      }
    }
    Bfs(m);
    Ans[m] = 0;
    for (int i = 1; i <= n; i++)
      if (!ok[i]) Ans[m]++;
    for (int i = m; i >= 1; i--) {
      Ans[i - 1] = Ans[i];
      if (vis[i]) {
        continue;
      }
      du[U[i]]--;
      du[V[i]]--;
      vis[i] = 1;
      if (du[U[i]] < k) {
        if (!ok[U[i]]) {
          q.push(U[i]);
          Ans[i - 1]--;
          ok[U[i]] = 1;
        }
      }
      if (du[V[i]] < k) {
        if (!ok[V[i]]) {
          q.push(V[i]);
          Ans[i - 1]--;
          ok[V[i]] = 1;
        }
      }
      Bfs(i - 1);
    }
    for (int i = 1; i <= m; i++) printf("%d\n", Ans[i]);
  }
  return 0;
}
