#include <bits/stdc++.h>
const double PI = 3.141592653589793238460;
using namespace std;
void kingsPath() {
  int i, j, di, dj;
  cin >> i >> j >> di >> dj;
  set<pair<int, int>> st;
  int t;
  cin >> t;
  int r, x, y;
  while (t--) {
    cin >> r >> x >> y;
    for (int i = x; i <= y; i++) st.insert({r, i});
  }
  queue<pair<pair<int, int>, int>> qu;
  qu.push({{i, j}, 0});
  int ans = -1;
  while (qu.size()) {
    pair<int, int> curr = qu.front().first;
    int moves = qu.front().second;
    qu.pop();
    i = curr.first;
    j = curr.second;
    if (st.find(curr) == st.end())
      continue;
    else
      st.erase(curr);
    if (curr.first == di && curr.second == dj) {
      ans = moves;
      break;
    }
    qu.push({{i - 1, j}, moves + 1});
    qu.push({{i - 1, j + 1}, moves + 1});
    qu.push({{i, j + 1}, moves + 1});
    qu.push({{i + 1, j + 1}, moves + 1});
    qu.push({{i + 1, j}, moves + 1});
    qu.push({{i + 1, j - 1}, moves + 1});
    qu.push({{i, j - 1}, moves + 1});
    qu.push({{i - 1, j - 1}, moves + 1});
  }
  cout << ans << '\n';
}
int main() { kingsPath(); }
