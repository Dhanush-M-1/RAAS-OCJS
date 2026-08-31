#include <bits/stdc++.h>
using namespace std;
int power(int x, unsigned int y) {
  int res = 1;
  while (y > 0) {
    if (y & 1) {
      res = res * x;
    }
    y = y >> 1;
    x = x * x;
  }
  return res;
}
int powermod(int x, unsigned int y, int p) {
  int res = 1;
  x = x % p;
  while (y > 0) {
    if (y & 1) {
      res = (res * x) % p;
    }
    y = y >> 1;
    x = (x * x) % p;
  }
  return res;
}
int Mod(int x, int m) { return (x % m + m) % m; }
int min(int a, int b) { return a < b ? a : b; }
int max(int a, int b) { return a > b ? a : b; }
const int mxn = 2e5 + 5;
map<pair<int, int>, int> p;
vector<int> g[mxn];
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  int a, b, c, d;
  cin >> a >> b >> c >> d;
  int k;
  cin >> k;
  int n = 0;
  vector<pair<int, pair<int, int>>> v;
  for (int i = 0; i < k; i++) {
    int a, b, c;
    cin >> a >> b >> c;
    v.push_back(make_pair(a, make_pair(b, c)));
  }
  sort(v.begin(), v.end());
  for (int j = 0; j < k; j++) {
    int l, r;
    int row;
    row = v[j].first;
    l = v[j].second.first;
    r = v[j].second.second;
    for (int i = l; i <= r; i++) {
      if (!p.count({row, i})) {
        p[{row, i}] = n;
        n++;
      }
      if (p.count({row, i - 1})) {
        g[p[{row, i}]].push_back(p[{row, i - 1}]);
        g[p[{row, i - 1}]].push_back(p[{row, i}]);
      }
      if (p.count({row, i + 1})) {
        g[p[{row, i}]].push_back(p[{row, i + 1}]);
        g[p[{row, i + 1}]].push_back(p[{row, i}]);
      }
      if (p.count({row - 1, i})) {
        g[p[{row, i}]].push_back(p[{row - 1, i}]);
        g[p[{row - 1, i}]].push_back(p[{row, i}]);
      }
      if (p.count({row - 1, i - 1})) {
        g[p[{row, i}]].push_back(p[{row - 1, i - 1}]);
        g[p[{row - 1, i - 1}]].push_back(p[{row, i}]);
      }
      if (p.count({row - 1, i + 1})) {
        g[p[{row, i}]].push_back(p[{row - 1, i + 1}]);
        g[p[{row - 1, i + 1}]].push_back(p[{row, i}]);
      }
      if (p.count({row + 1, i + 1})) {
        g[p[{row, i}]].push_back(p[{row + 1, i + 1}]);
        g[p[{row + 1, i + 1}]].push_back(p[{row, i}]);
      }
      if (p.count({row + 1, i - 1})) {
        g[p[{row, i}]].push_back(p[{row + 1, i - 1}]);
        g[p[{row + 1, i - 1}]].push_back(p[{row, i}]);
      }
    }
  }
  int s = p[make_pair(a, b)];
  int f = p[make_pair(c, d)];
  queue<pair<int, int>> q;
  q.push(make_pair(s, 0));
  int vis[n + 1];
  memset(vis, 0, sizeof(vis));
  while (!q.empty()) {
    int u = q.front().first;
    int d = q.front().second;
    q.pop();
    if (u == f) {
      cout << d << '\n';
      exit(0);
    }
    for (auto x : g[u]) {
      if (!vis[x]) {
        q.push(make_pair(x, d + 1));
        vis[x] = 1;
      }
    }
  }
  cout << -1 << '\n';
  return 0;
}
