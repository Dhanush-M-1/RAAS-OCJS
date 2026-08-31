#include <bits/stdc++.h>
using namespace std;
const int N = 1e9;
int ax, ay, bx, by;
int n;
set<pair<int, int>> s, vis;
struct point {
  int x, y, dis;
};
pair<int, int> adj[] = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1},
                        {0, 1},  {1, -1},  {1, 0},  {1, 1}};
bool check(int x, int y) {
  return x >= 0 and x <= N and y >= 0 and y <= N and
         s.find({x, y}) != s.end() and vis.find({x, y}) == vis.end();
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout << fixed;
  cout.precision(10);
  ;
  cin >> ax >> ay >> bx >> by;
  cin >> n;
  int r, a, b;
  for (int i = 0; i < n; i++) {
    cin >> r >> a >> b;
    for (int j = a; j <= b; j++) s.insert({r, j});
  }
  queue<point> q;
  q.push(point{ax, ay, 0});
  vis.insert({ax, ay});
  int ans = -1;
  while (!q.empty()) {
    point p = q.front();
    q.pop();
    int cx = p.x, cy = p.y, dis = p.dis;
    if (cx == bx and cy == by) {
      ans = dis;
      break;
    }
    for (auto i : adj) {
      int nx = cx + i.first, ny = cy + i.second;
      if (check(nx, ny)) {
        q.push(point{nx, ny, dis + 1});
        vis.insert({nx, ny});
      }
    }
  }
  cout << ans;
  return 0;
}
