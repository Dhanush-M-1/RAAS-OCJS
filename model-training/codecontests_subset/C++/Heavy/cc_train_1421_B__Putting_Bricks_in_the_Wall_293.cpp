#include <bits/stdc++.h>
using namespace std;
char _grid[300][300], grid[300][300];
long long vis[300][300];
long long n, m;
long long di[] = {0, 0, -1, 1};
long long dj[] = {-1, 1, 0, 0};
bool isPos(long long i, long long j) {
  return (i >= 0 and j >= 0 and i < n and j < n and !vis[i][j]);
}
void dfs(long long i, long long j) {
  vis[i][j] = true;
  for (long long k = 0; k < 4; k++) {
    long long ni = i + di[k], nj = j + dj[k];
    if (isPos(ni, nj) and grid[ni][nj] == grid[i][j]) dfs(ni, nj);
  }
}
void solve() {
  cin >> n;
  for (long long i = 0; i < n; i++) {
    for (long long j = 0; j < n; j++) cin >> _grid[i][j];
  }
  vector<vector<pair<long long, long long>>> a;
  pair<long long, long long> p1{1, 0};
  pair<long long, long long> p2{0, 1};
  pair<long long, long long> p3{n - 2, n - 1};
  pair<long long, long long> p4{n - 1, n - 2};
  a.push_back({});
  a.push_back({p1});
  a.push_back({p2});
  a.push_back({p3});
  a.push_back({p4});
  a.push_back({p1, p2});
  a.push_back({p1, p3});
  a.push_back({p1, p4});
  a.push_back({p2, p3});
  a.push_back({p2, p4});
  a.push_back({p3, p4});
  for (auto v : a) {
    auto change = [&](long long i, long long j) {
      if (grid[i][j] == '1')
        grid[i][j] = '0';
      else
        grid[i][j] = '1';
    };
    memset(vis, 0, sizeof(vis));
    for (long long i = 0; i < n; i++) {
      for (long long j = 0; j < n; j++) grid[i][j] = _grid[i][j];
    }
    for (auto it : v) change(it.first, it.second);
    dfs(1, 0);
    dfs(0, 1);
    if (vis[n - 2][n - 1] or vis[n - 1][n - 2]) continue;
    cout << (long long)v.size() << endl;
    for (auto it : v) cout << it.first + 1 << " " << it.second + 1 << endl;
    return;
  }
}
int32_t main() {
  ios_base::sync_with_stdio(false), cin.tie(nullptr), cin.tie(nullptr);
  long long t_c = 1;
  cin >> t_c;
  while (t_c--) solve();
}
