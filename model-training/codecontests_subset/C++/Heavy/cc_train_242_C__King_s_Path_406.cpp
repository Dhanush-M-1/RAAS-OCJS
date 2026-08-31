#include <bits/stdc++.h>
using namespace std;
set<pair<int, int>> st;
set<pair<int, int>> visi;
const int dx[] = {1, 1, 1, 0, -1, -1, -1, 0},
          dy[] = {0, 1, -1, 1, 1, 0, -1, -1};
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int x0, y0, x1, y1, n, r, a, b, f = 1;
  cin >> x0 >> y0 >> x1 >> y1 >> n;
  for (auto i = (0); i < (n); i++) {
    cin >> r >> a >> b;
    for (auto j = (a); j < (b + 1); j++) st.insert({r, j});
  }
  queue<tuple<int, int, int>> qu;
  qu.push({x0, y0, 0});
  while (!qu.empty()) {
    int t1, t2, t3;
    tie(t1, t2, t3) = qu.front();
    qu.pop();
    if (st.find({t1, t2}) == st.end() || visi.find({t1, t2}) != visi.end())
      continue;
    visi.insert({t1, t2});
    if (t1 == x1 && t2 == y1) {
      cout << t3 << '\n';
      f = 0;
      break;
    } else
      for (auto i = (0); i < (8); i++)
        qu.push({t1 + dx[i], t2 + dy[i], t3 + 1});
  }
  if (f) cout << "-1\n";
  return 0;
}
