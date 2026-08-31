#include <bits/stdc++.h>
using namespace std;
int n, fa[200005], deg[200005], vis[200005], head[200005], tot;
stack<int> sta;
int ans[200005], num;
struct edge {
  int to, next;
} e[200005 << 1];
inline void add(int u, int v) {
  e[++tot] = (edge){v, head[u]};
  head[u] = tot;
}
inline int read() {
  int x = 0;
  char c = std::getchar();
  while (c < '0' || c > '9') c = std::getchar();
  while (c >= '0' && c <= '9') {
    x = (x << 3) + (x << 1) + (c ^ 48);
    c = std::getchar();
  }
  return x;
}
void dfs1(int x, int f) {
  fa[x] = f;
  sta.push(x);
  for (int i = head[x]; i; i = e[i].next) {
    int v = e[i].to;
    if (v == f) continue;
    dfs1(v, x);
  }
}
void dfs2(int x) {
  vis[x] = 1;
  ans[++num] = x;
  for (int i = head[x]; i; i = e[i].next) {
    int v = e[i].to;
    deg[v]--;
    if (v == fa[x] || vis[v]) continue;
    if (!(deg[v] & 1)) dfs2(v);
  }
}
int main() {
  n = read();
  int v;
  for (int i = 1; i <= n; i++) {
    v = read();
    if (v) {
      add(i, v);
      add(v, i);
      ++deg[v];
      ++deg[i];
    }
  }
  dfs1(1, -1);
  while (!sta.empty()) {
    int az = sta.top();
    sta.pop();
    if (!(deg[az] & 1)) dfs2(az);
  }
  if (num == n) {
    puts("YES");
    for (int i = 1; i <= num; i++) printf("%d\n", ans[i]);
  } else
    puts("NO");
  return ~~(0 ^ 0) * (0 ^ 0);
}
