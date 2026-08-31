#include <bits/stdc++.h>
using namespace std;
const int INF = (int)1e9 + 7;
const int MXN = (int)1e5 + 7;
int sx, sy, fx, fy, n;
int dx[] = {1, 1, 1, -1, -1, -1, 0, 0}, dy[] = {-1, 0, 1, -1, 0, 1, 1, -1};
map<pair<int, int>, bool> ok, u;
bool check(int x, int y) {
  return x <= 1e9 && y <= 1e9 && x > 0 && y > 0 && ok[make_pair(x, y)] &&
         !u[make_pair(x, y)];
}
int main() {
  scanf("%d%d%d%d", &sx, &sy, &fx, &fy);
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    int x, y, z;
    scanf("%d%d%d", &x, &y, &z);
    for (int pos = y; pos <= z; pos++) ok[make_pair(x, pos)] = true;
  }
  queue<int> moves;
  queue<pair<int, int> > q;
  moves.push(0);
  q.push(make_pair(sx, sy));
  if (!check(sx, sy)) {
    puts("-1");
    return 0;
  }
  u[make_pair(sx, sy)] = true;
  while (!q.empty()) {
    int cx = q.front().first;
    int cy = q.front().second;
    int ca = moves.front();
    if (cx == fx && cy == fy) {
      printf("%d", ca);
      return 0;
    }
    q.pop();
    moves.pop();
    for (int i = 0; i < 8; i++) {
      int nx = cx + dx[i];
      int ny = cy + dy[i];
      if (check(nx, ny)) {
        u[make_pair(nx, ny)] = true;
        q.push(make_pair(nx, ny));
        moves.push(ca + 1);
      }
    }
  }
  puts("-1");
  return 0;
}
