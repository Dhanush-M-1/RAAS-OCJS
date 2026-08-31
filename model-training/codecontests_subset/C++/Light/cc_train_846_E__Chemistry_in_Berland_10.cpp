#include <bits/stdc++.h>
using namespace std;
long long n, i, j, k, x, y, z, m, q, h, l, timer;
long long a[100500], b[100500], w[100500];
vector<pair<long long, long long> > g[100500];
void dfs(long long v, long long p = -1) {
  w[v] = a[v] - b[v];
  for (int i = 0; i < g[v].size(); i++) {
    long long to = g[v][i].first;
    if (to != p) {
      dfs(to, v);
      long long val = g[v][i].second;
      if (w[to] > 0)
        w[v] += w[to];
      else if (w[to] < 0) {
        long long cur = -w[to];
        if (cur > ((long long)1e+18) / val + 1 || w[v] < -(long long)1e+18) {
          cout << "NO" << endl;
          exit(0);
        }
        w[v] -= cur * val;
      }
    }
  }
}
int main() {
  cin >> n;
  for (i = 1; i <= n; i++) {
    cin >> a[i];
  }
  for (i = 1; i <= n; i++) {
    cin >> b[i];
  }
  for (i = 2; i <= n; i++) {
    cin >> x >> y;
    g[x].push_back(make_pair(i, y));
    g[i].push_back(make_pair(x, y));
  }
  dfs(1);
  if (w[1] < 0)
    cout << "NO" << endl;
  else
    cout << "YES" << endl;
  return 0;
}
