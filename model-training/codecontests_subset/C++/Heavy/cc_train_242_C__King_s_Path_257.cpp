#include <bits/stdc++.h>
using namespace std;
map<pair<int, int>, int> valid, dist;
int solve(int x0, int y0, int x1, int y1) {
  queue<pair<int, int> > q;
  q.push(pair<int, int>(x0, y0));
  dist[pair<int, int>(x0, y0)] = 0;
  while (!q.empty()) {
    pair<int, int> f = q.front();
    q.pop();
    int x = f.first, y = f.second;
    if (x == x1 && y == y1) return dist[pair<int, int>(x, y)];
    for (int dx = -1; dx <= 1; dx++)
      for (int dy = -1; dy <= 1; dy++) {
        int xx = x + dx, yy = y + dy;
        if (valid[pair<int, int>(xx, yy)] &&
            dist.count(pair<int, int>(xx, yy)) == 0) {
          dist[pair<int, int>(xx, yy)] = dist[pair<int, int>(x, y)] + 1;
          q.push(pair<int, int>(xx, yy));
        }
      }
  }
  return -1;
}
int main() {
  cout.sync_with_stdio(false);
  cin.tie(NULL);
  int x0, y0, x1, y1;
  cin >> x0 >> y0 >> x1 >> y1;
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int r, a, b;
    cin >> r >> a >> b;
    for (int j = a; j <= b; j++) valid[pair<int, int>(r, j)] = 1;
  }
  cout << solve(x0, y0, x1, y1) << endl;
  return 0;
}
