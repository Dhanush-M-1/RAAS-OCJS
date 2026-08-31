#include <bits/stdc++.h>
using namespace std;
int main() {
  int x0, y0, x1, y1;
  cin >> x0 >> y0 >> x1 >> y1;
  int n;
  cin >> n;
  int dx[] = {-1, 0, 1};
  int dy[] = {-1, 0, 1};
  int r, a, b;
  set<pair<int, int> > m;
  map<pair<int, int>, int> dist;
  for (int i = 1; i <= n; i++) {
    scanf("%d %d %d", &r, &a, &b);
    for (int j = a; j <= b; j++) {
      m.insert(make_pair(r, j));
    }
  }
  queue<pair<int, int> > q1;
  q1.push(make_pair(x0, y0));
  dist[make_pair(x0, y0)] = 0;
  while (!q1.empty()) {
    pair<int, int> coord = q1.front();
    q1.pop();
    if (coord.first == x1 && coord.second == y1) {
      cout << dist[coord] << endl;
      return 0;
    }
    for (int x : dx) {
      for (int y : dy) {
        if (x == 0 && y == 0) continue;
        pair<int, int> next = make_pair(coord.first + x, coord.second + y);
        if (m.find(next) != m.end() && !dist[next]) {
          q1.push(next);
          dist[next] = dist[coord] + 1;
        }
      }
    }
  }
  cout << "-1" << endl;
  return 0;
}
