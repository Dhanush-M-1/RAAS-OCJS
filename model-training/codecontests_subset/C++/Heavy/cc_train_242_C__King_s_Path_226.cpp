#include <bits/stdc++.h>
using namespace std;
void solve() {
  long long x0, y0, x1, y1;
  cin >> x0 >> y0 >> x1 >> y1;
  map<pair<long long, long long>, long long> dist;
  map<pair<long long, long long>, bool> ok;
  long long m;
  cin >> m;
  while (m--) {
    long long r, a, b;
    cin >> r >> a >> b;
    for (long long i = a; i <= b; i++) ok[{r, i}] = true;
  }
  queue<pair<long long, long long>> q;
  q.push({x0, y0});
  dist[{x0, y0}] = 0;
  map<pair<long long, long long>, bool> vis;
  vis[{x0, y0}] = true;
  while (!q.empty()) {
    long long x = q.front().first;
    long long y = q.front().second;
    q.pop();
    for (long long j = -1; j <= 1; j++) {
      for (long long i = -1; i <= 1; i++) {
        if (ok[{x + i, y + j}] && !vis[{x + i, y + j}]) {
          dist[{x + i, y + j}] = dist[{x, y}] + 1;
          q.push({x + i, y + j});
          vis[{x + i, y + j}] = true;
          ok[{x + i, y + j}] = false;
        }
      }
    }
  }
  if (!dist[{x1, y1}]) {
    cout << -1;
    return;
  }
  cout << dist[{x1, y1}];
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  long long t = 1;
  while (t--) {
    solve();
  }
}
