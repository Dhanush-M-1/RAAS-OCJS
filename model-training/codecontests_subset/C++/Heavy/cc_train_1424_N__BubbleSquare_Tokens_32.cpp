#include <bits/stdc++.h>
using namespace std;
const int maxn = 1E6 + 5;
int n, m, size, head[maxn];
inline int read() {
  char ch = getchar();
  while (!isdigit(ch)) ch = getchar();
  int s = ch - '0';
  ch = getchar();
  while (isdigit(ch)) {
    s = s * 10 + ch - '0';
    ch = getchar();
  }
  return s;
}
struct edge {
  int to, next, w;
} E[maxn * 2];
inline void add(int u, int v) {
  E[++size].to = v;
  E[size].next = head[u];
  E[size].w = -1;
  head[u] = size;
}
bool vis[maxn];
int f[maxn];
int TI, tmp[maxn];
inline void bfs(int S) {
  queue<int> Q;
  Q.push(S);
  vis[S] = 1;
  f[S] = 0;
  while (!Q.empty()) {
    int u = Q.front();
    Q.pop();
    ++TI;
    for (int i = head[u]; i; i = E[i].next) {
      int v = E[i].to;
      if (f[v] != -1) tmp[f[v]] = TI;
      if (!vis[v]) {
        vis[v] = 1;
        Q.push(v);
      }
    }
    int pos = 0;
    while (tmp[pos] == TI) ++pos;
    f[u] = pos;
  }
}
vector<int> wait[12555];
int gg[maxn];
bool cmp(int x, int y) { return f[E[x].to] > f[E[y].to]; }
inline void solve() {
  for (int i = 1; i <= n; ++i) wait[f[i]].push_back(i);
  for (int e = n; e >= 0; --e)
    for (int q = 0; q < wait[e].size(); ++q) {
      int u = wait[e][q];
      gg[u] = 1;
      int tot = 0;
      for (int i = head[u]; i; i = E[i].next) {
        int v = E[i].to;
        if (gg[v]) continue;
        tmp[++tot] = i;
      }
      sort(tmp + 1, tmp + tot + 1, cmp);
      for (int i = 1; i <= tot; ++i) {
        int v = E[tmp[i]].to;
        int k = min(2, min(f[u], f[v]));
        f[u] -= k, f[v] -= k;
        E[tmp[i]].w = k;
      }
    }
  vector<int> A;
  for (int u = 1; u <= n; ++u) {
    assert(f[u] <= 1);
    if (f[u]) A.push_back(u);
  }
  cout << A.size() << '\n';
  for (int i = 0; i < A.size(); ++i) cout << A[i] << " ";
  if (A.size() != 0) cout << '\n';
  for (int u = 1; u <= n; ++u)
    for (int i = head[u]; i; i = E[i].next) {
      int v = E[i].to;
      if (E[i].w != -1) {
        cout << u << " " << v << " " << E[i].w << '\n';
        f[u] += E[i].w;
        f[v] += E[i].w;
      }
    }
  cout << endl;
  for (int u = 1; u <= n; ++u)
    for (int i = head[u]; i; i = E[i].next) {
      int v = E[i].to;
      if (f[v] == f[u]) assert(0);
    }
}
int main() {
  ios::sync_with_stdio(false);
  n = read(), m = read();
  for (int i = 1; i <= m; ++i) {
    int x = read(), y = read();
    add(x, y);
    add(y, x);
  }
  for (int i = 1; i <= n; ++i) f[i] = -1;
  for (int i = 1; i <= n; ++i)
    if (!vis[i]) bfs(i);
  solve();
  return 0;
}
