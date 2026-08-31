#include <bits/stdc++.h>
using namespace std;
void write(vector<int> &v) {
  for (auto i : v) cout << i << " ";
  cout << "\n";
}
void read(vector<int> &v) {
  for (auto &i : v) cin >> i;
}
const int INF = 1e9;
const int64_t INFF = 1e18;
const int N = 1e6 + 69;
map<pair<int, int>, int> grid;
vector<int> dRow = {0, 1, 0, -1, 1, 1, -1, -1};
vector<int> dCol = {1, 0, -1, 0, 1, -1, -1, 1};
map<pair<int, int>, int> vis;
void solve() {
  int x0, x1, y0, y1;
  cin >> x0 >> y0 >> x1 >> y1;
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int r, c1, c2;
    cin >> r >> c1 >> c2;
    for (int j = c1; j <= c2; j++) {
      grid[{r, j}] = 1;
    }
  }
  queue<pair<int, int> > q;
  q.push({x0, y0});
  vis[{x0, y0}] = 1;
  bool exist = false;
  while (!q.empty()) {
    int x = q.front().first;
    int y = q.front().second;
    q.pop();
    for (int i = 0; i < 8; i++) {
      int newx = x + dRow[i], newy = y + dCol[i];
      if (vis[{newx, newy}] == 0 && grid[{newx, newy}] && 0 <= newx &&
          newx < (int)1e9 && 0 <= newy < (int)1e9) {
        vis[{newx, newy}] = vis[{x, y}] + 1;
        q.push({newx, newy});
        if (newx == x1 && newy == y1) {
          exist = true;
          break;
        }
      }
    }
    if (exist) break;
  }
  if (exist)
    cout << vis[{x1, y1}] - 1 << "\n";
  else
    cout << -1 << "\n";
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t = 1;
  for (int i = 1; i <= t; i++) {
    solve();
  }
  return 0;
}
