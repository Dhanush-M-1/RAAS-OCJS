#include <bits/stdc++.h>
using namespace std;
namespace cxcyl {
int n, m, dep[100005];
bool vis[100005], in[100005], ab[100005];
vector<int> G[100005], ans, up[100005];
inline int read() {
  int x = 0, f = 1;
  char c = getchar();
  while (c > -1 && c < '0' || c > '9') {
    if (c == '-') f = -1;
    c = getchar();
  }
  if (c == -1) return 0;
  while (c >= '0' && c <= '9') x = x * 10 + c - 48, c = getchar();
  return x * f;
}
inline unsigned long long Genrand() {
  static unsigned long long x = 20040205;
  x ^= x >> 12;
  x ^= x << 25;
  x ^= x >> 27;
  return x;
}
bool check(int u) {
  in[u] = 1;
  for (int i = 0; i < G[u].size(); ++i) {
    int v = G[u][i];
    if (dep[v]) {
      if (!in[v]) return 0;
      continue;
    }
    dep[v] = dep[u] + 1;
    if (!check(v)) return 0;
  }
  in[u] = 0;
  return 1;
}
void dfs(int u) {
  for (int i = 0; i < G[u].size(); ++i) {
    int v = G[u][i];
    if (dep[v] == dep[u] + 1) {
      dfs(v);
      for (int j = 0; j < up[v].size(); ++j)
        if (up[v][j] != u) up[u].push_back(up[v][j]);
    } else
      up[u].push_back(v);
  }
  ab[u] = up[u].size() <= 1;
}
void find(int u) {
  for (int i = 0; i < up[u].size(); ++i) ab[u] &= ab[up[u][i]];
  if (ab[u]) ans.push_back(u);
  for (int i = 0; i < G[u].size(); ++i) {
    int v = G[u][i];
    if (dep[v] == dep[u] + 1) find(v);
  }
}
inline int main() {
  int T = read();
  while (T--) {
    n = read(), m = read();
    for (int i = 1; i <= n; ++i) G[i].clear();
    for (int i = 1; i <= m; ++i) {
      int u = read(), v = read();
      G[u].push_back(v);
    }
    for (int ct = 1; ct <= 100; ++ct) {
      int x = Genrand() % n + 1;
      for (int i = 1; i <= n; ++i) {
        dep[i] = 0;
        in[i] = 0;
      }
      dep[x] = 1;
      ans.clear();
      if (check(x)) {
        for (int i = 1; i <= n; ++i) up[i].clear();
        dfs(x);
        find(x);
        sort(ans.begin(), ans.end());
        if (5 * ans.size() >= n) {
          for (int i = 0; i < ans.size(); ++i) printf("%d ", ans[i]);
          puts("");
          break;
        } else {
          puts("-1");
          break;
        }
      }
    }
    if (ans.empty()) puts("-1");
  }
  return 0;
}
}  // namespace cxcyl
int main() { return cxcyl::main(); }
