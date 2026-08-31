#include <bits/stdc++.h>
using namespace std;
struct edge {
  int to;
  edge *nxt;
} edges[500000 * 7 + 5];
edge *ncnt = &edges[0], *Adj[400000 + 5], *Adj2[400000 + 5];
int n, m, a, b, N;
int dfn[400000 + 5], low[400000 + 5], dcnt;
int stk[400000 + 5], siz[400000 + 5], trfa[400000 + 5];
void Init() {
  ncnt = &edges[0];
  for (int i = 1; i <= 2 * n; i++)
    Adj[i] = Adj2[i] = 0, dfn[i] = low[i] = 0, trfa[i] = 0;
  N = n, stk[0] = 0, dcnt = 0;
}
void AddEdge(int u, int v) {
  edge *p = ++ncnt;
  p->to = v;
  p->nxt = Adj[u];
  Adj[u] = p;
  edge *q = ++ncnt;
  q->to = u;
  q->nxt = Adj[v];
  Adj[v] = q;
}
void AddEdge2(int u, int v) {
  edge *p = ++ncnt;
  p->to = v;
  p->nxt = Adj2[u];
  Adj2[u] = p;
}
void DFS(int u, int fa) {
  dfn[u] = low[u] = ++dcnt;
  stk[++stk[0]] = u;
  for (edge *p = Adj[u]; p != NULL; p = p->nxt) {
    int v = p->to;
    if (dfn[v] == 0) {
      DFS(v, u);
      low[u] = min(low[u], low[v]);
      if (low[v] >= dfn[u]) {
        AddEdge2(u, ++N);
        int fro;
        do {
          fro = stk[stk[0]--];
          AddEdge2(N, fro);
        } while (fro != v);
      }
    } else if (v != fa)
      low[u] = min(low[u], dfn[v]);
  }
}
void DFS2(int u) {
  siz[u] = 0;
  if (u <= n) siz[u] = 1;
  for (edge *p = Adj2[u]; p != NULL; p = p->nxt) {
    int v = p->to;
    trfa[v] = u;
    DFS2(v);
    siz[u] += siz[v];
  }
}
void Print() {
  for (int i = 1; i <= N; i++) {
    printf("%d: ", i);
    for (edge *p = Adj2[i]; p != NULL; p = p->nxt) printf("%d ", p->to);
    printf("\n");
  }
}
int main() {
  int T;
  scanf("%d", &T);
  for (int tmn = 1; tmn <= T; tmn++) {
    scanf("%d %d %d %d", &n, &m, &a, &b);
    Init();
    for (int i = 1; i <= m; i++) {
      int u, v;
      scanf("%d %d", &u, &v);
      AddEdge(u, v);
    }
    DFS(a, -1);
    int cnt = 0;
    for (edge *p = Adj2[a]; p != NULL; p = p->nxt)
      if (p->to > n) cnt++;
    if (cnt == 1 || Adj[b] == NULL) {
      printf("0\n");
      continue;
    }
    DFS2(a);
    int pos = b;
    while (trfa[pos] != a) pos = trfa[pos];
    printf("%lld\n", (1LL * siz[a] - 1LL * siz[pos] - 1LL) * (siz[b] - 1LL));
  }
  return 0;
}
