#include <bits/stdc++.h>
using namespace std;
int movx[] = {0, -1, -1, -1, 0, 1, 1, 1};
int movy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
int main(void) {
  int x0, y0, x1, y1;
  cin >> x0 >> y0 >> x1 >> y1;
  int n;
  cin >> n;
  map<pair<int, int>, bool> available;
  for (int i = 0; i < n; i++) {
    int r, a, b;
    cin >> r >> a >> b;
    for (int j = a; j <= b; j++) {
      available[{r, j}] = true;
    }
  }
  map<pair<int, int>, int> dis;
  for (auto i : available) {
    dis[{i.first.first, i.first.second}] = -1;
  }
  queue<pair<int, int>> q;
  q.push({x0, y0});
  dis[{x0, y0}] = 0;
  dis[{x1, y1}] = -1;
  while (!q.empty()) {
    pair<int, int> x = q.front();
    q.pop();
    if (x.first == x1 && x.second == y1) {
      break;
    }
    for (int i = 0; i < 8; i++) {
      int nx = x.first + movx[i];
      int ny = x.second + movy[i];
      if (available[{nx, ny}] == true) {
        dis[{nx, ny}] = 1 + dis[x];
        available[{nx, ny}] = false;
        q.push({nx, ny});
      }
    }
  }
  cout << dis[{x1, y1}];
  return 0;
}
