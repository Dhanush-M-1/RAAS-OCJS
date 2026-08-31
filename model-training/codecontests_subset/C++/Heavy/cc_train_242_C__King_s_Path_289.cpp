#include <bits/stdc++.h>
using namespace std;
const int N = 100005;
int x0, Y0, x1, Y1;
int n;
set<pair<int, int> > g, vis;
int dir[8][2] = {{0, 1},  {1, 1},   {1, 0},  {1, -1},
                 {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
map<pair<int, int>, int> dist;
bool bfs(int x, int y) {
  queue<pair<int, int> > q;
  q.push(pair<int, int>(x, y));
  dist[pair<int, int>(x, y)] = 0;
  while (!q.empty()) {
    x = q.front().first;
    y = q.front().second;
    q.pop();
    if (x == x1 and y == Y1) return 1;
    for (int i = 0; i < 8; i++) {
      int nx = x + dir[i][0];
      int ny = y + dir[i][1];
      if (g.count(pair<int, int>(nx, ny)) and
          !vis.count(pair<int, int>(nx, ny))) {
        q.push(pair<int, int>(nx, ny));
        vis.insert(pair<int, int>(nx, ny));
        dist[pair<int, int>(nx, ny)] = dist[pair<int, int>(x, y)] + 1;
      }
    }
  }
  return 0;
}
int main(void) {
  scanf("%d%d%d%d", &x0, &Y0, &x1, &Y1);
  scanf("%d", &n);
  int r, a, b;
  for (int i = 0; i < n; i++) {
    scanf("%d%d%d", &r, &a, &b);
    for (int j = a; j <= b; j++) {
      g.insert(pair<int, int>(r, j));
    }
  }
  bool ok = bfs(x0, Y0);
  if (ok) {
    printf("%d\n", dist[pair<int, int>(x1, Y1)]);
  } else {
    printf("-1\n");
  }
  return 0;
}
