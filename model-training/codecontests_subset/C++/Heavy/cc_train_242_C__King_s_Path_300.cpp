#include <bits/stdc++.h>
using namespace std;
map<pair<int, int>, int> d;
queue<pair<int, int> > q;
int main() {
  int sx, sy, ex, ey, n, a, b, r;
  int dx[] = {-1, -1, -1, 0, 1, 1, 1, 0};
  int dy[] = {-1, 0, 1, 1, 1, 0, -1, -1};
  cin >> sx >> sy >> ex >> ey >> n;
  for (int i = 0; i < n; i++) {
    cin >> r >> a >> b;
    for (int j = a; j <= b; j++) d[make_pair(r, j)] = -1;
  }
  d[make_pair(sx, sy)] = 0;
  q.push(make_pair(sx, sy));
  while (q.size()) {
    pair<int, int> u = q.front();
    q.pop();
    for (int i = 0; i < 8; i++) {
      pair<int, int> v = make_pair(u.first + dx[i], u.second + dy[i]);
      if (d.count(v) && d[v] == -1) d[v] = d[u] + 1, q.push(v);
    }
  }
  printf("%d", d[make_pair(ex, ey)]);
  return 0;
}
