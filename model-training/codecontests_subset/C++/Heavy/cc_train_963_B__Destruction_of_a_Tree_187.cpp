#include <bits/stdc++.h>
using namespace std;
const int maxn = 500000 + 5;
int head[maxn], to[maxn << 1], nex[maxn << 1], cnt, degree[maxn], parent[maxn],
    vis[maxn];
stack<int> dfs;
queue<int> answer;
inline void add_edge(int u, int v) {
  nex[++cnt] = head[u];
  head[u] = cnt;
  to[cnt] = v;
}
void dfs1(int u, int fa) {
  dfs.push(u);
  parent[u] = fa;
  for (int v = head[u]; v; v = nex[v])
    if (to[v] != fa) dfs1(to[v], u);
}
void dfs2(int u) {
  answer.push(u);
  vis[u] = 1;
  for (int v = head[u]; v; v = nex[v]) {
    --degree[to[v]];
    if (to[v] == parent[u] || vis[to[v]]) continue;
    if (degree[to[v]] % 2 == 0) dfs2(to[v]);
  }
}
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) {
    int a;
    scanf("%d", &a);
    if (a == 0) continue;
    add_edge(i, a);
    add_edge(a, i);
    ++degree[a], ++degree[i];
  }
  dfs1(1, 0);
  while (dfs.size()) {
    int u = dfs.top();
    dfs.pop();
    if (degree[u] % 2 == 0) dfs2(u);
  }
  if (answer.size() == n) {
    printf("YES\n");
    while (!answer.empty()) {
      printf("%d\n", answer.front());
      answer.pop();
    }
  } else
    printf("NO");
  return 0;
}
