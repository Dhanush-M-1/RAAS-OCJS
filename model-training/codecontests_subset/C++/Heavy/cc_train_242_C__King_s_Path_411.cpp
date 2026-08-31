#include <bits/stdc++.h>
using namespace std;
set<pair<int, int>> pts;
int main() {
  std::ios_base::sync_with_stdio(false);
  int x1, y1, x2, y2, n;
  cin >> x1 >> y1 >> x2 >> y2 >> n;
  for (int i = 0; i < (int)(n); ++i) {
    int r, a, b;
    cin >> r >> a >> b;
    for (int j = (a); j < (int)(b + 1); ++j) pts.insert({r, j});
  }
  map<pair<int, int>, int> len;
  queue<pair<int, int>> q;
  pair<int, int> s = {x1, y1};
  pair<int, int> cur;
  q.push(s), len[s] = 0;
  enum dir { d, r, u, l, ul, dr, ur, dl };
  int dx[8] = {1, 0, -1, 0, -1, 1, -1, 1};
  int dy[8] = {0, 1, 0, -1, -1, 1, 1, -1};
  int dep = 0, sz = 1;
  for (; !q.empty(); ++dep, sz = q.size()) {
    while (sz--) {
      cur = q.front(), q.pop();
      for (int d = 0; d < 8; ++d) {
        int nx = cur.first + dx[d];
        int ny = cur.second + dy[d];
        pair<int, int> newp = {nx, ny};
        if (pts.count(newp) == 0 || len.count(newp) != 0) continue;
        q.push(newp), len[newp] = dep + 1;
        if (newp.first == x2 && newp.second == y2) {
          cout << dep + 1;
          return 0;
        }
      }
    }
  }
  cout << -1;
  return 0;
}
