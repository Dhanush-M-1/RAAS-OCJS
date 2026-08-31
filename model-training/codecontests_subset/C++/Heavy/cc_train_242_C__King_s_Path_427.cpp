#include <bits/stdc++.h>
using namespace std;
struct state {
  int x, y, cost;
};
int sx, sy, fs, fy, n, r, a, b;
map<pair<int, int>, int> mp, vis;
queue<state> q;
int dxx[] = {1, 0, -1, 0, -1, 1, 1, -1};
int dyy[] = {0, 1, 0, -1, -1, 1, -1, 1};
bool check(int x, int y) { return x > 0 && y > 0; }
int bfs() {
  state s;
  s.x = sx;
  s.y = sy;
  s.cost = 0;
  q.push(s);
  while (!q.empty()) {
    state cur = q.front();
    int ox = cur.x, oy = cur.y, cc = cur.cost;
    q.pop();
    if (cur.x == fs && cur.y == fy) return cur.cost;
    if (vis.count(make_pair(cur.x, cur.y))) continue;
    vis[make_pair(cur.x, cur.y)] = 1;
    for (int i = 0; i < 8; i++) {
      int nx = ox + dxx[i], ny = oy + dyy[i];
      if (check(nx, ny) && vis.count(make_pair(nx, ny)) == 0 &&
          mp.count(make_pair(nx, ny))) {
        state next;
        next.x = nx;
        next.y = ny;
        next.cost = cur.cost + 1;
        q.push(next);
      }
    }
  }
  return -1;
}
int main() {
  cin >> sx >> sy >> fs >> fy >> n;
  for (int i = 0; i < n; i++) {
    cin >> r >> a >> b;
    for (int j = a; j <= b; j++) mp[make_pair(r, j)] = 1;
  }
  printf("%d\n", bfs());
}
