#include <bits/stdc++.h>
using namespace std;
const int N = (int)1e5 + 10;
int n;
vector<int> vs[N];
bool dfs(int node, int par) {
  if (par != -1 && vs[node].size() == 1) {
    return false;
  }
  int children = 0;
  bool bad = false;
  for (int v : vs[node])
    if (v != par) {
      ++children;
      bad |= dfs(v, node);
    }
  if (par != -1) bad |= children == 1;
  return bad;
}
void solve() {
  cin >> n;
  for (int i = 0; i < n - 1; ++i) {
    int u, v;
    cin >> u >> v, --u, --v;
    vs[u].push_back(v);
    vs[v].push_back(u);
  }
  int cnt = 0;
  bool bad = false;
  for (int i = 0; i < n && cnt < 2; ++i) {
    if (vs[i].size() == 1) {
      ++cnt;
      bad |= dfs(i, -1);
    }
  }
  cout << (bad ? "NO" : "YES") << endl;
}
int main() {
  cin.tie(0);
  ios::sync_with_stdio(false);
  cout.precision(20);
  cout << fixed;
  solve();
  return 0;
}
