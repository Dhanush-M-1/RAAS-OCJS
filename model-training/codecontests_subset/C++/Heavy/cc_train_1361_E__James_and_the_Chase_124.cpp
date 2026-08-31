#include <bits/stdc++.h>
namespace IO {
const int IN_LEN = 1 << 18 | 1;
static char buf[IN_LEN], *s, *t;
inline int Getchar(void) {
  return s == t && (t = (s = buf) + fread(buf, 1, IN_LEN, stdin)),
         s == t ? -1 : *s++;
}
template <class T>
inline void read(T& x) {
  static int c, f;
  c = Getchar(), x = f = 0;
  while (c < '0' || c > '9') {
    if (c == '-') f = 1;
    c = Getchar();
  }
  while (c <= '9' && c >= '0') x = x * 10 + c - 48, c = Getchar();
  x = f ? -x : x;
}
}  // namespace IO
using IO::read;
using namespace std;
const int N = 2e5 + 5;
int head[N], eidx, rt, n, vis[N], dep[N], low[N], sum[N], m, cnt;
struct Edge {
  int nxt, to;
} edge[N];
bool mark[N];
vector<int> ans;
inline void addedge(int u, int v) {
  edge[++eidx] = (Edge){head[u], v};
  head[u] = eidx;
}
bool chk(int u) {
  vis[u] = 1, ++cnt;
  for (int i = head[u], v; i; i = edge[i].nxt)
    if (!vis[v = edge[i].to]) {
      if (!chk(v)) return false;
    } else if (vis[v] == 2)
      return false;
  vis[u] = 2;
  return true;
}
void dfs(int u) {
  low[u] = u, vis[u] = 1;
  for (int i = head[u], v; i; i = edge[i].nxt)
    if (!vis[v = edge[i].to]) {
      dep[v] = dep[u] + 1;
      dfs(v);
      if (dep[low[v]] < dep[low[u]]) low[u] = low[v];
      sum[u] += sum[v];
    } else {
      ++sum[u], --sum[v];
      if (dep[v] < dep[low[u]]) low[u] = v;
    }
  if (sum[u] > 1) mark[u] = 1;
}
void redfs(int u) {
  if (sum[u] < 2 && mark[low[u]]) mark[u] = 1;
  if (!mark[u]) ans.push_back(u);
  for (int i = head[u], v; i; i = edge[i].nxt)
    if (dep[v = edge[i].to] == dep[u] + 1) redfs(v);
}
inline void solve(void) {
  read(n), read(m);
  eidx = 0;
  memset(head, 0, sizeof(int) * (n + 1));
  memset(mark, 0, sizeof(bool) * (n + 1));
  for (int i = 1, u, v; i <= m; ++i) {
    read(u), read(v);
    addedge(u, v);
  }
  int _ = 100;
  while (_--) {
    rt = (1LL * rand() * rand()) % n + 1, cnt = 0;
    memset(vis, 0, sizeof(int) * (n + 1));
    if (chk(rt) && cnt == n)
      break;
    else
      rt = 0;
  }
  if (!rt) return puts("-1"), void();
  memset(vis, 0, sizeof(int) * (n + 1));
  memset(sum, 0, sizeof(int) * (n + 1));
  dep[rt] = 0;
  dfs(rt);
  ans.clear();
  redfs(rt);
  if (int(ans.size()) * 5 < n) return puts("-1"), void();
  sort(ans.begin(), ans.end());
  for (const int& v : ans) printf("%d ", v);
  puts("");
}
int main(void) {
  srand(time(0));
  int T;
  read(T);
  while (T--) solve();
  return 0;
}
