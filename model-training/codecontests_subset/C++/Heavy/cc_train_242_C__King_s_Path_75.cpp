#include <bits/stdc++.h>
using namespace std;
map<pair<int, int>, int> mp;
map<pair<int, int>, int> dis;
map<pair<int, int>, bool> vis;
bool canplace(int row, int col) {
  if (row > 0 and row <= 1e9 and col > 0 and col <= 1e9 and
      mp[pair<int, int>(row, col)] == 1 and
      vis[pair<int, int>(row, col)] == false)
    return true;
  return false;
}
int bfs(int x0, int y0, int x1, int y1) {
  int row[8] = {-1, 0, 1, 1, 1, 0, -1, -1};
  int col[8] = {1, 1, 1, 0, -1, -1, -1, 0};
  queue<pair<int, int>> q;
  q.push(pair<int, int>(x0, y0));
  vis[pair<int, int>(x0, y0)] = true;
  while (!q.empty()) {
    pair<int, int> x;
    x = q.front();
    if (x == pair<int, int>(x1, y1)) return dis[pair<int, int>(x1, y1)];
    q.pop();
    for (int i = 0; i < 8; i++) {
      if (canplace(x.first + row[i], x.second + col[i])) {
        q.push(pair<int, int>(x.first + row[i], x.second + col[i]));
        vis[pair<int, int>(x.first + row[i], x.second + col[i])] = true;
        dis[pair<int, int>(x.first + row[i], x.second + col[i])] =
            dis[pair<int, int>(x.first, x.second)] + 1;
      }
    }
  }
  return -1;
}
int main() {
  int x0, y0, x1, y1;
  cin >> x0 >> y0 >> x1 >> y1;
  int n;
  cin >> n;
  pair<int, int> p;
  int a, b, c;
  for (int i = 0; i < n; i++) {
    cin >> a >> b >> c;
    for (int j = b; j <= c; j++) {
      mp[pair<int, int>(a, j)] = 1;
    }
  }
  cout << bfs(x0, y0, x1, y1) << endl;
  return 0;
}
