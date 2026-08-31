#include <bits/stdc++.h>
using namespace std;
vector<long long> v[1000050];
long long vis[1000050];
long long dfs(long long src) {
  long long n = 0;
  n++;
  vis[src] = 1;
  for (long long i = 0; i < v[src].size(); i++) {
    if (!vis[v[src][i]]) {
      n += dfs(v[src][i]);
    }
  }
  return n;
}
signed main() {
  long long t;
  cin >> t;
  while (t--) {
    long long n, m, a, b, x, y, j, k;
    cin >> n >> m >> a >> b;
    for (long long i = 1; i <= n; i++) {
      v[i].clear();
      vis[i] = 0;
    }
    for (long long i = 0; i < m; i++) {
      cin >> x >> y;
      v[x].push_back(y);
      v[y].push_back(x);
    }
    vis[b] = 1;
    j = n - dfs(a);
    for (long long i = 1; i <= n; i++) vis[i] = 0;
    vis[a] = 1;
    k = n - dfs(b);
    cout << (j - 1) * (k - 1) << endl;
  }
}
