#include <bits/stdc++.h>
using namespace std;
int dy[] = {1, -1, 1, 1, -1, -1, 0, 0};
int dx[] = {0, 0, 1, -1, 1, -1, 1, -1};
map<int, vector<pair<int, int> > > allowed;
bool valid(int r, int c) {
  if (r <= 10e9 && c <= 10e9 && r >= 0 && c >= 0)
    for (auto v : allowed[r]) {
      if (c >= v.first && c <= v.second) return true;
    }
  return false;
}
int bfs(int x1, int y1, int x2, int y2, int c) {
  queue<pair<pair<int, int>, int> > q;
  q.push(make_pair(make_pair(x1, y1), c));
  map<pair<int, int>, int> vis;
  while (!q.empty()) {
    pair<pair<int, int>, int> u = q.front();
    q.pop();
    if (u.first.first == x2 && u.first.second == y2) {
      return u.second;
    }
    if (++vis[u.first] > 1) continue;
    u.second++;
    for (int i = 0; i < 8; i++) {
      int r2 = u.first.first + dy[i];
      int c2 = u.first.second + dx[i];
      if (valid(r2, c2)) {
        q.push(make_pair(make_pair(r2, c2), u.second));
      }
    }
  }
  return -1;
}
int main() {
  ios_base::sync_with_stdio(false);
  int x1, y1, x2, y2;
  cin >> x1 >> y1 >> x2 >> y2;
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int t1, t2, t3;
    cin >> t1 >> t2 >> t3;
    allowed[t1].push_back(make_pair(t2, t3));
  }
  cout << bfs(x1, y1, x2, y2, 0) << endl;
  return 0;
}
