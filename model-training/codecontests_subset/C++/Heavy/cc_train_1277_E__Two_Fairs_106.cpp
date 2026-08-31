#include <bits/stdc++.h>
using namespace std;
hash<string> hfn;
const int inf = 2e9;
const long long mod = 1e9 + 7;
const long double eps = 1e-7;
const long long biginf = 1e18;
int n, m, a, b;
vector<vector<int> > g;
vector<int> used;
long long cnt1 = 0, cnt2 = 0;
void dfs1(int cur) {
  used[cur] = true;
  cnt1++;
  for (auto to : g[cur]) {
    if (to != b && !used[to]) dfs1(to);
  }
}
void dfs2(int cur) {
  used[cur] = true;
  cnt2++;
  for (auto to : g[cur]) {
    if (to != a && !used[to]) dfs2(to);
  }
}
void solve() {
  cin >> n >> m >> a >> b;
  a--, b--;
  g.resize(n);
  used.resize(n, false);
  for (int i = 0; i < m; i++) {
    int f, t;
    cin >> f >> t;
    f--, t--;
    g[f].push_back(t);
    g[t].push_back(f);
  }
  dfs1(a);
  fill((used).begin(), (used).end(), false);
  dfs2(b);
  cout << (n - cnt1 - 1) * (n - cnt2 - 1) << endl;
  g.clear();
  used.clear();
  cnt1 = 0;
  cnt2 = 0;
}
void multisolve() {
  int t;
  cin >> t;
  while (t--) solve();
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  multisolve();
}
