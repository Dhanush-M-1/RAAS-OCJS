#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 7;
int n, m;
bool bad[N];
vector<int> G[N];
int vis[N];
bool interesting;
int lvl[N];
int best[N];
int balance[N];
void clear() {
  for (int i = 1; i <= n; ++i) {
    lvl[i] = 0;
    best[i] = 0;
    balance[i] = 0;
    G[i].clear();
    bad[i] = false;
  }
}
void no_answer() {
  puts("-1");
  clear();
}
int getInt(int a = INT_MIN, int b = INT_MAX) {
  static mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
  return uniform_int_distribution<int>(a, b)(rng);
}
void dfs(int u) {
  vis[u] = 1;
  for (auto v : G[u])
    if (vis[v] == 0)
      dfs(v);
    else if (vis[v] == 2)
      interesting = false;
  vis[u] = 2;
}
bool check(int r) {
  for (int i = 1; i <= n; ++i) vis[i] = 0;
  interesting = true;
  dfs(r);
  return interesting;
}
int find_any() {
  int tests = 100;
  while (tests--) {
    int r = getInt(1, n);
    if (check(r)) return r;
  }
  return -1;
}
int find_bad(int u) {
  vis[u] = 1;
  best[u] = u;
  for (auto v : G[u])
    if (vis[v] == 0) {
      lvl[v] = lvl[u] + 1;
      balance[u] += find_bad(v);
      if (lvl[best[v]] < lvl[best[u]]) best[u] = best[v];
    } else {
      balance[u]++;
      balance[v]--;
      if (lvl[v] < lvl[best[u]]) best[u] = v;
    }
  if (balance[u] > 1) bad[u] = true;
  return balance[u];
}
void propagate_bad(int u) {
  vis[u] = 1;
  if (!bad[u] && bad[best[u]]) bad[u] = true;
  for (auto v : G[u])
    if (vis[v] == 0) propagate_bad(v);
}
vector<int> find_all(int r) {
  for (int i = 1; i <= n; ++i) vis[i] = 0;
  vector<int> ans;
  find_bad(r);
  for (int i = 1; i <= n; ++i) vis[i] = 0;
  propagate_bad(r);
  for (int i = 1; i <= n; ++i)
    if (!bad[i]) ans.push_back(i);
  return ans;
}
void solve() {
  scanf("%d %d", &n, &m);
  for (int i = 1; i <= m; ++i) {
    int u, v;
    scanf("%d %d", &u, &v);
    G[u].push_back(v);
  }
  int id = find_any();
  if (id == -1) {
    no_answer();
    return;
  }
  auto ans = find_all(id);
  if (5 * ans.size() >= n) {
    for (auto v : ans) printf("%d ", v);
    puts("");
    clear();
  } else
    no_answer();
}
int main() {
  int cases;
  scanf("%d", &cases);
  while (cases--) solve();
  return 0;
}
