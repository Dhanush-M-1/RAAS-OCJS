#include <bits/stdc++.h>
using namespace std;
const int maxn = 100007, dx[8] = {1, 1, 1, 0, 0, -1, -1, -1},
          dy[8] = {1, 0, -1, 1, -1, 1, 0, -1};
int xs, ys, xt, yt, n, r[maxn], a[maxn], b[maxn], d[maxn] = {}, cnt = 0;
bool vis[maxn] = {};
vector<int> row, col[maxn];
vector<pair<int, int> > seg[maxn], cells[maxn];
int dist(int x, int y) {
  x = lower_bound(row.begin(), row.end(), x) - row.begin() + 1;
  y = lower_bound(cells[x].begin(), cells[x].end(), make_pair(y, 0)) -
      cells[x].begin();
  return d[cells[x][y].second];
}
void set_dist(int x, int y, int val) {
  x = lower_bound(row.begin(), row.end(), x) - row.begin() + 1;
  y = lower_bound(cells[x].begin(), cells[x].end(), make_pair(y, 0)) -
      cells[x].begin();
  d[cells[x][y].second] = val;
}
bool valid(int x, int y) {
  if (!binary_search(row.begin(), row.end(), x)) return 0;
  x = lower_bound(row.begin(), row.end(), x) - row.begin() + 1;
  if (!binary_search(col[x].begin(), col[x].end(), y)) return 0;
  return 1;
}
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  cin >> xs >> ys >> xt >> yt >> n;
  for (int i = 1; i <= n; ++i) {
    cin >> r[i] >> a[i] >> b[i];
    row.push_back(r[i]);
  }
  sort(row.begin(), row.end());
  for (int i = 1; i <= n; ++i)
    r[i] = lower_bound(row.begin(), row.end(), r[i]) - row.begin() + 1;
  for (int i = 1; i <= n; ++i) seg[r[i]].push_back({a[i], b[i]});
  for (int i = 1; i <= n; ++i) {
    if (vis[r[i]]) continue;
    sort(seg[r[i]].begin(), seg[r[i]].end());
    int cur = 1;
    for (auto it : seg[r[i]]) {
      cur = max(it.first, cur);
      for (int j = cur; j <= it.second; ++j)
        cells[r[i]].push_back({j, ++cnt}), col[r[i]].push_back(j);
    }
    vis[r[i]] = 1;
  }
  queue<pair<int, int> > q;
  q.push({xs, ys});
  set_dist(xs, ys, 1);
  while (q.size()) {
    int x = q.front().first, y = q.front().second;
    q.pop();
    for (int i = 0; i < 8; ++i) {
      int xx = dx[i] + x, yy = dy[i] + y;
      if (valid(xx, yy) && dist(xx, yy) == 0)
        set_dist(xx, yy, dist(x, y) + 1), q.push({xx, yy});
    }
  }
  cout << dist(xt, yt) - 1;
  return 0;
}
