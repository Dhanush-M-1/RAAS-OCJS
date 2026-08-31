#include <bits/stdc++.h>
using namespace std;
template <typename G>
struct triple {
  G first, S1, S2, T;
};
mt19937 rng(chrono::high_resolution_clock::now().time_since_epoch().count());
template <typename T>
static T randint(T lo, T hi) {
  return uniform_int_distribution<T>(lo, hi)(rng);
}
struct DS {
  vector<int> parent, cont;
  vector<bool> interesting;
  DS(int n) : parent(n), cont(n, 1), interesting(n, true) {
    for (int i = 0; i < n; i++) parent[i] = i;
  }
  int SetOf(int x) {
    return parent[x] = (parent[x] == x ? x : SetOf(parent[x]));
  }
  void Merge(int x, int y) {
    x = SetOf(x);
    y = SetOf(y);
    if (x == y) return;
    if (cont[x] > cont[y]) swap(x, y);
    parent[x] = y;
    cont[y] += cont[x];
    interesting[y] = (interesting[y] & interesting[x]);
  }
};
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    vector<vector<int>> g(n);
    for (int i = 0; i < m; i++) {
      int x, y;
      cin >> x >> y;
      --x;
      --y;
      g[x].push_back(y);
    }
    vector<int> seen(n);
    function<bool(int)> dfs1 = [&](int c) {
      bool ok = true;
      seen[c] = -1;
      for (auto v : g[c]) ok &= (seen[v] == -1 || (seen[v] == 0 && dfs1(v)));
      seen[c] = 1;
      return ok;
    };
    bool found = false;
    int r = -1;
    for (int i = 0; i < 100; i++) {
      r = randint(0, n - 1);
      if (dfs1(r)) {
        found = true;
        break;
      }
      for (int j = 0; j < n; j++) seen[j] = 0;
    }
    if (!found) {
      cout << "-1\n";
      continue;
    }
    for (int i = 0; i < n; i++) seen[i] = 0;
    vector<int> p(n);
    vector<int> a(n);
    function<void(int)> dfs2 = [&](int c) {
      seen[c] = -1;
      for (auto v : g[c])
        if (seen[v] == 0) {
          p[v] = p[c] + 1;
          dfs2(v);
          a[c] += a[v];
        } else {
          ++a[c];
          --a[v];
        }
      seen[c] = 1;
    };
    dfs2(r);
    DS ds(n);
    for (int i = 0; i < n; i++)
      if (a[i] > 1) ds.interesting[i] = false;
    for (auto &i : seen) i = 0;
    function<int(int)> dfs3 = [&](int c) {
      int up = -1;
      seen[c] = -1;
      for (auto v : g[c])
        if (seen[v] == 0) {
          int temp = dfs3(v);
          if (p[temp] < p[c] && (up == -1 || p[up] > p[temp])) up = temp;
        } else {
          int temp = v;
          if (up == -1 || p[up] > p[temp]) up = temp;
        }
      seen[c] = 1;
      if (up != -1 && a[c] <= 1) {
        ds.Merge(c, up);
      }
      return up;
    };
    dfs3(r);
    vector<int> ans;
    for (int i = 0; i < n; i++)
      if (ds.interesting[ds.SetOf(i)]) ans.push_back(i);
    sort(ans.begin(), ans.end());
    if (ans.size() * 5 < n)
      cout << "-1\n";
    else
      for (int i = 0; i < ans.size(); i++)
        cout << ans[i] + 1 << " \n"[i == ans.size() - 1];
  }
  return 0;
}
