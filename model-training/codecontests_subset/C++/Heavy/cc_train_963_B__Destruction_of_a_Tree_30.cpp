#include <bits/stdc++.h>
#pragma GCC optimize("-O2")
using namespace std;
void err(istream_iterator<string> it) {}
template <typename T, typename... Args>
void err(istream_iterator<string> it, T a, Args... args) {
  cerr << *it << " = " << a << endl;
  err(++it, args...);
}
const int LIM = 2e5 + 5, MOD = 1e9 + 7;
int t, n, m, k, x, y;
vector<vector<int> > v;
vector<int> deg;
vector<int> nchild;
int dfs(int i, int par) {
  int ans = 1;
  for (auto &it : v[i])
    if (it != par) ans += dfs(it, i);
  return nchild[i] = ans;
}
bool vs[LIM];
void solve(int i, int par) {
  if (vs[i]) return;
  if (deg[i] == 0) {
    cout << i + 1 << endl;
    vs[i] = 1;
    return;
  }
  int neven = 0;
  for (auto &it : v[i])
    if (!vs[it] && it != par && !(nchild[it] & 1)) neven++;
  if (neven == 0 && !(deg[i] & 1)) {
    cout << i + 1 << endl;
    vs[i] = 1;
    deg[i] = 0;
    for (auto &it : v[i]) deg[it]--;
    for (auto &it : v[i])
      if (!vs[it] && it != par) solve(it, i);
  } else {
    for (auto &it : v[i])
      if (!vs[it] && it != par) solve(it, i);
    neven = 0;
    for (auto &it : v[i])
      if (!vs[it] && it != par && !(nchild[it] & 1)) neven++;
    if (neven == 0 && !(deg[i] & 1)) {
      cout << i + 1 << endl;
      vs[i] = 1;
      deg[i] = 0;
      for (auto &it : v[i]) deg[it]--;
      for (auto &it : v[i])
        if (!vs[it] && it != par) solve(it, i);
    } else {
      return;
    }
  }
}
int main() {
  cin >> n;
  if (!(n & 1)) {
    cout << "NO" << endl;
    return 0;
  }
  v.assign(n, vector<int>(0));
  deg.assign(n, 0);
  nchild.assign(n, 0);
  for (int i = 0; i < n; i++) {
    cin >> x;
    if (x == 0) continue;
    x--;
    deg[x]++;
    deg[i]++;
    v[x].push_back(i);
    v[i].push_back(x);
  }
  dfs(0, -1);
  cout << "YES\n";
  solve(0, -1);
  return 0;
}
