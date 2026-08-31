#include <bits/stdc++.h>
using namespace std;
const int N = 100 * 1000 + 5;
int xs, ys, xt, yt, n, a[N], b[N], r[N];
map<pair<int, int>, int> mark;
map<pair<int, int>, int> dist;
int dx[] = {1, -1, 0, 0, 1, 1, -1, -1};
int dy[] = {0, 0, 1, -1, 1, -1, 1, -1};
void bfs(int x, int y) {
  queue<pair<int, int> > q;
  dist[{x, y}] = 0;
  q.push({x, y});
  while (!q.empty()) {
    pair<int, int> p = q.front();
    q.pop();
    x = p.first, y = p.second;
    for (int i = 0; i < 8; i++) {
      int nx = x + dx[i], ny = y + dy[i];
      if (!mark[{nx, ny}])
        continue;
      else if (dist[{nx, ny}] > dist[{x, y}] + 1) {
        dist[{nx, ny}] = dist[{x, y}] + 1;
        q.push({nx, ny});
      }
    }
  }
}
void input() {
  cin >> xs >> ys >> xt >> yt >> n;
  for (int i = 0; i < n; i++) cin >> r[i] >> a[i] >> b[i];
}
void solve() {
  for (int i = 0; i < n; i++) {
    for (int j = a[i]; j <= b[i]; j++) {
      mark[{r[i], j}] = true;
      dist[{r[i], j}] = 1e9;
    }
  }
  bfs(xs, ys);
}
void output() {
  int ans = dist[{xt, yt}];
  if (ans == 1e9)
    cout << -1 << "\n";
  else
    cout << ans << "\n";
}
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  input();
  solve();
  output();
}
