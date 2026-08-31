#include <bits/stdc++.h>
using namespace std;
inline int read() {
  int x = 0, f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = x * 10 + ch - '0';
    ch = getchar();
  }
  return x * f;
}
const int N = 200010;
int n, m;
int a[N], deg[N], sg[N], ans[N];
vector<int> G[N], vec;
inline void topo() {
  queue<int> q;
  for (int i = (1); i <= (n); ++i)
    if (!deg[i]) q.push(i);
  while (!q.empty()) {
    int f = q.front();
    q.pop();
    vec.push_back(f);
    for (int i = (0); i < (G[f].size()); ++i) {
      deg[G[f][i]]--;
      if (!deg[G[f][i]]) q.push(G[f][i]);
    }
  }
  bool vis[N] = {0};
  for (int i = (n - 1); i >= (0); --i) {
    for (int j = (0); j < (G[vec[i]].size()); ++j) vis[sg[G[vec[i]][j]]] = 1;
    while (vis[sg[vec[i]]]) sg[vec[i]]++;
    for (int j = (0); j < (G[vec[i]].size()); ++j) vis[sg[G[vec[i]][j]]] = 0;
  }
}
int main() {
  n = read();
  m = read();
  for (int i = (1); i <= (n); ++i) a[i] = read();
  for (int i = (1); i <= (m); ++i) {
    int u = read(), v = read();
    G[u].push_back(v);
    deg[v]++;
  }
  topo();
  int maxx = -1, maxy = 0, id = -1;
  for (int i = (1); i <= (n); ++i) {
    if (maxx < sg[i]) maxx = sg[i];
    ans[sg[i]] ^= a[i];
  }
  int pd = 0;
  for (int i = (0); i <= (n); ++i) pd |= ans[i], maxx = (ans[i] ? i : maxx);
  for (int i = (1); i <= (n); ++i)
    if (sg[i] == maxx && (ans[maxx] ^ a[i]) < a[i]) {
      id = i;
      break;
    }
  if (!pd) return puts("LOSE"), 0;
  assert(id != -1);
  puts("WIN");
  a[id] ^= ans[sg[id]];
  for (int i = (0); i < (G[id].size()); ++i)
    a[G[id][i]] ^= ans[sg[G[id][i]]], ans[sg[G[id][i]]] = 0;
  for (int i = (1); i <= (n); ++i) printf("%d%c", a[i], i == n ? 10 : 32);
}
