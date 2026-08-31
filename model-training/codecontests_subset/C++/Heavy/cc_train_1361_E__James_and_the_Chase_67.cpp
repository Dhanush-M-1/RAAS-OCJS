#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5;
int n, m, interesting;
vector<int> a[N];
int vis[N];
template <typename T>
inline void chkmax(T &x, T y) {
  x = max(x, y);
}
template <typename T>
inline void chkmin(T &x, T y) {
  x = min(x, y);
}
template <typename T>
inline void read(T &x) {
  T f = 1;
  x = 0;
  char c = getchar();
  for (; !isdigit(c); c = getchar())
    if (c == '-') f = -f;
  for (; isdigit(c); c = getchar()) x = (x << 3) + (x << 1) + c - '0';
  x *= f;
}
inline void dfs(int x) {
  vis[x] = 1;
  for (auto y : a[x]) {
    if (!vis[y])
      dfs(y);
    else if (vis[y] == 2)
      interesting = 0;
  }
  vis[x] = 2;
}
inline bool check(int r) {
  for (int i = 1; i <= n; ++i) vis[i] = 0;
  interesting = 1;
  dfs(r);
  return interesting;
}
bool bad[N];
int level[N], best[N], balance[N];
inline int find_bad(int x) {
  vis[x] = 1;
  best[x] = x;
  for (auto y : a[x]) {
    if (!vis[y]) {
      level[y] = level[x] + 1;
      balance[x] += find_bad(y);
      if (level[best[y]] < level[best[x]]) best[x] = best[y];
    } else {
      ++balance[x];
      --balance[y];
      if (level[y] < level[best[x]]) best[x] = y;
    }
  }
  if (balance[x] > 1) bad[x] = 1;
  return balance[x];
}
inline void propagate_bad(int x) {
  vis[x] = 1;
  if (!bad[x] && bad[best[x]]) bad[x] = 1;
  for (int y : a[x])
    if (!vis[y]) propagate_bad(y);
}
inline void solve() {
  read(n);
  for (int i = 1; i <= n; ++i) a[i].clear();
  read(m);
  for (int i = 1; i <= m; ++i) {
    int u, v;
    read(u), read(v);
    a[u].emplace_back(v);
  }
  int id = -1;
  for (int t = 100; --t;) {
    int r = (long long)rand() * rand() % n + 1;
    if (check(r)) {
      id = r;
      break;
    }
  }
  if (id == -1) {
    printf("-1\n");
    return;
  }
  for (int i = 1; i <= n; ++i) {
    vis[i] = bad[i] = 0;
    level[i] = best[i] = balance[i] = 0;
  }
  find_bad(id);
  for (int i = 1; i <= n; ++i) vis[i] = 0;
  propagate_bad(id);
  vector<int> ans;
  for (int i = 1; i <= n; ++i)
    if (!bad[i]) ans.emplace_back(i);
  if (5 * (int)ans.size() >= n) {
    for (int x : ans) printf("%d ", x);
    printf("\n");
  } else
    printf("-1\n");
}
int main() {
  srand(20040926);
  int T;
  read(T);
  while (T--) solve();
  return 0;
}
