#include <bits/stdc++.h>
using namespace std;
int dx[] = {-1, -1, 1, 1, 0, 1, 0, -1};
int dy[] = {-1, 1, -1, 1, 1, 0, -1, 0};
const int N = 2e5 + 10, M = 1e6 + 10, OOm = 0x3f3f3f3f;
string blank = "";
int xO, yO, xN, yN, n;
map<int, set<int>> segments;
map<pair<int, int>, bool> vis;
bool valid(int x, int y) {
  if (segments.find(x) != segments.end())
    if (segments[x].count(y)) return true;
  return false;
}
int bfs() {
  queue<pair<int, pair<int, int>>> q;
  q.push({0, {xO, yO}});
  while (!q.empty()) {
    auto cell = q.front();
    q.pop();
    for (int i = 0; i < 8; i++) {
      int nx = cell.second.first + dx[i];
      int ny = cell.second.second + dy[i];
      if (valid(nx, ny) && !vis[{nx, ny}]) {
        vis[{nx, ny}] = true;
        if (nx == xN && ny == yN) return cell.first + 1;
        q.push({cell.first + 1, {nx, ny}});
      }
    }
  }
  return -1;
}
void solve() {
  cin >> xO >> yO >> xN >> yN >> n;
  for (int i = 0; i < n; i++) {
    int r, a, b;
    cin >> r >> a >> b;
    for (int i = a; i <= b; i++) {
      segments[r].insert(i);
    }
  }
  cout << bfs();
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  solve();
  cerr << "Time elapsed: " << clock() / 1000 << " ms" << endl;
}
