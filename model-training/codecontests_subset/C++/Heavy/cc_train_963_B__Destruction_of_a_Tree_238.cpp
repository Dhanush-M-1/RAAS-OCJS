#include <bits/stdc++.h>
using namespace std;
const long long MOD = 1000 * 1000 * 1000 + 7;
const int N = 2e5 + 6;
int n;
vector<int> g[N], ng[N], ans;
void dest(int v) {
  ans.push_back(v);
  for (auto to : ng[v]) {
    dest(to);
  }
}
bool dfs(int v, int root = false) {
  for (auto to : g[v]) {
    if (!dfs(to)) ng[v].push_back(to);
  }
  if ((ng[v].size() + root) % 2) {
    dest(v);
    return true;
  }
  return false;
}
int main() {
  mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
  cin >> n;
  if (n % 2 == 0) {
    cout << "NO" << endl;
    return 0;
  }
  cout << "YES" << endl;
  int root;
  for (int i = (1); i <= (n); ++i) {
    int p;
    cin >> p;
    if (!p) root = i;
    g[p].push_back(i);
  }
  dfs(root, true);
  for (int i = (0); i <= (n - 1); ++i) {
    cout << ans[i] << endl;
    assert(i < ans.size());
  }
  return 0;
}
