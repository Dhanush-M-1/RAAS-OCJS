#include <bits/stdc++.h>
using namespace std;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
const int mxn = 100000, k = 100;
int n, m;
int it[mxn], d[mxn], first[mxn], vis[mxn], p[mxn];
vector<int> g[mxn];
vector<int> ans;
bool dfs(int c) {
  bool ret = 1;
  vis[c] = d[c] = 1;
  for (int i : g[c]) {
    if (!vis[i]) {
      ret &= dfs(i);
      first[c] += first[i];
      p[c] ^= p[i];
    } else if (!d[i]) {
      return 0;
    } else {
      first[i]--;
      first[c]++;
      p[c] ^= i;
      p[i] ^= i;
    }
  }
  d[c] = 0;
  return ret;
}
void dfs2(int c) {
  vis[c] = 1;
  if (!first[c] || (!~-first[c] && d[p[c]])) {
    d[c] = 1;
    ans.push_back(c + 1);
  }
  for (int i : g[c])
    if (!vis[i]) dfs2(i);
}
void answer() {
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    it[i] = i;
    g[i].clear();
  }
  for (int i = 0; i < m; i++) {
    int u, v;
    cin >> u >> v;
    u--, v--;
    g[u].push_back(v);
  }
  shuffle(it, it + n, rng);
  ans.clear();
  for (int i = 0; i < min(n, k); i++) {
    memset(vis, 0, sizeof(vis));
    memset(d, 0, n * sizeof(int));
    memset(first, 0, n * sizeof(int));
    memset(p, 0, n * sizeof(int));
    if (dfs(it[i])) {
      memset(vis, 0, n * sizeof(int));
      memset(d, 0, n * sizeof(int));
      dfs2(it[i]);
      break;
    }
  }
  int ret = ans.size();
  if (5 * ret < n) {
    cout << -1 << '\n';
  } else {
    sort(ans.begin(), ans.end());
    cout << ans[0];
    for (int i = 1; i < ret; i++) cout << " " << ans[i];
    cout << '\n';
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int t;
  cin >> t;
  for (int i = 0; i < t; i++) answer();
  return 0;
}
