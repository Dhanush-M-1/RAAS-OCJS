#include <bits/stdc++.h>
using namespace std;
int x[3], y[3], T, res;
int dx[] = {-1, -1, -1, 0, 1, 1, 1, 0};
int dy[] = {-1, 0, 1, 1, 1, 0, -1, -1};
map<pair<int, int>, int> Ok, dis, vis;
bool isValid(int x, int y) {
  return (x >= 0 && y >= 0 && Ok[make_pair(x, y)] && !vis[make_pair(x, y)]);
}
void bfs(pair<int, int> v) {
  queue<pair<int, int>> q;
  q.push(v), vis[v] = 1;
  while (q.size()) {
    int x = q.front().first, y = q.front().second;
    q.pop();
    for (int i = 0; i < 8; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (isValid(nx, ny))
        q.push({nx, ny}), dis[make_pair(nx, ny)] = dis[make_pair(x, y)] + 1,
                                            vis[make_pair(nx, ny)] = 1;
    }
  }
}
int main() {
  ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  cin >> x[0] >> y[0] >> x[1] >> y[1] >> T;
  while (T--) {
    int r, x, y;
    cin >> r >> x >> y;
    for (int i = x; i <= y; i++) Ok[make_pair(r, i)] = 1;
  }
  bfs({x[0], y[0]});
  res = dis[make_pair(x[1], y[1])];
  return cout << (!res ? -1 : res) << endl, 0;
}
