#include <bits/stdc++.h>
#pragma warning(disable : 4996)
using namespace std;
map<pair<int, int>, bool> matrix;
map<pair<int, int>, long long> d;
void bfs(int x, int y) {
  queue<pair<int, int> > q;
  q.push(make_pair(x, y));
  matrix[make_pair(x, y)] = false;
  while (!q.empty()) {
    auto v = q.front();
    q.pop();
    if (matrix[make_pair(v.first - 1, v.second)]) {
      matrix[make_pair(v.first - 1, v.second)] = false;
      q.push(make_pair(v.first - 1, v.second));
      d[make_pair(v.first - 1, v.second)] = d[v] + 1;
    }
    if (matrix[make_pair(v.first + 1, v.second)]) {
      matrix[make_pair(v.first + 1, v.second)] = false;
      q.push(make_pair(v.first + 1, v.second));
      d[make_pair(v.first + 1, v.second)] = d[v] + 1;
    }
    if (matrix[make_pair(v.first, v.second - 1)]) {
      matrix[make_pair(v.first, v.second - 1)] = false;
      q.push(make_pair(v.first, v.second - 1));
      d[make_pair(v.first, v.second - 1)] = d[v] + 1;
    }
    if (matrix[make_pair(v.first, v.second + 1)]) {
      matrix[make_pair(v.first, v.second + 1)] = false;
      q.push(make_pair(v.first, v.second + 1));
      d[make_pair(v.first, v.second + 1)] = d[v] + 1;
    }
    if (matrix[make_pair(v.first + 1, v.second + 1)]) {
      matrix[make_pair(v.first + 1, v.second + 1)] = false;
      q.push(make_pair(v.first + 1, v.second + 1));
      d[make_pair(v.first + 1, v.second + 1)] = d[v] + 1;
    }
    if (matrix[make_pair(v.first - 1, v.second + 1)]) {
      matrix[make_pair(v.first - 1, v.second + 1)] = false;
      q.push(make_pair(v.first - 1, v.second + 1));
      d[make_pair(v.first - 1, v.second + 1)] = d[v] + 1;
    }
    if (matrix[make_pair(v.first + 1, v.second - 1)]) {
      matrix[make_pair(v.first + 1, v.second - 1)] = false;
      q.push(make_pair(v.first + 1, v.second - 1));
      d[make_pair(v.first + 1, v.second - 1)] = d[v] + 1;
    }
    if (matrix[make_pair(v.first - 1, v.second - 1)]) {
      matrix[make_pair(v.first - 1, v.second - 1)] = false;
      q.push(make_pair(v.first - 1, v.second - 1));
      d[make_pair(v.first - 1, v.second - 1)] = d[v] + 1;
    }
  }
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int x0, y0, x1, y1, n;
  cin >> x0 >> y0 >> x1 >> y1 >> n;
  for (int i = 0; i < n; ++i) {
    int r, a, b;
    cin >> r >> a >> b;
    for (int j = a; j <= b; ++j) matrix[make_pair(r, j)] = true;
  }
  d[make_pair(x0, y0)] = 0;
  bfs(x0, y0);
  int ans = -1;
  if (d.find(make_pair(x1, y1)) != d.end()) ans = d[make_pair(x1, y1)];
  cout << ans;
}
