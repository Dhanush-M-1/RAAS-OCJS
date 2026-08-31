#include <bits/stdc++.h>
using namespace std;
int n;
int x, y, a, b;
map<int, vector<pair<int, int>>> m;
map<pair<int, int>, bool> vis;
int solve() {
  queue<pair<int, int>> qu;
  queue<int> cst;
  qu.push({x, y});
  cst.push(0);
  vis[{x, y}] = 1;
  while (!qu.empty()) {
    pair<int, int> cur = qu.front();
    int cost = cst.front();
    qu.pop();
    cst.pop();
    if (cur == make_pair(a, b)) {
      return cost;
    }
    for (int j = -1; j < 2; j++) {
      for (int i = 0; i < m[cur.first + j].size(); i++) {
        pair<int, int> c = m[cur.first + j][i];
        for (int k = -1; k < 2; k++) {
          if (cur.second + k >= c.first && cur.second + k <= c.second) {
            if (!vis[{cur.first + j, cur.second + k}]) {
              qu.push({cur.first + j, cur.second + k});
              cst.push(cost + 1);
              vis[{cur.first + j, cur.second + k}] = 1;
            }
          }
        }
      }
    }
  }
  return -1;
}
int main() {
  ios::sync_with_stdio(0);
  cin >> x >> y >> a >> b;
  cin >> n;
  x--, y--, a--, b--;
  while (n--) {
    int r, i, j;
    cin >> r >> i >> j;
    r--, i--, j--;
    bool ps = true;
    for (int k = 0; k < m[r].size(); k++) {
      pair<int, int> second = m[r][k];
      if (second.first <= i && second.second >= j) {
        ps = false;
        break;
      } else if ((second.first >= i && second.second <= j)) {
        m[r][k] = {i, j};
        ps = false;
        break;
      } else if (second.first > i && second.first == j) {
        m[r][k] = {i, second.second};
        ps = false;
        break;
      } else if (second.second < j && second.second == i) {
        m[r][k] = {second.first, j};
        ps = false;
        break;
      }
    }
    if (ps) m[r].push_back({i, j});
  }
  cout << solve();
  return 0;
}
