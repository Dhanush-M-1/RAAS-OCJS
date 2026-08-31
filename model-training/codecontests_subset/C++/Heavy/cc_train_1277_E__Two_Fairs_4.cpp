#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 5;
const int maxm = 5e5 + 5;
struct edge {
  int to, next;
} G[maxm << 1];
int tot, head[maxn];
void addEdge(int u, int v) {
  G[tot] = {v, head[u]};
  head[u] = tot++;
}
int T, n, m, a, b, visa[maxn], visb[maxn];
void bfs1() {
  for (int i = 1; i <= n; i++) visa[i] = 0;
  queue<int> q;
  q.push(a);
  visa[a] = 1;
  int u, v, i;
  while (!q.empty()) {
    u = q.front();
    q.pop();
    for (int i = head[u]; i != -1; i = G[i].next) {
      v = G[i].to;
      if (visa[v]) continue;
      visa[v] = 1;
      if (v != b) q.push(v);
    }
  }
}
void bfs2() {
  for (int i = 1; i <= n; i++) visb[i] = 0;
  queue<int> q;
  q.push(b);
  visb[b] = 1;
  int u, v, i;
  while (!q.empty()) {
    u = q.front();
    q.pop();
    for (int i = head[u]; i != -1; i = G[i].next) {
      v = G[i].to;
      if (visb[v]) continue;
      visb[v] = 1;
      if (v != a) q.push(v);
    }
  }
}
int main() {
  for (cin >> T; T--;) {
    cin >> n >> m >> a >> b;
    tot = 0;
    for (int i = 1; i <= n; i++) {
      head[i] = -1;
      visa[i] = visb[i] = 0;
    }
    int u, v;
    for (int i = 1; i <= m; i++) {
      cin >> u >> v;
      addEdge(u, v);
      addEdge(v, u);
    }
    bfs1();
    bfs2();
    long long A = 0, B = 0;
    for (int i = 1; i <= n; i++) {
      A += visa[i] && !visb[i];
      B += visb[i] && !visa[i];
    }
    cout << A * B << endl;
  }
}
