#include <bits/stdc++.h>
using namespace std;
const long double pi = acos(-1);
const long double eps = 1e-9;
const int mod = 1e9 + 7;
mt19937 rng(
    (unsigned int)chrono::steady_clock::now().time_since_epoch().count());
template <typename T>
static T randint(T lo, T hi) {
  return uniform_int_distribution<T>(lo, hi)(rng);
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    vector<vector<int> > g(n);
    for (int i = 0; i < m; i++) {
      int u, v;
      cin >> u >> v;
      u--, v--;
      assert(u != v);
      g[u].push_back(v);
    }
    auto interesting = [&](int r) {
      vector<bool> mark(n), p(n);
      bool ok = true;
      function<void(int)> dfs = [&](int u) {
        mark[u] = p[u] = true;
        for (int v : g[u]) {
          if (!mark[v])
            dfs(v);
          else if (!p[v])
            ok = false;
        }
        p[u] = false;
      };
      dfs(r);
      return ok;
    };
    int r = -1;
    for (int i = 0; i < 100; i++) {
      int u = randint<int>(0, n - 1);
      if (interesting(u)) {
        r = u;
        break;
      }
    }
    if (r == -1) {
      cout << -1 << '\n';
      continue;
    }
    vector<int> mark(n), up(n, -1);
    function<multiset<int> *(int)> dfs = [&](int u) {
      mark[u] = true;
      vector<multiset<int> *> e;
      vector<int> b;
      int big = 0, who = -1;
      for (int v : g[u]) {
        if (!mark[v]) {
          e.push_back(dfs(v));
          if (big < (int)e.back()->size()) {
            big = e.back()->size();
            who = e.size() - 1;
          }
        } else {
          b.push_back(v);
        }
      }
      multiset<int> *ret;
      if (who != -1)
        ret = e[who];
      else
        ret = new multiset<int>();
      for (int i : b) ret->insert(i);
      int sz = e.size();
      for (int i = 0; i < sz; i++)
        if (i != who)
          for (int j : *e[i]) ret->insert(j);
      if (ret->count(u)) ret->erase(u);
      if (ret->size() == 1) up[u] = *(ret->begin());
      return ret;
    };
    dfs(r);
    fill(mark.begin(), mark.end(), false);
    vector<bool> is(n);
    is[r] = true;
    function<void(int)> dfs1 = [&](int u) {
      mark[u] = true;
      if (up[u] != -1 && is[up[u]]) is[u] = true;
      for (int v : g[u]) {
        if (mark[v]) continue;
        dfs1(v);
      }
    };
    dfs1(r);
    int ans = count(is.begin(), is.end(), true);
    if (5 * ans < n) {
      cout << -1 << '\n';
      continue;
    }
    for (int i = 0; i < n; i++)
      if (is[i]) {
        ans--;
        cout << i + 1 << " \n"[!ans];
      }
  }
  return 0;
}
