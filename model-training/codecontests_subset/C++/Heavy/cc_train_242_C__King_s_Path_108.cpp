#include <bits/stdc++.h>
using namespace std;
int dx[8] = {0, 0, 1, 1, 1, -1, -1, -1};
int dy[8] = {-1, 1, 0, 1, -1, 0, 1, -1};
map<pair<int, int>, int> vis;
map<pair<int, int>, int> dis;
bool valid(int x, int y) { return (x > 0 && x <= 1e9 && y > 0 && y <= 1e9); }
queue<pair<int, int> > q;
void bfs(int u, int v) {
  q.push(make_pair(u, v));
  while (!q.empty()) {
    pair<int, int> p = q.front();
    u = p.first;
    v = p.second;
    q.pop();
    for (int i = 0; i < 8; i++) {
      int x = u + dx[i];
      int y = v + dy[i];
      if (valid(x, y)) {
        if (vis[make_pair(x, y)])
          vis[make_pair(x, y)] = 0,
                           dis[make_pair(x, y)] = dis[make_pair(u, v)] + 1,
                           q.push(make_pair(x, y));
      }
    }
  }
}
int main() {
  int x, y, x0, y0;
  cin >> x >> y >> x0 >> y0;
  int n;
  cin >> n;
  while (n--) {
    int r, a, b;
    scanf("%d %d %d", &r, &a, &b);
    for (int i = a; i <= b; i++) {
      vis[make_pair(r, i)] = 1;
    }
  }
  bfs(x, y);
  if (dis[make_pair(x0, y0)])
    cout << dis[make_pair(x0, y0)];
  else
    cout << -1;
  return 0;
}
