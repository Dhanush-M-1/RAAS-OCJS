#include <bits/stdc++.h>
using namespace std;
struct ss {
  int next, to;
} e[1000005 << 1];
int cnt, head[1000005];
inline void add(int x, int y) {
  e[++cnt].next = head[x];
  e[cnt].to = y;
  head[x] = cnt;
}
int n, k, vis[1000005], low[1000005], siz[1000005], dep[1000005];
inline void dfs2(int now, int d) {
  dep[now] = d;
  low[now] = 1 << 30;
  if (!vis[now]) low[now] = d;
  for (int i = head[now]; i; i = e[i].next) {
    int v = e[i].to;
    dfs2(v, d + 1);
    low[now] = min(low[now], low[v]);
  }
}
inline void dfs3(int now) {
  if (!vis[now]) siz[now] = 1;
  for (int i = head[now]; i; i = e[i].next) {
    int v = e[i].to;
    dfs3(v);
    if (low[v] - dep[now] <= k) {
      siz[now] += siz[v];
      siz[v] = 0;
    }
  }
}
inline int dfs1(int now) {
  int s = 0;
  for (int i = head[now]; i; i = e[i].next) s = max(s, dfs1(e[i].to));
  return s + siz[now];
}
int main() {
  cin >> n >> k;
  for (int i = 2; i <= n; i++) {
    int x;
    cin >> x;
    add(x, i);
    vis[x] = 1;
  }
  dfs2(1, 0);
  dfs3(1);
  cout << dfs1(1);
}
