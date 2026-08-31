#include <bits/stdc++.h>
using namespace std;
const int N = 1e9;
const int M = 1e9;
int ix, iy, fx, fy;
map<pair<int, int>, int> pres;
map<pair<int, int>, int> dist;
map<pair<int, int>, bool> vis;
int dx[] = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
int dy[] = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
bool check(int x, int y) {
  if (x >= 1 && x <= 1e9 && y >= 1 && y <= 1e9) {
    if (pres[make_pair(x, y)]) return true;
    return false;
  }
  return false;
}
void bfs(int x, int y) {
  queue<pair<int, int> > q;
  pair<int, int> tmp;
  q.push(make_pair(x, y));
  while (q.size() > 0) {
    tmp = q.front();
    q.pop();
    for (int i = 0; i < 9; ++i) {
      int x1 = tmp.first + dx[i];
      int y1 = tmp.second + dy[i];
      if (check(x1, y1) && vis[make_pair(x1, y1)] == 0) {
        vis[make_pair(x1, y1)] = 1;
        dist[make_pair(x1, y1)] = dist[tmp] + 1;
        q.push(make_pair(x1, y1));
      }
    }
  }
}
int main() {
  cin >> ix >> iy >> fx >> fy;
  int Q;
  cin >> Q;
  int x, y, z;
  for (int q = 1; q <= Q; ++q) {
    scanf("%d%d%d", &x, &y, &z);
    for (int i = y; i <= z; ++i) {
      pres[make_pair(x, i)] = 1;
    }
  }
  dist[make_pair(ix, iy)] = 0;
  dist[make_pair(fx, fy)] = 1e9;
  vis[make_pair(ix, iy)] = 1;
  bfs(ix, iy);
  int res = dist[make_pair(fx, fy)];
  if (res >= 1e9) res = -1;
  cout << res << endl;
  return 0;
}
