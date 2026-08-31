#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t = 1;
  while (t--) {
    long long x0, y0, x1, y1, i, j, k, x, y, xn, yn;
    cin >> x0 >> y0 >> x1 >> y1;
    long long n;
    cin >> n;
    long long a, b, r, g, h;
    map<int, vector<pair<int, int>>> v;
    for (i = 0; i < n; i++) {
      cin >> r >> a >> b;
      v[r].push_back({a, b});
    }
    map<pair<long long, long long>, long long> vis;
    queue<pair<long long, long long>> q;
    q.push({x0, y0});
    vis[{x0, y0}] = 0;
    while (!q.empty()) {
      x = q.front().first;
      y = q.front().second;
      q.pop();
      if (x == x1 && y == y1) break;
      for (i = -1; i <= 1; i++) {
        for (j = -1; j <= 1; j++) {
          if (i == 0 && j == 0) continue;
          xn = x + i;
          yn = y + j;
          bool check = false;
          auto app = v.find(xn);
          if (app == v.end()) {
            continue;
          }
          auto z = app->second;
          for (h = 0; h < z.size(); h++) {
            if (z[h].first <= yn && z[h].second >= yn) {
              check = true;
              break;
            }
          }
          if (check && vis[{xn, yn}] == 0) {
            q.push({xn, yn});
            vis[{xn, yn}] = vis[{x, y}] + 1;
          }
        }
      }
    }
    if (vis[{x1, y1}] == 0)
      cout << -1;
    else
      cout << vis[{x1, y1}] << endl;
  }
  return 0;
}
