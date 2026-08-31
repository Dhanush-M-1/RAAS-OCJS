#include <bits/stdc++.h>
using namespace std;
template <typename T1, typename T2>
inline void chkmin(T1 &a, T2 b) {
  if (a > b) a = b;
}
template <typename T1, typename T2>
inline void chkmax(T1 &a, T2 b) {
  if (a < b) a = b;
}
using ll = long long;
using ld = long double;
const string FILENAME = "input";
const int MAXN = 200228;
int n, m;
vector<int> g[MAXN];
bool bad[MAXN];
int used[MAXN];
int deep[MAXN];
int opt[MAXN];
int bal[MAXN];
bool ok = false;
mt19937 as(272727);
void dfs(int u) {
  used[u] = 1;
  for (auto h : g[u]) {
    if (used[h] == 0) {
      dfs(h);
    } else if (used[h] == 2) {
      ok = false;
    }
  }
  used[u] = 2;
}
bool check(int u) {
  fill(used, used + n + 1, 0);
  ok = true;
  dfs(u);
  return ok;
}
int dfs1(int u) {
  used[u] = 1;
  opt[u] = u;
  for (auto v : g[u]) {
    if (used[v] == 0) {
      deep[v] = deep[u] + 1;
      bal[u] += dfs1(v);
      if (deep[opt[v]] < deep[opt[u]]) {
        opt[u] = opt[v];
      }
    } else {
      bal[u]++;
      bal[v]--;
      if (deep[v] < deep[opt[u]]) {
        opt[u] = v;
      }
    }
  }
  if (bal[u] > 1) {
    bad[u] = true;
  }
  return bal[u];
}
void dfs2(int u) {
  used[u] = 1;
  if (!bad[u] && bad[opt[u]]) {
    bad[u] = true;
  }
  for (auto v : g[u]) {
    if (used[v] == 0) {
      dfs2(v);
    }
  }
}
void solve() {
  cin >> n >> m;
  for (int i = 0; i < m; i++) {
    int a, b;
    cin >> a >> b;
    g[a].push_back(b);
  }
  int id = -1;
  for (int it = 0; it < 100; it++) {
    int u = as() % n + 1;
    if (check(u)) {
      id = u;
      break;
    }
  }
  if (id == -1) {
    cout << -1 << '\n';
  } else {
    fill(used, used + n + 1, 0);
    dfs1(id);
    fill(used, used + n + 1, 0);
    dfs2(id);
    vector<int> ans;
    for (int i = 1; i <= n; i++) {
      if (!bad[i]) {
        ans.push_back(i);
      }
    }
    if ((int)(ans).size() * 5 >= n) {
      for (auto x : ans) {
        cout << x << ' ';
      }
      cout << '\n';
    } else {
      cout << -1 << '\n';
    }
  }
  for (int i = 0; i <= n; i++) {
    g[i].clear();
    deep[i] = 0;
    opt[i] = 0;
    bad[i] = false;
    used[i] = 0;
    bal[i] = 0;
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int t;
  cin >> t;
  while (t--) {
    solve();
  }
  return 0;
}
