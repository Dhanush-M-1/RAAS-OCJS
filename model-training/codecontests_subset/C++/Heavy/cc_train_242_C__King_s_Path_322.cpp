#include <bits/stdc++.h>
using namespace std;
int dx[8] = {1, 0, -1, 0, -1, 1, -1, 1};
int dy[8] = {0, 1, 0, -1, -1, 1, 1, -1};
set<pair<int, int>> pnts;
int main() {
  long long x, y, a, b, n;
  cin >> x >> y >> a >> b >> n;
  for (int i = 0; i < (int)(n); ++i) {
    int r, a, b;
    cin >> r >> a >> b;
    for (int j = (a); j < (int)(b + 1); ++j) pnts.insert({r, j});
  }
  map<pair<int, int>, int> len;
  queue<pair<int, int>> q;
  pair<int, int> s;
  s = {x, y};
  q.push(s);
  int dep = 0, sz = 1;
  for (; !q.empty(); ++dep, sz = q.size()) {
    while (sz--) {
      pair<int, int> g;
      g = q.front();
      q.pop();
      pair<int, int> n;
      for (int i = 0; i < 8; i++) {
        n.first = g.first + dx[i];
        n.second = g.second + dy[i];
        if (pnts.count(n) == 0 || len.count(n) != 0) continue;
        len[n] = dep + 1;
        q.push(n);
        if (n.first == a && n.second == b) {
          cout << dep + 1;
          return 0;
        }
      }
    }
  }
  cout << -1;
  return 0;
}
