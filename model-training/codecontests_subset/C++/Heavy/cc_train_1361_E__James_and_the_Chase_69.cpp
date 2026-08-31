#include <bits/stdc++.h>
using namespace std;
inline int read() {
  char c = getchar();
  int x = 0;
  bool f = 0;
  for (; !isdigit(c); c = getchar()) f ^= !(c ^ 45);
  for (; isdigit(c); c = getchar()) x = (x << 1) + (x << 3) + (c ^ 48);
  if (f) x = -x;
  return x;
}
int n, m, p[500005];
vector<int> e[500005];
int dep[500005], fa[500005];
bool vis[500005], ins[500005], ok[500005];
bool check(int u) {
  vis[u] = ins[u] = 1;
  for (auto v : e[u]) {
    if (!vis[v]) {
      dep[v] = dep[u] + 1;
      fa[v] = u;
      if (!check(v)) return 0;
    } else if (!ins[v])
      return 0;
  }
  ins[u] = 0;
  return 1;
}
vector<int> vec[500005];
void dfs(int u) {
  vec[u].clear();
  ok[u] = 1;
  for (auto v : e[u]) {
    if (dep[v] > dep[u]) {
      dfs(v);
      for (auto x : vec[v])
        if (x != u) vec[u].push_back(x);
    } else
      vec[u].push_back(v);
  }
  if (vec[u].size() > 1) ok[u] = 0;
}
vector<int> res;
void solve(int u) {
  for (auto x : vec[u])
    if (!ok[x]) ok[u] = 0;
  for (auto v : e[u])
    if (dep[v] > dep[u]) solve(v);
  if (ok[u]) res.push_back(u);
}
void work() {
  n = read(), m = read();
  for (register int i = (1); i <= (n); ++i) p[i] = i, e[i].clear();
  for (register int i = (1); i <= (m); ++i) {
    int u = read(), v = read();
    e[u].push_back(v);
  }
  random_shuffle(p + 1, p + n + 1);
  int rt = 0;
  for (register int i = (1); i <= (50); ++i) {
    for (register int u = (1); u <= (n); ++u) vis[u] = ins[u] = 0;
    fa[p[i]] = 0;
    if (check(p[i])) {
      rt = p[i];
      break;
    }
  }
  if (!rt) {
    puts("-1");
    return;
  }
  dfs(rt);
  res.clear();
  solve(rt);
  if (res.size() * 5 >= n) {
    sort(res.begin(), res.end());
    for (auto x : res) cout << x << ' ';
    puts("");
  } else
    puts("-1");
}
signed main() {
  srand(2333);
  int T = read();
  while (T--) work();
  return 0;
}
