#include <bits/stdc++.h>
using namespace std;
map<int, map<int, bool> > ok;
int n, a, b, r;
int dx[] = {0, 0, 1, 1, 1, -1, -1, -1};
int dy[] = {1, -1, 1, 0, -1, 1, 0, -1};
bool vaild(int x, int y, int x1, int y1) {
  if (x > 0 && y > 0 && x <= 1e9 && y <= 1e9 && (x != x1 || y != y1) &&
      ok[x][y])
    return true;
  return false;
}
int dijkstra(int x1, int y1, int x2, int y2) {
  map<int, map<int, int> > dist;
  priority_queue<pair<int, pair<int, int> >,
                 vector<pair<int, pair<int, int> > >,
                 greater<pair<int, pair<int, int> > > >
      q;
  pair<int, pair<int, int> > p;
  p = {0, {x1, y1}};
  q.push(p);
  while (!q.empty()) {
    p = q.top();
    q.pop();
    int ux = p.second.first, uy = p.second.second, cost = p.first;
    if (ux == x2 && uy == y2) return cost;
    for (int i = 0; i < 8; i++) {
      int x = dx[i], y = dy[i];
      if (vaild(ux + x, uy + y, x1, y1) &&
          (dist[ux + x][uy + y] == 0 || dist[ux + x][uy + y] > cost + 1))
        dist[ux + x][uy + y] = cost + 1, p = {cost + 1, {ux + x, uy + y}},
                          q.push(p);
    }
  }
  return (dist[x2][y2] == 0 ? -1 : dist[x2][y2]);
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int x1, y1, x2, y2;
  cin >> x1 >> y1 >> x2 >> y2 >> n;
  while (n--) {
    cin >> r >> a >> b;
    for (int i = a; i <= b; i++) ok[r][i] = true;
  }
  cout << dijkstra(x1, y1, x2, y2);
  return 0;
}
