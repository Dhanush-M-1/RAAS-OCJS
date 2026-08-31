#include <bits/stdc++.h>
using namespace std;
int main() {
  int n = 0;
  int x0, y0, x1, y1;
  cin >> x0 >> y0 >> x1 >> y1;
  int m;
  cin >> m;
  map<pair<int, int>, bool> mass;
  for (int i = 0; i < m; i++) {
    int r, a, b;
    scanf("%d%d%d", &r, &a, &b);
    for (int j = a; j <= b; j++) {
      mass[make_pair(r, j)] = true;
    }
  }
  map<pair<int, int>, bool> flag;
  queue<pair<int, int> > q;
  map<pair<int, int>, int> dist;
  dist[make_pair(x0, y0)] = 1;
  q.push(make_pair(x0, y0));
  flag[make_pair(x0, y0)] = true;
  while (!q.empty()) {
    int x = q.front().first;
    int y = q.front().second;
    bool f = false;
    q.pop();
    if (mass[make_pair(x - 1, y - 1)]) {
      if (!flag[make_pair(x - 1, y - 1)]) {
        flag[make_pair(x - 1, y - 1)] = true;
        q.push(make_pair(x - 1, y - 1));
        dist[make_pair(x - 1, y - 1)] = dist[make_pair(x, y)] + 1;
      }
    }
    if (mass[make_pair(x, y - 1)]) {
      if (!flag[make_pair(x, y - 1)]) {
        flag[make_pair(x, y - 1)] = true;
        q.push(make_pair(x, y - 1));
        dist[make_pair(x, y - 1)] = dist[make_pair(x, y)] + 1;
      }
    }
    if (mass[make_pair(x + 1, y - 1)]) {
      if (!flag[make_pair(x + 1, y - 1)]) {
        flag[make_pair(x + 1, y - 1)] = true;
        q.push(make_pair(x + 1, y - 1));
        dist[make_pair(x + 1, y - 1)] = dist[make_pair(x, y)] + 1;
      }
    }
    if (mass[make_pair(x - 1, y)]) {
      if (!flag[make_pair(x - 1, y)]) {
        flag[make_pair(x - 1, y)] = true;
        q.push(make_pair(x - 1, y));
        dist[make_pair(x - 1, y)] = dist[make_pair(x, y)] + 1;
      }
    }
    if (mass[make_pair(x + 1, y)]) {
      if (!flag[make_pair(x + 1, y)]) {
        flag[make_pair(x + 1, y)] = true;
        q.push(make_pair(x + 1, y));
        dist[make_pair(x + 1, y)] = dist[make_pair(x, y)] + 1;
      }
    }
    if (mass[make_pair(x - 1, y + 1)]) {
      if (!flag[make_pair(x - 1, y + 1)]) {
        flag[make_pair(x - 1, y + 1)] = true;
        q.push(make_pair(x - 1, y + 1));
        dist[make_pair(x - 1, y + 1)] = dist[make_pair(x, y)] + 1;
      }
    }
    if (mass[make_pair(x, y + 1)]) {
      if (!flag[make_pair(x, y + 1)]) {
        flag[make_pair(x, y + 1)] = true;
        q.push(make_pair(x, y + 1));
        dist[make_pair(x, y + 1)] = dist[make_pair(x, y)] + 1;
      }
    }
    if (mass[make_pair(x + 1, y + 1)]) {
      if (!flag[make_pair(x + 1, y + 1)]) {
        flag[make_pair(x + 1, y + 1)] = true;
        q.push(make_pair(x + 1, y + 1));
        dist[make_pair(x + 1, y + 1)] = dist[make_pair(x, y)] + 1;
      }
    }
  }
  int ans = dist[make_pair(x1, y1)];
  if (ans) {
    cout << ans - 1;
  } else {
    cout << -1;
  }
}
