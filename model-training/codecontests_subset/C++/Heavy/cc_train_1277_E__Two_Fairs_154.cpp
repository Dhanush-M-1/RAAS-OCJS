#include <bits/stdc++.h>
using namespace std;
const long long INF = 2e9 + 1;
const long long MOD = 998244353;
const long long MAXN = 5e3 + 100;
const long double EPS = 1e-12;
const long double PI = acos(-1);
const long long XX[] = {0, 0, 1, 1, 1, -1, -1, -1};
const long long YY[] = {1, -1, 1, -1, 0, 1, -1, 0};
const long long ALPH = 31;
const long long LEN = 20;
mt19937 gen(228);
void bye() {
  cout << "\n";
  exit(0);
}
struct Solution {
  int n, m;
  vector<vector<int> > g;
  vector<bool> used;
  void dfs(int v) {
    used[v] = 1;
    for (auto to : g[v]) {
      if (!used[to]) {
        dfs(to);
      }
    }
  }
  void solve() {
    cin >> n >> m;
    int a, b;
    cin >> a >> b;
    a--, b--;
    g.resize(n);
    used.resize(n);
    for (int i = 0; i < m; i++) {
      int u, v;
      cin >> u >> v;
      u--, v--;
      g[u].push_back(v);
      g[v].push_back(u);
    }
    long long left = 0, right = 0;
    used[b] = 1;
    dfs(a);
    for (auto v : used) {
      left += !v;
    }
    fill((used).begin(), used.end(), 0);
    used[a] = 1;
    dfs(b);
    for (auto v : used) {
      right += !v;
    }
    cout << left * right << "\n";
  }
};
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long TEST_COUNT = 1;
  cin >> TEST_COUNT;
  while (TEST_COUNT--) {
    Solution kek;
    kek.solve();
  }
}
