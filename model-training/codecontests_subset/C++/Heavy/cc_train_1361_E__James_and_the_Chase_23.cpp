#include <bits/stdc++.h>
using namespace std;
const int N = 100005;
default_random_engine e;
int n, m, vis[N];
vector<int> v[N];
bool ok;
void dfs(int pos) {
  vis[pos] = 1;
  for (auto &i : v[pos])
    if (!vis[i])
      dfs(i);
    else if (vis[i] == 2)
      ok = 0;
  vis[pos] = 2;
}
bool check(int pos) {
  for (int i = 1; i <= n; i++) vis[i] = 0;
  ok = 1;
  dfs(pos);
  return ok;
}
bool bad[N];
int dep[N], low[N], val[N];
int find_bad(int pos) {
  vis[pos] = 1;
  low[pos] = pos;
  for (auto &i : v[pos])
    if (!vis[i]) {
      dep[i] = dep[pos] + 1, val[pos] += find_bad(i);
      if (dep[low[i]] < dep[low[pos]]) low[pos] = low[i];
    } else {
      ++val[pos];
      --val[i];
      if (dep[i] < dep[low[pos]]) low[pos] = i;
    }
  if (val[pos] > 1) bad[pos] = 1;
  return val[pos];
}
void pushdown(int pos) {
  vis[pos] = 1;
  if (bad[low[pos]]) bad[pos] = 1;
  for (auto &i : v[pos])
    if (!vis[i]) pushdown(i);
}
int main() {
  ios::sync_with_stdio(false);
  e.seed(time(0));
  int T;
  cin >> T;
  while (T--) {
    cin >> n >> m;
    for (int i = 1; i <= n; i++) v[i].clear();
    uniform_int_distribution<int> u(1, n);
    int t1, t2, rt = -1;
    for (int i = 1; i <= m; i++) {
      cin >> t1 >> t2;
      v[t1].push_back(t2);
    }
    for (int t = 100; t > 0; --t) {
      int cur = u(e);
      if (check(cur)) {
        rt = cur;
        break;
      }
    }
    if (rt == -1) {
      cout << -1 << endl;
      continue;
    }
    for (int i = 1; i <= n; i++) vis[i] = dep[i] = low[i] = val[i] = bad[i] = 0;
    find_bad(rt);
    for (int i = 1; i <= n; i++) vis[i] = 0;
    pushdown(rt);
    vector<int> ans;
    for (int i = 1; i <= n; i++)
      if (!bad[i]) ans.push_back(i);
    if (5 * int(ans.size()) >= n) {
      for (auto &i : ans) cout << i << ' ';
      cout << endl;
      continue;
    }
    cout << -1 << endl;
  }
  return 0;
}
